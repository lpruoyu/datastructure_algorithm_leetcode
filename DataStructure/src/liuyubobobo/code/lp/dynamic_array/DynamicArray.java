package liuyubobobo.code.lp.dynamic_array;

public class DynamicArray<E> {

	private static final int ELEMENT_NOT_FOUND = -1;
	private static final int DEFAULT_CAPACITY = 10;

	private E[] data;
	private int size;

	public DynamicArray(int capacity) {
		if (capacity <= 0)
			throw new IllegalArgumentException("capacity should be bigger than zero.");
		if (capacity < DEFAULT_CAPACITY)
			capacity = DEFAULT_CAPACITY;
		data = (E[]) new Object[capacity];
	}

	public DynamicArray() {
		this(DEFAULT_CAPACITY);
	}

	public int size() {
		return size;
	}

	public int capacity() {
		return data.length;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void addFirst(E e) {
		add(0, e);
	}

	public void addLast(E e) {
		add(size, e);
	}

	public void add(int index, E e) {
		if (null == e)
			throw new IllegalArgumentException("element cannot be null.");
		
		rangeCheckForAdd(index);
		for (int i = size; i > index; i--) {
			data[i] = data[i - 1];
		}
		data[index] = e;
		size++;
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
		if (size == capacity()) {
			grow();
		}
	}

	private void reduce() {
		int newCapacity = capacity() / 2;
		if (newCapacity <= DEFAULT_CAPACITY)
			return;
		resize(newCapacity);
	}

	private void grow() {
		resize(capacity() + capacity() / 2);
	}

	private void resize(int newCapacity) {
		E[] newData = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}

	public E get(int index) {
		rangeCheck(index);
		return data[index];
	}

	public E getFirst() {
		return get(0);
	}

	public E getLast() {
		return get(size() - 1);
	}

	public E set(int index, E e) {
		rangeCheck(index);
		E old = data[index];
		data[index] = e;
		return old;
	}

	public boolean contains(E e) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e))
				return true;
		}
		return false;
	}

	public int index(E e) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(e))
				return i;
		}
		return ELEMENT_NOT_FOUND;
	}

	public E removeLast() {
		return remove(size - 1);
	}

	public E removeFirst() {
		return remove(0);
	}

	public void removeElement(E e) {
		remove(index(e));
	}

	public void clear() {
		size = 0;
	}

	public E remove(int index) {
		rangeCheck(index);
		E old = data[index];
		for (int i = index; i < size - 1; i++)
			data[i] = data[i + 1];
		size--;
		data[size] = null; // gc
		if (size == capacity() / 4)
			reduce();
		return old;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			if (i != 0)
				sb.append(',');
			sb.append(data[i]);
		}
		if (sb.length() == 0)
			sb.append("empty");

		return "Array : size=" + size + ", capacity=" + capacity() + " [" + sb.toString() + "]";
	}

}
