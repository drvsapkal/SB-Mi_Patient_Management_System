package com.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hospital.entity.Doctor;
import com.hospital.response_result.ResponseResult;
import com.hospital.service.Doctor_InterfaceService;

@Controller
@CrossOrigin("*")
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
	
	@PostMapping("/login")
	private ResponseEntity<ResponseResult> doctorSignIn(@RequestBody Doctor doctor) {
		boolean signInResult = doctor_InterfaceService.doctorSignIn(doctor);
		String message = signInResult ? "Login Success" : "Invalid username or password";
		ResponseResult response = new ResponseResult(signInResult, message);
		HttpStatus status = signInResult ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
		return new ResponseEntity<ResponseResult>(response, status);
	}

}
