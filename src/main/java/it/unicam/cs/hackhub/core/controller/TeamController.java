package it.unicam.cs.hackhub.core.controller;

import it.unicam.cs.hackhub.common.ExceptionHandler;
import it.unicam.cs.hackhub.common.ServiceException;
import it.unicam.cs.hackhub.model.dto.TeamInput;
import it.unicam.cs.hackhub.model.dto.TeamOutput;
import it.unicam.cs.hackhub.core.service.TeamService;

import java.util.List;

public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    public TeamOutput create(TeamInput input) {
        try {
            return teamService.create(input);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    public TeamOutput registerToHackathon(String hackathonId, TeamInput input) {
        try {
            return teamService.registerToHackathon(hackathonId, input);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    public TeamOutput getById(String id) {
        try {
            return teamService.getById(id);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    public List<TeamOutput> getAll() {
        try {
            return teamService.getAll();
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    public TeamOutput update(String id, TeamInput input) {
        try {
            return teamService.update(id, input);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    public void delete(String id) {
        try {
            teamService.delete(id);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
        }
    }
}
