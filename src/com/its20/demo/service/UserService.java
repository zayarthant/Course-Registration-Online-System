package com.its20.demo.service;

import java.util.List;

import com.its20.demo.entity.User;
import com.its20.demo.entity.repository.UserRepository;
import com.its20.demo.exception.IncorrectPassowrdException;

public class UserService {

	private UserRepository repository;

	public UserService() {
		repository = new UserRepository();
	}

	public List<User> getUsers() {
		return repository.getUsers();
	}

	public void setUsers(User user) {
		repository.setUsers(user);
	}

	public User login(String email, String password) {
		User user = repository.getUserByEmail(email);
		if (!user.getPassword().equals(password))
			throw new IncorrectPassowrdException("Incorrect password!");
		return user;
	}

}
