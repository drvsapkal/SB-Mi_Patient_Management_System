package com.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hospital.entity.Doctor;
import com.hospital.repository.Doctor_InterfaceRepository;

@Service
public class DoctorService implements Doctor_InterfaceService{

	@Autowired
	Doctor_InterfaceRepository doctor_InterfaceRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	public Boolean addDoctor(Doctor doctor) {
		String userName = doctor.getUserName();

		if (doctor_InterfaceRepository.findByUserName(userName) != null) {
			return false;
		}
		else {
			String encodedPassword = passwordEncoder.encode(doctor.getPassWord());
	        doctor.setPassWord(encodedPassword);
	        System.out.println(doctor.getPassWord());
			Doctor d = doctor_InterfaceRepository.save(doctor);
			return d!= null ? true: false; 
		}
	}

	public Doctor doctorSignIn(Doctor doctor) {
		String userName = doctor.getUserName();
		String passWord = doctor.getPassWord();
		
		Doctor foundDoctor = doctor_InterfaceRepository.findByUserName(userName);
		
		if(foundDoctor != null && passwordEncoder.matches(passWord, foundDoctor.getPassWord()))
		{
			return foundDoctor;
		}else {
			return null;
		}
	}

}
