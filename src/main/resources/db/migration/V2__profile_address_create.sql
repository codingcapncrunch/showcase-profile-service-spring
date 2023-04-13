CREATE TABLE profile_tbl (

                         id varchar(40) NOT NULL,
                         first_name varchar(40),
                         middle_name varchar(40),
                         last_name varchar(40),
                         email varchar(40),
                         CONSTRAINT PK_PROFILE PRIMARY KEY (id)

);

CREATE TABLE address_tbl (

                         id int NOT NULL AUTO_INCREMENT,
                         type varchar(40),
                         line_one varchar(40),
                         line_two varchar(40),
                         city varchar(40),
                         state varchar(40),
                         zip_code int,
                         CONSTRAINT PK_ADDRESS PRIMARY KEY (id)

);

ALTER TABLE address_tbl AUTO_INCREMENT = 1000;

CREATE TABLE profile_address_tbl (

                         profile_id varchar(40) NOT NULL,
                         address_id int NOT NULL,
                         CONSTRAINT pk_profile_address PRIMARY KEY (profile_id, address_id),
                         CONSTRAINT fk_profile_id FOREIGN KEY (profile_id) REFERENCES profile_tbl(id),
                         CONSTRAINT fk_address_id FOREIGN KEY (address_id) REFERENCES address_tbl(id)

);



-- ROLLBACK SQL:

-- drop table profile_address_tbl;
-- drop table address_tbl;
-- drop table profile_tbl;