package com.vntechies.k8sspringbootseries.students.clients.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class TransactionsDTO {
    private UUID id;
    private UUID studentId;
    private String transType;
    private String transStatus;
    private BigDecimal amount;
    private String fromAccountNo;
    private String toAccountNo;
    private String transDesc;
    private LocalDateTime transDate;
}
