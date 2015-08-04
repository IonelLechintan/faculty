package com.garmin.dao;

import java.util.List;

import com.garmin.dao.model.StudentDTO;

public interface StudentDAO {

 
	public StudentDTO getStudentById(String id);
	public StudentDTO getStudentByName(String name);
	public List<StudentDTO> listAllStudents();
	public StudentDTO getStudentByRegistrationNoAndName(String name,int regNo);
	public int insertStudent(StudentDTO student);
	public int updateStudent(StudentDTO student);
}
