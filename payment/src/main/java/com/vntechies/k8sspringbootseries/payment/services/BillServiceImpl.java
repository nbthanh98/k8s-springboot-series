package com.vntechies.k8sspringbootseries.payment.services;

import com.vntechies.k8sspringbootseries.payment.entities.Bill;
import com.vntechies.k8sspringbootseries.payment.enums.BillStatus;
import com.vntechies.k8sspringbootseries.payment.exceptions.PaymentException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class BillServiceImpl implements IBillService {

    private static final List<Bill> BILLS = List.of(
            Bill.builder()
                    .id(UUID.fromString("cd4f70d4-0dee-469c-9d5f-49a398b155a2"))
                    .name("THANH TOAN HOC PHI KY I")
                    .amount(BigDecimal.valueOf(5_000_000L))
                    .billStatus(BillStatus.PENDING).build(),
            Bill.builder()
                    .id(UUID.fromString("0cf6b569-f610-408a-a033-76e16ecbeffe"))
                    .name("THANH TOAN HOC PHI KY II")
                    .amount(BigDecimal.valueOf(10_000_000L))
                    .billStatus(BillStatus.PENDING).build()
    );


    @Override
    public Bill getBillBy(UUID billId) {
        for (Bill bill : BILLS) {
            if (billId.equals(bill.getId())) {
                return bill;
            }
        }
        throw new PaymentException("Bill not found!");
    }

    @Override
    public List<Bill> getAllBill() {
        return BILLS;
    }

    @Override
    public void updateBillStatus(UUID billId) {
        Bill bill = this.getBillBy(billId);
        bill.setBillStatus(BillStatus.PAYED);
    }
}
