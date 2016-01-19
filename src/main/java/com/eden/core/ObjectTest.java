package com.eden.core;

public class ObjectTest {

	public static void main(String[] args) {
		User  user = new User();
		change(user);
		System.out.println(user.getName());
	}
	
	public static void change(User u) {
		u.setName("hello world");
		u = new User();
		u.setName("bye");
	}
}

class User {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}