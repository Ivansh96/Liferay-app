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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.test.model.ElectroType;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ElectroType. This utility wraps
 * <code>com.test.service.impl.ElectroTypeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ElectroTypeLocalService
 * @generated
 */
public class ElectroTypeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.test.service.impl.ElectroTypeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
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
	public static ElectroType addElectroType(ElectroType electroType) {
		return getService().addElectroType(electroType);
	}

	public static void addEmployeeElectroType(
		long employeeId, ElectroType electroType) {

		getService().addEmployeeElectroType(employeeId, electroType);
	}

	public static void addEmployeeElectroType(
		long employeeId, long ElectroTypeId) {

		getService().addEmployeeElectroType(employeeId, ElectroTypeId);
	}

	public static void addEmployeeElectroTypes(
		long employeeId, List<ElectroType> electroTypes) {

		getService().addEmployeeElectroTypes(employeeId, electroTypes);
	}

	public static void addEmployeeElectroTypes(
		long employeeId, long[] ElectroTypeIds) {

		getService().addEmployeeElectroTypes(employeeId, ElectroTypeIds);
	}

	public static void clearEmployeeElectroTypes(long employeeId) {
		getService().clearEmployeeElectroTypes(employeeId);
	}

	/**
	 * Creates a new electro type with the primary key. Does not add the electro type to the database.
	 *
	 * @param ElectroTypeId the primary key for the new electro type
	 * @return the new electro type
	 */
	public static ElectroType createElectroType(long ElectroTypeId) {
		return getService().createElectroType(ElectroTypeId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

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
	public static ElectroType deleteElectroType(ElectroType electroType) {
		return getService().deleteElectroType(electroType);
	}

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
	public static ElectroType deleteElectroType(long ElectroTypeId)
		throws PortalException {

		return getService().deleteElectroType(ElectroTypeId);
	}

	public static void deleteEmployeeElectroType(
		long employeeId, ElectroType electroType) {

		getService().deleteEmployeeElectroType(employeeId, electroType);
	}

	public static void deleteEmployeeElectroType(
		long employeeId, long ElectroTypeId) {

		getService().deleteEmployeeElectroType(employeeId, ElectroTypeId);
	}

	public static void deleteEmployeeElectroTypes(
		long employeeId, List<ElectroType> electroTypes) {

		getService().deleteEmployeeElectroTypes(employeeId, electroTypes);
	}

	public static void deleteEmployeeElectroTypes(
		long employeeId, long[] ElectroTypeIds) {

		getService().deleteEmployeeElectroTypes(employeeId, ElectroTypeIds);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ElectroType fetchElectroType(long ElectroTypeId) {
		return getService().fetchElectroType(ElectroTypeId);
	}

	/**
	 * Returns the electro type with the matching UUID and company.
	 *
	 * @param uuid the electro type's UUID
	 * @param companyId the primary key of the company
	 * @return the matching electro type, or <code>null</code> if a matching electro type could not be found
	 */
	public static ElectroType fetchElectroTypeByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().fetchElectroTypeByUuidAndCompanyId(uuid, companyId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the electro type with the primary key.
	 *
	 * @param ElectroTypeId the primary key of the electro type
	 * @return the electro type
	 * @throws PortalException if a electro type with the primary key could not be found
	 */
	public static ElectroType getElectroType(long ElectroTypeId)
		throws PortalException {

		return getService().getElectroType(ElectroTypeId);
	}

	/**
	 * Returns the electro type with the matching UUID and company.
	 *
	 * @param uuid the electro type's UUID
	 * @param companyId the primary key of the company
	 * @return the matching electro type
	 * @throws PortalException if a matching electro type could not be found
	 */
	public static ElectroType getElectroTypeByUuidAndCompanyId(
			String uuid, long companyId)
		throws PortalException {

		return getService().getElectroTypeByUuidAndCompanyId(uuid, companyId);
	}

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
	public static List<ElectroType> getElectroTypes(int start, int end) {
		return getService().getElectroTypes(start, end);
	}

	/**
	 * Returns the number of electro types.
	 *
	 * @return the number of electro types
	 */
	public static int getElectroTypesCount() {
		return getService().getElectroTypesCount();
	}

	public static List<ElectroType> getEmployeeElectroTypes(long employeeId) {
		return getService().getEmployeeElectroTypes(employeeId);
	}

	public static List<ElectroType> getEmployeeElectroTypes(
		long employeeId, int start, int end) {

		return getService().getEmployeeElectroTypes(employeeId, start, end);
	}

	public static List<ElectroType> getEmployeeElectroTypes(
		long employeeId, int start, int end,
		OrderByComparator<ElectroType> orderByComparator) {

		return getService().getEmployeeElectroTypes(
			employeeId, start, end, orderByComparator);
	}

	public static int getEmployeeElectroTypesCount(long employeeId) {
		return getService().getEmployeeElectroTypesCount(employeeId);
	}

	/**
	 * Returns the employeeIds of the employees associated with the electro type.
	 *
	 * @param ElectroTypeId the ElectroTypeId of the electro type
	 * @return long[] the employeeIds of employees associated with the electro type
	 */
	public static long[] getEmployeePrimaryKeys(long ElectroTypeId) {
		return getService().getEmployeePrimaryKeys(ElectroTypeId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static boolean hasEmployeeElectroType(
		long employeeId, long ElectroTypeId) {

		return getService().hasEmployeeElectroType(employeeId, ElectroTypeId);
	}

	public static boolean hasEmployeeElectroTypes(long employeeId) {
		return getService().hasEmployeeElectroTypes(employeeId);
	}

	public static void setEmployeeElectroTypes(
		long employeeId, long[] ElectroTypeIds) {

		getService().setEmployeeElectroTypes(employeeId, ElectroTypeIds);
	}

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
	public static ElectroType updateElectroType(ElectroType electroType) {
		return getService().updateElectroType(electroType);
	}

	public static ElectroTypeLocalService getService() {
		return _service;
	}

	private static volatile ElectroTypeLocalService _service;

}