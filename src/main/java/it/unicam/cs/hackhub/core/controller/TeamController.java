package it.unicam.cs.hackhub.core.controller;

import it.unicam.cs.hackhub.common.ExceptionHandler;
import it.unicam.cs.hackhub.common.ServiceException;
import it.unicam.cs.hackhub.core.service.TeamService;
import it.unicam.cs.hackhub.model.dto.TeamInput;
import it.unicam.cs.hackhub.model.dto.TeamOutput;

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
@RequestMapping("/api/v1/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public TeamOutput create(@RequestBody TeamInput input) {
        try {
            return teamService.create(input);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    @PostMapping("/hackathon/{hackathonId}/register")
    public TeamOutput registerToHackathon(@PathVariable String hackathonId, @RequestBody TeamInput input) {
        try {
            return teamService.registerToHackathon(hackathonId, input);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    @GetMapping("/{id}")
    public TeamOutput getById(@PathVariable String id) {
        try {
            return teamService.getById(id);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    @GetMapping
    public List<TeamOutput> getAll() {
        try {
            return teamService.getAll();
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    @PutMapping("/{id}")
    public TeamOutput update(@PathVariable String id, @RequestBody TeamInput input) {
        try {
            return teamService.update(id, input);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        try {
            teamService.delete(id);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
        }
    }
}
