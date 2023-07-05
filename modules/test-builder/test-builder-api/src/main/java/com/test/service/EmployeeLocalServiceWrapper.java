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
 * Provides a wrapper for {@link EmployeeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EmployeeLocalService
 * @generated
 */
public class EmployeeLocalServiceWrapper
	implements EmployeeLocalService, ServiceWrapper<EmployeeLocalService> {

	public EmployeeLocalServiceWrapper(
		EmployeeLocalService employeeLocalService) {

		_employeeLocalService = employeeLocalService;
	}

	@Override
	public void addElectroTypeEmployee(
		long ElectroTypeId, com.test.model.Employee employee) {

		_employeeLocalService.addElectroTypeEmployee(ElectroTypeId, employee);
	}

	@Override
	public void addElectroTypeEmployee(long ElectroTypeId, long employeeId) {
		_employeeLocalService.addElectroTypeEmployee(ElectroTypeId, employeeId);
	}

	@Override
	public void addElectroTypeEmployees(
		long ElectroTypeId, java.util.List<com.test.model.Employee> employees) {

		_employeeLocalService.addElectroTypeEmployees(ElectroTypeId, employees);
	}

	@Override
	public void addElectroTypeEmployees(
		long ElectroTypeId, long[] employeeIds) {

		_employeeLocalService.addElectroTypeEmployees(
			ElectroTypeId, employeeIds);
	}

	/**
	 * Adds the employee to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employee the employee
	 * @return the employee that was added
	 */
	@Override
	public com.test.model.Employee addEmployee(
		com.test.model.Employee employee) {

		return _employeeLocalService.addEmployee(employee);
	}

	@Override
	public com.test.model.Employee addLiferayEmployee(
		String firstname, String lastname, String patronymic,
		java.util.Date birthdate, boolean gender, long electroTypeId,
		long positionTypeId) {

		return _employeeLocalService.addLiferayEmployee(
			firstname, lastname, patronymic, birthdate, gender, electroTypeId,
			positionTypeId);
	}

	@Override
	public void clearElectroTypeEmployees(long ElectroTypeId) {
		_employeeLocalService.clearElectroTypeEmployees(ElectroTypeId);
	}

	/**
	 * Creates a new employee with the primary key. Does not add the employee to the database.
	 *
	 * @param employeeId the primary key for the new employee
	 * @return the new employee
	 */
	@Override
	public com.test.model.Employee createEmployee(long employeeId) {
		return _employeeLocalService.createEmployee(employeeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public void deleteElectroTypeEmployee(
		long ElectroTypeId, com.test.model.Employee employee) {

		_employeeLocalService.deleteElectroTypeEmployee(
			ElectroTypeId, employee);
	}

	@Override
	public void deleteElectroTypeEmployee(long ElectroTypeId, long employeeId) {
		_employeeLocalService.deleteElectroTypeEmployee(
			ElectroTypeId, employeeId);
	}

	@Override
	public void deleteElectroTypeEmployees(
		long ElectroTypeId, java.util.List<com.test.model.Employee> employees) {

		_employeeLocalService.deleteElectroTypeEmployees(
			ElectroTypeId, employees);
	}

	@Override
	public void deleteElectroTypeEmployees(
		long ElectroTypeId, long[] employeeIds) {

		_employeeLocalService.deleteElectroTypeEmployees(
			ElectroTypeId, employeeIds);
	}

	/**
	 * Deletes the employee from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employee the employee
	 * @return the employee that was removed
	 */
	@Override
	public com.test.model.Employee deleteEmployee(
		com.test.model.Employee employee) {

		return _employeeLocalService.deleteEmployee(employee);
	}

	/**
	 * Deletes the employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employeeId the primary key of the employee
	 * @return the employee that was removed
	 * @throws PortalException if a employee with the primary key could not be found
	 */
	@Override
	public com.test.model.Employee deleteEmployee(long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.deleteEmployee(employeeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employeeLocalService.dynamicQuery();
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

		return _employeeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.test.model.impl.EmployeeModelImpl</code>.
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

		return _employeeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.test.model.impl.EmployeeModelImpl</code>.
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

		return _employeeLocalService.dynamicQuery(
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

		return _employeeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _employeeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.test.model.Employee fetchEmployee(long employeeId) {
		return _employeeLocalService.fetchEmployee(employeeId);
	}

	/**
	 * Returns the employee with the matching UUID and company.
	 *
	 * @param uuid the employee's UUID
	 * @param companyId the primary key of the company
	 * @return the matching employee, or <code>null</code> if a matching employee could not be found
	 */
	@Override
	public com.test.model.Employee fetchEmployeeByUuidAndCompanyId(
		String uuid, long companyId) {

		return _employeeLocalService.fetchEmployeeByUuidAndCompanyId(
			uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _employeeLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.test.model.Employee> getElectroTypeEmployees(
		long ElectroTypeId) {

		return _employeeLocalService.getElectroTypeEmployees(ElectroTypeId);
	}

	@Override
	public java.util.List<com.test.model.Employee> getElectroTypeEmployees(
		long ElectroTypeId, int start, int end) {

		return _employeeLocalService.getElectroTypeEmployees(
			ElectroTypeId, start, end);
	}

	@Override
	public java.util.List<com.test.model.Employee> getElectroTypeEmployees(
		long ElectroTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.test.model.Employee> orderByComparator) {

		return _employeeLocalService.getElectroTypeEmployees(
			ElectroTypeId, start, end, orderByComparator);
	}

	@Override
	public int getElectroTypeEmployeesCount(long ElectroTypeId) {
		return _employeeLocalService.getElectroTypeEmployeesCount(
			ElectroTypeId);
	}

	/**
	 * Returns the ElectroTypeIds of the electro types associated with the employee.
	 *
	 * @param employeeId the employeeId of the employee
	 * @return long[] the ElectroTypeIds of electro types associated with the employee
	 */
	@Override
	public long[] getElectroTypePrimaryKeys(long employeeId) {
		return _employeeLocalService.getElectroTypePrimaryKeys(employeeId);
	}

	/**
	 * Returns the employee with the primary key.
	 *
	 * @param employeeId the primary key of the employee
	 * @return the employee
	 * @throws PortalException if a employee with the primary key could not be found
	 */
	@Override
	public com.test.model.Employee getEmployee(long employeeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.getEmployee(employeeId);
	}

	@Override
	public java.util.List<com.test.model.Employee> getEmployeeByPosition(
		long positionTypeId) {

		return _employeeLocalService.getEmployeeByPosition(positionTypeId);
	}

	/**
	 * Returns the employee with the matching UUID and company.
	 *
	 * @param uuid the employee's UUID
	 * @param companyId the primary key of the company
	 * @return the matching employee
	 * @throws PortalException if a matching employee could not be found
	 */
	@Override
	public com.test.model.Employee getEmployeeByUuidAndCompanyId(
			String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.getEmployeeByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of all the employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.test.model.impl.EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of employees
	 * @param end the upper bound of the range of employees (not inclusive)
	 * @return the range of employees
	 */
	@Override
	public java.util.List<com.test.model.Employee> getEmployees(
		int start, int end) {

		return _employeeLocalService.getEmployees(start, end);
	}

	/**
	 * Returns the number of employees.
	 *
	 * @return the number of employees
	 */
	@Override
	public int getEmployeesCount() {
		return _employeeLocalService.getEmployeesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _employeeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _employeeLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean hasElectroTypeEmployee(long ElectroTypeId, long employeeId) {
		return _employeeLocalService.hasElectroTypeEmployee(
			ElectroTypeId, employeeId);
	}

	@Override
	public boolean hasElectroTypeEmployees(long ElectroTypeId) {
		return _employeeLocalService.hasElectroTypeEmployees(ElectroTypeId);
	}

	@Override
	public void setElectroTypeEmployees(
		long ElectroTypeId, long[] employeeIds) {

		_employeeLocalService.setElectroTypeEmployees(
			ElectroTypeId, employeeIds);
	}

	/**
	 * Updates the employee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param employee the employee
	 * @return the employee that was updated
	 */
	@Override
	public com.test.model.Employee updateEmployee(
		com.test.model.Employee employee) {

		return _employeeLocalService.updateEmployee(employee);
	}

	@Override
	public EmployeeLocalService getWrappedService() {
		return _employeeLocalService;
	}

	@Override
	public void setWrappedService(EmployeeLocalService employeeLocalService) {
		_employeeLocalService = employeeLocalService;
	}

	private EmployeeLocalService _employeeLocalService;

}