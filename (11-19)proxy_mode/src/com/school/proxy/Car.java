package com.school.proxy;

public class Car implements Car_Move{

	@Override
	public void move() {
		// TODO �Զ����ɵķ������
		System.out.println("��ʻ��ʼ");
	}

	@Override
	public void stop_move() {
		// TODO �Զ����ɵķ������
		System.out.println("��ʻ����");
	}
}
