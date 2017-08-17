package com.dbbyte.service;

import org.springframework.stereotype.Service;

import com.dbbyte.model.Employee;

@Service
public class EmployeeService {

	public Employee createEmployee(String employeeName) {

    	Employee employee = new Employee();
    	employee.setName(employeeName);

        return employee;
	}
}
