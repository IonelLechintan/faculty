package com.garmin.dao.impl;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.garmin.dao.StudentDAO;
import com.garmin.dao.model.StudentDTO;
import com.garmin.util.StudentMapper;

public class StudentDAOImpl implements StudentDAO {

	private JdbcTemplate jdbcTemplateObject;

	public StudentDAOImpl(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}

	public StudentDTO getStudentById(String id) {
		String sql = "select * from student where studentId= ? and isDeleted=0";
		try {
			StudentDTO student = jdbcTemplateObject.queryForObject(sql, new Object[] { id }, new StudentMapper());
			return student;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public StudentDTO getStudentByName(String name) {
		String sql = "select * from student where name = ?";
		StudentDTO student = jdbcTemplateObject.queryForObject(sql, new Object[] { name }, new StudentMapper());

		return student;
	}

	public List<StudentDTO> listAllStudents() {
		String sql = "select * from student where isDeleted=0";
		List<StudentDTO> allStudents = jdbcTemplateObject.query(sql, new StudentMapper());
		return allStudents;
	}

	public StudentDTO getStudentByRegistrationNoAndName(String name, int regNo) {
		String sql = "select * from student where   name=? and registrationNo = ?";
		try {
			StudentDTO student = jdbcTemplateObject.queryForObject(sql, new Object[] { name, regNo },
					new StudentMapper());
			return student;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	public int updateStudent(StudentDTO student) {
		String sql = "update student set isDeleted=0 where registrationNo=?";
		return jdbcTemplateObject.update(sql,  student.getRegistrationNo());
	}

	public int insertStudent(StudentDTO student) {
		String sql = "insert into student(studentId,name,registrationNo)  values(?,?,?) ";
		return jdbcTemplateObject.update(sql, student.getId(), student.getName(), student.getRegistrationNo());
	}

	public int deleteStudent(StudentDTO studentDTO) {
		String sql = "update student set isDeleted=1 where studentId=?";
		return jdbcTemplateObject.update(sql, studentDTO.getId());
	}

}
