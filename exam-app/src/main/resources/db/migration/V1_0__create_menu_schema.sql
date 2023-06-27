CREATE SEQUENCE hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE users (
  user_id BIGINT NOT NULL,
   user_name VARCHAR(255),
   password VARCHAR(255),
   role VARCHAR(255),
   CONSTRAINT pk_users PRIMARY KEY (user_id)
);

CREATE TABLE car_workshop (
  id BIGINT AUTO_INCREMENT NOT NULL,
   title VARCHAR(255),
   address VARCHAR(255),
   manager VARCHAR(255),
   CONSTRAINT pk_carworkshop PRIMARY KEY (id)
);

CREATE TABLE repairman (
  id BIGINT AUTO_INCREMENT NOT NULL,
   name VARCHAR(255),
   surname VARCHAR(255),
   work_scope VARCHAR(255),
   city VARCHAR(255),
   rating DOUBLE,
   carworkshop_id BIGINT,
   CONSTRAINT pk_repairman PRIMARY KEY (id)
);

ALTER TABLE repairman ADD CONSTRAINT FK_REPAIRMAN_ON_CARWORKSHOP FOREIGN KEY (carworkshop_id) REFERENCES car_workshop (id);

