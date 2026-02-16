package it.unicam.cs.hackhub.core.controller;

import it.unicam.cs.hackhub.common.ExceptionHandler;
import it.unicam.cs.hackhub.common.ServiceException;
import it.unicam.cs.hackhub.model.dto.SubmissionInput;
import it.unicam.cs.hackhub.model.dto.SubmissionOutput;
import it.unicam.cs.hackhub.core.service.SubmissionService;

import java.util.List;

public class SubmissionController {

    private final SubmissionService submissionService;

    public SubmissionController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

    public SubmissionOutput submitToHackathon(String teamId, String hackathonId, SubmissionInput input) {
        try {
            return submissionService.submitToHackathon(teamId, hackathonId, input);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    public SubmissionOutput getById(String id) {
        try {
            return submissionService.getById(id);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    public List<SubmissionOutput> getAll() {
        try {
            return submissionService.getAll();
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    public SubmissionOutput update(String id, SubmissionInput input) {
        try {
            return submissionService.update(id, input);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    public void delete(String id) {
        try {
            submissionService.delete(id);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
        }
    }
}
