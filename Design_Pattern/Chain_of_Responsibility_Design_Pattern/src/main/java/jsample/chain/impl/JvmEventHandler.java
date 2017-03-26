package jsample.chain.impl;

import jsample.chain.EventHandler;

public class JvmEventHandler implements EventHandler {

	private EventHandler nextEventHandler;

	@Override
	public void setNextEventHandler(EventHandler nextEventHandler) {
		this.nextEventHandler = nextEventHandler;
	}

	@Override
	public void handle() {
		if (nextEventHandler != null) {
			nextEventHandler.handle();
		}
		System.out.println("Handling event at JVM level");

	}

}
