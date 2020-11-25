package com.ptm.main.dao;

import java.util.Map;

import com.ptm.common.vo.EmployeeVO;
import com.ptm.common.vo.LoginVO;
import com.ptm.main.common.pojo.SearchParams;
import com.ptm.main.entity.Employee;
import com.ptm.main.entity.IndiaState;

public interface EmployeeDAO {

	Employee getEmployeeDetailsById(int id);

	void saveOrUpdateEmployee(Employee employee);

	int updatePassword(LoginVO loginVO);

	int deleteEmployee(SearchParams searchParams);

	EmployeeVO getEmployeeDetailsById(SearchParams searchParams);

	Map<Integer, String> getIndiaStateList();

	IndiaState getIndiaState(SearchParams searchParams);

}
