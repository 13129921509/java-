package com.school.tread;
/*
 * 题目：有A，B，C三个线程,，A线程输出A，B线程输出B，
 *  C线程输出C，要求，同时启动三个线程,，按顺序输出ABC，循环10次。
 *  这道题目出现的频率很高啊
 */
public class Test_01 {
	static int num=0;
	class Biness{
		int count=0;
		String obj;
		public Biness(String obj) {
			// TODO 自动生成的构造函数存根
			this.obj = obj;
		}
		
		public void put(){
			if(num%3 == 0){
				if(obj.equals("a")){
					System.out.println(obj);
					this.count++;
					num++;
				}else{
					Thread.yield();
				}
			}else if(num%3 == 1){
				if(obj.equals("b")){
					System.out.println(obj);
					this.count++;
					num++;
				}else{
					Thread.yield();
				}
			}else if(num%3 == 2){
				if(obj.equals("c")){
					System.out.println(obj);
					this.count++;
					num++;
					System.out.println("进入:"+count+"次");
				}else{
					Thread.yield();
				}
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		
		Thread a = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO 自动生成的方法存根
				Biness b = new Test_01().new Biness("a");
				while (true) {
					if(b.count == 50){
						break;
					}else{
						b.put();
					}
				}
			}
		});
		Thread b = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO 自动生成的方法存根
				Biness b = new Test_01().new Biness("b");
				while (true) {
					if(b.count == 50){
						break;
					}else{
						b.put();
					}
				}
			}
		});
		Thread c = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO 自动生成的方法存根
				Biness b = new Test_01().new Biness("c");
				while (true) {
					if(b.count == 50){
						break;
					}else{
						b.put();
					}
				}
			}
		});
		
		a.start();
		b.start();
		c.start();
	}
}
