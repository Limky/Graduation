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
  `memberUrl` longtext NOT NULL,
  `productUrl` longtext NOT NULL,
  `level` varchar(45) NOT NULL,
  `reviewText` longtext NOT NULL,
  `starPoint` double NOT NULL,
  PRIMARY KEY (`index`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviewtb`
--

LOCK TABLES `reviewtb` WRITE;
/*!40000 ALTER TABLE `reviewtb` DISABLE KEYS */;
INSERT INTO `reviewtb` VALUES (1,'alice823','103','http://a','http://bimage.interpark.com/goods_image/0/2/4/4/211110244g.jpg','Gold','정리가 잘되어있어 공부하기 편해요',3),(2,'trycry','103','http://a','http://bimage.interpark.com/goods_image/0/2/4/4/211110244g.jpg','Gold','Spring framwork 구조를 자세히 알게되었어요',2.5),(3,'luckrock','103','http://b','http://bimage.interpark.com/goods_image/0/2/4/4/211110244g.jpg','Gold','생각보다 자세한 예시들이 없어서 아쉽네요',3.5),(4,'ultra','105','http://b','http://bimage.interpark.com/goods_image/0/2/4/4/211110244g.jpg','Gold','Spring을 처음 공부하시는분들께 추천합니다!',1.5),(5,'hot8118','103','https://scontent.xx.fbcdn.net/v/t1.0-9/13133331_159272791137480_2076198251917202711_n.jpg?oh=0ff3e11adaa947acfd481819011865c8&oe=57E2D8BF','http://bimage.interpark.com/goods_image/0/2/4/4/211110244g.jpg','Gold','Spring의 모든것',2),(6,'limky8118','8801056049881','https://scontent.xx.fbcdn.net/v/t1.0-9/13133331_159272791137480_2076198251917202711_n.jpg?oh=0ff3e11adaa947acfd481819011865c8&oe=57E2D8BF','h','Silve','테스트',1),(32,'bung56','8801056049881','https://scontent.xx.fbcdn.net/v/t1.0-9/13321921_177022146029211_9105196508368089817_n.jpg?oh=123f561c9d448ef1d90f4243fb4dbd4a&oe=57E321F4','h','Bronze','테스트2',3.5),(78,'b','8801056049881','Http://비','http://www.dior.com/beauty/version-5.1432748111895/resize-image/ep/0/390/100/0/v6_packshots_pdg%252FPDG_Y0578850-F057885020.jpg','gold','ㄷㅇ륙',3),(79,'b','103','Http://비','http://bimage.interpark.com/goods_image/0/2/4/4/211110244g.jpg','gold','말이야 방구야',1),(80,'b','102','Http://비','http://image.auction.co.kr/itemimage/ec/20/c0/ec20c0b05.jpg','gold','리뷰등록',0.5),(81,'b','101','Http://비','http://gdimg.gmarket.co.kr/goods_image2/shop_img/588/107/588107548.jpg','gold','임인햑 바보',4.5);
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

-- Dump completed on 2016-06-01 11:18:04
