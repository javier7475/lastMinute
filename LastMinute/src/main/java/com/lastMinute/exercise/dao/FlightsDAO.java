package com.lastMinute.exercise.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lastMinute.exercise.beans.FlightInfo;
import com.lastMinute.exercise.exception.NotFoundException;
import com.lastMinute.exercise.utils.FareCalculator;
import com.lastMinute.exercise.utils.FlightUtils;

public class FlightsDAO {

	public List<FlightInfo> searchFlight(String origin, String destination, Date departureDate, int adults,
			int children, int infants) throws NotFoundException {
		List<FlightInfo> result = new ArrayList<FlightInfo>();
		for (String[] element : Database.getFlights()) {
			if (origin.equals(element[0]) && destination.equals(element[1])) {
				InfantFareDAO infantDao = new InfantFareDAO();
				result.add(new FlightInfo(element[2], FareCalculator.getFare(adults, children, infants, departureDate,
						new BigDecimal(element[3]), infantDao.getInfantFare(FlightUtils.getCompany(element[2])))));

			}
		}
		return result;
	}
}
