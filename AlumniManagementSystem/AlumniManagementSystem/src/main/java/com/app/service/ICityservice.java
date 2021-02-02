package com.app.service;

import java.util.Optional;

import com.app.pojos.City;

public interface ICityservice {
	
	Optional<City> getById( Integer cityId);

}
