package com.web.ptm.service;

import java.util.Map;

import com.web.ptm.common.pojo.SearchParams;
import com.web.ptm.entity.Designation;
import com.web.ptm.userrole.vo.UserDetailVO;

public interface LoginNRoleService {

	UserDetailVO isValidLogin(SearchParams searchParams);

	Map<Integer, String> getRoleListByDepartmentId(SearchParams searchParams);

	Map<Integer, String> getDepartmentList();

	Designation getDesignationIdByRoleNDepttId(SearchParams searchParams);

}
