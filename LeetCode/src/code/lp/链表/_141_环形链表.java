package code.lp.链表;

public class _141_环形链表 {

	/*
	 * https://leetcode-cn.com/problems/linked-list-cycle/
	 */

	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode fast, slow;
		fast = head.next;
		slow = head;
		// 快指针判断是否为空
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow)
				return true;
		}
		return false;
	}

}
