package com.eden.pattern.proxy.static_proxy;

public class CountImpl implements Count {

	public void queryCount() {
		System.out.println("query...");
	}

	public void updateCount() {
		System.out.println("update...");
	}

}
