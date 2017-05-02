package jsample.mediator.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jsample.mediator.Mediator;
import jsample.mediator.User;

public class TweetMediator implements Mediator {

	private Map<User, List<User>> userFollowerMap = new HashMap<>();

	@Override
	public void sendNotification(String message, User user) {
		if (userFollowerMap.containsKey(user)) {
			for (User follower : userFollowerMap.get(user)) {
				follower.receiveNotification("User - " + user.getName() + " - tweets - " + message);
			}
		}
	}

	@Override
	public void addFollower(User user, User follower) {
		if (userFollowerMap.containsKey(user)) {
			userFollowerMap.get(user).add(follower);
		} else {
			List<User> followerList = new ArrayList<>();
			followerList.add(follower);
			userFollowerMap.put(user, followerList);
		}
	}
}