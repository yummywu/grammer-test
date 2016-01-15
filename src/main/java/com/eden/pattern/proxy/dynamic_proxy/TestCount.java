package com.eden.pattern.proxy.dynamic_proxy;

public class TestCount {

	public static void main(String[] args) {
//		CountImpl countImpl = new CountImpl();
//		CountProxy countProxy = new CountProxy(countImpl);
//		countProxy.queryCount();
//		countProxy.updateCount();
		
		CountProxy countProxy = new CountProxy();
		Count count = (Count)countProxy.bind(new CountImpl());
		count.queryCount();
		count.updateCount();
	}

}
