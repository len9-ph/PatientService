package com.lgadetsky.patientservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatientDto {
	private int id;
	private String name;
	private int gender;
	private String birthday;
	
}
