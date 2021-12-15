package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class CalendarCuliculator {
	
	public static Date ParseStrDatetimeToDate(String strDatetime) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = dateFormat.parse(strDatetime);
		return date;
	}
	
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
	public static Calendar ParseStrDatetimeToCalender(String strDatetime) throws ParseException{
		Date date = model.CalendarCuliculator.ParseStrDatetimeToDate(strDatetime);
		Calendar cl = model.CalendarCuliculator.DateToCalendar(date);
		return cl;
	}
	
	public static String AddDaysToStrDate(int d,String str) throws ParseException{
		
		Date date = model.CalendarCuliculator.ParseStringToDate(str);
		Calendar cal = model.CalendarCuliculator.DateToCalendar(date);
		cal.add(Calendar.DAY_OF_MONTH, d);
		date = model.CalendarCuliculator.CalendarToDate(cal);
		String result = model.CalendarCuliculator.DateToString(date);		
		return result;
		
	}
	public static int UnixtimeNow() {
		return(int) (System.currentTimeMillis()/1000L);
	}
	public static String StrCalendarNow() {
		Calendar cl = Calendar.getInstance();
		Date date = model.CalendarCuliculator.CalendarToDate(cl);
		String str = model.CalendarCuliculator.DateToString(date);
		return str + " 00:00:00";
	}

	public static String StrCalendarNowTime() {
		Calendar cl = Calendar.getInstance();
		Date date = cl.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String str = format.format(date);
		return str;
		
		
	}
	public static String DatetimeThisMonthFirstDay() {
		Calendar cl = Calendar.getInstance();
		Date date = cl.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		String str = format.format(date) + "-01 00:00:00";
		return str;
		
	}
	public static String DatetimeThisMonthLastDay() {
		Calendar cl = Calendar.getInstance();
		int LastDayOfMonth = cl.getActualMaximum(Calendar.DATE);
		Date date = cl.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		String str = format.format(date) + "-" + LastDayOfMonth + " 23:59:59";
		return str;
	}
}