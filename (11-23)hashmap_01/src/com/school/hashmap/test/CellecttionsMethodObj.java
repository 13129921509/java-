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
			// TODO �Զ����ɵķ������
			
			while(!(map.size()==0)){
				System.out.println(name+":һ�����Ϳ���"+map.size());
				map.remove(map.size());
				synchronized (obj) {
					System.out.println(name+":map��ʣ��"+map.size());
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				//map.notifyAll();
			}
			System.out.println(name+":map�Ѿ�null");
		//}
		
	}
}
