package com.ptm.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ptm.common.service.ServiceResponse;
import com.ptm.login.vo.LoginVO;
import com.ptm.login.reqprocessor.LoginReqProcessor;

@RestController
public class LoginController {
	
	@Autowired private LoginReqProcessor loginReqProcessor;
	
	@PostMapping(value = "/login")
	public ResponseEntity<ServiceResponse> login(@RequestBody LoginVO request) {
		return loginReqProcessor.login(request);
	}
	
	@GetMapping(value = "/go")
	public String go() {
		return "tear ur chut madhu..............";
	}
}
