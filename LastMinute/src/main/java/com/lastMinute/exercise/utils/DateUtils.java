package com.lastMinute.exercise.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		SimpleDateFormat format=new SimpleDateFormat(Constants.DATE_FORMAT);
		try {
			return format.parse(format.format(now.getTime()));
		} catch (ParseException e) {
			// impossible to reach
			e.printStackTrace();
			return null;
		}
	}
}
