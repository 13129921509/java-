package com.school.linklist;

/*
 * My_Pack_TwoWaysLinksList：作为双向链表的模板类
 * 通过几个方法实现简单的节点（Note）赠删查改
 */
public class My_Pack_TwoWaysLinksList {
	private Note head;//头结点
	private Note nowNode;//头结点
	private volatile int size;
	public My_Pack_TwoWaysLinksList(){
		head = new Note();
		nowNode = head;
		size = 0;
	}
	/*
	 * 把节点放入链表的尾部
	 */
	public void afterLinks(Object date){
		Note note = new Note();
		note.setDate(date);
		nowNode.next = note;
		note.pre = nowNode;
		nowNode = note; 
		size ++; 
	}
	
	/*
	 * 从头部遍历链表
	 */
	
	public void traverseLinkList(){
		Note h = head.next;
		while (h != null) {
			System.out.println(h.date);
			h = h.next;
		}
	}
	
	/*
	 * 从尾部遍历链表
	 */
	public void reTraverseLinkList(){
		Note note = nowNode;
		while(note != null&&note.pre != null){
			System.out.println(note.date);
			note = note.pre;
		}
	}
	
	/*
	 * 查询某个note
	 */
	public Object get(int index) throws Exception{
		if(index>size){
			throw new Exception("index超出长度");
		}
		return getNote(index).date;
	}
	
	private Note getNote(int index){
		Note note = head.next;
		for(int i = 1 ; i < index;i++){
			note = note.next;
		}
		return note;
	}
	/*
	 * 从头部插入链表
	 */
	public void insertHead(Object date){
		Note newNote = new Note();
		newNote.date = date;
		Note headNext = head.next;
		head.next = newNote;
		newNote.next = headNext;
		newNote.pre = head;
		newNote.next.pre = newNote;
		size++;
	}
	
	public int size(){
		return size;
	}
	/*----------------节点类---------------------*/
	final static class Note{
		private Note pre;
		private Note next;
		private Object date;
		protected Note getPre() {
			return pre;
		}
		protected void setPre(Note pre) {
			this.pre = pre;
		}
		protected Note getNext() {
			return next;
		}
		protected void setNext(Note next) {
			this.next = next;
		}
		protected Object getDate() {
			return date;
		}
		protected void setDate(Object date) {
			this.date = date;
		}
	}
	protected Note getHead() {
		return head;
	}
	protected void setHead(Note head) {
		this.head = head;
	}
	protected Note getNowNode() {
		return nowNode;
	}
	protected void setNowNode(Note nowNode) {
		this.nowNode = nowNode;
	}
	
	
}
