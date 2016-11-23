package jsample.data.structure;


public interface Queue<T> {

	void enqueue(T element);

	T dequeue();
	
	boolean empty();
	
	T peek();
}
