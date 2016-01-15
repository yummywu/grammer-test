package com.eden.pattern.proxy.cglib_proxy;

public class TestCount {

	public static void main(String[] args) {
//		CountImpl countImpl = new CountImpl();
//		CountProxy countProxy = new CountProxy(countImpl);
//		countProxy.queryCount();
//		countProxy.updateCount();
		
//		CountProxy countProxy = new CountProxy();
//		Count count = (Count)countProxy.bind(new CountImpl());
//		count.queryCount();
//		count.updateCount();
		
		CountProxy countProxy = new CountProxy();
		CountImpl countImpl = (CountImpl)countProxy.getInstance(new CountImpl());
		countImpl.queryCount();
		countImpl.updateCount();
		
		
	}

}
