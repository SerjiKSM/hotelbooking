CREATE DATABASE IF NOT EXISTS hotelbooking;

use hotelbooking;

CREATE TABLE IF NOT EXISTS users
  (
     id            BIGINT NOT NULL AUTO_INCREMENT,
     username      VARCHAR(255) NOT NULL,
     PRIMARY KEY (id)
  );

insert into `users`(`username`) values
('Rowan Atkinson'),
('Bruce Lee'),
('Chuck Norris');


CREATE TABLE IF NOT EXISTS addresses
  (
     id        BIGINT NOT NULL AUTO_INCREMENT,
     city      VARCHAR(255) NOT NULL,
     state     VARCHAR(255) NOT NULL,
     country   VARCHAR(255) NOT NULL,
     user_id   BIGINT NOT NULL,
     PRIMARY KEY (id)
  );

insert into `addresses`(`city`, `state`, `country`, `user_id`) values
('New York', 'USA', 'America', 2),
('California', 'USA', 'America', 1),
('Boston', 'USA', 'America', 3),
('Chicago', 'USA', 'America', 3);

