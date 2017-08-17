package com.dbbyte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbbyte.model.Employee;
import com.dbbyte.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/create")
	public Employee employee(String employeeName) {
		return employeeService.createEmployee(employeeName);
	}
}
