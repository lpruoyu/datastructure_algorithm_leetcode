package liuyubobobo.code.lp.queue;

public class LoopArrayQueue<E> implements Queue<E> {

	private E[] data;
	private int size;
	private int front;
	private int tail;

	public LoopArrayQueue() {
		this(DEFAULT_CAPACITY);
	}

	public LoopArrayQueue(int capacity) {
		if (capacity <= 0)
			throw new IllegalArgumentException("capacity must be bigger than zero.");
		data = (E[]) new Object[capacity + 1];
	}

	@Override
	public void enqueue(E e) {
		rangeCheckForAdd();

		data[tail] = e;
		tail = (tail + 1) % realCapacity();
		size++;
	}

	private void rangeCheckForAdd() {
		if ((tail + 1) % realCapacity() == front) {
			resize(realCapacity() + realCapacity() / 2);
		}
	}

	private void resize(int newCapacity) {
		if (newCapacity <= DEFAULT_CAPACITY)
			return;
		E[] newData = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newData[i] = data[front];
			front = (front + 1) % realCapacity();
		}
		data = newData;
		front = 0;
		tail = size;
	}

	@Override
	public E dequeue() {
		if (isEmpty())
			throw new IllegalArgumentException("queue is empty.");
		
		E e = data[front];
		data[front] = null;
		front = (front + 1) % realCapacity();
		size--;

		if (size == realCapacity() / 2) {
			resize(realCapacity() * 3 / 4);
		}

		return e;
	}

	@Override
	public E getFront() {
		if (isEmpty())
			throw new IllegalArgumentException("queue is empty.");
		return data[front];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int capacity() {
		return data.length - 1;
	}

	private int realCapacity() {
		return data.length;
	}

	@Override
	public boolean isEmpty() {
		return tail == front;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int f = front;
		for (int i = 0; i < size(); i++) {
			if (i != 0)
				sb.append(',');
			sb.append(data[f]);
			f = (f + 1) % realCapacity();
		}
		if (sb.length() == 0)
			sb.append("empty");

		return "LoopQueue : size=" + size() + ", capacity=" + capacity() + " front [" + sb.toString() + "]";
	}

}
