package com.eden.structure;

public class MyList<T> {
	Object[] data = null;
	int current;
	int capacity;
	
	public MyList() {
		this(10);
	}
	
	public MyList(int initSize) {
		this.data = new Object[initSize];
		current = 0;
	}
	
	public boolean add(T t) {
		//if 容量够
		data[current] = t;
		current++;
		return true;
	}
	
	public boolean remove() {
		return true;
	}
	
	public T get(int index) {
		return (T)data[index];
	}
	
	public int size() {
		return current;
	}
	
}
