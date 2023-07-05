package com.test.service.persistence.impl;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.test.model.Employee;
import com.test.model.impl.EmployeeImpl;
import com.test.service.persistence.EmployeeFinder;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = EmployeeFinder.class)
public class EmployeeFinderImpl extends EmployeeFinderBaseImpl implements EmployeeFinder {
	
	@Reference
	private CustomSQL customSQL;
	
	public List<Employee> getEmployeeByPosition(long positionTypeId) {
		
		Session session = null;
		
		try {
			
			session = openSession();
			String sql = customSQL.get(getClass(), "getEmployeeResults");
			
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Employee", EmployeeImpl.class);
			
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(positionTypeId);
			
			return (List<Employee>) sqlQuery.list();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			closeSession(session);
			
		}
		
		return null;
	}

}
