package com.ptm.main.dao;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.ptm.common.service.ServiceResponse;
import com.ptm.common.vo.LoginVO;
import com.ptm.main.common.pojo.SearchParams;
import com.ptm.main.common.pojo.SearchResult;
import com.ptm.main.entity.Department;
import com.ptm.main.entity.Designation;
import com.ptm.main.entity.Role;

public interface LoginDAO {

	ResponseEntity<ServiceResponse> login(LoginVO loginVo);

	SearchResult getRoleNDepartmentByDesignationId(SearchParams searchParams);

	Map<Integer, String> getRoleListByDepartmentId(SearchParams searchParams);

	Map<Integer, String> getDepartmentList();

	Designation getDesignationIdByRoleNDepttId(SearchParams searchParams);

	Role getRoleById(SearchParams searchParams);

	Department getDepartmentById(SearchParams searchParams);

//	Designation getDesignationIdByRoleNDepttId(SearchParams searchParams)
}
