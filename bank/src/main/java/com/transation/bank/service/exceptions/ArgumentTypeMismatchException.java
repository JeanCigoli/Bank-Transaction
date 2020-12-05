package com.transation.bank.service.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.transation.bank.utils.HttpResponse;

@ControllerAdvice
public class ArgumentTypeMismatchException {

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Map<Object, Object>> handleMethodArgumentTypeMismatchExceptions(
			MethodArgumentTypeMismatchException ex) {

		Map<String, String> errors = new HashMap<>();

		errors.put("param", ex.getName());
		errors.put("message", ex.getMessage());

		return HttpResponse.error(HttpStatus.BAD_REQUEST, "Tipo de argumento incompatível", errors);
	}
}
