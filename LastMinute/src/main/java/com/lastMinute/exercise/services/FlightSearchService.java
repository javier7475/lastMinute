package com.lastMinute.exercise.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

import com.lastMinute.exercise.beans.FlightInfo;
import com.lastMinute.exercise.dao.FlightsDAO;
import com.lastMinute.exercise.exception.LastMinuteException;
import com.lastMinute.exercise.exception.NotFoundException;
import com.lastMinute.exercise.utils.Constants;

/**
 * Implements the flight search service
 *
 */
public class FlightSearchService implements IService {

	public List<FlightInfo> searchFlight(String origin, String destination, String departureDate, int adults,
			int children, int infants) throws LastMinuteException {
		List<FlightInfo> result;
		try {
			result = new FlightsDAO().searchFlight(origin, destination,
					new SimpleDateFormat(Constants.DATE_FORMAT).parse(departureDate), adults, children, infants);
		} catch (ParseException e) {
			throw new LastMinuteException("Invalid date");
		}
		if (result.isEmpty()) {
			throw new NotFoundException("No flights found");
		} else {
			return result;
		}
	}

	@Override
	public void validate(String json) throws LastMinuteException {

	}

	public void validate(String origin, String destination, String departureDate, int adults, int children, int infants)
			throws LastMinuteException {
		if (!StringUtils.isEmpty(origin)) {
			throw new LastMinuteException("Origin mandatory");
		}
		if (!StringUtils.isEmpty(destination)) {
			throw new LastMinuteException("Destination mandatory");
		}
		try {
			new SimpleDateFormat("dd/MM/yyyy").parse(departureDate);
		} catch (ParseException e) {
			throw new LastMinuteException("Invalid date");
		}
		if (adults < 0) {
			throw new LastMinuteException("Invalid number of adults");
		}
		if (children < 0) {
			throw new LastMinuteException("Invalid number of children");
		}
		if (infants < 0) {
			throw new LastMinuteException("Invalid number of infants");
		}
	}

	@Override
	public JSONObject execute(String json) throws LastMinuteException {
		// TODO Auto-generated method stub
		return null;
	}

}
