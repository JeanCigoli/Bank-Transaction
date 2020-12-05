package com.transation.bank.resource.transaction;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transation.bank.service.TransactionService;
import com.transation.bank.utils.HttpResponse;

@RestController
@CrossOrigin
@RequestMapping("/transacao")
public class DeleteResource {
	
	@Autowired
	TransactionService transactionService;
	
	@DeleteMapping
	public ResponseEntity<Map<Object, Object>> deleteAll() {
		
		try {
			
			transactionService.deleteAll();
			
			return HttpResponse.success(HttpStatus.OK, "deleted successful", null);
			
		} catch (Exception e) {
			return HttpResponse.error(HttpStatus.INTERNAL_SERVER_ERROR, "internal server error", e.getMessage());
		} 

	}

}
