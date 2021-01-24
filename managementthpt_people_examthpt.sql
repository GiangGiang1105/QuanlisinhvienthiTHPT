-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: managementthpt
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `people_examthpt`
--

DROP TABLE IF EXISTS `people_examthpt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `people_examthpt` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hoten` varchar(45) DEFAULT NULL,
  `gioitinh` varchar(45) DEFAULT NULL,
  `ngaysinh` varchar(45) DEFAULT NULL,
  `diachi` varchar(45) DEFAULT NULL,
  `khuvuc` int(11) DEFAULT NULL,
  `doituong` varchar(45) DEFAULT NULL,
  `khoithi` varchar(45) DEFAULT NULL,
  `truong` varchar(45) DEFAULT NULL,
  `diemtong` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `people_examthpt`
--

LOCK TABLES `people_examthpt` WRITE;
/*!40000 ALTER TABLE `people_examthpt` DISABLE KEYS */;
INSERT INTO `people_examthpt` VALUES (2,'Nguyễn B','Nu','2-1-1980','Đà Nẵng',1,'Bình thường','Khối A','ABC',30),(3,'Nguyễn','Nam','1-1-1980','cebeb',1,'Bình thường','Khối A','cevr',40),(4,'Nguyễn Van C','Nam','1-1-1980','1',1,'Bình thường','Khối A','Khối A',30),(5,'Nguyễn','Nữ','1-1-1980','cebeb',1,'Bình thường','Khối A','cevrdfcgjk',40);
/*!40000 ALTER TABLE `people_examthpt` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-24 16:44:43
