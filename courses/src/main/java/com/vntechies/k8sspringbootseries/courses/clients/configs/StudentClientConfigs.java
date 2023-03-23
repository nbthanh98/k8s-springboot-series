package com.vntechies.k8sspringbootseries.courses.clients.configs;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class StudentClientConfigs {

    @Value("${clients.services.students.uri}")
    private String uri;
}
