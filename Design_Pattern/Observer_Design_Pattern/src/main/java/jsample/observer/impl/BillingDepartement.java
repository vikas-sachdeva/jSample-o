package jsample.observer.impl;

import jsample.observer.Observer;

public class BillingDepartement implements Observer {

	@Override
	public void update(UserState userState) {
		switch (userState) {
		case NEW_CONNECTION:
			System.out.println("Add new user for billing");
			break;
		case CHANGE_100_PLAN:
			System.out.println("Change user bill to 100");
			break;
		case CHANGE_500_PLAN:
			System.out.println("Change user bill to 500");
			break;
		case END_CONNECTION:
			System.out.println("Final user current month bill and stop further bills");
			break;
		}
	}
}
