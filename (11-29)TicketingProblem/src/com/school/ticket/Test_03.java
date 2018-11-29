package com.school.ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test_03 {
	/*
	 * 售票问题
	 * 1000票有编号 10窗口
	 */
	/*
	 * 使用并发队列，因为其内部方法是原子性的
	 * 所以可以使线程安全
	 */
	static Queue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
	class Business{
		public void get(){
			System.out.println(Thread.currentThread().getName()+"销售了:"+queue.poll());
		}
		
	}
	
	class Windows implements Runnable{
		Business b;
		public Windows(Business b){
			this.b = b;
		}
		@Override
		public void run() {
			// TODO 自动生成的方法存根
			while(!queue.isEmpty()){
				b.get();
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			
		}
	}
	public static void main(String[] args) {
		initQueue();
		Business b = new Test_03().new Business();
//		Thread t1 = new Thread(new Test_02().new Windows(b),"售票窗口1:");
//		Thread t2 = new Thread(new Test_02().new Windows(b),"售票窗口2:");
//		Thread t3 = new Thread(new Test_02().new Windows(b),"售票窗口3:");
//		Thread t4 = new Thread(new Test_02().new Windows(b),"售票窗口4:");
//		Thread t5 = new Thread(new Test_02().new Windows(b),"售票窗口5:");
//		Thread t6 = new Thread(new Test_02().new Windows(b),"售票窗口6:");
//		Thread t7 = new Thread(new Test_02().new Windows(b),"售票窗口7:");
//		Thread t8 = new Thread(new Test_02().new Windows(b),"售票窗口8:");
//		Thread t9 = new Thread(new Test_02().new Windows(b),"售票窗口9:");
//		Thread t10 = new Thread(new Test_02().new Windows(b),"售票窗口10:");
//		
//		t1.start();
//		t2.start();
//		t3.start();
//		t4.start();
//		t5.start();
//		t6.start();
//		t7.start();
//		t8.start();
//		t9.start();
//		t10.start();
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		for(int i = 0 ; i < 10 ; i++){
			executorService.execute(new Test_03(). new Windows(b));
		}
	}
	
	public static void initQueue(){
		for(int i = 0 ; i < 1000 ; i++){
			queue.offer(i);
		}
	}
}
