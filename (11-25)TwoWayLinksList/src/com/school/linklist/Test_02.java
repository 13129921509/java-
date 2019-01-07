package com.school.linklist;

public class Test_02 {
	public static void main(String[] args) throws Exception {
		My_Pack_TwoWaysLinksList linksList = new My_CircularTwoWaysLinksList();
		linksList.afterLinks(1);
		linksList.afterLinks(2);
		linksList.afterLinks("3");
		linksList.afterLinks("four");
		linksList.afterLinks("four");
		linksList.afterLinks("four");
		linksList.afterLinks("four4");
		//linksList.reTraverseLinkList();
		//linksList.insertHead(0);
		linksList.traverseLinkList();
		System.out.println(linksList.size());
		//System.out.println(linksList.get(7));
	}
}
