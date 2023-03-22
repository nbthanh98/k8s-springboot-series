package com.vntechies.k8sspringbootseries.payment.repositories;

import com.vntechies.k8sspringbootseries.payment.entities.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ITransactionRepository extends JpaRepository<Transactions, UUID> {

    @Query(value = "SELECT * FROM transactions t WHERE t.student_id = :studentId", nativeQuery = true)
    List<Transactions> findAllTransByStudentId(@Param(value = "studentId") String studentId);
}
