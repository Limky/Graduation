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
-- Table structure for table `producttb`
--

DROP TABLE IF EXISTS `producttb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producttb` (
  `barcode` varchar(45) NOT NULL,
  `productName` varchar(45) NOT NULL,
  `description` longtext NOT NULL,
  `starPoint` double NOT NULL,
  `category` varchar(45) NOT NULL,
  `productUrl` varchar(45) NOT NULL,
  `scanCount` int(11) NOT NULL,
  `companyName` varchar(45) NOT NULL,
  `totalReviewCount` int(11) NOT NULL,
  PRIMARY KEY (`barcode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producttb`
--

LOCK TABLES `producttb` WRITE;
/*!40000 ALTER TABLE `producttb` DISABLE KEYS */;
INSERT INTO `producttb` VALUES ('15489','가나우유','처음 접하는 초보자라도 알 수 있도록 쉽게 그리고 체계적으로 서술',3.9,'음료','http://가나우유',4,'코카콜라',8),('21654','레쓰비','처음 접하는 초보자라도 알 수 있도록 쉽게 그리고 체계적으로 서술',2.5,'음료','http://레쓰비',25,'칠성',17),('25497','실론티','처음 접하는 초보자라도 알 수 있도록 쉽게 그리고 체계적으로 서술',3.8,'음료','http://실론티',17,'북스힐',16),('321654','코카콜라','처음 접하는 초보자라도 알 수 있도록 쉽게 그리고 체계적으로 서술',4.2,'음료','http://코카콜라',6,'코카콜라',15),('36989','갤럭시노트','처음 접하는 초보자라도 알 수 있도록 쉽게 그리고 체계적으로 서술',2.7,'가전제품','http://갤럭시노트',7,'북스힐',21),('54897','아이패드','처음 접하는 초보자라도 알 수 있도록 쉽게 그리고 체계적으로 서술',1.9,'가전제품','http://아이패드',11,'그린',19),('5498','스프라이트','처음 접하는 초보자라도 알 수 있도록 쉽게 그리고 체계적으로 서술',3.1,'음료','http://스프라이트',8,'칠성',10),('78954','코코팜','처음 접하는 초보자라도 알 수 있도록 쉽게 그리고 체계적으로 서술',2.7,'음료','http://코코팜',13,'코카콜라',13),('9788955268423','통계학계론','쉽게 이해하고, 자료분석적 접근방식으로 통계적 방법을 익히고, 적응하도록 개발',4.5,'도서','http://통계학계론',10,'북스힐',11),('9788986497878','UML과객체지향','처음 접하는 초보자라도 알 수 있도록 쉽게 그리고 체계적으로 서술',1.2,'도서','http://UML과객체지향',5,'그린',12),('9842156','오렌지주스','처음 접하는 초보자라도 알 수 있도록 쉽게 그리고 체계적으로 서술',4.5,'음료','http://오렌지주스',9,'칠성',3);
/*!40000 ALTER TABLE `producttb` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-18 23:17:06
