package com.lgadetsky.patientservice.exception;

public class PatientNotValidException extends RuntimeException{
	private static final long serialVersionUID = 2L;
	
	public PatientNotValidException() {
		super("Patient not valid");
	}
}
