package com.hospital.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String firsName;
	private String lastName;
	private String mobileNumber;
	private String city;
	private String emailId;
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
	
	@OneToMany(mappedBy = "patient")
	@JsonIgnore
	private List<Drug> drug;
	
	@OneToMany(mappedBy="patient")
	@JsonIgnore
	private List<Reports> reports;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirsName() {
		return firsName;
	}

	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public List<Drug> getDrug() {
		return drug;
	}

	public void setDrug(List<Drug> drug) {
		this.drug = drug;
	}

	public Patient(Long id, String firsName, String lastName, String mobileNumber, String city, String emailId,
			Date date, Doctor doctor, List<Drug> drug, List<Reports> reports) {
		this.id = id;
		this.firsName = firsName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.city = city;
		this.emailId = emailId;
		this.date = date;
		this.doctor = doctor;
		this.drug = drug;
		this.reports = reports;
	}

	public Patient() {
	}
	
}
