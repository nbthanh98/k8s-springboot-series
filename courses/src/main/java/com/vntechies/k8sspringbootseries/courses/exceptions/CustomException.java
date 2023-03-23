package com.vntechies.k8sspringbootseries.courses.exceptions;

import lombok.Data;

@Data
public class CustomException extends RuntimeException {

    private String msg;

    public CustomException(String msg) {
        super(msg);
    }
}
