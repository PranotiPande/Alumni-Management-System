package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excs.StudentNotFoundException;
import com.app.dao.IBranchDao;
import com.app.pojos.Branch;

@Service
@Transactional
public class BranchServiceImpl implements IBranchService {

	@Autowired
	private IBranchDao dao;

	@Override
	public List<Branch> getAllBranches() {
		System.out.println("In Branch service impl getAllBranches");
		return dao.findAll();
	}

	@Override
	public Branch addBranch(Branch transientPOJO) {
		System.out.println("In Branch service impl save");
		return dao.save(transientPOJO);
	}

	@Override
	public Branch updateBranchDetails(Branch b1, int branchId) {
		System.out.println("In Event service impl update");
		// check if student exist
		Optional<Branch> b = dao.findById(branchId);
		if (b.isPresent()) {
			// s.get() : PERSISTENT
			// s1 : detached POJO : contain the updates sent by client
			// change the state of persistent pojo
			Branch branch = b.get();
			branch.setBranchName(b1.getBranchName());
			return branch;
		}
		throw new StudentNotFoundException("invalid Branch");

	}

	@Override
	public Optional<Branch> getById(Integer branchId) {
		return dao.findById(branchId);
	}

	

	


}
