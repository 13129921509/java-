package com.school.hashmap.test;

import java.util.Map;

public class CellecttionsMethodObj extends Thread{
	private String name;
	private Map<?,?> map;
	public CellecttionsMethodObj(String name,Map<?,?> map) {
		this.name = name;
		this.map = map;
	}
	final Object obj = new Object();
	@Override
	public void run() {
		//synchronized (map) {
			// TODO 自动生成的方法存根
			
			while(!(map.size()==0)){
				System.out.println(name+":一进来就看见"+map.size());
				map.remove(map.size());
				synchronized (obj) {
					System.out.println(name+":map还剩下"+map.size());
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				//map.notifyAll();
			}
			System.out.println(name+":map已经null");
		//}
		
	}
}
