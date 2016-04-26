package com.eden.core;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {

	public static void main(String[] args) {
		//HashMap 查询快，不同步
		Map<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("a", "aaa");
		hashMap.put("b", "bbb");
		hashMap.put("c", "ccc");
		hashMap.put("d", "ddd");
		Iterator<String> iterator = hashMap.keySet().iterator();
		while (iterator.hasNext()) {
			Object key = iterator.next();
			System.out.println("map.get(key) is :" + hashMap.get(key));
		}
		
		//Hashtable 支持同步
		Hashtable<String, String> hashTable = new Hashtable<String, String>();
		hashTable.put("a", "aaa");
		hashTable.put("b", "bbb");
		hashTable.put("c", "ccc");
		hashTable.put("d", "ddd");
		Iterator<String> iterator_1 = hashTable.keySet().iterator();
		while (iterator_1.hasNext()) {
			Object key = iterator_1.next();
			System.out.println("tab.get(key) is :" + hashTable.get(key));
		}
		
		//TreeMap 按键排序，不同步
		Map<String, String> treeMap = new TreeMap<String, String>();
		treeMap.put("c", "ccc");
		treeMap.put("a", "aaa");
		treeMap.put("d", "ddd");
		treeMap.put("b", "bbb");
		Iterator<String> iterator_2 = treeMap.keySet().iterator();
		while (iterator_2.hasNext()) {
			Object key = iterator_2.next();
			System.out.println("tmp.get(key) is :" + treeMap.get(key));
		}
		
		//LinkedHashMap 按插入顺序，不同步
		Map<String, String> linkedHashMap = new LinkedHashMap<String, String>();
		linkedHashMap.put("b", "aaa");
		linkedHashMap.put("a", "bbb");
		linkedHashMap.put("c", "ddd");
		linkedHashMap.put("d", "ccc");
		Iterator<String> iterator_3 = linkedHashMap.keySet().iterator();
		while (iterator_3.hasNext()) {
			Object key = iterator_3.next();
			System.out.println("tmp.get(key) is :" + linkedHashMap.get(key));
		}
	}

}
