package com.patient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.patient.entity.Doctor;
import com.patient.service.Doctor_InterfaceService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	Doctor_InterfaceService doctor_InterfaceService;
	
	@GetMapping("/login")
	public ResponseEntity<String> loginDoctor(@PathVariable Long id){
		doctor_InterfaceService.loginDoctor(id);
		return new ResponseEntity<String>("Login Success", HttpStatusCode.valueOf(200));
	}
	
	@PostMapping("/add")
	public ResponseEntity<Doctor> addDoctor(Doctor doctor)	{
		doctor_InterfaceService.addDoctor(doctor);
		return new ResponseEntity<Doctor>(doctor, HttpStatusCode.valueOf(201));
	}
}
