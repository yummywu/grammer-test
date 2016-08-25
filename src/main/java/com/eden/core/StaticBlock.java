package com.eden.core;

public class StaticBlock {

	public static void main(String args[]) {
		try {
			Class.forName("com.eden.core.Test");
			Class.forName("com.eden.core.Test");
			Class.forName("com.eden.core.Test").newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

class Test {
	public static int X = 100;
	public final static int Y = 200;

	public Test() {
		System.out.println("Test构造函数执行");
	}

	static {
		System.out.println("static语句块执行");
	}

	public static void display() {
		System.out.println("静态方法被执行");
	}

	public void display_1() {
		System.out.println("实例方法被执行");
	}
}
