package com.its20.demo.entity.repository;

import java.util.LinkedList;
import java.util.List;

import com.its20.demo.entity.User;
import com.its20.demo.exception.UserNotFoundException;

public class UserRepository {
	private static List<User> users = new LinkedList<>();

	static {
		User defaultUser = new User();
		defaultUser.setEmail("admin@mics.edu");
		defaultUser.setMobile("+95867246346");
		defaultUser.setName("Admin user");
		defaultUser.setPassword("root");
		defaultUser.setStudentId(3432L);
		users.add(defaultUser);
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(User user) {
		user.setEmail(user.getEmail().toLowerCase());
		users.add(user);
	}

	public User getUserByEmail(String email) {
		email = email.toLowerCase();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getEmail().equals(email))
				return users.get(i);
		}
		throw new UserNotFoundException("No account with " + email);
	}
}
