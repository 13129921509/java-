package com.school.Pands;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test_01 {
	public static void main(String[] args) throws InterruptedException {
		Lock lock = new ReentrantLock();
		Condition pc = lock.newCondition();
		Condition cc = lock.newCondition();
		Resource r = new Resource(lock,pc,cc);
		Producer p1 = new Producer(r);
		Consumer c4 = new Consumer(r);
		Consumer c5 = new Consumer(r);
		
		p1.start();
		c4.start();
		c5.start();
	}
}
