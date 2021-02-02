package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.AlumniJobDetails;

public interface IAlumniJobDetails extends JpaRepository<AlumniJobDetails, Integer>{
	
	
	@Query("SELECT a FROM AlumniJobDetails a INNER JOIN User u  ON  a.ID=u.ID where a.ID=:id")
	AlumniJobDetails getAlumniJobDetailsByUserId(int id);

}
