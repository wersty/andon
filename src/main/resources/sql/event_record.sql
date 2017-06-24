/*
Navicat MySQL Data Transfer

Source Server         : wersty
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : andon

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2017-06-24 22:30:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for event_record
-- ----------------------------
DROP TABLE IF EXISTS `event_record`;
CREATE TABLE `event_record` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `item_id` varchar(50) DEFAULT NULL,
  `item_value` varchar(50) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=156 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of event_record
-- ----------------------------
INSERT INTO `event_record` VALUES ('153', 'Channel1.Device1.vw100', '101', '1498314598000');
INSERT INTO `event_record` VALUES ('154', 'Channel1.Device1.vw101', '102', '1498314600000');
INSERT INTO `event_record` VALUES ('155', 'Channel1.Device1.vw102', '103', '1498314602000');
