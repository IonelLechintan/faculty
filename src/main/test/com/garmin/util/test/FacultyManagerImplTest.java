package com.garmin.util.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.garmin.dao.StudentDAO;
import com.garmin.dao.model.StudentDTO;
import com.garmin.manager.impl.FacultyManagerImpl;
import com.garmin.model.exceptions.EntityAlreadyExistException;
import com.garmin.model.exceptions.EntityNotFoundException;

public class FacultyManagerImplTest {

	@Mock
	private StudentDAO studentDAO;

	@InjectMocks
	private FacultyManagerImpl facultyManagerImpl;

	private StudentDTO studentDTO = new StudentDTO("123", "ionel", 123);

	@Before
	public void create() {
		MockitoAnnotations.initMocks(this);
		facultyManagerImpl = new FacultyManagerImpl(studentDAO, null, null);
	}

	@Test
	public void testHappyGetStudentById() {
		when(studentDAO.getStudentById("123")).thenReturn(studentDTO);

		assertEquals("123", facultyManagerImpl.getStudentById("123").getId());
		verify(studentDAO, times(1)).getStudentById(Mockito.anyString());

	}

	@Test(expected = EntityNotFoundException.class)
	public void testBadGetStudentById() {
		when(studentDAO.getStudentById("123")).thenReturn(null);

		try {
			facultyManagerImpl.getStudentById("123");
		} finally {
			verify(studentDAO, times(1)).getStudentById(Mockito.anyString());
		}
	}

	@Test
	public void testHappyInsertForAddStudent() {
		when(studentDAO.getStudentByRegistrationNoAndName("ionel", 123)).thenReturn(null);
		when(studentDAO.getStudentById(Mockito.anyString())).thenReturn(studentDTO);

		assertEquals(studentDTO, facultyManagerImpl.addStudent(studentDTO));
		verify(studentDAO, times(1)).getStudentByRegistrationNoAndName(Mockito.anyString(), Mockito.anyInt());
		verify(studentDAO, times(1)).insertStudent(studentDTO);
		verify(studentDAO, times(1)).getStudentById(Mockito.anyString());
		verify(studentDAO, never()).updateStudent(studentDTO);
	}

	@Test
	public void testHappyUpdateForAddStudent() {
		studentDTO.setDeleted(true);
		when(studentDAO.getStudentByRegistrationNoAndName("ionel", 123)).thenReturn(studentDTO);
		when(studentDAO.getStudentById(Mockito.anyString())).thenReturn(studentDTO);

		assertEquals(studentDTO, facultyManagerImpl.addStudent(studentDTO));
		verify(studentDAO, times(1)).getStudentByRegistrationNoAndName(Mockito.anyString(), Mockito.anyInt());
		verify(studentDAO, never()).insertStudent(studentDTO);
		verify(studentDAO, times(1)).updateStudent(studentDTO);
		verify(studentDAO, times(1)).getStudentById(Mockito.anyString());

	}

	@Test(expected = EntityAlreadyExistException.class)
	public void testBadUpdateForAddStudent() {
		studentDTO.setDeleted(false);
		when(studentDAO.getStudentByRegistrationNoAndName("ionel", 123)).thenReturn(studentDTO);
		try {
			facultyManagerImpl.addStudent(studentDTO);
		} finally {

			verify(studentDAO, times(1)).getStudentByRegistrationNoAndName(Mockito.anyString(), Mockito.anyInt());
			verify(studentDAO, never()).insertStudent(studentDTO);
			verify(studentDAO, never()).updateStudent(studentDTO);
			verify(studentDAO, never()).getStudentById(Mockito.anyString());
		}
	}
}
