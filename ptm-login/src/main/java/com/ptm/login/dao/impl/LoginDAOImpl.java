package com.ptm.login.dao.impl;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptm.login.common.constant.HibernateQuery;
import com.ptm.login.dao.LoginDAO;
import com.ptm.login.entity.Designation;
import com.ptm.login.entity.Employee;
import com.ptm.login.entity.Role;
import com.ptm.login.vo.LoginVO;
import com.ptm.login.vo.MenuVO;
import com.ptm.login.vo.UserDetailVO;

@Repository
public class LoginDAOImpl implements LoginDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired UserDetailVO userDetailVO;
	@Override
	public UserDetailVO login(LoginVO loginVO) {
		Session session = sessionFactory.openSession();
	//	Role r =  session.get(Role.class, 10);
	//	System.out.println(r.getDepartment());
		Query<Employee> query =  session.createQuery(HibernateQuery.USER_LOGIN, Employee.class);
		query.setParameter("id", loginVO.getId());
		query.setParameter("password", loginVO.getPassword());
		Employee employee = query.getSingleResult();
		if (employee == null) { 
		//	logger.info("Invalid credentials..."); 
			return null; 
		} 
		
	//	BeanUtils.copyProperties(employee, userDetailVO);
		Role role = employee.getRole();
		Designation designation = role.getDesignation();
		String desig = role.getDesignation().getShortName();
		String dept =  role.getDepartment().getName();
		String designationName = desig + " " + dept; 
		userDetailVO.setDesignationName(designationName);
		Map<Integer, MenuVO> roleMap = new TreeMap<Integer, MenuVO>(); // Preparing set of permitted urls of user
		Set<String> permittedURLs = new HashSet<String>(); 
/*			for (UserRole role : userRole) { SubMenu subMenu = role.getSubMenu(); Menu menu =
					* subMenu.getMenu(); // Putting all url into set. This set will be used in
					* interceptor // to authorize request. permittedURLs.add(new
					* StringBuilder(contextPath).append(subMenu.getSubMenuUrl()).toString());
					* permittedURLs.add(new
							* StringBuilder(contextPath).append(menu.getMenuUrl()).toString()); int id =
							* menu.getId(); SubMenuVO subMenuVO = BeanUtils.instantiate(SubMenuVO.class);
							* BeanUtils.copyProperties(subMenu, subMenuVO); // Checking submenu dependency
							* Set<SubMenuDependency> dependency =
									* subMenu.getSubMenuDependenciesForSubMenuId(); for (SubMenuDependency dep :
										* dependency) { // populating submneu dependency in submenu SubMenuVO smdep =
										* BeanUtils.instantiate(SubMenuVO.class);
										* BeanUtils.copyProperties(dep.getSubMenuBySubMenuDependencyId(), smdep);
										* subMenuVO.getSubMenuDependencySet().add(smdep); permittedURLs.add(new
												* StringBuilder(contextPath).append(smdep.getSubMenuUrl()).toString()); }
									* MenuVO menuVO = roleMap.get(id); // Checking if key(Menu id) exists in map if
									* (menuVO != null) { // Key exists. Fetch MenuVO and put SubMenuVO in MenuVO
										* menuVO.getSubMenuList().add(subMenuVO); } else { // Key don't exists.
											* preparing MenuVo and SubMenuVO and // putting in map as menu id as key and
											* submenuvo asvalue menuVO = BeanUtils.instantiate(MenuVO.class);
											* BeanUtils.copyProperties(menu, menuVO);
											* menuVO.getSubMenuList().add(subMenuVO); roleMap.put(menuVO.getId(), menuVO);
											* } } userDetailVO.setUserRole(roleMap.values());
											* userDetailVO.setPermittedURLs(permittedURLs); session.close();

											return new UserDetailVO();*/
		return new UserDetailVO();
	}
}
