package com.vntechies.k8sspringbootseries.payment.entities;

import com.vntechies.k8sspringbootseries.payment.enums.BillStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
    private UUID id;
    private String name;
    private BigDecimal amount;
    private BillStatus billStatus;
}
