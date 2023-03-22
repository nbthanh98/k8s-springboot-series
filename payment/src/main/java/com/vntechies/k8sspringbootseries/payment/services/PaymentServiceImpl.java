package com.vntechies.k8sspringbootseries.payment.services;

import com.vntechies.k8sspringbootseries.payment.dto.PayBillRequest;
import com.vntechies.k8sspringbootseries.payment.dto.PayBillResp;
import com.vntechies.k8sspringbootseries.payment.entities.Bill;
import com.vntechies.k8sspringbootseries.payment.entities.Transactions;
import com.vntechies.k8sspringbootseries.payment.enums.BillStatus;
import com.vntechies.k8sspringbootseries.payment.enums.TransStatus;
import com.vntechies.k8sspringbootseries.payment.enums.TransType;
import com.vntechies.k8sspringbootseries.payment.exceptions.PaymentException;
import com.vntechies.k8sspringbootseries.payment.repositories.ITransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements IPaymentService {

    private final IBillService iBillService;
    private final ITransactionRepository iTransactionRepository;

    @Override
    public PayBillResp payBill(PayBillRequest request) {
        Bill bill = iBillService.getBillBy(request.getBillId());
        if (BillStatus.PAYED.equals(bill.getBillStatus())) {
            throw new PaymentException("Bill payed!");
        }
        boolean isAmountEnoughToPayBill = request.getAmount().compareTo(bill.getAmount()) >= 0;
        if (!isAmountEnoughToPayBill) {
            throw new PaymentException("Amount not enough to pay bill!");
        }
        iBillService.updateBillStatus(request.getBillId());
        Transactions transactions = iTransactionRepository.save(buildFrom(request, bill));
        return PayBillResp.buildFrom(transactions, bill, request);
    }

    private Transactions buildFrom(PayBillRequest request, Bill bill) {
        Transactions transactions = new Transactions();
        transactions.setId(UUID.randomUUID());
        transactions.setStudentId(request.getStudentId());
        transactions.setAmount(request.getAmount());
        transactions.setTransDesc(bill.getName());
        transactions.setFromAccountNo(request.getFromAccountNo());
        transactions.setToAccountNo(request.getToAccountNo());
        transactions.setTransType(TransType.ONLINE);
        transactions.setTransStatus(TransStatus.DONE);
        transactions.setTransDate(LocalDateTime.now());
        return transactions;
    }

    @Override
    public List<Transactions> getAllTransByStudentId(String studentId) {
        return iTransactionRepository.findAllTransByStudentId(studentId);
    }
}
