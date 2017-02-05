package com.lastMinute.exercise.utils;

public class FlightUtils {

	public static String getCompany(String flightNo) {
		if (flightNo == null || flightNo.length() < 3) {
			return null;
		} else {
			return flightNo.substring(0, 2);
		}
	}
}
