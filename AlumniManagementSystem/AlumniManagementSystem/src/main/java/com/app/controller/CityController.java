package com.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.City;
import com.app.service.ICityservice;


@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/students")
public class CityController {
	@Autowired
	private ICityservice service;
	
	@GetMapping("/city/{cityId}")
	public ResponseEntity<?> getCityById(@PathVariable int cityId)
	{
		System.out.println("in get by id city");
		try {
			
			Optional<City> c=service.getById(cityId);
			return new ResponseEntity<>(c,HttpStatus.OK);
				
		}catch(RuntimeException e) {
		e.printStackTrace();
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
