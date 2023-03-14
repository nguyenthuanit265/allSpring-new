package com.learn.controller;

import com.learn.model.request.AuthRequest;
import com.learn.service.SimpleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class SimpleController {
    private final Logger LOGGER = LoggerFactory.getLogger(SimpleController.class);

    private final SimpleService simpleService;

    public SimpleController(
            SimpleService simpleService) {

        this.simpleService = simpleService;
    }

    @GetMapping("/test")
    public ResponseEntity<?> simpleController() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        return simpleService.simpleLogin(request);
    }
}
