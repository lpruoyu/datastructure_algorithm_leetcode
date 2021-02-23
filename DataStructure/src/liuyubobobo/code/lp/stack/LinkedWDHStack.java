package liuyubobobo.code.lp.stack;

import liuyubobobo.code.lp.linkedlist.LinkedListWithDummyHead;

public class LinkedWDHStack<E> implements Stack<E> {

	private LinkedListWithDummyHead<E> list = new LinkedListWithDummyHead<E>();

	@Override
	public void push(E e) {
		list.addFirst(e);
	}

	@Override
	public E pop() {
		return list.removeFirst();
	}

	@Override
	public E peek() {
		return list.getFirst();
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public int capacity() {
		return list.size();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			if (i != 0) {
				sb.append(',');
			}
			sb.append(list.get(i));
		}
		if (sb.length() == 0)
			sb.append("empty");

		return "LinkedWDHStack : size=" + list.size() + " >stack top< [" + sb.toString() + "] >stack end<";
	}

}
