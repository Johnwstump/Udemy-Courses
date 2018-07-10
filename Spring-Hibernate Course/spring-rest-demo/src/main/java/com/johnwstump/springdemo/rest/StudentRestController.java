package com.johnwstump.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.johnwstump.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students;
	
	@PostConstruct
	private void loadData() {
		students = new ArrayList<Student>();
		students.add(new Student("Poornima", "Patel"));
		students.add(new Student("Mario", "Rossi"));
		students.add(new Student("Mary", "Smith"));
	}
	
	// Define an endpoint for "/students" - return list of students
	@GetMapping("/students")
	public List<Student> getStudents(){
		return students;

	}
	
	// Define an endpoint for "/students/{studentIs}" - return student at Index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		if (studentId >= students.size() || studentId < 0) {
			throw new StudentNotFoundException("Student id not found - " + studentId); 
		}
		return students.get(studentId);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex){
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception ex){
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
