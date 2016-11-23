package jsample.data.structure.impl;

import jsample.data.structure.Stack;

public class LinkedListBasedStack<T> implements Stack<T> {

	private Node topNode;

	private class Node {
		private T element;
		private Node next;

		public Node(T element) {
			this.element = element;
		}
	}

	@Override
	public void push(T element) {
		Node node = new Node(element);
		node.next = topNode;
		topNode = node;
	}

	@Override
	public T pop() {
		T element = topNode.element;
		topNode = topNode.next;
		return element;
	}

	@Override
	public boolean empty() {
		if (topNode == null) {
			return true;
		}
		return false;
	}

	@Override
	public T peek() {
		return topNode.element;
	}
}