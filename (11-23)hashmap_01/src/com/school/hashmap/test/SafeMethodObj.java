package com.school.hashmap.test;

import java.util.Map;

public class SafeMethodObj extends Thread{
	private String name;
	private Map<?,?> map;
	public SafeMethodObj(String name,Map<?,?> map) {
		this.name = name;
		this.map = map;
	}
	@Override
	public void run() {
		synchronized (map) {
			// TODO 自动生成的方法存根
			System.out.println(name+":一进来就看见"+map.size());
			while(!(map.size()==0)){
				map.remove(map.size());
				System.out.println(name+":map还剩下"+map.size());
				try {
					map.wait(1000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				map.notifyAll();
			}
			System.out.println(name+":map已经null");
		}
		
	}

}
