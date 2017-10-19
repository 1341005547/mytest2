package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilTime {
	/**
	 * Date转化为String类型*/
	public static String date2String(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date1 =  sdf.format(date);
		return date1;
	}
	/**
	 * 把字符串"yyyy-MM-dd"日期转转为sql的date*/
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
	 * Calendar转String*/
	public static String calendar2String(){
		Calendar calendar = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat();
		String date = df.format(calendar.getTime());
		return date;
	}
	/**
	 * String转Calendar*/
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
	 * Calendar转化为Date*/
	public static Date calendar2Date(){
		Calendar calendar = Calendar.getInstance();
		java.util.Date date = calendar.getTime();
		return date;
	}
	/**
	 * Date转化为Calendar*/
	public static Calendar date2Calendar(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return calendar;
	}
}
