/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : tyxkxt

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 06/09/2021 14:47:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `cid` int(10) NOT NULL AUTO_INCREMENT COMMENT '课程号',
  `cname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名',
  `cscope` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授课范围',
  `cinfo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程简介',
  `islife` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '这节课上不上  是否还是开课的',
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for results
-- ----------------------------
DROP TABLE IF EXISTS `results`;
CREATE TABLE `results`  (
  `sno` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `zx1` int(5) NULL DEFAULT NULL COMMENT '专项1',
  `zx2` int(5) NULL DEFAULT NULL COMMENT '专项2',
  `tjq` int(5) NULL DEFAULT NULL COMMENT '太极拳',
  `xyp` int(5) NULL DEFAULT NULL COMMENT ' 校园跑',
  `pscj` int(5) NULL DEFAULT NULL COMMENT '平时成绩',
  `zcj` int(5) NULL DEFAULT NULL COMMENT '总成绩',
  `resid` int(10) NOT NULL AUTO_INCREMENT COMMENT '成绩id',
  `tcid` int(20) NULL DEFAULT NULL COMMENT '班级id',
  PRIMARY KEY (`resid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 16185 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rkb
-- ----------------------------
DROP TABLE IF EXISTS `rkb`;
CREATE TABLE `rkb`  (
  `Id` int(10) NOT NULL AUTO_INCREMENT COMMENT '任课id',
  `tgh` int(10) NOT NULL COMMENT '教师工号',
  `cid` int(10) NOT NULL COMMENT '课程号',
  PRIMARY KEY (`Id`) USING BTREE,
  UNIQUE INDEX `tgh_cid`(`tgh`, `cid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 61 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for stu
-- ----------------------------
DROP TABLE IF EXISTS `stu`;
CREATE TABLE `stu`  (
  `sno` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `sname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生姓名',
  `ssex` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生性别',
  `sqrade` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年级',
  `sclass` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级',
  `sxy` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教学院',
  PRIMARY KEY (`sno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for teach_class
-- ----------------------------
DROP TABLE IF EXISTS `teach_class`;
CREATE TABLE `teach_class`  (
  `tcid` int(20) NOT NULL AUTO_INCREMENT COMMENT '班级id',
  `cid` int(10) NULL DEFAULT NULL COMMENT '课程号',
  `cname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名',
  `tname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教师姓名',
  `tgh` int(10) NULL DEFAULT NULL COMMENT '教师工号',
  `rsxz` int(11) NULL DEFAULT NULL COMMENT '选课人数限制',
  `xq` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '校区',
  `sqrade` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开课年级',
  `sksd` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选课时段（第几节课）',
  `sksq` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选课时区（周几）',
  `isend` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否结课',
  `ssex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程性别限制',
  `xkrs` int(11) NULL DEFAULT NULL COMMENT '当前选课人数',
  PRIMARY KEY (`tcid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 304 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `tgh` int(10) NOT NULL COMMENT '教师工号',
  `tname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教师姓名',
  `tsex` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教师性别',
  `tinfo` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教师信息',
  `tdept` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教师所在部门',
  `retired` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否退休',
  PRIMARY KEY (`tgh`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `tgh` int(10) NOT NULL COMMENT '教师工号（为账号）',
  `tname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教师姓名',
  `pwd` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `jurisdiction` int(2) NOT NULL COMMENT '权限',
  PRIMARY KEY (`tgh`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for xk
-- ----------------------------
DROP TABLE IF EXISTS `xk`;
CREATE TABLE `xk`  (
  `xkid` int(20) NOT NULL AUTO_INCREMENT COMMENT '选课标识号',
  `tcid` int(20) NULL DEFAULT NULL COMMENT '班级id',
  `sno` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学号',
  PRIMARY KEY (`xkid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4182 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
