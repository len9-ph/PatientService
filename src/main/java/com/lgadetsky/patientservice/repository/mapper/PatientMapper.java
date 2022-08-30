package com.lgadetsky.patientservice.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.lgadetsky.patientservice.model.Patient;

/**
 * Mapper interace to work with database by PatientMapper.xml 
 * @author Leonid Gadetsky
 * @see Patient
 */
@Mapper
public interface PatientMapper {
	int insert(Patient patient);
	Patient findByName(String first, String mid, String last, String birthday);
	Patient findById(int id);
	int update(Patient patient);
}
