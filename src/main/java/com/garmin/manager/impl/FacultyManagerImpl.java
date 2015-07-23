package com.garmin.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.garmin.dao.StudentDAO;
import com.garmin.dao.model.StudentDTO;
import com.garmin.manager.FacultyManager;
import com.garmin.model.StudentBO;
import com.garmin.util.Translator;

public class FacultyManagerImpl implements FacultyManager {

	private StudentDAO studentDAO;

	@Autowired
	public FacultyManagerImpl(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	public StudentDTO getStudentById(int id) {
		return studentDAO.getStudentById(id);
	}

	public List<StudentDTO> listAllStudents() {
		return studentDAO.listAllStudents();
	}

	public void addStudent(StudentDTO studentDTO) {
	studentDAO.addStudent(studentDTO);
		
	}

}
