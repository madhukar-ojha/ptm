-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.20-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5937
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for ptm
DROP DATABASE IF EXISTS `ptm`;
CREATE DATABASE IF NOT EXISTS `ptm_new` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ptm_new`;

-- Dumping structure for table ptm_new.action
DROP TABLE IF EXISTS `Action`;
CREATE TABLE IF NOT EXISTS `Action` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `actionName` varchar(50) NOT NULL,
  `actionKey` varchar(50) NOT NULL,
  `actionType` varchar(50) NOT NULL,
  `isActive` tinyint(1) unsigned NOT NULL,
  `isDeleted` tinyint(1) unsigned NOT NULL,
  `createdBy` smallint(5) unsigned NOT NULL,
  `createdOn` date NOT NULL,
  `updatedBy` smallint(5) unsigned DEFAULT NULL,
  `updatedOn` date DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK_action_createdBy` (`createdBy`),
  KEY `FK_action_updatedBy` (`updatedBy`),
  CONSTRAINT `FK_action_createdBy` FOREIGN KEY (`createdBy`) REFERENCES `User` (`id`),
  CONSTRAINT `FK_action_updatedBy` FOREIGN KEY (`updatedBy`) REFERENCES `User` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- Dumping data for table ptm_new.Action: ~4 rows (approximately)
DELETE FROM `Action`;
/*!40000 ALTER TABLE `Action` DISABLE KEYS */;
INSERT INTO `Action` (`id`, `actionName`, `actionKey`, `actionType`, `isActive`, `isDeleted`, `createdBy`, `createdOn`, `updatedBy`, `updatedOn`) VALUES
	(10, 'Add', 'action.add', 'button', 1, 0, 100, '2020-04-10', NULL, NULL),
	(11, 'Update', 'action.update', 'button', 1, 0, 100, '2020-04-10', NULL, NULL),
	(12, 'Delete', 'action.delete', 'button', 1, 0, 100, '2020-04-10', NULL, NULL),
	(13, 'Search', 'action.search', 'button', 1, 0, 100, '2020-04-10', NULL, NULL);
/*!40000 ALTER TABLE `Action` ENABLE KEYS */;

