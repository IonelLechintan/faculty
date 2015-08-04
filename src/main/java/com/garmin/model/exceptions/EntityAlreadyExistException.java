package com.garmin.model.exceptions;

public class EntityAlreadyExistException extends RuntimeException {
	private static final long serialVersionUID = -8065982658143199570L;

	public EntityAlreadyExistException(String message) {
		super(message);
	}

}
