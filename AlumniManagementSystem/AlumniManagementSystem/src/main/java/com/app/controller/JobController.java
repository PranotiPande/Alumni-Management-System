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

import com.app.pojos.Job;
import com.app.service.IJobService;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/job")
public class JobController {


	@Autowired
	private IJobService service;
	
	public JobController() {
		System.out.println("In Constructor of :: "+getClass().getName());
	}


	//get all feedback list
		@GetMapping
		  public ResponseEntity<?> listAllJobVacancy(){
			  System.out.println("In list all job");
			  List<Job> job=service.getAllJobVacancy();
			  if(job.isEmpty())
			  {
				  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			  }		  
			  return new ResponseEntity<>(job,HttpStatus.OK);
		  }

		
		// req handling method to create new job :post
		@PostMapping
		public ResponseEntity<?> addJobVacancyDetails(@RequestBody Job j) {
					System.out.println("in Add feedback :: " + j);
				try {
					Job saveJob = service.addJobVacancy(j);
					return new ResponseEntity<>(saveJob, HttpStatus.OK);
				} catch (RuntimeException e) {
					e.printStackTrace();
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}

		@PutMapping("/{jobId}")
		public ResponseEntity<?> updateJobDetails(@PathVariable int jobId,@RequestBody Job j)
		{
			System.out.println("in update"+j);
			try {
				Job updatedetails=service.updateJobVacancyDetails(j,jobId);
				return new ResponseEntity<>(updatedetails,HttpStatus.OK);
			}catch (RuntimeException e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
}
