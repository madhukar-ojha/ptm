package com.web.ptm.service;

import java.util.Map;

import com.web.ptm.common.pojo.SearchParams;
import com.web.ptm.userrole.vo.EmployeeVO;
import com.web.ptm.vo.LoginVO;

public interface EmployeeService {

	void saveOrUpdateEmployee(EmployeeVO employeeVO, SearchParams searchParams);

	int updatePassword(LoginVO loginVO);

	int deleteEmployeePersonal(SearchParams searchParams);

	EmployeeVO getEmployeeDetailsById(SearchParams searchParams);

	Map<Integer, String> getIndiaStateList();
}
