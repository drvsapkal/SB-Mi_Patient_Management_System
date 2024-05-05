package com.hospital.service;

import java.util.List;

import com.hospital.entity.Patient;

public interface Patient_InterfaceService {

	boolean addPatient(Patient patient);

	Patient getPatientById(Long patientId);

	List<Patient> getPatientsDetails();

}
