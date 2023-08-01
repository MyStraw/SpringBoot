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
-- Table structure for table `facilities`
--

DROP TABLE IF EXISTS `facilities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facilities` (
  `station_code` bigint NOT NULL,
  `above_under` varchar(2) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `floor` tinyint(1) DEFAULT NULL,
  `connector` tinyint(1) DEFAULT NULL,
  `transfer_parking` tinyint(1) DEFAULT NULL,
  `cycle_locker` tinyint(1) DEFAULT NULL,
  `meet_place` tinyint(1) DEFAULT NULL,
  `locker` tinyint(1) DEFAULT NULL,
  `photo` tinyint(1) DEFAULT NULL,
  `doc_machine` tinyint(1) DEFAULT NULL,
  `baby_milk` tinyint(1) DEFAULT NULL,
  `wheel_lift` tinyint(1) DEFAULT NULL,
  `elevator_inside` tinyint(1) DEFAULT NULL,
  `elevator_out` tinyint(1) DEFAULT NULL,
  `escalator` tinyint(1) DEFAULT NULL,
  `blind_way` tinyint(1) DEFAULT NULL,
  `external_ramp` tinyint(1) DEFAULT NULL,
  `emergency_phone` tinyint(1) DEFAULT NULL,
  `police` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`station_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facilities`
--

LOCK TABLES `facilities` WRITE;
/*!40000 ALTER TABLE `facilities` DISABLE KEYS */;
INSERT INTO `facilities` VALUES (95,'지하',2,1,0,1,1,1,0,1,1,0,1,1,1,1,0,1,0),(96,'지하',2,0,0,1,1,1,0,0,1,0,1,1,1,1,0,1,0),(97,'지하',3,0,0,1,1,0,0,0,1,0,1,1,1,1,1,1,0),(98,'지하',2,0,0,1,1,0,0,0,1,0,1,1,1,1,0,1,0),(99,'지하',2,0,0,1,1,0,0,0,1,0,1,1,1,1,0,1,0),(100,'지하',2,0,0,1,1,1,0,0,1,0,1,1,1,1,0,1,0),(101,'지하',1,0,1,1,1,0,0,0,1,0,1,1,0,1,1,1,0),(102,'지하',2,0,1,1,1,1,1,0,1,0,1,1,1,1,1,1,0),(103,'지하',2,0,0,1,1,0,0,0,1,0,1,1,0,1,1,1,0),(104,'지하',2,0,0,1,1,0,0,0,1,0,1,1,0,1,1,1,0),(105,'지하',2,1,0,1,1,1,1,0,1,0,1,1,0,1,1,1,0),(106,'지하',5,1,0,1,1,0,0,0,1,0,1,1,1,1,1,1,0),(107,'지하',4,1,1,1,1,0,0,0,1,0,1,1,1,1,1,1,0),(108,'지하',2,0,0,1,1,1,0,0,1,0,1,1,0,1,1,1,0),(109,'지하',2,0,0,1,1,1,0,0,1,0,1,1,0,1,1,1,0),(110,'지하',2,0,0,1,1,1,1,0,1,0,1,1,1,1,1,1,0),(111,'지하',2,0,0,1,1,1,1,0,1,0,1,1,1,1,1,1,0),(112,'지하',2,1,0,0,1,1,1,0,1,0,1,1,1,1,1,1,1),(113,'지하',2,0,1,1,1,1,1,0,1,0,1,1,1,1,1,1,0),(114,'지하',2,0,0,1,1,1,0,0,1,0,1,1,0,1,1,1,0),(115,'지하',2,1,0,1,1,1,0,0,1,0,1,1,0,1,1,1,0),(116,'지하',2,0,1,1,1,0,0,0,1,0,1,1,0,1,1,1,0),(117,'지하',2,0,0,0,1,1,1,0,1,0,1,1,0,1,1,1,0),(118,'지하',2,1,0,1,1,1,1,0,1,0,1,1,1,1,1,1,0),(119,'지하',2,1,0,1,0,1,1,1,1,0,1,1,1,1,1,1,1),(120,'지하',2,0,0,1,1,1,1,0,1,0,1,1,0,1,1,1,0),(121,'지하',2,1,0,1,1,1,1,0,1,0,1,1,0,1,1,1,0),(122,'지하',2,1,0,1,1,1,1,0,1,0,1,1,0,1,1,1,0),(123,'지하',2,1,0,1,1,1,1,1,1,0,0,1,1,1,0,1,1),(124,'지하',2,1,0,1,1,0,0,0,1,0,1,1,1,1,1,1,0),(125,'지상',2,1,1,1,1,1,1,0,1,0,1,0,1,1,1,1,0),(126,'지상',2,0,1,1,1,1,0,0,1,0,1,0,0,1,1,1,0),(127,'지상',2,0,1,1,1,1,0,0,1,0,1,0,0,1,1,1,1),(128,'지상',2,0,0,1,1,1,1,1,1,0,1,0,0,1,1,1,0),(129,'지상',2,0,1,1,1,1,0,0,1,0,1,0,0,1,1,1,0),(130,'지상',2,0,1,1,1,0,0,0,1,0,1,0,0,1,0,1,0),(131,'지하',2,0,0,1,1,0,0,0,1,0,1,1,0,1,1,1,0),(132,'지하',2,0,1,1,1,1,0,0,1,0,1,1,0,1,1,1,0),(133,'지하',3,0,0,1,1,0,0,0,1,0,1,1,1,1,1,1,0),(134,'지상',2,0,1,1,1,1,0,0,1,0,1,0,1,1,1,1,0),(201,'지하',2,1,1,1,1,1,1,0,1,0,1,1,0,1,1,1,0),(202,'지하',2,0,1,1,1,1,0,0,1,0,1,1,0,1,1,1,0),(203,'지하',2,1,0,1,1,1,0,0,1,0,1,1,0,1,1,1,0),(204,'지하',2,0,0,1,1,1,0,0,1,0,1,1,0,1,1,1,0),(205,'지하',2,0,0,1,1,1,0,0,1,0,1,1,1,1,1,1,0),(206,'지하',2,0,0,1,1,1,1,1,1,0,1,1,1,1,1,1,0),(207,'지하',3,0,0,1,1,0,0,1,1,0,1,1,1,1,1,1,0),(208,'지하',3,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0),(209,'지하',3,1,0,1,1,1,0,0,1,0,1,1,1,1,1,1,1),(210,'지하',4,1,0,1,1,1,0,0,1,0,1,1,1,1,1,1,0),(211,'지하',3,1,1,1,1,1,0,0,1,0,1,1,1,1,1,1,0),(212,'지하',3,1,0,1,1,1,1,0,1,0,1,1,1,1,1,1,0),(213,'지하',3,1,0,1,1,1,1,0,1,0,1,1,1,1,1,1,0),(214,'지하',3,1,0,1,1,0,0,0,1,0,1,1,1,1,1,1,0),(215,'지하',4,1,0,1,1,0,0,0,1,0,1,1,1,1,1,1,0),(216,'지하',3,1,0,1,1,0,0,0,1,0,1,1,1,1,1,1,0),(217,'지하',2,1,0,1,0,1,0,0,1,0,1,1,1,1,1,1,0),(218,'지하',3,1,1,1,1,1,0,0,1,0,1,1,1,1,1,1,0),(219,'지하',3,1,0,1,0,1,1,0,1,1,1,1,1,1,1,1,0),(220,'지하',3,1,0,1,1,0,0,0,1,0,1,1,1,1,1,1,0),(221,'지하',3,1,0,1,1,0,0,0,1,1,1,1,1,1,1,1,0),(222,'지하',4,1,0,1,1,1,0,0,1,0,1,1,1,1,1,1,0),(223,'지하',3,1,0,1,1,1,0,0,1,0,1,1,1,1,1,1,0),(224,'지하',2,0,1,1,1,1,0,1,1,0,1,1,0,1,1,1,0),(225,'지하',2,0,0,1,1,1,0,0,1,0,1,1,0,1,1,1,0),(226,'지하',2,0,0,1,1,0,0,0,1,0,1,1,0,1,1,1,0),(227,'지하',2,0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0),(228,'지하',2,0,0,1,1,0,0,0,1,0,1,1,0,1,1,1,0),(229,'지하',2,0,0,1,1,0,0,0,1,1,1,1,0,1,1,1,0),(230,'지하',2,0,1,1,1,1,0,0,1,0,1,1,0,1,1,1,0),(231,'지하',3,0,1,1,1,0,0,0,1,0,1,1,1,1,1,1,0),(232,'지하',3,0,0,1,1,0,0,0,1,0,1,1,1,1,1,1,0),(233,'지하',2,1,1,1,1,1,1,0,1,0,0,1,0,1,1,1,1),(234,'지하',2,0,0,1,1,0,0,0,1,0,1,1,1,1,1,1,0),(235,'지하',2,0,0,1,1,1,1,0,1,0,1,1,1,1,1,1,0),(236,'지하',2,0,0,1,1,0,0,0,1,0,1,1,0,1,1,1,0),(237,'지상',1,1,0,1,1,0,0,0,1,0,1,0,0,1,0,1,0),(238,'지상',2,0,1,1,1,0,0,0,1,0,1,0,0,1,1,1,0),(239,'지상',5,1,1,1,1,0,0,0,1,0,1,0,1,1,1,1,0),(240,'지상',2,0,0,1,1,0,0,1,1,0,1,0,1,1,1,1,0),(241,'지상',1,1,1,1,1,0,0,1,1,0,1,1,1,1,0,1,0),(242,'지상',3,1,1,1,1,1,0,1,1,0,1,1,1,1,0,1,0),(243,'지상',3,1,1,1,1,1,0,0,1,0,1,1,1,1,1,1,0),(301,'지하',4,1,0,1,1,1,0,0,1,0,0,0,1,1,0,1,0),(302,'지하',6,1,0,1,1,1,0,0,1,0,1,1,1,1,1,1,0),(303,'지하',8,1,0,1,1,1,0,0,1,0,1,1,1,1,1,1,0),(304,'지하',5,1,0,1,1,0,0,0,1,0,1,1,1,1,1,1,0),(305,'지하',4,1,0,1,1,1,0,0,1,0,1,1,1,1,1,1,0),(306,'지하',2,0,0,1,1,1,0,0,1,0,1,1,1,1,1,1,0),(307,'지하',3,1,0,1,1,1,0,0,1,0,1,1,1,1,1,1,1),(308,'지하',2,0,0,1,1,1,0,0,1,0,1,1,1,1,1,1,0),(309,'지하',3,1,0,1,1,1,0,1,1,0,1,1,1,1,1,1,0),(310,'지하',9,1,0,1,1,1,0,0,1,0,1,1,1,1,1,1,0),(311,'지하',2,0,0,1,1,1,0,0,1,0,1,1,1,1,1,1,0),(312,'지하',3,0,0,1,1,1,0,0,1,0,1,1,1,1,1,1,0),(313,'지하',3,1,1,1,1,1,0,0,1,0,1,1,1,1,1,1,0),(314,'지상',2,0,0,1,1,1,0,0,1,0,1,1,1,1,1,1,0),(315,'지상',5,0,1,1,1,1,0,0,1,0,1,1,1,1,1,1,0),(316,'지상',4,1,1,1,1,0,0,0,1,0,1,1,1,1,1,1,0),(317,'지상',3,1,1,1,1,1,0,0,1,0,1,1,1,1,0,1,0),(401,'지하',3,1,0,1,1,0,0,0,1,0,0,1,1,1,0,1,0),(402,'지하',4,1,0,1,1,1,0,0,1,0,1,1,1,1,0,1,0),(403,'지하',3,1,0,1,1,1,0,0,1,0,1,1,1,1,0,1,0),(404,'지하',3,1,0,1,1,0,0,0,1,0,1,1,1,1,0,1,0),(405,'지하',3,1,1,1,1,1,0,0,1,0,1,1,1,1,0,1,0),(406,'지하',3,1,0,1,1,0,0,0,1,0,1,1,1,1,0,1,0),(407,'지하',3,1,0,1,1,0,0,0,1,0,1,1,1,1,0,1,0),(408,'지하',3,1,0,1,1,0,0,0,1,0,1,1,1,1,0,1,0),(409,'지상',1,1,0,1,1,0,0,0,1,0,1,0,1,1,0,1,0),(410,'지상',2,1,0,1,1,0,0,0,1,0,1,0,1,1,0,1,0),(411,'지상',2,1,0,1,1,1,0,0,1,0,1,1,1,1,0,1,0),(412,'지상',2,1,0,1,1,1,0,0,1,0,1,1,1,1,0,1,0),(413,'지상',2,1,0,1,1,0,0,0,1,0,1,1,1,1,0,1,0),(414,'지상',2,1,1,1,1,1,0,0,1,0,1,1,1,1,0,1,0);
/*!40000 ALTER TABLE `facilities` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-28 14:01:05
