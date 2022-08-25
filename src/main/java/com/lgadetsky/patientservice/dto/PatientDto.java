package com.lgadetsky.patientservice.dto;

import com.lgadetsky.patientservice.model.Patient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientDto {
	private int id;
	private String name;
	private int gender;
	private String birthday;
	private String phone;
	private String email;
	private String address;
	
	public static PatientDto of (Patient p) {
		return new PatientDtoBuilder().id(p.getId())
				.name(new StringBuilder(p.getFirstName() + " " + p.getMiddleName() + " "+ p.getLastName()).toString())
				.gender(p.getGender())
				.birthday(p.getBirthday().toString())
				.phone(p.getPhone())
				.email(p.getEmail())
				.address(p.getAddress())
				.build();
	}
}
