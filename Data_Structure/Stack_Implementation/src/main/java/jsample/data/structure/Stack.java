package jsample.data.structure;



public interface Stack<T> {

	void push(T element);

	T pop();

	boolean empty();

	T peek();
}
