package com.app.pojos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ID;
	
	
	@Column(length = 30)
	private String password;
	
	@Column(length = 30)
	private String firstName;
	
	@Column(length = 30)
	private String lastName;
	
	private Integer gender;
	
	@Column(length = 50)
	private String address;
	
	
	//@ManyToOne
	//@JoinColumn(name = "cityId")
	//@JsonIgnore
	private Integer cityId;
	
	@Column(length = 15,unique=true)
	private String contactNo;
	
	
	@Column(length = 50,unique=true)
	private String email;
	
	//@JsonSerialize(using = LocalDateTimeSerializer.class)
	//@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	//@JsonProperty
	private String DOB;
	
	//@ManyToOne
	//@JoinColumn (name="branchId")
	//@JsonIgnore
	private Integer  branchId;
	
	
	//private Integer batchID;
	//@ManyToOne
	//@JoinColumn (name="batchId")
	//@JsonIgnore
	private Integer batchId;
	
	private Boolean status;
	
	@Enumerated(EnumType.STRING)
	private UserType role;
	@Lob
	private byte[] image;
	@Column(length = 30)
	private String imageContentType;
	public User() {
		super();
		System.out.println("In Constructor " + getClass().getName());
	}
	public User(Integer iD, String password, String firstName, String lastName, Integer gender, String address,
			Integer cityId, String contactNo, String email, String dOB, Integer branchId, Integer batchId, Boolean status,
			UserType role, byte[] image, String imageContentType) {
		super();
		ID = iD;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.address = address;
		this.cityId = cityId;
		this.contactNo = contactNo;
		this.email = email;
		DOB = dOB;
		this.branchId = branchId;
		this.batchId = batchId;
		this.status = status;
		this.role = role;
		this.image = image;
		this.imageContentType = imageContentType;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public Integer getBranchId() {
		return branchId;
	}
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	public Integer getBatchId() {
		return batchId;
	}
	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public UserType getRole() {
		return role;
	}
	public void setRole(UserType role) {
		this.role = role;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getImageContentType() {
		return imageContentType;
	}
	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}
	
	

	
	
	
}
