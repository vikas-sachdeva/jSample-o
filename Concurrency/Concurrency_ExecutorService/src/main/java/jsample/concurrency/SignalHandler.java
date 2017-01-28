package jsample.concurrency;

public class SignalHandler implements Runnable {

	private String signal;

	public SignalHandler(String signal) {
		this.signal = signal;
		System.out.println(Thread.currentThread().getName() + " Input signal = " + signal);
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Start handling signal = " + signal);
		handleSignal();
		System.out.println(Thread.currentThread().getName() + " End");
	}

	private void handleSignal() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
