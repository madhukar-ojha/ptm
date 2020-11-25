package com.ptm.ptmlogin.dao;


import java.util.Map;

import com.ptm.ptmlogin.entity.UserDetailVO;
import com.ptm.ptmlogin.vo.LoginVO;

public interface LoginDAO {

	UserDetailVO isValidLogin(LoginVO loginVO);

	/*
	 * SearchResult getRoleNDepartmentByDesignationId(SearchParams searchParams);
	 * 
	 * Map<Integer, String> getRoleListByDepartmentId(SearchParams searchParams);
	 * 
	 * Map<Integer, String> getDepartmentList();
	 * 
	 * Designation getDesignationIdByRoleNDepttId(SearchParams searchParams);
	 * 
	 * Role getRoleById(SearchParams searchParams);
	 * 
	 * Department getDepartmentById(SearchParams searchParams);
	 */

//	Designation getDesignationIdByRoleNDepttId(SearchParams searchParams)
}
