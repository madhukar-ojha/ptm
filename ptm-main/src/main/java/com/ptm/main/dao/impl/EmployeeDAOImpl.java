package com.ptm.main.dao.impl;

import static com.ptm.main.common.constant.HibernateQuery.EMPLOYEE_DELETE_BY_ID;
import static com.ptm.main.common.constant.HibernateQuery.EMPLOYEE_DETAILS_BY_ID;
import static com.ptm.main.common.constant.HibernateQuery.INDIA_STATE_LIST;
import static com.ptm.main.common.constant.HibernateQuery.UPDATE_PASSWORD;
import static com.ptm.main.common.constant.ParamConstants.STATE_ID;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptm.common.vo.DepartmentVO;
import com.ptm.common.vo.DesignationVO;
import com.ptm.common.vo.EmployeeVO;
import com.ptm.common.vo.LoginVO;
import com.ptm.common.vo.RoleVO;
import com.ptm.main.common.pojo.SearchParams;
import com.ptm.main.common.util.AppMethodUtils;
import com.ptm.main.dao.EmployeeDAO;
import com.ptm.main.entity.Employee;
import com.ptm.main.entity.IndiaState;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private EmployeeVO employeeVO;

	@Override
	public void saveOrUpdateEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(employee);
		session.getTransaction().commit();
	}

	@Override
	public int deleteEmployee(SearchParams searchParams) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		// create query
		Query<?> query = session.createQuery(EMPLOYEE_DELETE_BY_ID);
		query.setParameter("id", searchParams.getIntNum1());
		int result = query.executeUpdate();
		session.getTransaction().commit();
		return result;
	}

	@Override
	public EmployeeVO getEmployeeDetailsById(SearchParams searchParams) {
		Session session = sessionFactory.openSession();
		// create query
		Query<Employee> query = session.createQuery(EMPLOYEE_DETAILS_BY_ID, Employee.class);
		// setting user id and password
		query.setParameter("id", searchParams.getIntNum1());
		// execute query
		Employee employee = query.uniqueResult();
		if (employee == null) {
			return null;
		}
		BeanUtils.copyProperties(employee, employeeVO);
		String dob = AppMethodUtils.dateToString(employee.getDateOfBirth(), "yyyy-MM-dd");
		employeeVO.setDateOfBirth(dob);
		DesignationVO designationVO = BeanUtils.instantiate(DesignationVO.class);
		BeanUtils.copyProperties(employee.getDesignation(), designationVO);
		RoleVO roleVO = BeanUtils.instantiate(RoleVO.class);
		BeanUtils.copyProperties(employee.getDesignation().getRole(), roleVO);
		roleVO.setRole(roleVO.getId());
		designationVO.setRole(roleVO);
		DepartmentVO departmentVO = BeanUtils.instantiate(DepartmentVO.class);
		BeanUtils.copyProperties(employee.getDesignation().getDepartment(), departmentVO);
		departmentVO.setDepartment(departmentVO.getId());
		designationVO.setDepartment(departmentVO);
		employeeVO.setDesignation(designationVO);
		employeeVO.setState(employee.getIndiaState().getId());
		session.close();
		return employeeVO;
	}

	@Override
	public Map<Integer, String> getIndiaStateList() {
		Session session = sessionFactory.openSession();
		Query<IndiaState> query = session.createQuery(INDIA_STATE_LIST, IndiaState.class);
		List<IndiaState> indiaStateList = query.getResultList();
		Map<Integer, String> stateMap = new TreeMap<Integer, String>();
		for (IndiaState indiaState : indiaStateList) {
			stateMap.put(indiaState.getId(), indiaState.getName());
		}
		session.close();
		return stateMap;
	}

	@Override
	public int updatePassword(LoginVO loginVO) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(UPDATE_PASSWORD);
		query.setParameter("id", loginVO.getId());
		query.setParameter("password", loginVO.getPassword());
		int result = query.executeUpdate();
		session.getTransaction().commit();
		return result;
	}

	@Override
	public Employee getEmployeeDetailsById(int id) {
		Session session = sessionFactory.openSession();
		Employee employee = session.load(Employee.class, id);
		session.close();
		return employee;
	}

	@Override
	public IndiaState getIndiaState(SearchParams searchParams) {
		Session session = sessionFactory.openSession();
		IndiaState indiaState = null;
		indiaState = session.get(IndiaState.class, (Integer) searchParams.getRequestMap().get(STATE_ID));
		session.close();
		return indiaState;
	}

}
