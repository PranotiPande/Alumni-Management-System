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

import com.app.pojos.Branch;
import com.app.pojos.City;
import com.app.service.IBranchService;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/branches")
public class BranchController {
	@Autowired
	private IBranchService service;
	
	 @GetMapping
	  public ResponseEntity<?> listAllBatch(){
		  System.out.println("In list all batch");
		  List<Branch> batches=service.getAllBranches();
		  if(batches.isEmpty())
		  {
			  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			 
		  }
		  
		  return new ResponseEntity<>(batches,HttpStatus.OK);
	  }
	 
	// req handling mthod to create new Batch :post
		@PostMapping
		public ResponseEntity<?> addBranchDetails(@RequestBody Branch b) {
		System.out.println("In add Branch:: " + b);
			try {
					Branch saveProduct = service.addBranch(b);
					return new ResponseEntity<>(saveProduct, HttpStatus.OK);
				} catch (RuntimeException e) {
					e.printStackTrace();
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
		}
		
		@PutMapping("/{branchId}")
		public ResponseEntity<?> updateBranchDetails(@PathVariable int branchId,@RequestBody Branch b)
			{
				System.out.println("in update"+b);
				try {
						Branch updatedetails=service.updateBranchDetails(b,branchId);
						return new ResponseEntity<>(updatedetails,HttpStatus.OK);
					}
				catch (RuntimeException e) {
						e.printStackTrace();
						return new ResponseEntity<>(HttpStatus.NOT_FOUND);
					}
			}
		
		
		@GetMapping("/{branchId}")
		public ResponseEntity<?> getCityById(@PathVariable int branchId)
		{
			System.out.println("in get by id branch");
			try {
				
				Optional<Branch> c=service.getById(branchId);
				return new ResponseEntity<>(c,HttpStatus.OK);
					
			}catch(RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		

	

}
