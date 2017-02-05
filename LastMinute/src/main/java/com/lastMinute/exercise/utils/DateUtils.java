package com.lastMinute.exercise.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class DateUtils {

	public static long daysTillDate(Date date) {

		return TimeUnit.DAYS.convert(date.getTime() - getToday().getTime(), TimeUnit.MILLISECONDS);
	}

	public static Date getToday() {
		Calendar now = new GregorianCalendar();
		now.set(Calendar.HOUR, 0);
		now.set(Calendar.MINUTE, 0);
		now.set(Calendar.SECOND, 0);
		now.set(Calendar.MILLISECOND, 0);
		return now.getTime();
	}
}
