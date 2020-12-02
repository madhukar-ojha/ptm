package com.web.ptm.common.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.web.ptm.userrole.vo.MenuVO;
import com.web.ptm.userrole.vo.SubMenuVO;
import com.web.ptm.userrole.vo.UserDetailVO;

public class AppMethodUtils {
	public static boolean isValidRequest(BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.err.println("----------- checking request errors ----------");
			for (FieldError error : bindingResult.getFieldErrors()) {
				System.err.println(error.getField() + " : " + error.getDefaultMessage());
				return false;
			}
		}
		return true;

	}

	public static boolean isValidRequestTest(BindingResult bindingResult) {
		System.out.println("----------- input has errors ----------");
		for (FieldError error : bindingResult.getFieldErrors()) {
			System.out.println("field : " + error.getField());
			System.out.println("DefaultMessage : " + error.getDefaultMessage());
			System.out.println("Code : " + error.getCode());
			System.out.println("RejectedValue : " + error.getRejectedValue());
			System.out.println("ObjectName : " + error.getObjectName() + "\n-----------------\n");
			for (Object temp : error.getArguments()) {
				System.out.println("getArguments : " + temp);
			}
			for (String temp : error.getCodes()) {
				System.out.println("getCodes() : " + temp);
			}
		}
		return true;
	}

	public static SubMenuVO getSubMenuVO(UserDetailVO userDetailVO, String menuKey, String subMneuKey) {
		for (MenuVO menuVO : userDetailVO.getUserRole()) {
			if (menuKey.equalsIgnoreCase(menuVO.getMenuKey())) {
				for (SubMenuVO subMenuVO : menuVO.getSubMenuList()) {
					if (subMneuKey.equalsIgnoreCase(subMenuVO.getActionKey())) {
						return subMenuVO;
					}
					for (SubMenuVO dependency : subMenuVO.getSubMenuDependencySet()) {
						if (subMneuKey.equalsIgnoreCase(dependency.getActionKey())) {
							return dependency;
						}
					}
				}
			}
		}
		return null;
	}

	public static String dateToString(LocalDate date, String dateFormat) {
		return date.toString();
	}

	public static LocalDate stringToDate(String date, String dateFormat) {
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;/* ofPattern(DATE_FORMAT_YYYY_MM_DD); */
		LocalDate localDate = null;
		try {
			localDate = LocalDate.parse(date, formatter);
		} catch (DateTimeParseException e) {
			e.printStackTrace();
		}
		return localDate;
	}

	/*
	 * public static int getDesignationIdByRoleNDeptt(String role, String
	 * department) { SearchParams searchParams = new SearchParams(); LoginNRoleDAO
	 * userRoleDAO = new LoginNRoleDAOImpl();
	 * searchParams.setIntNum1(Integer.parseInt(role));
	 * searchParams.setIntNum2(Integer.parseInt(department)); Designation
	 * designationDTO = userRoleDAO.getDesignationIdByRoleNDepttId(searchParams);
	 * int designationId = designationDTO.getId(); return designationId; }
	 */

}
