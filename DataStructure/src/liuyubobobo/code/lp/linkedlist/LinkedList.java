package liuyubobobo.code.lp.linkedlist;

public class LinkedList<E> {
	
	/*
	 * 该类不全，去WithDummyHead的LinkedList中。
	 */

	private static class Node<E> {
		private E e;
		private Node<E> next;

		Node(E e) {
			this(null, e);
		}

		Node() {
			this(null, null);
		}

		Node(Node<E> next, E e) {
			this.e = e;
			this.next = next;
		}

	}

	private Node<E> head;
	private int size;

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void add(int index, E e) {
		if (null == e) {
			throw new IllegalArgumentException("e cannot be null.");
		}
		rangeCheckForAdd(index);
		if (index == 0) {
			addFirst(e);
		} else {
			Node<E> prev = head;
			for (int i = 0; i < index - 1; i++) {
				prev = prev.next;
			}

//			Node<E> node = new Node<E>();
//			node.next = prev.next;
//			prev.next = node;

			prev.next = new Node<E>(prev.next, e);
			size++;
		}
	}

	public void addFirst(E e) {
//		Node<E> node = new Node<E>(e);
//		node.next = head;
//		head = node;
		head = new Node<E>(head, e);
		size++;
	}

	public void addLast(E e) {
		add(size, e);
	}

	private void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("index must be : >= 0 && <= size");
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node<E> prev = head;
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				sb.append(',');
			}
			sb.append(prev.e);
			prev = prev.next;
		}
		return "LinkedList size=" + size + " [" + sb.toString() + "]";
	}

}
