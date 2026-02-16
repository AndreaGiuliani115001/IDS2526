package it.unicam.cs.hackhub.core.controller;

import it.unicam.cs.hackhub.common.ExceptionHandler;
import it.unicam.cs.hackhub.common.ServiceException;
import it.unicam.cs.hackhub.model.dto.HackathonInput;
import it.unicam.cs.hackhub.model.dto.HackathonOutput;
import it.unicam.cs.hackhub.core.service.HackathonService;

import java.util.List;

public class HackathonController {

    private final HackathonService hackathonService;

    public HackathonController(HackathonService hackathonService) {
        this.hackathonService = hackathonService;
    }

    public HackathonOutput create(HackathonInput input) {
        try {
            return hackathonService.create(input);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    public HackathonOutput getById(String id) {
        try {
            return hackathonService.getById(id);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    public List<HackathonOutput> getAll() {
        try {
            return hackathonService.getAll();
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    public HackathonOutput update(String id, HackathonInput input) {
        try {
            return hackathonService.update(id, input);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    public void delete(String id) {
        try {
            hackathonService.delete(id);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
        }
    }
}
