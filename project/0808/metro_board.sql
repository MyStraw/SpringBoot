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
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `content` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `author` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `station_code` int DEFAULT NULL,
  `like_count` int DEFAULT '0',
  `image` varchar(255) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `imagefile` tinyblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=181 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (1,'냐하하','뇨호호호호호','EMBER',NULL,0,NULL,NULL),(2,'냐하하','뇨호호','뜡뜡',NULL,0,NULL,NULL),(3,'냐하하22','뇨호호','뜡뜡',NULL,0,NULL,NULL),(4,'해보자','냐하하',NULL,NULL,0,NULL,NULL),(5,'해보자2','냐하하',NULL,NULL,0,NULL,NULL),(6,'해보자3','냐하하',NULL,NULL,0,NULL,NULL),(7,'해보자5','냐하하',NULL,NULL,0,NULL,NULL),(8,'해보자6','냐하하',NULL,NULL,0,NULL,NULL),(9,'마네자~','냐하하','manager',NULL,0,NULL,NULL),(10,'냐하하1','뇨호호호호호1','MEMBER1',95,0,NULL,NULL),(11,'냐하하2','뇨호호호호호2','MEMBER2',95,0,NULL,NULL),(12,'냐하하3','뇨호호호호호3','MEMBER3',95,0,NULL,NULL),(13,'냐하하4','뇨호호호호호4','MEMBER4',96,0,NULL,NULL),(14,'냐하하5','뇨호호호호호5','MEMBER5',96,0,NULL,NULL),(15,'냐하하6','뇨호호호호호6','MEMBER6',96,0,NULL,NULL),(16,'냐하하7','냐하하하ㅏ하호호호호호누ㅠㅠㅎ휴휴야니니ㅏ야더ㅁㄴㅇㄻㄴㅇㄼㅈㄷㄹ얀낭림ㄴ어림냐ㅓ리;ㅂ젇리;ㅏㅓㅈ빌더ㅣ;ㅁㄴ어리;ㅑㅁㄴ어림;나어리ㅑ먼일;ㅑㅓㅂㅈ미;댜ㅂ쟈덜;ㅣㅂ쟈더리ㅑㅓㅂ지다ㅓ리ㅏㄴㅁ어리ㅑㅁㄴ어ㅣ;ㅏ럼ㄴ이ㅑ럼니아러ㅣㅁㄴ어리ㅏㅁㄴ어ㅣ럼ㄴ이ㅏ러민아ㅓ림냥러ㅣ자ㅓㄷ리ㅓㅁㄴ이ㅏ럼니아러ㅣㅁ나어리ㅏ먼이랴ㅓ지바더리ㅓㅁㄴ이ㅏ리ㅏㅁ넝리ㅑㅓ비자디랴ㅓㅁㄴ이ㅏ러ㅣㅑㅂ지;ㅏㄷ러ㅣㅁㄴ어ㅣㅏㅓㄹㅓㄹ냐어','MEMBER7',96,0,NULL,NULL),(17,'냐하하8','뇨호호호호호8','MEMBER8',97,0,NULL,NULL),(18,'냐하하9','뇨호호호호호9','MEMBER9',97,0,NULL,NULL),(19,'냐하하10','뇨호호호호호10','MEMBER10',97,0,NULL,NULL),(20,'냐하하11','뇨호호호호호11','MEMBER11',97,0,NULL,NULL),(21,'냐하하12','뇨호호호호호12','MEMBER12',98,0,NULL,NULL),(22,'냐하하13','뇨호호호호호13','MEMBER13',98,0,NULL,NULL),(23,'냐하하14','뇨호호호호호14','MEMBER14',98,0,NULL,NULL),(24,'냐하하15','뇨호호호호호15','MEMBER15',98,0,NULL,NULL),(25,'냐하하16','뇨호호호호호16','MEMBER16',99,0,NULL,NULL),(26,'냐하하17','뇨호호호호호17','MEMBER17',99,0,NULL,NULL),(27,'냐하하18','뇨호호호호호18','MEMBER18',99,0,NULL,NULL),(28,'냐하하19','뇨호호호호호19','MEMBER19',99,0,NULL,NULL),(29,'냐하하20','뇨호호호호호20','MEMBER20',100,0,NULL,NULL),(30,'냐하하21','뇨호호호호호21','MEMBER21',100,0,NULL,NULL),(31,'냐하하22','뇨호호호호호22','MEMBER22',100,0,NULL,NULL),(32,'냐하하23','뇨호호호호호23','MEMBER23',100,0,NULL,NULL),(33,'냐하하24','뇨호호호호호24','MEMBER24',101,0,NULL,NULL),(34,'냐하하25','뇨호호호호호25','MEMBER25',101,0,NULL,NULL),(35,'냐하하26','뇨호호호호호26','MEMBER26',101,0,NULL,NULL),(36,'냐하하27','뇨호호호호호27','MEMBER27',101,0,NULL,NULL),(37,'냐하하28','뇨호호호호호28','MEMBER28',102,0,NULL,NULL),(38,'냐하하29','뇨호호호호호29','MEMBER29',102,0,NULL,NULL),(39,'냐하하30','뇨호호호호호30','MEMBER30',102,0,NULL,NULL),(40,'냐하하31','뇨호호호호호31','MEMBER31',102,0,NULL,NULL),(41,'냐하하32','뇨호호호호호32','MEMBER32',103,0,NULL,NULL),(42,'냐하하33','뇨호호호호호33','MEMBER33',103,0,NULL,NULL),(43,'냐하하34','뇨호호호호호34','MEMBER34',103,0,NULL,NULL),(44,'냐하하35','뇨호호호호호35','MEMBER35',103,0,NULL,NULL),(45,'냐하하36','뇨호호호호호36','MEMBER36',104,0,NULL,NULL),(46,'냐하하37','뇨호호호호호37','MEMBER37',104,0,NULL,NULL),(47,'냐하하38','뇨호호호호호38','MEMBER38',104,0,NULL,NULL),(48,'냐하하39','뇨호호호호호39','MEMBER39',104,0,NULL,NULL),(49,'냐하하40','뇨호호호호호40','MEMBER40',105,0,NULL,NULL),(50,'냐하하41','뇨호호호호호41','MEMBER41',105,0,NULL,NULL),(51,'냐하하42','뇨호호호호호42','MEMBER42',105,0,NULL,NULL),(52,'냐하하43','뇨호호호호호43','MEMBER43',105,0,NULL,NULL),(53,'냐하하44','뇨호호호호호44','MEMBER44',106,0,NULL,NULL),(54,'냐하하45','뇨호호호호호45','MEMBER45',106,0,NULL,NULL),(55,'냐하하46','뇨호호호호호46','MEMBER46',106,0,NULL,NULL),(56,'냐하하47','뇨호호호호호47','MEMBER47',106,0,NULL,NULL),(57,'냐하하48','뇨호호호호호48','MEMBER48',107,0,NULL,NULL),(58,'냐하하49','뇨호호호호호49','MEMBER49',107,0,NULL,NULL),(59,'냐하하50','뇨호호호호호50','MEMBER50',107,0,NULL,NULL),(60,'냐하하51','뇨호호호호호51','MEMBER51',107,0,NULL,NULL),(61,'냐하하52','뇨호호호호호52','MEMBER52',108,0,NULL,NULL),(62,'냐하하53','뇨호호호호호53','MEMBER53',108,0,NULL,NULL),(63,'냐하하54','뇨호호호호호54','MEMBER54',108,0,NULL,NULL),(64,'냐하하55','뇨호호호호호55','MEMBER55',108,0,NULL,NULL),(65,'냐하하56','뇨호호호호호56','MEMBER56',109,0,NULL,NULL),(66,'냐하하57','뇨호호호호호57','MEMBER57',109,0,NULL,NULL),(67,'냐하하58','뇨호호호호호58','MEMBER58',109,0,NULL,NULL),(68,'냐하하59','뇨호호호호호59','MEMBER59',109,0,NULL,NULL),(69,'냐하하60','뇨호호호호호60','MEMBER60',110,0,NULL,NULL),(70,'냐하하61','뇨호호호호호61','MEMBER61',110,0,NULL,NULL),(71,'냐하하62','뇨호호호호호62','MEMBER62',110,0,NULL,NULL),(72,'냐하하63','뇨호호호호호63','MEMBER63',110,0,NULL,NULL),(73,'냐하하64','뇨호호호호호64','MEMBER64',111,0,NULL,NULL),(74,'냐하하65','뇨호호호호호65','MEMBER65',111,0,NULL,NULL),(75,'냐하하66','뇨호호호호호66','MEMBER66',111,0,NULL,NULL),(76,'냐하하67','뇨호호호호호67','MEMBER67',111,0,NULL,NULL),(77,'냐하하68','뇨호호호호호68','MEMBER68',112,0,NULL,NULL),(78,'냐하하69','뇨호호호호호69','MEMBER69',112,0,NULL,NULL),(79,'냐하하70','뇨호호호호호70','MEMBER70',112,0,NULL,NULL),(80,'냐하하71','뇨호호호호호71','MEMBER71',112,0,NULL,NULL),(81,'냐하하72','뇨호호호호호72','MEMBER72',113,0,NULL,NULL),(82,'냐하하73','뇨호호호호호73','MEMBER73',113,0,NULL,NULL),(83,'냐하하74','뇨호호호호호74','MEMBER74',113,0,NULL,NULL),(84,'냐하하75','뇨호호호호호75','MEMBER75',113,0,NULL,NULL),(85,'냐하하76','뇨호호호호호76','MEMBER76',114,0,NULL,NULL),(86,'냐하하77','뇨호호호호호77','MEMBER77',114,0,NULL,NULL),(87,'냐하하78','뇨호호호호호78','MEMBER78',114,0,NULL,NULL),(88,'냐하하79','뇨호호호호호79','MEMBER79',114,0,NULL,NULL),(89,'냐하하80','뇨호호호호호80','MEMBER80',115,0,NULL,NULL),(90,'냐하하81','뇨호호호호호81','MEMBER81',115,0,NULL,NULL),(91,'냐하하82','뇨호호호호호82','MEMBER82',115,0,NULL,NULL),(92,'냐하하83','뇨호호호호호83','MEMBER83',115,0,NULL,NULL),(93,'냐하하84','뇨호호호호호84','MEMBER84',116,0,NULL,NULL),(94,'냐하하85','뇨호호호호호85','MEMBER85',116,0,NULL,NULL),(95,'냐하하86','뇨호호호호호86','MEMBER86',116,0,NULL,NULL),(96,'냐하하87','뇨호호호호호87','MEMBER87',116,0,NULL,NULL),(97,'냐하하88','뇨호호호호호88','MEMBER88',117,0,NULL,NULL),(98,'냐하하89','뇨호호호호호89','MEMBER89',117,0,NULL,NULL),(99,'냐하하90','뇨호호호호호90','MEMBER90',117,0,NULL,NULL),(100,'냐하하91','뇨호호호호호91','MEMBER91',117,0,NULL,NULL),(101,'냐하하92','뇨호호호호호92','MEMBER92',118,0,NULL,NULL),(102,'냐하하93','뇨호호호호호93','MEMBER93',118,0,NULL,NULL),(103,'냐하하94','뇨호호호호호94','MEMBER94',118,0,NULL,NULL),(104,'냐하하95','뇨호호호호호95','MEMBER95',118,0,NULL,NULL),(105,'냐하하96','뇨호호호호호96','MEMBER96',119,0,NULL,NULL),(106,'냐하하97','뇨호호호호호97','MEMBER97',119,0,NULL,NULL),(107,'냐하하98','뇨호호호호호98','MEMBER98',119,0,NULL,NULL),(108,'냐하하99','뇨호호호호호99','MEMBER99',119,0,NULL,NULL),(109,'냐하하100','뇨호호호호호100','MEMBER100',120,0,NULL,NULL),(110,'냐하하1','뇨호호호호호1','MEMBER1',200,0,NULL,NULL),(111,'냐하하2','뇨호호호호호2','MEMBER2',200,0,NULL,NULL),(112,'냐하하3','뇨호호호호호3','MEMBER3',200,0,NULL,NULL),(113,'냐하하4','뇨호호호호호4','MEMBER4',201,0,NULL,NULL),(114,'냐하하5','뇨호호호호호5','MEMBER5',201,0,NULL,NULL),(115,'냐하하6','뇨호호호호호6','MEMBER6',201,0,NULL,NULL),(116,'냐하하7','뇨호호호호호7','MEMBER7',201,0,NULL,NULL),(117,'냐하하8','뇨호호호호호8','MEMBER8',202,0,NULL,NULL),(118,'냐하하9','뇨호호호호호9','MEMBER9',202,0,NULL,NULL),(119,'냐하하10','뇨호호호호호10','MEMBER10',202,0,NULL,NULL),(120,'냐하하11','뇨호호호호호11','MEMBER11',202,0,NULL,NULL),(121,'냐하하12','뇨호호호호호12','MEMBER12',203,0,NULL,NULL),(122,'냐하하13','뇨호호호호호13','MEMBER13',203,0,NULL,NULL),(123,'냐하하14','뇨호호호호호14','MEMBER14',203,0,NULL,NULL),(124,'냐하하15','뇨호호호호호15','MEMBER15',203,0,NULL,NULL),(125,'냐하하16','뇨호호호호호16','MEMBER16',204,0,NULL,NULL),(126,'냐하하17','뇨호호호호호17','MEMBER17',204,0,NULL,NULL),(127,'냐하하18','뇨호호호호호18','MEMBER18',204,0,NULL,NULL),(128,'냐하하19','뇨호호호호호19','MEMBER19',204,0,NULL,NULL),(129,'냐하하20','뇨호호호호호20','MEMBER20',205,0,NULL,NULL),(130,'냐하하1','뇨호호호호호1','MEMBER1',300,0,NULL,NULL),(131,'냐하하2','뇨호호호호호2','MEMBER2',300,0,NULL,NULL),(132,'냐하하3','뇨호호호호호3','MEMBER3',300,0,NULL,NULL),(133,'냐하하4','뇨호호호호호4','MEMBER4',301,0,NULL,NULL),(134,'냐하하5','뇨호호호호호5','MEMBER5',301,0,NULL,NULL),(135,'냐하하6','뇨호호호호호6','MEMBER6',301,0,NULL,NULL),(136,'냐하하7','뇨호호호호호7','MEMBER7',301,0,NULL,NULL),(137,'냐하하8','뇨호호호호호8','MEMBER8',302,0,NULL,NULL),(138,'냐하하9','뇨호호호호호9','MEMBER9',302,0,NULL,NULL),(139,'냐하하10','뇨호호호호호10','MEMBER10',302,0,NULL,NULL),(140,'냐하하11','뇨호호호호호11','MEMBER11',302,0,NULL,NULL),(141,'냐하하12','뇨호호호호호12','MEMBER12',303,0,NULL,NULL),(142,'냐하하13','뇨호호호호호13','MEMBER13',303,0,NULL,NULL),(143,'냐하하14','뇨호호호호호14','MEMBER14',303,0,NULL,NULL),(144,'냐하하15','뇨호호호호호15','MEMBER15',303,0,NULL,NULL),(145,'냐하하16','뇨호호호호호16','MEMBER16',304,0,NULL,NULL),(146,'냐하하17','뇨호호호호호17','MEMBER17',304,0,NULL,NULL),(147,'냐하하18','뇨호호호호호18','MEMBER18',304,0,NULL,NULL),(148,'냐하하19','뇨호호호호호19','MEMBER19',304,0,NULL,NULL),(149,'냐하하20','뇨호호호호호20','MEMBER20',305,0,NULL,NULL),(150,'냐하하1','뇨호호호호호1','MEMBER1',400,0,NULL,NULL),(151,'냐하하2','뇨호호호호호2','MEMBER2',400,0,NULL,NULL),(152,'냐하하3','뇨호호호호호3','MEMBER3',400,0,NULL,NULL),(153,'냐하하4','뇨호호호호호4','MEMBER4',401,0,NULL,NULL),(154,'냐하하5','뇨호호호호호5','MEMBER5',401,0,NULL,NULL),(155,'냐하하6','뇨호호호호호6','MEMBER6',401,0,NULL,NULL),(156,'냐하하7','뇨호호호호호7','MEMBER7',401,0,NULL,NULL),(157,'냐하하8','뇨호호호호호8','MEMBER8',402,0,NULL,NULL),(158,'냐하하9','뇨호호호호호9','MEMBER9',402,0,NULL,NULL),(159,'냐하하10','뇨호호호호호10','MEMBER10',402,0,NULL,NULL),(160,'냐하하11','뇨호호호호호11','MEMBER11',402,0,NULL,NULL),(161,'냐하하12','뇨호호호호호12','MEMBER12',403,0,NULL,NULL),(162,'냐하하13','뇨호호호호호13','MEMBER13',403,0,NULL,NULL),(163,'냐하하14','뇨호호호호호14','MEMBER14',403,0,NULL,NULL),(164,'냐하하15','뇨호호호호호15','MEMBER15',403,0,NULL,NULL),(165,'냐하하16','뇨호호호호호16','MEMBER16',404,0,NULL,NULL),(166,'냐하하17','뇨호호호호호17','MEMBER17',404,0,NULL,NULL),(167,'냐하하18','뇨호호호호호18','MEMBER18',404,0,NULL,NULL),(168,'냐하하19','뇨호호호호호19','MEMBER19',404,0,NULL,NULL),(169,'냐하하20','뇨호호호호호20','MEMBER20',405,0,NULL,NULL),(170,'뇨호호','냐하하하','member',405,0,NULL,NULL),(171,'test','test','ㅋㅌㅊㅍ',104,NULL,NULL,NULL),(172,'sdgsd','sdf','abc',108,0,NULL,NULL),(173,'sigkgk','뇨호호','abc',107,0,NULL,NULL),(174,'sdfg','dfhre','abc',107,0,'52fbcc19-603f-41cd-ba46-385c7d4921c5_video_call_black_24dp.svg',NULL),(175,'aaaa','냐하하하','admin',103,0,NULL,NULL),(177,'뇨호호2','냐하하하','admin',103,0,NULL,NULL),(179,'뇨호호2','냐하하하','admin',103,0,NULL,NULL),(180,'wpfdjsk','dsfsdkljgvxclkjdslkfjwkejriojfdkfsfnkxmlkfjsdfishflskdgklsfsdfd','ㅋㅌㅊㅍ',113,0,NULL,NULL);
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-08 17:47:56
