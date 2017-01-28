package jsample.concurrency;

import java.util.concurrent.Callable;

public class SignalHandler implements Callable<String> {

	private String signal;

	public SignalHandler(String signal) {
		this.signal = signal;
		System.out.println(Thread.currentThread().getName() + " Input signal = " + signal);
	}

	private void handleSignal() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName() + " Start handling signal = " + signal);
		handleSignal();
		System.out.println(Thread.currentThread().getName() + " End");
		return signal;
	}

}
