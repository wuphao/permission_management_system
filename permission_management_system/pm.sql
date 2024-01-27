/*
Navicat MySQL Data Transfer

Source Server         : wph
Source Server Version : 80032
Source Host           : localhost:3306
Source Database       : pm

Target Server Type    : MYSQL
Target Server Version : 80032
File Encoding         : 65001

Date: 2023-10-24 12:55:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for organization
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `orgid` int NOT NULL,
  `orgname` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`orgid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of organization
-- ----------------------------
INSERT INTO `organization` VALUES ('0', 'boss', '000');
INSERT INTO `organization` VALUES ('1', '组织部', '信息楼');
INSERT INTO `organization` VALUES ('2', '财务部', '财务楼');
INSERT INTO `organization` VALUES ('3', '人事部', '人事楼');
INSERT INTO `organization` VALUES ('4', '市场部', '市场楼');
INSERT INTO `organization` VALUES ('5', '技术部', '技术楼');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `perid` int NOT NULL,
  `pername` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`perid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('0', '增加删除修改');
INSERT INTO `permission` VALUES ('1', '增加');
INSERT INTO `permission` VALUES ('2', '删除');
INSERT INTO `permission` VALUES ('3', '修改');
INSERT INTO `permission` VALUES ('4', '增加删除');
INSERT INTO `permission` VALUES ('5', '增加修改');
INSERT INTO `permission` VALUES ('6', '删除修改');
INSERT INTO `permission` VALUES ('7', '查看');

-- ----------------------------
-- Table structure for pos
-- ----------------------------
DROP TABLE IF EXISTS `pos`;
CREATE TABLE `pos` (
  `posid` int NOT NULL,
  `posname` varchar(255) DEFAULT NULL,
  `responsibility` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`posid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of pos
-- ----------------------------
INSERT INTO `pos` VALUES ('0', 'boss', '0');
INSERT INTO `pos` VALUES ('1', '保安部', '看守');
INSERT INTO `pos` VALUES ('2', '财务经理', '负责财务管理');
INSERT INTO `pos` VALUES ('3', '人事主管', '负责人事管理');
INSERT INTO `pos` VALUES ('4', '市场专员', '负责市场推广');
INSERT INTO `pos` VALUES ('5', '软件工程师', '进行软件开发');
INSERT INTO `pos` VALUES ('6', '销售代表', '推销公司产品');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleid` int NOT NULL,
  `rolename` varchar(255) DEFAULT NULL,
  `orgid` int DEFAULT NULL,
  `posid` int DEFAULT NULL,
  `perid` int DEFAULT NULL,
  PRIMARY KEY (`roleid`),
  KEY `posid` (`posid`),
  KEY `orgid` (`orgid`),
  KEY `perid` (`perid`),
  CONSTRAINT `role_ibfk_1` FOREIGN KEY (`posid`) REFERENCES `pos` (`posid`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `role_ibfk_2` FOREIGN KEY (`orgid`) REFERENCES `organization` (`orgid`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `role_ibfk_3` FOREIGN KEY (`perid`) REFERENCES `permission` (`perid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('0', 'root', '0', '0', '0');
INSERT INTO `role` VALUES ('1', 'admin1', '1', '1', '1');
INSERT INTO `role` VALUES ('2', 'admin2', '2', '2', '2');
INSERT INTO `role` VALUES ('3', 'admin3', '2', '4', '3');
INSERT INTO `role` VALUES ('4', 'admin4', '5', '4', '4');
INSERT INTO `role` VALUES ('5', 'admin5', '4', '4', '5');
INSERT INTO `role` VALUES ('6', 'admin6', '4', '3', '6');
INSERT INTO `role` VALUES ('7', 'admin7', '2', '4', '7');
INSERT INTO `role` VALUES ('8', 'admin3', '3', '5', '5');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phonenumber` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `roleid` int DEFAULT NULL,
  KEY `roleid` (`roleid`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '11111', '08b96aa763a4b97196926abf068ef18a', '168', '1111@163.com', '1');
INSERT INTO `user` VALUES ('2', 'user1', '74edb3b688f0e037940ec3e4fa2b4aee', '111111', 'user1@163.com', '2');
INSERT INTO `user` VALUES ('3', 'user2', '6675db1f73c01f1f9e66de673ace3222', '13652', 'user2@163.com', '3');
INSERT INTO `user` VALUES ('4', 'user3', '92f410833265cdf237e289f2f43ea9d4', '321665', 'user3@163.com', '4');
INSERT INTO `user` VALUES ('5', 'user4', '4ae6987b3c1362e1b2ea0f1636c334f6', '13020', 'user4@163.com', '5');
INSERT INTO `user` VALUES ('6', 'user5', 'b81b132ee51a2e7b75626f6ba970ae1f', '36412', 'user5@163.com', '6');
INSERT INTO `user` VALUES ('7', 'user6', '460b37c9d9dfef43f71b363f9b4f254a', '631adada', 'user6@163.com', '7');
INSERT INTO `user` VALUES ('8', 'test66664498776644', 'c3a59f5ead28beb7e635074382d10702', '1632333', 'qqeamikl', '1');
INSERT INTO `user` VALUES ('9', 'adad', '5220958281715bb6984d0b30cb864e84', 'dada', 'daada', '7');
INSERT INTO `user` VALUES ('10', '666', '88d7c61fa06c786be59d48fdcaf7fa07', '188888', '65646@', '7');
INSERT INTO `user` VALUES ('0', 'wph', 'c3a59f5ead28beb7e635074382d10702', '1632333', 'qqeamikl', '1');
