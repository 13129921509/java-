package com.school.hashmap.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test_01 {
	/*
	 * ��Ҫ��֤HashMap�������ǲ���ȫ��
	 * �趨2��������������ͬʱ�����ٽ���Դ
	 * �Ƿ�ᱨ��
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
		 * 	o2:map��ʣ��6
			o3:map��ʣ��6
			o1:map��ʣ��6
			o3:map��ʣ��4
			o2:map��ʣ��5
			o3:map��ʣ��2
			o1:map��ʣ��3
			o3:map��ʣ��0
			o2:map��ʣ��1
			o2:map�Ѿ�null
			o1:map�Ѿ�null
			o3:map�Ѿ�null
			��������Ǵ��ҵģ���Ȼ��ʱmap�������̰߳�ȫ��
		 */
	}
}
