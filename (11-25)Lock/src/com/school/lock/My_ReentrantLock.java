package com.school.lock;

import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class My_ReentrantLock extends Thread{
	static Lock lock = new ReentrantLock();
	Condition c1 = lock.newCondition();
	volatile Map<Integer, Object> map;
	private static Object obj = new Object();
	public My_ReentrantLock(Map<Integer, Object> map) {
		// TODO �Զ����ɵĹ��캯�����
		this.map = map;
	}
	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		try {
				lock.lock();
				System.out.println(Thread.currentThread().getName()+":map����"+map.size());
				while(map.get(map.size()) != null){
					map.remove(map.size());
					System.out.println(Thread.currentThread().getName()+":mapʣ��"+map.size());
				}
				System.out.println(Thread.currentThread().getName()+":mapʣ��"+map.size());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();;
		}finally{
			lock.unlock();
			System.out.println("����");
		}
		
	}
}
