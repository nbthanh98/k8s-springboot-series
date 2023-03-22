package com.vntechies.k8sspringbootseries.payment.dto;

import com.vntechies.k8sspringbootseries.payment.enums.TransType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
public class PayBillRequest {
    private UUID billId;
    private String studentId;
    private TransType transType;
    private BigDecimal amount;
    private String fromAccountNo;
    private String toAccountNo;
    private String transDesc;
}
