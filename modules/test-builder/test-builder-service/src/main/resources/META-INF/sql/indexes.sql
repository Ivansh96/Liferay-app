create index IX_41AFACB5 on test_ElectroEmployee (companyId);
create index IX_393DA1B0 on test_ElectroEmployee (employeeId);

create index IX_60B2C2D3 on test_ElectroType (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_9691D49 on test_Electronics (price);
create index IX_17072D44 on test_Electronics (uuid_[$COLUMN_LENGTH:75$]);

create index IX_1E312095 on test_Employee (uuid_[$COLUMN_LENGTH:75$], companyId);

create index IX_5D7A2A7E on test_PositionType (uuid_[$COLUMN_LENGTH:75$]);

create index IX_9909B4C0 on test_Purchase (uuid_[$COLUMN_LENGTH:75$]);

create index IX_44BBDA6 on test_PurchaseType (uuid_[$COLUMN_LENGTH:75$]);