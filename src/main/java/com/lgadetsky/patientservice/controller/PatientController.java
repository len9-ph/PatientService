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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

/**
 * Main controller for patient service
 * 
 * Implements CRUD operations
 * create - to create new Patient
 * readByName - find Patient by full name and birthday
 * readById - find Patient by id
 * update - update Patient
 * 
 * @author Leonid Gadetsky
 * @see PatientService
 */
@RestController
@AllArgsConstructor
@Tag(name = "default", description = "Main controller")
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	
	@PostMapping("/patient")
	@Operation(
			summary = "Request for adding a new Patient",
			description = "Creates a new patient with parameters are contatined in the requestbody")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "A new patient has been successfully created", content = @Content ),
    		@ApiResponse(responseCode = "500", description = "Server error", content = @Content)
})
	PatientDto create(@RequestBody PatientDto patient){
		patientService.create(Patient.of(patient));
		return patient;
	}
	
	@GetMapping("/patient/{first}/{mid}/{last}/{birthday}")
	@Operation(
			summary = "Get the Patient by Full name and birthday",
			description = "Returns object by unique values or null"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "A successful response", content = @Content),
    		@ApiResponse (responseCode = "404", description = "A resource with requested fields not found", content = @Content),
    		@ApiResponse(responseCode = "500", description = "Server error", content = @Content)
	})
	PatientDto readByName(@PathVariable String first,
			@PathVariable String mid, @PathVariable String last, @PathVariable String birthday) {
		return PatientDto.of(patientService.findByName(first, mid, last, birthday));	
	}
	
	@Operation(
			summary = "Get the Patient by id",
			description = "Returns object by idor null"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "A successful response", content = @Content),
    		@ApiResponse (responseCode = "404", description = "A resource with requested id not found", content = @Content),
    		@ApiResponse(responseCode = "500", description = "Server error", content = @Content)
	})
	@GetMapping("/patientId/{id}")
	PatientDto readById(@PathVariable int id) {
		return PatientDto.of(patientService.findById(id));
	}
	
	@PutMapping("/patient/{id}")
	@Operation(
            summary = "Request for editing the Patient by id",
            description = "Update patient by id with parameters are contained in request body"
    )
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Order has been updated succesfully", content = @Content),
	    	@ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
	    	@ApiResponse(responseCode = "500", description = "Server error", content = @Content)
	})
	PatientDto update(@PathVariable int id, @RequestBody PatientDto patient) {
		patient.setId(id);
		patientService.update(Patient.of(patient));
		return patient;
	}

}
