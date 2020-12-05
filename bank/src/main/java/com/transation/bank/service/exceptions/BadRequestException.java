package com.transation.bank.service.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.transation.bank.utils.HttpResponse;

@ControllerAdvice
public class BadRequestException {

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Map<Object, Object>> handleMessageNotReadableExceptions(HttpMessageNotReadableException ex) {
		
		Map<String, String> errors = new HashMap<>();

		errors.put("param", "request JSON");
		errors.put("message", ex.getMessage());

		return HttpResponse.error(HttpStatus.BAD_REQUEST, "JSON se encontra mal formatado", errors);
	}
}
