package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.AlumniJobDetails;
import com.app.pojos.User;

public interface IAlumniJobDetailsService {
	
	List<AlumniJobDetails> getAllAlumniJobDetails();
	
	//
	AlumniJobDetails addAlumniJobDetails(AlumniJobDetails transientPOJO);
	
	//Update existing alumni job details
	AlumniJobDetails updateAlumniJobDetails(AlumniJobDetails detachedPOJO,int studentId);
	
	AlumniJobDetails getAlumniJobDetailsById(int ID);
	
	

}
