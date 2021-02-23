package liuyubobobo.code.lp.stack;

public interface Stack<E> {

	int DEFAULT_CAPACITY = 10;

	void push(E e);

	E pop();

	E peek();

	boolean isEmpty();

	int size();
	int capacity();

}
