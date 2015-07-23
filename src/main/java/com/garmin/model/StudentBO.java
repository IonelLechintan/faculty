package com.garmin.model;

public class StudentBO {

	private int id;
	private String name;
	private int registration_no;

	public StudentBO(int id, String name, int registration_no) {
		this.id = id;
		this.name = name;
		this.registration_no = registration_no;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRegistration_no() {
		return registration_no;
	}

	public void setRegistration_no(int registration_no) {
		this.registration_no = registration_no;
	}
}
