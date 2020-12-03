package com.transation.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transation.bank.entity.Transaction;
import com.transation.bank.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;
	
	public Transaction create (Transaction transaction) {
		return transactionRepository.save(transaction);
	}

}
