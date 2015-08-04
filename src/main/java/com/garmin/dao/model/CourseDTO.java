package com.garmin.dao.model;

public class CourseDTO {
	private String courseId;
	private String name;
	private int noOfStudents;

	public CourseDTO(String courseId, String name, int noOfStudents) {
		this.courseId = courseId;
		this.name = name;
		this.noOfStudents = noOfStudents;
	}

	public CourseDTO() {
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

}
