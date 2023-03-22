package com.vntechies.k8sspringbootseries.payment.exceptions;

import lombok.Data;

@Data
public class PaymentException extends RuntimeException {

    private String msg;

    public PaymentException(String msg) {
        super(msg);
    }
}
