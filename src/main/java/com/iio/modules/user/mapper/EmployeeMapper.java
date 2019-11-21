package com.iio.modules.user.mapper;


import com.iio.modules.user.vo.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
	List<Employee> findAll();
}
