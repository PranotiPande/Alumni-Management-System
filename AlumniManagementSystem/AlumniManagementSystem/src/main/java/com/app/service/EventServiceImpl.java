package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excs.StudentNotFoundException;
import com.app.dao.IEventDao;
import com.app.pojos.Event;
import com.app.pojos.User;

@Service
@Transactional
public class EventServiceImpl implements IEventService {

	@Autowired
	private IEventDao dao;
	
	@Override
	public List<Event> getAllEvents() {
		System.out.println("in Events service getALL::"+getClass().getName());
		return dao.findAll();
	}

	@Override
	public Event addEvent(Event transientPOJO) {
		System.out.println("In Event service impl save");
		return dao.save(transientPOJO);
	}

	@Override
	public Event updateEventDetails(Event e1, int eventId) {
		System.out.println("In Event service impl update");
		// check if student exist
		Optional<Event> e = dao.findById(eventId);
		if (e.isPresent()) {
			// s.get() : PERSISTENT
			// s1 : detached POJO : contain the updates sent by client
			// change the state of persistent pojo
			Event event = e.get();
			event.setEventTitle(e1.getEventTitle());
			event.setEventDescription(e1.getEventDescription());
			return event;
		}

		// in case of no Student find : throw custom exception
		throw new StudentNotFoundException("invalid Event");

	}

}
