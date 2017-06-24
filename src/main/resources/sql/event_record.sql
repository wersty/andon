/*
Navicat MySQL Data Transfer

Source Server         : wersty
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : andon

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2017-06-24 19:20:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for event_record
-- ----------------------------
DROP TABLE IF EXISTS `event_record`;
CREATE TABLE `event_record` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `event_type` varchar(50) DEFAULT NULL,
  `group_id` varchar(50) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=144 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of event_record
-- ----------------------------
INSERT INTO `event_record` VALUES ('141', '100', 'Channel1.Device1.vw100', '1498297004000');
INSERT INTO `event_record` VALUES ('142', '200', 'Channel1.Device1.vw101', '1498297006000');
INSERT INTO `event_record` VALUES ('143', '300', 'Channel1.Device1.vw102', '1498297009000');
