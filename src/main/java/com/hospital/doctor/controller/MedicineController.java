package com.hospital.doctor.controller;

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

import com.hospital.doctor.entity.Medicine;
import com.hospital.doctor.services.IMedicineService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/medicine")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class MedicineController {

	private final IMedicineService medicineService;

	@PostMapping("/saveMedicine")
	public Medicine createMedicine(@RequestBody Medicine medicine) {

		return medicineService.createMedicine(medicine);

	}

	@GetMapping("/getAllMedicine")
	public List<Medicine> getAllMedicines() {
		return medicineService.getAllMedicines();
	}

	@DeleteMapping("/deleteMedicine/{id}")
	public ResponseEntity<?> deleteMedicine(@PathVariable long id) throws AttributeNotFoundException {
		medicineService.deleteMedicine(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/updateMedicine/{id}")
	public ResponseEntity<Medicine> updateMedicinebyId(@PathVariable long id, @RequestBody Medicine medicine)
			throws AttributeNotFoundException {

		Medicine updateMedicine = medicineService.updateMedicine(id, medicine);

		return ResponseEntity.ok(updateMedicine);
	}

	@GetMapping("/getMedicine/{id}")
	public ResponseEntity<Medicine> getMedicineById(@PathVariable long id) throws AttributeNotFoundException {

		Medicine medicine = medicineService.getMedicineById(id);
		return ResponseEntity.ok(medicine);
	}
}
