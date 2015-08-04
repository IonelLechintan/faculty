package com.garmin.model.exceptions;

public class EntityNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -5395597585943090984L;

	public EntityNotFoundException(String message) {
		super(message);
	}

}
