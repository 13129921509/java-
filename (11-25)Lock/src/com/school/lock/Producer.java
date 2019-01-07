package com.school.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Producer extends Thread{
	private Resource r;
	public Producer(Resource r) {
		this.r = r;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"已启动"+r.getNum());
		while(true){
			if(r.lock.tryLock()){
				try{
					
					if(r.getNum() >= 30){
						r.pc.await();
						System.out.println(Thread.currentThread().getName()+"等待");
					}else{
						r.num++;
						r.cc.signalAll();
						System.out.println(Thread.currentThread().getName()+"商品生产有"+r.getNum());
						Thread.sleep(300);
					}
					
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					r.lock.unlock();
				}
		}
		}
	}
}

