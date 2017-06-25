/*
Navicat MySQL Data Transfer

Source Server         : wersty
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : andon

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2017-06-26 00:11:23
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
  `group_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=181 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of event_record
-- ----------------------------
INSERT INTO `event_record` VALUES ('175', 'Channel1.Device1.vw100', '101', '1498406892000', '175');
INSERT INTO `event_record` VALUES ('176', 'Channel1.Device1.vw101', '102', '1498406903000', '176');
INSERT INTO `event_record` VALUES ('177', 'Channel1.Device1.vw102', '103', '1498406914000', '177');
INSERT INTO `event_record` VALUES ('178', 'Channel1.Device1.vw102', '101', '1498406996000', '178');
INSERT INTO `event_record` VALUES ('179', 'Channel1.Device1.vw100', '102', '1498406992000', '175');
INSERT INTO `event_record` VALUES ('180', 'Channel1.Device1.vw101', '103', '1498406994000', '176');
