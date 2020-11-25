package com.ptm.main.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.ptm.common.response.ServiceResponse;
import com.ptm.common.vo.LoginVO;
import com.ptm.common.vo.UserDetailVO;
import com.ptm.main.common.pojo.SearchParams;
import com.ptm.main.entity.Designation;

public interface LoginService {

	ResponseEntity<ServiceResponse<UserDetailVO, Exception>> login(LoginVO loginVO);

	Map<Integer, String> getRoleListByDepartmentId(SearchParams searchParams);

	Map<Integer, String> getDepartmentList();

	Designation getDesignationIdByRoleNDepttId(SearchParams searchParams);

}
