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
			// TODO �Զ����ɵķ������
			System.out.println(name+":һ�����Ϳ���"+map.size());
			while(!(map.size()==0)){
				map.remove(map.size());
				System.out.println(name+":map��ʣ��"+map.size());
				try {
					map.wait(1000);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				map.notifyAll();
			}
			System.out.println(name+":map�Ѿ�null");
		}
		
	}

}
