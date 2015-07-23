package com.garmin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.garmin.business.FacultyBusinessServices;
import com.garmin.model.StudentBO;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private FacultyBusinessServices facultyBusinessServices;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public StudentBO getStudentById(@PathVariable int id) {
		return facultyBusinessServices.getStudentById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public List<StudentBO> listAllStudents() {
		return facultyBusinessServices.listAllStudents();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
	public void addStudent() {
		facultyBusinessServices.addStudent("Prima incercare");
		System.out.println("sadasd");
	}
}