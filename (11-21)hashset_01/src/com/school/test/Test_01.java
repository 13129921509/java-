package com.school.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test_01 {
	Set set = new HashSet();
	
	public void t_addAll(){
		Collection con = new ArrayList();
		con.add("1");
		con.add(1);
		
		set.addAll(con);
		
	}
	
	public static void main(String[] args) {
		Test_01 t = new Test_01();
		t.t_addAll();
		//System.out.println(t.set.size());
//		Iterator iterator = t.set.iterator();
//		while(iterator.hasNext()){
//			System.out.println(iterator.next().getClass());
//		}
		//System.out.println(t.set.contains(1));
		t.set.add(1);
	}
}
