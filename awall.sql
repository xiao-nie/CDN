/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : awall

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 15/04/2021 16:54:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_article
-- ----------------------------
DROP TABLE IF EXISTS `tb_article`;
CREATE TABLE `tb_article`  (
  `article_id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL COMMENT '发布者',
  `date` datetime NULL DEFAULT NULL COMMENT '发布时间',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `tag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '话题',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章地址',
  `classify` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类',
  `star` int NULL DEFAULT NULL COMMENT '点赞',
  `count` bigint NULL DEFAULT NULL COMMENT '热度值',
  `update_time` datetime NULL DEFAULT NULL COMMENT '最后一次持久化时间',
  PRIMARY KEY (`article_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_article
-- ----------------------------
INSERT INTO `tb_article` VALUES (1, 502006690, NULL, '内容', '话题', 'url', '分类', 123, 456, NULL);
INSERT INTO `tb_article` VALUES (2, 213123123, '2021-01-01 00:00:00', '213232132', '3123131', '213312', '2213', 2321, 916, NULL);
INSERT INTO `tb_article` VALUES (3, 2131, NULL, '132312', '2132', '231', '21312', 321, 1204, NULL);
INSERT INTO `tb_article` VALUES (4, 21321, NULL, NULL, NULL, NULL, NULL, NULL, 160, NULL);
INSERT INTO `tb_article` VALUES (5, 523, NULL, NULL, NULL, NULL, NULL, NULL, 2132, NULL);
INSERT INTO `tb_article` VALUES (6, 435, NULL, NULL, NULL, NULL, NULL, NULL, 3122, NULL);
INSERT INTO `tb_article` VALUES (7, 435435, NULL, NULL, NULL, NULL, NULL, NULL, 140, NULL);
INSERT INTO `tb_article` VALUES (8, 53434, NULL, NULL, NULL, NULL, NULL, NULL, 60, NULL);
INSERT INTO `tb_article` VALUES (9, 545, NULL, NULL, NULL, NULL, NULL, NULL, 96916, NULL);
INSERT INTO `tb_article` VALUES (10, 42121, NULL, NULL, NULL, NULL, NULL, NULL, 21312, NULL);
INSERT INTO `tb_article` VALUES (11, 321, NULL, NULL, NULL, NULL, NULL, NULL, 60, NULL);
INSERT INTO `tb_article` VALUES (12, 2112, NULL, NULL, NULL, NULL, NULL, NULL, 380, NULL);
INSERT INTO `tb_article` VALUES (13, 31231, NULL, NULL, NULL, NULL, NULL, NULL, 32342, NULL);
INSERT INTO `tb_article` VALUES (14, 3123, NULL, NULL, NULL, NULL, NULL, NULL, 676, NULL);
INSERT INTO `tb_article` VALUES (15, 32112, NULL, NULL, NULL, NULL, NULL, NULL, 796, NULL);

-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment`  (
  `com_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint NOT NULL COMMENT '评论者id',
  `article_id` bigint NOT NULL COMMENT '文章id',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '评论内容',
  `date` datetime NULL DEFAULT NULL COMMENT '评论时间',
  `to_id` bigint NULL DEFAULT NULL COMMENT '回复谁',
  PRIMARY KEY (`com_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_comment
-- ----------------------------

-- ----------------------------
-- Table structure for tb_file
-- ----------------------------
DROP TABLE IF EXISTS `tb_file`;
CREATE TABLE `tb_file`  (
  `file_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名',
  `file_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件地址',
  `user_id` bigint NULL DEFAULT NULL COMMENT '文件所属成员',
  PRIMARY KEY (`file_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_file
-- ----------------------------

-- ----------------------------
-- Table structure for tb_group
-- ----------------------------
DROP TABLE IF EXISTS `tb_group`;
CREATE TABLE `tb_group`  (
  `group_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint NULL DEFAULT NULL COMMENT '成员',
  `post_id` bigint NULL DEFAULT NULL COMMENT '组织',
  PRIMARY KEY (`group_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_group
-- ----------------------------
INSERT INTO `tb_group` VALUES (1, 234111, 451116);

-- ----------------------------
-- Table structure for tb_notice
-- ----------------------------
DROP TABLE IF EXISTS `tb_notice`;
CREATE TABLE `tb_notice`  (
  `notice_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告类型 1管理员公告 2 组织公告 3 组织内部公告',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '公告内容',
  `date` datetime NULL DEFAULT NULL COMMENT '发布时间',
  `user_id` bigint NULL DEFAULT NULL COMMENT '发布人',
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_notice
-- ----------------------------
INSERT INTO `tb_notice` VALUES (1, NULL, NULL, NULL, 5671);

-- ----------------------------
-- Table structure for tb_object
-- ----------------------------
DROP TABLE IF EXISTS `tb_object`;
CREATE TABLE `tb_object`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '发展对象批次',
  `pstime` datetime NOT NULL COMMENT '培训开始时间',
  `pbtime` datetime NOT NULL COMMENT '培训结束时间',
  `ztime` datetime NOT NULL COMMENT '座谈会时间',
  `ttime` datetime NOT NULL COMMENT '团组织推优时间',
  `ltime` datetime NOT NULL COMMENT '列为发展对象时间',
  `gstime` datetime NOT NULL COMMENT '公示开始时间',
  `gbtime` datetime NOT NULL COMMENT '公示结束时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_object
-- ----------------------------
INSERT INTO `tb_object` VALUES (1, '2018-04-01 00:00:00', '2018-04-29 00:00:00', '2018-04-09 00:00:00', '2018-03-20 00:00:00', '2018-03-26 00:00:00', '2018-04-10 00:00:00', '2018-04-16 00:00:00');
INSERT INTO `tb_object` VALUES (2, '2018-10-01 00:00:00', '2018-10-29 00:00:00', '2018-10-09 00:00:00', '2018-09-20 00:00:00', '2018-09-26 00:00:00', '2018-10-10 00:00:00', '2018-10-16 00:00:00');
INSERT INTO `tb_object` VALUES (3, '2019-04-01 00:00:00', '2019-04-29 00:00:00', '2019-04-09 00:00:00', '2019-03-20 00:00:00', '2019-03-26 00:00:00', '2019-04-10 00:00:00', '2019-04-16 00:00:00');
INSERT INTO `tb_object` VALUES (4, '2019-10-01 00:00:00', '2019-10-29 00:00:00', '2019-10-09 00:00:00', '2019-09-20 00:00:00', '2019-09-26 00:00:00', '2019-10-10 00:00:00', '2019-10-16 00:00:00');
INSERT INTO `tb_object` VALUES (5, '2020-04-01 00:00:00', '2020-04-29 00:00:00', '2020-04-09 00:00:00', '2020-03-20 00:00:00', '2020-03-26 00:00:00', '2020-04-10 00:00:00', '2020-04-16 00:00:00');
INSERT INTO `tb_object` VALUES (6, '2020-10-01 00:00:00', '2020-10-29 00:00:00', '2020-10-09 00:00:00', '2020-09-20 00:00:00', '2020-09-26 00:00:00', '2020-10-10 00:00:00', '2020-10-16 00:00:00');
INSERT INTO `tb_object` VALUES (7, '2021-04-01 00:00:00', '2021-04-29 00:00:00', '2021-04-09 00:00:00', '2021-03-20 00:00:00', '2021-03-26 00:00:00', '2021-04-10 00:00:00', '2021-04-16 00:00:00');

-- ----------------------------
-- Table structure for tb_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_permission`;
CREATE TABLE `tb_permission`  (
  `permission_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `per_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限名称',
  `per_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限描述',
  PRIMARY KEY (`permission_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_permission
-- ----------------------------

-- ----------------------------
-- Table structure for tb_protect
-- ----------------------------
DROP TABLE IF EXISTS `tb_protect`;
CREATE TABLE `tb_protect`  (
  `protect_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `status` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  `article_id` bigint NULL DEFAULT NULL COMMENT '文章id',
  PRIMARY KEY (`protect_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_protect
-- ----------------------------

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role`  (
  `role_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_role
-- ----------------------------

-- ----------------------------
-- Table structure for tb_rp
-- ----------------------------
DROP TABLE IF EXISTS `tb_rp`;
CREATE TABLE `tb_rp`  (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role_id` int NOT NULL,
  `permission_id` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_rp
-- ----------------------------

-- ----------------------------
-- Table structure for tb_sub
-- ----------------------------
DROP TABLE IF EXISTS `tb_sub`;
CREATE TABLE `tb_sub`  (
  `sub_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `sub_user_id` bigint NOT NULL COMMENT '订阅者|粉丝',
  `pub_user_id` bigint NOT NULL COMMENT '发布者',
  PRIMARY KEY (`sub_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_sub
-- ----------------------------
INSERT INTO `tb_sub` VALUES (1, 123456, 231321);

-- ----------------------------
-- Table structure for tb_train
-- ----------------------------
DROP TABLE IF EXISTS `tb_train`;
CREATE TABLE `tb_train`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id代表学期',
  `stime` datetime NOT NULL COMMENT '党课培训开始时间',
  `btime` datetime NOT NULL COMMENT '党课培训结束时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_train
-- ----------------------------
INSERT INTO `tb_train` VALUES (1, '2017-04-22 00:00:00', '2017-05-20 00:00:00');
INSERT INTO `tb_train` VALUES (2, '2017-11-19 00:00:00', '2017-12-23 00:00:00');
INSERT INTO `tb_train` VALUES (3, '2018-04-12 00:00:00', '2018-05-22 00:00:00');
INSERT INTO `tb_train` VALUES (4, '2018-11-23 00:00:00', '2018-12-21 00:00:00');
INSERT INTO `tb_train` VALUES (5, '2019-05-06 00:00:00', '2019-06-21 00:00:00');
INSERT INTO `tb_train` VALUES (6, '2019-11-23 00:00:00', '2019-12-20 00:00:00');
INSERT INTO `tb_train` VALUES (7, '2020-05-06 00:00:00', '2020-06-06 00:00:00');
INSERT INTO `tb_train` VALUES (8, '2020-10-23 00:00:00', '2020-11-29 00:00:00');
INSERT INTO `tb_train` VALUES (9, '2021-04-10 00:00:00', '2021-06-01 00:00:00');

-- ----------------------------
-- Table structure for tb_ur
-- ----------------------------
DROP TABLE IF EXISTS `tb_ur`;
CREATE TABLE `tb_ur`  (
  `id` bigint NOT NULL COMMENT 'id',
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_ur
-- ----------------------------

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
  `tel` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号|手机号',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `head_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'http://q1.qlogo.cn/g?b=qq&nk=1607847501&s=640' COMMENT '头像',
  `nikename` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `signature` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个性签名',
  `hobby` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '爱好',
  `college` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学院',
  `real_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `ac` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '认证',
  `login_time` datetime NULL DEFAULT NULL COMMENT '最后登录时间',
  `login_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后登录ip',
  `background_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'https://cdn.jsdelivr.net/gh/Tab-tan/CDN@1.1.15/pic/171141-1575709901e5e0.jpg' COMMENT '背景图',
  `salt` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `tel`(`tel`) USING BTREE COMMENT '唯一'
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (3, '17605674682', '000000', 'http://q1.qlogo.cn/g?b=qq&nk=1607847501&s=640', 'xiaonie', '不忘初心，牢记使命！', 'coding', '大人院', '聂富豪', '2020-03-01 12:00:00', '已认证', '2020-03-01 12:00:00', '127.0.0.1', 'https://cdn.jsdelivr.net/gh/Tab-tan/CDN@1.1.15/pic/171141-1575709901e5e0.jpg', 'sdgsdfgsdg');
INSERT INTO `tb_user` VALUES (4, '17634509867', 'c77fb0d15df9b9b75c469a6e848734e1', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '8e9f09');
INSERT INTO `tb_user` VALUES (6, '17605674689', '0757e165605fe4c0e599cc688d564d5d', NULL, '小聂同学', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '918c4f');
INSERT INTO `tb_user` VALUES (7, '15665371888', '2153975436a6a862e608d17dca1e950d', NULL, '哈哈', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '0ac79c');
INSERT INTO `tb_user` VALUES (8, '17605678900', '2d7c36a179e283c613ba03302aab6de1', NULL, '小聂同学', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'c70181');
INSERT INTO `tb_user` VALUES (9, '17755702867', 'bd347b313e827e8d062b374329bb77d9', NULL, 'xiaochang', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'be0b24');
INSERT INTO `tb_user` VALUES (10, '17755702860', 'c6256af09f563411daf3e83796c0ca5c', NULL, '小聂同学', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'eb4556');
INSERT INTO `tb_user` VALUES (11, '13888888888', '2d321605592fa5779c1cefa88c9b48cd', NULL, '小聂同学', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'eea6f4');
INSERT INTO `tb_user` VALUES (13, '13666666666', '5e82c75a20f2760e19ea3de5fc51f827', NULL, '111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'beb77a');
INSERT INTO `tb_user` VALUES (15, '13999999999', '4d8d206ef731cd74182a1f153459839d', NULL, '小聂同学', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '19bf3d');
INSERT INTO `tb_user` VALUES (17, '17605674681', 'c412a55581f35d01d33d8dbc4f8ac233', NULL, '小聂', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'e5230a');

SET FOREIGN_KEY_CHECKS = 1;