-- Dumping structure for table ptm_new.department
DROP TABLE IF EXISTS `Department`;
CREATE TABLE IF NOT EXISTS `Department` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `description` varchar(50) NOT NULL DEFAULT '',
  `createdBy` smallint(5) unsigned NOT NULL,
  `createdOn` date NOT NULL,
  `updatedBy` smallint(5) unsigned DEFAULT NULL,
  `updatedOn` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_dept_creatdeBy` (`createdBy`),
  KEY `FK_dept_updatdeBy` (`updatedBy`),
  CONSTRAINT `FK_dept_creatdeBy` FOREIGN KEY (`createdBy`) REFERENCES `User` (`id`),
  CONSTRAINT `FK_dept_updatdeBy` FOREIGN KEY (`updatedBy`) REFERENCES `User` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- Dumping data for table ptm_new.Department: ~4 rows (approximately)
DELETE FROM `Department`;
/*!40000 ALTER TABLE `Department` DISABLE KEYS */;
INSERT INTO `Department` (`id`, `name`, `description`, `createdBy`, `createdOn`, `updatedBy`, `updatedOn`) VALUES
	(10, 'Management', 'Manages all staff', 100, '2020-04-10', NULL, NULL),
	(11, 'HR', 'Human resources', 100, '2020-04-10', NULL, NULL),
	(12, 'Sales', 'Sales n Marketing', 100, '2020-04-10', NULL, NULL),
	(13, 'Technology', 'Applicaion Development', 100, '2020-04-10', NULL, NULL);
/*!40000 ALTER TABLE `Department` ENABLE KEYS */;

-- Dumping structure for table ptm_new.menu
DROP TABLE IF EXISTS `Menu`;
CREATE TABLE IF NOT EXISTS `Menu` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `menuName` varchar(50) NOT NULL,
  `menuKey` varchar(50) NOT NULL DEFAULT '',
  `menuType` varchar(50) NOT NULL DEFAULT '',
  `isActive` tinyint(1) unsigned NOT NULL,
  `isDeleted` tinyint(1) unsigned NOT NULL,
  `createdBy` smallint(5) unsigned NOT NULL,
  `createdOn` date NOT NULL,
  `updatedBy` smallint(5) unsigned DEFAULT NULL,
  `updatedOn` date DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `FK_menu_created_by` (`createdBy`),
  KEY `FK_menu_updatedBy` (`updatedBy`),
  CONSTRAINT `FK_menu_created_by` FOREIGN KEY (`createdBy`) REFERENCES `User` (`id`),
  CONSTRAINT `FK_menu_updatedBy` FOREIGN KEY (`updatedBy`) REFERENCES `User` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- Dumping data for table ptm_new.Menu: ~3 rows (approximately)
DELETE FROM `Menu`;
/*!40000 ALTER TABLE `Menu` DISABLE KEYS */;
INSERT INTO `Menu` (`id`, `menuName`, `menuKey`, `menuType`, `isActive`, `isDeleted`, `createdBy`, `createdOn`, `updatedBy`, `updatedOn`) VALUES
	(10, 'Client', 'menu.client', 'link', 1, 0, 100, '2020-04-10', NULL, NULL),
	(11, 'Project', 'menu.project', 'link', 1, 0, 100, '2020-04-10', NULL, NULL),
	(12, 'Employee', 'menu.employee', 'link', 1, 0, 100, '2020-04-10', NULL, NULL);
/*!40000 ALTER TABLE `Menu` ENABLE KEYS */;

-- Dumping structure for table ptm_new.MenuAction
DROP TABLE IF EXISTS `MenuAction`;
CREATE TABLE IF NOT EXISTS `MenuAction` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `menu_id` smallint(5) unsigned NOT NULL,
  `action_id` smallint(5) unsigned NOT NULL COMMENT 'It defines order of roles starting top roles to bottom. 1 is top most and descinding.',
  `isActive` tinyint(1) unsigned NOT NULL,
  `isDeleted` tinyint(1) unsigned NOT NULL,
  `createdBy` smallint(5) unsigned NOT NULL,
  `createdOn` date NOT NULL,
  `updatedBy` smallint(5) unsigned DEFAULT NULL,
  `updatedOn` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_menuaction_creatdeBy` (`createdBy`),
  KEY `FK_menuaction_updatdeBy` (`updatedBy`),
  KEY `FK_menu_action_menu_id` (`menu_id`),
  KEY `FK_menuaction_action_id` (`action_id`),
  CONSTRAINT `FK_menuaction_creatdeBy` FOREIGN KEY (`createdBy`) REFERENCES `User` (`id`),
  CONSTRAINT `FK_menuaction_updatdeBy` FOREIGN KEY (`updatedBy`) REFERENCES `User` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

-- Dumping data for table ptm_new.MenuAction: ~13 rows (approximately)
DELETE FROM `MenuAction`;
/*!40000 ALTER TABLE `MenuAction` DISABLE KEYS */;
INSERT INTO `MenuAction` (`id`, `menu_id`, `action_id`, `isActive`, `isDeleted`, `createdBy`, `createdOn`, `updatedBy`, `updatedOn`) VALUES
	(10, 10, 10, 1, 0, 100, '2020-04-10', NULL, NULL),
	(11, 10, 11, 1, 0, 100, '2020-04-10', NULL, NULL),
	(12, 10, 12, 1, 0, 100, '2020-04-10', NULL, NULL),
	(13, 10, 13, 1, 0, 100, '2020-04-10', NULL, NULL),
	(14, 11, 10, 1, 0, 100, '2020-04-10', NULL, NULL),
	(15, 11, 11, 1, 0, 100, '2020-04-10', NULL, NULL),
	(16, 11, 12, 1, 0, 100, '2020-04-10', NULL, NULL),
	(17, 11, 13, 1, 0, 100, '2020-04-10', NULL, NULL),
	(18, 12, 10, 1, 0, 100, '2020-04-10', NULL, NULL),
	(19, 12, 11, 1, 0, 100, '2020-04-10', NULL, NULL),
	(20, 12, 12, 1, 0, 100, '2020-04-10', NULL, NULL),
	(21, 12, 13, 1, 0, 100, '2020-04-10', NULL, NULL),
	(22, 12, 13, 1, 0, 100, '2020-04-10', NULL, NULL);
