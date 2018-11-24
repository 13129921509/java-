package com.school.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CarProxyHandler implements InvocationHandler{
	//ͨ�����캯�����룬����ʵ�ַ��͹淶�Ļ���
	private Class<?> proxyId;
	//���ǲ����ģ������ҵ��ʵ���ֱ࣬�ӽ���ʵ����ΪObject
	private Object obj;
	public CarProxyHandler(Class<?> proxyId) throws InstantiationException, IllegalAccessException {
		//ʵ���Ĵ���
		this.obj = proxyId.newInstance();
	}
	//����ģʽ�ṩʵ��
	public Object getInstance(){
		//obj2�Ǵ����෵�ص�ҵ��ʵ�����ʵ�������Ƿ�����
		Object obj2 = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
		return obj2;
	}
	
	//�˷����ܹ�����ָ��ҵ����ķ�������������־����
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("��־��ʼ");
		// TODO �Զ����ɵķ������
		method.invoke(obj, args);
		System.out.println("��־����");
		return null;
	}

//
//	public Car getProxyId() {
//		return proxyId;
//	}
//
//
//	public void setProxyId(Car proxyId) {
//		this.proxyId = proxyId;
//	}
//
//	
	
}
