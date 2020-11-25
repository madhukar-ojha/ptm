package com.ptm.login.dao.impl;

import org.springframework.stereotype.Repository;

import com.ptm.common.vo.LoginVO;
import com.ptm.common.vo.UserDetailVO;
import com.ptm.login.dao.LoginDAO;

@Repository
public class LoginDAOImpl implements LoginDAO {
	@Override
	public UserDetailVO login(LoginVO loginVO) {
		if((loginVO.getId() == 101) && "ptmpwd".equalsIgnoreCase(loginVO.getPassword())) {
			return new UserDetailVO();
		}else {
			return null;
		}
	}
}
