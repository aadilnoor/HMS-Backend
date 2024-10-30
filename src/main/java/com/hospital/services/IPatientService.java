package com.hospital.services;

import java.util.List;

import javax.management.AttributeNotFoundException;

import com.hospital.entities.Patient;

public interface IPatientService {

	Patient createPatient(Patient patient);
	
	Patient getPatientById(long id)throws AttributeNotFoundException;
	
	List<Patient> getAllPatients();
	
	void deletePatientById(long id) throws AttributeNotFoundException;
	
	Patient updatePatient(long id , Patient patient) throws AttributeNotFoundException;
}
