package com.vntechies.k8sspringbootseries.payment.entities;

import com.vntechies.k8sspringbootseries.payment.enums.TransStatus;
import com.vntechies.k8sspringbootseries.payment.enums.TransType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transactions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "trans_type")
    @Enumerated(EnumType.STRING)
    private TransType transType;

    @Column(name = "trans_status")
    @Enumerated(EnumType.STRING)
    private TransStatus transStatus;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "from_account_no")
    private String fromAccountNo;

    @Column(name = "to_account_no")
    private String toAccountNo;

    @Column(name = "trans_desc")
    private String transDesc;

    @Column(name = "trans_date")
    private LocalDateTime transDate;
}
