package com.lgadetsky.patientservice.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.lgadetsky.patientservice.model.Patient;
import com.lgadetsky.patientservice.repository.mapper.PatientMapper;

@org.springframework.stereotype.Service
public class PatientService implements Service<Patient, Integer> {
	@Autowired
	private PatientMapper patientMapper;
	
	@Override
	public Patient create(Patient obj) {
		if (obj == null)
			return null;
		else
			patientMapper.insert(obj);
		return obj;
	}

	@Override
	public Patient findById(Integer id) {
		if (patientMapper.findById(id) == null)
			return null;
		else return patientMapper.findById(id);
	}

	@Override
	public Patient update(Patient obj) {
		if (patientMapper.findById(obj.getId()) == null)
			return null;
		else
			patientMapper.update(obj);
		return obj;
	}

	@Override
	public void deleteById(Integer id) {
		patientMapper.deleteById(id);
	}

}
