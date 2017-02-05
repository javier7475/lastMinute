package com.lastMinute.test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.lastMinute.exercise.beans.FlightInfo;
import com.lastMinute.exercise.dao.FlightsDAO;
import com.lastMinute.exercise.exception.NotFoundException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestFlightSearch extends TestCase {

	public void test1() {
		GregorianCalendar departureDate = new GregorianCalendar();
		departureDate.add(Calendar.DATE, 31);
		try {
			List<FlightInfo> flights = new FlightsDAO().searchFlight("AMS", "FRA", departureDate.getTime(), 1, 0, 0);
			assertTrue(flights.toString().equals("[TK2372,157.60, TK2659,198.40, LH5909,90.40]"));
		} catch (NotFoundException e) {
			assertTrue(false);
		}
	}
	
	public void test2() {
		GregorianCalendar departureDate = new GregorianCalendar();
		departureDate.add(Calendar.DATE, 15);
		try {
			List<FlightInfo> flights = new FlightsDAO().searchFlight("LHR", "IST", departureDate.getTime(), 2, 1, 1);
			assertTrue(flights.toString().equals("[TK8891,806.00, LH1085,481.19]"));
		} catch (NotFoundException e) {
			assertTrue(false);
		}
	}

	public void test3() {
		GregorianCalendar departureDate = new GregorianCalendar();
		departureDate.add(Calendar.DATE, 2);
		try {
			List<FlightInfo> flights = new FlightsDAO().searchFlight("BCN", "MAD", departureDate.getTime(), 1, 2, 0);
			assertTrue(flights.toString().equals("[IB2171,909.09, LH5496,1028.43]"));
		} catch (NotFoundException e) {
			assertTrue(false);
		}
	}
	
	public void test4() {
		GregorianCalendar departureDate = new GregorianCalendar();
		departureDate.add(Calendar.DATE, 2);
		try {
			List<FlightInfo> flights = new FlightsDAO().searchFlight("CDG", "FRA", departureDate.getTime(), 1, 2, 0);
			assertTrue(flights.toString().equals("[a]"));
		} catch (NotFoundException e) {
			assertTrue(false);
		}
	} 
	
	public static Test suite() {
		return new TestSuite(TestFlightSearch.class);
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}

}