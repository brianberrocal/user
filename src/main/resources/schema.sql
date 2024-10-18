CREATE TABLE users (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NULL,
  email VARCHAR(50) NULL,
  password VARCHAR(100) NULL,
  dateCreated DATETIME NULL,
  dateModified DATETIME NULL,
  lastLogin DATETIME NULL,
  token VARCHAR(100) NULL,
  inactive CHAR(1) NULL
);

CREATE TABLE phone (
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   number VARCHAR(12) NULL,
   city VARCHAR(50) NULL,
   countryCode VARCHAR(3) NULL,
   users_id BIGINT,
   FOREIGN KEY (users_id) REFERENCES users(id)
);