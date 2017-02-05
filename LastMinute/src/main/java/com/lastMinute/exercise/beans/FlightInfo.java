package com.lastMinute.exercise.beans;

import java.math.BigDecimal;

public class FlightInfo {

	private String flightNo;
	private BigDecimal price;

	public FlightInfo(String flightNo, BigDecimal price) {
		this.flightNo = flightNo;
		this.price = price;
	}

	public String toString() {

		return flightNo + "," + price.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

}
