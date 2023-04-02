package com.vntechies.k8sspringbootseries.students.controllers;

import com.vntechies.k8sspringbootseries.students.configs.AppConfigs;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/configs")
public class AppConfigsControllers {

    private final AppConfigs appConfigs;

    public AppConfigsControllers(AppConfigs appConfigs) {
        this.appConfigs = appConfigs;
    }

    @GetMapping(value = "/v1")
    public String getConfigs() {
        return appConfigs.toString();
    }
}
