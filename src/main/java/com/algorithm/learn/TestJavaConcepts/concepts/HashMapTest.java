package com.algorithm.learn.TestJavaConcepts.concepts;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HashMapTest<K, V> {
	
	public static void main(String[] args) {
		System.out.println(Float.isNaN(0.0f/0.0f));
	}
	/**
	 * 当需要进行synchronized处理时，对其进行笼统地包装也可以
	 */
	public void synchronizedMap() {
		Collections.synchronizedMap(new HashMap<>());
	}

	/**
	 * map中的值也可以进行判定是否存在
	 */
	public void testValue() {
		Map<String, String> map = new HashMap<>();
		map.put(null, "123");
		System.out.println(map.containsValue("123"));
	}


}
