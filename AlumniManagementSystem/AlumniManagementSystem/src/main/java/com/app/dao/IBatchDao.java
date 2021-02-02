package com.app.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Batch;


public interface IBatchDao extends JpaRepository<Batch, Integer> {
	//List<Batch> getAllBatches();
	
	//Optional<Batch> findByPassingYear(int passingYear);
	
}
