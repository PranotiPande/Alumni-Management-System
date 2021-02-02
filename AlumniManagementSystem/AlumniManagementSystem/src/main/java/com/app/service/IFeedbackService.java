package com.app.service;

import java.util.List;

import com.app.pojos.Feedback;


public interface IFeedbackService {
	//list of all students
	List<Feedback> getAllFeedback();
	
	//
	Feedback InsertFeedback(Feedback transientPOJO);
	
	Feedback updateFeedback(Feedback detachedPOJO,int feedbackId);
	//Feedback deleteFeedbackById(int feedbackId);
}
