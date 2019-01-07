package com.school.test;

import java.lang.reflect.Proxy;

import com.school.proxy.Back;
import com.school.proxy.Business;
import com.school.proxy.Car;
import com.school.proxy.CarProxyHandler;
import com.school.proxy.Car_Maintain;
import com.school.proxy.Car_Move;
import com.school.proxy.Static_Proxy;

/*
 * 目的:1.实现jdk动态代理
 * 	   2.实现泛型功能的动态代理
 * 	   3.实现动态代理的工厂模式
 */
public class Test {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
//		Static_Proxy static_Proxy = new Static_Proxy();
//		static_Proxy.create();
		
		/*CarProxyHandler cHandler = new CarProxyHandler(new Car());
		Class<?> obj = cHandler.getProxyId().getClass();
		Car_Move car = (Car_Move) Proxy.newProxyInstance(obj.getClassLoader(), obj.getInterfaces(), cHandler);
		car.move();*/
		//Class<?> object = 
		/*
		 * 目的：我们不需要关注CarProxyHandler内部的细节，只需要提供业务类的class，以及提供方法的接口，就可以实现动态代理
		 * 用处：可以做日志方面的记录，测试运行时间……
		 * 
		 */
		Car_Move car = (Car_Move) new CarProxyHandler(Car.class).getInstance();
		car.stop_move();
		System.out.println("-------------------");
		car.move();
		System.out.println("-------切换自行车车型--------");
		car = (Car_Move) new CarProxyHandler(Back.class).getInstance();
		car.stop_move();
		System.out.println("-------------------");
		car.move();
		System.out.println("-------车辆保养-------");
		Car_Maintain car2 = (Car_Maintain)new CarProxyHandler(Back.class).getInstance();
		car2.maintain();
	}
}
