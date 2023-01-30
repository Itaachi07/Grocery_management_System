-- created gms database
drop database if exists gms_db;
create database gms_db;

-- Use database
use gms_db;

-- Location Table
drop table if exists location;
create table location(city varchar(100),pincode int primary key,state varchar(100));

-- Customer's Table
drop table if exists customer;
create table customer(c_id int primary key AUTO_INCREMENT,c_fname varchar(50),c_lname varchar(50),c_email varchar(100) unique,c_mobile varchar(20) unique,c_password varchar(300),c_address varchar(200),c_pincode int,isDeleted boolean default false, FOREIGN KEY (c_pincode
) REFERENCES location(pincode));


-- Seller Table
drop table if exists seller;
create table seller(s_id int primary key AUTO_INCREMENT,s_name varchar(100),s_email varchar(100),s_mobile varchar(20),s_password varchar(300),s_pincode int,isDeleted boolean default false,FOREIGN KEY (s_pincode) REFERENCES location(pincode));

-- Category Table
drop table if exists category;
create table category(cat_id int primary key AUTO_INCREMENT,cat_name varchar(100),
cat_desc varchar(800),cat_image_path varchar(500));


-- Product's Table
drop table if exists product;
create table product(p_id int primary key AUTO_INCREMENT,cat_id int,s_id int,p_name varchar(100),p_price double,p_unit varchar(20),p_details varchar(800),p_image_path varchar(500),isDeleted boolean default false,FOREIGN KEY (s_id) REFERENCES seller(s_id),FOREIGN KEY (cat_id) REFERENCES category(cat_id));


-- Orders Table
drop table if exists orders;
create table orders(o_id int primary key AUTO_INCREMENT,c_id int,c_pincode int,o_date date,FOREIGN KEY (c_id) REFERENCES customer(c_id),FOREIGN KEY (c_pincode) REFERENCES location(pincode));

-- Order_Details Table
drop table if exists order_details;
create table order_details(o_id int,s_id int,p_id int,p_qty int,FOREIGN KEY (o_id) REFERENCES orders(o_id),FOREIGN KEY (s_id) REFERENCES seller(s_id),FOREIGN KEY (p_id) REFERENCES product(P_id));

-- Contact Us table
drop table if exists contact_us;
create table contact_us(name varchar(100),email varchar(100),mobile varchar(15),message varchar(1000));