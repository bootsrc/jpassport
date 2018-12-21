/*
Navicat MySQL Data Transfer

Source Server         : fpassport
Source Server Version : 50632
Source Host           : localhost:3306
Source Database       : fpassport

Target Server Type    : MYSQL
Target Server Version : 50632
File Encoding         : 65001

Date: 2017-10-17 20:59:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for fly_user
-- ----------------------------
DROP TABLE IF EXISTS `fly_user`;
CREATE TABLE `fly_user` (
  `id` bigint(12) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `status` int(3) DEFAULT '0',
  `password` varchar(60) DEFAULT NULL,
  `mobile` varchar(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `openid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fly_user
-- ----------------------------
INSERT INTO `fly_user` VALUES ('1', '2017-08-27 17:45:11', '2017-08-27 17:45:11', '0', 'f379eaf3c831b04de153469d1bec345e', '15601623391', null, null);
INSERT INTO `fly_user` VALUES ('2', '2017-08-27 17:48:35', '2017-08-27 17:48:35', '0', 'e10adc3949ba59abbe56e057f20f883e', '13053262189', null, null);
INSERT INTO `fly_user` VALUES ('3', '2017-08-27 18:38:51', '2017-08-27 18:38:51', '0', 'f379eaf3c831b04de153469d1bec345e', '13052362189', null, null);
INSERT INTO `fly_user` VALUES ('5', '2017-08-27 21:49:23', '2017-08-27 21:49:23', '0', 'e10adc3949ba59abbe56e057f20f883e', '13011111111', null, null);
