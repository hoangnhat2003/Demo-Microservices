
----------------------------------
-- DATABASE ecommerce_system --
----------------------------------
CREATE DATABASE IF NOT EXISTS ecommerce_system DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;

USE ecommerce_system;

----------------------------------
-- TABLE tbl_users --
----------------------------------
CREATE TABLE IF NOT EXISTS tbl_users (
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
CREATE TABLE IF NOT EXISTS tbl_roles (
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
CREATE TABLE IF NOT EXISTS tbl_user_roles (
	user_id INT(11) NOT NULL,
	role_id INT(11) NOT NULL,
    PRIMARY KEY(user_id, role_id),
	CONSTRAINT pa_user_role_fk1 FOREIGN KEY (user_id) REFERENCES tbl_users(id),
	CONSTRAINT pa_user_role_fk2 FOREIGN KEY (role_id) REFERENCES tbl_roles(id)
);

----------------------------------
-- TABLE tbl_customer --
----------------------------------
CREATE TABLE IF NOT EXISTS tbl_customer (
	id INT(11) AUTO_INCREMENT,
	fullName VARCHAR(50),
	gender VARCHAR(50),
	dateOfBirth VARCHAR(255),
	address VARCHAR(255),
	created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(id)
);

----------------------------------
-- TABLE tbl_category --
----------------------------------
CREATE TABLE IF NOT EXISTS tbl_category (
	id INT(11) AUTO_INCREMENT,
	name VARCHAR(255),
	description VARCHAR(255),
	created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(id)
);

----------------------------------
-- TABLE tbl_product --
----------------------------------
CREATE TABLE IF NOT EXISTS tbl_product (
	id INT(11) AUTO_INCREMENT,
	product_name VARCHAR(255),
	description VARCHAR(255),
	price DOUBLE,
	quantity_in_stock INTEGER,
	category_id INTEGER,
	created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(id),
	CONSTRAINT product_fk1 FOREIGN KEY (category_id) REFERENCES tbl_category(id)
);

----------------------------------
-- TABLE tbl_address --
----------------------------------
CREATE TABLE IF NOT EXISTS tbl_address (
	id INT(11) AUTO_INCREMENT,
	line VARCHAR(255),
	city VARCHAR(255),
	country VARCHAR(255),
	postcode VARCHAR(255),
	PRIMARY KEY(id)
);

----------------------------------
-- TABLE tbl_payment_details --
----------------------------------
CREATE TABLE IF NOT EXISTS tbl_payment_details (
	id INT(11) AUTO_INCREMENT,
	card_type VARCHAR(255),
	holder_name VARCHAR(255),
	card_number VARCHAR(255),
	cvv INTEGER,
	expire VARCHAR(255),
	PRIMARY KEY(id)
);

----------------------------------
-- TABLE tbl_order --
----------------------------------
CREATE TABLE IF NOT EXISTS tbl_order (
	id INT(11) AUTO_INCREMENT,
	customer_id INTEGER,
    status VARCHAR(255),
    product_id INTEGER,
    quantity INTEGER,
    amount INTEGER,
	shipping_address_id INTEGER,
	billing_address_id INTEGER,
	payment_detail_id INTEGER,
	created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(id)
);

----------------------------------
-- TABLE tbl_invoice --
----------------------------------
CREATE TABLE IF NOT EXISTS tbl_invoice (
	id INT(11) AUTO_INCREMENT,
    order_id INTEGER,
	customer_id INTEGER,
    product_id INTEGER,
    quantity INTEGER,
    product_price DOUBLE,
    payment_detail_id INTEGER,
    billing_address_id INTEGER,
    total_charge_amount DOUBLE,
	created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(id)
);
