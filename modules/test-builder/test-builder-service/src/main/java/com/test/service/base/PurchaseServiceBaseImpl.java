/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.test.service.base;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import com.test.model.Purchase;
import com.test.service.PurchaseService;
import com.test.service.PurchaseServiceUtil;
import com.test.service.persistence.ElectroTypePersistence;
import com.test.service.persistence.ElectronicsFinder;
import com.test.service.persistence.ElectronicsPersistence;
import com.test.service.persistence.EmployeeFinder;
import com.test.service.persistence.EmployeePersistence;
import com.test.service.persistence.PositionTypePersistence;
import com.test.service.persistence.PurchaseFinder;
import com.test.service.persistence.PurchasePersistence;
import com.test.service.persistence.PurchaseTypePersistence;

import java.lang.reflect.Field;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the purchase remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.test.service.impl.PurchaseServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.test.service.impl.PurchaseServiceImpl
 * @generated
 */
public abstract class PurchaseServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, IdentifiableOSGiService, PurchaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>PurchaseService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>PurchaseServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
		_setServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			PurchaseService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		purchaseService = (PurchaseService)aopProxy;

		_setServiceUtilService(purchaseService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return PurchaseService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Purchase.class;
	}

	protected String getModelClassName() {
		return Purchase.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = purchasePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setServiceUtilService(PurchaseService purchaseService) {
		try {
			Field field = PurchaseServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, purchaseService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected ElectronicsPersistence electronicsPersistence;

	@Reference
	protected ElectronicsFinder electronicsFinder;

	@Reference
	protected ElectroTypePersistence electroTypePersistence;

	@Reference
	protected EmployeePersistence employeePersistence;

	@Reference
	protected EmployeeFinder employeeFinder;

	@Reference
	protected PositionTypePersistence positionTypePersistence;

	@Reference
	protected com.test.service.PurchaseLocalService purchaseLocalService;

	protected PurchaseService purchaseService;

	@Reference
	protected PurchasePersistence purchasePersistence;

	@Reference
	protected PurchaseFinder purchaseFinder;

	@Reference
	protected PurchaseTypePersistence purchaseTypePersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

}