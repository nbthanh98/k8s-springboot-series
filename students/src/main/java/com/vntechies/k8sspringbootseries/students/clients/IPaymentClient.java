package com.vntechies.k8sspringbootseries.students.clients;

import com.vntechies.k8sspringbootseries.students.clients.dto.BillDTO;
import com.vntechies.k8sspringbootseries.students.clients.dto.PayBillRequest;
import com.vntechies.k8sspringbootseries.students.clients.dto.PayBillResp;
import com.vntechies.k8sspringbootseries.students.clients.dto.TransactionsDTO;

import java.util.List;

public interface IPaymentClient {

    PayBillResp payBill(PayBillRequest request);

    BillDTO getBillById(String billId);

    List<BillDTO> getAllBill();

    List<TransactionsDTO> getAllTransByStudentId(String studentId);
}
