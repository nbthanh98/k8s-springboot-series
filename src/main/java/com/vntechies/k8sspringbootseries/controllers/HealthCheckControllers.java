package com.vntechies.k8sspringbootseries.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/health-check")
public class HealthCheckControllers {

    @GetMapping(value = "/ping")
    public String ping() {
        String message = String.format("%s - Service healthy!", System.currentTimeMillis());
        System.out.println(message);
        return message;
    }
}
