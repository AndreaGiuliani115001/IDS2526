package it.unicam.cs.hackhub.core.service;

import it.unicam.cs.hackhub.common.ErrorCode;
import it.unicam.cs.hackhub.common.Service;
import it.unicam.cs.hackhub.common.ServiceException;
import it.unicam.cs.hackhub.model.dto.HackathonInput;
import it.unicam.cs.hackhub.model.dto.HackathonOutput;
import it.unicam.cs.hackhub.model.entity.Hackathon;
import it.unicam.cs.hackhub.model.entity.User;
import it.unicam.cs.hackhub.model.mapper.HackathonMapper;
import it.unicam.cs.hackhub.core.repository.HackathonRepository;
import it.unicam.cs.hackhub.core.repository.UserRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class HackathonService implements Service<Hackathon, HackathonInput, HackathonOutput> {

    private final HackathonRepository hackathonRepository;
    private final UserRepository userRepository;
    private final HackathonMapper hackathonMapper;

    public HackathonService(HackathonRepository hackathonRepository, UserRepository userRepository, HackathonMapper hackathonMapper) {
        this.hackathonRepository = hackathonRepository;
        this.userRepository = userRepository;
        this.hackathonMapper = hackathonMapper;
    }

    @Override
    public HackathonOutput create(HackathonInput input) throws ServiceException {
        User organizer = userRepository.findById(input.getJudge()).orElseThrow(() -> new ServiceException(ErrorCode.NOT_FOUND, "Organizer/judge not found"));
        User judge = organizer;
        List<User> mentors = resolveUserIds(input.getMentors());
        String id = UUID.randomUUID().toString();
        Hackathon entity = hackathonMapper.toEntity(input, id, organizer, judge, mentors);
        hackathonRepository.save(entity);
        return hackathonMapper.toOutDto(entity);
    }

    @Override
    public HackathonOutput getById(String id) throws ServiceException {
        Hackathon entity = hackathonRepository.findById(id).orElseThrow(() -> new ServiceException(ErrorCode.NOT_FOUND, "Hackathon not found: " + id));
        return hackathonMapper.toOutDto(entity);
    }

    @Override
    public List<HackathonOutput> getAll() throws ServiceException {
        return hackathonRepository.findAll().stream().map(hackathonMapper::toOutDto).collect(Collectors.toList());
    }

    @Override
    public HackathonOutput update(String id, HackathonInput input) throws ServiceException {
        Hackathon existing = hackathonRepository.findById(id).orElseThrow(() -> new ServiceException(ErrorCode.NOT_FOUND, "Hackathon not found: " + id));
        hackathonMapper.updateEntity(input, existing);
        hackathonRepository.update(id, existing);
        return hackathonMapper.toOutDto(existing);
    }

    @Override
    public void delete(String id) throws ServiceException {
        hackathonRepository.delete(id);
    }

    public Hackathon getEntityById(String id) throws ServiceException {
        return hackathonRepository.findById(id).orElseThrow(() -> new ServiceException(ErrorCode.NOT_FOUND, "Hackathon not found: " + id));
    }

    private List<User> resolveUserIds(List<String> ids) throws ServiceException {
        if (ids == null || ids.isEmpty()) return java.util.Collections.emptyList();
        return ids.stream()
                .map(userId -> userRepository.findById(userId).orElseThrow(() -> new ServiceException(ErrorCode.NOT_FOUND, "User not found: " + userId)))
                .collect(Collectors.toList());
    }
}
