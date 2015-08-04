package com.garmin.dao.impl;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.garmin.dao.CourseDAO;
import com.garmin.dao.model.CourseDTO;
import com.garmin.util.CourseMapper;

public class CourseDAOImpl implements CourseDAO {

	private JdbcTemplate jdbcTemplateObject;

	public CourseDAOImpl(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}

	public CourseDTO getCourseById(String id) {
		String sql = "select * from course where courseId= ? ";
		try {
			CourseDTO course = jdbcTemplateObject.queryForObject(sql, new Object[] { id }, new CourseMapper());
			return course;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public CourseDTO getCourseByName(String name) {
		String sql = "select * from course where name = ?";
		try {
			CourseDTO course = jdbcTemplateObject.queryForObject(sql, new Object[] { name }, new CourseMapper());
			return course;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	public List<CourseDTO> listAllCourses() {
		String sql = "select * from course";
		List<CourseDTO> allCourses = jdbcTemplateObject.query(sql, new CourseMapper());
		return allCourses;
	}

	public int insertCourse(CourseDTO course) {
		String sql = "insert into course(courseId,name)  values(?,?) ";
		return jdbcTemplateObject.update(sql, course.getCourseId(), course.getName());
	}

	public int updateCourse(CourseDTO course) {
		String sql = "update course set noOfStudents=noOfStudents+1 where name=?";
		return jdbcTemplateObject.update(sql, course.getName());
	}

}
