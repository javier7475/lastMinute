package com.lastMinute.exercise.dao;

import java.math.BigDecimal;

import com.lastMinute.exercise.exception.NotFoundException;

/**
 * Class for accessing price info. A database and a tool like hibernate should be used
 *
 */
public class InfantPriceDAO {

	public BigDecimal getInfantPrice(String company) throws NotFoundException {
		for (String[] element : Database.getAirlines()) {
			if (company.equals(element[0])) {
				return new java.math.BigDecimal(element[2]);
			}
		}
		throw new NotFoundException("Comany not found");
	}
}
