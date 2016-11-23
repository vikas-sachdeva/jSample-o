package jsample;

import jsample.data.structure.Stack;
import jsample.data.structure.impl.ArrayBasedStack;
import jsample.data.structure.impl.LinkedListBasedStack;

public class App {
	public static void main(String[] args) {
		Stack<Integer> stack = new ArrayBasedStack<>();
		System.out.println("Performing operation on array based stack...");
		performStackOperations(stack);
		stack = new LinkedListBasedStack<>();
		System.out.println("\nPerforming operation on linked list based stack...");
		performStackOperations(stack);
	}

	private static void performStackOperations(Stack<Integer> stack) {
		System.out.println("Pushing element in stack");
		for (int i = 0; i < 20; i++) {
			stack.push(i * 10);
		}
		System.out.println("Top element in stack =" + stack.peek());
		System.out.println("Popping element from stack");
		for (int i = 0; i < 20; i++) {
			System.out.println(stack.pop());
		}
		System.out.println("Checking if stack is empty = " + stack.empty());
	}
}
