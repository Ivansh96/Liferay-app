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

package com.test.service.impl;

import com.liferay.portal.aop.AopService;
import com.test.model.Employee;
import com.test.service.base.EmployeeLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.test.model.Employee",
	service = AopService.class
)
public class EmployeeLocalServiceImpl extends EmployeeLocalServiceBaseImpl {
	
	public List<Employee> getEmployeeByPosition(long positionTypeId) {
		return employeeFinder.getEmployeeByPosition(positionTypeId);
	}
	
	public Employee addLiferayEmployee(String firstname, 
			                           String lastname, 
			                           String patronymic, 
			                           Date birthdate,
			                           boolean gender,
			                           long electroTypeId,
			                           long positionTypeId
			                          ) {
		
		long employeeId = counterLocalService.increment(Employee.class.getName());
		
		Employee employee = createEmployee(employeeId);
		
		employee.setFirstname(firstname);
		employee.setLastname(lastname);
		employee.setPatronymic(patronymic);
		employee.setBirthdate(birthdate);
		employee.setGender(gender);
		employee.setPositionTypeId(positionTypeId);
		employeeLocalService.addElectroTypeEmployee(electroTypeId, employeeId);
		
		return super.addEmployee(employee);
		
		
	}
}