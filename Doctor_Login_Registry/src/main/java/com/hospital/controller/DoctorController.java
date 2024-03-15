package com.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	private ResponseEntity<ResponseResult> registerDoctors(@RequestBody Doctor doctor) {
		boolean signInResult = doctor_InterfaceService.addDoctor(doctor);
		String message = signInResult ? "Registered SuccessFully" : "Not Registered, enter valid data";
		ResponseResult response = new ResponseResult(signInResult, message);
		HttpStatus status = signInResult ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
		return new ResponseEntity<ResponseResult>(response, status);
	}
	
	@PostMapping("/login")
	private ResponseEntity<Doctor> doctorSignIn(@RequestBody Doctor doctor) {
	
		Doctor doctorLoginDetails = doctor_InterfaceService.doctorSignIn(doctor);
		if(doctorLoginDetails != null)
		{
			return new ResponseEntity<Doctor>(doctorLoginDetails, HttpStatus.OK);
		} else {
			return new ResponseEntity<Doctor>(HttpStatus.UNAUTHORIZED);

		}
//		boolean signInResult = doctor_InterfaceService.doctorSignIn(doctor);
//		String message = signInResult ? "Login Success" : "Invalid username or password";
//		ResponseResult response = new ResponseResult(signInResult, message);
//		HttpStatus status = signInResult ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
//		return new ResponseEntity<ResponseResult>(response, status);
	
	}

}
