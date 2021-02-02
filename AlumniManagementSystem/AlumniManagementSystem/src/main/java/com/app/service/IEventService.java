package com.app.service;

import java.util.List;

import com.app.pojos.Event;
import com.app.pojos.User;

public interface IEventService {
	List<Event> getAllEvents();
	
	//add new event 
	 Event addEvent(Event transientPOJO);	
	 
	 //Update existing event details
	Event updateEventDetails(Event e1,int eventId);

	 
}
