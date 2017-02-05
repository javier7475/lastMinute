package com.lastMinute.exercise.exception;

/**
 * Exception for not found
 *
 */
public class NotFoundException extends LastMinuteException {
	
	private static final long serialVersionUID = -1000627788367067059L;

	public NotFoundException(String message) {
		super(message);
	}

}
