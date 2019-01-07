package com.school.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CarProxyHandler implements InvocationHandler{
	//通过构造函数传入，我们实现泛型规范的基础
	private Class<?> proxyId;
	//我们不关心，传入的业务实体类，直接将其实例化为Object
	private Object obj;
	public CarProxyHandler(Class<?> proxyId) throws InstantiationException, IllegalAccessException {
		//实例的代码
		this.obj = proxyId.newInstance();
	}
	//工厂模式提供实例
	public Object getInstance(){
		//obj2是代理类返回的业务实体类的实例，我们返回他
		Object obj2 = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
		return obj2;
	}
	
	//此方法能够拦截指定业务类的方法，可以做日志操作
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("日志开始");
		// TODO 自动生成的方法存根
		method.invoke(obj, args);
		System.out.println("日志结束");
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
