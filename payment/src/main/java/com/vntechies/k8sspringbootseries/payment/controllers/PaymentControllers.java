package com.vntechies.k8sspringbootseries.payment.controllers;

import com.vntechies.k8sspringbootseries.payment.dto.GetAllTransByStudentIdResp;
import com.vntechies.k8sspringbootseries.payment.dto.PayBillRequest;
import com.vntechies.k8sspringbootseries.payment.dto.PayBillResp;
import com.vntechies.k8sspringbootseries.payment.entities.Bill;
import com.vntechies.k8sspringbootseries.payment.entities.Transactions;
import com.vntechies.k8sspringbootseries.payment.services.IBillService;
import com.vntechies.k8sspringbootseries.payment.services.IPaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/payment")
public class PaymentControllers {

    private final IBillService iBillService;
    private final IPaymentService iPaymentService;

    public PaymentControllers(IBillService iBillService, IPaymentService iPaymentService) {
        this.iBillService = iBillService;
        this.iPaymentService = iPaymentService;
    }

    @PostMapping(value = "/v1/payBill")
    public ResponseEntity<PayBillResp> payBill(@RequestBody PayBillRequest request) {
        return new ResponseEntity<>(iPaymentService.payBill(request), HttpStatus.OK);
    }

    @GetMapping(value = "/v1/getBillBy")
    public ResponseEntity<Bill> getBillBy(@RequestParam(name = "billId") String billId) {
        return new ResponseEntity<>(iBillService.getBillBy(UUID.fromString(billId)), HttpStatus.OK);
    }

    @GetMapping(value = "/v1/getAllBill")
    public ResponseEntity<List<Bill>> getAllBill() {
        return new ResponseEntity<>(iBillService.getAllBill(), HttpStatus.OK);
    }

    @GetMapping(value = "/v1/getAllTransBy")
    public ResponseEntity<GetAllTransByStudentIdResp> getAllTransByStudentId(@RequestParam(name = "studentId") String studentId) {
        return new ResponseEntity<>(new GetAllTransByStudentIdResp(iPaymentService.getAllTransByStudentId(studentId)), HttpStatus.OK);
    }
}
