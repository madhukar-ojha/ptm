package com.ptm.ptmlogin.service;


import java.util.Map;

import com.ptm.ptmlogin.entity.UserDetailVO;
import com.ptm.ptmlogin.vo.LoginVO;

public interface LoginService {

	UserDetailVO isValidLogin(LoginVO loginVO);

	/*
	 * Map<Integer, String> getRoleListByDepartmentId(SearchParams searchParams);
	 * 
	 * Map<Integer, String> getDepartmentList();
	 * 
	 * Designation getDesignationIdByRoleNDepttId(SearchParams searchParams);
	 */

}
