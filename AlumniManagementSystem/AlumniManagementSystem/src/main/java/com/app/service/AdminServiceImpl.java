package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_excs.StudentNotFoundException;
import com.app.dao.IAdminDao;
import com.app.pojos.Admin;
import com.app.pojos.User;
@Service
@Transactional
public class AdminServiceImpl implements IAdminService{
	
	@Autowired
	private IAdminDao dao;
	
	@Override
	public List<Admin> getAllAdmin() {
		System.out.println("in admin service getALL"+getClass().getName());
		return dao.findAll();
	}

	@Override
	public Admin addAdminDetails(Admin transientPOJO) {
		System.out.println("In Admin service impl save");
		return dao.save(transientPOJO);
	}

	@Override
	public Admin updateAdminDetails(Admin a1, int adminId) {
		System.out.println("In Admin service impl updaate");
		// check if student exist
				Optional<Admin> a = dao.findById(adminId);
				if (a.isPresent()) {
					// s.get() : PERSISTENT
					// s1 : detached POJO : contain the updates sent by client
					// change the state of persistent pojo
					Admin admin = a.get();
					admin.setEmail(a1.getEmail());
					admin.setAdminId(a1.getAdminId());
					admin.setFirstName(a1.getFirstName());
					admin.setLastName(a1.getLastName());
					admin.setContactNo(a1.getContactNo());
					admin.setPassword(a1.getPassword());
					return admin;
				}
				
				// in case of no Student find : throw custom exception
				throw new StudentNotFoundException("invalid Admin");
	}

	@Override
	public Admin authenticateAdmin(String email, String password) {
		return dao.findByEmailAndPassword(email,password);
	}





}
