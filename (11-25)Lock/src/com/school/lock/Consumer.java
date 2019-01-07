package com.school.lock;

import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Consumer extends Thread{
	private Resource r;
	public Consumer(Resource r) {
		// TODO �Զ����ɵĹ��캯�����
		this.r = r;
	}
	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName()+"������"+r.getNum());
		while(true){
			if(r.lock.tryLock()){
				try{
					
						if(r.getNum() <= 0){
							r.cc.await();
						}else{
							r.num--;
							r.pc.signalAll();
							System.out.println(Thread.currentThread().getName()+"��Ʒ������"+r.getNum());
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
