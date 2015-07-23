package com.garmin.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.garmin.business.FacultyBusinessServices;
import com.garmin.manager.FacultyManager;
import com.garmin.model.StudentBO;
import com.garmin.util.Translator;

public class FacultyBusinessServicesImpl implements FacultyBusinessServices {

	@Autowired
	private FacultyManager facultyManager;
	@Autowired
	private Translator translator;

	public StudentBO getStudentById(int id) {
		return translator.translateStudentToBusinessObject(facultyManager.getStudentById(id));
	}

	public List<StudentBO> listAllStudents() {

		return translator.translateAllStudents( facultyManager.listAllStudents());
	}
	public void addStudent(String name){
		StudentBO studentBO=new StudentBO((int)(Math.random()*1000+1),name,(int)(Math.random()*10000000+1));
		facultyManager.addStudent(translator.translateStudentToDataTransferObject(studentBO));
	}
}
