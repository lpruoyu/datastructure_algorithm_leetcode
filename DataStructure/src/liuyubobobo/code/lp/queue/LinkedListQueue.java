package liuyubobobo.code.lp.queue;

public class LinkedListQueue<E> implements Queue<E> {

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
	private Node<E> tail;
	private int size;

	/*
	 * 队尾入队简单，删除教难 队首出队
	 */

	@Override
	public void enqueue(E e) {
		if (tail == null) {
			tail = new Node<>(e);
			head = tail;
		} else {
			tail.next = new Node<>(e);
			tail = tail.next;
		}
		size++;
	}

	@Override
	public E dequeue() {
		rangeCheck();
		Node<E> retNode = head;
		head = head.next;
		retNode.next = null;
		if (head == null) {
			tail = null;
		}
		size--;
		return retNode.e;
	}

	private void rangeCheck() {
		if (isEmpty()) {
			throw new IllegalArgumentException("queue is empty.");
		}
	}

	@Override
	public E getFront() {
		rangeCheck();
		return head.e;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int capacity() {
		return size();
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (Node<E> current = head; current != null; current = current.next) {
			sb.append(current.e);
			sb.append(" <- ");
		}

		sb.append("NULL");

		return "Queue : size=" + size() + " front [" + sb.toString() + "] end";
	}

}
