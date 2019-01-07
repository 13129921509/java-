package com.school;

import java.io.Serializable;

public class PersonTager implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1180520472312796954L;
	private static String AGE = "26";
	private String name;
	private String sex;
	private String brithday;
	transient private String car;
	protected String getBrithday() {
		return brithday;
	}
	protected void setBrithday(String brithday) {
		this.brithday = brithday;
	}
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected String getSex() {
		return sex;
	}
	protected void setSex(String sex) {
		this.sex = sex;
	}
	protected String getCar() {
		return car;
	}
	protected void setCar(String car) {
		this.car = car;
	}
	
	@Override
	public String toString() {
		// TODO 自动生成的方法存根
		return "PersonTager{name:"+name+",car:"+car+",sex:"+sex+"+,AGE:"+AGE+"}";
	}
}
