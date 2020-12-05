package com.transation.bank.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transation.bank.entity.Transaction;
import com.transation.bank.entity.dto.Statistic;
import com.transation.bank.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;
	
	public Transaction create (Transaction transaction) {
		return transactionRepository.save(transaction);
	}
	
	public List<Transaction> findAll() {
		return transactionRepository.findAll();
	}
	
	public void deleteAll() {
		transactionRepository.deleteAll();
	}

	public Statistic findBetweenCreateAt(int seconds) {
		
		Date initDate = new Date();
		initDate.setTime(initDate.getTime() - (seconds * 1000));
		
		Date finalDate = new Date();
		
		return transactionRepository.findStatisticBetweenCreatedAt(initDate, finalDate);
	
	}
}
