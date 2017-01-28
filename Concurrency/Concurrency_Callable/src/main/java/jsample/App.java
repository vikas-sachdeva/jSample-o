package jsample;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import jsample.concurrency.SignalHandler;

public class App {
	private static final int THREAD_POOL_SIZE = 2;

	private static final String SIGNAL_ONE = "signal 1";

	private static final String SIGNAL_TWO = "signal 2";

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

		Callable<String> sHandler1 = new SignalHandler(SIGNAL_ONE);
		Future<String> future1 = executor.submit(sHandler1);

		Callable<String> sHandler2 = new SignalHandler(SIGNAL_TWO);
		Future<String> future2 = executor.submit(sHandler2);

		if (future1.isDone()) {
			System.out.println("Signal Handler " + SIGNAL_ONE + " is completed.");
		} else {
			System.out.println("Signal Handler " + SIGNAL_ONE + " is not yet completed.");
		}

		if (future2.isDone()) {
			System.out.println("Signal Handler " + SIGNAL_TWO + " is completed.");
		} else {
			System.out.println("Signal Handler " + SIGNAL_TWO + " is not yet completed.");
		}

		System.out.println("Signal Handler " + SIGNAL_ONE + " result = " + future1.get());

		System.out.println("Signal Handler " + SIGNAL_TWO + " result = " + future2.get(1000, TimeUnit.MILLISECONDS));

		executor.shutdown();

	}
}
