package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilTime {
	/**
	 * Dateת��ΪString����*/
	public static String date2String(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date1 =  sdf.format(date);
		return date1;
	}
	/**
	 * ���ַ���"yyyy-MM-dd"����תתΪsql��date*/
	public static java.sql.Date utilDateSqlDate(String Date){
		Date date =null;
		DateFormat sft = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sft.parse(Date);//util-date
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (new java.sql.Date(date.getTime()));
	}
	/**
	 * CalendarתString*/
	public static String calendar2String(){
		Calendar calendar = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat();
		String date = df.format(calendar.getTime());
		return date;
	}
	/**
	 * StringתCalendar*/
	public static Calendar string2Calendar(){
		String date = "2017-10-13";
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = null;
		try {
			date1 = df.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date1);
		return calendar;
	}
	/**
	 * Calendarת��ΪDate*/
	public static Date calendar2Date(){
		Calendar calendar = Calendar.getInstance();
		java.util.Date date = calendar.getTime();
		return date;
	}
	/**
	 * Dateת��ΪCalendar*/
	public static Calendar date2Calendar(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return calendar;
	}
}
