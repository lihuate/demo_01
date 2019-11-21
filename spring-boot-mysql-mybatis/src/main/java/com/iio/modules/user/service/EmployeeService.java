package com.iio.modules.user.service;


import com.iio.modules.user.mapper.EmployeeMapper;
import com.iio.modules.user.vo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeMapper employeeMapper;

	public List<Employee> findAll() {
		return this.employeeMapper.findAll();
	}
}
