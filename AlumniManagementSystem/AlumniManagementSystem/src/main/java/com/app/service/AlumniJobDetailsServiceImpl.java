package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.AlumniJobDetails;
import com.app.pojos.User;
import com.app.custom_excs.StudentNotFoundException;
import com.app.dao.IAlumniJobDetails;

@Service
@Transactional
public class AlumniJobDetailsServiceImpl implements IAlumniJobDetailsService {

	@Autowired
	private IAlumniJobDetails dao;

	@Override
	public List<AlumniJobDetails> getAllAlumniJobDetails() {
		System.out.println("in alumnijobdetails service getALL"+getClass().getName());
		return dao.findAll();
	}

	@Override
	public AlumniJobDetails addAlumniJobDetails(AlumniJobDetails transientPOJO) {
		System.out.println("In job details service impl save");
		return dao.save(transientPOJO);
	}

	@Override
	public AlumniJobDetails updateAlumniJobDetails(AlumniJobDetails j1, int jobId) {
		System.out.println("In student service impl updaate");
		// check if student exist
				Optional<AlumniJobDetails> j = dao.findById(jobId);
				if (j.isPresent()) {
					// s.get() : PERSISTENT
					// s1 : detached POJO : contain the updates sent by client
					// change the state of persistent pojo
					AlumniJobDetails job = j.get();
					job.setCompanyName(j1.getCompanyName());
					job.setDesignation(j1.getDesignation());
					job.setJoinDate(j1.getJoinDate());
					job.setLeavingDate(j1.getLeavingDate());
					return job;
				}
				
				// in case of no Student find : throw custom exception
				throw new StudentNotFoundException("invalid student");

	}

	@Override
	public AlumniJobDetails getAlumniJobDetailsById(int ID) {
		return dao.getAlumniJobDetailsByUserId(ID);
	}

	

	

	

}
