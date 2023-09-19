CREATE TABLE contactus_tbl (

                                id varchar(40) NOT NULL,
                                message varchar(255),
                                created_datetime TIMESTAMP,
                                email_address varchar(42),
                                phone_number int,
                                phone_country_code int,
                                status varchar(25),
                                CONSTRAINT PK_contactus_tbl PRIMARY KEY (id)

);

-- ROLLBACK SQL:
--drop table contactus_tbl;