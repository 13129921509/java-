package com.school.linklist;
/*
 * My_CircularTwoWaysLinksList��չ��˫������My_Pack_TwoWaysLinksList
 * �γ��� ѭ����˫������
 */
public class My_CircularTwoWaysLinksList extends My_Pack_TwoWaysLinksList{
	private Note head;
	private Note nowNote;
	public My_CircularTwoWaysLinksList() {
		// TODO �Զ����ɵĹ��캯�����

	}
	/*
	 * ����
	 * @see com.school.linklist.My_Pack_TwoWaysLinksList#traverseLinkList()
	 */
	@Override
	public void traverseLinkList() {
		// TODO �Զ����ɵķ������
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
