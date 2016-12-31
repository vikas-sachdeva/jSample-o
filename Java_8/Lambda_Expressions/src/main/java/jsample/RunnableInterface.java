package jsample;

public class RunnableInterface {
	public static void main(String[] args) {
		/**
		 * Create thread without lambda expression
		 */
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Hello World Till Java 1.7");
			}
		}).start();

		/**
		 * Create thread with lambda expression
		 */
		new Thread(() -> System.out.println("Hello World In Java 1.8")).start();
	}
}
