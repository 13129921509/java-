package com.school.proxy;

public class Back implements Car_Move,Car_Maintain{

	@Override
	public void move() {
		System.out.println("自行车启动啦");
		
	}

	@Override
	public void stop_move() {
		// TODO 自动生成的方法存根
		System.out.println("自行车停止啦");
	}

	@Override
	public void maintain() {
		// TODO 自动生成的方法存根
		System.out.println("车辆保养");
	}

}
