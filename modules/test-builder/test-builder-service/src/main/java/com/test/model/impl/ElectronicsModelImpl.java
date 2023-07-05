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

package com.test.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import com.test.model.Electronics;
import com.test.model.ElectronicsModel;
import com.test.model.ElectronicsSoap;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Electronics service. Represents a row in the &quot;test_Electronics&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ElectronicsModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ElectronicsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElectronicsImpl
 * @generated
 */
@JSON(strict = true)
public class ElectronicsModelImpl
	extends BaseModelImpl<Electronics> implements ElectronicsModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a electronics model instance should use the <code>Electronics</code> interface instead.
	 */
	public static final String TABLE_NAME = "test_Electronics";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"electronicsId", Types.BIGINT},
		{"name", Types.VARCHAR}, {"price", Types.BIGINT},
		{"count", Types.INTEGER}, {"inStock", Types.BOOLEAN},
		{"archive", Types.BOOLEAN}, {"description", Types.VARCHAR},
		{"ElectroTypeId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("electronicsId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("price", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("count", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("inStock", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("archive", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("ElectroTypeId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table test_Electronics (uuid_ VARCHAR(75) null,electronicsId LONG not null primary key,name VARCHAR(75) null,price LONG,count INTEGER,inStock BOOLEAN,archive BOOLEAN,description VARCHAR(75) null,ElectroTypeId LONG)";

	public static final String TABLE_SQL_DROP = "drop table test_Electronics";

	public static final String ORDER_BY_JPQL =
		" ORDER BY electronics.electronicsId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY test_Electronics.electronicsId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ELECTRONICSID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static Electronics toModel(ElectronicsSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Electronics model = new ElectronicsImpl();

		model.setUuid(soapModel.getUuid());
		model.setElectronicsId(soapModel.getElectronicsId());
		model.setName(soapModel.getName());
		model.setPrice(soapModel.getPrice());
		model.setCount(soapModel.getCount());
		model.setInStock(soapModel.isInStock());
		model.setArchive(soapModel.isArchive());
		model.setDescription(soapModel.getDescription());
		model.setElectroTypeId(soapModel.getElectroTypeId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<Electronics> toModels(ElectronicsSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Electronics> models = new ArrayList<Electronics>(
			soapModels.length);

		for (ElectronicsSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public ElectronicsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _electronicsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setElectronicsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _electronicsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Electronics.class;
	}

	@Override
	public String getModelClassName() {
		return Electronics.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Electronics, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Electronics, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Electronics, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((Electronics)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Electronics, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Electronics, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Electronics)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Electronics, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Electronics, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Electronics, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Electronics, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Electronics, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Electronics, Object>>();
		Map<String, BiConsumer<Electronics, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Electronics, ?>>();

		attributeGetterFunctions.put("uuid", Electronics::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Electronics, String>)Electronics::setUuid);
		attributeGetterFunctions.put(
			"electronicsId", Electronics::getElectronicsId);
		attributeSetterBiConsumers.put(
			"electronicsId",
			(BiConsumer<Electronics, Long>)Electronics::setElectronicsId);
		attributeGetterFunctions.put("name", Electronics::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<Electronics, String>)Electronics::setName);
		attributeGetterFunctions.put("price", Electronics::getPrice);
		attributeSetterBiConsumers.put(
			"price", (BiConsumer<Electronics, Long>)Electronics::setPrice);
		attributeGetterFunctions.put("count", Electronics::getCount);
		attributeSetterBiConsumers.put(
			"count", (BiConsumer<Electronics, Integer>)Electronics::setCount);
		attributeGetterFunctions.put("inStock", Electronics::getInStock);
		attributeSetterBiConsumers.put(
			"inStock",
			(BiConsumer<Electronics, Boolean>)Electronics::setInStock);
		attributeGetterFunctions.put("archive", Electronics::getArchive);
		attributeSetterBiConsumers.put(
			"archive",
			(BiConsumer<Electronics, Boolean>)Electronics::setArchive);
		attributeGetterFunctions.put(
			"description", Electronics::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<Electronics, String>)Electronics::setDescription);
		attributeGetterFunctions.put(
			"ElectroTypeId", Electronics::getElectroTypeId);
		attributeSetterBiConsumers.put(
			"ElectroTypeId",
			(BiConsumer<Electronics, Long>)Electronics::setElectroTypeId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getElectronicsId() {
		return _electronicsId;
	}

	@Override
	public void setElectronicsId(long electronicsId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_electronicsId = electronicsId;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_name = name;
	}

	@JSON
	@Override
	public long getPrice() {
		return _price;
	}

	@Override
	public void setPrice(long price) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_price = price;
	}

	@JSON
	@Override
	public int getCount() {
		return _count;
	}

	@Override
	public void setCount(int count) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_count = count;
	}

	@JSON
	@Override
	public boolean getInStock() {
		return _inStock;
	}

	@JSON
	@Override
	public boolean isInStock() {
		return _inStock;
	}

	@Override
	public void setInStock(boolean inStock) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_inStock = inStock;
	}

	@JSON
	@Override
	public boolean getArchive() {
		return _archive;
	}

	@JSON
	@Override
	public boolean isArchive() {
		return _archive;
	}

	@Override
	public void setArchive(boolean archive) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_archive = archive;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_description = description;
	}

	@JSON
	@Override
	public long getElectroTypeId() {
		return _ElectroTypeId;
	}

	@Override
	public void setElectroTypeId(long ElectroTypeId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_ElectroTypeId = ElectroTypeId;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Electronics.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Electronics toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Electronics>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ElectronicsImpl electronicsImpl = new ElectronicsImpl();

		electronicsImpl.setUuid(getUuid());
		electronicsImpl.setElectronicsId(getElectronicsId());
		electronicsImpl.setName(getName());
		electronicsImpl.setPrice(getPrice());
		electronicsImpl.setCount(getCount());
		electronicsImpl.setInStock(isInStock());
		electronicsImpl.setArchive(isArchive());
		electronicsImpl.setDescription(getDescription());
		electronicsImpl.setElectroTypeId(getElectroTypeId());

		electronicsImpl.resetOriginalValues();

		return electronicsImpl;
	}

	@Override
	public int compareTo(Electronics electronics) {
		long primaryKey = electronics.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Electronics)) {
			return false;
		}

		Electronics electronics = (Electronics)object;

		long primaryKey = electronics.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Electronics> toCacheModel() {
		ElectronicsCacheModel electronicsCacheModel =
			new ElectronicsCacheModel();

		electronicsCacheModel.uuid = getUuid();

		String uuid = electronicsCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			electronicsCacheModel.uuid = null;
		}

		electronicsCacheModel.electronicsId = getElectronicsId();

		electronicsCacheModel.name = getName();

		String name = electronicsCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			electronicsCacheModel.name = null;
		}

		electronicsCacheModel.price = getPrice();

		electronicsCacheModel.count = getCount();

		electronicsCacheModel.inStock = isInStock();

		electronicsCacheModel.archive = isArchive();

		electronicsCacheModel.description = getDescription();

		String description = electronicsCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			electronicsCacheModel.description = null;
		}

		electronicsCacheModel.ElectroTypeId = getElectroTypeId();

		return electronicsCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Electronics, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Electronics, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Electronics, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Electronics)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Electronics, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Electronics, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Electronics, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Electronics)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Electronics>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Electronics.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _electronicsId;
	private String _name;
	private long _price;
	private int _count;
	private boolean _inStock;
	private boolean _archive;
	private String _description;
	private long _ElectroTypeId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Electronics, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Electronics)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("electronicsId", _electronicsId);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("price", _price);
		_columnOriginalValues.put("count", _count);
		_columnOriginalValues.put("inStock", _inStock);
		_columnOriginalValues.put("archive", _archive);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("ElectroTypeId", _ElectroTypeId);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("electronicsId", 2L);

		columnBitmasks.put("name", 4L);

		columnBitmasks.put("price", 8L);

		columnBitmasks.put("count", 16L);

		columnBitmasks.put("inStock", 32L);

		columnBitmasks.put("archive", 64L);

		columnBitmasks.put("description", 128L);

		columnBitmasks.put("ElectroTypeId", 256L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Electronics _escapedModel;

}