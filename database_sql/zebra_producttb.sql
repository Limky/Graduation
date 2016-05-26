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
  `productUrl` longtext NOT NULL,
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
INSERT INTO `producttb` VALUES ('21654','갤럭시노트11','처음 접하는 초보자라도 알 수 있도록 쉽게 그리고 체계적으로 서술',2.5,'1','http://레쓰비',25,'삼양',17),('25497','갤럭시노트22','처음 접하는 초보자라도 알 수 있도록 쉽게 그리고 체계적으로 서술',3.8,'2','http://실론티',17,'삼양',16),('321654','삼성전자3 AX80K7580WFD','사용면적 90㎡, 소비전력 90W, 필터 항균필터, 기타특징 필터점검알림',4.2,'3','http://shopping.phinf.naver.net/main_9261996/9261996568.20160107095622.jpg?type=f300',6,'농심',15),('36989','갤럭시노트3','처음 접하는 초보자라도 알 수 있도록 쉽게 그리고 체계적으로 서술',2.7,'3','http://갤럭시노트',7,'삼성',21),('54897','갤럭시노트4','처음 접하는 초보자라도 알 수 있도록 쉽게 그리고 체계적으로 서술',1.9,'4','http://아이패드',11,'애플',19),('5498','스프라이트2','처음 접하는 초보자라도 알 수 있도록 쉽게 그리고 체계적으로 서술',3.1,'2','http://스프라이트',8,'농심',10),('841456049881','가나우유11','처음 접하는 초보자라도 알 수 있도록 쉽게 그리고 체계적으로 서술',3.9,'1','http://가나우유',4,'농심',8),('8801056049881','코코팜4','처음 접하는 초보자라도 알 수 있도록 쉽게 그리고 체계적으로 서술',2.7,'4','http://코코팜',13,'해태',13),('8801056059842','아이시스 8.0','Natural Mineral Water Get a concise introduction to Spring, the popular open source framework for building lightweight enterprise',3.5,'1','http://www.dior.com/beauty/version-5.1432748111895/resize-image/ep/0/390/100/0/v6_packshots_pdg%252FPDG_Y0578850-F057885020.jpg',10,'롯데',5),('9788955268423','Just Spring4','Get a concise introduction to Spring, the popular open source framework for building lightweight enterprise',4.5,'4','https://scontent.xx.fbcdn.net/v/t1.0-9/13240509_172684289796330_2913376845849042849_n.jpg?oh=29e67d3e4ade26b3071fbdd803a56ca1&oe=57E17ADE',10,'농심',11),('9788986497878','UML과객체지향3','처음 접하는 초보자라도 알 수 있도록 쉽게 그리고 체계적으로 서술',1.2,'3','http://UML과객체지향',5,'삼양',12),('9842156','디올 foundation3','제형 리퀴드, 종류 파운데이션, 제품구성 본품, 제품 특징 자외선차단, 지속력, 커버력, 밀착력 사용 효과',4.5,'3','http://www.dior.com/beauty/version-5.1432748111895/resize-image/ep/0/390/100/0/v6_packshots_pdg%252FPDG_Y0578850-F057885020.jpg',9,'해태',3);
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

-- Dump completed on 2016-05-26 22:46:43
