package com.school.hashmap.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test_01 {
	/*
	 * 主要验证HashMap的数据是不安全的
	 * 设定2个（或多个）对象，同时访问临界资源
	 * 是否会报错
	 */
	public static Map<Integer,Object> hashMap = new HashMap<Integer,Object>();
	
	
	private static void initMap(){
		hashMap.put(1, new Object());
		hashMap.put(2, new Object());
		hashMap.put(3, new Object());
		hashMap.put(4, new Object());
		hashMap.put(5, new Object());
		hashMap.put(6, new Object());
		hashMap.put(7, new Object());
		hashMap.put(8, new Object());
		hashMap.put(9, new Object());
		
	}
	private static int roundUpToPowerOf2(int number) {
        // assert number >= 0 : "number must be non-negative";
        return Integer.highestOneBit((number - 1) << 1);
    }
	
	public static void main(String[] args) throws InterruptedException {
//		MethodObj o1 = new MethodObj("o1", hashMap);
//		MethodObj o2 = new MethodObj("o2", hashMap);
//		MethodObj o3 = new MethodObj("o3", hashMap);
		//System.out.println(roundUpToPowerOf2(10));
		//hashMap = Collections.synchronizedMap(hashMap);
		hashMap = new ConcurrentHashMap<Integer, Object>(hashMap);
		CellecttionsMethodObj o1 = new CellecttionsMethodObj("o1", hashMap);
		CellecttionsMethodObj o2 = new CellecttionsMethodObj("o2", hashMap);
		CellecttionsMethodObj o3 = new CellecttionsMethodObj("o3", hashMap);
		initMap();
		o1.join();
		o2.join();
		o3.join();
		o1.start();
		o2.start();
		o3.start();
		/*
		 * 	o2:map还剩下6
			o3:map还剩下6
			o1:map还剩下6
			o3:map还剩下4
			o2:map还剩下5
			o3:map还剩下2
			o1:map还剩下3
			o3:map还剩下0
			o2:map还剩下1
			o2:map已经null
			o1:map已经null
			o3:map已经null
			结果明显是错乱的，显然此时map并不是线程安全的
		 */
	}
}
