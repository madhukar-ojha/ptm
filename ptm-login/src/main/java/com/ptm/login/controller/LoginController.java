package com.ptm.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ptm.common.response.ServiceResponse;
import com.ptm.common.vo.LoginVO;
import com.ptm.common.vo.UserDetailVO;
import com.ptm.login.reqprocessor.LoginReqProcessor;

@RestController
public class LoginController {
	
	@Autowired private LoginReqProcessor loginReqProcessor;
	
	@PostMapping(value = "/login")
	public ResponseEntity<ServiceResponse<UserDetailVO, Exception>> login(@RequestBody LoginVO loginVO) {
		return loginReqProcessor.login(loginVO);
	}
	
}
