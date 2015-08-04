package com.garmin.business;

import java.util.List;

import com.garmin.model.CourseBO;
import com.garmin.model.StudentBO;
import com.garmin.model.exceptions.EntityAlreadyExistException;

public interface FacultyBusinessServices {

	public StudentBO getStudentById(String id);
	public List<StudentBO> listAllStudents();
	public StudentBO addStudent(StudentBO student) throws EntityAlreadyExistException;
	public CourseBO getCourseByID(String id);
	public List<CourseBO> listAllCourses();
	public CourseBO addCourse(CourseBO courseBO);
	public void addStudentToCourses(String studentId, List<CourseBO> coursesToAttend);
}
