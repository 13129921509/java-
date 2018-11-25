package com.school.lock;

import java.util.HashMap;
import java.util.Map;

public class Test_01 {
	static Map<Integer, Object> map = new HashMap<Integer, Object>();
	public static void main(String[] args) throws InterruptedException {
		initlist();
//		Thread t1 = new Thread(new My_ReentrantLock(map));
//		Thread t2 = new Thread(new My_ReentrantLock(map));
//		Thread t3 = new Thread(new My_ReentrantLock(map));
//		Thread t5 = new Thread(new My_ReentrantLock(map));
//		Thread t6 = new Thread(new My_ReentrantLock(map));
//		Thread t7 = new Thread(new My_ReentrantLock(map));
		Thread t1 = new My_ReentrantLock(map);
		Thread t2 = new My_ReentrantLock(map);
		Thread t3 = new My_ReentrantLock(map);
		Thread t5 = new My_ReentrantLock(map);
		Thread t7 = new My_ReentrantLock(map);
		Thread t6 = new My_ReentrantLock(map);
	
		t1.start();
		t2.start();
		t3.start();
		t5.start();
		t6.start();
		t7.start();
		
		System.out.println("Main:½áÊø");
	}
	
	public static void initlist(){
		map.put(1, new Object());
		map.put(2, new Object());
		map.put(3, new Object());
		map.put(4, new Object());
		map.put(5, new Object());
		map.put(6, new Object());
		
		map.put(7, new Object());
		map.put(8, new Object());
		map.put(9, new Object());
		
		map.put(10, new Object());
		map.put(11, new Object());
		map.put(12, new Object());
		
		map.put(13, new Object());
		map.put(14, new Object());
		map.put(15, new Object());
	}
}
