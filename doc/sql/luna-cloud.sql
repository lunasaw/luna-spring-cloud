/*
 Navicat Premium Data Transfer

 Source Server         : luna-local
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : localhost:3306
 Source Schema         : luna-cloud

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 04/02/2021 20:49:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_account
-- ----------------------------
DROP TABLE IF EXISTS `tb_account`;
CREATE TABLE `tb_account` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) DEFAULT NULL,
  `total` decimal(10,0) DEFAULT NULL COMMENT '总额度',
  `use` decimal(10,0) DEFAULT NULL COMMENT '已用额度',
  `residue` decimal(10,0) DEFAULT NULL COMMENT '剩余额度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_account
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tb_order
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(11) DEFAULT NULL,
  `product_id` bigint(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `money` decimal(10,0) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for tb_payment
-- ----------------------------
DROP TABLE IF EXISTS `tb_payment`;
CREATE TABLE `tb_payment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `serial` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_payment
-- ----------------------------
BEGIN;
INSERT INTO `tb_payment` VALUES (1, '13');
INSERT INTO `tb_payment` VALUES (2, '99');
INSERT INTO `tb_payment` VALUES (3, '13');
INSERT INTO `tb_payment` VALUES (4, '13');
INSERT INTO `tb_payment` VALUES (5, '13');
INSERT INTO `tb_payment` VALUES (6, '13');
COMMIT;

-- ----------------------------
-- Table structure for tb_storage
-- ----------------------------
DROP TABLE IF EXISTS `tb_storage`;
CREATE TABLE `tb_storage` (
  `id` bigint(11) NOT NULL,
  `total` int(11) DEFAULT NULL,
  `product_id` bigint(11) DEFAULT NULL,
  `used` int(11) DEFAULT NULL,
  `residue` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_storage
-- ----------------------------
BEGIN;
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
