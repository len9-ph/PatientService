package com.lgadetsky.patientservice.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler{
	
	private final static String TIMESTAMP = "timestamp";
	private final static String MESSAGE = "message";
	private final static String PATIENT_NOT_FOUND = "Patient not found";
	
	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<Object> handlePatientNotFoundException(
			PatientNotFoundException ex, WebRequest request) {
		
		Map<String, Object> body = new LinkedHashMap<>();
		body.put(TIMESTAMP, LocalDateTime.now());
		body.put(MESSAGE, PATIENT_NOT_FOUND);
		
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
}
