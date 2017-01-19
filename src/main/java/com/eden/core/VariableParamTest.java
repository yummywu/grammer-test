package com.eden.core;

import java.util.Arrays;
import java.util.List;

public class VariableParamTest {

	public static void main(String[] args) {
		System.out.println("begin....");
		System.out.println(add(1,2,3,4,5));
		System.out.println(add(5,5));
		System.out.println("end...");
		
		String aa = "12342,767";
		String bb = "12342";
		List<String> aaList = Arrays.asList(aa.split(","));
		List<String> bbList = Arrays.asList(bb.split(","));
	}
	
	public static int add(int... list) {
		int sum = 0;
		for (int i : list) {
			sum = sum + i;
		}
		return sum;
	}

}
