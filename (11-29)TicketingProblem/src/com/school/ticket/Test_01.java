package com.school.ticket;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test_01 {
	/*
	 * ��Ʊ����
	 * 1000Ʊ�б�� 10����
	 */
	/*
	 * ʹ��ͬ���鷽ʽ
	 * Ч�ʺܵ�
	 */
	static List<Integer> list = new ArrayList<Integer>();
	class Business{
		public void get(){
			synchronized (list) {
				System.out.println(Thread.currentThread().getName()+"�Ѿ�������"+list.get(0));
				list.remove(list.get(0));
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
		Business b = new Test_01().new Business();
		Thread t1 = new Thread(new Test_01().new Windows(b),"��Ʊ����1:");
		Thread t2 = new Thread(new Test_01().new Windows(b),"��Ʊ����2:");
		Thread t3 = new Thread(new Test_01().new Windows(b),"��Ʊ����3:");
		Thread t4 = new Thread(new Test_01().new Windows(b),"��Ʊ����4:");
		Thread t5 = new Thread(new Test_01().new Windows(b),"��Ʊ����5:");
		Thread t6 = new Thread(new Test_01().new Windows(b),"��Ʊ����6:");
		Thread t7 = new Thread(new Test_01().new Windows(b),"��Ʊ����7:");
		Thread t8 = new Thread(new Test_01().new Windows(b),"��Ʊ����8:");
		Thread t9 = new Thread(new Test_01().new Windows(b),"��Ʊ����9:");
		Thread t10 = new Thread(new Test_01().new Windows(b),"��Ʊ����10:");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
	}
	
	public static void initList(){
		for(int i = 1 ; i <= 1000 ; i++ ){
			list.add(i);
		}
	}
}
