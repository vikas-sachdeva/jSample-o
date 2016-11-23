package jsample;

import jsample.data.structure.Queue;
import jsample.data.structure.impl.ArrayBasedQueue;
import jsample.data.structure.impl.LinkedListBasedQueue;

public class App {
	public static void main(String[] args) {
		Queue<Integer> queue = new ArrayBasedQueue<>(10);
		System.out.println("\nPerforming operation on array based queue...");
		performQueueOperations(queue);
		queue = new LinkedListBasedQueue<>();
		System.out.println("\nPerforming operation on linked list based queue...");
		performQueueOperations(queue);
	}

	private static void performQueueOperations(Queue<Integer> queue) {
		System.out.println("Adding elements in queue");
		for (int i = 0; i < 10; i++) {
			queue.enqueue(i);
		}
		System.out.println("First element in queue = " + queue.peek());
		System.out.println("Removing elements from queue");
		for (int i = 0; i < 10; i++) {
			System.out.println(queue.dequeue());
		}
		System.out.println("Checking if queue is empty = " + queue.empty());
	}
}
