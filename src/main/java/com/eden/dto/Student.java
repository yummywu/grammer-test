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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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