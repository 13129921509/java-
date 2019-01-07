package com.school.threadpoolexecutor.CachedThreadPool;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test_01 {
	static ExecutorService executor;
	
	static Map<Integer,Object> map = new HashMap<Integer, Object>();//new LockMap<Integer, Object>(new HashMap());
	static ObjRunner r = new ObjRunner(map);
	public static void main(String[] args) {
		initMap(map);
		executor = Executors.newCachedThreadPool();
		executor.execute(r);
		executor.execute(r);
		executor.execute(r);
		executor.execute(r);
		executor.execute(r);
		executor.shutdown();
	}
	
	
	
	static void initMap(Map<Integer,Object> map){
		map.put(1, new Object());
		map.put(2, new Object());
		map.put(3, new Object());
		map.put(4, new Object());
		map.put(5, new Object());
		
		map.put(6, new Object());
		map.put(7, new Object());
		map.put(8, new Object());
		map.put(9, new Object());
		
	}
}
