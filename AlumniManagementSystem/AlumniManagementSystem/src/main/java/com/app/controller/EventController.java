package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Event;
import com.app.pojos.User;
import com.app.service.IEventService;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("events")
public class EventController {
	
	@Autowired
	private IEventService service;
	
	public  EventController() {
		System.out.println("In Constructor of :: "+getClass().getName());
	}
	
	//get all Events 
	@GetMapping
	  public ResponseEntity<?> listAllEvents(){
		  System.out.println("In list all batch");
		  List<Event> batches=service.getAllEvents();
		  if(batches.isEmpty())
		  {
			  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }		  
		  return new ResponseEntity<>(batches,HttpStatus.OK);
	  }
	
	// req handling method to create new event :post
	@PostMapping
	public ResponseEntity<?> addEventDetails(@RequestBody Event event) {
				System.out.println("in Add Event :: " + event);
			try {
				Event saveProduct = service.addEvent(event);
				return new ResponseEntity<>(saveProduct, HttpStatus.OK);
			} catch (RuntimeException e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
	@PutMapping("/{eventId}")
	public ResponseEntity<?> updateEventDetails(@PathVariable int eventId,@RequestBody Event e1)
	{
		System.out.println("in update"+e1);
		try {
			Event updatedetails=service.updateEventDetails(e1, eventId);
			return new ResponseEntity<>(updatedetails,HttpStatus.OK);
		}
		catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
