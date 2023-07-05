package com.test.service.persistence.impl;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.test.model.Electronics;
import com.test.model.impl.ElectronicsImpl;
import com.test.service.persistence.ElectronicsFinder;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = ElectronicsFinder.class)
public class ElectronicsFinderImpl extends ElectronicsFinderBaseImpl implements ElectronicsFinder {

	@Reference
	private CustomSQL customSQL;

	public List<Electronics> getElectronicsByTypeId(long electroTypeId) {

		Session session = null;

		try {

			session = openSession();
			String sql = customSQL.get(getClass(), "getTotalPrice");

			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Electronics", ElectronicsImpl.class);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(electroTypeId);

			return (List<Electronics>) sqlQuery.list();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			closeSession(session);
		}

		return null;
	}

	public List<Electronics> getElectronicsByPurchaseType(long purchaseTypeId) {

		Session session = null;

		try {

			session = openSession();
			String sql = customSQL.get(getClass(), "getByPurchase");

			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Electronics", ElectronicsImpl.class);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(purchaseTypeId);

			return (List<Electronics>) sqlQuery.list();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			closeSession(session);

		}

		return null;
	}

	public List<Electronics> getElectronicsByEmployeeId(long employeeId) {

		Session session = null;

		try {

			session = openSession();
			String sql = customSQL.get(getClass(), "getEmployeeElectronicsResults");

			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Electronics", ElectronicsImpl.class);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(employeeId);

			return (List<Electronics>) sqlQuery.list();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			closeSession(session);

		}

		return null;
	}

	public List<Electronics> getElectronicsByCount() {
		List<Electronics> elList = electronicsPersistence.findAll();
		List<Electronics> newList = new ArrayList<>();

		for (int i = 0; i < elList.size(); i++) {
			if (elList.get(i).getCount() > 0) {
				newList.add(elList.get(i));
			}
		}
		return newList;
	}
}
