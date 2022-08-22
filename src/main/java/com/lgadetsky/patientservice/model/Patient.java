package com.lgadetsky.patientservice.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Patient {
	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private int gender;
	private LocalDate birthday;
	private String phone;
	private String email;
	private String address;
}
