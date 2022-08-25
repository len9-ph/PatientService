package com.lgadetsky.patientservice.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.lgadetsky.patientservice.dto.PatientDto;
import com.lgadetsky.patientservice.model.Patient;
import com.lgadetsky.patientservice.repository.mapper.PatientMapper;

@org.springframework.stereotype.Service
public class PatientService implements Service<PatientDto, Integer> {
	@Autowired
	private PatientMapper patientMapper;
	
	@Override
	public PatientDto create(PatientDto obj) {
		if (obj == null)
			return null;
		else
			patientMapper.insert(Patient.of(obj));
		return obj;
	}

	@Override
	public PatientDto findById(Integer id) {
		if (patientMapper.findById(id) == null)
			return null;
		else return PatientDto.of(patientMapper.findById(id));
	}

	@Override
	public PatientDto update(PatientDto obj) {
		if (patientMapper.findById(obj.getId()) == null)
			return null;
		else
			patientMapper.update(Patient.of(obj));
		return obj;
	}

	@Override
	public void deleteById(Integer id) {
		patientMapper.deleteById(id);
	}

}
