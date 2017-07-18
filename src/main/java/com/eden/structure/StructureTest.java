package com.eden.structure;

public class StructureTest {

	public static void main(String[] args) {
		MyList<String> myList = new MyList<String>();
		myList.add("ooo");
		myList.add("222");
		System.out.println(myList.size());
		System.out.println(myList.get(1));
	}

}
