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
INSERT INTO `producttb` VALUES ('101','시작하세요 스프링4 ','자바 엔터프라이즈 개발의 핵심 프레임워크로 자리 잡은 스프링을 기반으로 한 개발 방법을 소개하는 실습 안내서',3,'1','http://gdimg.gmarket.co.kr/goods_image2/shop_img/588/107/588107548.jpg',25,'위키북스',17),('102','스프링4 프로그래밍 입문','스프링 프로젝트 생성, XML 설정과 자바 코드 설정, 스프링의 기본적인 사용법과 DB와 스프링 MVC에 대해서 다룬다. ',3,'1','http://image.auction.co.kr/itemimage/ec/20/c0/ec20c0b05.jpg',17,'가메출판사',16),('103','토비의 스프링 3.1 세트','스프링을 활용한 아키텍처를 설계하고 프레임워크를 개발하려고 하는 아키텍트에 이르기까지 모두 참고할 수 있는 스프링 완벽 바이블',2.6,'1','http://bimage.interpark.com/goods_image/0/2/4/4/211110244g.jpg',6,'에이콘출판',5),('104','Do it! 안드로이드 앱 프로그래밍',' 변경된 프래그먼트 사용 방법과 페이스북 연동 등 이번 개정 3판에서는 최신 버전인 마시멜로에 맞춰 소스 코드 테스트를 완료했다. ',4.1,'1','http://image.auction.co.kr/itemimage/ec/21/51/ec2151043.jpg',70,'이지스퍼블리싱',32),('105','이것이 안드로이드다','저자의 경험을 녹여낸 이 책은 무작정 암기하지 않아도 자연스럽게 고급 정보를 익힐 수 있어 실무에 강한 전문가로 여러분을 이끌어 줄 것이다.',3.8,'1','http://www.hanbit.co.kr/data/books/B6633742408_l.jpg',7,'한빛미디어 ',21),('106','인사이드 안드로이드 ','안드로이드 프레임워크 분석을 위한 국내 최초의 참고 서적으로, 안드로이드 프레임워크의 구조가 궁금한 개발자들에게는 한줄기 단비와 같은 책이다.',3.5,'1','http://www.kapg.org/img/board/qna/insideandroid/book_inside_android.jpg',11,'위키북스',19),('107','난 정말 JAVA를 공부한 적이 없다구요 ','많은 것을 알려주는 것도 중요하지만, 많은 것을 스스로 알아갈 수 있는 능력을 향상시키는 자바 기본서. ',3.1,'1','http://gdimg.gmarket.co.kr/goods_image2/shop_img/172/082/172082291.jpg',8,'오렌지미디어',10),('108','명품 JAVA Programming','전공자나 비전공자를 불문하고 다양한 독자들이 자바 언어를 배우기 쉽도록 책의 내용을 충실히 정리하고 적절한 예제를 준비하였다. 또한 쉽게 책을 접할 수 있도록 그림과 삽화를 삽입하였다.',3.9,'1','http://gdimg.gmarket.co.kr/goods_image2/shop_img/339/298/339298080.jpg',37,'생능출판사',8),('109','예제가 가득한 Java 프로그래밍','예제가 가득한 프로그래밍 시리즈. Java에서 프로그래밍할 때 \'정말 필요한 지식과 테크닉\'을 목적별로 정리한 책이다. ',3.6,'1','http://image.aladin.co.kr/product/6618/62/cover/8956746389_1.jpg',13,'정보문화사',13),('201','LG전자 드럼세탁기 빅인','LG전자 고유 기술인 다이렉트 드라이브 모터로 구현하는 6모션 기능도 적용.',4.7,'2','http://image.newstomato.com/newsimg/2010/4/12/88138/1.jpg',10,'LG전자',5),('202','삼성전자 버블샷2 드럼세탁기','강력한 DD모터가 탁월한 세탁력과 헹굼력을 제공합니다. 생활에 꼭 필요한 세탁기',4.5,'2','http://image.auction.co.kr/itemimage/d5/53/18/d553186e5.jpg',10,'삼성전자',11),('203','삼성 프렌치도어 냉장고','냉장고 친환경 포장은 수 십회 이상 재사용이 가능하며 99.7%의 휘발성 유기화합물과 연간 7천톤의 CO를 줄여 국내외 친환경성을 인정 ',4.3,'2','http://img.kr.news.samsung.com/kr/wp-content/uploads/2013/01/RF323TEDBSR_2_1.jpg',15,'삼성전자',10),('204','DIOS V9100 4도어냉장고','LG 디오스 4도어 냉장고 906L_[F918S11 메탈퓨어]/상냉장/하냉동 대용량 냉장고',4.7,'2','http://image.gsshop.com/mi09/deal/dealno/206/20160502173627332273.jpg',12,'LG전자',7),('205','LG전자 싸이킹 청소기','무선으로 자유롭게, 스마트 인버터 모터로 강력하게 오래오래 ',4.3,'2','http://www.lge.co.kr/lgekor/asset/images/web/productList/thumbs/thumb38.png',23,'LG전자',10),('206','삼성전자, 청소기 모션싱크','\'피라미드 구조의 캠버드 휠\'을 채용해 급작스런 방향 전환에도 중심을 잃고 넘어지지 않는다.',4.4,'2','http://img.danawa.com/cms/img/2013/07/01/1372645045_thumb.jpg',22,'삼성전자',20),('207','쿠쿠 압력밥솥 CRP-P0610FD','Full 스테인리스 커버로 위생적인 사용과 관리 가능,2중 모션 패킹 밀착으로 샐 틈없는 밥맛',4.7,'2','http://img3.coupangcdn.com/image/vendor_inventory/images/2016/05/17/11/2/9d0d923c-fe18-46eb-b9e8-7f86e1a331b9.jpg',30,'쿠쿠',21),('208','웅진코웨이 CHP-481L','살균케어,탱크세척,필터세척 서비스/스페셜 케어 서비스 제공 3단 맞춤온수 시스템,RO 멤브레인 필터 시스템',4.4,'2','http://www.coway.co.kr/UploadFiles/attach/PRODUCT/ATTACH_MALL/th_CHP-340N.jpg',21,'웅진코웨이',10),('209','청소기 스마트 탱고','부드러운 유선형 주행,미세 먼지까지 청소하는 강력한 흡입, 흡착력!',3.9,'2','http://gdimg.gmarket.co.kr/goods_image2/shop_img/504/152/504152516.jpg',31,'삼성전자',13),('30070349','임경호컴패니','야미 상품 설명입니다.',0,'1','https://ncache.ilbe.com/files/attach/new/20130126/14357299/627667423/707713717/6d07be440729f9fa40656fc37821cf09.jpg',1,'임경호컴패니',1),('8801056049881','스페셜K','제형 리퀴드, 종류 파운데이션, 제품구성 본품, 제품 특징 자외선차단, 지속력, 커버력, 밀착력 사용 효과',2.3333333333333335,'7','http://www.dior.com/beauty/version-5.1432748111895/resize-image/ep/0/390/100/0/v6_packshots_pdg%252FPDG_Y0578850-F057885020.jpg',9,'농심',5);
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

-- Dump completed on 2016-06-01 11:18:03
