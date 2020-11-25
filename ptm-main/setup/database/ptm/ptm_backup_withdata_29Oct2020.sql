-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.20-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5989
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for ptm
CREATE DATABASE IF NOT EXISTS `ptm` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `ptm`;

-- Dumping structure for table ptm.department
CREATE TABLE IF NOT EXISTS `department` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(50) NOT NULL DEFAULT '',
  `enabled` enum('true','false') NOT NULL DEFAULT 'true',
  `deleted` enum('true','false') NOT NULL DEFAULT 'false',
  `createdBy` int(6) unsigned NOT NULL,
  `createdOn` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedBy` int(6) unsigned DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_dept_creatdeBy` (`createdBy`),
  KEY `FK_dept_updatdeBy` (`updatedBy`),
  CONSTRAINT `FK23isp6r45djhgrrulwcovt220` FOREIGN KEY (`createdBy`) REFERENCES `employee` (`id`),
  CONSTRAINT `FK96f6k960h3ghcp6x0onsdaf4q` FOREIGN KEY (`updatedBy`) REFERENCES `employee` (`id`),
  CONSTRAINT `FK_department_createdBy` FOREIGN KEY (`createdBy`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_department_updatedBy` FOREIGN KEY (`updatedBy`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1 COMMENT='This table contains department names.';

-- Dumping data for table ptm.department: ~5 rows (approximately)
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
REPLACE INTO `department` (`id`, `name`, `description`, `enabled`, `deleted`, `createdBy`, `createdOn`, `updatedBy`, `updatedOn`) VALUES
	(10, 'Management', 'Manages all staff', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(11, 'HR', 'Human resources', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(12, 'Sales', 'Sales n Marketing', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(13, 'Technology', 'Applicaion Development', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(14, 'IT', 'Networking, software, hardware and architecture', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;

-- Dumping structure for table ptm.designation
CREATE TABLE IF NOT EXISTS `designation` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int(6) unsigned NOT NULL,
  `role_name` varchar(50) NOT NULL,
  `department_id` int(6) unsigned NOT NULL,
  `department_name` varchar(50) NOT NULL,
  `designationName` varchar(50) GENERATED ALWAYS AS (concat(`role_name`,' ',`department_name`)) VIRTUAL,
  `hierarchy` int(6) unsigned NOT NULL,
  `description` varchar(50) NOT NULL DEFAULT '',
  `enabled` enum('true','false') NOT NULL DEFAULT 'true',
  `deleted` enum('true','false') NOT NULL DEFAULT 'false',
  `createdBy` int(6) unsigned NOT NULL,
  `createdOn` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedBy` int(6) unsigned DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_id_department_id` (`role_id`,`department_id`),
  UNIQUE KEY `UKpu353je5cjqhh75wh0tvkdupe` (`role_id`,`department_id`),
  KEY `FKkvn6d0gtb22cgsaiey3iko67x` (`createdBy`),
  KEY `FK8yglks43pah88vlfy22jg2ucj` (`department_id`),
  KEY `FKjtgi6fjrnn7dabvx0wufoco3a` (`updatedBy`),
  CONSTRAINT `FK8yglks43pah88vlfy22jg2ucj` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`),
  CONSTRAINT `FK_designation_createdBy` FOREIGN KEY (`createdBy`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_designation_department_id` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_designation_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_designation_updatedBy` FOREIGN KEY (`updatedBy`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKjtgi6fjrnn7dabvx0wufoco3a` FOREIGN KEY (`updatedBy`) REFERENCES `employee` (`id`),
  CONSTRAINT `FKkvn6d0gtb22cgsaiey3iko67x` FOREIGN KEY (`createdBy`) REFERENCES `employee` (`id`),
  CONSTRAINT `FKp84k4ijpdy008bsbonubndvfw` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1 COMMENT='It sets relationship between role and department.';

-- Dumping data for table ptm.designation: ~21 rows (approximately)
/*!40000 ALTER TABLE `designation` DISABLE KEYS */;
REPLACE INTO `designation` (`id`, `role_id`, `role_name`, `department_id`, `department_name`, `designationName`, `hierarchy`, `description`, `enabled`, `deleted`, `createdBy`, `createdOn`, `updatedBy`, `updatedOn`) VALUES
	(10, 11, 'CEO', 10, 'Management', 'CEO Management', 1, '', 'true', 'false', 100, '2020-04-23 00:00:00', NULL, NULL),
	(11, 12, 'Director', 10, 'Management', 'Director Management', 2, '', 'true', 'false', 100, '2020-04-23 00:00:00', NULL, NULL),
	(12, 12, 'Director', 11, 'HR', 'Director HR', 2, '', 'true', 'false', 100, '2020-04-23 00:00:00', NULL, NULL),
	(13, 12, 'Director', 12, 'Sales', 'Director Sales', 2, '', 'true', 'false', 100, '2020-04-23 00:00:00', NULL, NULL),
	(14, 12, 'Director', 13, 'Technology', 'Director Technology', 2, '', 'true', 'false', 100, '2020-04-23 00:00:00', NULL, NULL),
	(15, 13, 'Manager', 10, 'Management', 'Manager Management', 3, '', 'true', 'false', 100, '2020-04-23 00:00:00', NULL, NULL),
	(16, 13, 'Manager', 11, 'HR', 'Manager HR', 3, '', 'true', 'false', 100, '2020-04-23 00:00:00', NULL, NULL),
	(17, 13, 'Manager', 12, 'Sales', 'Manager Sales', 3, '', 'true', 'false', 100, '2020-04-23 00:00:00', NULL, NULL),
	(18, 13, 'Manager', 13, 'Technology', 'Manager Technology', 3, '', 'true', 'false', 100, '2020-04-23 00:00:00', NULL, NULL),
	(19, 14, 'TL', 12, 'Sales', 'TL Sales', 4, '', 'true', 'false', 100, '2020-04-23 00:00:00', NULL, NULL),
	(20, 14, 'TL', 13, 'Technology', 'TL Technology', 4, '', 'true', 'false', 100, '2020-04-23 00:00:00', NULL, NULL),
	(21, 15, 'Senior Executive', 10, 'Management', 'Senior Executive Management', 5, '', 'true', 'false', 100, '2020-04-23 00:00:00', NULL, NULL),
	(22, 15, 'Senior Executive', 11, 'HR', 'Senior Executive HR', 5, '', 'true', 'false', 100, '2020-04-23 00:00:00', NULL, NULL),
	(23, 15, 'Senior Executive', 12, 'Sales', 'Senior Executive Sales', 5, '', 'true', 'false', 100, '2020-04-23 00:00:00', NULL, NULL),
	(24, 16, 'Sr. soft Engg.', 13, 'Technology', 'Sr. soft Engg. Technology', 5, '', 'true', 'false', 100, '2020-04-23 00:00:00', NULL, NULL),
	(25, 17, 'Soft Engg.', 13, 'Technology', 'Soft Engg. Technology', 6, '', 'true', 'false', 100, '2020-04-23 00:00:00', NULL, NULL),
	(26, 18, 'Executive', 11, 'HR', 'Executive HR', 6, '', 'true', 'false', 100, '2020-04-23 00:00:00', NULL, NULL),
	(27, 18, 'Executive', 12, 'Sales', 'Executive Sales', 6, '', 'true', 'false', 100, '2020-04-23 00:00:00', NULL, NULL),
	(29, 15, 'Sr. Executive', 14, 'IT', 'Sr. Executive IT', 5, '', 'true', 'false', 100, '2020-04-23 00:00:00', NULL, NULL),
	(30, 14, 'TL', 14, 'IT', 'TL IT', 4, '', 'true', 'false', 100, '2020-04-23 00:00:00', NULL, '2020-05-21 17:56:06'),
	(31, 18, 'Executive', 14, 'IT', 'Executive IT', 6, '', 'true', 'false', 100, '2020-04-23 00:00:00', NULL, NULL);
/*!40000 ALTER TABLE `designation` ENABLE KEYS */;

-- Dumping structure for table ptm.employee
CREATE TABLE IF NOT EXISTS `employee` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT COMMENT 'User id',
  `firstName` varchar(50) NOT NULL,
  `middleName` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) NOT NULL,
  `nickName` varchar(50) DEFAULT NULL,
  `displayName` varchar(50) DEFAULT NULL,
  `fullName` varchar(50) DEFAULT NULL,
  `gender` varchar(6) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `designation_id` int(6) unsigned NOT NULL,
  `dateOfBirth` date NOT NULL,
  `fatherName` varchar(50) NOT NULL,
  `motherName` varchar(50) NOT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `pincode` int(6) unsigned NOT NULL,
  `india_state_id` int(6) unsigned NOT NULL,
  `enabled` varchar(50) NOT NULL,
  `disabledReason` varchar(50) DEFAULT NULL,
  `createdBy` int(6) unsigned DEFAULT NULL,
  `createdOn` datetime DEFAULT NULL,
  `updatedBy` int(6) unsigned DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user_createdBy` (`createdBy`),
  KEY `FK_user_updatedBy` (`updatedBy`),
  KEY `FK_user_role` (`designation_id`) USING BTREE,
  KEY `FK10fb48p2qf9yytjvhwmlvnrl5` (`india_state_id`),
  CONSTRAINT `FK10fb48p2qf9yytjvhwmlvnrl5` FOREIGN KEY (`india_state_id`) REFERENCES `india_state` (`id`),
  CONSTRAINT `FK5ip2cshkyu258e5bjmqyjw53u` FOREIGN KEY (`createdBy`) REFERENCES `employee` (`id`),
  CONSTRAINT `FK_employee_createdBy` FOREIGN KEY (`createdBy`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_employee_designation_id` FOREIGN KEY (`designation_id`) REFERENCES `designation` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_employee_india_state_id` FOREIGN KEY (`india_state_id`) REFERENCES `india_state` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_employee_updatedBy` FOREIGN KEY (`updatedBy`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKfml0xcfp4lm64pyjgrsl77yh7` FOREIGN KEY (`updatedBy`) REFERENCES `employee` (`id`),
  CONSTRAINT `FKol9yh6p28atwacprnxacbd2f0` FOREIGN KEY (`designation_id`) REFERENCES `designation` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=latin1 COMMENT='It stores User details.';

-- Dumping data for table ptm.employee: ~6 rows (approximately)
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
REPLACE INTO `employee` (`id`, `firstName`, `middleName`, `lastName`, `nickName`, `displayName`, `fullName`, `gender`, `password`, `designation_id`, `dateOfBirth`, `fatherName`, `motherName`, `phone`, `mobile`, `email`, `address`, `pincode`, `india_state_id`, `enabled`, `disabledReason`, `createdBy`, `createdOn`, `updatedBy`, `updatedOn`) VALUES
	(100, 'Madhukar', '', 'Ojha', 'Gopal', '', '', 'male', 'ptmpwd', 10, '2020-04-06', 'Madan Gopal Ojha', 'Bibha Ojha', '', '+91-9999889811', 'DSDFS@dfsd', '2nd floor HN-240, Sector 30 Faridabad', 110092, 43, '1', NULL, 100, '2020-04-09 00:00:00', 101, '2020-06-08 16:56:31'),
	(101, 'Swapna', 'Avinash', 'Palkar', 'madhu', '', '', 'female', 'ptmpwd', 12, '1984-02-03', 'Avinash Palkar', 'Bibha Palkar', '', '+91-8469099764', 'dfsfds@cxvcvx', 'Bharuch', 110092, 20, '1', NULL, 101, '2020-05-28 17:15:48', 101, '2020-06-08 16:56:58'),
	(102, 'Atul', 'Kumar', 'Ojha', 'atul', '', '', 'female', 'ptmpwd', 29, '1980-07-01', 'Madan Gopal Ojha', 'Bibha Ojha', '', '9871725234', 'atul.ojha@gmail.com', 'Faridabad', 110093, 21, '0', NULL, 101, '2020-05-11 00:00:00', 101, '2020-06-08 16:57:06'),
	(109, 'e', 'e', 'e', 'e', NULL, NULL, 'female', 'Welcome@123', 13, '2020-06-07', 'e', 'e', 'e', 'e', 'e@d', 'd', 222222, 12, '0', NULL, 101, '2020-06-08 15:57:52', 100, '2020-06-08 16:04:43'),
	(110, 'h', '', 'h', 'h', NULL, NULL, 'male', 'Welcome@123', 19, '2020-06-22', 'h', 'h', 'h', 'h', 'h@d', 'd', 333333, 13, '0', NULL, 101, '2020-06-08 16:07:30', 101, '2020-06-08 17:24:26'),
	(111, 'a', 'a', 'a', 'a', NULL, NULL, 'male', 'Welcome@123', 16, '2020-06-08', 'a', 'a', 'a', 'a', 'a@a', 'a', 111111, 19, '1', NULL, 101, '2020-06-08 17:11:49', NULL, NULL);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;

-- Dumping structure for table ptm.india_state
CREATE TABLE IF NOT EXISTS `india_state` (
  `id` int(10) unsigned NOT NULL,
  `name` varchar(50) NOT NULL,
  `capital` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table ptm.india_state: ~36 rows (approximately)
/*!40000 ALTER TABLE `india_state` DISABLE KEYS */;
REPLACE INTO `india_state` (`id`, `name`, `capital`) VALUES
	(10, 'Andaman Nicobar', 'Port Blair'),
	(11, 'Andhra Pradesh', 'Amaravati'),
	(12, 'Arunachal Pradesh', 'Itanagar'),
	(13, 'Assam', 'Dispur'),
	(14, 'Bihar', 'Patna'),
	(15, 'Chandigarh', 'Chandigarh'),
	(16, 'Chhatisgarh', 'Raipur'),
	(17, 'Daman and Diu', 'Daman'),
	(18, 'Delhi NCT', 'New Delhi'),
	(19, 'Goa', 'Panaji'),
	(20, 'Gujarat', 'Gandhinagar'),
	(21, 'Haryana', 'Chandigarh'),
	(22, 'Himachal Pradesh', 'Shimla'),
	(23, 'Jammu Kashmir', 'Srinagar'),
	(24, 'Jharkhand', 'Ranchi'),
	(25, 'Karnataka', 'Bangalore'),
	(26, 'Kerala', 'Thiruvananthapuram'),
	(27, 'Ladakh', 'Leh'),
	(28, 'Lakshadweep', 'Kavaratti'),
	(29, 'Madhya Pradesh', 'Bhopal'),
	(30, 'Maharashtra', 'Mumbai'),
	(31, 'Manipur', 'Imphal'),
	(32, 'Meghalaya', 'Shillong'),
	(33, 'Mizoram', 'Aizawl'),
	(34, 'Nagaland', 'Kohima'),
	(35, 'Odisha', 'Bhubaneswar'),
	(36, 'Puducherry', 'Pondicherry'),
	(37, 'Punjab', 'Chandigarh'),
	(38, 'Rajasthan', 'Jaipur'),
	(39, 'Sikkim', 'Gangtok'),
	(40, 'Tamil Nadu', 'Chennai'),
	(41, 'Telangana', 'Hyderabad'),
	(42, 'Tripura', 'Agartala'),
	(43, 'Uttar  Pradesh', 'Lucknow'),
	(44, 'Uttarakhaand', 'Dehradun'),
	(45, 'West Bengal', 'Kolkata');
/*!40000 ALTER TABLE `india_state` ENABLE KEYS */;

-- Dumping structure for table ptm.menu
CREATE TABLE IF NOT EXISTS `menu` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `menuKey` varchar(50) NOT NULL,
  `menuName` varchar(50) NOT NULL,
  `menuUrl` varchar(50) NOT NULL,
  `menuType` varchar(50) NOT NULL,
  `serialNo` int(10) unsigned NOT NULL,
  `enabled` enum('true','false') NOT NULL DEFAULT 'true',
  `deleted` enum('true','false') NOT NULL DEFAULT 'false',
  `createdBy` int(6) unsigned NOT NULL,
  `createdOn` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedBy` int(6) unsigned DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `menuKey` (`menuKey`),
  UNIQUE KEY `menuUrl` (`menuUrl`),
  UNIQUE KEY `UK8yo7b88w1wglyprsqh24v6tyv` (`menuKey`),
  UNIQUE KEY `UKlor1pjj5ehoqt99musibsmhgm` (`menuUrl`),
  KEY `FK_menu_created_by` (`createdBy`),
  KEY `FK_menu_updatedBy` (`updatedBy`),
  CONSTRAINT `FK6o21pqcp5h9d3iu4qvgevqvl4` FOREIGN KEY (`updatedBy`) REFERENCES `employee` (`id`),
  CONSTRAINT `FK_menu_ctratedBy` FOREIGN KEY (`createdBy`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_menu_updatedBy` FOREIGN KEY (`updatedBy`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKc403tjuoi8fhe9fr22tuupn3p` FOREIGN KEY (`createdBy`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- Dumping data for table ptm.menu: ~4 rows (approximately)
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
REPLACE INTO `menu` (`id`, `menuKey`, `menuName`, `menuUrl`, `menuType`, `serialNo`, `enabled`, `deleted`, `createdBy`, `createdOn`, `updatedBy`, `updatedOn`) VALUES
	(10, 'menu.client', 'Client', '/client', 'link', 1, 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(11, 'menu.project', 'Project', '/project', 'link', 2, 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(12, 'menu.employee', 'Employee', '/employee', 'link', 3, 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(13, 'menu.it', 'IT', '/it', 'link', 4, 'true', 'false', 100, '2020-04-10 00:00:00', NULL, '2020-05-22 02:12:50');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;

-- Dumping structure for table ptm.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  `enabled` enum('true','false') NOT NULL DEFAULT 'true',
  `deleted` enum('true','false') NOT NULL DEFAULT 'false',
  `createdBy` int(6) unsigned NOT NULL,
  `createdOn` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedBy` int(6) unsigned DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_role_createdBy` (`createdBy`),
  KEY `FK_role_updatedBy` (`updatedBy`),
  CONSTRAINT `FK67s9kwa5mj6k356dxia9qq172` FOREIGN KEY (`updatedBy`) REFERENCES `employee` (`id`),
  CONSTRAINT `FK_role_createdBy` FOREIGN KEY (`createdBy`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_role_updatedBy` FOREIGN KEY (`updatedBy`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKditg09jo36bb8b2kv8de4vh4j` FOREIGN KEY (`createdBy`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1 COMMENT='This table contains all roles.';

-- Dumping data for table ptm.role: ~9 rows (approximately)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
REPLACE INTO `role` (`id`, `name`, `description`, `enabled`, `deleted`, `createdBy`, `createdOn`, `updatedBy`, `updatedOn`) VALUES
	(10, 'Super User', 'Super User', 'true', 'false', 100, '2020-04-09 00:00:00', NULL, NULL),
	(11, 'CEO', 'CEO', 'true', 'false', 100, '2020-04-09 00:00:00', NULL, NULL),
	(12, 'Director', 'Director', 'true', 'false', 100, '2020-04-09 00:00:00', NULL, NULL),
	(13, 'Manager', 'Manager', 'true', 'false', 100, '2020-04-23 00:00:00', NULL, NULL),
	(14, 'Team Leader', 'Team Leader', 'true', 'false', 100, '2020-04-09 00:00:00', NULL, NULL),
	(15, 'Senior Executive', 'Senior Executive', 'true', 'false', 100, '2020-04-09 00:00:00', NULL, NULL),
	(16, 'Senior Software Engineer', 'Senior Software Engineer', 'true', 'false', 100, '2020-04-09 00:00:00', NULL, NULL),
	(17, 'Software Engineer', 'Software Engineer', 'true', 'false', 100, '2020-04-09 00:00:00', NULL, NULL),
	(18, 'Executive', 'Executive', 'true', 'false', 100, '2020-04-09 00:00:00', NULL, NULL);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Dumping structure for table ptm.sub_menu
CREATE TABLE IF NOT EXISTS `sub_menu` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `menu_id` int(6) unsigned NOT NULL,
  `actionKey` varchar(50) NOT NULL,
  `actionType` enum('add','save','update','delete','search','searchpage','resetpassword') NOT NULL,
  `subMenuUrl` varchar(50) NOT NULL,
  `subMenuName` varchar(50) NOT NULL,
  `commandName` varchar(50) NOT NULL,
  `enabled` enum('true','false') NOT NULL DEFAULT 'true',
  `deleted` enum('true','false') NOT NULL DEFAULT 'false',
  `createdBy` int(6) unsigned NOT NULL,
  `createdOn` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedBy` int(6) unsigned DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `actionKey` (`actionKey`),
  UNIQUE KEY `subMenuUrl` (`subMenuUrl`),
  UNIQUE KEY `UKl6y54vifvu5g9xei4b3wcslif` (`actionKey`),
  UNIQUE KEY `UKti3ltrvo0t4nw8y9l7jruly3d` (`subMenuUrl`),
  KEY `FK_menuaction_creatdeBy` (`createdBy`),
  KEY `FK_menuaction_updatdeBy` (`updatedBy`),
  KEY `FK_menu_action_menu_id` (`menu_id`) USING BTREE,
  CONSTRAINT `FK2d9x5rq6u3y5scw3bsoaxkp6q` FOREIGN KEY (`updatedBy`) REFERENCES `employee` (`id`),
  CONSTRAINT `FK_submenu_command_createdBy` FOREIGN KEY (`createdBy`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_submenu_command_menu_id` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_submenu_command_updatedBy` FOREIGN KEY (`updatedBy`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKc1b790s6pl6oyvkve7ok7wm12` FOREIGN KEY (`createdBy`) REFERENCES `employee` (`id`),
  CONSTRAINT `FKd0ixq89ofxsfo84ux8vk66e4w` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

-- Dumping data for table ptm.sub_menu: ~14 rows (approximately)
/*!40000 ALTER TABLE `sub_menu` DISABLE KEYS */;
REPLACE INTO `sub_menu` (`id`, `menu_id`, `actionKey`, `actionType`, `subMenuUrl`, `subMenuName`, `commandName`, `enabled`, `deleted`, `createdBy`, `createdOn`, `updatedBy`, `updatedOn`) VALUES
	(10, 10, 'cliSave', 'save', '/client/add', 'Add New Client', 'Save', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(11, 10, 'cliUpdate', 'update', '/client/update', 'Update Client', 'Save', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(12, 10, 'cliDelete', 'delete', '/client/delete', 'Delete Client', 'Delete', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(13, 10, 'cliSearch', 'search', '/client/search', 'Search Client', 'Search', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(14, 11, 'proSave', 'save', '/project/add', 'Add New Project', 'Save', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(15, 11, 'proUpdate', 'update', '/project/update', 'Update Project', 'Save', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(16, 11, 'proDelete', 'delete', '/project/delete', 'Delete Project', 'Delete', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(17, 11, 'proSearch', 'search', '/project/search', 'Search Project', 'Search', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(18, 12, 'empSave', 'save', '/employee/save', 'Add New Employee', 'Save', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(19, 12, 'empUpdate', 'update', '/employee/update', 'Update Employee', 'Save', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(20, 12, 'empDelete', 'delete', '/employee/delete', 'Delete Employee', 'Delete', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(21, 12, 'empSearch', 'search', '/employee/search', 'Search Employee', 'Search', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(22, 12, 'empResetPassword', 'resetpassword', '/employee/resetpassword', 'Reset Password', 'Reset Password', 'true', 'false', 100, '2020-05-09 00:00:00', NULL, NULL),
	(23, 12, 'empSearchPage', 'searchpage', '/employee/searchpage', 'Search Employee', 'Search Page', 'true', 'false', 100, '2020-05-09 00:00:00', NULL, '2020-05-25 13:44:34');
/*!40000 ALTER TABLE `sub_menu` ENABLE KEYS */;

-- Dumping structure for table ptm.sub_menu_dependency
CREATE TABLE IF NOT EXISTS `sub_menu_dependency` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `subMenu_id` int(6) unsigned NOT NULL,
  `t_submenu_key` varchar(50) NOT NULL DEFAULT '',
  `subMenu_dependency_id` int(6) unsigned NOT NULL,
  `t_subMenu_dependency_key` varchar(50) NOT NULL DEFAULT '',
  `index` int(3) unsigned NOT NULL DEFAULT '0',
  `createdBy` int(6) unsigned NOT NULL,
  `createdOn` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedBy` int(6) unsigned DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKok61hv2gymyqih19y6ogw9g5v` (`createdBy`),
  KEY `FKjyart1tkibtwmmllexkt2h914` (`subMenu_dependency_id`),
  KEY `FKk1uypocgjmt7exjxnayl5x7w4` (`subMenu_id`),
  KEY `FKjd6bnbl477l8woyeu9q80udv5` (`updatedBy`),
  CONSTRAINT `FK_sub_menu_dependency_sub_menu` FOREIGN KEY (`subMenu_id`) REFERENCES `sub_menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_sub_menu_dependency_sub_menu_2` FOREIGN KEY (`subMenu_dependency_id`) REFERENCES `sub_menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_submenu_dependency_employee` FOREIGN KEY (`createdBy`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_submenu_dependency_employee_2` FOREIGN KEY (`updatedBy`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKjd6bnbl477l8woyeu9q80udv5` FOREIGN KEY (`updatedBy`) REFERENCES `employee` (`id`),
  CONSTRAINT `FKjyart1tkibtwmmllexkt2h914` FOREIGN KEY (`subMenu_dependency_id`) REFERENCES `sub_menu` (`id`),
  CONSTRAINT `FKk1uypocgjmt7exjxnayl5x7w4` FOREIGN KEY (`subMenu_id`) REFERENCES `sub_menu` (`id`),
  CONSTRAINT `FKok61hv2gymyqih19y6ogw9g5v` FOREIGN KEY (`createdBy`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- Dumping data for table ptm.sub_menu_dependency: ~4 rows (approximately)
/*!40000 ALTER TABLE `sub_menu_dependency` DISABLE KEYS */;
REPLACE INTO `sub_menu_dependency` (`id`, `subMenu_id`, `t_submenu_key`, `subMenu_dependency_id`, `t_subMenu_dependency_key`, `index`, `createdBy`, `createdOn`, `updatedBy`, `updatedOn`) VALUES
	(10, 21, 'empSearch', 23, 'empSearchPage', 1, 100, '2020-05-21 14:43:54', NULL, NULL),
	(11, 19, 'empUpdate', 21, 'empSearch', 0, 100, '2020-05-21 14:43:54', NULL, NULL),
	(12, 20, 'empDelete', 21, 'empSearch', 0, 100, '2020-05-21 14:43:54', NULL, NULL),
	(13, 22, 'empResetPassword', 21, 'empSearch', 0, 100, '2020-05-21 14:43:54', NULL, NULL);
/*!40000 ALTER TABLE `sub_menu_dependency` ENABLE KEYS */;

-- Dumping structure for table ptm.user_role
CREATE TABLE IF NOT EXISTS `user_role` (
  `id` int(6) unsigned NOT NULL AUTO_INCREMENT,
  `designation_id` int(6) unsigned NOT NULL,
  `t_designation_name` varchar(50) NOT NULL,
  `submenu_command_id` int(6) unsigned NOT NULL,
  `t_menu_cmd_name` varchar(50) NOT NULL,
  `enabled` enum('true','false') NOT NULL DEFAULT 'true',
  `deleted` enum('true','false') NOT NULL DEFAULT 'false',
  `createdBy` int(6) unsigned NOT NULL,
  `createdOn` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedBy` int(6) unsigned DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `designation_id_submenu_command_id` (`designation_id`,`submenu_command_id`),
  UNIQUE KEY `UKpv5kfa1b652d9glayob18oj78` (`designation_id`,`submenu_command_id`),
  KEY `FK_rma_createdBy` (`createdBy`),
  KEY `FK_rma_updatedBy` (`updatedBy`),
  KEY `FK_rma_roleId` (`designation_id`) USING BTREE,
  KEY `FK_rma_menuActionId` (`submenu_command_id`) USING BTREE,
  CONSTRAINT `FK8try0udqok1bj0rxm2fxh6qqv` FOREIGN KEY (`createdBy`) REFERENCES `employee` (`id`),
  CONSTRAINT `FK_dsc_command_id` FOREIGN KEY (`submenu_command_id`) REFERENCES `sub_menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_dsc_designation_id` FOREIGN KEY (`designation_id`) REFERENCES `designation` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_dsc_employee_createdBy` FOREIGN KEY (`createdBy`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_dsc_employee_updatedBy` FOREIGN KEY (`updatedBy`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FKalx0jji6b93w08forq43xr9vc` FOREIGN KEY (`designation_id`) REFERENCES `designation` (`id`),
  CONSTRAINT `FKirjctxkwlxmk1uvg4k5ffmv20` FOREIGN KEY (`submenu_command_id`) REFERENCES `sub_menu` (`id`),
  CONSTRAINT `FKxf3ns0q0vh419qucjgxhihcp` FOREIGN KEY (`updatedBy`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=latin1 COMMENT='This table sets role between designation and sub_menu.';

-- Dumping data for table ptm.user_role: ~53 rows (approximately)
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
REPLACE INTO `user_role` (`id`, `designation_id`, `t_designation_name`, `submenu_command_id`, `t_menu_cmd_name`, `enabled`, `deleted`, `createdBy`, `createdOn`, `updatedBy`, `updatedOn`) VALUES
	(10, 10, 'CEO', 10, 'client add', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(11, 10, 'CEO', 11, 'client update', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(12, 10, 'CEO', 12, 'client delete', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(13, 10, 'CEO', 13, 'client search', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(14, 11, 'Director mgmt', 10, 'client add', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(15, 11, 'Director mgmt', 11, 'client update', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(16, 11, 'Director mgmt', 12, 'client delete', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(17, 11, 'Director mgmt', 13, 'client  search', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(18, 12, 'Director HR', 18, 'employee add', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(19, 12, 'Director HR', 19, 'employee update', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(20, 12, 'Director HR', 20, 'employee delete', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(21, 12, 'Director HR', 21, 'employee delete', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(22, 13, 'Director Sales', 10, 'client add', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(23, 13, 'Director Sales', 11, 'client update', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(24, 13, 'Director Sales', 12, 'client delete', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(25, 13, 'Director Sales', 13, 'client search', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(26, 13, 'Director Sales', 14, 'project add', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(27, 13, 'Director Sales', 15, 'project update', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(28, 13, 'Director Sales', 16, 'project delete', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(29, 13, 'Director Sales', 17, 'project search', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(30, 14, 'Director Technology', 14, 'project add', 'true', 'false', 100, '2020-04-24 00:00:00', NULL, NULL),
	(31, 14, 'Director Technology', 15, 'project update', 'true', 'false', 100, '2020-04-24 00:00:00', NULL, NULL),
	(32, 14, 'Director Technology', 16, 'project delete', 'true', 'false', 100, '2020-04-24 00:00:00', NULL, NULL),
	(33, 14, 'Director Technology', 17, 'project search', 'true', 'false', 100, '2020-04-24 00:00:00', NULL, NULL),
	(34, 15, 'Manager mgmt', 10, 'client add', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(35, 15, 'Manager mgmt', 11, 'client update', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(36, 15, 'Manager mgmt', 12, 'client delete', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(37, 15, 'Manager mgmt', 13, 'client search', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(38, 16, 'Manager HR', 18, 'employee add', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(39, 16, 'Manager HR', 19, 'employee update', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(40, 16, 'Manager HR', 20, 'employee delete', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(41, 16, 'Manager HR', 21, 'employee search', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(42, 17, 'Manager Sales', 10, 'client add', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(43, 17, 'Manager Sales', 11, 'client update', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(44, 17, 'Manager Sales', 12, 'client delete', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(45, 17, 'Manager Sales', 13, 'client search', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(46, 17, 'Manager Sales', 14, 'project add', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(47, 17, 'Manager Sales', 15, 'project update', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(48, 17, 'Manager Sales', 16, 'project delete', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(49, 17, 'Manager Sales', 17, 'project search', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(50, 22, 'Sr exe. HR', 18, 'employee add', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(51, 22, 'Sr exe. HR', 19, 'employee update', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(52, 22, 'Sr exe. HR', 20, 'employee delete', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(53, 22, 'Sr exe. HR', 21, 'employee search', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(54, 23, 'Sr exe. Sales', 14, 'project add', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(55, 23, 'Sr exe. Sales', 15, 'project update', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(56, 23, 'Sr exe. Sales', 17, 'project search', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(57, 26, 'Executive HR', 18, 'employee add', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(58, 26, 'Executive HR', 19, 'employee update', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(59, 26, 'Executive HR', 21, 'employee search', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(60, 29, 'Sr. Executive IT', 22, 'reset password', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(61, 30, 'TL  IT', 22, 'reset password', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL),
	(62, 31, 'Executive  IT', 22, 'reset password', 'true', 'false', 100, '2020-04-10 00:00:00', NULL, NULL);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