/*!40000 ALTER TABLE `MenuAction` ENABLE KEYS */;

-- Dumping structure for table ptm_new.Role
DROP TABLE IF EXISTS `Role`;
CREATE TABLE IF NOT EXISTS `Role` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `department_id` smallint(5) unsigned NOT NULL,
  `hierarchy` varchar(50) NOT NULL DEFAULT '' COMMENT 'It defines order of roles starting top roles to bottom. 1 is top most and descinding.',
  `description` varchar(50) DEFAULT NULL,
  `isActive` tinyint(1) unsigned NOT NULL,
  `isDeleted` tinyint(1) unsigned NOT NULL,
  `createdBy` smallint(5) unsigned NOT NULL,
  `createdOn` date NOT NULL,
  `updatedBy` smallint(5) unsigned DEFAULT NULL,
  `updatedOn` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_role_createdBy` (`createdBy`),
  KEY `FK_role_updatedBy` (`updatedBy`),
  KEY `FK_role_deptt` (`department_id`) USING BTREE,
  CONSTRAINT `FK_role_createdBy` FOREIGN KEY (`createdBy`) REFERENCES `User` (`id`),
  CONSTRAINT `FK_role_department_id` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`),
  CONSTRAINT `FK_role_updatedBy` FOREIGN KEY (`updatedBy`) REFERENCES `User` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

-- Dumping data for table ptm_new.Role: ~14 rows (approximately)
DELETE FROM `Role`;
/*!40000 ALTER TABLE `Role` DISABLE KEYS */;
INSERT INTO `Role` (`id`, `name`, `department_id`, `hierarchy`, `description`, `isActive`, `isDeleted`, `createdBy`, `createdOn`, `updatedBy`, `updatedOn`) VALUES
	(10, 'Super User', 10, '1', 'Management', 1, 0, 100, '2020-04-09', NULL, NULL),
	(11, 'Director', 10, '2', 'Management', 1, 0, 100, '2020-04-09', NULL, NULL),
	(12, 'Manager', 11, '3', 'HR', 1, 0, 100, '2020-04-09', NULL, NULL),
	(13, 'Manager', 12, '3', 'Sales', 1, 0, 100, '2020-04-09', NULL, NULL),
	(14, 'Manager', 10, '3', 'Management', 1, 0, 100, '2020-04-09', NULL, NULL),
	(15, 'Manager', 13, '3', 'Technology', 1, 0, 100, '2020-04-09', NULL, NULL),
	(16, 'Team Leader', 12, '4', 'Sales', 1, 0, 100, '2020-04-09', NULL, NULL),
	(17, 'Team Leader', 13, '4', 'Technology', 1, 0, 100, '2020-04-09', NULL, NULL),
	(18, 'Senior Executive', 11, '4', 'HR', 1, 0, 100, '2020-04-09', NULL, NULL),
	(19, 'Senior Executive', 10, '4', 'Management', 1, 0, 100, '2020-04-09', NULL, NULL),
	(20, 'Senior Software Engineer', 13, '5', 'Technology', 1, 0, 100, '2020-04-09', NULL, NULL),
	(21, 'Software Engineer', 13, '6', 'Technology', 1, 0, 100, '2020-04-09', NULL, NULL),
	(22, 'Executive', 11, '6', 'HR', 1, 0, 100, '2020-04-09', NULL, NULL),
	(23, 'Executive', 12, '6', 'Sales', 1, 0, 100, '2020-04-09', NULL, NULL);
