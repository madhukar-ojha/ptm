package com.web.ptm.service;

import java.util.Map;

import com.web.ptm.common.pojo.SearchParams;
import com.web.ptm.common.pojo.SearchResult;
import com.web.ptm.entity.Department;
import com.web.ptm.entity.Designation;
import com.web.ptm.entity.Role;

public interface PTMAdminService {
	SearchResult getRoleNDepartmentByDesignationId(SearchParams searchParams);

	Map<Integer, String> getRoleListByDepartmentId(SearchParams searchParams);

	Map<Integer, String> getDepartmentList();

	Designation getDesignationIdByRoleNDepttId(SearchParams searchParams);

	Role getRoleById(SearchParams searchParams);

	Department getDepartmentById(SearchParams searchParams);
}
