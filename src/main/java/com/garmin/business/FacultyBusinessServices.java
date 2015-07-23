package com.garmin.business;

import java.util.List;

import com.garmin.model.StudentBO;

public interface FacultyBusinessServices {

	public StudentBO getStudentById(int id);
	public List<StudentBO> listAllStudents();
	public void addStudent(String name);
}
