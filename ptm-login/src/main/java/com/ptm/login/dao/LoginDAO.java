package com.ptm.login.dao;

import com.ptm.common.vo.LoginVO;
import com.ptm.common.vo.UserDetailVO;

public interface LoginDAO {
	com.ptm.login.vo.UserDetailVO login(com.ptm.login.vo.LoginVO loginVO);
}
