package liuyubobobo.code.lp.test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MyBSTree<E extends Comparable<E>> {

	public static void main(String[] args) {
		MyBSTree<Integer> tree = new MyBSTree<Integer>();
		int[] arr = { 79, 63, 84, 11, 65, 10, 15, 100, 11, 666 };
		for (int i = 0; i < arr.length; i++) {
			tree.add(arr[i]);
		}
//		tree.prevOrder();
//		tree.inOrder();
//		tree.postOrder();
//		tree.prevOrderNR();
//		tree.breadthFirstOrder();
//		System.out.println("contains 10 : " + tree.contains(10) + " -- contains 99 : " + tree.contains(99));
//		System.out.println("arr   length : " + arr.length);
//		System.out.println("tree  size   : " + tree.size());
//		tree.inOrder();
//		System.out.println(tree.max());
//		System.out.println(tree.min());
//
//		System.out.println("tree remomax: " + tree.removeMax());
//		System.out.println("tree remomin: " + tree.removeMin());
//
//		System.out.println("tree  size   : " + tree.size());
//		tree.inOrder();
//		System.out.println(tree.max());
//		System.out.println(tree.min());

//		for (int i = 0; i < arr.length; i++) {
//			tree.inOrder();
//			tree.remove(arr[i]);
//		}
//
//		tree.inOrder();

	}

	/*
	 * 不能添加重复元素 不能添加null元素
	 */

	private static final class Node<E> {
		private E e;
		private Node<E> left;
		private Node<E> right;

		Node(E e) {
			this.e = e;
		}
	}

	private Node<E> root;
	private int size;

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(E e) {
		checkNull(e);
		root = add(root, e);
	}

	private Node<E> add(Node<E> node, E e) {
		if (node == null) {
			size++;
			return new Node<>(e);
		}
		if (e.compareTo(node.e) > 0) {
			node.right = add(node.right, e);
		} else if (e.compareTo(node.e) < 0) {
			node.left = add(node.left, e);
		}
		return node;
	}

	public void remove(E e) {
		checkNull(e);
		checkNull(root);

		root = remove(root, e);
	}

	private Node<E> remove(Node<E> node, E e) {
		if (node == null) {
			return null;
		}

		if (e.compareTo(node.e) > 0) {
			node.right = remove(node.right, e);
			return node;
		} else if (e.compareTo(node.e) < 0) {
			node.left = remove(node.left, e);
			return node;
		} else {

			if (node.left == null) {
				size--;
				return node.right;
			} else if (node.right == null) {
				size--;
				return node.left;
			} else {
				Node<E> minimum = minimum(node.right);
				minimum.right = removeMin(node.right);
				minimum.left = node.left;
				return minimum;
			}
		}

	}

	public E max() {
		checkNull(root);

		return maximum(root).e;
	}

	private Node<E> maximum(Node<E> node) {
		if (node.right == null) {
			return node;
		}

		return maximum(node.right);
	}

	public E removeMax() {
		checkNull(root);
		E e = max();
		root = removeMax(root);
		return e;
	}

	private Node<E> removeMax(Node<E> node) {
		if (node.right == null) {
			size--;
			return node.left;
		}
		node.right = removeMax(node.right);
		return node;
	}

	public E min() {
		checkNull(root);

		return minimum(root).e;
	}

	private Node<E> minimum(Node<E> node) {
		if (node.left == null) {
			return node;
		}

		return minimum(node.left);
	}

	public E removeMin() {
		checkNull(root);
		E e = min();
		root = removeMin(root);
		return e;
	}

	private Node<E> removeMin(Node<E> node) {
		if (node.left == null) {
			size--;
			return node.right;
		}
		node.left = removeMin(node.left);
		return node;
	}

	public boolean contains(E e) {
		checkNull(root);
		checkNull(e);
		return contains(root, e);
	}

	private boolean contains(Node<E> node, E e) {
		if (node == null) {
			return false;
		}
		if (e.compareTo(node.e) > 0) {
			return contains(node.right, e);
		} else if (e.compareTo(node.e) < 0) {
			return contains(node.left, e);
		} else {
			return true;
		}
	}

	// 前序遍历
	public void prevOrder() {
		checkNull(root); // 根节点为空，那么一定没有元素

		System.out.print("前序:\t");
		prevOrder(root);
		System.out.println();
	}

	private void prevOrder(Node<E> node) {
		if (node == null) {
			return;
		}
		System.out.print(node.e + "\t");
		prevOrder(node.left);
		prevOrder(node.right);
	}

	// 中序遍历
	public void inOrder() {
		checkNull(root); // 根节点为空，那么一定没有元素

		System.out.print("中序:\t");
		inOrder(root);
		System.out.println();
	}

	private void inOrder(Node<E> node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.e + "\t");
		inOrder(node.right);
	}

	// 后序遍历
	public void postOrder() {
		checkNull(root); // 根节点为空，那么一定没有元素

		System.out.print("后序:\t");
		postOrder(root);
		System.out.println();
	}

	private void postOrder(Node<E> node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.e + "\t");
	}

	public void prevOrderNR() {
		checkNull(root);
		// root既不会为null，使得取出的栈顶元素不会NullPointerException；也确保Tree中有元素
		System.out.print("非递归前序遍历:\t");
		Deque<Node<E>> stack = new LinkedList<>();
		stack.push(root);
		Node<E> node;
		while (!stack.isEmpty()) {
			node = stack.pop();
			System.out.print(node.e + "\t");
			if (null != node.right) {
				stack.push(node.right);
			}
			if (null != node.left) {
				stack.push(node.left);
			}
		}
		System.out.println();
	}

	public void breadthFirstOrder() {
		checkNull(root);
		// root既不会为null，使得取出的栈顶元素不会NullPointerException；也确保Tree中有元素

		System.out.print("广度优先遍历:\t");
		Queue<Node<E>> queue = new LinkedList<>();
		queue.add(root);
		Node<E> node;
		while (!queue.isEmpty()) {
			node = queue.remove();
			System.out.print(node.e + "\t");
			if (null != node.left) {
				queue.add(node.left);
			}
			if (null != node.right) {
				queue.add(node.right);
			}
		}
		System.out.println();
	}

	private void checkNull(Object obj) {
		if (null == obj) {
			throw new IllegalArgumentException("must not be null!");
		}
	}

}
