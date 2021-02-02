package com.app.pojos;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer adminId;
	
	@Column( length = 25 ,unique = true)
	private String email;
	
	@Column( length = 30)
	private String password;
	
	@Column( length = 25)
	private String firstName;
	
	@Column( length = 25)
	private String lastName;
	
	@Column( length = 15)
	private String contactNo;
	private Blob image;
	public Admin() {
		super();
		System.out.println("In Constructor " + getClass().getName());
	}
	public Admin(Integer adminId, String email, String password, String firstName, String lastName, String contactNo,
			Blob image) {
		super();
		this.adminId = adminId;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.image = image;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String userName) {
		this.email = userName;
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
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	
		

}
