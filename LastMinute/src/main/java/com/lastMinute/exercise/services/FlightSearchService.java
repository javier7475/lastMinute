package com.lastMinute.exercise.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.lastMinute.exercise.beans.FlightInfo;
import com.lastMinute.exercise.dao.FlightsDAO;
import com.lastMinute.exercise.exception.LastMinuteException;
import com.lastMinute.exercise.exception.NotFoundException;
import com.lastMinute.exercise.utils.Constants;

/**
 * Implements the flight search service
 *
 */
public class FlightSearchService extends Service<List<FlightInfo>> {

	private String origin;
	private String destination;
	private String departureDate;
	private int adults;
	private int children;
	private int infants;

	public FlightSearchService(String origin, String destination, String departureDate, int adults, int children,
			int infants) {

		this.origin = origin;
		this.destination = destination;
		this.departureDate = departureDate;
		this.adults = adults;
		this.children = children;
		this.infants = infants;

	}

	public void validateInput() throws LastMinuteException {
		if (StringUtils.isEmpty(origin)) {
			throw new LastMinuteException("Origin mandatory");
		}
		if (StringUtils.isEmpty(destination)) {
			throw new LastMinuteException("Destination mandatory");
		}
		if (StringUtils.isEmpty(departureDate)) {
			throw new LastMinuteException("Departure date mandatory");
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
		if (adults==0 && children==0 && infants==0) {
			throw new LastMinuteException("The number of people is required");
		}
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public int getAdults() {
		return adults;
	}

	public void setAdults(int adults) {
		this.adults = adults;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public int getInfants() {
		return infants;
	}

	public void setInfants(int infants) {
		this.infants = infants;
	}

	@Override
	protected List<FlightInfo> doAction() throws LastMinuteException {
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

}
