package com.aop.SpringBootAOP;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

	public List<Student> getAllStudents() {
		return Arrays.asList(new Student("100","Juju","8"),new Student("200","Papu","26"),new Student("300","saba","38") );
	}
	
	public Student getStudentById(String id) {
		return Arrays.asList(new Student("100","Juju","8"),new Student("200","Papu","26"),new Student("300","saba","38") )
				.stream().filter(student -> student.getId().equals(id)).findFirst().get();	
			
	}
	
}
