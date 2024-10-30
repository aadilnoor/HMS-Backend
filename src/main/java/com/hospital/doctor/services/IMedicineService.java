package com.hospital.doctor.services;

import java.util.List;

import javax.management.AttributeNotFoundException;

import com.hospital.doctor.entity.Medicine;

public interface IMedicineService {

	Medicine createMedicine(Medicine medicine);

	List<Medicine> getAllMedicines();

	void deleteMedicine(long id) throws AttributeNotFoundException;

	Medicine updateMedicine(long id,Medicine medicine) throws AttributeNotFoundException;
	
	Medicine getMedicineById(long id) throws AttributeNotFoundException;
}
