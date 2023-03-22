package com.vntechies.k8sspringbootseries.students.clients.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class BillDTO {
    private UUID id;
    private String name;
    private BigDecimal amount;
    private String billStatus;
}
