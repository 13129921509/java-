package com.school.proxy;

public class Back implements Car_Move,Car_Maintain{

	@Override
	public void move() {
		System.out.println("���г�������");
		
	}

	@Override
	public void stop_move() {
		// TODO �Զ����ɵķ������
		System.out.println("���г�ֹͣ��");
	}

	@Override
	public void maintain() {
		// TODO �Զ����ɵķ������
		System.out.println("��������");
	}

}
