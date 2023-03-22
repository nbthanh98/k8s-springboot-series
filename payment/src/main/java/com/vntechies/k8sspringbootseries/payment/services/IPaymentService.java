package com.vntechies.k8sspringbootseries.payment.services;

import com.vntechies.k8sspringbootseries.payment.dto.PayBillRequest;
import com.vntechies.k8sspringbootseries.payment.dto.PayBillResp;
import com.vntechies.k8sspringbootseries.payment.entities.Transactions;

import java.util.List;

public interface IPaymentService {

    PayBillResp payBill(PayBillRequest request);

    List<Transactions> getAllTransByStudentId(String studentId);
}
