package com.vntechies.k8sspringbootseries.students.controllers;

import com.vntechies.k8sspringbootseries.students.clients.dto.PayBillRequest;
import com.vntechies.k8sspringbootseries.students.clients.dto.PayBillResp;
import com.vntechies.k8sspringbootseries.students.clients.dto.TransactionsDTO;
import com.vntechies.k8sspringbootseries.students.services.IPaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/payment")
public class PaymentControllers {

    private final IPaymentService iPaymentService;

    public PaymentControllers(IPaymentService iPaymentService) {
        this.iPaymentService = iPaymentService;
    }

    @PostMapping(value = "/payBill")
    public ResponseEntity<PayBillResp> payBill(@RequestBody PayBillRequest request) {
        return new ResponseEntity<>(iPaymentService.payBill(request), HttpStatus.OK);
    }

    @GetMapping(value = "/getAllTransBy")
    public ResponseEntity<List<TransactionsDTO>> getAllTransByStudentId(@RequestParam(value = "studentId") String studentId) {
        return new ResponseEntity<>(iPaymentService.getAllTransByStudentId(studentId), HttpStatus.OK);
    }
}
