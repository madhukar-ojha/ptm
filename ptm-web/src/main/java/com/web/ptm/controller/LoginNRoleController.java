package com.web.ptm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.web.ptm.reqprocessor.LoginNRoleReqProcessor;
import com.web.ptm.vo.LoginVO;

@Controller
@RequestMapping("/")
public class LoginNRoleController {
	private static int t_count;

	public LoginNRoleController() {
		System.out.println("---- LoginNRoleController count : " + ++t_count);
	}

	@Autowired
	private LoginNRoleReqProcessor loginReqProcessor;

	@GetMapping
	public String welcome(ModelMap modelMap) {
		return loginReqProcessor.welcome(modelMap);
	}

	@PostMapping(value = "/login")
	public String login(@Valid LoginVO loginVO, BindingResult bindingResult, ModelMap modelMap,
			HttpServletRequest request) {
	//	return loginReqProcessor.login(loginVO, bindingResult, modelMap, request);
		return "project";
	}

	@GetMapping(value = "/logout")
	public String logout(ModelMap model, HttpServletRequest request) {
		return loginReqProcessor.logout(model, request);
	}


	@GetMapping(value = "/error") 
	public String error(ModelMap model,	HttpServletRequest request) { 
		return "error"; 
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ModelAndView loginException(RuntimeException loginException1, HttpServletRequest req, Exception e) {
		return loginReqProcessor.loginException(loginException1);
	}

}
