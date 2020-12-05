package com.transation.bank.resource.transaction;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transation.bank.entity.Transaction;
import com.transation.bank.service.TransactionService;
import com.transation.bank.utils.HttpResponse;

@RestController
@CrossOrigin
@RequestMapping("/transacao")
public class FindAllResource {
	
	@Autowired
	TransactionService transactionService;
	
	@GetMapping()
	public ResponseEntity<Map<Object, Object>> findAll() {
	
		try {
			
			List<Transaction> service = transactionService.findAll();
			
			return HttpResponse.success(HttpStatus.OK, "request successful", service);
			
		} catch (Exception e) {
			return HttpResponse.error(HttpStatus.INTERNAL_SERVER_ERROR, "internal server error", e.getMessage());
		} 

	}
	

}