/*!40000 ALTER TABLE `Role` ENABLE KEYS */;

-- Dumping structure for table ptm_new.RoleMenuAction
DROP TABLE IF EXISTS `RoleMenuAction`;
CREATE TABLE IF NOT EXISTS `RoleMenuAction` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` smallint(5) unsigned NOT NULL COMMENT 'It defines order of roles starting top roles to bottom. 1 is top most and descinding.',
  `menuAction_id` smallint(5) unsigned NOT NULL,
  `isActive` tinyint(1) unsigned NOT NULL,
  `isDeleted` tinyint(1) unsigned NOT NULL,
  `createdBy` smallint(5) unsigned NOT NULL,
  `createdOn` date NOT NULL,
  `updatedBy` smallint(5) unsigned DEFAULT NULL,
  `updatedOn` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_rma_createdBy` (`createdBy`),
  KEY `FK_rma_updatedBy` (`updatedBy`),
  KEY `FK_rma_menuActionId` (`menuAction_id`) USING BTREE,
  KEY `FK_rma_roleId` (`role_id`) USING BTREE,
  CONSTRAINT `FK_rma_createdBy` FOREIGN KEY (`createdBy`) REFERENCES `User` (`id`),
  CONSTRAINT `FK_rma_menuAction_id` FOREIGN KEY (`menuAction_id`) REFERENCES `menu_action` (`id`),
  CONSTRAINT `FK_rma_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK_rma_updatedBy` FOREIGN KEY (`updatedBy`) REFERENCES `User` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

-- Dumping data for table ptm_new.RoleMenuAction: ~22 rows (approximately)
DELETE FROM `RoleMenuAction`;
/*!40000 ALTER TABLE `RoleMenuAction` DISABLE KEYS */;
INSERT INTO `RoleMenuAction` (`id`, `role_id`, `menuAction_id`, `isActive`, `isDeleted`, `createdBy`, `createdOn`, `updatedBy`, `updatedOn`) VALUES
	(1, 11, 10, 1, 0, 100, '2020-04-10', NULL, NULL),
	(2, 11, 11, 1, 0, 100, '2020-04-10', NULL, NULL),
	(3, 11, 13, 1, 0, 100, '2020-04-10', NULL, NULL),
	(5, 12, 18, 1, 0, 100, '2020-04-10', NULL, NULL),
	(6, 12, 19, 1, 0, 100, '2020-04-10', NULL, NULL),
	(7, 12, 20, 1, 0, 100, '2020-04-10', NULL, NULL),
	(8, 12, 21, 1, 0, 100, '2020-04-10', NULL, NULL),
	(9, 13, 10, 1, 0, 100, '2020-04-10', NULL, NULL),
	(10, 13, 11, 1, 0, 100, '2020-04-10', NULL, NULL),
	(11, 13, 12, 1, 0, 100, '2020-04-10', NULL, NULL),
	(12, 13, 13, 1, 0, 100, '2020-04-10', NULL, NULL),
	(13, 13, 14, 1, 0, 100, '2020-04-10', NULL, NULL),
	(14, 13, 15, 1, 0, 100, '2020-04-10', NULL, NULL),
	(15, 13, 16, 1, 0, 100, '2020-04-10', NULL, NULL),
	(16, 13, 17, 1, 0, 100, '2020-04-10', NULL, NULL),
	(17, 16, 10, 1, 0, 100, '2020-04-10', NULL, NULL),
	(18, 16, 11, 1, 0, 100, '2020-04-10', NULL, NULL),
	(19, 16, 13, 1, 0, 100, '2020-04-10', NULL, NULL),
	(20, 18, 18, 1, 0, 100, '2020-04-10', NULL, NULL),
	(21, 18, 19, 1, 0, 100, '2020-04-10', NULL, NULL),
	(22, 18, 20, 1, 0, 100, '2020-04-10', NULL, NULL),
	(23, 18, 21, 1, 0, 100, '2020-04-10', NULL, NULL);
