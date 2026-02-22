package it.unicam.cs.hackhub.model.mapper;

import it.unicam.cs.hackhub.common.ModelMapper;
import it.unicam.cs.hackhub.model.dto.SubmissionInput;
import it.unicam.cs.hackhub.model.dto.SubmissionOutput;
import it.unicam.cs.hackhub.model.entity.Attachment;
import it.unicam.cs.hackhub.model.entity.Hackathon;
import it.unicam.cs.hackhub.model.entity.Submission;
import it.unicam.cs.hackhub.model.entity.Team;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SubmissionMapper implements ModelMapper<Submission, SubmissionInput, SubmissionOutput> {

    @Override
    public Submission toEntity(SubmissionInput dto) {
        throw new UnsupportedOperationException(
                "Use toEntity(SubmissionInput, String id, Team team, Hackathon hackathon) for Submission");
    }

    /**
     * Creates a Submission entity; team and hackathon must be resolved by the
     * service.
     */
    public Submission toEntity(SubmissionInput dto, String id, Team team, Hackathon hackathon) {
        Submission s = new Submission(dto.getName(), dto.getDescription(), Instant.now(), team, hackathon);
        s.setId(id);
        if (dto.getAttachments() != null) {
            for (int i = 0; i < dto.getAttachments().size(); i++) {
                String url = dto.getAttachments().get(i);
                Attachment att = new Attachment("attachment", url);
                att.setId(id + "-att-" + i);
                s.getAttachments().add(att);
            }
        }
        return s;
    }

    @Override
    public SubmissionOutput toOutDto(Submission entity) {
        List<String> urls = entity.getAttachments().stream().map(Attachment::getUrl).collect(Collectors.toList());
        return new SubmissionOutput(
                entity.getName(),
                entity.getDescription(),
                entity.getDate(),
                urls != null ? urls : new ArrayList<>());
    }

    @Override
    public void updateEntity(SubmissionInput dto, Submission entity) {
        throw new UnsupportedOperationException("Submission is immutable for updates");
    }
}
