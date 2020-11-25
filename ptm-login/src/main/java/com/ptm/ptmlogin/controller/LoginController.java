package com.ptm.ptmlogin.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ptm.ptmlogin.entity.UserDetailVO;
import com.ptm.ptmlogin.reqprocessor.LoginReqProcessor;
import com.ptm.ptmlogin.vo.LoginVO;


@RestController
@RequestMapping("/")
public class LoginController {
	private static int t_count;

	public LoginController() {
		System.out.println("---- LoginController count : " + ++t_count);
	}
	
//	@Cont private ServletContext servletContext;
	@Autowired private LoginReqProcessor loginReqProcessor;

	@PostMapping(value = "/login")
	public ResponseEntity<UserDetailVO> login(@Valid LoginVO loginVO, BindingResult bindingResult) {
	//	return loginReqProcessor.login(loginVO, bindingResult);
		return ResponseEntity.ok(loginReqProcessor.login(loginVO, bindingResult));
	}

	/*
	 * @ExceptionHandler(RuntimeException.class) public ModelAndView
	 * loginException(RuntimeException loginException1) { return
	 * loginReqProcessor.loginException(loginException1); }
	 */

}

