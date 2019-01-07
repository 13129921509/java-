package com.school.Pands;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Producer extends Thread{
	private Resource r;
	public Producer(Resource r) {
		this.r = r;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"ÒÑÆô¶¯"+r.getNum());
		while(true){
			r.addNum();
		}
	}
}

