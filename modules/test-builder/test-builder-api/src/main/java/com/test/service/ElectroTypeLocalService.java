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

package com.test.service;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.test.model.ElectroType;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for ElectroType. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ElectroTypeLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ElectroTypeLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.test.service.impl.ElectroTypeLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the electro type local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ElectroTypeLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the electro type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ElectroTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param electroType the electro type
	 * @return the electro type that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ElectroType addElectroType(ElectroType electroType);

	public void addEmployeeElectroType(
		long employeeId, ElectroType electroType);

	public void addEmployeeElectroType(long employeeId, long ElectroTypeId);

	public void addEmployeeElectroTypes(
		long employeeId, List<ElectroType> electroTypes);

	public void addEmployeeElectroTypes(long employeeId, long[] ElectroTypeIds);

	public void clearEmployeeElectroTypes(long employeeId);

	/**
	 * Creates a new electro type with the primary key. Does not add the electro type to the database.
	 *
	 * @param ElectroTypeId the primary key for the new electro type
	 * @return the new electro type
	 */
	@Transactional(enabled = false)
	public ElectroType createElectroType(long ElectroTypeId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the electro type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ElectroTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param electroType the electro type
	 * @return the electro type that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public ElectroType deleteElectroType(ElectroType electroType);

	/**
	 * Deletes the electro type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ElectroTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ElectroTypeId the primary key of the electro type
	 * @return the electro type that was removed
	 * @throws PortalException if a electro type with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public ElectroType deleteElectroType(long ElectroTypeId)
		throws PortalException;

	public void deleteEmployeeElectroType(
		long employeeId, ElectroType electroType);

	public void deleteEmployeeElectroType(long employeeId, long ElectroTypeId);

	public void deleteEmployeeElectroTypes(
		long employeeId, List<ElectroType> electroTypes);

	public void deleteEmployeeElectroTypes(
		long employeeId, long[] ElectroTypeIds);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.test.model.impl.ElectroTypeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.test.model.impl.ElectroTypeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ElectroType fetchElectroType(long ElectroTypeId);

	/**
	 * Returns the electro type with the matching UUID and company.
	 *
	 * @param uuid the electro type's UUID
	 * @param companyId the primary key of the company
	 * @return the matching electro type, or <code>null</code> if a matching electro type could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ElectroType fetchElectroTypeByUuidAndCompanyId(
		String uuid, long companyId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the electro type with the primary key.
	 *
	 * @param ElectroTypeId the primary key of the electro type
	 * @return the electro type
	 * @throws PortalException if a electro type with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ElectroType getElectroType(long ElectroTypeId)
		throws PortalException;

	/**
	 * Returns the electro type with the matching UUID and company.
	 *
	 * @param uuid the electro type's UUID
	 * @param companyId the primary key of the company
	 * @return the matching electro type
	 * @throws PortalException if a matching electro type could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ElectroType getElectroTypeByUuidAndCompanyId(
			String uuid, long companyId)
		throws PortalException;

	/**
	 * Returns a range of all the electro types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.test.model.impl.ElectroTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of electro types
	 * @param end the upper bound of the range of electro types (not inclusive)
	 * @return the range of electro types
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ElectroType> getElectroTypes(int start, int end);

	/**
	 * Returns the number of electro types.
	 *
	 * @return the number of electro types
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getElectroTypesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ElectroType> getEmployeeElectroTypes(long employeeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ElectroType> getEmployeeElectroTypes(
		long employeeId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ElectroType> getEmployeeElectroTypes(
		long employeeId, int start, int end,
		OrderByComparator<ElectroType> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEmployeeElectroTypesCount(long employeeId);

	/**
	 * Returns the employeeIds of the employees associated with the electro type.
	 *
	 * @param ElectroTypeId the ElectroTypeId of the electro type
	 * @return long[] the employeeIds of employees associated with the electro type
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getEmployeePrimaryKeys(long ElectroTypeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasEmployeeElectroType(long employeeId, long ElectroTypeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasEmployeeElectroTypes(long employeeId);

	public void setEmployeeElectroTypes(long employeeId, long[] ElectroTypeIds);

	/**
	 * Updates the electro type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ElectroTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param electroType the electro type
	 * @return the electro type that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ElectroType updateElectroType(ElectroType electroType);

}