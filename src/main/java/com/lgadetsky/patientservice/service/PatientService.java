package com.lgadetsky.patientservice.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.lgadetsky.patientservice.dto.PatientDto;
import com.lgadetsky.patientservice.exception.PatientNotFoundException;
import com.lgadetsky.patientservice.model.Patient;
import com.lgadetsky.patientservice.repository.mapper.PatientMapper;

@org.springframework.stereotype.Service
public class PatientService implements Service<PatientDto, String> {
	@Autowired
	private PatientMapper patientMapper;
	
	@Override
	public PatientDto create(PatientDto obj) {
		patientMapper.insert(Patient.of(obj));
		return obj;
	}

	@Override
	public PatientDto findByName(String first, String mid, String last, String birth) {
		if (patientMapper.findByName(first, mid, last, birth) == null)
			throw new PatientNotFoundException();
		else return PatientDto.of(patientMapper.findByName(first, mid, last, birth));
	}

	@Override
	public PatientDto update(PatientDto obj) {
		if (patientMapper.findByName(obj.getFirstName(), obj.getMidName(), obj.getLastName(), obj.getBirthday()) == null)
			throw new PatientNotFoundException();
		else
			patientMapper.update(Patient.of(obj));
		return obj;
	}
}
