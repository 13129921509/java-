package com.school.proxy;

public class Static_Proxy extends Business{
	
	public void create() {
		// TODO �Զ����ɵķ������
		long start = System.currentTimeMillis();
		super.create();
		long end = System.currentTimeMillis();
		System.out.println("��־��¼:ҵ�񻨷ѵ�ʱ��"+(end-start)+"����");
	}
}
