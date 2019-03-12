package com.appjishu.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/** 
* @author  Frank Liu
* @version 创建时间：2017年3月7日 下午2:16:24 
* 类说明 
*/
public class DateUtil {	
	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
//	public static void main(String[] args) {
//    	Date currentDate = new Date();
//    	Date endDate = DateUtil.addByMinute(currentDate, -30);
//    	String endDateStr = DateUtil.format(endDate);
//    	
//    	
//    	Date startDate = DateUtil.addByHour(currentDate, -3);
//    	String startDateStr = DateUtil.format(startDate);
//    	
//    	System.out.println("startDateStr, " + startDateStr);
//    	System.out.println("endDateStr, " + endDateStr);
//	}
	
	public static Date parse(String date) {
		Date result = null;
		try {
			result = formatter.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static String format(Date date) {
		return formatter.format(date);
	}
	
	public static Date addByHour(Date date, int amount) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, amount);
		return calendar.getTime();
	}
	
	public static Date addByDay(Date date, int amount) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, amount);
		return calendar.getTime();
	}
	
	public static Date addByMinute(Date date, int amount) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, amount);
		return calendar.getTime();
	}
}
