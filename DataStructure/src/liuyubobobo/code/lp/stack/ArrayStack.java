package liuyubobobo.code.lp.stack;

import liuyubobobo.code.lp.dynamic_array.DynamicArray;

public class ArrayStack<E> implements Stack<E> {

	private DynamicArray<E> array;

	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}

	public ArrayStack(int capacity) {
		array = new DynamicArray<E>(capacity);
	}

	@Override
	public void push(E e) {
		array.addLast(e);
	}

	@Override
	public E pop() {
		return array.removeLast();
	}

	@Override
	public E peek() {
		return array.getLast();
	}

	@Override
	public boolean isEmpty() {
		return array.isEmpty();
	}

	@Override
	public int size() {
		return array.size();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < array.size(); i++) {
			if (i != 0)
				sb.append(',');
			sb.append(array.get(i));
		}
		if (sb.length() == 0)
			sb.append("empty");

		return "ArrayStack : size=" + array.size() + ", capacity=" + array.capacity() + " >stack end< [" + sb.toString() + "] >stack top<";
	}

	@Override
	public int capacity() {
		return array.capacity();
	}

}
