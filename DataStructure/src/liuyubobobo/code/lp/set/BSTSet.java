package liuyubobobo.code.lp.set;

import liuyubobobo.code.lp.tree.BinarySearchTree;

public class BSTSet<E extends Comparable<E>> implements Set<E> {

	private BinarySearchTree<E> tree = new BinarySearchTree<>();

	/**
	 * 不能添加重复元素
	 */
	@Override
	public void add(E e) {
		tree.add(e);
	}

	@Override
	public void remove(E e) {
		tree.remove(e);
	}

	@Override
	public boolean contains(E e) {
		return tree.contains(e);
	}

	@Override
	public int getSize() {
		return tree.size();
	}

	@Override
	public boolean isEmpty() {
		return tree.isEmpty();
	}

}
