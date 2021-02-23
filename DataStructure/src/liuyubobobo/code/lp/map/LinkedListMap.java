package liuyubobobo.code.lp.map;

public class LinkedListMap<K, V> implements Map<K, V> {

	private static class Node<K, V> {
		private K key;
		private V value;
		private Node<K, V> next;

		Node() {
		}

		Node(Node<K, V> next, K key, V value) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	private Node<K, V> dummyHead = new Node<>();
	private int size;

	/*
	 * 只往头结点插入元素
	 */
	@Override
	public void add(K key, V value) {
		Node<K, V> node = node(key);
		if (node != null) {
			node.value = value;
		} else {
			dummyHead.next = new Node<>(dummyHead.next, key, value);
			size++;
		}
	}

	private Node<K, V> node(K key) {
		checkNull(key);
		Node<K, V> node = dummyHead.next;
		while (node != null) {
			if (node.key.equals(key)) {
				return node;
			}
			node = node.next;
		}
		return null;
	}

	public void order() {
		System.out.print("遍历:\t");
		Node<K, V> cur = dummyHead.next;
		while (null != cur) {
			System.out.print(cur.value + "\t");
			cur = cur.next;
		}
		System.out.println();
	}

	private void checkNull(Object obj) {
		if (null == obj) {
			throw new IllegalArgumentException("argument must not be null.");
		}
	}

	@Override
	public V remove(K key) {
		checkNull(key);
		Node<K, V> prev = dummyHead;
		while (prev.next != null) {
			if (key.equals(prev.next.key)) {
				Node<K, V> delNode = prev.next;
				prev.next = prev.next.next;
				size--;
				return delNode.value;
			}
			prev = prev.next;
		}
		return null;
	}

//	@Override
//	public V remove(K key) {
//		checkNull(key);
//		Node<K, V> prev = dummyHead;
//		Node<K, V> curr = dummyHead.next;
//		while (null != curr) {
//			if (key.equals(curr.key)) {
//				prev.next = curr.next;
//				size--;
//				return curr.value;
//			}
//			prev = curr;
//			curr = curr.next;
//		}
//		return null;
//	}

//	private Node<K, V> remove(Node<K, V> node, K key) {
//		if (node == null) {
//			return null;
//		}
//		if (key.equals(node.key)) {
//			size--;
//			return node.next;
//		}
//		node.next = remove(node.next, key);
//		return node;
//	}

	private Node<K, V> remove(Node<K, V> node, K key) {
		if (node == null) {
			return null;
		}
		if (key.equals(node.key)) {
			size--;
			return node.next;
		}
		node.next = remove(node.next, key);
		return node;
	}

	@Override
	public boolean contains(K key) {
		return node(key) != null;
	}

	@Override
	public V get(K key) {
		Node<K, V> node = node(key);
		if (node != null) {
			return node.value;
		}
		return null;
	}

	@Override
	public void set(K key, V value) {
		Node<K, V> node = node(key);
		if (node != null) {
			node.value = value;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

}
