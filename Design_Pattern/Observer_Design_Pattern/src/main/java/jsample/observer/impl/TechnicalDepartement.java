package jsample.observer.impl;

import jsample.observer.Observer;

public class TechnicalDepartement implements Observer {

	@Override
	public void update(UserState userState) {
		switch (userState) {
		case NEW_CONNECTION:
			System.out.println("Add new user in database");
			break;
		case CHANGE_100_PLAN:
			System.out.println("Change user category to 100 category");
			break;
		case CHANGE_500_PLAN:
			System.out.println("Change user category to 500 category");
			break;
		case END_CONNECTION:
			System.out.println("Mark user deleted");
			break;
		}
	}
}
