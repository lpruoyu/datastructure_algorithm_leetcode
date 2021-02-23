package liuyubobobo.code.lp.map;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

	private static class Node<K, V> {
		private K key;
		private V value;
		private Node<K, V> left;
		private Node<K, V> right;

		Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	private Node<K, V> root;
	private int size;

	/**
	 * key不能重复 根据key来存储元素
	 */
	@Override
	public void add(K key, V value) {
		checkNull(key);
		root = add(root, key, value);
	}

	private Node<K, V> add(Node<K, V> node, K key, V value) {
		if (node == null) {
			size++;
			return new Node<>(key, value);
		}

		if (key.compareTo(node.key) > 0) {
			node.right = add(node.right, key, value);
		} else if (key.compareTo(node.key) < 0) {
			node.left = add(node.left, key, value);
		} else {
			node.value = value;
		}

		return node;
	}

	private void checkNull(Object obj) {
		if (obj == null) {
			throw new IllegalArgumentException("argument is null!");
		}
	}

	@Override
	public V remove(K key) {
		checkNull(root);
		checkNull(key);
		Node<K, V> node = node(root, key);
		if (node != null) {
			root = remove(root, key);
			return node.value;
		}
		return null;
	}

	private Node<K, V> node(Node<K, V> node, K key) {
		if (node == null) {
			return null;
		}
		if (key.compareTo(node.key) > 0) {
			return node(node.right, key);
		} else if (key.compareTo(node.key) < 0) {
			return node(node.left, key);
		} else {
			return node;
		}
	}

	private Node<K, V> remove(Node<K, V> node, K key) {
		if (node == null) {
			return null;
		}
		if (key.compareTo(node.key) > 0) {
			node.right = remove(node.right, key);
			return node;
		} else if (key.compareTo(node.key) < 0) {
			node.left = remove(node.left, key);
			return node;
		} else {

			if (node.left == null) {
				size--;
				return node.right;
			} else if (node.right == null) {
				size--;
				return node.left;
			} else {
				Node<K, V> min = min(node.right);
				min.right = removeMin(node.right);
				min.left = node.left;
				return min;
			}

		}
	}
	
	

	public V minimum() {
		checkNull(root);
		return min(root).value;
	}

	private Node<K, V> min(Node<K, V> node) {
		if (node.left == null) {
			return node;
		}
		return min(node.left);
	}

	public V removeMin() {
		checkNull(root);
		V v = minimum();
		root = removeMin(root);
		return v;
	}

	private Node<K, V> removeMin(Node<K, V> node) {
		if (node.left == null) {
			size--;
			return node.right;
		}
		node.left = removeMin(node.left);
		return node;
	}

	public V maximum() {
		checkNull(root);
		return max(root).value;
	}

	private Node<K, V> max(Node<K, V> node) {
		if (node.right == null) {
			return node;
		}
		return max(node.right);
	}

	public V removeMax() {
		checkNull(root);
		V v = maximum();
		root = removeMax(root);
		return v;
	}

	private Node<K, V> removeMax(Node<K, V> node) {
		if (node.right == null) {
			size--;
			return node.left;
		}
		node.right = removeMax(node.right);
		return node;
	}

	@Override
	public boolean contains(K key) {
		return node(root, key) != null;
	}

	@Override
	public V get(K key) {
		Node<K, V> node = node(root, key);
		return node == null ? null : node.value;
	}

	@Override
	public void set(K key, V value) {
		Node<K, V> node = node(root, key);
		if (null != node) {
			node.value = value;
		}
	}

	public void prevOrder() {
		checkNull(root);
		System.out.print("前序遍历:\t");
		prevOrder(root);
		System.out.println();
	}

	private void prevOrder(Node<K, V> node) {
		if (node == null) {
			return;
		}
		System.out.print(node.key + " -> " + node.value + "\t");
		prevOrder(node.left);
		prevOrder(node.right);
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
