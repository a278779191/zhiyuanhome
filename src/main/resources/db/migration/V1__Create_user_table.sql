CREATE TABLE USER (
   ID int NOT NULL AUTO_INCREMENT,
  ACCOUNT_ID varchar(100) ,
  NAME varchar(50) ,
  TOKEN char(36) ,
  GMT_CREATE bigint,
  GMT_MODIFIED bigint ,
  bio varchar(256),
  PRIMARY KEY (ID)
)