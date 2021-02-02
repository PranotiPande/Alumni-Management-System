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
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer feedbackId;
	
	@ManyToOne
	@JoinColumn(name="ID")
		private User ID;
		
		@Column(length = 50)
		private String description;
		//add date 
		private LocalDate feedbackDate;
		public Feedback() {
			super();
			System.out.println("In Constructor " + getClass().getName());

		}
		public Feedback(Integer feedbackId, User iD, String description, LocalDate feedbackDate) {
			super();
			this.feedbackId = feedbackId;
			ID = iD;
			this.description = description;
			this.feedbackDate = feedbackDate;
		}
		public Integer getFeedbackId() {
			return feedbackId;
		}
		public void setFeedbackId(Integer feedbackId) {
			this.feedbackId = feedbackId;
		}
		public User getID() {
			return ID;
		}
		public void setID(User iD) {
			ID = iD;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public LocalDate getFeedbackDate() {
			return feedbackDate;
		}
		public void setFeedbackDate(LocalDate feedbackDate) {
			this.feedbackDate = feedbackDate;
		}
		
		
		
}
