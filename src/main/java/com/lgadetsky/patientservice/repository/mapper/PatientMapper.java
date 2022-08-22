package com.lgadetsky.patientservice.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.lgadetsky.patientservice.model.Patient;

/**
 * Mapper
 * @author leoni
 * @see Patient
 */
@Mapper
public interface PatientMapper {
	void insert(Patient patient);
	Patient findById(int id);
	void update(Patient patient);
	void deleteById(int id);
}
