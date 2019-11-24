package com.iii.demo.modules.user.service;


import com.iii.demo.modules.user.mapper.EmployeeMapper;
import com.iii.demo.modules.user.vo.Employee;
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

    public Employee findByUserName(String userName) {
        return this.employeeMapper.findByUserName(userName);
    }
}
