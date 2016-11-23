package jsample.data.structure.impl;

import java.util.Arrays;

import jsample.data.structure.Stack;

public class ArrayBasedStack<T> implements Stack<T> {

	private int top = -1;

	private Object[] elementData;

	private int capacity;

	public ArrayBasedStack() {
		this(10);
	}

	public ArrayBasedStack(int capacity) {
		elementData = new Object[capacity];
		this.capacity = capacity;
	}

	@Override
	public void push(T element) {
		if (elementData.length == top + 1) {
			elementData = Arrays.copyOf(elementData, elementData.length + capacity);
		}
		elementData[++top] = element;
	}

	@Override
	public T pop() {
		T element = peek();
		elementData[top--] = null;
		return element;
	}

	@Override
	public boolean empty() {
		return top == -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T peek() {
		return (T) elementData[top];
	}
}