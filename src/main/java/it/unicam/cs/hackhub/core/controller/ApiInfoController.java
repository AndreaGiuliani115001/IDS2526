package it.unicam.cs.hackhub.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class ApiInfoController {

    @GetMapping({"/", "/api/v1", "/api/v1/"})
    public List<?> info() {
        return Collections.emptyList();
    }
}
