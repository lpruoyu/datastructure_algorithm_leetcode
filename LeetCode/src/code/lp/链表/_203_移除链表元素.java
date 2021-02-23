package code.lp.链表;

public class _203_移除链表元素 {

	/*
	 * https://leetcode-cn.com/problems/remove-linked-list-elements/
	 */

	/*
	 * 之前自己的想法（操作）
	 */
	public ListNode removeElements(ListNode head, int val) {
		ListNode sbListNode = new ListNode(-1); // 创建哨兵节点
		sbListNode.next = head;
		ListNode prevNode = sbListNode;
		ListNode tempNode = head;
		while (tempNode != null) {
			if (tempNode.val == val) {
				prevNode.next = tempNode.next;
				tempNode = tempNode.next;
				continue;
			}
			tempNode = tempNode.next;
			prevNode = prevNode.next;
		}
		return sbListNode.next;
	}

	/*
	 * 使用递归
	 */
	public ListNode removeElements3(ListNode head, int val) {
		return removeHead(head, val);
	}

	private ListNode removeHead(ListNode head, int val) {
		if (null == head) {
			return null;
		}
		/*
		 * if (head.val == val) { head = removeHead(head.next, val); } else { head.next
		 * = removeHead(head.next, val); }
		 */
		/*
		 * ListNode node = removeHead(head.next, val); if (head.val == val) { head =
		 * node; } else { head.next = node; } return head;
		 */
		head.next = removeHead(head.next, val);
		if (head.val == val) {
			return head.next;
		} else {
			return head;
		}
	}

	/*
	 * 使用虚拟头结点
	 */
	public ListNode removeElements2(ListNode head, int val) {
		ListNode dummyHead = new ListNode(-1); // 使用虚拟头结点
		dummyHead.next = head;
		ListNode prev = dummyHead;
		while (prev.next != null) {
			if (prev.next.val == val) {
				prev.next = prev.next.next;
			} else {
				prev = prev.next;
			}
		}
		return dummyHead.next;
	}

	/*
	 * 不使用dummyhead节点
	 */
	public ListNode removeElements1(ListNode head, int val) {
		// 首先判断首元素是否为val
		while (head != null && head.val == val) {
			head = head.next;
		}
		// 判断是否还有元素
		if (head != null) {
			// 当有元素时，head.val绝对不等于val
			// 删除元素应当找到该元素的前一个节点
			ListNode prev = head;
			while (prev.next != null) {
				if (prev.next.val == val) {
					prev.next = prev.next.next;
				} else {
					prev = prev.next;
				}
			}
		}
		return head;
	}

}
