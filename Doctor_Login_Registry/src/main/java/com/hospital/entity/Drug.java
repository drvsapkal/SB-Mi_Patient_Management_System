package com.hospital.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Drug {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String tabletName;
	private Long mg;
	private Long days;
	private String comments;
	private Long quantity;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTabletName() {
		return tabletName;
	}

	public void setTabletName(String tabletName) {
		this.tabletName = tabletName;
	}

	public Long getMg() {
		return mg;
	}

	public void setMg(Long mg) {
		this.mg = mg;
	}

	public Long getDays() {
		return days;
	}

	public void setDays(Long days) {
		this.days = days;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Drug(Long id, String tabletName, Long mg, Long days, String comments, Long quantity, Patient patient) {
		super();
		this.id = id;
		this.tabletName = tabletName;
		this.mg = mg;
		this.days = days;
		this.comments = comments;
		this.quantity = quantity;
		this.patient = patient;
	}
	
}
