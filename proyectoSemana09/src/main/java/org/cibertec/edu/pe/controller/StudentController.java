package org.cibertec.edu.pe.controller;

import java.util.List;

import org.cibertec.edu.pe.model.Student;
import org.cibertec.edu.pe.repository.IStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private IStudent student;
	
	@GetMapping
	public List<Student> list(){
		return student.findAll();
	}
}
