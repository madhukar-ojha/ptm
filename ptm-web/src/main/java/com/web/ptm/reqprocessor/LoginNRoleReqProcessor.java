package com.web.ptm.reqprocessor;

import static com.web.ptm.common.constant.JspViewConstants.CHANGE_PASSWORD;
import static com.web.ptm.common.constant.JspViewConstants.HOME;
import static com.web.ptm.common.constant.JspViewConstants.LOGIN;
import static com.web.ptm.common.constant.JspViewConstants.REDIRECT_HOME_PAGE;
import static com.web.ptm.common.constant.ParamConstants.LOGIN_VO;
import static com.web.ptm.common.constant.ParamConstants.USER_DETAIL_VO;
import static com.web.ptm.common.constant.StringConstants.MSG;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.web.ptm.common.constant.PropertiesConfig;
import com.web.ptm.common.pojo.SearchParams;
import com.web.ptm.service.LoginNRoleService;
import com.web.ptm.userrole.vo.UserDetailVO;
import com.web.ptm.vo.LoginVO;

@Component
public class LoginNRoleReqProcessor {
	static int t_count;

	public LoginNRoleReqProcessor() {
	}

	@Autowired
	private PropertiesConfig appConfigProp;
	@Autowired
	private LoginNRoleService userRoleService;
	@Autowired
	private LoginVO loginVO;
	@Autowired
	private SearchParams searchParams;
	private final static Logger logger = LoggerFactory.getLogger(LoginNRoleReqProcessor.class);

	public String welcome(ModelMap model) {
		loginVO.setId(101);
		loginVO.setPassword("ptmpwd");
		model.addAttribute(LOGIN_VO, loginVO);
		model.addAttribute("name", "Madhukar Ojha");
		return LOGIN;
	}

	public String login(LoginVO loginVO, BindingResult bindingResult, ModelMap modelMap, HttpServletRequest request) {
		HttpSession session;
		// Checking request binding result
		if (bindingResult.hasErrors()) {
			return LOGIN;
		}
		searchParams.setIntNum1(loginVO.getId());
		searchParams.setStrData1(loginVO.getPassword());
		searchParams.setStrData2(request.getContextPath());
		UserDetailVO userDetailVO = userRoleService.isValidLogin(searchParams);
		if (!isValidLoginResponse(userDetailVO, modelMap, bindingResult)) {
			return LOGIN;
		} else if (isDefaultPassword(loginVO, modelMap)) {
			return CHANGE_PASSWORD;
		}
		session = request.getSession();
		session.setAttribute(USER_DETAIL_VO, userDetailVO);
		return HOME;
	}

	public String logout(ModelMap model, HttpServletRequest request) {
		request.getSession(false).invalidate();
		loginVO.setId(101);
		loginVO.setPassword("ptmpwd");
		model.addAttribute(LOGIN_VO, loginVO);
		return REDIRECT_HOME_PAGE;
	}

	public ModelAndView loginException(RuntimeException loginException) {
		ModelAndView modelMap = new ModelAndView();
		loginException.printStackTrace();
		if (loginException instanceof EmptyResultDataAccessException) {
			modelMap.addObject(MSG, appConfigProp.getLoginFailed());
		} else {
			modelMap.addObject(MSG, loginException.getMessage());
		}
		loginVO.setId(101);
		loginVO.setPassword("ptmpwd");
		modelMap.addObject(LOGIN_VO, loginVO);
		modelMap.setViewName(LOGIN);
		return modelMap;
	}

	private boolean isValidLoginResponse(UserDetailVO userDetailVO, ModelMap modelMap, BindingResult bindingResult) {
		if (userDetailVO == null) {
			bindingResult.reject("error.login.failed");
			return false;
		} else if (!userDetailVO.getEnabled()) {
			bindingResult.reject("error.login.account.locked");
			return false;
		}
		return true;
	}

	private boolean isDefaultPassword(LoginVO loginVO, ModelMap modelMap) {
		if (appConfigProp.getDefaultPassword().equals(loginVO.getPassword())) {
			loginVO.setPassword(null);
			modelMap.addAttribute(LOGIN_VO, loginVO);
			return true;
		}
		return false;
	}
}
