package com.transation.bank.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HttpResponse {
	
	public static ResponseEntity<Map<Object, Object>> error (
			HttpStatus httpStatus, String message, Object errors){
		
		Map<Object, Object> jsonReponse = new HashMap<>();
		
		jsonReponse.put("message", message);
		jsonReponse.put("errors", errors);
		
		return ResponseEntity.status(httpStatus).body(jsonReponse);
		
		
	}
	
	public static ResponseEntity<Map<Object, Object>> success (
			HttpStatus httpStatus, String message, Object payload){
		
		Map<Object, Object> jsonReponse = new HashMap<>();
		
		jsonReponse.put("message", message);
		
		if (payload != null) {
			jsonReponse.put("payload", payload);
		}
		
		return ResponseEntity.status(httpStatus).body(jsonReponse);
		
		
	}

}
