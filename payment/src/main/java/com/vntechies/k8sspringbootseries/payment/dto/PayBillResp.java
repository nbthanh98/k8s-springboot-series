package com.vntechies.k8sspringbootseries.payment.dto;

import com.vntechies.k8sspringbootseries.payment.entities.Bill;
import com.vntechies.k8sspringbootseries.payment.entities.Transactions;
import com.vntechies.k8sspringbootseries.payment.enums.TransStatus;
import com.vntechies.k8sspringbootseries.payment.enums.TransType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PayBillResp {

    private UUID transId;
    private UUID billId;
    private TransType transType;
    private TransStatus transStatus;
    private BigDecimal amount;
    private String fromAccountNo;
    private String toAccountNo;
    private String transDesc;

    public static PayBillResp buildFrom(Transactions transactions, Bill bill, PayBillRequest payBillRequest) {
        PayBillResp payBillResp = new PayBillResp();
        payBillResp.setTransId(transactions.getId());
        payBillResp.setBillId(bill.getId());
        payBillResp.setTransType(transactions.getTransType());
        payBillResp.setTransStatus(transactions.getTransStatus());
        payBillResp.setAmount(transactions.getAmount());
        payBillResp.setAmount(transactions.getAmount());
        payBillResp.setTransDesc(transactions.getTransDesc());
        return payBillResp;
    }
}
