package com.vntechies.k8sspringbootseries.students.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/api/test")
public class TestController {

    @RequestMapping(value = "/makeInfinityLoop")
    public void makeInfinityLoop() {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        while (true) {
            bigDecimal = bigDecimal.add(BigDecimal.ONE);
        }
    }
}
