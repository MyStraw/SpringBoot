-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: metro
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `username` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `role` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `enabled` tinyint DEFAULT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('abc','$2a$10$TYQJH/rLkZQ/YwWL.TzqP.KA4UB357NqA16z9M8atsU.0HgNj.qO.','ROLE_MEMBER',1),('admin','$2a$10$tZ8xKr6IitFgLPwNdy155.wUoThK/MNgrOiS3US0lpoBhc5JbXOgO','ROLE_ADMIN',1),('manager','$2a$10$snLN4zKj0iPjiK74O4TEjOpnmJ/YY3HFmHwesmDzXL.0InB5vJIIm','ROLE_MANAGER',1),('member','$2a$10$.PAPNArmKhP35wFiVSrD2OU8slajVmWz4tS3g4PRGBFBB9w.1q38e','ROLE_MEMBER',1),('star','$2a$10$4k8dXLpX3FzubgqNaWJ1rezOBG.krLWUqRbbtwUIrk2.4c.X2iw.W','ROLE_MEMBER',1),('star1','$2a$10$l4isz/901YkvI0z8Z0z.F.I91bWSePOASevXZXB/AsnkeYFUagKUq','ROLE_MEMBER',1),('star22','$2a$10$wcXrSOk1hZEwxcFgZO53wOoyHG7P.YOlvkJuIOm7OkppHT9xuemAq','ROLE_MEMBER',1),('ㅋㅌㅊㅍ','$2a$10$pvyq2acFrEtyuuevQo4eBuoy8mMuqtmKjsszaVAhRC36bvtRVTzWS','ROLE_MEMBER',1);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-07 16:07:15
