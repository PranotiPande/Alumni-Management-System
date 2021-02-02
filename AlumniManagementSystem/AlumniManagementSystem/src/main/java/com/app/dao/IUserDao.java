package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import com.app.pojos.User;

public interface IUserDao extends JpaRepository<User, Integer>{
	
	User findByEmailAndPassword(String email,String password);
	//Student findByEmail(String email);
	
	@Query("SELECT r FROM User r WHERE r.role='ALUMNI'")
	 List<User> findByRoleAlumni();
	
	@Query("SELECT r FROM User r WHERE r.role='STUDENT'")
	 List<User> findByRoleStudent();

	
}
