package com.hospital.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reports {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reports_id;
	
	private String test_Name;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;

	public Long getReports_id() {
		return reports_id;
	}

	public void setReports_id(Long reports_id) {
		this.reports_id = reports_id;
	}

	public String getTest_Name() {
		return test_Name;
	}

	public void setTest_Name(String test_Name) {
		this.test_Name = test_Name;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Reports(Long reports_id, String test_Name, Patient patient) {
		super();
		this.reports_id = reports_id;
		this.test_Name = test_Name;
		this.patient = patient;
	}
	
	public Reports() {}
}
