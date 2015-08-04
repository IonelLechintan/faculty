package com.garmin.model;

import java.io.Serializable;

public class StudentBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3515808963198113420L;
	private String id;
	private String name;
	private int registrationNo;

	public StudentBO() {
		// TODO Auto-generated constructor stub
	}

	public StudentBO(String id, String name, int registrationNo) {

		this.id = id;
		this.name = name;
		this.registrationNo = registrationNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(int registrationNo) {
		this.registrationNo = registrationNo;
	}

}
