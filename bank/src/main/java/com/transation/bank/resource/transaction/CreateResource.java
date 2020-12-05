package com.transation.bank.resource.transaction;

import java.util.Map;

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
import com.transation.bank.entity.dto.TransactionRequest;
import com.transation.bank.service.TransactionService;
import com.transation.bank.utils.HttpResponse;

@RestController
@CrossOrigin
@RequestMapping("/transacao")
public class CreateResource {
	
	@Autowired
	TransactionService transactionService;
	
	
	@PostMapping()
	public ResponseEntity<Map<Object, Object>> create(@Valid @RequestBody TransactionRequest transactionRequest) {
	
		try {
			Transaction transaction = new Transaction(transactionRequest.getValor(), transactionRequest.getDataHora());
			
			Transaction service = transactionService.create(transaction);
			
			return HttpResponse.success(HttpStatus.CREATED, "created successful", service);
			
		} catch (Exception e) {
			return HttpResponse.error(HttpStatus.INTERNAL_SERVER_ERROR, "internal server error", e.getMessage());
		} 
	}
}
