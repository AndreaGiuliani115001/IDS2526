package it.unicam.cs.hackhub.core.controller;

import it.unicam.cs.hackhub.common.ExceptionHandler;
import it.unicam.cs.hackhub.common.ServiceException;
import it.unicam.cs.hackhub.core.service.UserService;
import it.unicam.cs.hackhub.model.dto.LoginRequest;
import it.unicam.cs.hackhub.model.dto.UserInput;
import it.unicam.cs.hackhub.model.dto.UserOutput;

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
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserOutput register(@RequestBody UserInput input) {
        try {
            return userService.register(input);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    @PostMapping("/login")
    public UserOutput login(@RequestBody LoginRequest loginRequest) {
        try {
            return userService.login(loginRequest.getUsername(), loginRequest.getPassword());
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    @GetMapping("/{id}")
    public UserOutput getById(@PathVariable String id) {
        try {
            return userService.getById(id);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    @GetMapping
    public List<UserOutput> getAll() {
        try {
            return userService.getAll();
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    @PutMapping("/{id}")
    public UserOutput update(@PathVariable String id, @RequestBody UserInput input) {
        try {
            return userService.update(id, input);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        try {
            userService.delete(id);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
        }
    }
}
