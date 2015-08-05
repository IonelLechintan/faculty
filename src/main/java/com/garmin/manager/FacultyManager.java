	package com.garmin.manager;

import java.util.List;

import com.garmin.dao.model.CourseDTO;
import com.garmin.dao.model.StudentAtCoursesDTO;
import com.garmin.dao.model.StudentDTO;
import com.garmin.model.exceptions.EntityAlreadyExistException;

public interface FacultyManager {
	public StudentDTO getStudentById(String id);
	public List<StudentDTO> listAllStudents();
	public StudentDTO addStudent(StudentDTO studentDTO) throws EntityAlreadyExistException;
	public CourseDTO getCourseById(String id);
	public List<CourseDTO>  listAllCourses();
	public CourseDTO addStudent(CourseDTO courseDTO) throws EntityAlreadyExistException;
	public List<CourseDTO> addStudentToCourses(String studentId, List<CourseDTO> coursesToAttend);
	public StudentAtCoursesDTO listStudentWithCourses(String studentId);
}
