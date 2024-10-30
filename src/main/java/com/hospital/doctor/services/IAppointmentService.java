package com.hospital.doctor.services;

import java.util.List;

import javax.management.AttributeNotFoundException;

import com.hospital.doctor.entity.Appointment;

public interface IAppointmentService {
	
	Appointment  createAppointment(Appointment appointment );
	
	List<Appointment> getAllAppointments();
	
	void deleteAppointment(long id) throws AttributeNotFoundException;
	

}
