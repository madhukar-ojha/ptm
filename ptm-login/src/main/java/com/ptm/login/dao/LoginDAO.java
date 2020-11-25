package com.ptm.login.dao;

import com.ptm.common.vo.LoginVO;
import com.ptm.common.vo.UserDetailVO;

public interface LoginDAO {
	UserDetailVO login(LoginVO loginVO);
}
