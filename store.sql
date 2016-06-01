/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : store

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2016-06-01 20:37:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goodstable
-- ----------------------------
DROP TABLE IF EXISTS `goodstable`;
CREATE TABLE `goodstable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` double(10,2) DEFAULT NULL,
  `left` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for itemtable
-- ----------------------------
DROP TABLE IF EXISTS `itemtable`;
CREATE TABLE `itemtable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` int(11) DEFAULT NULL,
  `goodsId` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ordertable
-- ----------------------------
DROP TABLE IF EXISTS `ordertable`;
CREATE TABLE `ordertable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `location` varchar(255) NOT NULL,
  `time` datetime DEFAULT NULL,
  `total` double DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for usertable
-- ----------------------------
DROP TABLE IF EXISTS `usertable`;
CREATE TABLE `usertable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
