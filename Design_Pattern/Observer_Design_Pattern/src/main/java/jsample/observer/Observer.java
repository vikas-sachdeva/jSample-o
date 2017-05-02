package jsample.observer;

import jsample.observer.impl.UserState;

/**
 * Observer pattern is one of the behavioral design pattern.
 * 
 * Observer pattern is used for observing change in state of an object and to
 * notify all dependent or registered objects about this change.
 * 
 * Object which is observed is called Subject or Observable and objects which
 * are notified are called Observer.
 * 
 * One Subject can have multiple observers.
 * 
 */
public interface Observer {

	public void update(UserState userState);

}
