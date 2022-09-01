
----------------------------------
-- DATABASE ecommerce_system --
----------------------------------
CREATE DATABASE ecommerce_system DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE ecommerce_system;

----------------------------------
-- TABLE tbl_users --
----------------------------------
CREATE TABLE tbl_users (
	id INT(11) AUTO_INCREMENT,
	email VARCHAR(50) NOT NULL,
	username VARCHAR(50) NOT NULL,
	password VARCHAR(255) NOT NULL,
	created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(id),
	UNIQUE(username)
);

----------------------------------
-- TABLE tbl_roles --
----------------------------------
CREATE TABLE tbl_roles (
	id INT(11) AUTO_INCREMENT,
	name VARCHAR(255) NOT NULL,
    enabled BOOLEAN,
	created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	UNIQUE (name),
	PRIMARY KEY(id)
);


----------------------------------
-- TABLE tbl_user_roles --
----------------------------------
CREATE TABLE tbl_user_roles (
	user_id INT(11) NOT NULL,
	role_id INT(11) NOT NULL,
    PRIMARY KEY(user_id, role_id),
	CONSTRAINT pa_user_role_fk1 FOREIGN KEY (user_id) REFERENCES tbl_users(id),
	CONSTRAINT pa_user_role_fk2 FOREIGN KEY (role_id) REFERENCES tbl_roles(id)
);

----------------------------------
-- TABLE tbl_customer --
----------------------------------
CREATE TABLE tbl_customer (
	id INT(11) AUTO_INCREMENT,
	fullName VARCHAR(50),
	gender VARCHAR(50),
	dateOfBirth VARCHAR(255),
	address VARCHAR(255),
	user_id INT(11) NOT NULL,
	created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(id),
	CONSTRAINT tbl_customer_fk1 FOREIGN KEY (user_id) REFERENCES tbl_users(id)
);