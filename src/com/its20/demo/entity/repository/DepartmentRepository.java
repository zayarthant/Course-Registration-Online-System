package com.its20.demo.entity.repository;

import java.util.LinkedList;
import java.util.List;

import com.its20.demo.entity.Department;
import com.its20.demo.exception.DepartmentNotFound;

public class DepartmentRepository {
	protected static List<Department> departments = new LinkedList<>();

	static {
		Department sanskritDepartment = new Department();
		sanskritDepartment.setId(1);
		sanskritDepartment.setName("Sanskrit Department");
		sanskritDepartment.setPhone("+357649534564");

		Department historyDepartment = new Department();
		historyDepartment.setId(2);
		historyDepartment.setName("History Department");
		historyDepartment.setPhone("+583968339448");

		departments.add(sanskritDepartment);
		departments.add(historyDepartment);
	}

	public Department findById(int id) {
		for (int i = 0; i < departments.size(); i++) {
			if (departments.get(i).getId() == id)
				return departments.get(i);
		}
		throw new DepartmentNotFound("No Department With ID : " + id);
	}
	
	public List<Department> getDepartment() {
		return departments;
	}

	public void setDepartment(Department department) {
		departments.add(department);
	}
}
