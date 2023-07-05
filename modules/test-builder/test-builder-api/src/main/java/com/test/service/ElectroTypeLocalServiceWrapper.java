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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ElectroTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ElectroTypeLocalService
 * @generated
 */
public class ElectroTypeLocalServiceWrapper
	implements ElectroTypeLocalService,
			   ServiceWrapper<ElectroTypeLocalService> {

	public ElectroTypeLocalServiceWrapper(
		ElectroTypeLocalService electroTypeLocalService) {

		_electroTypeLocalService = electroTypeLocalService;
	}

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
	@Override
	public com.test.model.ElectroType addElectroType(
		com.test.model.ElectroType electroType) {

		return _electroTypeLocalService.addElectroType(electroType);
	}

	@Override
	public void addEmployeeElectroType(
		long employeeId, com.test.model.ElectroType electroType) {

		_electroTypeLocalService.addEmployeeElectroType(
			employeeId, electroType);
	}

	@Override
	public void addEmployeeElectroType(long employeeId, long ElectroTypeId) {
		_electroTypeLocalService.addEmployeeElectroType(
			employeeId, ElectroTypeId);
	}

	@Override
	public void addEmployeeElectroTypes(
		long employeeId,
		java.util.List<com.test.model.ElectroType> electroTypes) {

		_electroTypeLocalService.addEmployeeElectroTypes(
			employeeId, electroTypes);
	}

	@Override
	public void addEmployeeElectroTypes(
		long employeeId, long[] ElectroTypeIds) {

		_electroTypeLocalService.addEmployeeElectroTypes(
			employeeId, ElectroTypeIds);
	}

	@Override
	public void clearEmployeeElectroTypes(long employeeId) {
		_electroTypeLocalService.clearEmployeeElectroTypes(employeeId);
	}

	/**
	 * Creates a new electro type with the primary key. Does not add the electro type to the database.
	 *
	 * @param ElectroTypeId the primary key for the new electro type
	 * @return the new electro type
	 */
	@Override
	public com.test.model.ElectroType createElectroType(long ElectroTypeId) {
		return _electroTypeLocalService.createElectroType(ElectroTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _electroTypeLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.test.model.ElectroType deleteElectroType(
		com.test.model.ElectroType electroType) {

		return _electroTypeLocalService.deleteElectroType(electroType);
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
	@Override
	public com.test.model.ElectroType deleteElectroType(long ElectroTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _electroTypeLocalService.deleteElectroType(ElectroTypeId);
	}

	@Override
	public void deleteEmployeeElectroType(
		long employeeId, com.test.model.ElectroType electroType) {

		_electroTypeLocalService.deleteEmployeeElectroType(
			employeeId, electroType);
	}

	@Override
	public void deleteEmployeeElectroType(long employeeId, long ElectroTypeId) {
		_electroTypeLocalService.deleteEmployeeElectroType(
			employeeId, ElectroTypeId);
	}

	@Override
	public void deleteEmployeeElectroTypes(
		long employeeId,
		java.util.List<com.test.model.ElectroType> electroTypes) {

		_electroTypeLocalService.deleteEmployeeElectroTypes(
			employeeId, electroTypes);
	}

	@Override
	public void deleteEmployeeElectroTypes(
		long employeeId, long[] ElectroTypeIds) {

		_electroTypeLocalService.deleteEmployeeElectroTypes(
			employeeId, ElectroTypeIds);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _electroTypeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _electroTypeLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _electroTypeLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _electroTypeLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _electroTypeLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _electroTypeLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _electroTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.test.model.ElectroType fetchElectroType(long ElectroTypeId) {
		return _electroTypeLocalService.fetchElectroType(ElectroTypeId);
	}

	/**
	 * Returns the electro type with the matching UUID and company.
	 *
	 * @param uuid the electro type's UUID
	 * @param companyId the primary key of the company
	 * @return the matching electro type, or <code>null</code> if a matching electro type could not be found
	 */
	@Override
	public com.test.model.ElectroType fetchElectroTypeByUuidAndCompanyId(
		String uuid, long companyId) {

		return _electroTypeLocalService.fetchElectroTypeByUuidAndCompanyId(
			uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _electroTypeLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the electro type with the primary key.
	 *
	 * @param ElectroTypeId the primary key of the electro type
	 * @return the electro type
	 * @throws PortalException if a electro type with the primary key could not be found
	 */
	@Override
	public com.test.model.ElectroType getElectroType(long ElectroTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _electroTypeLocalService.getElectroType(ElectroTypeId);
	}

	/**
	 * Returns the electro type with the matching UUID and company.
	 *
	 * @param uuid the electro type's UUID
	 * @param companyId the primary key of the company
	 * @return the matching electro type
	 * @throws PortalException if a matching electro type could not be found
	 */
	@Override
	public com.test.model.ElectroType getElectroTypeByUuidAndCompanyId(
			String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _electroTypeLocalService.getElectroTypeByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.test.model.ElectroType> getElectroTypes(
		int start, int end) {

		return _electroTypeLocalService.getElectroTypes(start, end);
	}

	/**
	 * Returns the number of electro types.
	 *
	 * @return the number of electro types
	 */
	@Override
	public int getElectroTypesCount() {
		return _electroTypeLocalService.getElectroTypesCount();
	}

	@Override
	public java.util.List<com.test.model.ElectroType> getEmployeeElectroTypes(
		long employeeId) {

		return _electroTypeLocalService.getEmployeeElectroTypes(employeeId);
	}

	@Override
	public java.util.List<com.test.model.ElectroType> getEmployeeElectroTypes(
		long employeeId, int start, int end) {

		return _electroTypeLocalService.getEmployeeElectroTypes(
			employeeId, start, end);
	}

	@Override
	public java.util.List<com.test.model.ElectroType> getEmployeeElectroTypes(
		long employeeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.test.model.ElectroType> orderByComparator) {

		return _electroTypeLocalService.getEmployeeElectroTypes(
			employeeId, start, end, orderByComparator);
	}

	@Override
	public int getEmployeeElectroTypesCount(long employeeId) {
		return _electroTypeLocalService.getEmployeeElectroTypesCount(
			employeeId);
	}

	/**
	 * Returns the employeeIds of the employees associated with the electro type.
	 *
	 * @param ElectroTypeId the ElectroTypeId of the electro type
	 * @return long[] the employeeIds of employees associated with the electro type
	 */
	@Override
	public long[] getEmployeePrimaryKeys(long ElectroTypeId) {
		return _electroTypeLocalService.getEmployeePrimaryKeys(ElectroTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _electroTypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _electroTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _electroTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean hasEmployeeElectroType(long employeeId, long ElectroTypeId) {
		return _electroTypeLocalService.hasEmployeeElectroType(
			employeeId, ElectroTypeId);
	}

	@Override
	public boolean hasEmployeeElectroTypes(long employeeId) {
		return _electroTypeLocalService.hasEmployeeElectroTypes(employeeId);
	}

	@Override
	public void setEmployeeElectroTypes(
		long employeeId, long[] ElectroTypeIds) {

		_electroTypeLocalService.setEmployeeElectroTypes(
			employeeId, ElectroTypeIds);
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
	@Override
	public com.test.model.ElectroType updateElectroType(
		com.test.model.ElectroType electroType) {

		return _electroTypeLocalService.updateElectroType(electroType);
	}

	@Override
	public ElectroTypeLocalService getWrappedService() {
		return _electroTypeLocalService;
	}

	@Override
	public void setWrappedService(
		ElectroTypeLocalService electroTypeLocalService) {

		_electroTypeLocalService = electroTypeLocalService;
	}

	private ElectroTypeLocalService _electroTypeLocalService;

}