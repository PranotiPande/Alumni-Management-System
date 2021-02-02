package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.custom_excs.StudentNotFoundException;
import com.app.dao.IUserDao;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao dao;
	
	
	@Override
	public List<User> getAllStudents() {
		System.out.println("in batch service getALL"+getClass().getName());
		return dao.findAll();
	}

	@Override
	public User addStudentDetails(User transientPOJO) {
		System.out.println("In Batch service impl save");
		return dao.save(transientPOJO);
	}


	@Override
	public User updateStudentDetails(User s1,int studentId) {
		System.out.println("In student service impl updaate");
		// check if student exist
				Optional<User> s = dao.findById(studentId);
				if (s.isPresent()) {
					// s.get() : PERSISTENT
					// s1 : detached POJO : contain the updates sent by client
					// change the state of persistent pojo
					User student = s.get();
					student.setFirstName(s1.getFirstName());
					student.setLastName(s1.getLastName());
					student.setRole(s1.getRole());
					student.setDOB(s1.getDOB());
					student.setAddress(s1.getAddress());
					return student;
				}
				
				// in case of no Student find : throw custom exception
				throw new StudentNotFoundException("invalid student");

	}


		
	
		@Override
		public User authenticateStudent(String email,String password) {
		// TODO Auto-generated method stub
			return dao.findByEmailAndPassword(email,password);
			/*Student s=dao.findByEmail(email);
			//Optional<Student> s2=dao.findByPassword(password);
			System.out.println("***********here from service: "+s1);
			System.out.println("email::"+email);
			System.out.println("password::"+password);
			if(s1.isPresent()) {
				return s;
			}
			
			throw new StudentNotFoundException("invalid student");*/

		}

		@Override
		public Optional<User> getByStudentId(int studentId) {
			// TODO Auto-generated method stub
			return dao.findById(studentId);
		}
		
		@Override
		public Optional<User> deleteStudentById(int studentId) {
			
			// check if student exist
					Optional<User> s = dao.findById(studentId);
					System.out.println("From service "+s);
					if (s.isPresent()) {
						dao.deleteById(studentId);
						return s;
					} 
					throw new StudentNotFoundException("invalid student");
					
					
		}
		
		@Override
		public List<User> getAllAlumni() {
			// TODO Auto-generated method stub
			return dao.findByRoleAlumni();
		}


		@Override
		public List<User> getAllStudentsByRole() {
			// TODO Auto-generated method stub
			return dao.findByRoleStudent();
		}


}
