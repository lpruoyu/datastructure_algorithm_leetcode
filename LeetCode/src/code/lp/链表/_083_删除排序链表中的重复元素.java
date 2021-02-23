package code.lp.链表;

public class _083_删除排序链表中的重复元素 {

	/*
	 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
	 */

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		ListNode temp = head;
		ListNode tempNext = temp.next;
		while (null != temp && null != tempNext) {
			if (temp.val == tempNext.val) {
				temp.next = tempNext.next;
				tempNext = tempNext.next;
				continue;
			}
			temp = temp.next;
			tempNext = tempNext.next;
		}
		return head;
	}

}
