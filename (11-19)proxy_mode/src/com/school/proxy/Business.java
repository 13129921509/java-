package com.school.proxy;

public class Business {
	public void create(){
		try {
			Thread.sleep(2000);
			System.out.println("ҵ�񴴽�");
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
