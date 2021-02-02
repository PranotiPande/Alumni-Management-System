package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excs.StudentNotFoundException;
import com.app.dao.IJobDao;
import com.app.pojos.Job;
import com.app.pojos.User;

@Service
@Transactional
public class JobServiceImpl implements IJobService {

	@Autowired
	private IJobDao dao;
	
	@Override
	public List<Job> getAllJobVacancy() {
		System.out.println("in Job service getALL"+getClass().getName());
		return dao.findAll();
	}

	@Override
	public Job addJobVacancy(Job transientPOJO) {
		System.out.println("In job service impl save");
		return dao.save(transientPOJO);
	}

	@Override
	public Job updateJobVacancyDetails(Job detachedPOJO, int jobId) {
		System.out.println("in job service impl...");
		//check if job exist
		Optional<Job> j=dao.findById(jobId);
		if(j.isPresent()) {
			Job job=j.get();
			job.setDescription(detachedPOJO.getDescription());
			job.setTitle(detachedPOJO.getTitle());
			job.setStartDate(detachedPOJO.getStartDate());
			job.setEndDate(detachedPOJO.getEndDate());
		}
		return null;
	}

	@Override
	public Job deleteJobVacancy(int jobId) {
		// TODO Auto-generated method stub
		return null;
	}

}
