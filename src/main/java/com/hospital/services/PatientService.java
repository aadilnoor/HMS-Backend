package com.hospital.services;

import java.util.Comparator;
import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.stereotype.Service;

import com.hospital.entities.Patient;
import com.hospital.repositries.PatientRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PatientService implements IPatientService {

	private final PatientRepository patientRepository;

	@Override
	public Patient createPatient(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public List<Patient> getAllPatients() {
		List<Patient> allPatients = patientRepository.findAll();
		return allPatients.stream().sorted(Comparator.comparing(Patient::getId).reversed()).toList();
	}

	@Override
	public void deletePatientById(long id) throws AttributeNotFoundException {
		Patient patient = patientRepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException("patient not found with id :" + id));
		patientRepository.delete(patient);
	}

	@Override
	public Patient updatePatient(long id, Patient patient) throws AttributeNotFoundException {
		Patient patient2 = patientRepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException("Patient not found with id :" + id));

		patient2.setName(patient.getName());
		patient2.setAge(patient.getAge());
		patient2.setBlood(patient.getBlood());
		patient2.setDose(patient.getDose());
		patient2.setFees(patient.getFees());
		patient2.setPrescription(patient.getPrescription());
		patient2.setUrgency(patient.getUrgency());

		return patientRepository.save(patient2);

	}

	@Override
	public Patient getPatientById(long id) throws AttributeNotFoundException {
		Patient patient = patientRepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException("Patient not found with id :" + id));
		return patient;
	}
}
