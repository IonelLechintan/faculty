-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: students
-- ------------------------------------------------------
-- Server version	5.1.43-community

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
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `courseId` varchar(60) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `noOfStudents` int(11) DEFAULT '0',
  PRIMARY KEY (`courseId`),
  UNIQUE KEY `courseId` (`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES ('1','Fizica',0),('93724376-0c9e-4487-8551-0a0c92abaf8a','Algebra',0),('c231f362-89f6-404e-baa9-ebe57fab7184','Chimie',1),('d4531056-9215-42e7-9a2e-4ba3780c94f2','Logica',1),('d65f6f68-3ea4-45b8-8aeb-fbf7b6a60ddc','Aritmetica',1),('sdfsdfsdg4314fb5','Programare',0);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participants`
--

DROP TABLE IF EXISTS `participants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `participants` (
  `participantId` varchar(60) NOT NULL,
  `studentId` varchar(60) DEFAULT NULL,
  `courseId` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`participantId`),
  UNIQUE KEY `studentId` (`studentId`,`courseId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participants`
--

LOCK TABLES `participants` WRITE;
/*!40000 ALTER TABLE `participants` DISABLE KEYS */;
INSERT INTO `participants` VALUES ('c1ba1abc-b398-47f1-afd7-e09748a73454','e46053f7-0a56-4c51-8954-262ff249d91c','c231f362-89f6-404e-baa9-ebe57fab7184'),('224cdd15-922c-493c-9f8a-bf007d77a5c6','e46053f7-0a56-4c51-8954-262ff249d91c','d4531056-9215-42e7-9a2e-4ba3780c94f2'),('e2547a7b-78f9-4345-b64c-e83baa5dcf16','e46053f7-0a56-4c51-8954-262ff249d91c','d65f6f68-3ea4-45b8-8aeb-fbf7b6a60ddc');
/*!40000 ALTER TABLE `participants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `studentId` varchar(60) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `registrationNo` int(20) NOT NULL,
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`studentId`),
  UNIQUE KEY `studentId` (`studentId`),
  UNIQUE KEY `registrationNo` (`registrationNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('118d5646-d4e9-48bc-aae3-e0414810f6e0','lechintan ionel',11,1),('19c55b95-ebb1-45c5-acca-5e599cf619e3','balea',1221,0),('1e39b7ee-68b5-4682-8025-a6f681fc271e','mihai',12021,0),('e46053f7-0a56-4c51-8954-262ff249d91c','lechintan ionel',411,0);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-05 14:33:45
