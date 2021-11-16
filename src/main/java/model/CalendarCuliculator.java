package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarCuliculator {
	
	public static Date ParseStringToDate(String str) throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = dateFormat.parse(str);
		return date;
	}
	public static String DateToString (Date date) {
		String str = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		str = dateFormat.format(date);
		return str;
	}
	public static Calendar DateToCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
	public static Date CalendarToDate(Calendar cal) {
		Date date = cal.getTime();
		return date;
	}
	public static String AddDaysTostrDate(int d,String str) throws ParseException{
		
		Date date = model.CalendarCuliculator.ParseStringToDate(str);
		Calendar cal = model.CalendarCuliculator.DateToCalendar(date);
		cal.add(Calendar.DAY_OF_MONTH, d);
		date = model.CalendarCuliculator.CalendarToDate(cal);
		String result = model.CalendarCuliculator.DateToString(date);		
		return result;
		
	}
	
	
	
}