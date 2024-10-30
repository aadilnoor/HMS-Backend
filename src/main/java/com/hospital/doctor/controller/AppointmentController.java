package com.hospital.doctor.controller;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.doctor.entity.Appointment;
import com.hospital.doctor.services.IAppointmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/appointment")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AppointmentController {
	
	private final IAppointmentService appointmentService;

	@PostMapping("/saveAppointment")
	public Appointment createAppointment(@RequestBody Appointment appointment) {

		return appointmentService.createAppointment(appointment);
	}

	@GetMapping("/getAllAppointment")
	public List<Appointment> getAllAppointments() {

		return appointmentService.getAllAppointments();
	}

	@DeleteMapping("/deleteAppointment/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable long id) throws AttributeNotFoundException {

		appointmentService.deleteAppointment(id);
		return ResponseEntity.ok().build();
		//return new ResponseEntity<>("Appointment deleted successfully...", HttpStatus.OK);
	}
}
