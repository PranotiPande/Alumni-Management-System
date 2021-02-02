package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

// student has job:containment--->reminder
@Entity
public class AlumniJobDetails {
@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer alumniJobId;
	//@ManyToOne
	//@JoinColumn(name="ID")
	private Integer ID;
	
	@Column(length = 50)
	private String companyName;
	@Column(length = 30)
	private String designation;
	private LocalDate joinDate;
	private LocalDate leavingDate;
	public AlumniJobDetails() {
		super();
		System.out.println("In Constructor " + getClass().getName());
	}
	public AlumniJobDetails(Integer alumniJobId, Integer iD, String companyName, String designation, LocalDate joinDate,
			LocalDate leavingDate) {
		super();
		this.alumniJobId = alumniJobId;
		ID = iD;
		this.companyName = companyName;
		this.designation = designation;
		this.joinDate = joinDate;
		this.leavingDate = leavingDate;
	}
	public Integer getAlumniJobId() {
		return alumniJobId;
	}
	public void setAlumniJobId(Integer alumniJobId) {
		this.alumniJobId = alumniJobId;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public LocalDate getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}
	public LocalDate getLeavingDate() {
		return leavingDate;
	}
	public void setLeavingDate(LocalDate leavingDate) {
		this.leavingDate = leavingDate;
	}
	
	
}
