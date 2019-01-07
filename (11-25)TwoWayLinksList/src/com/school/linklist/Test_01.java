package com.school.linklist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Test_01 {
	public static void main(String[] args) throws Throwable {
		My_TwoWaysLinksList pre = null;
		My_TwoWaysLinksList next = null;
		My_TwoWaysLinksList entry = null;
		List<My_TwoWaysLinksList> list = new ArrayList<My_TwoWaysLinksList>();
		for(int i = 0 ; i<10 ;i++){
			if(i==0){
				list.add(new My_TwoWaysLinksList(null, null, String.valueOf(i)));
			}else{
				list.add(new My_TwoWaysLinksList(list.get(i-1), null, String.valueOf(i)));
				if(i<10){
					list.get(i-1).setNext(list.get(i));
				}
			}
		}
		remove(5, list);
		System.out.println(list.size());
		My_TwoWaysLinksList head = list.get(list.size()-1);
		while(head.getPre()!=null){
			System.out.println(head.getDate());
			head = head.getPre();
		}
	}
	
	
	
	public static void remove(int index,List<My_TwoWaysLinksList> list) throws Throwable{
		list.get(index).pre.next = list.get(index).next;
		list.get(index).next.pre = list.get(index).pre;
		list.remove(index);
	}
}
