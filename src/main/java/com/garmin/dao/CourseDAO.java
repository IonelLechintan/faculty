package com.garmin.dao;

import java.util.List;

import com.garmin.dao.model.CourseDTO;

public interface CourseDAO {
	public CourseDTO getCourseById(String id);
	public CourseDTO getCourseByName(String name);
	public List<CourseDTO> listAllCourses();
	public int insertCourse(CourseDTO courseDTO);
	public int updateCourse(CourseDTO courseDTO);
	public int deleteCourse(CourseDTO courseDTO);
}
