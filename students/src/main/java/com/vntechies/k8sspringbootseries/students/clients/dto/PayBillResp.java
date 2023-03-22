package com.vntechies.k8sspringbootseries.students.clients.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayBillResp {
    private UUID transId;
    private UUID billId;
    private String transType;
    private String transStatus;
    private BigDecimal amount;
    private String fromAccountNo;
    private String toAccountNo;
    private String transDesc;
}
