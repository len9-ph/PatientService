package com.lgadetsky.patientservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lgadetsky.patientservice.dto.PatientDto;
import com.lgadetsky.patientservice.model.Patient;
import com.lgadetsky.patientservice.service.PatientService;

import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	
	@PostMapping("/patient")
	@ApiResponses(value = {
			
	})
	PatientDto create(@RequestBody PatientDto patient){
		patientService.create(Patient.of(patient));
		return patient;
	}
	
	@GetMapping("/patient/{first}/{mid}/{last}/{birthday}")
	@ApiResponses(value = {
			
	})
	PatientDto readByName(@PathVariable String first,
			@PathVariable String mid, @PathVariable String last, @PathVariable String birthday) {
		return PatientDto.of(patientService.findByName(first, mid, last, birthday));	
	}
	
	@GetMapping("/patientId/{id}")
	PatientDto readById(@PathVariable int id) {
		return PatientDto.of(patientService.findById(id));
	}
	
	@PutMapping("/patient/{id}")
	@ApiResponses(value = {
			
	})
	PatientDto update(@PathVariable int id, @RequestBody PatientDto patient) {
		patient.setId(id);
		patientService.update(Patient.of(patient));
		return patient;
	}

}
