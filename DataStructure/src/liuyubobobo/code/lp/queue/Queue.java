package liuyubobobo.code.lp.queue;

public interface Queue<E> {
	
	int DEFAULT_CAPACITY = 10;
	
	void enqueue(E e);
	E dequeue();
	E getFront();
	
	int size();
	int capacity();
	boolean isEmpty();
	
}
