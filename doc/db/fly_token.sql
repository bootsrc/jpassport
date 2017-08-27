/*
Navicat MySQL Data Transfer

Source Server         : tencent-flylib_1
Source Server Version : 50632
Source Host           : localhost:3306
Source Database       : flylib_1

Target Server Type    : MYSQL
Target Server Version : 50632
File Encoding         : 65001

Date: 2017-08-27 22:20:35
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
