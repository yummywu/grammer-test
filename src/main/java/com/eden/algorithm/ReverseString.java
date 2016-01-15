package com.eden.algorithm;

public class ReverseString {

	public static void main(String[] args) {
		String str1 = "wu, yaming, man";
		System.out.println(reverse(str1));
	}

	public static String reverse(String str) {
		char[] charArray = str.toCharArray();
		int begin = 0;
		int end = charArray.length;
		while (begin < end) {
			char temp = charArray[begin];
			charArray[begin] = charArray[end - 1];
			charArray[end - 1] = temp;
			begin++;
			end--;
		}
		return String.valueOf(charArray);
	}
}
