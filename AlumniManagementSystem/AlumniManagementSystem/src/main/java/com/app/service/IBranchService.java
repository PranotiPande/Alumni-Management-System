package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Branch;
import com.app.pojos.City;

public interface IBranchService {


	//get All Branches
		List<Branch> getAllBranches();
		
		//Insert new branch		
		Branch  addBranch(Branch transientPOJO);
		
		 //Update existing branch details
		Branch updateBranchDetails(Branch b1,int branchId);
		Optional<Branch> getById( Integer branchId);
		
}
