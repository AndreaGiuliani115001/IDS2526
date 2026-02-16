package it.unicam.cs.hackhub.core.controller;

import it.unicam.cs.hackhub.common.ExceptionHandler;
import it.unicam.cs.hackhub.common.ServiceException;
import it.unicam.cs.hackhub.model.dto.EvaluationInput;
import it.unicam.cs.hackhub.model.dto.EvaluationOutput;
import it.unicam.cs.hackhub.core.service.EvaluationService;

import java.util.List;

public class EvaluationController {

    private final EvaluationService evaluationService;

    public EvaluationController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    public EvaluationOutput create(EvaluationInput input) {
        try {
            return evaluationService.create(input);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    public EvaluationOutput getById(String id) {
        try {
            return evaluationService.getById(id);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    public List<EvaluationOutput> getAll() {
        try {
            return evaluationService.getAll();
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    public EvaluationOutput update(String id, EvaluationInput input) {
        try {
            return evaluationService.update(id, input);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    public void delete(String id) {
        try {
            evaluationService.delete(id);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
        }
    }
}
