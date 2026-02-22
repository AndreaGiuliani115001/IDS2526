package it.unicam.cs.hackhub.model.mapper;

import it.unicam.cs.hackhub.common.HackathonState;
import it.unicam.cs.hackhub.common.ModelMapper;
import it.unicam.cs.hackhub.model.dto.HackathonInput;
import it.unicam.cs.hackhub.model.dto.HackathonOutput;
import it.unicam.cs.hackhub.model.entity.Hackathon;
import it.unicam.cs.hackhub.model.entity.User;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class HackathonMapper implements ModelMapper<Hackathon, HackathonInput, HackathonOutput> {

    @Override
    public Hackathon toEntity(HackathonInput dto) {
        throw new UnsupportedOperationException(
                "Use toEntity(HackathonInput, String id, User organizer, User judge, List<User> mentors)");
    }

    /**
     * Creates a Hackathon entity; organizer, judge and mentors must be resolved by
     * the service.
     */
    public Hackathon toEntity(HackathonInput dto, String id, User organizer, User judge, List<User> mentors) {
        Hackathon h = new Hackathon(dto.getName(), dto.getDescription(), dto.getRules(),
                dto.getRegistrationDeadline(), dto.getStartDate(), dto.getEndDate(), dto.getLocation(),
                dto.getPrize(), dto.getMaxTeamSize(), HackathonState.REGISTRATION,
                organizer, judge);
        h.setId(id);
        if (mentors != null) {
            h.getMentors().addAll(mentors);
        }
        return h;
    }

    @Override
    public HackathonOutput toOutDto(Hackathon entity) {
        List<String> mentorIds = entity.getMentors().stream().map(User::getId).collect(Collectors.toList());
        List<String> submissionIds = entity.getSubmissions().stream().map(s -> s.getId()).collect(Collectors.toList());
        List<String> teamIds = entity.getTeams().stream().map(t -> t.getId()).collect(Collectors.toList());
        return new HackathonOutput(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getRules(),
                entity.getRegistrationDeadline(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getLocation(),
                entity.getPrize(),
                entity.getMaxTeamSize(),
                entity.getJudge() != null ? entity.getJudge().getId() : null,
                mentorIds != null ? mentorIds : new ArrayList<>(),
                submissionIds != null ? submissionIds : new ArrayList<>(),
                teamIds != null ? teamIds : new ArrayList<>());
    }

    @Override
    public void updateEntity(HackathonInput dto, Hackathon entity) {
        throw new UnsupportedOperationException("Hackathon is largely immutable; use state handlers for state changes");
    }
}
