package com.NJTProject.rest.webservices.restwebservices.Report;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.NJTProject.rest.webservices.restwebservices.doctor.Doctor;
import com.NJTProject.rest.webservices.restwebservices.patient.Patient;

@Entity

public class Report {
	
	@Id
	@GeneratedValue

	private Long id;
	 private String diagnosis;
	 private String therapy;
	 private String note;
	 
	 
	 public Report() {
		 
	 }
	 
	public Report(Long id, String diagnosis, String therapy, String note) {
		super();
		this.id = id;
		this.diagnosis = diagnosis;
		this.therapy = therapy;
		this.note = note;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getTherapy() {
		return therapy;
	}
	public void setTherapy(String therapy) {
		this.therapy = therapy;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Report [id=" + id + ", diagnosis=" + diagnosis + ", therapy=" + therapy + ", note=" + note + "]";
	}
	 
	
	
	
}
