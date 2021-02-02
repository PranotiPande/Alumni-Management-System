package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excs.StudentNotFoundException;
import com.app.dao.IBatchDao;
import com.app.pojos.Batch;

@Service
@Transactional
public class BatchServiceImpl implements IBatchService {
	
	@Autowired
	private IBatchDao dao;


	/*@Override
	public List<Batch> getAllBatches() {
		// TODO Auto-generated method stub
		return dao.getAllBatches();
	}*/


	@Override
	public Batch addBatch(Batch transientPOJO) {
		System.out.println("In Batch service impl save");
		return dao.save(transientPOJO);
		
	}


	@Override
	public List<Batch> getAllBatches() {
		System.out.println("in batch service getALL"+getClass().getName());
		return dao.findAll();
	}

	@Override
	public Batch updateBatchDetails(Batch b1, int batchId) {
		System.out.println("In Batch service impl update");
		// check if student exist
		Optional<Batch> b = dao.findById(batchId);
		if (b.isPresent()) {
			// s.get() : PERSISTENT
			// s1 : detached POJO : contain the updates sent by client
			// change the state of persistent pojo
			Batch batch = b.get();
			batch.setPassingYear(b1.getPassingYear());
			return batch;
		}
		throw new StudentNotFoundException("invalid Batch");
	}

}
