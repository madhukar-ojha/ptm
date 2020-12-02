package com.web.ptm.service.impl;

import static com.web.ptm.common.constant.ParamConstants.STATE_ID;
import static com.web.ptm.common.constant.StringConstants.EMPLOYEE_SUB_MENU_SAVE;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.ptm.common.constant.PropertiesConfig;
import com.web.ptm.common.pojo.SearchParams;
import com.web.ptm.common.util.AppMethodUtils;
import com.web.ptm.dao.EmployeeDAO;
import com.web.ptm.dao.LoginNRoleDAO;
import com.web.ptm.entity.Designation;
import com.web.ptm.entity.Employee;
import com.web.ptm.entity.IndiaState;
import com.web.ptm.service.EmployeeService;
import com.web.ptm.userrole.vo.EmployeeVO;
import com.web.ptm.vo.LoginVO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	@Autowired
	private LoginNRoleDAO loginRoleDAO;
	@Autowired
	private PropertiesConfig ptmConfigProperties;

	@Override
	public void saveOrUpdateEmployee(EmployeeVO employeeVO, SearchParams searchParams) {
		Employee employee = BeanUtils.instantiate(Employee.class);
		BeanUtils.copyProperties(employeeVO, employee);
		LocalDate dateOfBirth = AppMethodUtils.stringToDate(employeeVO.getDateOfBirth(), null);
		employee.setDateOfBirth(dateOfBirth);
		// Fetching designation by role n department
		SearchParams designationSearch = BeanUtils.instantiate(SearchParams.class);
		designationSearch.setIntNum1(employeeVO.getRole());
		designationSearch.setIntNum2(employeeVO.getDepartment());
		Designation designation = loginRoleDAO.getDesignationIdByRoleNDepttId(designationSearch);
		employee.setDesignation(designation);
		// Fteching InddiaState entity
		SearchParams indiaStateSearch = BeanUtils.instantiate(SearchParams.class);
		indiaStateSearch.getRequestMap().put(STATE_ID, employeeVO.getState());
		IndiaState indiaState = employeeDAO.getIndiaState(indiaStateSearch);
		employee.setIndiaState(indiaState);
		if (EMPLOYEE_SUB_MENU_SAVE.equals(employeeVO.getAction())) {
			employee.setEnabled(Boolean.parseBoolean(ptmConfigProperties.getEmpDefaultEnabledStatus()));
			employee.setPassword(ptmConfigProperties.getDefaultPassword());
		}
		employeeDAO.saveOrUpdateEmployee(employee);
	}

	@Override
	public EmployeeVO getEmployeeDetailsById(SearchParams searchParams) {
		EmployeeVO employeeVO = employeeDAO.getEmployeeDetailsById(searchParams);
		if (employeeVO == null) {
			return null;
		}
		return employeeVO;
	}

	@Override
	public int deleteEmployeePersonal(SearchParams searchParams) {
		return employeeDAO.deleteEmployee(searchParams);
	}

	@Override
	public Map<Integer, String> getIndiaStateList() {
		Map<Integer, String> indiaStateMap = employeeDAO.getIndiaStateList();
		return indiaStateMap;
	}

	@Override
	public int updatePassword(LoginVO loginVO) {
		return employeeDAO.updatePassword(loginVO);
	}

}
