package com.garmin.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.garmin.dao.model.CourseDTO;
import com.garmin.dao.model.StudentDTO;
import com.garmin.model.CourseBO;
import com.garmin.model.StudentBO;

public class Translator {

	public StudentBO translateStudentToBusinessObject(StudentDTO studentDTO) {
		if (!studentDTO.isDeleted()) {
			StudentBO studentBO = new StudentBO(studentDTO.getId(), studentDTO.getName(),
					studentDTO.getRegistrationNo());
			return studentBO;
		}
		return null;
	}

	public List<StudentBO> translateAllStudents(List<StudentDTO> allStudentsDTO) {
		if (CollectionUtils.isEmpty(allStudentsDTO)) {
			return Collections.emptyList();
		}
		List<StudentBO> allStudentsBO = new ArrayList<StudentBO>();
		for (StudentDTO studentDTO : allStudentsDTO) {
			if (studentDTO != null) {
				allStudentsBO
						.add(new StudentBO(studentDTO.getId(), studentDTO.getName(), studentDTO.getRegistrationNo()));
			}
		}
		return allStudentsBO;
	}

	public StudentDTO translateStudentToDataTransferObject(StudentBO studentBO) {
		return new StudentDTO(studentBO.getId(), studentBO.getName(), studentBO.getRegistrationNo());
	}

	public CourseBO translateCoursetoBusinessObject(CourseDTO courseDTO) {
		return new CourseBO(courseDTO.getCourseId(), courseDTO.getName(), courseDTO.getNoOfStudents());
	}

	public List<CourseBO> translateAllCoursesToBusinnesObject(List<CourseDTO> allCoursesDTO) {
		if (CollectionUtils.isEmpty(allCoursesDTO)) {
			return Collections.emptyList();
		} else {
			List<CourseBO> allCoursesBO = new ArrayList<CourseBO>();
			for (CourseDTO courseDTO : allCoursesDTO) {
				allCoursesBO
						.add(new CourseBO(courseDTO.getCourseId(), courseDTO.getName(), courseDTO.getNoOfStudents()));
			}
			return allCoursesBO;
		}

	}

	public CourseDTO translateCourseToDataTransferObject(CourseBO courseBO) {
		return new CourseDTO(courseBO.getCourseId(), courseBO.getName(), courseBO.getNoOfStudents());
	}

	public List<CourseDTO> translateAllCoursestoDataTransferObject(List<CourseBO> coursesToAttend) {
		if (CollectionUtils.isEmpty(coursesToAttend)) {
			return Collections.emptyList();
		} else {
			List<CourseDTO> coursesToAttendDTO = new ArrayList<CourseDTO>();
			for (CourseBO courseBO : coursesToAttend) {
				coursesToAttendDTO
						.add(new CourseDTO(courseBO.getCourseId(), courseBO.getName(), courseBO.getNoOfStudents()));
			}
			return coursesToAttendDTO;
		}
	}

}
