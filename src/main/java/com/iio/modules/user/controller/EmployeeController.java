package com.iio.modules.user.controller;

import com.iio.modules.user.service.EmployeeService;
import com.iio.modules.user.vo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/findAll")
	public List<Employee> findAll() {
		return this.employeeService.findAll();
	}
}

