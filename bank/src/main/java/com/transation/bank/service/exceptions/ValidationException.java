package com.transation.bank.service.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.transation.bank.utils.HttpResponse;

@ControllerAdvice
public class ValidationException {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<Object, Object>> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
		
	    Map<String, String> errors = new HashMap<>();
	    
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	    	
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        
	        errors.put("param", fieldName);
	        errors.put("message", errorMessage);
	    });
	    
	    return HttpResponse.error(HttpStatus.UNPROCESSABLE_ENTITY, "Unprocessable Entity", errors);
	}

}
