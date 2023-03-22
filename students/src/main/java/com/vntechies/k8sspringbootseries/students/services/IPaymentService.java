package com.vntechies.k8sspringbootseries.students.services;

import com.vntechies.k8sspringbootseries.students.clients.dto.PayBillRequest;
import com.vntechies.k8sspringbootseries.students.clients.dto.PayBillResp;
import com.vntechies.k8sspringbootseries.students.clients.dto.TransactionsDTO;

import java.util.List;

public interface IPaymentService {

    PayBillResp payBill(PayBillRequest request);

    List<TransactionsDTO> getAllTransByStudentId(String studentId);
}
