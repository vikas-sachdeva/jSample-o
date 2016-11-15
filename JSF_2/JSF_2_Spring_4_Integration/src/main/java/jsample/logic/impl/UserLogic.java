package jsample.logic.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jsample.bean.User;
import jsample.logic.IUserLogic;

@Service
public class UserLogic implements IUserLogic {

	public List<User> getUserDetails() {
		List<User> userList = new ArrayList<>();
		User user = new User();
		userList.add(user);
		user.setFirstName("Robert");
		user.setLastName("Brown");

		user = new User();
		userList.add(user);
		user.setFirstName("John");
		user.setLastName("Dalton");

		user = new User();
		userList.add(user);
		user.setFirstName("Albert");
		user.setLastName("Einstein");

		user = new User();
		userList.add(user);
		user.setFirstName("Caesar");
		user.setLastName("Cipher");

		user = new User();
		userList.add(user);
		user.setFirstName("Alice");
		user.setLastName("Cooper");

		return userList;
	}

}
