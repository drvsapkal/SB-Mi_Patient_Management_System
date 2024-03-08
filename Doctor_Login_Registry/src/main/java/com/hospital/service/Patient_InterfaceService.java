package com.hospital.service;

import com.hospital.entity.Patient;

public interface Patient_InterfaceService {

	boolean addPatient(Patient patient);

	Patient getPatientDetails(Long patientId);

}
