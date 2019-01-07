package com.school.ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test_02 {
	/*
	 * 售票问题
	 * 1000票有编号 10窗口
	 */
	Lock lock = new ReentrantLock();
	static List<Integer> list = new ArrayList<Integer>();
	class Business{
		public void get(){
			try {
				lock.lock();
				System.out.println(Thread.currentThread().getName()+"已经卖出了"+list.get(0));
				list.remove(list.get(0));
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
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
			while(list.size()!=0){
				b.get();
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			
		}
	}
	public static void main(String[] args) {
		initList();
		Business b = new Test_02().new Business();
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
			executorService.execute(new Test_02(). new Windows(b));
		}
	}
	
	public static void initList(){
		list = Collections.synchronizedList(list);
		for(int i = 1 ; i <= 1000 ; i++ ){
			list.add(i);
		}
	}
}
