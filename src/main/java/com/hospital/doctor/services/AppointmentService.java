package com.hospital.doctor.services;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.stereotype.Service;

import com.hospital.doctor.entity.Appointment;
import com.hospital.doctor.repository.AppointmentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentService implements IAppointmentService {

	private final AppointmentRepository appointmentRepository;

	@Override
	public Appointment createAppointment(Appointment appointment) {

		return appointmentRepository.save(appointment);
	}
	
	@Override
	public List<Appointment> getAllAppointments() {
	
		return appointmentRepository.findAll();
	}

	@Override
	public void deleteAppointment(long id) throws AttributeNotFoundException {
		Appointment appointment = appointmentRepository.findById(id).
		orElseThrow(() -> new AttributeNotFoundException("Appointment not found with id : " +id));
		appointmentRepository.delete(appointment);
	}
}