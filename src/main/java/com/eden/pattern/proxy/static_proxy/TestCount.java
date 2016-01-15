package com.eden.pattern.proxy.static_proxy;

public class TestCount {

	public static void main(String[] args) {
		CountImpl countImpl = new CountImpl();
		CountProxy countProxy = new CountProxy(countImpl);
		countProxy.queryCount();
		countProxy.updateCount();
	}

}
