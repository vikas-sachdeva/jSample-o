package jsample;

import jsample.chain.EventHandler;
import jsample.chain.impl.JavaAppEventHandler;
import jsample.chain.impl.JvmEventHandler;
import jsample.chain.impl.OsEventHandler;

public class App {
	public static void main(String[] args) {
		EventHandler eventHandler = setEventChain();
		System.out.println("Calling event handler for handling event");
		eventHandler.handle();

	}

	private static EventHandler setEventChain() {
		System.out.println("Creating Event Chain");
		EventHandler osEventHandler = new OsEventHandler();
		EventHandler jvmEventHandler = new JvmEventHandler();
		EventHandler javaAppEventHandler = new JavaAppEventHandler();
		osEventHandler.setNextEventHandler(jvmEventHandler);
		jvmEventHandler.setNextEventHandler(javaAppEventHandler);
		return osEventHandler;
	}
}
