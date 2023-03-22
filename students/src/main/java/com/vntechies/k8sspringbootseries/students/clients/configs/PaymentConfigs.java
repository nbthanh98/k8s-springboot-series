package com.vntechies.k8sspringbootseries.students.clients.configs;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class PaymentConfigs {

    @Value("${clients.payment.uri}")
    private String uri;
}
