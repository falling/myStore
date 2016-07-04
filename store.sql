/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50709
Source Host           : localhost:3306
Source Database       : store

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2016-07-04 17:20:31
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
  `number` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `imgUrl` varchar(255) NOT NULL DEFAULT 'http://i.niupic.com/images/2016/06/02/9q5E7H.png',
  `state` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodstable
-- ----------------------------
INSERT INTO `goodstable` VALUES ('1', '卫龙', '50.00', '12', '素类', 'http://i.niupic.com/images/2016/06/02/RbTBna.jpg', '0');
INSERT INTO `goodstable` VALUES ('2', '咪咪', '0.50', '11', '素类', 'http://i.niupic.com/images/2016/06/02/9q5E7H.png', '0');
INSERT INTO `goodstable` VALUES ('3', '上好佳', '1.00', '0', '素类', 'http://i.niupic.com/images/2016/06/02/9q5E7H.png', '0');
INSERT INTO `goodstable` VALUES ('4', '乐事', '5.00', '0', '素类', 'http://i.niupic.com/images/2016/06/02/9q5E7H.png', '0');
INSERT INTO `goodstable` VALUES ('5', '薄荷', '0.00', '0', '素类', 'http://i.niupic.com/images/2016/06/02/9q5E7H.png', '0');
INSERT INTO `goodstable` VALUES ('6', '可乐', '3.00', '12', '饮料', 'http://i.niupic.com/images/2016/06/02/9q5E7H.png', '0');
INSERT INTO `goodstable` VALUES ('8', '大白兔', '3.00', '20', '素类', 'http://i.niupic.com/images/2016/06/02/9q5E7H.png', '0');

-- ----------------------------
-- Table structure for itemtable
-- ----------------------------
DROP TABLE IF EXISTS `itemtable`;
CREATE TABLE `itemtable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` int(11) DEFAULT NULL,
  `goodsId` int(11) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `orderId` (`orderId`),
  CONSTRAINT `orderId` FOREIGN KEY (`orderId`) REFERENCES `ordertable` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of itemtable
-- ----------------------------
INSERT INTO `itemtable` VALUES ('1', '2', '6', null);
INSERT INTO `itemtable` VALUES ('2', '2', '2', null);
INSERT INTO `itemtable` VALUES ('3', '3', '2', null);
INSERT INTO `itemtable` VALUES ('4', '3', '2', null);
INSERT INTO `itemtable` VALUES ('5', '3', '2', null);
INSERT INTO `itemtable` VALUES ('6', '4', '1', null);
INSERT INTO `itemtable` VALUES ('7', '4', '1', null);
INSERT INTO `itemtable` VALUES ('8', '5', '1', null);
INSERT INTO `itemtable` VALUES ('9', '5', '1', null);
INSERT INTO `itemtable` VALUES ('10', '5', '1', null);

-- ----------------------------
-- Table structure for ordertable
-- ----------------------------
DROP TABLE IF EXISTS `ordertable`;
CREATE TABLE `ordertable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `location` varchar(255) NOT NULL,
  `time` datetime DEFAULT CURRENT_TIMESTAMP,
  `total` double DEFAULT NULL,
  `state` int(255) DEFAULT '0',
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ordertable
-- ----------------------------
INSERT INTO `ordertable` VALUES ('2', '4', '明德楼', '2016-06-08 20:49:17', '3.5', '2', '无');
INSERT INTO `ordertable` VALUES ('3', '4', '明德楼1-519', '2016-06-09 21:03:46', '1.5', '1', '无');
INSERT INTO `ordertable` VALUES ('4', '35', 'fgdgdgdg', '2016-06-14 11:13:39', '1', '1', 'dgdg');
INSERT INTO `ordertable` VALUES ('5', '35', 'sfs', '2016-06-14 11:14:00', '1.5', '1', 'sfs');
INSERT INTO `ordertable` VALUES ('6', '35', 'sdf', '2016-06-14 11:14:10', '0', '1', 'sfs');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `a` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------

-- ----------------------------
-- Table structure for usertable
-- ----------------------------
DROP TABLE IF EXISTS `usertable`;
CREATE TABLE `usertable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT 'customer',
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usertable
-- ----------------------------
INSERT INTO `usertable` VALUES ('1', 'falling', '123123', '15167193069', 'admin', '朱永政');
INSERT INTO `usertable` VALUES ('2', 'allen', '123123', '15167193069', 'admin', 'Allen');
INSERT INTO `usertable` VALUES ('4', 'visitor', '123123', '15167193069', 'customer', 'zyz');
INSERT INTO `usertable` VALUES ('35', 'zhoucaner', '123456', '15167192498', 'customer', 'zhoucaner');
