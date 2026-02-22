package it.unicam.cs.hackhub.core.controller;

import it.unicam.cs.hackhub.common.ExceptionHandler;
import it.unicam.cs.hackhub.common.ServiceException;
import it.unicam.cs.hackhub.core.service.HackathonService;
import it.unicam.cs.hackhub.model.dto.HackathonInput;
import it.unicam.cs.hackhub.model.dto.HackathonOutput;

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
@RequestMapping("/api/v1/hackathons")
public class HackathonController {

    private final HackathonService hackathonService;

    public HackathonController(HackathonService hackathonService) {
        this.hackathonService = hackathonService;
    }

    @PostMapping
    public HackathonOutput create(@RequestBody HackathonInput input) throws ServiceException {
        return hackathonService.create(input);
    }

    @GetMapping("/{id}")
    public HackathonOutput getById(@PathVariable String id) {
        try {
            return hackathonService.getById(id);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    @GetMapping
    public List<HackathonOutput> getAll() {
        try {
            return hackathonService.getAll();
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    @PutMapping("/{id}")
    public HackathonOutput update(@PathVariable String id, @RequestBody HackathonInput input) {
        try {
            return hackathonService.update(id, input);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        try {
            hackathonService.delete(id);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
        }
    }
}