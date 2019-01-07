package com.school.hashmap.test;

import java.util.Map;

public class MethodObj extends Thread{
	private String name;
	private Map<?,?> map;
	public MethodObj(String name,Map<?,?> map) {
		this.name = name;
		this.map = map;
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		while(!(map.size()==0)){
			map.remove(map.size());
			System.out.println(name+":map还剩下"+map.size());
		}
		System.out.println(name+":map已经null");
	}
}
