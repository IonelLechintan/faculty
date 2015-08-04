package com.garmin.util.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.garmin.dao.model.StudentDTO;
import com.garmin.model.StudentBO;
import com.garmin.util.Translator;

public class TranslatorTest {

	private Translator translator = new Translator();
	private StudentDTO studentDTO = new StudentDTO("1232dsffsf", "ionel", 123);
	private StudentBO studentBO = new StudentBO("1232dsffsf", "ionel", 123);
	private List<StudentDTO> allStudentsDTO = new ArrayList<StudentDTO>();
	// private List<StudentBO> allStudentsBO = new ArrayList<StudentBO>();

	@Test
	public void testTranslateStudentToBusinessObject() {
		StudentBO testStudent = translator.translateStudentToBusinessObject(studentDTO);

		assertEquals(studentBO.getId(), testStudent.getId());
		assertEquals(studentBO.getName(), testStudent.getName());
		assertEquals(studentBO.getRegistrationNo(), testStudent.getRegistrationNo());
	}

	@Test
	public void testTranslateDeletedStudentToBusinessObject() {

		studentDTO.setDeleted(true);
		StudentBO testStudent = translator.translateStudentToBusinessObject(studentDTO);

		assertEquals(null, testStudent);
	}

	@Test
	public void testTranslateStudentToDataTransferObject() {
		StudentDTO testStudent = translator.translateStudentToDataTransferObject(studentBO);

		assertEquals(studentDTO.getId(), testStudent.getId());
		assertEquals(studentDTO.getName(), testStudent.getName());
		assertEquals(studentDTO.getRegistrationNo(), testStudent.getRegistrationNo());
	}

	@Test
	public void testTranslateAllStudents() {
		StudentDTO auxiliar = null;
		allStudentsDTO.add(studentDTO);
		allStudentsDTO.add(new StudentDTO("123", "ione", 121));
		allStudentsDTO.add(auxiliar);
		System.out.println(allStudentsDTO.size());
		List<StudentBO> studentBOs = translator.translateAllStudents(allStudentsDTO);

		assertEquals(studentDTO.getId(), studentBOs.get(0).getId());

	}
	/*
	 * @Test public void testTranslateAllStudentsPart2() {
	 * allStudentsDTO.add(studentDTO); allStudentsDTO.add(new StudentDTO("123",
	 * "ione", 121)); System.out.println(allStudentsDTO.size()); List<StudentBO>
	 * studentBOs = translator.translateAllStudents(allStudentsDTO);
	 * 
	 * assertEquals(studentDTO.getId(), studentBOs.get(0).getId());
	 * 
	 * }
	 */

	@Test
	public void testNullTranslateAllStudents() {
		List<StudentBO> studentBOs = translator.translateAllStudents(allStudentsDTO);
		assertEquals(Collections.emptyList(), studentBOs);

	}
}
