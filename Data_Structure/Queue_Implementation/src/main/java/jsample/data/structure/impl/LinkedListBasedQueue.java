package jsample.data.structure.impl;

import jsample.data.structure.Queue;

public class LinkedListBasedQueue<T> implements Queue<T> {

	private Node front;

	private Node rear;

	private class Node {
		private T element;
		private Node next;

		public Node(T element) {
			this.element = element;
		}
	}

	@Override
	public void enqueue(T element) {
		Node node = new Node(element);
		if (front == null) {
			front = rear = node;
		} else {
			/**
			 * Below statement is equivalent to following 2 statements -
			 * 
			 * rear.next = node; rear = node;
			 */
			rear = rear.next = node;
		}
	}

	@Override
	public T dequeue() {
		Node tempNode = front;
		front = front.next;
		return tempNode.element;
	}

	@Override
	public boolean empty() {
		return front == null;
	}

	@Override
	public T peek() {
		return front.element;
	}
}