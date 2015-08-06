package com.garmin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.garmin.business.FacultyBusinessServices;
import com.garmin.model.CourseBO;
import com.garmin.model.StudentBO;
import com.garmin.model.exceptions.InvalidDataSubmittedException;
import com.garmin.model.exceptions.EntityAlreadyExistException;
import com.garmin.model.exceptions.EntityNotFoundException;

@RestController
@RequestMapping("/courses")
public class CourseController {
	@Autowired
	private FacultyBusinessServices facultyBusinessServices;
	private static final Logger facultyLogger = LoggerFactory.getLogger(CourseController.class);

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public CourseBO getCourseById(@PathVariable String id) {

		return facultyBusinessServices.getCourseByID(id);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CourseBO> listAllCourses() {
		return facultyBusinessServices.listAllCourses();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public CourseBO addCourse(@RequestBody CourseBO courseBO, @PathVariable String id)
			throws EntityAlreadyExistException, InvalidDataSubmittedException, EntityNotFoundException {
		facultyLogger.info("The post method was called");
		if (courseBO.getName() == null)
			throw new InvalidDataSubmittedException("The data sent is null");
		return facultyBusinessServices.addCourse(courseBO);
	}

	@RequestMapping(value = "/{courseId}/students", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StudentBO> listAllStudentsAtCourse(@PathVariable String courseId) {
		facultyLogger.info("The listAllStudentAtCourse was called");
		return facultyBusinessServices.listAllStudentsAtCourse(courseId);

	}

	@RequestMapping(method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteCourse(@RequestBody CourseBO course) {
		facultyBusinessServices.deleteCourse(course);
	}

	@ExceptionHandler(EntityAlreadyExistException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public String alreadyInDatabase(EntityAlreadyExistException exception) {
		facultyLogger.warn("EntityAlreadyExistException caught with message: {}", exception.getMessage());
		return exception.getMessage();
	}

	@ExceptionHandler(InvalidDataSubmittedException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> nullDataSent(InvalidDataSubmittedException exception) {
		facultyLogger.warn("EmptyDataSetException caugth, Throwing new BadRequestException", exception);
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public void entityNotFound(EntityNotFoundException exception) {
		facultyLogger.warn("EntityNotFoundException caugth with message: {}  ", exception.getMessage());
	}
}