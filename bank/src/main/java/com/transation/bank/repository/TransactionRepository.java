package com.transation.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transation.bank.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
