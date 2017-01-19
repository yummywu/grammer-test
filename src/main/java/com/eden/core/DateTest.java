package com.eden.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateTest {

	public static void main(String[] args) throws ParseException {
//		java.util.Date nowdate=new java.util.Date(); 
//		String myString = "2008-09-08";
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.CHINA);
//
//		Date d = sdf.parse(myString);
//		boolean flag = d.before(nowdate);
//		if(flag)
//		System.out.print("早于今天");
//		else
//		System.out.print("晚于今天");
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM--dd HH:mm:ss");
//		sdf.setTimeZone(TimeZone.getTimeZone("Turkey"));//GMT+02:00
//		Date aDate = new Date();
//		String snow = sdf.format(aDate); // snow = 2011-12-04 21:22:24
//		System.out.println(snow);
//		
//		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM--dd HH:mm:ss");
//		sdf2.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
//		Date date = sdf2.parse(snow);
//		System.out.println(date);
		
//		String siReceiveTimeStr = "22 Oct 2016, 05:39";
//        SimpleDateFormat formatterGMT = new SimpleDateFormat("dd MMM yyyy, HH:mm");
////        formatterGMT.setTimeZone(TimeZone.getTimeZone("GMT"));
//        Date recvTime =formatterGMT.parse(siReceiveTimeStr);
//		System.out.println(recvTime);
		
//		TimeZone zone = TimeZone.getTimeZone("GMT+02:00");
//		Calendar cal = Calendar.getInstance(zone);
//		Date date = cal.getTime();
//		System.out.println(date);
		
//		Date d1 = new Date();
//		Date d2 = new Date();
//		Date d3 = new Date();
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.CHINA);
//		String formatedD1 = sdf.format(d1);
//		Date parsedD1 = sdf.parse(formatedD1);
//		
//		System.out.println(parsedD1);
//		System.out.println(d1.getTime());
//		System.out.println(d2.getTime());
//		System.out.println(d3.getTime());
//		System.out.println(d1);
//		System.out.println(d2);
//		System.out.println(d1.before(d2));
//		System.out.println(d1.after(d3));
		
		String siReceiveTimeStr = "22 Oct 2016, 05:39";
        SimpleDateFormat formatterGMT = new SimpleDateFormat("dd MMM yyyy, HH:mm");
        formatterGMT.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date siReceiveTime =formatterGMT.parse(siReceiveTimeStr);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy, HH:mm");  
        dateFormat.setTimeZone(TimeZone.getTimeZone("Turkey"));  
        String siReceiveTimeInTurkeyStr = dateFormat.format(siReceiveTime);
        
        Date siReceiveTimeInTurkey = new SimpleDateFormat("dd MMM yyyy, HH:mm").parse(siReceiveTimeInTurkeyStr);
        System.out.println(siReceiveTimeInTurkey);
	}

}
