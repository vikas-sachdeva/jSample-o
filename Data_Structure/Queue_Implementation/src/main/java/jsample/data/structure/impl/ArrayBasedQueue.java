package jsample.data.structure.impl;

import java.util.Arrays;

import jsample.data.structure.Queue;

public class ArrayBasedQueue<T> implements Queue<T> {

	private Object[] elementData;

	private int capacity;

	private int front = 0;

	private int rear = -1;

	public ArrayBasedQueue() {
		this(10);
	}

	public ArrayBasedQueue(int capacity) {
		this.capacity = capacity;
		elementData = new Object[capacity];
	}

	@Override
	public void enqueue(T element) {
		if (elementData.length == rear + 1) {
			if (front == 0) {
				elementData = Arrays.copyOf(elementData, elementData.length + capacity);
				elementData[++rear] = element;
			} else {
				System.arraycopy(elementData, front, elementData, 0, elementData.length - front);
				rear = rear - front;
				front = 0;
				elementData[++rear] = element;
			}
		} else {
			elementData[++rear] = element;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T dequeue() {
		Object element = elementData[front];
		elementData[front] = null;
		front++;
		return (T) element;
	}

	@Override
	public boolean empty() {
		return front > rear;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T peek() {
		return (T) elementData[front];
	}
}