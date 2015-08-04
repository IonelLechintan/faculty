package com.garmin.model;

public class CourseBO {
	private String courseId;
	private String name;
	private int noOfStudents;

	public CourseBO() {
	}

	public CourseBO(String courseId, String name, int noOfStudents) {
		this.courseId = courseId;
		this.name = name;
		this.noOfStudents = noOfStudents;
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
