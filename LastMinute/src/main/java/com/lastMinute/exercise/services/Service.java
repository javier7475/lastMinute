package com.lastMinute.exercise.services;

import com.lastMinute.exercise.exception.LastMinuteException;

/**
 * Generic class for a service. Each subclass must define a method for
 * validating the input and a method for executing the service.
 * This way we force to create and invoke a method for validating the input.
 *
 */
public abstract class Service {

	abstract protected void validateInput() throws LastMinuteException;

	abstract protected Object doAction() throws LastMinuteException;

	public Object execute() throws LastMinuteException {
		validateInput();
		return doAction();
	}

}
