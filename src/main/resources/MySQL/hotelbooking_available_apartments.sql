-- MySQL dump 10.13  Distrib 5.7.25, for Linux (x86_64)
--
-- Host: localhost    Database: hotelbooking
-- ------------------------------------------------------
-- Server version	5.7.25-0ubuntu0.16.04.2

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
-- Table structure for table `available_apartments`
--

DROP TABLE IF EXISTS `available_apartments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `available_apartments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_hotel` int(11) NOT NULL,
  `id_apartment_type_number` int(11) NOT NULL,
  `id_apartment_category` int(11) NOT NULL,
  `id_apartment_price` int(11) NOT NULL,
  `apartment_number` int(11) NOT NULL,
  `available` tinyint(1) NOT NULL,
  `date_from` timestamp NULL DEFAULT NULL,
  `date_to` timestamp NULL DEFAULT NULL,
  `id_additional_apartments_service` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7ckj78xehr4bsp580xes05vfc` (`id_additional_apartments_service`),
  KEY `FKbi5a3hu0g8nr7f80ns5dviw4b` (`id_apartment_price`),
  KEY `FKobtgvcy2finlc1ndl0dhfcg5i` (`id_apartment_type_number`),
  KEY `FK1vk6acers33phprvi1osd3ao6` (`id_apartment_category`),
  KEY `FKpsvdj2vnkjwb6aklp1h94823q` (`id_hotel`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `available_apartments`
--

LOCK TABLES `available_apartments` WRITE;
/*!40000 ALTER TABLE `available_apartments` DISABLE KEYS */;
INSERT INTO `available_apartments` VALUES (1,1,1,1,1,102,0,'2018-12-31 22:00:00','2019-01-01 22:00:00',1),(2,2,1,1,2,103,1,'2018-12-31 22:00:00','2019-01-01 22:00:00',1),(3,1,2,2,3,104,1,'2018-12-31 22:00:00','2019-01-01 22:00:00',1),(4,2,2,2,4,101,1,'2018-12-31 22:00:00','2019-01-01 22:00:00',1),(5,3,3,3,5,105,1,'2018-12-31 22:00:00','2019-01-01 22:00:00',1),(6,3,1,1,6,106,1,'2018-12-31 22:00:00','2019-01-01 22:00:00',1),(7,1,1,1,1,102,1,'2019-01-01 22:00:00','2019-01-02 22:00:00',1),(8,1,1,1,1,102,1,'2019-01-02 22:00:00','2019-01-03 22:00:00',1),(9,1,1,1,1,102,1,'2019-01-03 22:00:00','2019-01-04 22:00:00',1),(10,2,1,1,2,103,1,'2019-01-01 22:00:00','2019-01-02 22:00:00',1),(11,2,1,1,2,103,1,'2019-01-02 22:00:00','2019-01-03 22:00:00',1),(12,2,1,1,2,103,1,'2019-01-03 22:00:00','2019-01-04 22:00:00',1),(13,1,2,2,3,104,1,'2019-01-01 22:00:00','2019-01-02 22:00:00',1),(14,1,2,2,3,104,1,'2019-01-02 22:00:00','2019-01-03 22:00:00',1),(15,3,3,3,5,105,0,'2019-01-01 22:00:00','2019-01-02 22:00:00',1),(16,3,3,3,5,105,1,'2019-01-02 22:00:00','2019-01-03 22:00:00',1),(17,3,3,3,5,105,1,'2019-01-03 22:00:00','2019-01-04 22:00:00',1),(18,3,1,1,6,106,1,'2019-01-01 22:00:00','2019-01-02 22:00:00',1),(19,3,1,1,6,106,1,'2019-01-02 22:00:00','2019-01-03 22:00:00',1),(20,3,1,1,6,106,0,'2019-01-03 22:00:00','2019-01-04 22:00:00',1);
/*!40000 ALTER TABLE `available_apartments` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-23 23:52:09
