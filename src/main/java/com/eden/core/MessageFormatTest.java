package com.eden.core;

import java.text.MessageFormat;

public class MessageFormatTest {

	public static void main(String[] args) {
		String s1  = "this is a {0} test, {1}";
		String formatedStr = MessageFormat.format(s1, "format", "haha");
		System.out.println(formatedStr);
	}

}
