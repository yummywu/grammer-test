package com.eden.core;

public class VariableParamTest {

	public static void main(String[] args) {
		System.out.println(add(1,2,3,4,5));
	}
	
	public static int add(int... list) {
		int sum = 0;
		for (int i : list) {
			sum = sum + i;
		}
		return sum;
	}

}
