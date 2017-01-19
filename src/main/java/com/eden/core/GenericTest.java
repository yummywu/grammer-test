package com.eden.core;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {


	public static void main(String[] args) {
		List<String> testList = new ArrayList<String>();
		testList.add("aaa");
		String aString = test(testList, new ArrayList<String>());
		System.out.println(aString);
	}
	
	public static <Hello> Hello test(List<Hello> test, List<Hello> tes2) {
		return test.get(0); 
	}

}
