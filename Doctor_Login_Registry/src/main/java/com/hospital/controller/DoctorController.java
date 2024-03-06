package com.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hospital.entity.Doctor;
import com.hospital.service.Doctor_InterfaceService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	Doctor_InterfaceService doctor_InterfaceService;

	@PostMapping("/register")
	private ResponseEntity<String> registerDoctors(@RequestBody Doctor doctor) {
		Boolean isDoctorRegistered = doctor_InterfaceService.addDoctor(doctor);
		if (isDoctorRegistered) {
			return new ResponseEntity<String>("Registered SuccessFully", HttpStatusCode.valueOf(200));
		} else {
			return new ResponseEntity<String>("Not Registered", HttpStatusCode.valueOf(400));
		}
	}
	
	@GetMapping("/login")
	private ResponseEntity<String> doctorSignIn(@RequestBody Doctor doctor) {
		if (doctor_InterfaceService.doctorSignIn(doctor)) {
			return new ResponseEntity<String>("Login Success", HttpStatusCode.valueOf(200));
		} else {
			return new ResponseEntity<String>("Please Enter Valid Credentials", HttpStatusCode.valueOf(400));
		}
	}

}
