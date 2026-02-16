package it.unicam.cs.hackhub.core.service;

import it.unicam.cs.hackhub.common.ErrorCode;
import it.unicam.cs.hackhub.common.Service;
import it.unicam.cs.hackhub.common.ServiceException;
import it.unicam.cs.hackhub.model.dto.TeamInput;
import it.unicam.cs.hackhub.model.dto.TeamOutput;
import it.unicam.cs.hackhub.model.entity.Hackathon;
import it.unicam.cs.hackhub.model.entity.Team;
import it.unicam.cs.hackhub.model.entity.User;
import it.unicam.cs.hackhub.model.mapper.TeamMapper;
import it.unicam.cs.hackhub.core.repository.TeamRepository;
import it.unicam.cs.hackhub.core.repository.UserRepository;
import it.unicam.cs.hackhub.core.state.HackathonStateService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TeamService implements Service<Team, TeamInput, TeamOutput> {

    private final TeamRepository teamRepository;
    private final UserRepository userRepository;
    private final HackathonStateService stateService;
    private final HackathonService hackathonService;
    private final TeamMapper teamMapper;

    public TeamService(TeamRepository teamRepository, UserRepository userRepository,
                       HackathonStateService stateService, HackathonService hackathonService, TeamMapper teamMapper) {
        this.teamRepository = teamRepository;
        this.userRepository = userRepository;
        this.stateService = stateService;
        this.hackathonService = hackathonService;
        this.teamMapper = teamMapper;
    }

    @Override
    public TeamOutput create(TeamInput input) throws ServiceException {
        List<User> members = resolveUserIds(input.getMembers());
        String id = UUID.randomUUID().toString();
        Team entity = teamMapper.toEntity(input, id, members);
        teamRepository.save(entity);
        return teamMapper.toOutDto(entity);
    }

    /**
     * Registers a team to a hackathon. Uses state handler; only allowed in REGISTRATION state.
     */
    public TeamOutput registerToHackathon(String hackathonId, TeamInput input) throws ServiceException {
        Hackathon hackathon = hackathonService.getEntityById(hackathonId);
        List<User> members = resolveUserIds(input.getMembers());
        String id = UUID.randomUUID().toString();
        Team team = teamMapper.toEntity(input, id, members);
        stateService.getHandler(hackathon.getState()).registerTeam(hackathon, team);
        teamRepository.save(team);
        return teamMapper.toOutDto(team);
    }

    @Override
    public TeamOutput getById(String id) throws ServiceException {
        Team entity = teamRepository.findById(id).orElseThrow(() -> new ServiceException(ErrorCode.NOT_FOUND, "Team not found: " + id));
        return teamMapper.toOutDto(entity);
    }

    @Override
    public List<TeamOutput> getAll() throws ServiceException {
        return teamRepository.findAll().stream().map(teamMapper::toOutDto).collect(Collectors.toList());
    }

    @Override
    public TeamOutput update(String id, TeamInput input) throws ServiceException {
        Team existing = teamRepository.findById(id).orElseThrow(() -> new ServiceException(ErrorCode.NOT_FOUND, "Team not found: " + id));
        teamMapper.updateEntity(input, existing);
        teamRepository.update(id, existing);
        return teamMapper.toOutDto(existing);
    }

    @Override
    public void delete(String id) throws ServiceException {
        teamRepository.delete(id);
    }

    public Team getEntityById(String id) throws ServiceException {
        return teamRepository.findById(id).orElseThrow(() -> new ServiceException(ErrorCode.NOT_FOUND, "Team not found: " + id));
    }

    private List<User> resolveUserIds(List<String> ids) throws ServiceException {
        if (ids == null || ids.isEmpty()) return java.util.Collections.emptyList();
        return ids.stream()
                .map(userId -> userRepository.findById(userId).orElseThrow(() -> new ServiceException(ErrorCode.NOT_FOUND, "User not found: " + userId)))
                .collect(Collectors.toList());
    }
}
