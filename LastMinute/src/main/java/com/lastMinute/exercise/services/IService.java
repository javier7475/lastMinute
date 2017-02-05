package com.lastMinute.exercise.services;

import org.json.JSONObject;

import com.lastMinute.exercise.exception.LastMinuteException;

/**
 * General class for service
 *
 */
public interface IService {

	/**
	 * Method for validating the input
	 * 
	 * @param json
	 *            received json or null if no json is required
	 * @throws LastMinuteException
	 *             in case of wrong input
	 */
	public void validate(String json) throws LastMinuteException;

	/**
	 * Executes the service
	 * 
	 * @param json
	 *            the received json or null if no json is required
	 * @return the response in json format.
	 * @throws LastMinuteException
	 */
	public JSONObject execute(String json) throws LastMinuteException;

}
