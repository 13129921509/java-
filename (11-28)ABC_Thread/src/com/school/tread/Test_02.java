package com.school.tread;

import com.school.tread.Test_01.Biness;

public class Test_02 {
	static String newstr1="";
	static String newstr2="";
	static String newstr3="";
	class Biness{
		String str;
		public Biness(String str) {
			// TODO 自动生成的构造函数存根
			this.str = str;
		}
		
		public String get(){
			return str;
		}
		
	}
	public static void main(String[] args) throws InterruptedException{
		final Biness b1 = new Test_02().new Biness("abc");
		final Biness b2 = new Test_02().new Biness("def");
		final Biness b3 = new Test_02().new Biness("ghi");
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO 自动生成的方法存根
				System.out.print(b1.get().toCharArray()[0]);
				System.out.print(b2.get().toCharArray()[0]);
				System.out.print(b3.get().toCharArray()[0]);
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO 自动生成的方法存根
				System.out.print(b1.get().toCharArray()[1]);
				System.out.print(b2.get().toCharArray()[1]);
				System.out.print(b3.get().toCharArray()[1]);
			}
		});
		
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO 自动生成的方法存根
				System.out.print(b1.get().toCharArray()[2]);
				System.out.print(b2.get().toCharArray()[2]);
				System.out.print(b3.get().toCharArray()[2]);
			}
		});
		
		t1.join();
		t2.join();
		t3.join();
		t1.start();
		t2.start();
		t3.start();
	}
}
