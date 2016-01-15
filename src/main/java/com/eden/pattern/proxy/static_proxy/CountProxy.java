package com.eden.pattern.proxy.static_proxy;

public class CountProxy implements Count {

	private CountImpl countImpl;

	public CountProxy(CountImpl countImpl) {
		this.countImpl = countImpl;
	}

	public void queryCount() {
		System.out.println("before query...");
		countImpl.queryCount();
		System.out.println("after query...");
	}

	public void updateCount() {
		System.out.println("before update...");
		countImpl.updateCount();
		System.out.println("after update...");
	}

}
