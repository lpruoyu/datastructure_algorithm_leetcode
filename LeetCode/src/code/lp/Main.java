package code.lp;

import code.lp.链表.ListNode;
import code.lp.链表._203_移除链表元素;

public class Main {

	public static void main(String[] args) {
		test2();
	}

	private static void test2() {
		_203_移除链表元素 obj = new _203_移除链表元素();
		ListNode head = new ListNode(new int[] { 3, 1, 3, 21, 1, 3, 2, 3, 1, 3 });
		ListNode removeElements = obj.removeElements3(head, 3);
		System.out.println(removeElements);
		removeElements = obj.removeElements3(head, 1);
		System.out.println(removeElements);
	}

	private static void test1() {
		_203_移除链表元素 obj = new _203_移除链表元素();
		ListNode head = new ListNode(new int[] { 1, 3, 21, 13, 4, 4, 2, 121, 2, 1, 33, 21, 11, 3, 1 });
		ListNode removeElements = obj.removeElements(head, 1);
		removeElements = obj.removeElements(removeElements, 4);
		removeElements = obj.removeElements(removeElements, 3);
		removeElements = obj.removeElements(removeElements, 2);
		removeElements = obj.removeElements(removeElements, 21);
		System.out.println(removeElements);

		head = new ListNode(new int[] { 1, 3, 21, 13, 4, 4, 2, 121, 2, 1, 33, 21, 11, 3, 1 });
		removeElements = obj.removeElements1(head, 1);
		removeElements = obj.removeElements(removeElements, 4);
		removeElements = obj.removeElements(removeElements, 3);
		removeElements = obj.removeElements(removeElements, 21);
		removeElements = obj.removeElements(removeElements, 2);
		System.out.println(removeElements);

		head = new ListNode(new int[] { 1, 3, 21, 13, 4, 4, 2, 121, 2, 1, 33, 21, 11, 3, 1 });
		removeElements = obj.removeElements2(head, 1);
		removeElements = obj.removeElements(removeElements, 4);
		removeElements = obj.removeElements(removeElements, 21);
		removeElements = obj.removeElements(removeElements, 3);
		removeElements = obj.removeElements(removeElements, 2);
		System.out.println(removeElements);
	}

	/*
	 * 之前自己写的傻逼代码：
	 */
	private static void test() {
//		ListNode head = new ListNode(1);
//		head.next = new ListNode(2);
//		head.next.next = new ListNode(6);
//		head.next.next.next = new ListNode(3);
//		head.next.next.next.next = new ListNode(4);
//		head.next.next.next.next.next = new ListNode(5);
//		head.next.next.next.next.next.next = new ListNode(6);
//		ListNode removeElements = new _203_移除链表元素().removeElements(head, 1);
	}

}
