package com.app.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.IUserDao;
import com.app.dto.LoginDto;
import com.app.dto.ResponseDTO;
import com.app.pojos.User;
import com.app.service.IUserService;
import com.app.dto.ImageDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/students")
public class UserController {
	@Value("${file.upload.location}")
	private String location;
	@Autowired
	private IUserService service;
	
	@Autowired
	private IUserDao dao;

	public UserController() {
		System.out.println("In constr of::"+ getClass().getName());
	}
	  @GetMapping
	  public ResponseEntity<?> listAllStudeEntity(){
		  System.out.println("In list all batch");
		  List<User> batches=service.getAllStudents();
		  if(batches.isEmpty())
		  {
			  return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
		  return new ResponseEntity<>(batches,HttpStatus.OK);
	  }
	
	// req handling mthod to create new student :post
	/*	@PostMapping
		public ResponseEntity<?> addStudentDetails(@RequestBody User s) {
			System.out.println("iin add product " + s);
			try {
				User saveProduct = service.addStudentDetails(s);
				return new ResponseEntity<>(saveProduct, HttpStatus.OK);
			} catch (RuntimeException e) {
				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}*/
	
		/*
		 * @GetMapping("/{studentId}") public ResponseEntity<?>
		 * deleteStudentById(@PathVariable int sid,@RequestBody Student s) {
		 * System.out.println("in del "+sid+ " "+s); try { Student
		 * delProduct=service.deleteStudentById(sid); return new
		 * ResponseEntity<>(HttpStatus.OK);
		 * 
		 * }catch (RuntimeException e) { e.printStackTrace(); return new
		 * ResponseEntity<>(HttpStatus.NOT_FOUND); } }
		 */
	
		@PostMapping("/login")
		  public ResponseEntity<?> authenticateStudent(@RequestBody LoginDto dto){
			  System.out.println("In authenticate student"+dto.getEmail()+dto.getPassword());
			  User s = service.authenticateStudent(dto.getEmail(), dto.getPassword());
			  if(s == null)
			  {
				  return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			  }
				  return new ResponseEntity<>(new ResponseDTO("success", "Successfull Student Login", s),HttpStatus.OK);
				  //new ResponseDTO("success", "Successfull Student Login", s),
			 
			  
		  }
		
		//request  handling method to update existing student
				@PutMapping("/{studentId}")
				public ResponseEntity<?> updateStudentDetails(@PathVariable int studentId,@RequestBody User s)
				{
					System.out.println("in update"+s);
					try {
						User updatedetails=service.updateStudentDetails(s,studentId);
						return new ResponseEntity<>(updatedetails,HttpStatus.OK);
					}catch (RuntimeException e) {
						e.printStackTrace();
						return new ResponseEntity<>(HttpStatus.NOT_FOUND);
					}
				}
				
				@GetMapping("{studentId}")
				public ResponseEntity<?> getStudentDetailsById(@PathVariable int studentId)
				{
					System.out.println("in get by id student");
					try {
						Optional<User> s=service.getByStudentId(studentId);
						return new ResponseEntity<>(s,HttpStatus.OK);
					}catch (RuntimeException e) {
						e.printStackTrace();
						return new ResponseEntity<>(HttpStatus.NOT_FOUND);
					}
				}

				
				
				//add a method to upload User details in JSON format n multipart image file , to save in DB
				//Tested with angular front end n postman
				@PostMapping("/upload")
				public ResponseDTO fileUploadWithParams(@RequestParam String dtls, @RequestParam MultipartFile imageFile) {
					System.out.println("data " + dtls + " " + imageFile.getOriginalFilename());
					try {
						//un marshalling json--> java
						User u = new ObjectMapper().readValue(dtls, User.class);
						u.setImage(imageFile.getBytes());
						u.setImageContentType(imageFile.getContentType());

						//imageFile.transferTo(new File(location, imageFile.getOriginalFilename()));
						System.out.println("user dtls " + u);
						dao.save(u);

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return new ResponseDTO("File uploaded :" + imageFile.getOriginalFilename() + " @ ", LocalDateTime.now());
				}
				
				
				//Add Method to download image from DB in angular front end , with specified user id
				@GetMapping("/download/{userId}")
				public ResponseEntity<?> downloadImage(@PathVariable int userId) throws IOException {
					System.out.println("in img download " + userId);
					User u = dao.findById(userId).get();
//					Path path = Paths.get(location, imgName);
					ImageDTO img = new ImageDTO();
					// img.setName(imgName);
					img.setData(u.getImage());
					img.setType(u.getImageContentType());
//					System.out.println(img.getType());

					return new ResponseEntity<>(img, HttpStatus.OK);

				}

				@DeleteMapping("/{studentId}")
				public ResponseEntity<?> deleteProductDetails(@PathVariable int studentId) {
					System.out.println("in delete emp " + studentId);
					// check if emp exists
					try {
						Optional<User> deletes = service.deleteStudentById(studentId);
						return new ResponseEntity<>(deletes, HttpStatus.OK);
					} catch (RuntimeException e) {
						e.printStackTrace();
						return new ResponseEntity<>(HttpStatus.NOT_FOUND);
					}

				}

				
				//get all students
				@GetMapping("/alumni")
				public ResponseEntity<?> fetchAllAlumni(){
					System.out.println("Fetching all alumni...");
					List<User> alumni = service.getAllAlumni();
					if (alumni.isEmpty()) {
						return new ResponseEntity<>(HttpStatus.NO_CONTENT);
					}
					return new ResponseEntity<>(alumni, HttpStatus.OK);
				}
				//get all students
					@GetMapping("/student")
					public ResponseEntity<?> fetchAllStudents(){
						System.out.println("Fetching all students...");
						List<User> students = service.getAllStudentsByRole();
						if (students.isEmpty()) {
							return new ResponseEntity<>(HttpStatus.NO_CONTENT);
						}
						return new ResponseEntity<>(students, HttpStatus.OK);
					}
		
				
}
