/*
 Navicat Premium Data Transfer

 Source Server         : 阿丁
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : 124.222.35.20:3306
 Source Schema         : my_db

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 03/04/2022 20:10:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for jwt_login_user
-- ----------------------------
DROP TABLE IF EXISTS `jwt_login_user`;
CREATE TABLE `jwt_login_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jwt_login_user
-- ----------------------------
INSERT INTO `jwt_login_user` VALUES (3, '123456', '123456', NULL, NULL);
INSERT INTO `jwt_login_user` VALUES (4, '123456', '123456', '2022-04-03 16:39:31', NULL);
INSERT INTO `jwt_login_user` VALUES (5, '123456', '123456', '2022-04-03 18:06:11', NULL);
INSERT INTO `jwt_login_user` VALUES (8, 'ding', 'b293b1ecc37fac4c719a78048754507d', '2022-04-03 18:27:58', NULL);

SET FOREIGN_KEY_CHECKS = 1;
