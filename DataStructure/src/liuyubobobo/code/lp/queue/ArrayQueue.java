package liuyubobobo.code.lp.queue;

import liuyubobobo.code.lp.dynamic_array.DynamicArray;

public class ArrayQueue<E> implements Queue<E> {

	private DynamicArray<E> array;

	public ArrayQueue() {
		this(DEFAULT_CAPACITY);
	}

	public ArrayQueue(int capacity) {
		array = new DynamicArray<E>(capacity);
	}

	@Override
	public void enqueue(E e) {
		array.addLast(e);
	}

	@Override
	public E dequeue() {

		return array.removeFirst();
	}

	@Override
	public E getFront() {

		return array.getFirst();
	}

	@Override
	public int size() {

		return array.size();
	}

	@Override
	public boolean isEmpty() {

		return array.isEmpty();
	}

	@Override
	public int capacity() {
		return array.capacity();
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

		return "ArrayQueue : size=" + array.size() + ", capacity=" + array.capacity() + " >front< [" + sb.toString() + "]";
	}

}
