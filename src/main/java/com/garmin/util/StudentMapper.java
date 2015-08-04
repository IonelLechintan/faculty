package com.garmin.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.garmin.dao.model.StudentDTO;

public class StudentMapper implements RowMapper<StudentDTO> {
	public StudentDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		StudentDTO student = new StudentDTO();
		student.setId(rs.getString("studentId"));
		student.setName(rs.getString("name"));
		student.setRegistrationNo(rs.getInt("registrationNo"));
		student.setDeleted(rs.getBoolean("isDeleted"));

		return student;
	}
}
