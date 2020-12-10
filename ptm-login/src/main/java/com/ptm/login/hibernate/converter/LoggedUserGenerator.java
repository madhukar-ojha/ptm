package com.ptm.login.hibernate.converter;

import org.hibernate.Session;
import org.hibernate.tuple.ValueGenerator;

import com.ptm.login.entity.Employee;

public class LoggedUserGenerator implements ValueGenerator<Employee> {
	@Override
	public Employee generateValue(Session session, Object owner) {
		return session.load(Employee.class, CurrentUser.INSTANCE.get());
	}
}
