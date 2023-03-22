package com.vntechies.k8sspringbootseries.payment.services;

import com.vntechies.k8sspringbootseries.payment.entities.Bill;

import java.util.List;
import java.util.UUID;

public interface IBillService {

    Bill getBillBy(UUID billId);

    List<Bill> getAllBill();

    void updateBillStatus(UUID billId);
}
