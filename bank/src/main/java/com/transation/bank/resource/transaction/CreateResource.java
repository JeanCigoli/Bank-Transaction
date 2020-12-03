package com.transation.bank.resource.transaction;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transation.bank.entity.Transaction;
import com.transation.bank.service.TransactionService;

@RestController
@CrossOrigin
@RequestMapping("/transacao")
public class CreateResource {
	
	@Autowired
	TransactionService transactionService;
	
	@PostMapping()
	public ResponseEntity<Transaction> create(@Valid @RequestBody Transaction transaction) {
	
		try {
			
			Transaction service = transactionService.create(transaction);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(service);
			
		} catch (Exception e) {
			return null;
		} 
	}
}
