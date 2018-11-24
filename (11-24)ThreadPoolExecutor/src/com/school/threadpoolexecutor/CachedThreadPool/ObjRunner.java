package com.school.threadpoolexecutor.CachedThreadPool;

import java.util.Map;
import java.util.Set;

public class ObjRunner implements Runnable{
	private Map map;
	public ObjRunner(Map map) {
		// TODO �Զ����ɵĹ��캯�����
		this.map = map;
	}
	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		System.out.println(Thread.currentThread().getName()+":������"+map.size());
		while(!(map.size()==0)){
			System.out.println(Thread.currentThread().getName()+":"+map.size());
			map.remove(map.size());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+":������"+map.size());
	}

}
