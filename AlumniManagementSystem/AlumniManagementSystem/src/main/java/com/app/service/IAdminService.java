package com.app.service;

import java.util.List;

import com.app.pojos.Admin;
import com.app.pojos.User;


public interface IAdminService {
	//list of all Admin
		List<Admin> getAllAdmin();
		Admin addAdminDetails(Admin transientPOJO);
		Admin updateAdminDetails(Admin detachedPOJO,int adminId);
		//Admin deleteStudentById(int adminId);
		
		Admin authenticateAdmin(String email, String password);

}
