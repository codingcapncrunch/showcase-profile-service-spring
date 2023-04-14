CREATE TABLE city_state_tbl (

                                id int,
                                city varchar(60),
                                state_short varchar(10),
                                state_full varchar(60),
                                county varchar(60),
                                CONSTRAINT PK_city_state PRIMARY KEY (id)

);

CREATE TABLE state_zipcode_tbl (

                                   zip_code int,
                                   district_name varchar(60),
                                   state_short varchar(10),
                                   CONSTRAINT PK_state_zipcode PRIMARY KEY (zip_code)

);

-- ROLLBACK SQL:

--drop table city_state_tbl;
--drop table state_zipcode_tbl;