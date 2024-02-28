package com.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.repository.Patient_InterfaceRepository;

@Service
public class PatientService implements Patient_InterfaceService{

	@Autowired
	Patient_InterfaceRepository patient_InterfaceRepository;
	
}
