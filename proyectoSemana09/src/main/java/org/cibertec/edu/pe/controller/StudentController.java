package org.cibertec.edu.pe.controller;

import java.util.List;

import org.cibertec.edu.pe.model.Student;
import org.cibertec.edu.pe.repository.IStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping
	public void insert(@RequestBody Student s) {
		student.save(s);
	}
	
	@PutMapping
	public void update(@RequestBody Student s) {
		student.save(s);
	}
	
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable("id") int id) {
		student.deleteById(id);
	}
}
