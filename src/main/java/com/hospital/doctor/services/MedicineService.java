package com.hospital.doctor.services;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.stereotype.Service;

import com.hospital.doctor.entity.Medicine;
import com.hospital.doctor.repository.MedicineRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MedicineService implements IMedicineService {

	private final MedicineRepository medicineRepository;

	@Override
	public Medicine createMedicine(Medicine medicine) {

		return medicineRepository.save(medicine);

	}

	@Override
	public List<Medicine> getAllMedicines() {
		return medicineRepository.findAll();

	}

	@Override
	public void deleteMedicine(long id) throws AttributeNotFoundException {
		Medicine medicine = medicineRepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException("Medicine not found wit id :" + id));
		medicineRepository.delete(medicine);
	}

	@Override
	public Medicine updateMedicine(long id, Medicine medicine) throws AttributeNotFoundException {
		Medicine newMedicine = medicineRepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException("Medicine not found with id :" + id));

		newMedicine.setId(medicine.getId());
		newMedicine.setMedName(medicine.getMedName());
		newMedicine.setStock(medicine.getStock());
		return medicineRepository.save(newMedicine);

	}

	@Override
	public Medicine getMedicineById(long id) throws AttributeNotFoundException {

		Medicine medicine = medicineRepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException("Medicine not found with id :" + id));

		return medicine;
	}
}
