package com.school.threadpoolexecutor.CachedThreadPool;

import java.util.Map;
import java.util.Set;

public class ObjRunner implements Runnable{
	private Map map;
	public ObjRunner(Map map) {
		// TODO 自动生成的构造函数存根
		this.map = map;
	}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		System.out.println(Thread.currentThread().getName()+":进来啦"+map.size());
		while(!(map.size()==0)){
			System.out.println(Thread.currentThread().getName()+":"+map.size());
			map.remove(map.size());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+":结束了"+map.size());
	}

}
