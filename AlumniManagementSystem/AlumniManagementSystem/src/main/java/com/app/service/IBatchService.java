package com.app.service;

import java.util.List;

import com.app.pojos.Batch;
import com.app.pojos.Branch;

public interface IBatchService {
		//list of all batches
	List<Batch> getAllBatches();
			
	Batch  addBatch(Batch transientPOJO);
	
	 //Update existing branch details
		Batch updateBatchDetails(Batch b1,int batchId);
}