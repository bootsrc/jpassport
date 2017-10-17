/*
Navicat MySQL Data Transfer

Source Server         : tencent-flylib_1
Source Server Version : 50632
Source Host           : localhost:3306
Source Database       : flylib_1

Target Server Type    : MYSQL
Target Server Version : 50632
File Encoding         : 65001

Date: 2017-10-17 20:59:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for fly_token
-- ----------------------------
DROP TABLE IF EXISTS `fly_token`;
CREATE TABLE `fly_token` (
  `user_id` bigint(12) NOT NULL,
  `token` varchar(50) DEFAULT NULL,
  `expire` bigint(12) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of fly_token
-- ----------------------------
INSERT INTO `fly_token` VALUES ('1', 'b2d159798edd67f252603ab0dac57e65', '1000000000', '2017-08-27 17:45:11', '2017-08-27 17:45:11');
INSERT INTO `fly_token` VALUES ('2', 'bfad3897dfd296223ee84afd62119b3b', '1000000000', '2017-08-27 17:48:35', '2017-08-27 17:48:35');
INSERT INTO `fly_token` VALUES ('3', '24dd032ccac322aa3ece13b598f1ae83', '1000000000', '2017-08-27 18:38:51', '2017-08-27 18:38:51');
INSERT INTO `fly_token` VALUES ('5', '069473bedcc609b0d25d6746c11760e5', '1000000000', '2017-08-27 21:49:31', '2017-08-27 21:49:31');
