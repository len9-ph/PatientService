package com.lgadetsky.patientservice.exception;

/**
 * Exception class responsible for patient not found case
 * 
 * @author Leonid Gadetsky
 * @see ControllerAdvisor
 */
public class PatientNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public PatientNotFoundException() {
		super();
	}
}
