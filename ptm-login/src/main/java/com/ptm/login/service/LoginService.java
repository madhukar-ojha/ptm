package com.ptm.login.service;

import com.ptm.login.vo.LoginVO;
import com.ptm.login.vo.UserDetailVO;

public interface LoginService {
	UserDetailVO login(LoginVO loginVO);
}
