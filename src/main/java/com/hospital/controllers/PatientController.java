package com.hospital.controllers;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.entities.Patient;
import com.hospital.services.IPatientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {

	private final IPatientService patientService;

	@PostMapping("/savePatient")
	public Patient createPatient(@RequestBody Patient patient) {

		return patientService.createPatient(patient);

	}

	@GetMapping("/getAllPatients")
	public List<Patient> getAllPatients() {
		return patientService.getAllPatients();
	}

	@DeleteMapping("/deletePatient/{id}")
	public ResponseEntity<?> deletePatient(@PathVariable Long id) throws AttributeNotFoundException {
		patientService.deletePatientById(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/updatePatient/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable long id, @RequestBody Patient patient)
			throws AttributeNotFoundException {
		Patient updatePatient = patientService.updatePatient(id, patient);
		return ResponseEntity.ok(updatePatient);

	}

	@GetMapping("/getPatient/{id}")
	public ResponseEntity<Patient> getPatientById(@PathVariable long id) throws AttributeNotFoundException {

		Patient patientById = patientService.getPatientById(id);
		return ResponseEntity.ok(patientById);
	}
}
