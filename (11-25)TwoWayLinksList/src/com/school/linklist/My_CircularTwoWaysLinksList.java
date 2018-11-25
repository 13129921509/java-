package com.school.linklist;
/*
 * My_CircularTwoWaysLinksList拓展了双向链表My_Pack_TwoWaysLinksList
 * 形成了 循环的双向链表
 */
public class My_CircularTwoWaysLinksList extends My_Pack_TwoWaysLinksList{
	private Note head;
	private Note nowNote;
	public My_CircularTwoWaysLinksList() {
		// TODO 自动生成的构造函数存根

	}
	/*
	 * 采用
	 * @see com.school.linklist.My_Pack_TwoWaysLinksList#traverseLinkList()
	 */
	@Override
	public void traverseLinkList() {
		// TODO 自动生成的方法存根
		head = super.getHead();
		nowNote = super.getNowNode();
		head = head.getNext();
		nowNote.setNext(head);
		head.setPre(nowNote);
		Note h = head;
		while(true){
			System.out.println(h.getDate());
			h = h.getNext();
		}
		
	}
}
