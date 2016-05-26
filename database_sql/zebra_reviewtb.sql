-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: zebra
-- ------------------------------------------------------
-- Server version	5.7.12-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `reviewtb`
--

DROP TABLE IF EXISTS `reviewtb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reviewtb` (
  `index` int(11) NOT NULL AUTO_INCREMENT,
  `id` varchar(45) NOT NULL,
  `barcode` varchar(45) NOT NULL,
  `reviewText` longtext NOT NULL,
  `starPoint` double NOT NULL,
  `memberUrl` varchar(45) NOT NULL,
  `productUrl` longtext NOT NULL,
  PRIMARY KEY (`index`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviewtb`
--

LOCK TABLES `reviewtb` WRITE;
/*!40000 ALTER TABLE `reviewtb` DISABLE KEYS */;
INSERT INTO `reviewtb` VALUES (1,'a','9788955268426','이 책을 통하여 기술통계, 확률 및 확률분포를 익혔습니다!',4,'http://a',''),(2,'a','9788986497878','UML을 통하여 실무에서 사용할 수 있게 실무사례를 익혔습니다.',2,'http://a',''),(3,'b','9788955268423','추정과 가설검정, 분산분석에 대하여 익혔습니다',1,'http://b',''),(4,'b','9788986497878','소프트웨어개발을 전공하는 자로서 객체지향기법의 소프트웨어 개발에 관한 비젼을 얻었다',5,'http://b',''),(5,'c','841456049881','안드로이드 통신 테스트',3,'http://c',''),(6,'a','841456049881','안드로이드 통신 테스트 2',3,'http://a',''),(7,'b','841456049881','안드로이드 통신 테스트 3',2,'http://b',''),(30,'a','9842156','냄세가 참좋네요',4,'http://a','http://www.dior.com/beauty/version-5.1432748111895/resize-image/ep/0/390/100/0/v6_packshots_pdg%252FPDG_Y0578850-F057885020.jpg'),(31,'b','9842156','디올이라그런지 쩌네요',3,'http://b','http://www.dior.com/beauty/version-5.1432748111895/resize-image/ep/0/390/100/0/v6_packshots_pdg%252FPDG_Y0578850-F057885020.jpg'),(32,'bung56','8801056059842','목넘김이 부드럽고 깔끔해서 좋아요!',1,'h','h'),(33,'inhyuck111','8801056059842','각종 회의나 세미나에서 많이 활용중입니다!',1,'h','h'),(34,'a','8801056059842','dd',2,'Http://에이','http://www.dior.com/beauty/version-5.1432748111895/resize-image/ep/0/390/100/0/v6_packshots_pdg%252FPDG_Y0578850-F057885020.jpg'),(35,'a','8801056059842','dee',2,'Http://에이','http://www.dior.com/beauty/version-5.1432748111895/resize-image/ep/0/390/100/0/v6_packshots_pdg%252FPDG_Y0578850-F057885020.jpg'),(36,'a','8801056059842','호ㅓㅇ기탸',2,'Http://에이','http://www.dior.com/beauty/version-5.1432748111895/resize-image/ep/0/390/100/0/v6_packshots_pdg%252FPDG_Y0578850-F057885020.jpg'),(37,'a','8801056059842','a',3,'a','d'),(38,'a','8801056059842','s',3,'b','d'),(39,'a','8801056059842','d',3,'d','d'),(40,'a','8801056059842','f',3,'d','d'),(41,'a','8801056059842','g',4,'d','d'),(42,'a','8801056059842','g',4,'d','d'),(43,'a','8801056059842','h',4,'d','d'),(44,'a','8801056059842','j',4,'d','d'),(45,'a','8801056059842','re',4,'d','d'),(46,'a','8801056059842','w',5,'d','d');
/*!40000 ALTER TABLE `reviewtb` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-26 22:46:44
