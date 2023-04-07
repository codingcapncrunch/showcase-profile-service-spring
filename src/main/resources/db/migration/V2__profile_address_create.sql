CREATE TABLE PROFILE_TBL (

                         id varchar(40) NOT NULL,
                         firstname varchar(40) NOT NULL,
                         middlename varchar(40),
                         lastname varchar(40) NOT NULL,
                         email varchar(40) NOT NULL,
                         CONSTRAINT PK_PROFILE PRIMARY KEY (id)

);

CREATE TABLE ADDRESS_TBL (

                         id int NOT NULL AUTO_INCREMENT,
                         type varchar(40) NOT NULL,
                         lineone varchar(40) NOT NULL,
                         linetwo varchar(40),
                         city varchar(40) NOT NULL,
                         state varchar(40) NOT NULL,
                         zipcode int NOT NULL,
                         CONSTRAINT PK_ADDRESS PRIMARY KEY (id)

);

ALTER TABLE ADDRESS_TBL AUTO_INCREMENT = 1000;

CREATE TABLE PROFILE_ADDRESS_TBL (

                         profile_id varchar(40) NOT NULL,
                         address_id int NOT NULL,
                         CONSTRAINT PK_PROFILE_ADDRESS PRIMARY KEY (profile_id, address_id),
                         CONSTRAINT FK_PROFILE_ID FOREIGN KEY (profile_id) REFERENCES PROFILE_TBL(id),
                         CONSTRAINT FK_ADDRESS_ID FOREIGN KEY (address_id) REFERENCES ADDRESS_TBL(id)

);

-- ROLLBACK SQL:

-- drop table profile_address_tbl;
-- drop table address_tbl;
-- drop table profile_tbl;