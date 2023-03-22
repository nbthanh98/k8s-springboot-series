package com.vntechies.k8sspringbootseries.students.clients.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
public class PayBillRequest {
    private UUID billId;
    private UUID studentId;
    private BigDecimal amount;
    private String fromAccountNo;
    private String toAccountNo;
    private String transDesc;
}
