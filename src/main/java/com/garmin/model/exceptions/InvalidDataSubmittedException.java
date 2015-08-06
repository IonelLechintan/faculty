package com.garmin.model.exceptions;

public class InvalidDataSubmittedException extends RuntimeException {
	private static final long serialVersionUID = -3704608269644972717L;

	public InvalidDataSubmittedException(String message) {
		super(message);
	}

}
