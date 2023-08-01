-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: metro
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `exceptionstationinfo`
--

DROP TABLE IF EXISTS `exceptionstationinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exceptionstationinfo` (
  `StationCode` int DEFAULT NULL,
  `StationName` text COLLATE utf8mb3_unicode_ci,
  `TransferParking` int DEFAULT NULL,
  `CycleLocker` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exceptionstationinfo`
--

LOCK TABLES `exceptionstationinfo` WRITE;
/*!40000 ALTER TABLE `exceptionstationinfo` DISABLE KEYS */;
INSERT INTO `exceptionstationinfo` VALUES (221,'가야',0,1),(226,'감전',0,1),(315,'강서구청',1,1),(223,'개금',0,1),(306,'거제',0,1),(212,'경성대·부경대',0,1),(413,'고촌',0,1),(209,'광안',0,1),(105,'괴정',0,1),(124,'교대',0,1),(231,'구남',1,1),(232,'구명',0,1),(130,'구서',1,1),(314,'구포',0,1),(217,'국제금융센터·부산은행',0,1),(238,'금곡',1,1),(210,'금련산',0,1),(408,'금사',0,1),(404,'낙민',0,1),(132,'남산',1,1),(311,'남산정',0,1),(242,'남양산',1,1),(211,'남천',1,1),(111,'남포',0,1),(97,'낫개',0,1),(224,'냉정',1,1),(134,'노포',1,1),(96,'다대포항',0,1),(95,'다대포해수욕장',0,1),(103,'당리',0,1),(213,'대연',0,1),(317,'대저',1,1),(106,'대티',0,1),(233,'덕천(2)',1,1),(313,'덕천(3)',1,1),(228,'덕포',0,1),(108,'동대신',0,1),(125,'동래(1)',1,1),(402,'동래(4)',0,1),(100,'동매',0,1),(204,'동백',0,1),(237,'동원',0,1),(222,'동의대',0,1),(131,'두실',0,1),(310,'만덕',0,1),(302,'망미',0,1),(126,'명륜',1,1),(406,'명장',0,1),(229,'모덕',0,1),(230,'모라',1,1),(214,'못골',0,1),(216,'문현',0,1),(304,'물만골',0,1),(309,'미남(3)',0,1),(401,'미남(4)',0,1),(207,'민락',0,1),(409,'반여농산물시장',0,1),(303,'배산',0,1),(118,'범내골',0,1),(133,'범어사',0,1),(117,'범일',0,0),(205,'벡스코',0,1),(128,'부산대',0,1),(241,'부산대양산캠퍼스',1,1),(113,'부산역',1,1),(115,'부산진',0,1),(220,'부암',0,1),(120,'부전',0,1),(227,'사상',1,1),(308,'사직',0,1),(104,'사하',0,1),(107,'서대신',1,1),(407,'서동',0,1),(119,'서면(1)',0,1),(219,'서면(2)',0,1),(410,'석대',0,1),(206,'센텀시티',0,1),(403,'수안',0,1),(208,'수영(2)',1,1),(301,'수영(3)',0,1),(234,'수정',0,1),(312,'숙등',0,1),(122,'시청',0,1),(98,'신장림',0,1),(101,'신평',1,1),(414,'안평',1,1),(243,'양산',1,1),(121,'양정',0,1),(123,'연산(1)',0,1),(305,'연산(3)',0,1),(411,'영산대',0,1),(127,'온천장',1,1),(412,'윗반송',0,1),(236,'율리',0,1),(110,'자갈치',0,1),(99,'장림',0,1),(201,'장산',1,1),(129,'장전',1,1),(218,'전포',1,1),(307,'종합운동장',0,1),(116,'좌천',1,1),(225,'주례',0,1),(202,'중동',1,1),(112,'중앙',0,0),(240,'증산',0,1),(215,'지게골',0,1),(316,'체육공원',1,1),(114,'초량',0,1),(405,'충렬사',1,1),(109,'토성',0,1),(102,'하단',1,1),(203,'해운대',0,1),(239,'호포',1,1),(235,'화명',0,1);
/*!40000 ALTER TABLE `exceptionstationinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-27  0:16:39
