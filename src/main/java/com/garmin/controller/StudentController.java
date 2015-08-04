package com.garmin.controller;

import java.util.List;

import org.slf4j.Logger;
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
import com.garmin.model.exceptions.EmptyDataSetException;
import com.garmin.model.exceptions.EntityAlreadyExistException;
import com.garmin.model.exceptions.EntityNotFoundException;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private FacultyBusinessServices facultyBusinessServices;
	private final static Logger facultyLogger = org.slf4j.LoggerFactory.getLogger(StudentController.class);

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public StudentBO getStudentById(@PathVariable String id) {
		facultyLogger.info("Request made for id={}", id);
		return facultyBusinessServices.getStudentById(id);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StudentBO> listAllStudents() {
		return facultyBusinessServices.listAllStudents();
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public StudentBO addStudent(@RequestBody StudentBO student)
			throws EntityAlreadyExistException, EmptyDataSetException, EntityNotFoundException {
		if (student.getName() == null || student.getRegistrationNo() == 0)
			throw new EmptyDataSetException("The data sent is null");
		return facultyBusinessServices.addStudent(student);
	}

	@RequestMapping(value = "/{studentId}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void addStudentToCourses(@PathVariable String studentId, @RequestBody List<CourseBO> coursesToAttend) {
System.out.println(coursesToAttend.get(1).getName());
facultyBusinessServices.addStudentToCourses(studentId,coursesToAttend);
	}

	@ExceptionHandler(EntityAlreadyExistException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public String alreadyInDatabase(EntityAlreadyExistException exception) {
		// System.out.println(exception.getMessage());
		facultyLogger.warn("EntityAlreadyExistException caught with message: {}", exception.getMessage());
		return exception.getMessage();
	}

	@ExceptionHandler(EmptyDataSetException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> nullDataSent(EmptyDataSetException exception) {
		facultyLogger.warn("EmptyDataSetException caugth, Throwing new BadRequestException", exception);
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public void entityNotFound(EntityNotFoundException exception) {
		facultyLogger.warn("EntityNotFoundException caugth with message: {}  ", exception.getMessage());
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public String otherExceptions(Exception exception) {

		facultyLogger.warn("Other exception caugth with cause: ", exception);
		return "Internal application problem";
	}
}