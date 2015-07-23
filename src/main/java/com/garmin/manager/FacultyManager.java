package com.garmin.manager;

import java.util.List;

import com.garmin.dao.model.StudentDTO;

public interface FacultyManager {
	public StudentDTO getStudentById(int id);
	public List<StudentDTO> listAllStudents();
	public void addStudent(StudentDTO studentDTO);

}
