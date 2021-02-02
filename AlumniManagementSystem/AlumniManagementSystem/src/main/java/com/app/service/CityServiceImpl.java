package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICityDao;
import com.app.pojos.City;


@Service
@Transactional
public class CityServiceImpl  implements ICityservice{

	@Autowired
	private ICityDao dao;
	
	@Override
	public Optional<City> getById(Integer cityId) {
		// TODO Auto-generated method stub
		return dao.findById(cityId);
	}

}
