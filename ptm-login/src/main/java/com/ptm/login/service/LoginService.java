package com.ptm.login.service;

import com.ptm.common.vo.LoginVO;
import com.ptm.common.vo.UserDetailVO;

public interface LoginService {
	UserDetailVO login(LoginVO loginVO);
}
