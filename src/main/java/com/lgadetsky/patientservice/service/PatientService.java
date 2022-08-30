package com.lgadetsky.patientservice.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.lgadetsky.patientservice.exception.PatientNotFoundException;
import com.lgadetsky.patientservice.model.Patient;
import com.lgadetsky.patientservice.repository.mapper.PatientMapper;

/**
 * Service class that implements {@link Service} inteface
 * Work with {@link PatientMapper} methods 
 * 
 * @author Leonid Gadetsky
 * @see Service
 * @see PatientMapper
 */
@org.springframework.stereotype.Service
public class PatientService implements Service<Patient, String> {
	@Autowired
	private PatientMapper patientMapper;
	
	@Override
	public Patient create(Patient obj) {
		patientMapper.insert(obj);
		return obj;
	}

	@Override
	public Patient findByName(String first, String mid, String last, String birth) {
		if (patientMapper.findByName(first, mid, last, birth) == null)
			throw new PatientNotFoundException();
		else return patientMapper.findByName(first, mid, last, birth);
	}
	
	public Patient findById(int id) {
		if (patientMapper.findById(id) == null)
			throw new PatientNotFoundException();
		else return patientMapper.findById(id);
	}

	@Override
	public Patient update(Patient obj) {
		if (patientMapper.findById(obj.getId()) == null)
			throw new PatientNotFoundException();
		else
			patientMapper.update(obj);
		return obj;
	}
}
