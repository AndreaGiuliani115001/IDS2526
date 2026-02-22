package it.unicam.cs.hackhub.core.controller;

import it.unicam.cs.hackhub.common.ExceptionHandler;
import it.unicam.cs.hackhub.common.ServiceException;
import it.unicam.cs.hackhub.core.service.SubmissionService;
import it.unicam.cs.hackhub.model.dto.SubmissionInput;
import it.unicam.cs.hackhub.model.dto.SubmissionOutput;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/submissions")
public class SubmissionController {

    private final SubmissionService submissionService;

    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    @PostMapping("/team/{teamId}/hackathon/{hackathonId}")
    public SubmissionOutput submitToHackathon(@PathVariable String teamId, @PathVariable String hackathonId, @RequestBody SubmissionInput input) {
        try {
            return submissionService.submitToHackathon(teamId, hackathonId, input);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    @GetMapping("/{id}")
    public SubmissionOutput getById(@PathVariable String id) {
        try {
            return submissionService.getById(id);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    @GetMapping
    public List<SubmissionOutput> getAll() {
        try {
            return submissionService.getAll();
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    @PutMapping("/{id}")
    public SubmissionOutput update(@PathVariable String id, @RequestBody SubmissionInput input) {
        try {
            return submissionService.update(id, input);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        try {
            submissionService.delete(id);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
        }
    }
}
