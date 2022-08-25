package com.lgadetsky.patientservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.lgadetsky.patientservice.dto.PatientDto;
import com.lgadetsky.patientservice.service.PatientService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PatientController {
	
	private final PatientService patientService;
	
	
	
	@PostMapping("/patient")
	ResponseEntity<?> create(@RequestBody PatientDto patient){
		patientService.create(patient);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/patient/{id}")
	ResponseEntity<?> readById(@PathVariable int id) {
		return new ResponseEntity<PatientDto>(patientService.findById(id), HttpStatus.OK);	
	}
	
	@PutMapping("/patient/{id}")
	ResponseEntity<?> update(@PathVariable int id, @RequestBody PatientDto patient) {
		patient.setId(id);
		patientService.update(patient);
		return new ResponseEntity<PatientDto>(patient, HttpStatus.OK);
	}
	
	@DeleteMapping("/patient/{id}")
	ResponseEntity<?> deleteByid(@PathVariable int id){
		patientService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
