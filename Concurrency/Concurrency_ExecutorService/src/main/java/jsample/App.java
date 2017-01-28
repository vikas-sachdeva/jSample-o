package jsample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import jsample.concurrency.SignalHandler;

public class App {
	public static final int THREAD_POOL_SIZE = 5;

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
		for (int i = 0; i < 10; i++) {
			Runnable sHandler = new SignalHandler("" + i);
			executor.execute(sHandler);
		}
		// shutdown executor.
		System.out.println("Shutdown executor");
		executor.shutdown();
		while (!executor.isTerminated()) {
			/**
			 * There is a difference between shutdown and terminated. Shutdown
			 * refers to shutdown of executor i.e. it initiates an orderly
			 * shutdown in which previously submitted tasks are executed, but no
			 * new tasks will be accepted. Terminated refers to termination of
			 * all threads managed by the executor.
			 */
			// wait for termination of the thread pool
			System.out.println("Wait for executor termination");
			Thread.sleep(1 * 1000);
		}
		System.out.println("Finished all threads");
	}
}
