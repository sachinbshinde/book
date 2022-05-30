//tables needs to be created

DROP TABLE IF EXISTS Theatre;
CREATE TABLE Theatre (
theatreid varchar(50) PRIMARY KEY,
theatrename varchar(50),
city varchar(50)
);

//similarly we need to create tables for all entity classes. With FK-PK relations