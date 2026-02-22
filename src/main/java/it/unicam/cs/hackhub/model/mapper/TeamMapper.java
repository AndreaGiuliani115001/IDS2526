package it.unicam.cs.hackhub.model.mapper;

import it.unicam.cs.hackhub.common.ModelMapper;
import it.unicam.cs.hackhub.model.dto.TeamInput;
import it.unicam.cs.hackhub.model.dto.TeamOutput;
import it.unicam.cs.hackhub.model.entity.Team;
import it.unicam.cs.hackhub.model.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeamMapper implements ModelMapper<Team, TeamInput, TeamOutput> {

    @Override
    public Team toEntity(TeamInput dto) {
        throw new UnsupportedOperationException("Use toEntity(TeamInput, String id, List<User> members) for Team");
    }

    /**
     * Creates a Team entity; members must be resolved by the service.
     */
    public Team toEntity(TeamInput dto, String id, List<User> members) {
        Team team = new Team(dto.getName());
        team.setId(id);
        if (members != null) {
            team.getMembers().addAll(members);
        }
        return team;
    }

    @Override
    public TeamOutput toOutDto(Team entity) {
        List<String> memberIds = entity.getMembers().stream().map(User::getId)
                .collect(java.util.stream.Collectors.toList());
        return new TeamOutput(entity.getName(), memberIds != null ? memberIds : new java.util.ArrayList<>());
    }

    @Override
    public void updateEntity(TeamInput dto, Team entity) {
        throw new UnsupportedOperationException("Use overload with resolved members to update team");
    }
}
