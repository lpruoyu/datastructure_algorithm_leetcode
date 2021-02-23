package code.lp.链表;

public class _206_反转链表 {

	/*
	 * https://leetcode-cn.com/problems/reverse-linked-list/
	 */

	class Solution {
		public ListNode reverseList(ListNode head) {

			if (head == null || head.next == null)
				return head;

			ListNode temp;
			ListNode newHead = null;
			while (head != null) {
				temp = head.next;
				head.next = newHead;
				newHead = head;
				head = temp;
			}
			return newHead;
		}
	}

}
