package com.ptm.ptmlogin.dao.impl;


/*import static com.web.ptm.common.constant.HibernateQuery.DEPARTMENT_LIST;
import static com.web.ptm.common.constant.HibernateQuery.DESIGNATION_ID_BY_ROLEnDEPTT_ID;
import static com.web.ptm.common.constant.HibernateQuery.ROLE_BY_ID;
import static com.web.ptm.common.constant.HibernateQuery.ROLE_LIST_BY_DEPARTMENT_ID;
import static com.web.ptm.common.constant.HibernateQuery.USER_LOGIN;*/
import static com.ptm.ptmlogin.constant.HibernateQuery.USER_LOGIN;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.naming.directory.SearchResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ptm.ptmlogin.dao.LoginDAO;
import com.ptm.ptmlogin.entity.MenuVO;
import com.ptm.ptmlogin.entity.SubMenuVO;
import com.ptm.ptmlogin.entity.UserDetailVO;
import com.ptm.ptmlogin.vo.LoginVO;
import com.web.ptm.entity.test.Department;
import com.web.ptm.entity.test.Designation;
import com.web.ptm.entity.test.Employee;
import com.web.ptm.entity.test.Menu;
import com.web.ptm.entity.test.Role;
import com.web.ptm.entity.test.SubMenu;
import com.web.ptm.entity.test.UserRole;

@Component
public class LoginDAOImpl implements LoginDAO {

//	@Autowired
//	private SessionFactory sessionFactory;
	@Autowired
	private UserDetailVO userDetailVO;
	private static final Logger logger = LogManager.getLogger(LoginDAOImpl.class);
	
	@Override
	public UserDetailVO isValidLogin(LoginVO loginVO) {
		return new UserDetailVO();
	}

	/*@Override
	public UserDetailVO isValidLogin(LoginVO loginVO) {
		Session session = sessionFactory.openSession();
		// create query
		Query<Employee> query = session.createQuery(USER_LOGIN, Employee.class);
		// setting user id and password
		query.setParameter("id", loginVO.getId());
		query.setParameter("password", loginVO.getPassword());
		// execute query
		Employee employee = query.uniqueResult();
		// No record found... means user is and password didn't match
		if (employee == null) {
			logger.info("Invalid credentials...");
			return null;
		}
		logger.info(new StringBuilder("User id " + loginVO.getId() + " logged in."));
		// Fetching context path. It will be appended to permitted URLs.
		// This URLs are investigated in request interceptor to authorize request.
//		String contextPath = searchParams.getStrData2();
		BeanUtils.copyProperties(employee, userDetailVO);
//		userDetailVO.setDesignationName(employee.getDesignationId().getDesignationName());

		Set<UserRole> userRole = employee.getDesignation().getUserRoles();
		// Preparing map of user roles
		Map<Integer, MenuVO> roleMap = new TreeMap<Integer, MenuVO>();
		// Preparing set of permitted urls of user
		Set<String> permittedURLs = new HashSet<String>();
		for (UserRole role : userRole) {
			SubMenu subMenu = role.getSubMenu();
			Menu menu = subMenu.getMenu();
			// Putting all url into set. This set will be used in interceptor
			// to authorize request.
			permittedURLs.add(new StringBuilder(contextPath).append(subMenu.getSubMenuUrl()).toString());
			permittedURLs.add(new StringBuilder(contextPath).append(menu.getMenuUrl()).toString());
			int id = menu.getId();
			SubMenuVO subMenuVO = BeanUtils.instantiate(SubMenuVO.class);
			BeanUtils.copyProperties(subMenu, subMenuVO);
			// Checking submenu dependency
			Set<SubMenuDependency> dependency = subMenu.getSubMenuDependenciesForSubMenuId();
			for (SubMenuDependency dep : dependency) {
				// populating submneu dependency in submenu
				SubMenuVO smdep = BeanUtils.instantiate(SubMenuVO.class);
				BeanUtils.copyProperties(dep.getSubMenuBySubMenuDependencyId(), smdep);
				subMenuVO.getSubMenuDependencySet().add(smdep);
				permittedURLs.add(new StringBuilder(contextPath).append(smdep.getSubMenuUrl()).toString());
			}
			MenuVO menuVO = roleMap.get(id);
			// Checking if key(Menu id) exists in map
			if (menuVO != null) {
				// Key exists. Fetch MenuVO and put SubMenuVO in MenuVO
				menuVO.getSubMenuList().add(subMenuVO);
			} else {
				// Key don't exists. preparing MenuVo and SubMenuVO and
				// putting in map as menu id as key and submenuvo asvalue
				menuVO = BeanUtils.instantiate(MenuVO.class);
				BeanUtils.copyProperties(menu, menuVO);
				menuVO.getSubMenuList().add(subMenuVO);
				roleMap.put(menuVO.getId(), menuVO);
			}
		}
		userDetailVO.setUserRole(roleMap.values());
		userDetailVO.setPermittedURLs(permittedURLs);
		session.close();
		      
		return userDetailVO;
	}

	@Override
	public Map<Integer, String> getRoleListByDepartmentId(SearchParams searchParams) {
		Session session = sessionFactory.openSession();

		// Create query object.
		@SuppressWarnings("rawtypes")
		Query query = session.createNativeQuery(ROLE_LIST_BY_DEPARTMENT_ID);
//		Query query = session.createQuery(ROLE_LIST_BY_DEPARTMENT_ID);
		query.setParameter("id", searchParams.getIntNum1());
		List roleList = query.getResultList();

		// preparing Map of role id as key and name as value
		Map<Integer, String> roleMap = new TreeMap<Integer, String>();
		for (Object dto : roleList) {
			Object[] obj = (Object[]) dto;
			int id = (Integer) obj[0];
			roleMap.put(Integer.valueOf(id), (String) obj[1]);
		}
		session.close();
		return roleMap;

	}

	@Override
	public Map<Integer, String> getDepartmentList() {
		Session session = sessionFactory.openSession();

		// Create query object.
		Query<Department> query = session.createQuery(DEPARTMENT_LIST, Department.class);
		List<Department> departmentDTOList = query.getResultList();
		// preparing Map of department id as key and name as value
		Map<Integer, String> departmentMap = new TreeMap<Integer, String>();
		for (Department dto : departmentDTOList) {
			departmentMap.put(dto.getId(), dto.getName());
		}
		session.close();
		return departmentMap;
	}

	@Override
	public Designation getDesignationIdByRoleNDepttId(SearchParams searchParams) {
		Session session = sessionFactory.openSession();

		// Create query object.
		Query<Designation> query = session.createQuery(DESIGNATION_ID_BY_ROLEnDEPTT_ID, Designation.class);
		query.setParameter("roleId", searchParams.getIntNum1());
		query.setParameter("departmentId", searchParams.getIntNum2());
		Designation designation = query.getSingleResult();
		session.close();
		return designation;
	}

	@Override
	public Role getRoleById(SearchParams searchParams) {
		Session session = sessionFactory.openSession();

		// preparing query and setting parameter
		Query<Role> query = session.createQuery(ROLE_BY_ID, Role.class);
		query.setParameter("id", searchParams.getIntNum1());
		// execute query
		Role role = query.uniqueResult();
		session.close();
		return role;
	}

	@Override
	public Department getDepartmentById(SearchParams searchParams) {
		Session session = sessionFactory.openSession();
		Department department = session.get(Department.class, searchParams.getIntNum1());
		session.close();
		return department;
	}

	@Override
	public SearchResult getRoleNDepartmentByDesignationId(SearchParams searchParams) {
		// TODO Auto-generated method stub
		return null;
	}*/
}