package com.school.Pands;

import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Consumer extends Thread{
	private Resource r;
	public Consumer(Resource r) {
		// TODO �Զ����ɵĹ��캯�����
		this.r = r;
	}
	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName()+"������"+r.getNum());
		while(true){
			r.jianNum();
		}
	}
}
