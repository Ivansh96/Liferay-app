create table test_ElectroEmployee (
	companyId LONG not null,
	ElectroTypeId LONG not null,
	employeeId LONG not null,
	primary key (ElectroTypeId, employeeId)
);

create table test_ElectroType (
	uuid_ VARCHAR(75) null,
	ElectroTypeId LONG not null primary key,
	name VARCHAR(75) null,
	companyId LONG
);

create table test_Electronics (
	uuid_ VARCHAR(75) null,
	electronicsId LONG not null primary key,
	name VARCHAR(75) null,
	price LONG,
	count INTEGER,
	inStock BOOLEAN,
	archive BOOLEAN,
	description VARCHAR(75) null,
	ElectroTypeId LONG
);

create table test_Employee (
	uuid_ VARCHAR(75) null,
	employeeId LONG not null primary key,
	firstname VARCHAR(75) null,
	lastname VARCHAR(75) null,
	patronymic VARCHAR(75) null,
	birthdate DATE null,
	gender BOOLEAN,
	PositionTypeId LONG,
	companyId LONG
);

create table test_PositionType (
	uuid_ VARCHAR(75) null,
	PositionTypeId LONG not null primary key,
	name VARCHAR(75) null
);

create table test_Purchase (
	uuid_ VARCHAR(75) null,
	purchaseId LONG not null primary key,
	purchaseDate DATE null,
	employeeId LONG,
	electronicsId LONG,
	purchaseTypeId LONG
);

create table test_PurchaseType (
	uuid_ VARCHAR(75) null,
	purchaseTypeId LONG not null primary key,
	name VARCHAR(75) null
);