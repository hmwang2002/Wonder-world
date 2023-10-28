CREATE DATABASE `spot` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

use spot;
-- spot.landscape definition

CREATE TABLE `landscape` (
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `name` varchar(100) NOT NULL,
                             `description` text NOT NULL,
                             `photo` varchar(100) DEFAULT NULL,
                             `longitude` double NOT NULL,
                             `latitude` double NOT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;