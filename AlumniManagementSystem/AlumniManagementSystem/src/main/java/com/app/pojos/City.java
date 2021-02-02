package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cityId;
	
	//city has state
	//@ManyToOne
	//@JoinColumn(name = "stateId")
	private Integer stateId;
	
	@Column(length = 30)
	private String cityName;

	public City() {
		super();
		System.out.println("In Constructor " + getClass().getName());

	}

	public City(Integer cityId, Integer state, String cityName) {
		super();
		this.cityId = cityId;
		this.stateId = state;
		this.cityName = cityName;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer state) {
		this.stateId = state;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	
	
}
