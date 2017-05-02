package jsample.observer.impl;

import java.util.ArrayList;
import java.util.List;

import jsample.observer.Observable;
import jsample.observer.Observer;

public class User implements Observable {

	private List<Observer> observerList = new ArrayList<>();

	private UserState userState;

	@Override
	public void registerObserver(Observer observer) {
		observerList.add(observer);
	}

	@Override
	public void unregisterObserver(Observer observer) {
		observerList.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observerList) {
			observer.update(userState);
		}
	}

	@Override
	public UserState getChanged() {
		return userState;
	}

	@Override
	public void setUserState(UserState userState) {
		this.userState = userState;
	}

}
