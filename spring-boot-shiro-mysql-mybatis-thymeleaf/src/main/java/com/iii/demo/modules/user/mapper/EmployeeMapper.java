package com.iii.demo.modules.user.mapper;

import com.iii.demo.modules.user.vo.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
	List<Employee> findAll();

	Employee findByUserName(String userName);
}
