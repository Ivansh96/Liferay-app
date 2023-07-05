package com.test.service.persistence.impl;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.test.model.Purchase;
import com.test.model.impl.ElectronicsImpl;
import com.test.model.impl.EmployeeImpl;
import com.test.model.impl.PurchaseImpl;
import com.test.service.persistence.PurchaseFinder;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = PurchaseFinder.class)
public class PurchaseFinderImpl extends PurchaseFinderBaseImpl implements PurchaseFinder {
	
	@Reference
	private CustomSQL customSQL;
	
	public List<Purchase> getPurchaseCount(long electroTypeId, long price, Date date) {
		
		Session session = null;
		
		try {
			
			session = openSession();
			String sql = customSQL.get(getClass(), "getElectronicsCount");
			
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Purchase", PurchaseImpl.class);
			
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(electroTypeId);
			queryPos.add(price);
			queryPos.add(date);
			
			return (List<Purchase>) sqlQuery.list();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			closeSession(session);
		}
		
		return null;
	}
}
