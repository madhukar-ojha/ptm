package com.web.ptm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.ptm.reqprocessor.EmployeeReqProcessor;
import com.web.ptm.vo.LoginVO;
import com.web.ptm.vo.RoleListVO;

@Controller
@RequestMapping("/public")
public class PublicController {
	private static int t_count;

	public PublicController() {
		System.out.println("---- PublicController count : " + ++t_count);
	}

	@Autowired
	private EmployeeReqProcessor employeeReqProcessor;

	@GetMapping(value = "/employee/getRoleList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RoleListVO>> getRoleList(@RequestParam("departmentId") int departmentId) {
		List<RoleListVO> roleListForms = employeeReqProcessor.getRoleList(departmentId);
		return new ResponseEntity<List<RoleListVO>>(roleListForms, HttpStatus.OK);
	}

	@PostMapping(value = "/updatePassword")
	public String updatePassword(LoginVO loginVO, ModelMap modelMap) {
		return employeeReqProcessor.updatePassword(loginVO, modelMap);
	}

	/*
	 * @GetMapping(path = "/employee/search", produces =
	 * MediaType.APPLICATION_JSON_VALUE) public ResponseEntity<EmployeeJSonVO>
	 * getEmployeeDetailsById(@RequestParam("id") int id) { EmployeeJSonVO
	 * employeeJSonVO = employeeReqProcessor.getEmployeeDetailsByIdAsJson(id);
	 * return new ResponseEntity<EmployeeJSonVO>(employeeJSonVO, HttpStatus.OK); }
	 */
}
