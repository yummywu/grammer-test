package com.eden.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MapLockTest {

	public final static int THREAD_POOL_SIZE = 5;

	
	List<String> testList = Collections.synchronizedList(new ArrayList<String>()); 
	public static Map<String, Integer> hashTable = null;
	public static Map<String, Integer> synchronizedHashMap = null;
	public static Map<String, Integer> concurrentHashMap = null;

	public static void main(String[] args) throws InterruptedException {

		// Test with Hashtable Object
		hashTable = new Hashtable<String, Integer>();
		performTest(hashTable);

		// Test with synchronizedMap Object
		synchronizedHashMap = Collections.synchronizedMap(new HashMap<String, Integer>());
		performTest(synchronizedHashMap);

		// Test with ConcurrentHashMap Object
		concurrentHashMap = new ConcurrentHashMap<String, Integer>();
		performTest(concurrentHashMap);

	}

	public static void performTest(final Map<String, Integer> map) throws InterruptedException {
		System.out.println("Test started for: " + map.getClass());
		long averageTime = 0;
		for (int i = 0; i < 5; i++) {
			long startTime = System.nanoTime();
			ExecutorService exServer = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

			for (int j = 0; j < THREAD_POOL_SIZE; j++) {
				exServer.execute(new Runnable() {
					@SuppressWarnings("unused")
					public void run() {

						for (int i = 0; i < 500000; i++) {
							Integer randomNumber = (int) Math.ceil(Math.random() * 550000);

							// Retrieve value. We are not using it anywhere
							Integer value = map.get(String.valueOf(randomNumber));

							// Put value
							map.put(String.valueOf(randomNumber), randomNumber);
						}
					}
				});
			}

			// Make sure executor stops
			exServer.shutdown();

			// Blocks until all tasks have completed execution after a shutdown request
			exServer.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

			long entTime = System.nanoTime();
			long totalTime = (entTime - startTime) / 1000000L;
			averageTime += totalTime;
			System.out.println("2500K entried added/retrieved in " + totalTime + " ms");
		}
		System.out.println("For " + map.getClass() + " the average time is " + averageTime / 5 + " ms\n");
	}
}
