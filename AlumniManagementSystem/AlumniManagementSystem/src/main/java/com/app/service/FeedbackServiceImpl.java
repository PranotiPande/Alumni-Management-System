package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excs.FeedbackNotFoundException;
import com.app.dao.IFeedbackDao;
import com.app.pojos.Feedback;


@Service
@Transactional
public class FeedbackServiceImpl implements IFeedbackService{

	@Autowired
	private IFeedbackDao dao;
	@Override
	public List<Feedback> getAllFeedback() {
		System.out.println("in feedback service getALL"+getClass().getName());
		return dao.findAll();
	}

	@Override
	public Feedback InsertFeedback(Feedback transientPOJO) {
		System.out.println("in feedback service insert "+getClass().getName());
		return dao.save(transientPOJO);
	}

	

	@Override
	public Feedback updateFeedback(Feedback detachedPOJO,int feedbackId) {
		System.out.println("In Feedback service impl update");
		// check if student exist
		Optional<Feedback> f = dao.findById(feedbackId);
		if (f.isPresent()) {
			// f.get() : PERSISTENT
			//  : detached POJO : contain the updates sent by client
			// change the state of persistent pojo
			Feedback feedback = f.get();
			feedback.setDescription(feedback.getDescription());
			feedback.setFeedbackDate(feedback.getFeedbackDate());
			return feedback;
		}

		// in case of no Student find : throw custom exception
		throw new FeedbackNotFoundException("Invalid Feedback");

	}


	

}
