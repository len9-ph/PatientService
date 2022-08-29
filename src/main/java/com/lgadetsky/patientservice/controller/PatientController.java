package com.lgadetsky.patientservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lgadetsky.patientservice.dto.PatientDto;
import com.lgadetsky.patientservice.service.PatientService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PatientController {
	@Autowired
	private final PatientService patientService;
	
	
	@PostMapping("/patient")
	ResponseEntity<?> create(@RequestBody PatientDto patient){
		patientService.create(patient);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/patient/{first}/{mid}/{last}/{birthday}")
	ResponseEntity<?> readById(@PathVariable String first,
			@PathVariable String mid, @PathVariable String last, @PathVariable String birthday) {
		return new ResponseEntity<PatientDto>(patientService.findByName(first, mid, last, birthday), HttpStatus.OK);	
	}
	
	@PutMapping("/patient/{id}")
	ResponseEntity<?> update(@PathVariable int id, @RequestBody PatientDto patient) {
		patient.setId(id);
		patientService.update(patient);
		return new ResponseEntity<PatientDto>(patient, HttpStatus.OK);
	}

}
