package com.school.proxy;

public class Car implements Car_Move{

	@Override
	public void move() {
		// TODO 自动生成的方法存根
		System.out.println("行驶开始");
	}

	@Override
	public void stop_move() {
		// TODO 自动生成的方法存根
		System.out.println("行驶结束");
	}
}
