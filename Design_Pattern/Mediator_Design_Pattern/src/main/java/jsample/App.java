package jsample;

import jsample.mediator.Mediator;
import jsample.mediator.User;
import jsample.mediator.impl.TweetMediator;
import jsample.mediator.impl.TwitterUser;

public class App {
	public static void main(String[] args) {

		Mediator mediator = new TweetMediator();

		User user1 = new TwitterUser();
		user1.setMediator(mediator);
		user1.setName("Albert");

		User user2 = new TwitterUser();
		user2.setMediator(mediator);
		user2.setName("Wilson");

		User user3 = new TwitterUser();
		user3.setMediator(mediator);
		user3.setName("Noman");

		mediator.addFollower(user1, user2);
		mediator.addFollower(user1, user3);

		mediator.addFollower(user2, user3);

		user1.postMessage("Hi! This is my first tweet");

		user2.postMessage("Hi! This is my first tweet");

		user3.postMessage("Hi! This is my first tweet");

	}
}
