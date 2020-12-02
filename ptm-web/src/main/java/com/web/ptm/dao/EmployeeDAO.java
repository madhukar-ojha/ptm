package com.web.ptm.dao;

import java.util.Map;

import com.web.ptm.common.pojo.SearchParams;
import com.web.ptm.entity.Employee;
import com.web.ptm.entity.IndiaState;
import com.web.ptm.userrole.vo.EmployeeVO;
import com.web.ptm.vo.LoginVO;

public interface EmployeeDAO {

	Employee getEmployeeDetailsById(int id);

	void saveOrUpdateEmployee(Employee employee);

	int updatePassword(LoginVO loginVO);

	int deleteEmployee(SearchParams searchParams);

	EmployeeVO getEmployeeDetailsById(SearchParams searchParams);

	Map<Integer, String> getIndiaStateList();

	IndiaState getIndiaState(SearchParams searchParams);

}
