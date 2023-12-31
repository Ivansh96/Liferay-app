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

package com.test.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.test.service.http.PositionTypeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PositionTypeSoap implements Serializable {

	public static PositionTypeSoap toSoapModel(PositionType model) {
		PositionTypeSoap soapModel = new PositionTypeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPositionTypeId(model.getPositionTypeId());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static PositionTypeSoap[] toSoapModels(PositionType[] models) {
		PositionTypeSoap[] soapModels = new PositionTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PositionTypeSoap[][] toSoapModels(PositionType[][] models) {
		PositionTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PositionTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PositionTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PositionTypeSoap[] toSoapModels(List<PositionType> models) {
		List<PositionTypeSoap> soapModels = new ArrayList<PositionTypeSoap>(
			models.size());

		for (PositionType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PositionTypeSoap[soapModels.size()]);
	}

	public PositionTypeSoap() {
	}

	public long getPrimaryKey() {
		return _PositionTypeId;
	}

	public void setPrimaryKey(long pk) {
		setPositionTypeId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPositionTypeId() {
		return _PositionTypeId;
	}

	public void setPositionTypeId(long PositionTypeId) {
		_PositionTypeId = PositionTypeId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private String _uuid;
	private long _PositionTypeId;
	private String _name;

}