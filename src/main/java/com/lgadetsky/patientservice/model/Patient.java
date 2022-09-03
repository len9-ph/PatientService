package com.lgadetsky.patientservice.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.lgadetsky.patientservice.dto.PatientDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Patient entity
 * @author Leonid Gadetsky
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
	
	public static Patient of(PatientDto obj) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return new PatientBuilder()
				.id(obj.getId())
				.firstName(obj.getFirstName())
				.middleName(obj.getMiddleName())
				.lastName(obj.getLastName())
				.gender(obj.getGender())
				.birthday(LocalDate.parse(obj.getBirthday(), dtf))
				.phone(obj.getPhone())
				.email(obj.getEmail())
				.address(obj.getAddress())
				.build();
	}
}
