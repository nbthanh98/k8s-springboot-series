package com.vntechies.k8sspringbootseries.students.clients.dto;

import lombok.Data;

import java.util.List;

@Data
public class GetAllBillResp {
    private List<BillDTO> bills;
}
