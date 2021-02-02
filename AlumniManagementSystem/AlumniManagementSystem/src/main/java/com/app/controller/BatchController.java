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

import com.app.pojos.Batch;
import com.app.service.IBatchService;
@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/batches")
public class BatchController {
	@Autowired
	private IBatchService service;

	public BatchController() {
		System.out.println("In constr of " + getClass().getName());
	}
	
	 /* @PostMapping 
	  public ResponseEntity<?> addBatch(@RequestBody Batch b) {
	  System.out.println("in add Batch"+b); try { Batch savedBatch =
	  service.addBatch(b); return new ResponseEntity<>(savedBatch,HttpStatus.OK);
	  }catch (RuntimeException e) { e.printStackTrace(); return new
	  ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); }
	  
	  }*/
	  
	  @GetMapping
	  public ResponseEntity<?> listAllBatch(){
		  System.out.println("In list all batch");
		  List<Batch> batches=service.getAllBatches();
		  if(batches.isEmpty())
		  {
			  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			 
		  }
		  
		  return new ResponseEntity<>(batches,HttpStatus.OK);
	  }
	 
	  @PostMapping
		public ResponseEntity<?> addBatchDetais(@RequestBody Batch b) {
			System.out.println("in add Batch" + b);
			try {
				Batch savedBatch = service.addBatch(b);
				return new ResponseEntity<>(savedBatch, HttpStatus.OK);
			} catch (RuntimeException e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		@PutMapping("/{batchId}")
		public ResponseEntity<?> updateBatchDetails(@PathVariable int batchId, @RequestBody Batch b) {
			System.out.println("in update" + b);
			try {
				Batch updatedetails = service.updateBatchDetails(b, batchId);
				return new ResponseEntity<>(updatedetails, HttpStatus.OK);
			} catch (RuntimeException e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}


}
