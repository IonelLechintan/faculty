package com.garmin.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.garmin.business.FacultyBusinessServices;
import com.garmin.dao.model.CourseDTO;
import com.garmin.dao.model.StudentAtCoursesDTO;
import com.garmin.manager.FacultyManager;
import com.garmin.model.CourseBO;
import com.garmin.model.StudentBO;
import com.garmin.model.exceptions.EntityAlreadyExistException;
import com.garmin.util.Translator;

public class FacultyBusinessServicesImpl implements FacultyBusinessServices {

	@Autowired
	private FacultyManager facultyManager;
	@Autowired
	private Translator translator;

	public StudentBO getStudentById(String id) {
		return translator.translateStudentToBusinessObject(facultyManager.getStudentById(id));
	}

	public List<StudentBO> listAllStudents() {

		return translator.translateAllStudents(facultyManager.listAllStudents());
	}

	public StudentBO addStudent(StudentBO student) throws EntityAlreadyExistException {

		return translator.translateStudentToBusinessObject(
				facultyManager.addStudent(translator.translateStudentToDataTransferObject(student)));

	}

	public CourseBO getCourseByID(String id) {
		return translator.translateCourseToBusinessObject(facultyManager.getCourseById(id));
	}

	public List<CourseBO> listAllCourses() {
		return translator.translateAllCoursesToBusinnesObject(facultyManager.listAllCourses());
	}

	public CourseBO addCourse(CourseBO courseBO) {

		return translator.translateCourseToBusinessObject(
				facultyManager.addStudent(translator.translateCourseToDataTransferObject(courseBO)));
	}

	public void addStudentToCourses(String studentId, List<CourseBO> coursesToAttend) {
		// translator.translateAllCoursesToBusinnesObject(
		facultyManager.addStudentToCourses(studentId,
				translator.translateAllCoursestoDataTransferObject(coursesToAttend));

	}

	public List<CourseBO> listStudentWithCourses(String studentId) {

		return translator.translateAllCoursesToBusinnesObject(facultyManager.listStudentAtCourses(studentId));
	}

	public List<StudentBO> listAllStudentsAtCourse(String courseId) {
		return translator.translateAllStudents(facultyManager.listAllStudentsAtCourse(courseId));
	}

	public void deleteCourse(CourseBO course) {
		facultyManager.deleteCourse(translator.translateCourseToDataTransferObject(course));
		
	}

}
