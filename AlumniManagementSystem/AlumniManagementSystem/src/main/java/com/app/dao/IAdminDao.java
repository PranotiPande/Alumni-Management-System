package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Admin;
import com.app.pojos.User;

public interface IAdminDao extends JpaRepository<Admin, Integer>{
	Admin findByEmailAndPassword(String email,String password);
	//Student findByEmail(String email);

}
