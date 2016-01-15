package com.eden.dto;

public class Student {
	String name;
	int age;
	String gender;

	public Student() {
		System.out.println("student");
	}

	public Student(String name, int age, String gender) {
		this.age = age;
		this.name = name;
		this.gender = gender;
		System.out.println(age + ":" + name + ":" + gender);
	}
}


class GoodStudent extends Student {
	boolean isGood;

	public GoodStudent() {
		System.out.println("good student");
	}

	public GoodStudent(String name, int age, String gender, boolean isGood) {
		super(name, age, gender);
		this.age = age;
		this.name = name;
		this.gender = gender;
		this.isGood = isGood;
		System.out.println(age + ":" + name + ":" + gender + ":" + isGood);
	}
}