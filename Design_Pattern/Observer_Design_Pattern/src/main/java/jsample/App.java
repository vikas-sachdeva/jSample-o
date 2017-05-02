package jsample;

import jsample.observer.Observable;
import jsample.observer.Observer;
import jsample.observer.impl.BillingDepartement;
import jsample.observer.impl.TechnicalDepartement;
import jsample.observer.impl.User;
import jsample.observer.impl.UserState;

public class App {
	public static void main(String[] args) {
		Observer observer1 = new BillingDepartement();
		Observer observer2 = new TechnicalDepartement();

		Observable observable = new User();
		observable.registerObserver(observer1);
		observable.registerObserver(observer2);

		observable.setUserState(UserState.NEW_CONNECTION);
		observable.notifyObservers();

		observable.setUserState(UserState.CHANGE_500_PLAN);
		observable.notifyObservers();

		observable.unregisterObserver(observer2);

		observable.setUserState(UserState.CHANGE_100_PLAN);
		observable.notifyObservers();
	}
}
