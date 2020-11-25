package com.ptm.main.service;

import java.util.Map;

import com.ptm.common.vo.EmployeeVO;
import com.ptm.common.vo.LoginVO;
import com.ptm.main.common.pojo.SearchParams;

public interface EmployeeService {

	void saveOrUpdateEmployee(EmployeeVO employeeVO, SearchParams searchParams);

	int updatePassword(LoginVO loginVO);

	int deleteEmployeePersonal(SearchParams searchParams);

	EmployeeVO getEmployeeDetailsById(SearchParams searchParams);

	Map<Integer, String> getIndiaStateList();
}
