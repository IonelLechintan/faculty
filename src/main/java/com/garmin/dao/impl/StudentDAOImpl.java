package com.garmin.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.garmin.dao.StudentDAO;
import com.garmin.dao.model.StudentDTO;
import com.garmin.util.StudentMapper;

public class StudentDAOImpl implements StudentDAO {

	private JdbcTemplate jdbcTemplateObject;

	public StudentDAOImpl(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}

	public StudentDTO getStudentById(int id) {
		String sql = "select * from student where student_id = ?";
		StudentDTO student = jdbcTemplateObject.queryForObject(sql,
				new Object[] { id }, new StudentMapper());

		return student;
	}

	public List<StudentDTO> listAllStudents() {
		String sql = "select * from student ";
		List<StudentDTO> allStudents = jdbcTemplateObject.query(sql,
				new StudentMapper());
		return allStudents;
	}

	public void addStudent(StudentDTO studentDTO) {
		String SQL = "insert into student (student_id, name,registration_no) values (?, ?,?)";
		System.out.println(studentDTO.getId()+studentDTO.getName());
		jdbcTemplateObject.update(SQL, studentDTO.getId(),studentDTO.getName(),studentDTO.getRegistration_no());

	}

}
