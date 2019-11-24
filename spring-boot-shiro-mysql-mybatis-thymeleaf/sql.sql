/*
SQLyog Ultimate v11.13 (64 bit)
MySQL - 5.6.10 : Database - t1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`t1` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `t1`;

/*Table structure for table `employees` */

DROP TABLE IF EXISTS `employees`;

CREATE TABLE `employees` (
  `employee_id` int(11) NOT NULL,
  `first_name` varchar(40) DEFAULT '',
  `last_name` varchar(40) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `user_name` varchar(300) NOT NULL,
  `user_passwd` varchar(300) NOT NULL,
  `status` char(1) NOT NULL DEFAULT '0',
  `perms` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `employees` */

insert  into `employees`(`employee_id`,`first_name`,`last_name`,`email`,`user_name`,`user_passwd`,`status`,`perms`) values (1,'赵','丽颖','zly56546654@qq.com','tom','123456','1','user:add'),(2,'诸','葛亮','zgl765454qq.com','zgl','123456','0','user:update');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
