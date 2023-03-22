package com.vntechies.k8sspringbootseries.students.clients;

import com.vntechies.k8sspringbootseries.students.clients.configs.PaymentConfigs;
import com.vntechies.k8sspringbootseries.students.clients.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentClientImpl implements IPaymentClient {

    private final PaymentConfigs paymentConfigs;
    private static final RestTemplate restTemplate = new RestTemplate();

    public BillDTO getBillById(String billId) {
        return restTemplate.getForObject(paymentConfigs.getUri() + "/api/payment/v1/getBillBy?billId=" + billId, BillDTO.class);
    }

    @Override
    public List<BillDTO> getAllBill() {
        GetAllBillResp paymentResp = restTemplate.getForObject(paymentConfigs.getUri() + "/api/payment/v1/getAllBill", GetAllBillResp.class);
        return paymentResp.getBills();
    }

    @Override
    public PayBillResp payBill(PayBillRequest request) {
        return restTemplate.postForObject(paymentConfigs.getUri() + "/api/payment/v1/payBill", request, PayBillResp.class);
    }

    @Override
    public List<TransactionsDTO> getAllTransByStudentId(String studentId) {
        String fullUrl = paymentConfigs.getUri() + "/api/payment/v1/getAllTransBy?studentId=" + studentId;
        GetAllTransByStudentIdResp response = restTemplate.getForObject(fullUrl, GetAllTransByStudentIdResp.class);
        return response.getData();
    }
}
