package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Feedback;

public interface IFeedbackDao extends JpaRepository<Feedback, Integer>{
	

}
