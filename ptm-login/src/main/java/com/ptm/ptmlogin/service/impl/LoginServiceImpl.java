package com.ptm.ptmlogin.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptm.ptmlogin.dao.LoginDAO;
import com.ptm.ptmlogin.entity.UserDetailVO;
import com.ptm.ptmlogin.service.LoginService;
import com.ptm.ptmlogin.vo.LoginVO;
/*import com.web.ptm.common.pojo.SearchParams;
import com.web.ptm.dao.LoginNRoleDAO;
import com.web.ptm.entity.Designation;
import com.web.ptm.service.LoginNRoleService;*/
/*import com.web.ptm.userrole.vo.SubMenuVO;
import com.web.ptm.userrole.vo.UserDetailVO;*/

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO loginDAO;

	@Override
	public UserDetailVO isValidLogin(LoginVO loginVO) {
		UserDetailVO userDetailVO = loginDAO.isValidLogin(loginVO);
		if (userDetailVO == null) {
			return null;
		}
		// preparing home map to display menu on home.jsp
		/*Map<String, TreeSet<SubMenuVO>> homeMap = new HashMap<String, TreeSet<SubMenuVO>>();
		List<SubMenuVO> redundantList = new ArrayList<SubMenuVO>();
		TreeSet<SubMenuVO> list = new TreeSet<SubMenuVO>();*/
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
//		userDetailVO.setHomeMap(homeMap);

		return userDetailVO;
	}}

/*
 * @Override public Map<Integer, String> getRoleListByDepartmentId(SearchParams
 * searchParams) { Map<Integer, String> roleMap =
 * loginRoleDAO.getRoleListByDepartmentId(searchParams); return roleMap; }
 * 
 * @Override public Map<Integer, String> getDepartmentList() { Map<Integer,
 * String> departmentMap = loginRoleDAO.getDepartmentList(); return
 * departmentMap; }
 * 
 * @Override public Designation getDesignationIdByRoleNDepttId(SearchParams
 * searchParams) { Designation designation =
 * loginRoleDAO.getDesignationIdByRoleNDepttId(searchParams); return
 * designation; } }
 */
