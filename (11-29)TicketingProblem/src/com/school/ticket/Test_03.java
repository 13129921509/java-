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
	 * ��Ʊ����
	 * 1000Ʊ�б�� 10����
	 */
	/*
	 * ʹ�ò������У���Ϊ���ڲ�������ԭ���Ե�
	 * ���Կ���ʹ�̰߳�ȫ
	 */
	static Queue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
	class Business{
		public void get(){
			System.out.println(Thread.currentThread().getName()+"������:"+queue.poll());
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
			while(!queue.isEmpty()){
				b.get();
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
			
		}
	}
	public static void main(String[] args) {
		initQueue();
		Business b = new Test_03().new Business();
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
			executorService.execute(new Test_03(). new Windows(b));
		}
	}
	
	public static void initQueue(){
		for(int i = 0 ; i < 1000 ; i++){
			queue.offer(i);
		}
	}
}
