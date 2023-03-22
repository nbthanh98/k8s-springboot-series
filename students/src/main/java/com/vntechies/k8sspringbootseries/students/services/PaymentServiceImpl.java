package com.vntechies.k8sspringbootseries.students.services;

import com.vntechies.k8sspringbootseries.students.clients.IPaymentClient;
import com.vntechies.k8sspringbootseries.students.clients.dto.BillDTO;
import com.vntechies.k8sspringbootseries.students.clients.dto.PayBillRequest;
import com.vntechies.k8sspringbootseries.students.clients.dto.PayBillResp;
import com.vntechies.k8sspringbootseries.students.clients.dto.TransactionsDTO;
import com.vntechies.k8sspringbootseries.students.exceptions.CustomException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements IPaymentService {

    private final IPaymentClient iPaymentClient;

    @Override
    public PayBillResp payBill(PayBillRequest request) {
        try {
            BillDTO billDTO = iPaymentClient.getBillById(request.getBillId().toString());
            if (Objects.isNull(billDTO)) {
                throw new CustomException("Bill not found!");
            }
            return iPaymentClient.payBill(request);
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }

    @Override
    public List<TransactionsDTO> getAllTransByStudentId(String studentId) {
        return iPaymentClient.getAllTransByStudentId(studentId);
    }
}
