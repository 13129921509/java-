package com.schoool.tree;

public class Test_01 {
	public static void main(String[] args) {
		My_SsarchTree sarchTree = new My_SsarchTree();
		sarchTree.add(4);
		sarchTree.add(3);
		sarchTree.add(7);
		sarchTree.add(5);
		sarchTree.add(1);
		sarchTree.add(2);
		sarchTree.add(0);
		
		sarchTree.inTraverse(sarchTree.getHead());
	}
}
