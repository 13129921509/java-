package com.school.proxy;

public class Business {
	public void create(){
		try {
			Thread.sleep(2000);
			System.out.println("业务创建");
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
