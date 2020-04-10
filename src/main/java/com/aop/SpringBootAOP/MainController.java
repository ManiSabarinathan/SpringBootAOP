package com.aop.SpringBootAOP;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/allstudents")
	public List<Student> getAllStudent() {
		return  studentService.getAllStudents();
		
	}
	
	@GetMapping("/getStudent/{id}")
	public ResponseEntity<Optional<Student>> getStudent(@PathVariable String id ) {
		try {
			return new ResponseEntity<Optional<Student>>(studentService.getStudentById(id), HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Optional<Student>>(HttpStatus.NOT_FOUND);
		}
		
	}

}
