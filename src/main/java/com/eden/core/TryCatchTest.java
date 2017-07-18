package com.eden.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TryCatchTest {

	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "a");
		map.put("a", "b");
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("mm dd");
		Date aDate = new Date();
		dateFormat.format(aDate);
		try {
			dateFormat.parse("11.5");
		} catch (ParseException e) {
			System.out.println("error hello!!");
			e.printStackTrace();
//			return;
//			System.out.println("sdfs");
		} finally {
			System.out.println("finally run or not");
		}
		
		System.out.println("run or not?");
	}

}
