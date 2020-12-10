package com.ptm.login.reqprocessor;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.ptm.common.service.ServiceResponse;
import com.ptm.common.service.SuccessResponse;
import com.ptm.login.vo.LoginVO;
import com.ptm.login.vo.UserDetailVO;
import com.ptm.login.service.LoginService;

@Component
public class LoginReqProcessor {
	
	@Autowired private LoginService loginService;
		
	public <T> ResponseEntity<ServiceResponse> login(@Valid LoginVO request) {
		LoginVO loginVO = (LoginVO) request;
		UserDetailVO userDetailVO = loginService.login(loginVO);
		ServiceResponse response = new ServiceResponse(new SuccessResponse(userDetailVO), HttpStatus.OK );
		return ResponseEntity.ok(response);
	}
		
}
