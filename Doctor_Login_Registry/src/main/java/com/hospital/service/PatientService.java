package com.hospital.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.entity.Patient;
import com.hospital.repository.Patient_InterfaceRepository;

@Service
public class PatientService implements Patient_InterfaceService{

	@Autowired
	Patient_InterfaceRepository patient_InterfaceRepository;
	
	@Override
	public boolean addPatient(Patient patient) {
		
		Patient patientDetails = patient_InterfaceRepository.save(patient);
		
		if(patientDetails != null)
			return true;
		else
			return false;
		
	}

	@Override
	public Patient getPatientById(Long patientId) {
		
		Optional<Patient> patientDetails = patient_InterfaceRepository.findById(patientId);
		return patientDetails.get();
	
	}

	@Override
	public List<Patient> getPatientsDetails() {
		
		List<Patient> patientDetails = patient_InterfaceRepository.findAll();

		if (patientDetails != null) {
			return patientDetails;
		} else {
			return Collections.emptyList();
		}
	}
	
}
