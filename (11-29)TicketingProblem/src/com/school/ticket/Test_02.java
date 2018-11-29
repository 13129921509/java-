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
	 * ��Ʊ����
	 * 1000Ʊ�б�� 10����
	 */
	Lock lock = new ReentrantLock();
	static List<Integer> list = new ArrayList<Integer>();
	class Business{
		public void get(){
			try {
				lock.lock();
				System.out.println(Thread.currentThread().getName()+"�Ѿ�������"+list.get(0));
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
			// TODO �Զ����ɵķ������
			while(list.size()!=0){
				b.get();
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
			
		}
	}
	public static void main(String[] args) {
		initList();
		Business b = new Test_02().new Business();
//		Thread t1 = new Thread(new Test_02().new Windows(b),"��Ʊ����1:");
//		Thread t2 = new Thread(new Test_02().new Windows(b),"��Ʊ����2:");
//		Thread t3 = new Thread(new Test_02().new Windows(b),"��Ʊ����3:");
//		Thread t4 = new Thread(new Test_02().new Windows(b),"��Ʊ����4:");
//		Thread t5 = new Thread(new Test_02().new Windows(b),"��Ʊ����5:");
//		Thread t6 = new Thread(new Test_02().new Windows(b),"��Ʊ����6:");
//		Thread t7 = new Thread(new Test_02().new Windows(b),"��Ʊ����7:");
//		Thread t8 = new Thread(new Test_02().new Windows(b),"��Ʊ����8:");
//		Thread t9 = new Thread(new Test_02().new Windows(b),"��Ʊ����9:");
//		Thread t10 = new Thread(new Test_02().new Windows(b),"��Ʊ����10:");
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
