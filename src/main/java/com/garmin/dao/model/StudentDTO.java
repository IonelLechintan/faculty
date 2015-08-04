package com.garmin.dao.model;

public class StudentDTO {

	private String id;
	private String name;
	private int registrationNo;
	private boolean isDeleted;

	public StudentDTO() {

	}

	public StudentDTO(String id, String name, int registrationNo) {
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

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}
