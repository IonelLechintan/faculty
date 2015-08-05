package com.garmin.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.garmin.business.FacultyBusinessServices;
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
		return translator.translateCoursetoBusinessObject(facultyManager.getCourseById(id));
	}

	public List<CourseBO> listAllCourses() {
		return translator.translateAllCoursesToBusinnesObject(facultyManager.listAllCourses());
	}

	public CourseBO addCourse(CourseBO courseBO) {

		return translator.translateCoursetoBusinessObject(
				facultyManager.addStudent(translator.translateCourseToDataTransferObject(courseBO)));
	}

	public void addStudentToCourses(String studentId, List<CourseBO> coursesToAttend) {
		translator.translateAllCoursesToBusinnesObject(facultyManager.addStudentToCourses(studentId,
				translator.translateAllCoursestoDataTransferObject(coursesToAttend)));

	}

	public StudentAtCoursesDTO listStudentWithCourses(String studentId) {
		 
		return facultyManager.listStudentWithCourses(studentId);
	}

}
