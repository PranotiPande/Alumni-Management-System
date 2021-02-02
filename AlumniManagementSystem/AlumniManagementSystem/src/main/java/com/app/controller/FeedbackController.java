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
import com.app.pojos.Feedback;
import com.app.pojos.User;
import com.app.service.IFeedbackService;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	
	@Autowired
	private IFeedbackService service;

	public FeedbackController() {
		
		System.out.println("In Constructor of :: "+getClass().getName());
	}
	
	//get all feedback list
		@GetMapping
		  public ResponseEntity<?> listAllFeedback(){
			  System.out.println("In list all feedback");
			  List<Feedback> feedback=service.getAllFeedback();
			  if(feedback.isEmpty())
			  {
				  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  }		  
			  return new ResponseEntity<>(feedback,HttpStatus.OK);
		  }
		
		// req handling method to create new feedback :post
		@PostMapping
		public ResponseEntity<?> addFeedbackDetails(@RequestBody Feedback fd) {
					System.out.println("in Add feedback :: " + fd);
				try {
					Feedback saveFeedback = service.InsertFeedback(fd);
					return new ResponseEntity<>(saveFeedback, HttpStatus.OK);
				} catch (RuntimeException e) {
					e.printStackTrace();
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}

		@PutMapping("/{feedbackId}")
		public ResponseEntity<?> updateStudentDetails(@PathVariable int feedbackId,@RequestBody Feedback f)
		{
			System.out.println("in update"+f);
			try {
				Feedback updatedetails=service.updateFeedback(f, feedbackId);
				return new ResponseEntity<>(updatedetails,HttpStatus.OK);
			}catch (RuntimeException e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
}
