package com.lastMinute.exercise.utils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtils {

	/**
	 * @param date a date 
	 * @return the number of days from current date till the given date
	 */
	public static long daysTillDate(Date date) {

		return TimeUnit.DAYS.convert(date.getTime() - getToday().getTime(), TimeUnit.MILLISECONDS);
	}

	/**
	 * @return current Date without time
	 */
	public static Date getToday() {
		return org.apache.commons.lang.time.DateUtils.truncate(new Date(), java.util.Calendar.DAY_OF_MONTH);
	}
}
