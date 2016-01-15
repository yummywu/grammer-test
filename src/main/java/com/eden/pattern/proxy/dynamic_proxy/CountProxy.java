package com.eden.pattern.proxy.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CountProxy implements InvocationHandler {

	private Object target;

	public Object bind(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		System.out.println("before...");
		result = method.invoke(target, args);
		System.out.println("after...");
		return result;
	}

//	private CountImpl countImpl;
//
//	public CountProxy(CountImpl countImpl) {
//		this.countImpl = countImpl;
//	}
//
//	public void queryCount() {
//		System.out.println("before query...");
//		countImpl.queryCount();
//		System.out.println("after query...");
//	}
//
//	public void updateCount() {
//		System.out.println("before update...");
//		countImpl.updateCount();
//		System.out.println("after update...");
//	}

}
