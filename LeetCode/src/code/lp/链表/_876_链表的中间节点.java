package code.lp.链表;

public class _876_链表的中间节点 {

	/*
	 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
	 */

	public ListNode middleNode(ListNode head) {

		int listSize = 0;
		ListNode temp = head;
		while (null != temp) {
			listSize++;
			temp = temp.next;
		}

		temp = head;
		for (int i = 0; i < listSize / 2; i++) {
			temp = temp.next;
		}

		return temp;
	}

}
