package jsample.observer;

import jsample.observer.impl.UserState;

public interface Observable {

	public void registerObserver(Observer observer);

	public void unregisterObserver(Observer observer);

	public void notifyObservers();
	
	public UserState getChanged();
	
	public void setUserState(UserState userState);

}
