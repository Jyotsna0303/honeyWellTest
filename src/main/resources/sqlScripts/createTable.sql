CREATE DATABASE  IF NOT EXISTS `honeywell_employee_tracker`;
USE `honeywell_employee_tracker`;

DROP TABLE IF EXISTS `Employee`;

CREATE TABLE `Employee` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  `Age` int DEFAULT NULL,
  `Gender` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1;
