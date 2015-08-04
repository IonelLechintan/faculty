package com.garmin.model.exceptions;

public class BadRequestException extends RuntimeException {
	private static final long serialVersionUID = 4574680522222301639L;;

	public BadRequestException(String message) {
		super(message);

	}

}
