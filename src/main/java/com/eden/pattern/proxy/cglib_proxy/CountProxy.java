package com.eden.pattern.proxy.cglib_proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CountProxy implements MethodInterceptor {

	// private Object target;
	//
	// public Object bind(Object target) {
	// this.target = target;
	// return Proxy.newProxyInstance(target.getClass().getClassLoader(),
	// target.getClass().getInterfaces(), this);
	// }
	//
	// public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	// Object result = null;
	// System.out.println("before...");
	// result = method.invoke(target, args);
	// System.out.println("after...");
	// return result;
	// }

	private Object target;

	public Object getInstance(Object target) {
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		// 回调方法
		enhancer.setCallback(this);
		// 创建代理对象
		return enhancer.create();
	}

	// 回调方法
	public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("before...");
		proxy.invokeSuper(object, args);
		System.out.println("after...");
		return null;
	}

}
