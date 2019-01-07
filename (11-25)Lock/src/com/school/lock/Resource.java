package com.school.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.plaf.SliderUI;

public class Resource {
	public int num = 10;
	public Lock lock;
	public Condition cc;
	public Condition pc;
	public Resource(Lock lock, Condition cc, Condition pc) {
		// TODO �Զ����ɵĹ��캯�����
		this.lock = lock;
		this.cc = cc;
		this.pc = pc;
	}

	public void addNum(){
		if(lock.tryLock()){
			try{
				
				if(getNum() >= 30){
					pc.await();
					System.out.println(Thread.currentThread().getName()+"�ȴ�");
				}else{
					num++;
					cc.signalAll();
					System.out.println(Thread.currentThread().getName()+"��Ʒ������"+getNum());
					Thread.sleep(300);
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
	}
	}

	public void jianNum(){
		if(lock.tryLock()){
			try{
				
					if(getNum() <= 0){
						cc.await();
					}else{
						num--;
						pc.signalAll();
						System.out.println(Thread.currentThread().getName()+"��Ʒ������"+getNum());
						Thread.sleep(300);
					}
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
		}
	}
	protected int getNum() {
		return num;
	}

	protected void setNum(int num) {
		this.num = num;
	}
	
	
}
