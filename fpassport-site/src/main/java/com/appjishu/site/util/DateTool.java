package com.appjishu.site.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class DateTool {

	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat FORMAT1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	public static final SimpleDateFormat FORMAT_HHMMSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	//  格式化日期为字符串   "yyyy-MM-dd   hh:mm"   
	public static  String   formatDateTime(Date   basicDate,String   strFormat)   {   
		SimpleDateFormat   df   =   new   SimpleDateFormat(strFormat);   
		return   df.format(basicDate);   
	}  
	
	
	/**
	 * 字符串格式转换为date类型
	 * @param strFormat
	 * @return
	 */
	 public static Date stringToDate(String strFormat) { 
 		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

 		Date date  = null;  
	        try {  
	             date = df.parse(strFormat);   
	        } catch (ParseException e) {  
	            e.printStackTrace();  
	        }  
	         return date;  
	    }
	
	 
	 /**
	 * 字符串格式转换为date类型
	 * @param strFormat
	 * @return
	 */
	 public static Date stringToDateFormat(String strFormat) { 
 		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

 		Date date  = null;  
	        try {  
	             date = df.parse(strFormat);   
	        } catch (ParseException e) {  
	            e.printStackTrace();  
	        }  
	         return date;  
	    }
	 
	 
	//   格式化日期为字符串   "yyyy-MM-dd   hh:mm"   
	public  static String   formatDateTime(String   basicDate,String   strFormat)   {   
		SimpleDateFormat   df   =   new   SimpleDateFormat(strFormat);   
		Date   tmpDate=null;   
		try   {   
			tmpDate=df.parse(basicDate);   
		}   
		catch(Exception   e)   {   
			//   日期型字符串格式错误   
		}   
		return   df.format(tmpDate);   
	}   

	
	//   当前日期加减n天后的日期，返回String   (yyyy-mm-dd)   
	public  static String   nDaysAftertoday(int   n)   {   
		SimpleDateFormat   df   =   new   SimpleDateFormat("yyyy-MM-dd");   
		Calendar   rightNow   =   Calendar.getInstance();   
		//rightNow.add(Calendar.DAY_OF_MONTH,-1);   
		rightNow.add(Calendar.DAY_OF_MONTH,+n);   
		return   df.format(rightNow.getTime());   
	}   
	
	
	//   当前日期加减n天后的日期，返回String   (yyyy-mm-dd HH:mm:ss)   
	public  static String   nDaysAftertodayTime(int   n)   {   
		SimpleDateFormat   df   =   new   SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
		Calendar   rightNow   =   Calendar.getInstance();   
		rightNow.add(Calendar.DAY_OF_MONTH,+n);   
		return   df.format(rightNow.getTime());   
	} 
	

	//   当前日期加减n天后的日期，返回String   (yyyy-mm-dd)   
	public  static Date   nDaysAfterNowDate(int   n)   {   
		Calendar   rightNow   =   Calendar.getInstance();   
		//rightNow.add(Calendar.DAY_OF_MONTH,-1);   
		rightNow.add(Calendar.DAY_OF_MONTH,+n);   
		return   rightNow.getTime();   
	}   

	
	//   给定一个日期型字符串，返回加减n天后的日期型字符串   
	public  static String   nDaysAfterOneDateString(String   basicDate,int   n)   {   
		SimpleDateFormat   df   =   new   SimpleDateFormat("yyyy-MM-dd");   
		Date   tmpDate   =   null;   
		try   {   
			tmpDate   =   df.parse(basicDate);   
		}   
		catch(Exception   e){   
			//   日期型字符串格式错误   
		}   
		long   nDay=(tmpDate.getTime()/(24*60*60*1000)+1+n)*(24*60*60*1000);   
		tmpDate.setTime(nDay);   

		return   df.format(tmpDate);   
	}   

	
	//   给定一个日期，返回加减n天后的日期   
	public static  Date   nDaysAfterOneDate(Date   basicDate,int   n)   {   
		long   nDay=(basicDate.getTime()/(24*60*60*1000)+1+n)*(24*60*60*1000);   
		basicDate.setTime(nDay);   
		return   basicDate;   
	}   

	
	//   计算两个日期相隔的天数   
	public  static int   nDaysBetweenTwoDate(Date   firstDate,Date   secondDate)   {   
		int   nDay=(int)((secondDate.getTime()-firstDate.getTime())/(24*60*60*1000));   
		return   nDay;   
	}   

	
	//   计算两个日期相隔的天数   
	public  static int   nDaysBetweenTwoDate(String   firstString,String   secondString)   {   
		SimpleDateFormat   df   =   new   SimpleDateFormat("yyyy-MM-dd");   
		Date   firstDate=null;   
		Date   secondDate=null;   
		try   {   
			firstDate   =   df.parse(firstString);   
			secondDate=df.parse(secondString);   
		}   
		catch(Exception   e)   {   
			//   日期型字符串格式错误   
		}   

		int   nDay=(int)((secondDate.getTime()-firstDate.getTime())/(24*60*60*1000));   
		return   nDay;   
	}   
	
	
	/**
	 * 以时间为基础创建ID
	 * 
	 * @param name
	 * @return
	 */
	public static synchronized String getIdByTime(String name) {
		return name + "-" + getCurrDate() + "-" + getCurrTime()
				+ getRandomNumber();
	}

	
	/**
	 * 取得字符串格式的当前日期
	 * 
	 * @return
	 */
	public static String getCurrDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}
	

	/**
	 * 取得字符串格式的当前时间
	 * 
	 * @return
	 */
	public static String getCurrTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(".HH.mm.ss");
		return formatter.format(date);
	}
	
	
	public static String getTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(date);
	}
	
	
	/**
	 * 获取分钟 秒 毫秒---生成邀请码用
	 * @return
	 */
	public static String getMillTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("mmssSSS");
		return formatter.format(date);
	}
	
	
	public static String getDate(Date date) {
 		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return formatter.format(date);
	}
	
	
	public static String getRandomNumber() {
		Random random = new Random();
		String retval = String.valueOf(random.nextInt(100));
		return retval;
	}

	
	/**
	 * 获取距离现在的时间
	 */
	public static String getMinutes(Date date) {
		long time =new Date().getTime()- date.getTime() ;// time 单位是 毫秒
		String res = null;
		// 转化成天数
		// 先判断是不是小于 60 * 1000 也就是 小于1分钟 ，那么显示 ： 刚刚

		if (time < 60 * 1000) {
			res = "刚刚";
		}
		// 先判断是不是小于 60 * 60 * 1000 也就是 小于1小时，那么显示 ： **分钟前
		else if (time < 60 * 60 * 1000) {
			res = (time / 1000 / 60) + "分钟前";
		}
		// 如果大于等于1小时 小于等于一天，那么显示 ： **小时前
		else if (time >= 60 * 60 * 1000 && time < 24 * 60 * 60 * 1000) {
			res = (time / 1000 / 60 / 60) + "小时前";
		}
		// 如果大于等于1小时 小于等于一天，那么显示 ： **小时前
	//	else if (time >= 24 * 60 * 60 * 1000) {
	//		res = (time / 1000 / 60 / 60 / 24) + "天前";
	//	}
		// 如果时间不明确或者发帖不足一分钟 ，则不显示
		else {
 
			res = FORMAT1.format(date);
 		}
		return res;
	}
	
	
	/**
	 * 以下为另外一种方式实现
	 */
	private static final int MINUTE = 60 * 1000;

	private static final int HOUR = 60 * MINUTE;


	public static String getPastTime(Date pastDate) {
		if (pastDate == null) {
			return null;
		}
		String time = "";
		try {
			Calendar currentCal = GregorianCalendar.getInstance();
			currentCal.setTime(FORMAT
					.parse(FORMAT.format(currentCal.getTime())));
			Calendar pastCal = GregorianCalendar.getInstance();
			pastCal.setTime(FORMAT.parse(FORMAT.format(pastDate)));
			pastCal.add(Calendar.DATE, 2);
			if (pastCal.before(currentCal)) {
				time = FORMAT.format(pastDate);
			} else {
				pastCal.add(Calendar.DATE, -1);
				if (pastCal.before(currentCal)) {
					time = "前天";
				} else {
					pastCal.add(Calendar.DATE, -1);
					if (pastCal.before(currentCal)) {
						time = "昨天";
					} else {
						currentCal = GregorianCalendar.getInstance();
						pastCal.setTime(pastDate);
						long timeLong = currentCal.getTime().getTime()
								- pastDate.getTime();
						pastCal.add(Calendar.MINUTE, 59);
						if (timeLong < 0) {
							time = "";
						} else if (pastCal.before(currentCal)) {
							time = String.valueOf(timeLong / HOUR) + "小时前";
						} else {
							pastCal.add(Calendar.MINUTE, -59);
							pastCal.add(Calendar.MINUTE, 4);
							pastCal.add(Calendar.SECOND, 59);
							if (pastCal.before(currentCal)) {
								time = String.valueOf(timeLong / MINUTE)
										+ "分钟前";
							} else {
								time = "刚刚";
							}
						}
					}
				}
			}
		} catch (ParseException e) {
			time = "";
		}
		return time;
	}
	
	
	/**
	 * 获取星期（中文如：‘星期一’）
	 * @param date
	 * @return
	 *String
	 *
	 */
	public static String getWeekdayString(String date){//必须yyyy-MM-dd
	    
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
	    
		SimpleDateFormat sdw = new SimpleDateFormat("E");
		Date d = null;
		
		try {
			d = sd.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    
		return sdw.format(d);
	}
	
	
	/**
	 * 根据输入的日期信息来拼写日期返回内容
	 * @param pastDate
	 * @return
	 */
	public static String getAfterTime(String  dateinfo) {
		String returndateinfo=getCurrDate();
		if (dateinfo == null || dateinfo.equals("")) {
			return returndateinfo+" 今天";
		}else if(dateinfo.equals("today")){
			return returndateinfo+" 今天";
		}
		else if(dateinfo.equals("tomorrow")){
 			return nDaysAftertoday(1)+" 明天";
		}else{
			returndateinfo="";
		}
		 
		return returndateinfo;
	}
	
	 
	/**
	 * 格式化时间
	 * @param format
	 * @param date
	 * @return
	 */
	public static String format(String format,Date date){
		if (null==date) {
			return null;
		}
		return new SimpleDateFormat(format).format(date);
	}
	
	
	/**
	 * 格式化时间戳 (yyyy-MM-dd HH:mm:ss)
	 * @param date
	 * @return
	 */
	public static String format(Long date){
		return format("yyyy-MM-dd HH:mm:ss", new Date(date));
	}
	
	
	/**
	 * 目标时间与当前时间比对
	 * @param date
	 * @return
	 *boolean
	 *
	 */
	public static boolean dateCompareNow(String date){
		Date targetDate = stringToDate(date);
		return targetDate.before(new Date());
	}
	
	
	/**
	 * 获得时间差（以天为单位）
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static long getDateDiff(Date startDate,Date endDate){
		long number = (endDate.getTime() - startDate.getTime())/(1000 * 60 * 60 * 24);
		double number_s = (endDate.getTime() - startDate.getTime())%(1000 * 60 * 60 * 24);
		if(number_s > 0){
			number = number+1;
		}
		return number;
	}
	

	//   计算日期与今天相隔的天数   
	public  static String   nDaysBetweenTwoDate(String   firstString)   {   
		SimpleDateFormat   df   =   new   SimpleDateFormat("yyyy-MM-dd");   
		Date   firstDate=null;   
		Date   secondDate=new Date();   
		try   {   
			firstDate   =   df.parse(firstString);   
		}   
		catch(Exception   e)   {   
			//   日期型字符串格式错误   
		}   
		int nDay = (int) ((firstDate.getTime() - secondDate.getTime()) / (24 * 60 * 60 * 1000));
		double number_s = (firstDate.getTime() - secondDate.getTime())
				% (1000 * 60 * 60 * 24);
		if (number_s > 0) {
			nDay = nDay + 1;
		}
		if (nDay > 1) {
			return firstString;
		} else if (nDay == 1) {
			return "明天";
		} else if (nDay == 0) {
			return "今天";
		} else {
			return firstString;
		}
	}
	
	//把String数据转成long型
	public static long getDateTime(String date){
		Date targetDate = stringToDate(date);
		return targetDate.getTime();
	}
	
	
	public static List<HashMap<String, String>> endDateListMap;
	public static List<HashMap<String, String>> endTimeListMap;
	static {
		initEndDateListMap();
		initEndTimeListMap();
	}
	
	
	private static void initEndDateListMap(){
		
		endDateListMap = new ArrayList<HashMap<String, String>>();
		
		for(int day=1; day<8; day++){
			HashMap<String, String> endDateMap = new HashMap<String, String>();
			
			String currDate = DateTool.nDaysAftertoday(day-1);
			endDateMap.put("date", currDate);
			endDateMap.put("desc", DateTool.getWeekdayString(currDate));
			endDateListMap.add(endDateMap);
		}
	}
	
	
	private static void initEndTimeListMap(){
		
		endTimeListMap = new ArrayList<HashMap<String, String>>();
		
		for(int hour=0; hour<24; hour++){
			HashMap<String, String> wholeVoteEndTimeMap = new HashMap<String, String>();
			HashMap<String, String> halfHourVoteEndTimeMap = new HashMap<String, String>();
			
			String desc = getCurrentEndTimeDesc(hour);
			
			wholeVoteEndTimeMap.put("desc", desc);
			halfHourVoteEndTimeMap.put("desc", desc);
			if(hour<10){
				wholeVoteEndTimeMap.put("time", "0" + hour + ":00" );
				halfHourVoteEndTimeMap.put("time", "0" + hour + ":30" );
			}else{
				wholeVoteEndTimeMap.put("time", hour + ":00" );
				halfHourVoteEndTimeMap.put("time", hour + ":30" );
			}
			endTimeListMap.add(wholeVoteEndTimeMap);
			endTimeListMap.add(halfHourVoteEndTimeMap);
		}
	}
	
	
	private static String getCurrentEndTimeDesc(int hour){
		
		return hour > 12 ? "下午" : "上午";
	}
	
		
	/**
	 * 返回changetime毫秒前的时间，格式yyyy-MM-dd HH：mm：ss
	 * @param time yyyy-MM-dd HH：mm：ss
	 * @param changetime 往前多少毫秒
	 * @return
	 */
	public static String getBeforeTime(String time,long changetime){
		String date = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			long currentTime = df.parse(time).getTime();
			long newtime = currentTime-changetime;
			
			date = df.format(newtime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}
	
	
	
	/**
	 * 根据生日字符串日期转换为实际年龄
	 * @param birthday 要处理的生日
	 * @return
	 */
//	public static int dateToAge(String birthday) {
//		if (!birthday.equals("")&&birthday!=null&&!birthday.equals("null")) {
//			birthday = birthday.substring(0, 10);
//			if (ValidateUtils.isBirthday(birthday)) {
//				int age = 0;
//				Date date = new Date();
//				String datenow = FORMAT.format(date.getTime());
//				// 当前年月日
//				int nowyear = Integer.parseInt(datenow.substring(0, 4));
//				int nowmonth = Integer.parseInt(datenow.substring(5, 7));
//				int nowday = Integer.parseInt(datenow.substring(8, 10));
//				// 生日年月日
//				int year = Integer.parseInt(birthday.substring(0, 4));
//				int month = Integer.parseInt(birthday.substring(5, 7));
//				int day = Integer.parseInt(birthday.substring(8, 10));
//				if (year == nowyear || year > nowyear) {//生日等于 或大于当前年份
//					return age;
//				} else {
//					if (month > nowmonth) { // 生日月份 大于 当前日期月份
//						age = nowyear - year - 1;
//
//					} else if (month < nowmonth) {//生日 月份 小于 当前日期月份
//						age = nowyear - year;
//
//					} else if (month == nowmonth) {//生日 月份 等于 当前日期月份
//						if (day < nowday|| day == nowday) {
//							age = nowyear - year;
//						} else {
//							age = nowyear - year - 1;
//						}
//					}
//					return age;
//				}
//			}
//		}
//		return 0;
//	}
	
	
	/**
	 * 根據日期解析出星座
	 * @param strDate 1990-05-01 格式
	 * @return
	 */
//	public static String dateToConstellation(String strDate) {
//		if(ValidateUtils.isBirthday(strDate)){
//			int month = Integer.parseInt(strDate.substring(5, 7));
//			int day = Integer.parseInt(strDate.substring(8, 10));
//			String[] starArr = { "魔羯座", "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座",
//					"巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座" };
//			int[] DayArr = { 20, 19, 21, 20, 21, 22, 23, 23, 23, 24, 23, 22 }; //每兩個星座(月份)之間的分割日
//			int index = month;
//			
//			if(month==12){
//				// day日期在分割日之前，索引-1，否则不变
//				if (day < DayArr[month - 1]) {
//					index = index - 1;
//				}
//				if(day>=DayArr[month - 1]){//12月大于分割日的，索引為0
//					index =0;
//				}
//			}else{
//				if (day < DayArr[month - 1]) {
//					index = index - 1;
//				}
//			}
//			// 返回索引指向的星座string
//			return starArr[index];
//		}
//		return "";
//		
//	}
	
	    /**
	     * @author：hxc
	     * @createtime ： 2014-10-10 下午3:44:55
	     * @description 获取两个时间之间的毫秒数
	     * @param sdate
	     * @param edate 
	     * @return
	     */
	    public static Long getDateSubtractionMillis(Date sdate, Date edate)
	    {
	        Calendar nowDate = Calendar.getInstance();
	        nowDate.setTime(sdate);
	        Calendar oldDate = Calendar.getInstance();
	        oldDate.setTime(edate);
	        long timeNow = nowDate.getTimeInMillis();
	        long timeOld = oldDate.getTimeInMillis();
	        return timeOld - timeNow;
	    }
}
