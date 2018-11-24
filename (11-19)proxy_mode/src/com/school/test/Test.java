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
 * Ŀ��:1.ʵ��jdk��̬����
 * 	   2.ʵ�ַ��͹��ܵĶ�̬����
 * 	   3.ʵ�ֶ�̬����Ĺ���ģʽ
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
		 * Ŀ�ģ����ǲ���Ҫ��עCarProxyHandler�ڲ���ϸ�ڣ�ֻ��Ҫ�ṩҵ�����class���Լ��ṩ�����Ľӿڣ��Ϳ���ʵ�ֶ�̬����
		 * �ô�����������־����ļ�¼����������ʱ�䡭��
		 * 
		 */
		Car_Move car = (Car_Move) new CarProxyHandler(Car.class).getInstance();
		car.stop_move();
		System.out.println("-------------------");
		car.move();
		System.out.println("-------�л����г�����--------");
		car = (Car_Move) new CarProxyHandler(Back.class).getInstance();
		car.stop_move();
		System.out.println("-------------------");
		car.move();
		System.out.println("-------��������-------");
		Car_Maintain car2 = (Car_Maintain)new CarProxyHandler(Back.class).getInstance();
		car2.maintain();
	}
}
