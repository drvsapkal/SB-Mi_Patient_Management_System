package com.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.entity.Patient;
import com.hospital.service.Patient_InterfaceService;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	Patient_InterfaceService patient_InterfaceService;
	
	@PostMapping("/add")
	private ResponseEntity<String> addPatient(@RequestBody Patient patient) {
		
		if(patient != null && patient_InterfaceService.addPatient(patient))
		{
			return new ResponseEntity<String>("Patient added SuccessFully", HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<String>("Please Enter Correct Details", HttpStatus.BAD_REQUEST);
		}
	}
}
