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
-- Table structure for table `membertb`
--

DROP TABLE IF EXISTS `membertb`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `membertb` (
  `id` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `phoneNumber` varchar(45) NOT NULL,
  `point` bigint(20) NOT NULL,
  `level` varchar(45) NOT NULL,
  `memberUrl` longtext NOT NULL,
  `lastReviewDate` date NOT NULL,
  `reviewCount` int(11) NOT NULL,
  `totalReviewCount` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `membertb`
--

LOCK TABLES `membertb` WRITE;
/*!40000 ALTER TABLE `membertb` DISABLE KEYS */;
INSERT INTO `membertb` VALUES ('alice823','c123','씨','01081098048',310,'Gold','Http://씨','2016-05-30',2,2),('b','b123','비','01081098047',1400,'gold','Http://비','2016-05-30',62,42),('e','e123','이','01081098050',600,'Silver','Http://이','2016-05-18',2,5),('f','f123','에프','01081098051',800,'Gold','Http://에프','2016-05-18',2,9),('g','g123','쥐','01081098052',1000,'Bronze','Http://쥐','2016-05-18',2,4),('h','h123','에이치','01081098053',500,'Bronze','Http://에이치','2016-05-18',2,5),('i','i123','아이','01081098054',600,'Bronze','Http://아이','2016-05-18',2,6),('limkyy','a123','에이','01081098046',10099,'Silver','https://scontent.xx.fbcdn.net/v/t1.0-9/13133331_159272791137480_2076198251917202711_n.jpg?oh=0ff3e11adaa947acfd481819011865c8&oe=57E2D8BF','2016-05-30',285,39),('luckrock','d123','디','01081098049',460,'Gold','Http://디','2016-05-29',2,7);
/*!40000 ALTER TABLE `membertb` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-06-01 11:18:03
