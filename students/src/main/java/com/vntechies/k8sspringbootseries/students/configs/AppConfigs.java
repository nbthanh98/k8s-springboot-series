package com.vntechies.k8sspringbootseries.students.configs;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class AppConfigs {

    @Value("${server.port}")
    private Integer SERVER_PORT;

    @Value("${spring.datasource.url}")
    private String MYSQL_URL;

    @Value("${spring.datasource.username}")
    private String MYSQL_USERNAME;

    @Value("${spring.datasource.password}")
    private String MYSQL_PASSWORD;

    @Override
    public String toString() {
        return "AppConfigs{" +
                "SERVER_PORT=" + SERVER_PORT +
                ", MYSQL_URL='" + MYSQL_URL + '\'' +
                ", MYSQL_USERNAME='" + MYSQL_USERNAME + '\'' +
                ", MYSQL_PASSWORD='" + MYSQL_PASSWORD + '\'' +
                '}';
    }
}
