package com.school.proxy;

public class Static_Proxy extends Business{
	
	public void create() {
		// TODO 自动生成的方法存根
		long start = System.currentTimeMillis();
		super.create();
		long end = System.currentTimeMillis();
		System.out.println("日志记录:业务花费的时间"+(end-start)+"毫秒");
	}
}
