package com.ptm.main.service;

import java.util.Map;

import com.ptm.main.common.pojo.SearchParams;
import com.ptm.main.common.pojo.SearchResult;
import com.ptm.main.entity.Department;
import com.ptm.main.entity.Designation;
import com.ptm.main.entity.Role;

public interface PTMAdminService {
	SearchResult getRoleNDepartmentByDesignationId(SearchParams searchParams);

	Map<Integer, String> getRoleListByDepartmentId(SearchParams searchParams);

	Map<Integer, String> getDepartmentList();

	Designation getDesignationIdByRoleNDepttId(SearchParams searchParams);

	Role getRoleById(SearchParams searchParams);

	Department getDepartmentById(SearchParams searchParams);
}
