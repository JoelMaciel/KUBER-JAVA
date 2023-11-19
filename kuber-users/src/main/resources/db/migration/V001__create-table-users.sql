CREATE TABLE users (
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(100) NOT NULL,
   email VARCHAR(60) NOT NULL UNIQUE,
   password VARCHAR(30) NOT NULL,
   creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);