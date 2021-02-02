package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer jobId;
	
	@ManyToOne
	@JoinColumn(name="ID")
	private User ID;
	
	@Column(length=30)
	private String title;
	
	@Column(length=60)
	private String description;
	@Column(length=200)
	private String link;
	
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	public Job() {
		super();
	}

	public Job(Integer jobId, User student, String title, String description, String link, LocalDate startDate,
			LocalDate endDate) {
		super();
		this.jobId = jobId;
		this.ID = student;
		this.title = title;
		this.description = description;
		this.link = link;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public User getID() {
		return ID;
	}

	public void setID(User student) {
		this.ID = student;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	
	
	
	
	
	
	
}
