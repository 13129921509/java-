package com.school.linklist;

import java.util.List;

public class My_TwoWaysLinksList {
	public My_TwoWaysLinksList pre;
	public My_TwoWaysLinksList next;
	public String date;
	public My_TwoWaysLinksList(My_TwoWaysLinksList pre,My_TwoWaysLinksList next,String date) {
		// TODO �Զ����ɵĹ��캯�����
		this.pre=pre;
		this.next=next;
		this.date = date;
	}
	protected My_TwoWaysLinksList getNext() {
		return next;
	}
	protected void setNext(My_TwoWaysLinksList next) {
		this.next = next;
	}
	protected My_TwoWaysLinksList getPre() {
		return pre;
	}
	protected void setPre(My_TwoWaysLinksList pre) {
		this.pre = pre;
	}
	protected String getDate() {
		return date;
	}
	protected void setDate(String date) {
		this.date = date;
	}
	
	@Override
	protected void finalize() throws Throwable {
		// TODO �Զ����ɵķ������
		super.finalize();
	}
}
