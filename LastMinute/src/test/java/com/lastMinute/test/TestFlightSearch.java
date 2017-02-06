package com.lastMinute.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.lastMinute.exercise.beans.FlightInfo;
import com.lastMinute.exercise.exception.LastMinuteException;
import com.lastMinute.exercise.exception.NotFoundException;
import com.lastMinute.exercise.services.FlightSearchService;
import com.lastMinute.exercise.utils.Constants;
import com.lastMinute.exercise.utils.DateUtils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestFlightSearch extends TestCase {

	/**
	 * More than 30 days with adults
	 */
	public void test1() {
		GregorianCalendar departureDate = getToday();
		departureDate.add(Calendar.DATE, 31);
		try {
			SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT);
			List<FlightInfo> flights = new FlightSearchService("AMS", "FRA", format.format(departureDate.getTime()), 1,
					0, 0).execute();
			assertTrue(flights.toString().equals("[TK2372,157.60, TK2659,198.40, LH5909,90.40]"));
		} catch (LastMinuteException e) {
			fail();
		}
	}

	/**
	 * Between 15 and 30 days. With adults, children and infants
	 */
	public void test2() {
		GregorianCalendar departureDate = getToday();
		departureDate.add(Calendar.DATE, 15);
		try {
			SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT);
			List<FlightInfo> flights = new FlightSearchService("LHR", "IST", format.format(departureDate.getTime()), 2,
					1, 1).execute();
			assertTrue(flights.toString().equals("[TK8891,806.00, LH1085,481.19]"));
		} catch (LastMinuteException e) {
			fail();
		}
	}

	/**
	 * Less than 3 days. With adults and children
	 */
	public void test3() {
		GregorianCalendar departureDate = getToday();
		departureDate.add(Calendar.DATE, 2);
		try {
			SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT);
			List<FlightInfo> flights = new FlightSearchService("BCN", "MAD", format.format(departureDate.getTime()), 1,
					2, 0).execute();
			assertTrue(flights.toString().equals("[IB2171,909.09, LH5496,1028.43]"));
		} catch (LastMinuteException e) {
			fail();
		}
	}

	/**
	 * No flights
	 */
	public void test4() {
		GregorianCalendar departureDate = getToday();
		departureDate.add(Calendar.DATE, 2);
		try {
			SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT);
			new FlightSearchService("CDG", "FRA", format.format(departureDate.getTime()), 1, 2, 0).execute();
			fail();
		} catch (NotFoundException e) {
			// OK
		} catch (LastMinuteException e) {
			fail();
		}
	}

	/**
	 * More than 30 days. Adults, children and infants
	 */
	public void test5() {
		GregorianCalendar departureDate = getToday();
		departureDate.add(Calendar.DATE, 31);
		try {
			SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT);
			List<FlightInfo> flights = new FlightSearchService("AMS", "FRA", format.format(departureDate.getTime()), 2,
					3, 4).execute();
			assertTrue(flights.toString().equals("[TK2372,651.98, TK2659,815.58, LH5909,390.50]"));
		} catch (LastMinuteException e) {
			fail();
		}
	}

	/**
	 * Less than 3 days. Adults, children and infants
	 */
	public void test6() {
		GregorianCalendar departureDate = getToday();
		departureDate.add(Calendar.DATE, 2);
		try {
			SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT);
			List<FlightInfo> flights = new FlightSearchService("BCN", "MAD", format.format(departureDate.getTime()), 4,
					3, 2).execute();
			assertTrue(flights.toString().equals("[IB2171,2354.89, LH5496,2655.40]"));
		} catch (LastMinuteException e) {
			fail();
		}
	}

	/**
	 * No origin
	 */
	public void test7() {
		GregorianCalendar departureDate = getToday();
		departureDate.add(Calendar.DATE, 2);
		try {
			SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT);
			new FlightSearchService("", "MAD", format.format(departureDate.getTime()), 4, 3, 2).execute();
			fail();
		} catch (LastMinuteException e) {
			// Ok
		}
	}

	/**
	 * No destination
	 */
	public void test8() {
		GregorianCalendar departureDate = getToday();
		departureDate.add(Calendar.DATE, 2);
		try {
			SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT);
			new FlightSearchService("MAD", null, format.format(departureDate.getTime()), 4, 3, 2).execute();
			fail();
		} catch (LastMinuteException e) {
			// Ok
		}
	}

	/**
	 * No date
	 */
	public void test9() {
		GregorianCalendar departureDate = getToday();
		departureDate.add(Calendar.DATE, 2);
		try {
			new FlightSearchService("MAD", "BCN", null, 4, 3, 2).execute();
			fail();
		} catch (LastMinuteException e) {
			// Ok
		}
	}

	/**
	 * No people
	 */
	public void test10() {
		GregorianCalendar departureDate = getToday();
		departureDate.add(Calendar.DATE, 2);
		try {
			SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT);
			new FlightSearchService("BCN", "MAD", format.format(departureDate.getTime()), 0, 0, 0).execute();
			fail();
		} catch (LastMinuteException e) {
			// Ok
		}
	}

	/**
	 * Example with negative adults
	 */
	public void test11() {
		GregorianCalendar departureDate = getToday();
		departureDate.add(Calendar.DATE, 2);
		try {
			SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT);
			new FlightSearchService("BCN", "MAD", format.format(departureDate.getTime()), -1, 1, 0).execute();
			fail();
		} catch (LastMinuteException e) {
			// Ok
		}
	}

	/**
	 * Example with negative children
	 */
	public void test12() {
		GregorianCalendar departureDate = getToday();
		departureDate.add(Calendar.DATE, 2);
		try {
			SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT);
			new FlightSearchService("BCN", "MAD", format.format(departureDate.getTime()), 1, -2, 1).execute();
			fail();
		} catch (LastMinuteException e) {
			// Ok
		}
	}

	/**
	 * Ejemplo with negative infants
	 */
	public void test13() {
		GregorianCalendar departureDate = getToday();
		departureDate.add(Calendar.DATE, 2);
		try {
			SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT);
			new FlightSearchService("BCN", "MAD", format.format(departureDate.getTime()), 1, 1, -1).execute();
			fail();
		} catch (LastMinuteException e) {
			// Ok
		}
	}

	public GregorianCalendar getToday() {
		GregorianCalendar date = new GregorianCalendar();
		date.setTime(DateUtils.getToday());
		return date;
	}

	public static Test suite() {
		return new TestSuite(TestFlightSearch.class);
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}

}