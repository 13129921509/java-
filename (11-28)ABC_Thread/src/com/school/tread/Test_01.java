package com.school.tread;
/*
 * ��Ŀ����A��B��C�����߳�,��A�߳����A��B�߳����B��
 *  C�߳����C��Ҫ��ͬʱ���������߳�,����˳�����ABC��ѭ��10�Ρ�
 *  �����Ŀ���ֵ�Ƶ�ʺܸ߰�
 */
public class Test_01 {
	static int num=0;
	class Biness{
		int count=0;
		String obj;
		public Biness(String obj) {
			// TODO �Զ����ɵĹ��캯�����
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
					System.out.println("����:"+count+"��");
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
				// TODO �Զ����ɵķ������
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
				// TODO �Զ����ɵķ������
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
				// TODO �Զ����ɵķ������
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
