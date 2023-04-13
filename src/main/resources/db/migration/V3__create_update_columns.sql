ALTER TABLE profile_tbl ADD COLUMN create_datetime TIMESTAMP, ADD COLUMN update_datetime TIMESTAMP;

ALTER TABLE address_tbl ADD COLUMN create_datetime TIMESTAMP, ADD COLUMN update_datetime TIMESTAMP;


-- ROLLBACK SQL:
--ALTER TABLE profile_tbl DROP COLUMN create_datetime, DROP COLUMN update_datetime;
--ALTER TABLE address_tbl DROP COLUMN create_datetime, DROP COLUMN update_datetime;

