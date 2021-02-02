package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer eventId;
	
	@Column(length = 50)
	private String eventTitle;
	
	@Column(length = 200)
	private String eventDescription;

	public Event() {
		super();
	}

	public Event(Integer eventId, String eventTitle, String eventDescription) {
		super();
		this.eventId = eventId;
		this.eventTitle = eventTitle;
		this.eventDescription = eventDescription;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	

	
}
