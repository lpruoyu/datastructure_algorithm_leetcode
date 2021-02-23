package liuyubobobo.code.lp.linkedlist;

public class LinkedListWithDummyHead<E> {

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

	private Node<E> dummyHead; // 虚拟头结点
	private int size;

	public LinkedListWithDummyHead() {
		dummyHead = new Node<>();
	}

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

		Node<E> prev = dummyHead;
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}

//			Node<E> node = new Node<E>();
//			node.next = prev.next;
//			prev.next = node;

		prev.next = new Node<E>(prev.next, e);
		size++;
	}

	public void addFirst(E e) {
		add(0, e);
	}

	public void addLast(E e) {
		add(size, e);
	}

	public E remove(int index) {
		rangeCheck(index);

		Node<E> prev = dummyHead;
		for (int i = 0; i < index; i++) {
			prev = prev.next;
		}

		Node<E> retNode = prev.next;
		prev.next = retNode.next;
		retNode.next = null;

		size--;
		return retNode.e;
	}

	public E removeFirst() {
		return remove(0);
	}

	public E removeLast() {
		return remove(size - 1);
	}
	
	private Node<E> node(int index) {
		rangeCheck(index);
		Node<E> current = dummyHead.next;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}

	public E get(int index) {
		return node(index).e;
	}

	public E getFirst() {
		return get(0);
	}

	public E getLast() {
		return get(size() - 1);
	}

	public void set(int index, E e) {
		node(index).e = e;
	}

	public int index(E e) {
		if (null == e) {
			throw new IllegalArgumentException("e cannot be null.");
		}
		int i = 0;
		Node<E> current = dummyHead.next;
		// 使用 for 更好
		// 纯粹练习while
		while (null != current) {
			if (e.equals(current.e)) {
				return i;
			}
			i++;
			current = current.next;
		}
		return -1;
	}

	public boolean contains(E e) {
		if (null == e) {
			return false;
		} else {
			Node<E> current = dummyHead.next;
			for (int i = 0; i < size; i++) {
				if (e.equals(current.e)) {
					return true;
				}
				current = current.next;
			}
		}
		return false;
	}

	private void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException("index must be : >= 0 && < size");
		}
	}

	private void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("index must be : >= 0 && <= size");
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
//		Node<E> current = dummyHead.next;
//		for (int i = 0; i < size; i++) {
//			if (i != 0) {
//				sb.append(',');
//			}
//			sb.append(current.e);
//			current = current.next;
//		}

		for (Node<E> current = dummyHead.next; current != null; current = current.next) {
			sb.append(current.e);
			sb.append("-> ");
		}

		sb.append("NULL");

		return "LinkedList size=" + size + " [" + sb.toString() + "]";
	}

}
