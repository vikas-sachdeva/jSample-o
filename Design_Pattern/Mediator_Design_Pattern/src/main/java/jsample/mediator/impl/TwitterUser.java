package jsample.mediator.impl;

import jsample.mediator.Mediator;
import jsample.mediator.User;

public class TwitterUser implements User {

	private Mediator mediator;

	private String name;

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void postMessage(String message) {
		System.out.println(message + " -- " + name);
		mediator.sendNotification(message, this);
	}

	@Override
	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public void receiveNotification(String message) {
		System.out.println(name + " received notification - " + message);
	}

}