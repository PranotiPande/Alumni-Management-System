package com.app.controller;

import java.util.List;
import java.util.Optional;

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
import com.app.pojos.AlumniJobDetails;
import com.app.service.IAlumniJobDetailsService;


@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/alumnijobdetails")
public class AlumniJobDetailsController {

	@Autowired
	private IAlumniJobDetailsService service;
	
	 public AlumniJobDetailsController() {
		System.out.println("In constr of::"+ getClass().getName());
	}
	
	 
	 @GetMapping
	  public ResponseEntity<?> listAllJobEntity(){
		  System.out.println("In list all Job details");
		  List<AlumniJobDetails> job=service.getAllAlumniJobDetails();
		  if(job.isEmpty())
		  {
			  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
		  return new ResponseEntity<>(job,HttpStatus.OK);
	  }
		
	// request handling method to create new job :post
			@PostMapping
			public ResponseEntity<?> addJobDetails(@RequestBody AlumniJobDetails j) {
				System.out.println("iin add product " + j);
				try {
					AlumniJobDetails saveJob = service.addAlumniJobDetails(j);
					return new ResponseEntity<>(saveJob, HttpStatus.OK);
				} catch (RuntimeException e) {
					e.printStackTrace();
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			
			
			@PutMapping("/{alumnijobId}")
			public ResponseEntity<?> updateStudentDetails(@PathVariable int alumnijobId,@RequestBody AlumniJobDetails j)
			{
				System.out.println("in update"+j);
				try {
					AlumniJobDetails updatedetails=service.updateAlumniJobDetails(j, alumnijobId);
					return new ResponseEntity<>(updatedetails,HttpStatus.OK);
				}catch (RuntimeException e) {
					e.printStackTrace();
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			}
			
			
			@GetMapping("{ID}")
			public ResponseEntity<?> getAlumniJobDetailsById(@PathVariable int ID) {
				System.out.println("in get by id alumni job details");
				try {
					AlumniJobDetails s = service.getAlumniJobDetailsById(ID);
					if(s == null)
					{
						return new ResponseEntity<>(s,HttpStatus.NO_CONTENT);
					}
					return new ResponseEntity<>(s, HttpStatus.OK);
				} catch (RuntimeException e) {
					e.printStackTrace();
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			}

			
}
