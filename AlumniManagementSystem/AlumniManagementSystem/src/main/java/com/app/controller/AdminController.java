package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginDto;
import com.app.dto.ResponseDTO;
import com.app.pojos.Admin;
import com.app.service.IAdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IAdminService service;

	public AdminController() {
		System.out.println("In constr of::"+ getClass().getName());
	}
	
	 @GetMapping
	  public ResponseEntity<?> listAllAdminEntity(){
		  System.out.println("In list all Admin");
		  List<Admin> admin=service.getAllAdmin();
		  if(admin.isEmpty())
		  {
			  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
		  return new ResponseEntity<>(admin,HttpStatus.OK);
	  }
	 
	//req handling method to create a new Admin details : post
			@PostMapping
			public ResponseEntity<?> addAdmin(@RequestBody Admin a)
			{
				System.out.println("in add Admin"+a);
					try {
						Admin savedAdmin = service.addAdminDetails(a);
						return new ResponseEntity<>(savedAdmin,HttpStatus.OK);
					}catch (RuntimeException e) {
						e.printStackTrace();
						return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
					}
						
			}
	
			//request  handling method to update existing admin
			@PutMapping("/{adminId}")
			public ResponseEntity<?> updateStudentDetails(@PathVariable int adminId,@RequestBody Admin a)
			{
				System.out.println("in update"+a);
				try {
					Admin updatedetails=service.updateAdminDetails(a, adminId);
					return new ResponseEntity<>(updatedetails,HttpStatus.OK);
				}catch (RuntimeException e) {
					e.printStackTrace();
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
			}
	
			@PostMapping("/login")
			  public ResponseEntity<?> authenticateStudent(@RequestBody LoginDto dto){
				  System.out.println("In authenticate Admin"+dto.getEmail()+dto.getPassword());
				  Admin a = service.authenticateAdmin(dto.getEmail(), dto.getPassword());
				  if(a == null)
				  {
					  return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
				  }
					  return new ResponseEntity<>(new ResponseDTO("success", "Successfull Admin Login", a),HttpStatus.OK);
					  //new ResponseDTO("success", "Successfull Student Login", s),
				 
				  
			  }
}
