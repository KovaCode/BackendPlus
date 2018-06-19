CREATE DATABASE IF NOT EXISTS `data` DEFAULT CHARACTER SET 'utf8';
use `data`;

CREATE TABLE IF NOT EXISTS `skill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_5ljf2l2h4odhtxrsuohlro4ir` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `email` varchar(150) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `note` varchar(500) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_lqjrcobrh9jc8wpcar64q1bfh` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;



CREATE TABLE IF NOT EXISTS `user_skill` (
  `user_id` bigint(20) NOT NULL,
  `skill_id` bigint(20) NOT NULL,
  KEY `FKj53flyds4vknyh8llw5d7jdop` (`skill_id`),
  KEY `FKfixgsonf2ev168mfck7co17u1` (`user_id`),
  CONSTRAINT `FKfixgsonf2ev168mfck7co17u1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKj53flyds4vknyh8llw5d7jdop` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



--insert into skill (name) values ('Java');
--insert into skill (name) values ('Springboot');
--insert into skill (name) values ('Php');
--insert into skill (name) values ('Html');
--insert into skill (name) values ('Selenium');
--insert into skill (name) values ('Python');
--insert into skill (name) values ('c#');
--insert into skill (name) values ('MsSql');
--insert into skill (name) values ('MySql');
--insert into skill (name) values ('OracleDb');
--insert into skill (name) values ('MongoDb');
--insert into skill (name) values ('Microservices');
--insert into skill (name) values ('TestNg');
--insert into skill (name) values ('Jira');
--insert into skill (name) values ('Angular');
----insert into skill (name) values ('Testrail');

