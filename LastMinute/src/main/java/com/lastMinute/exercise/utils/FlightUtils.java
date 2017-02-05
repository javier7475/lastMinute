package com.lastMinute.exercise.utils;

public class FlightUtils {

	/**
	 * @param flightNo Flight number
	 * @return the company code
	 */
	public static String getCompany(String flightNo) {
		if (flightNo == null || flightNo.length() < 3) {
			return null;
		} else {
			return flightNo.substring(0, 2);
		}
	}
}
