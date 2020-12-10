package com.ptm.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptm.login.vo.LoginVO;
import com.ptm.login.vo.UserDetailVO;
import com.ptm.login.dao.LoginDAO;
import com.ptm.login.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginDAO loginDAO;

	@Override
	public UserDetailVO login(LoginVO loginVO) {
		UserDetailVO userDetailVO = loginDAO.login(loginVO);
		
		// preparing home map to display menu on home.jsp
		/*
		 * Map<String, TreeSet<SubMenuVO>> homeMap = new HashMap<String,
		 * TreeSet<SubMenuVO>>(); List<SubMenuVO> redundantList = new
		 * ArrayList<SubMenuVO>(); TreeSet<SubMenuVO> list = new TreeSet<SubMenuVO>();
		 */
		/*
		 * for (MenuVO menuVO : userDetailVO.getUserRole()) { for (SubMenuVO subMenuVO :
		 * menuVO.getSubMenuList()) { list.add(subMenuVO); // This loop is for SubMenu
		 * dependency. eg Employee update has implicit employee // search right. So it
		 * is looked and put on list. for (SubMenuVO subMenuVO2 :
		 * subMenuVO.getSubMenuDependencySet()) { if (subMenuVO2.getIndex() == 0) {
		 * list.add(subMenuVO2); list.remove(subMenuVO); redundantList.add(subMenuVO);
		 * break; } } } list.removeAll(redundantList); homeMap.put(menuVO.getMenuName(),
		 * list); }
		 */
	//	userDetailVO.setHomeMap(homeMap);

		return userDetailVO;
	}
}
