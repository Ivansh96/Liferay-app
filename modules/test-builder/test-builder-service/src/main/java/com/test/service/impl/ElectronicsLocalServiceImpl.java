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
import com.test.model.Electronics;
import com.test.service.base.ElectronicsLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.test.model.Electronics",
	service = AopService.class
)
public class ElectronicsLocalServiceImpl
	extends ElectronicsLocalServiceBaseImpl {
	
	
	public List<Electronics> getElectronicsByTypeId(long electroTypeId) {
		return electronicsFinder.getElectronicsByTypeId(electroTypeId);
	}
	
	public List<Electronics> getElectronicsByPurchaseType(long purchaseTypeId) {
		return electronicsFinder.getElectronicsByPurchaseType(purchaseTypeId);
	}
	
	public List<Electronics> getElectronicsByEmployeeId(long employeeId) {
		return electronicsFinder.getElectronicsByEmployeeId(employeeId);
	}
	public List<Electronics> getElectronicsByCount() {
		return electronicsFinder.getElectronicsByCount();
	}
}