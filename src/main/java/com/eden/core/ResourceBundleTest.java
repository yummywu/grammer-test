package com.eden.core;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class ResourceBundleTest {

	public static void main(String[] args) {
		ResourceBundle bundle = ResourceBundle.getBundle("Message");
		String s1 = bundle.getString("msg.no.provided");
		
		String formatedStr = MessageFormat.format(s1, "kitty");
		System.out.println(formatedStr);
	}

}
