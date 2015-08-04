package com.garmin.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.garmin.dao.model.CourseDTO;

public class CourseMapper implements RowMapper<CourseDTO> {

	public CourseDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CourseDTO course = new CourseDTO();
		course.setCourseId(rs.getString("courseId"));
		course.setName(rs.getString("name"));
		course.setNoOfStudents(rs.getInt("noOfStudents"));
		return course;
	}

}
