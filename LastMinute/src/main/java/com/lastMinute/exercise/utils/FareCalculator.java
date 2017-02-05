package com.lastMinute.exercise.utils;

import java.math.BigDecimal;
import java.util.Date;

public class FareCalculator {

	public static BigDecimal getFare(int adults, int children, int infants, Date departureDate,
			BigDecimal adultFare, BigDecimal infantFare) {
		long daysTillDeparture = DateUtils.daysTillDate(departureDate);

		BigDecimal daysFactor = null;
		if (daysTillDeparture > 30) {
			daysFactor = new BigDecimal("0.8");
		} else if (daysTillDeparture >= 16 && daysTillDeparture <= 30) {
			daysFactor = new BigDecimal("1");
		} else if (daysTillDeparture >= 3 && daysTillDeparture <= 15) {
			daysFactor = new BigDecimal("1.2");
		} else if (daysTillDeparture < 3) {
			daysFactor = new BigDecimal("1.5");
		}
		BigDecimal adultsPrice = daysFactor.multiply(adultFare).multiply(new BigDecimal(adults));
		BigDecimal childrenPrice = daysFactor.multiply(adultFare).multiply(new BigDecimal(children))
				.multiply(new BigDecimal("0.67"));
		BigDecimal infantPrice = new BigDecimal(infants).multiply(infantFare);

		return adultsPrice.add(childrenPrice).add(infantPrice);
	}
}
