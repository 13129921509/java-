package com.school.Pands;

import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Consumer extends Thread{
	private Resource r;
	public Consumer(Resource r) {
		// TODO 自动生成的构造函数存根
		this.r = r;
	}
	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName()+"已启动"+r.getNum());
		while(true){
			r.jianNum();
		}
	}
}
