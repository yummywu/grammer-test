package com.eden.core;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateTest {

	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		
		//format Date
		Date date = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		System.out.println(formater.format(date));
		
		//format TimeZone Date
		SimpleDateFormat japanFormater = new SimpleDateFormat("日本时间：yy-MM-dd HH:mm:ss");
		japanFormater.setTimeZone(TimeZone.getTimeZone("Japan"));
		System.out.println(japanFormater.format(date));

		//use Calendar to show hour, minute, second
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		System.out.println(calendar.get(Calendar.DATE) + ":" + calendar.get(Calendar.HOUR));
		
		//use GregorianCalendar to show hour, minute, second
		Calendar japanCalendar = new GregorianCalendar(TimeZone.getTimeZone("Japan"));
		System.out.println(japanCalendar.get(Calendar.DATE) + ":" + japanCalendar.get(Calendar.HOUR));
	}

}
