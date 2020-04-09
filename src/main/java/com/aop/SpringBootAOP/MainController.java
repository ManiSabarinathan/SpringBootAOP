package com.aop.SpringBootAOP;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Student getStudent(@PathVariable String id ) {
		return  studentService.getStudentById(id);
	}

}
