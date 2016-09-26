package com.eden.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {

	public static void main(String[] args) {
		List<String> listA = new ArrayList<String>();
		listA.add("a");
		listA.add("b");
		listA.add("c");
		Iterator<String> iterator = listA.iterator();
		while(iterator.hasNext()) {
			/*Note that Iterator.remove is the only safe way
			 * to modify a collection during iteration.
			 */
			String s = iterator.next();
			iterator.remove();
			System.out.println(s);
		}
	}

}
