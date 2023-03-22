package com.vntechies.k8sspringbootseries.payment.dto;

import com.vntechies.k8sspringbootseries.payment.entities.Transactions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTransByStudentIdResp {
    private List<Transactions> data;
}
