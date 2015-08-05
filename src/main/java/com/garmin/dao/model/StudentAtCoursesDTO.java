package com.garmin.dao.model;

import java.util.List;

public class StudentAtCoursesDTO {
	private String name;
	private List<CourseDTO> courses;

//TODO vezi de ce afiseaza null
	public StudentAtCoursesDTO(String name, List<CourseDTO> courses) {
		this.name = name;
		this.courses = courses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CourseDTO> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseDTO> courses) {
		this.courses = courses;
	}

}
