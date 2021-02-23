package liuyubobobo.code.lp.test;

import java.util.HashSet;
import java.util.Set;

import liuyubobobo.code.lp.Bean;
import liuyubobobo.code.lp.dynamic_array.DynamicArray;
import liuyubobobo.code.lp.linkedlist.LinkedList;
import liuyubobobo.code.lp.linkedlist.LinkedListWithDummyHead;
import liuyubobobo.code.lp.map.BSTMap;
import liuyubobobo.code.lp.map.LinkedListMap;
import liuyubobobo.code.lp.queue.ArrayQueue;
import liuyubobobo.code.lp.queue.LinkedListQueue;
import liuyubobobo.code.lp.queue.LoopArrayQueue;
import liuyubobobo.code.lp.queue.Queue;
import liuyubobobo.code.lp.stack.ArrayStack;
import liuyubobobo.code.lp.stack.LinkedWDHStack;
import liuyubobobo.code.lp.stack.Stack;
import liuyubobobo.code.lp.tree.BinarySearchTree;

public class Main {

	public static void main(String[] args) {
		test11();
	}

	private static void test11() {
		LinkedListMap<Integer, Integer> bstMap = new LinkedListMap<>();
		int arr[] = { 123, 220, 3230, 120, 1011, 443, 230, 123, 220, 3230, 120, 1011, 443, 230, 123, 220, 3230, 120,
				1011, 443, 230, 123, 220, 3230, 120, 1011, 443, 230 };
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			bstMap.add(arr[i], j++);
		}
//		bstMap.prevOrder();
//		bstMap.removeMin();
//		bstMap.prevOrder();
//		bstMap.removeMax();
//		bstMap.prevOrder();
//		System.out.println(bstMap.size());
//		
		bstMap.order();
		System.out.println(bstMap.size());
		for (int i = 0; i < arr.length; i++) {
			bstMap.remove(arr[i]);
			bstMap.order();
			System.out.println(bstMap.size());
		}
//
//		for (int i = 0; i < bstMap.size(); i++) {
//			bstMap.removeMax();
//		}
	}

	private static void test10() {
		Set<Bean> set = new HashSet<Bean>();

		set.add(new Bean(0, ""));
		set.add(new Bean(0, ""));
		set.add(new Bean(0, ""));

		System.out.println(set);
		System.out.println(set.size());

	}

	private static void test9() {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();

		int arr[] = { 23, 4, 231, 11, 213, 99 };
		for (int i = 0; i < arr.length; i++) {
			tree.add(arr[i]);
		}

		for (int i = 0; i < tree.size(); i++) {
			tree.removeMax();
		}

		System.out.println(tree.size());

//		tree.inOrder();
//		for (int i = 0; i < arr.length; i++) {
//			tree.remove(arr[i]);
//		}
//		System.out.println(tree.size());
//		tree.postOrder();
//		tree.removeMin();		
//		tree.inOrder();
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(tree.contains(arr[i]));
//		}

//		tree.prevOrderBreadthFirst();

//		tree.prevOrderNN();

//		tree.prevOrder();

//		tree.postOrder();

	}

	private static void printArr(final int[] arr) {
		for (int i = 0; i < 10; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
	}

	private static void test8() {
		int count = 100000;
		testQueue(new LoopArrayQueue<Double>(), count);
		testQueue(new LinkedListQueue<Double>(), count);
	}

	private static void test7() {
		LinkedListQueue<Integer> queue = new LinkedListQueue<Integer>();
		for (int i = 0; i < 30; i++) {
			queue.enqueue(i);
			System.out.println(queue);
		}
		System.out.println(queue.getFront());
		for (int i = 0; i < 20; i++) {
			queue.dequeue();
			System.out.println(queue);
		}
		System.out.println(queue.getFront());
	}

	private static void test6() {
		LinkedWDHStack<Integer> stack = new LinkedWDHStack<Integer>();
		for (int i = 0; i < 40; i++) {
			stack.push(i);
		}
		System.out.println(stack);
		System.out.println(stack.peek());

		for (int i = 0; i < 20; i++) {
			stack.pop();
		}

		System.out.println(stack);
		System.out.println(stack.peek());
	}

	private static void test5() {
		LinkedListWithDummyHead<Integer> linkedList = new LinkedListWithDummyHead<>();
		for (int i = 0; i < 10; i++) {
			linkedList.add(i, i);
		}
		System.out.println(linkedList);
		linkedList.set(0, 666);
		linkedList.set(linkedList.size() - 1, 666);
		linkedList.set(3, 666);
		System.out.println(linkedList.get(3));
		System.out.println(linkedList);
//		for (int i = 0; i < 5; i++) {
//			linkedList.removeFirst();
//		}
//		System.out.println(linkedList);
//		for (int i = 0; i < 5; i++) {
//			linkedList.removeLast();
//		}
//		System.out.println(linkedList);
//		for (int i = 0; i < 10; i++) {
//			linkedList.add(i, i);
//		}
//		System.out.println(linkedList);
//		for (int i = 0; i < 4; i++) {
//			linkedList.remove(i);
//		}
//		System.out.println(linkedList);
	}

	private static void test4() {
		LinkedList<Integer> linkedList = new LinkedList<>();
		for (int i = 0; i < 10; i++) {
			linkedList.addFirst(i);
		}
		System.out.println(linkedList);
		for (int i = 0; i < 10; i++) {
			linkedList.addLast(i);
		}
		System.out.println(linkedList);
		for (int i = 0; i < 10; i++) {
			linkedList.add(i, i);
		}
		System.out.println(linkedList);
	}

	private static void testQueue(Queue<Double> q, int count) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			q.enqueue(Math.random());
		}
		for (int i = 0; i < count; i++) {
			q.dequeue();
		}
		long end = System.currentTimeMillis();
		System.out.println(q.getClass() + " 消耗： " + (end - start));
	}

	private static void testStack(Stack<Double> q, int count) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < count; i++) {
			q.push(0.0);
		}
		for (int i = 0; i < count; i++) {
			q.pop();
		}
		long end = System.currentTimeMillis();
		System.out.println(q.getClass() + " 消耗： " + (end - start));
	}

	private static void test3() {
		LoopArrayQueue<Integer> queue = new LoopArrayQueue<Integer>(1);
		for (int i = 0; i < 100; i++) {
			queue.enqueue(i);
			System.out.println(queue);
		}

		for (int i = 0; i < 50; i++) {
			queue.dequeue();
			System.out.println(queue);
		}
	}

	private static void test2() {
		Queue<Integer> queue = new ArrayQueue<Integer>();
		for (int i = 0; i < 8; i++) {
			queue.enqueue(i);
		}
		System.out.println(queue);

		for (int i = 0; i < 8; i++) {
			queue.dequeue();
		}
		System.out.println(queue);

	}

	private static void test1() {
		Stack<Integer> stack = new ArrayStack<Integer>();
		for (int i = 0; i < 40; i++)
			stack.push(i);
		System.out.println(stack);
		System.out.println(stack.peek());
		for (int i = 0; i < 20; i++)
			stack.pop();
		System.out.println(stack);
		System.out.println(stack.peek());
	}

	private static void test0() {
		DynamicArray<Bean> array = new DynamicArray<>(1);
		for (int i = 0; i < 40; i++)
			array.addLast(new Bean(i, "lp:" + i));
		System.out.println(array);
		for (int i = 0; i < 40; i++)
			array.remove(0);
		for (int i = 0; i < 400; i++)
			array.addLast(new Bean(i, "lp:" + i));
		System.out.println(array);
	}

}
