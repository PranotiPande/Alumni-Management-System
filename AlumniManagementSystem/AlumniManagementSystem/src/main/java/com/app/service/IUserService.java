package com.app.service;
import java.util.List;
import java.util.Optional;

import com.app.pojos.*;

public interface IUserService {

	//list of all students
	List<User> getAllStudents();
	
	//
	User addStudentDetails(User transientPOJO);
	
	//Update existing student details
	User updateStudentDetails(User detachedPOJO,int studentId);
	
	
	User authenticateStudent(String email, String password);
	Optional<User> getByStudentId(int studentId);
	Optional<User> deleteStudentById(int studentId);
	 
	//list all alumni
	List<User> getAllAlumni();
	List<User> getAllStudentsByRole();

}