/*!40000 ALTER TABLE `RoleMenuAction` ENABLE KEYS */;

-- Dumping structure for table ptm_new.User
DROP TABLE IF EXISTS `User`;
CREATE TABLE IF NOT EXISTS `User` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT COMMENT 'User id',
  `firstName` varchar(50) NOT NULL,
  `middleName` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) NOT NULL,
  `nickName` varchar(50) DEFAULT NULL,
  `displayName` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role_id` smallint(5) unsigned NOT NULL,
  `manager_id` smallint(5) unsigned NOT NULL,
  `dateOfBirth` date NOT NULL,
  `fatherName` varchar(50) NOT NULL,
  `motherName` varchar(50) NOT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `pincode` mediumint(8) unsigned NOT NULL,
  `country` varchar(50) NOT NULL,
  `isActive` tinyint(1) unsigned NOT NULL,
  `isDeleted` tinyint(1) unsigned NOT NULL,
  `createdBy` smallint(5) unsigned NOT NULL,
  `createdOn` date NOT NULL,
  `updatedBy` smallint(5) unsigned DEFAULT NULL,
  `updatedOn` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user_createdBy` (`createdBy`),
  KEY `FK_user_updatedBy` (`updatedBy`),
  KEY `FK_user_role` (`role_id`) USING BTREE,
  KEY `FK_user_user` (`manager_id`) USING BTREE,
  CONSTRAINT `FK_user_createdBy` FOREIGN KEY (`createdBy`) REFERENCES `User` (`id`),
  CONSTRAINT `FK_User_manager_id` FOREIGN KEY (`manager_id`) REFERENCES `User` (`id`),
  CONSTRAINT `FK_User_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK_User_updatedBy` FOREIGN KEY (`updatedBy`) REFERENCES `User` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=latin1 COMMENT='It stores User personal details.';

-- Dumping data for table ptm_new.User: ~3 rows (approximately)
DELETE FROM `User`;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` (`id`, `firstName`, `middleName`, `lastName`, `nickName`, `displayName`, `password`, `role_id`, `manager_id`, `dateOfBirth`, `fatherName`, `motherName`, `phone`, `mobile`, `email`, `address`, `pincode`, `country`, `isActive`, `isDeleted`, `createdBy`, `createdOn`, `updatedBy`, `updatedOn`) VALUES
	(100, 'Madhukar', NULL, 'Ojha', 'Gopal', 'Madhukar Ojha', 'su', 10, 100, '1976-07-20', 'Madan Gopal Ojha', 'Bibha Ojha', NULL, '+91-9999889811', 'madhukar.ojha27@gmail.com', '2nd floor HN-240, Sector 30 Faridabad', 110092, 'India', 1, 0, 100, '2020-04-09', NULL, NULL),
	(101, 'Murli', 'Manohar', 'Ojha', 'bhola', 'Murli Ojha', 'murli', 12, 100, '1980-06-05', 'Madan Gopal Ojha', 'Bibha Ojha', NULL, '+919871725234', 'aadi.ojha@gmail.com', '2nd floor HN-240, Sector 30 Faridabad', 110092, 'India', 1, 0, 100, '2020-04-10', NULL, NULL),
	(102, 'Atul', 'Kumar', 'Ojha', 'atul', 'Atul Ojha', 'atul', 13, 101, '1980-07-01', 'Madan Gopal Ojha', 'Bibha Ojha', NULL, '+919871725234', 'atul.ojha@gmail.com', '2nd floor HN-240, Sector 30 Faridabad', 110085, 'India', 1, 0, 101, '2020-04-11', NULL, NULL);
/*!40000 ALTER TABLE `User` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
