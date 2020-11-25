package com.ptm.login.reqprocessor;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.ptm.common.response.ServiceResponse;
import com.ptm.common.vo.LoginVO;
import com.ptm.common.vo.UserDetailVO;
import com.ptm.login.service.LoginService;

@Component
public class LoginReqProcessor {
	
	@Autowired private LoginService loginService;
	private ServiceResponse<UserDetailVO, Exception> serviceResponse;
	
	public ResponseEntity<ServiceResponse<UserDetailVO, Exception>> login(@Valid LoginVO loginVO) {
		UserDetailVO userDetailVO = loginService.login(loginVO);
		ServiceResponse<UserDetailVO , Exception> response = new ServiceResponse<>(userDetailVO, null, HttpStatus.OK );
		return ResponseEntity.ok(response);
	}
		
}
