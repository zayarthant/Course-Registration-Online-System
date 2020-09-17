package com.its20.demo.entity.repository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.its20.demo.entity.Registration;
import com.its20.demo.exception.UserNotFoundException;

public class RegistrationRepository {
	private static List<Registration> registrations = new LinkedList<>();

	public List<Registration> getRegistration() {
		return registrations;
	}

	public List<Registration> getRegistrationByStudentId(long id) {
		List<Registration> list = new ArrayList<>();
		for (int i = 0; i < registrations.size(); i++) {
			if (registrations.get(i).getStudent().getStudentId() == id)
				list.add(registrations.get(i));
		}
		return list;
	}

	public Registration getById(long id) {
		for (int i = 0; i < registrations.size(); i++) {
			if (registrations.get(i).getId() == id)
				return registrations.get(i);
		}
		throw new UserNotFoundException("No registration with " + id);
	}

	public void setRegistration(Registration registration) {
		registrations.add(registration);
	}
}
