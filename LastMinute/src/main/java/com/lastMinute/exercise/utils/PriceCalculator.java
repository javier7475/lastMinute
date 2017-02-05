package com.lastMinute.exercise.utils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Class for calculating the price of a flight
 *
 */
public class PriceCalculator {

	public static BigDecimal getPrice(int adults, int children, int infants, Date departureDate, BigDecimal adultPrice,
			BigDecimal infantPrice) {
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
		BigDecimal adultsTotal= daysFactor.multiply(adultPrice).multiply(new BigDecimal(adults));
		BigDecimal childrenTotal= daysFactor.multiply(adultPrice).multiply(new BigDecimal(children))
				.multiply(new BigDecimal("0.67"));
		BigDecimal infantTotal= new BigDecimal(infants).multiply(infantPrice);

		return adultsTotal.add(childrenTotal).add(infantTotal);
	}
}
