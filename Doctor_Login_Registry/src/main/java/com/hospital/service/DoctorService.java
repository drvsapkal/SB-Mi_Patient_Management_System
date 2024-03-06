package com.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.entity.Doctor;
import com.hospital.repository.Doctor_InterfaceRepository;

@Service
public class DoctorService implements Doctor_InterfaceService{

	@Autowired
	Doctor_InterfaceRepository doctor_InterfaceRepository;

	public Boolean addDoctor(Doctor doctor) {
		String userName = doctor.getUserName();

		if (doctor_InterfaceRepository.findByUserName(userName) != null) {
			return false;
		}
		else {
			Doctor d = doctor_InterfaceRepository.save(doctor);
			return d!= null ? true: false; 
		}
	}

	public Boolean doctorSignIn(Doctor doctor) {
		String userName = doctor.getUserName();
		String passWord = doctor.getPassWord();
		
		Doctor foundDoctor = doctor_InterfaceRepository.findByUserName(userName);
		
		if(foundDoctor != null && foundDoctor.getPassWord().equals(passWord))
		{
			return true;
		}else {
			return false;
		}
	}

}
