CREATE TABLE `role`(
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `name` varchar(20) DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

 INSERT INTO role(name) VALUES('ADMIN');
 INSERT INTO role(name) VALUES('USER');
 INSERT INTO role(name) VALUES('BOOKER');
 INSERT INTO role(name) VALUES('EVENT_OWNER');