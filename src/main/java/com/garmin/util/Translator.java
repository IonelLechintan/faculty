package com.garmin.util;

import java.util.ArrayList;
import java.util.List;

import com.garmin.dao.model.StudentDTO;
import com.garmin.model.StudentBO;

public class Translator {

	public StudentBO translateStudentToBusinessObject(StudentDTO studentDTO) {

		StudentBO studentBO = new StudentBO(studentDTO.getId(),
				studentDTO.getName(),studentDTO.getRegistration_no());
		System.out.println("s");
		return studentBO;
	}

	public List<StudentBO> translateAllStudents(List<StudentDTO> allStudentsDTO) {
		List<StudentBO> allStudentsBO = new ArrayList<StudentBO>();
		for (StudentDTO helper : allStudentsDTO) {
			allStudentsBO.add(new StudentBO(helper.getId(), helper.getName(),helper.getRegistration_no()));
		}

		return allStudentsBO;

	}

	public StudentDTO translateStudentToDataTransferObject(StudentBO studentBO) {
		return new StudentDTO(studentBO.getId(),studentBO.getName(),studentBO.getRegistration_no());
		
	}

}
