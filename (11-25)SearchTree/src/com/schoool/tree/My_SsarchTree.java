package com.schoool.tree;

public class My_SsarchTree {
	private Note leftChild;
	private Note rightChild;
	private Note head;
	public My_SsarchTree() {
		// TODO 自动生成的构造函数存根 
	}
	
	@SuppressWarnings("null")
	public void insert(int num,Note note,Note parent){
		if(note == null){
			note = new Note();
			note.date = num;
			if(parent.date>note.date){
				System.out.println(note.date+"在"+parent.date+"的右边");
				parent.setRightChild(note);
			}else{
				System.out.println(note.date+"在"+parent.date+"的左边");
				parent.setLeftChild(note);
			}
			return ;
		}
		if(note.date>num){
			insert(num,note.getRightChild(),note);
		}else{
			insert(num,note.getLeftChild(),note);
		}
	}
	public void add(int num){
		if(head == null){
			head = new Note();
			head.setDate(num);
		}else{
			insert(num, head,head);
		}
	}
	
	public void inTraverse(Note note){
		if(note.leftChild != null){
			inTraverse(note.leftChild);
		}
		System.out.println(note.date);
		if(note.rightChild != null){
			inTraverse(note.rightChild);
		}
	}
	
	static final class Note{
		private Note leftChild;
		private Note rightChild;
		private int date;
		protected Note getLeftChild() {
			return leftChild;
		}
		protected void setLeftChild(Note leftChild) {
			this.leftChild = leftChild;
		}
		protected Note getRightChild() {
			return rightChild;
		}
		protected void setRightChild(Note rightChild) {
			this.rightChild = rightChild;
		}
		protected int getDate() {
			return date;
		}
		protected void setDate(int date) {
			this.date = date;
		}
	}

	protected Note getLeftChild() {
		return leftChild;
	}

	protected void setLeftChild(Note leftChild) {
		this.leftChild = leftChild;
	}

	protected Note getRightChild() {
		return rightChild;
	}

	protected void setRightChild(Note rightChild) {
		this.rightChild = rightChild;
	}

	protected Note getHead() {
		return head;
	}

	protected void setHead(Note head) {
		this.head = head;
	}
	
}
