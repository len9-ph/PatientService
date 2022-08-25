package com.lgadetsky.patientservice.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.lgadetsky.patientservice.dto.PatientDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
				.firstName(obj.getName().split(" ")[0])
				.middleName(obj.getName().split(" ")[1])
				.lastName(obj.getName().split(" ")[2])
				.gender(obj.getGender())
				.birthday(LocalDate.parse(obj.getBirthday(), dtf))
				.phone(obj.getPhone())
				.email(obj.getEmail())
				.address(obj.getAddress())
				.build();
	}
}
