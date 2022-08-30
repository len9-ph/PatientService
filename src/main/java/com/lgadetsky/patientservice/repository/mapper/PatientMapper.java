package com.lgadetsky.patientservice.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.lgadetsky.patientservice.model.Patient;

/**
 * Mapper
 * @author Leonid Gadetsky
 * @see Patient
 */
@Mapper
public interface PatientMapper {
	void insert(Patient patient);
	Patient findByName(String first, String mid, String last, String birthday);
	Patient findById(int id);
	void update(Patient patient);
}
