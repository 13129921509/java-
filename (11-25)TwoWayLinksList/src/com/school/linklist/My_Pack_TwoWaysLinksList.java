package com.school.linklist;

/*
 * My_Pack_TwoWaysLinksList����Ϊ˫�������ģ����
 * ͨ����������ʵ�ּ򵥵Ľڵ㣨Note����ɾ���
 */
public class My_Pack_TwoWaysLinksList {
	private Note head;//ͷ���
	private Note nowNode;//ͷ���
	private volatile int size;
	public My_Pack_TwoWaysLinksList(){
		head = new Note();
		nowNode = head;
		size = 0;
	}
	/*
	 * �ѽڵ���������β��
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
	 * ��ͷ����������
	 */
	
	public void traverseLinkList(){
		Note h = head.next;
		while (h != null) {
			System.out.println(h.date);
			h = h.next;
		}
	}
	
	/*
	 * ��β����������
	 */
	public void reTraverseLinkList(){
		Note note = nowNode;
		while(note != null&&note.pre != null){
			System.out.println(note.date);
			note = note.pre;
		}
	}
	
	/*
	 * ��ѯĳ��note
	 */
	public Object get(int index) throws Exception{
		if(index>size){
			throw new Exception("index��������");
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
	 * ��ͷ����������
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
	/*----------------�ڵ���---------------------*/
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
