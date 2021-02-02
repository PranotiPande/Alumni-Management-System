package com.app.service;

import java.util.List;

import com.app.pojos.Job;

public interface IJobService {

	//list of all Job Vacancy
	List<Job> getAllJobVacancy();
	
	//
	Job addJobVacancy(Job transientPOJO);
	
	//Update existing job details
	Job updateJobVacancyDetails(Job detachedPOJO,int jobId);
	Job deleteJobVacancy(int jobId);
	
}
