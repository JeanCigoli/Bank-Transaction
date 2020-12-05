package com.transation.bank.resource.statistic;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.transation.bank.entity.dto.Statistic;
import com.transation.bank.service.TransactionService;
import com.transation.bank.utils.HttpResponse;

@RestController
@CrossOrigin
@RequestMapping("/estatistica")
public class FindStatisticResource {
	
	@Autowired
	TransactionService transactionService;
	
	
	@GetMapping()
	public ResponseEntity<Map<Object, Object>> find(@RequestParam int seconds) {
	
		try {
			
			Statistic statistic = transactionService.findBetweenCreateAt(seconds);
			
			return HttpResponse.success(HttpStatus.OK, "request successful", statistic);
			
		} catch (Exception e) {
			return HttpResponse.error(HttpStatus.INTERNAL_SERVER_ERROR, "internal server error", e.getMessage());
		} 
	}

}
