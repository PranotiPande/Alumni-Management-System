package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class State {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer stateId;
	
	//containment: country has state
	
   // @ManyToOne
	//@JoinColumn(name="countryId")
	private Integer countryId;
	
	@Column(length = 30)
	private String stateName;

	public State() {
		super();
		System.out.println("In Constructor " + getClass().getName());

	}

	public State(Integer stateId, Integer country, String stateName) {
		super();
		this.stateId = stateId;
		this.countryId = country;
		this.stateName = stateName;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer country) {
		this.countryId = country;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

}
