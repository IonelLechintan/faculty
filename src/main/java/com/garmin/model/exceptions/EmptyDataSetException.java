package com.garmin.model.exceptions;

public class EmptyDataSetException extends RuntimeException {
	private static final long serialVersionUID = -3704608269644972717L;

	public EmptyDataSetException(String message) {
		super(message);
	}

}
