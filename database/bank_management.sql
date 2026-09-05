CREATE DATABASE IF NOT EXISTS bank_management;

USE bank_management;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    father_name VARCHAR(100),
    dob VARCHAR(30),
    gender VARCHAR(20),
    email VARCHAR(100),
    address VARCHAR(255),
    city VARCHAR(100),
    state VARCHAR(100),
    pin_code VARCHAR(20),
    account_type VARCHAR(50),
    card_number VARCHAR(20) UNIQUE NOT NULL,
    pin VARCHAR(10) NOT NULL,
    balance DOUBLE DEFAULT 0
);

CREATE TABLE transactions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    card_number VARCHAR(20) NOT NULL,
    transaction_type VARCHAR(50) NOT NULL,
    amount DOUBLE NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);