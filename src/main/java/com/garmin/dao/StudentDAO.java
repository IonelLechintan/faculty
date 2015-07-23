package com.garmin.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.garmin.dao.model.StudentDTO;

public interface StudentDAO {

 
	public StudentDTO getStudentById(int id);
	public List<StudentDTO> listAllStudents();
	public void addStudent(StudentDTO studentDTO);
}
