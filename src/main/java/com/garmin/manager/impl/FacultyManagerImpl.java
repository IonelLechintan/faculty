package com.garmin.manager.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.garmin.dao.CourseDAO;
import com.garmin.dao.ParticipantsDAO;
import com.garmin.dao.StudentDAO;
import com.garmin.dao.model.CourseDTO;
import com.garmin.dao.model.StudentDTO;
import com.garmin.manager.FacultyManager;
import com.garmin.model.exceptions.EntityAlreadyExistException;
import com.garmin.model.exceptions.EntityNotFoundException;

@Transactional(readOnly = true)
public class FacultyManagerImpl implements FacultyManager {
	private StudentDAO studentDAO;
	private CourseDAO courseDAO;
	private ParticipantsDAO participantsDAO;

	public FacultyManagerImpl(StudentDAO studentDAO, CourseDAO courseDAO, ParticipantsDAO participantsDAO) {
		this.studentDAO = studentDAO;
		this.courseDAO = courseDAO;
		this.participantsDAO = participantsDAO;
	}

	public StudentDTO getStudentById(String id) {
		StudentDTO student = studentDAO.getStudentById(id);
		if (student == null) {
			throw new EntityNotFoundException("Student with id= " + id + " was not found");
		} else {
			return student;
		}
	}

	public List<StudentDTO> listAllStudents() {
		return studentDAO.listAllStudents();
	}

	@Transactional(readOnly = false)
	public StudentDTO addStudent(StudentDTO studentDTO) throws EntityAlreadyExistException {
		UUID id = UUID.randomUUID();
		studentDTO.setId(id.toString());
		StudentDTO studentHelper = studentDAO.getStudentByRegistrationNoAndName(studentDTO.getName(),
				studentDTO.getRegistrationNo());
		if (studentHelper == null) {
			studentDAO.insertStudent(studentDTO);
			return studentDAO.getStudentById(studentDTO.getId());
		} else if (studentHelper.isDeleted()) {
			studentDAO.updateStudent(studentDTO);
			return studentDAO.getStudentById(studentHelper.getId());
		} else {
			throw new EntityAlreadyExistException("This student with registration number"
					+ studentDTO.getRegistrationNo() + " is already in database");
		}

	}

	public CourseDTO getCourseById(String id) {
		CourseDTO course = courseDAO.getCourseById(id);
		if (course == null) {
			throw new EntityNotFoundException("Course with id= " + id + " was not found");
		} else {
			return course;
		}
	}

	public List<CourseDTO> listAllCourses() {
		return courseDAO.listAllCourses();
	}

	@Transactional(readOnly = false)
	public CourseDTO addStudent(CourseDTO courseDTO) throws EntityAlreadyExistException {
		UUID id = UUID.randomUUID();
		courseDTO.setCourseId(id.toString());
		CourseDTO courseHelper = courseDAO.getCourseByName(courseDTO.getName());
		if (courseHelper == null) {
			courseDAO.insertCourse(courseDTO);
			return courseDAO.getCourseById(courseDTO.getCourseId());
		} else {
			throw new EntityAlreadyExistException("Course with name= " + courseDTO.getName() + " already exist");
		}
	}

	private CourseDTO updateCourse(CourseDTO courseDTO) {
		courseDAO.updateCourse(courseDTO);
		return courseDAO.getCourseByName(courseDTO.getName());
	}

	@Transactional(readOnly = false)
	public List<CourseDTO> addStudentToCourses(String studentId, List<CourseDTO> coursesToAttend) {

		StudentDTO studentDTO = studentDAO.getStudentById(studentId);
		if (studentDTO == null) {
			throw new EntityNotFoundException("Student with id= " + studentId + " was not found");
		} else if (coursesToAttend != null) {
			for (CourseDTO courseDTO : coursesToAttend) {
				CourseDTO courseDTOHelper = courseDAO.getCourseByName(courseDTO.getName());
				if (courseDTOHelper == null) {
					throw new EntityNotFoundException("Course with name: " + courseDTO.getName() + " was not found");
				} else {
					UUID participantId = UUID.randomUUID();

					if (participantsDAO.getParticipantByStudentIdAndCourseId(studentId,
							courseDTOHelper.getCourseId()) == 0) {
						courseDTO = this.updateCourse(courseDTOHelper);
						participantsDAO.addStudentToCourse(participantId.toString(), studentId,
								courseDTO.getCourseId());
					}
				}
			}
		}
		return null;
	}

}
