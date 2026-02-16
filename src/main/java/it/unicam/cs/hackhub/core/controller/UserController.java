package it.unicam.cs.hackhub.core.controller;

import it.unicam.cs.hackhub.common.ExceptionHandler;
import it.unicam.cs.hackhub.common.ServiceException;
import it.unicam.cs.hackhub.model.dto.UserInput;
import it.unicam.cs.hackhub.model.dto.UserOutput;
import it.unicam.cs.hackhub.core.service.UserService;

import java.util.List;

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public UserOutput register(UserInput input) {
        try {
            return userService.register(input);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    public UserOutput login(String username, String password) {
        try {
            return userService.login(username, password);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    public UserOutput getById(String id) {
        try {
            return userService.getById(id);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    public List<UserOutput> getAll() {
        try {
            return userService.getAll();
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    public UserOutput update(String id, UserInput input) {
        try {
            return userService.update(id, input);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
            return null;
        }
    }

    public void delete(String id) {
        try {
            userService.delete(id);
        } catch (ServiceException e) {
            ExceptionHandler.handle(e);
        }
    }
}
