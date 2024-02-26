package com.patient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.entity.Doctor;
import com.patient.repository.Doctor_InterfaceRepository;

@Service
public class DoctorService implements Doctor_InterfaceService{

	@Autowired
	Doctor_InterfaceRepository doctor_InterfaceRepository;
	
	@Override
	public void loginDoctor(Long id) {
		doctor_InterfaceRepository.findById(id);
	}

	@Override
	public void addDoctor(Doctor doctor) {
		doctor_InterfaceRepository.save(doctor);	
	}
}
