package com.its20.demo.service;

import java.util.List;

import com.its20.demo.entity.Department;
import com.its20.demo.entity.repository.DepartmentRepository;

public class DepartmentService {
	private DepartmentRepository departmentRepository;

	public DepartmentService() {
		departmentRepository = new DepartmentRepository();
	}

	public List<Department> getDepartments() {
		return departmentRepository.getDepartment();
	}
}
