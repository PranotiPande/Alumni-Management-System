package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

@Entity
public class Branch {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer branchId;
	
	@Column(length = 50,unique=true)
	private String branchName;

	public Branch() {
		super();
		System.out.println("In Constructor " + getClass().getName());

	}

	public Branch(Integer branchId, String branchName) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	
}
