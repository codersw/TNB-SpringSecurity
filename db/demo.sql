/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.4.162_3306
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : 192.168.4.162:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 07/04/2020 15:52:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept`  (
  `dept_id` int(11) NOT NULL COMMENT '部门id',
  `dept_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '部门名字',
  `parent_id` int(11) NOT NULL DEFAULT 0 COMMENT '父级id',
  `order_num` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modify_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `is_del` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除 0未删除 1已删除',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '部门信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `parent_id` int(11) NOT NULL DEFAULT 0 COMMENT '父级id',
  `menu_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '菜单/按钮名称',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '对应路由path',
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '对应路由组件component',
  `perms` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '权限标识',
  `icon` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '图标',
  `type` tinyint(4) NOT NULL DEFAULT 0 COMMENT '类型 0菜单 1按钮',
  `order_num` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modify_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `is_del` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除 0未删除 1已删除',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '菜单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES (1, 0, '用户管理', '/system/user', '', 'user:view', '', 0, 1, '2020-04-07 12:27:51', '2020-04-07 12:27:51', 0);
INSERT INTO `t_menu` VALUES (2, 1, '新增用户', '', '', 'user:add', '', 1, 1, '2020-04-07 12:28:36', '2020-04-07 12:28:36', 0);
INSERT INTO `t_menu` VALUES (3, 1, '修改用户', '', '', 'user:update', '', 1, 1, '2020-04-07 12:28:37', '2020-04-07 12:28:37', 0);
INSERT INTO `t_menu` VALUES (4, 1, '删除用户', '', '', 'user:delete', '', 1, 1, '2020-04-07 12:28:39', '2020-04-07 12:28:39', 0);
INSERT INTO `t_menu` VALUES (5, 0, '角色管理', '/system/role', '', 'role:view', '', 0, 2, '2020-04-07 12:28:50', '2020-04-07 12:28:50', 0);
INSERT INTO `t_menu` VALUES (6, 5, '新增角色', '', '', 'role:add', '', 1, 1, '2020-04-07 12:29:07', '2020-04-07 12:29:07', 0);
INSERT INTO `t_menu` VALUES (7, 5, '修改角色', '', '', 'role:update', '', 1, 1, '2020-04-07 12:29:08', '2020-04-07 12:29:08', 0);
INSERT INTO `t_menu` VALUES (8, 5, '删除角色', '', '', 'role:delete', '', 1, 1, '2020-04-07 12:29:10', '2020-04-07 12:29:10', 0);
INSERT INTO `t_menu` VALUES (9, 0, '菜单管理', '/system/menu', '', 'menu:view', '', 0, 3, '2020-04-07 12:29:16', '2020-04-07 12:29:16', 0);
INSERT INTO `t_menu` VALUES (10, 9, '新增菜单', '', '', 'menu:add', '', 1, 1, '2020-04-07 12:29:29', '2020-04-07 12:29:29', 0);
INSERT INTO `t_menu` VALUES (11, 9, '修改菜单', '', '', 'menu:update', '', 1, 1, '2020-04-07 12:29:31', '2020-04-07 12:29:31', 0);
INSERT INTO `t_menu` VALUES (12, 9, '删除菜单', '', '', 'menu:delete', '', 1, 1, '2020-04-07 12:29:33', '2020-04-07 12:29:33', 0);
INSERT INTO `t_menu` VALUES (13, 0, '部门管理', '/system/dept', '', 'dept:view', '', 0, 4, '2020-04-07 12:29:40', '2020-04-07 12:29:40', 0);
INSERT INTO `t_menu` VALUES (14, 13, '新增部门', '', '', 'dept:add', '', 1, 1, '2020-04-07 12:29:43', '2020-04-07 12:29:43', 0);
INSERT INTO `t_menu` VALUES (15, 13, '修改部门', '', '', 'dept:update', '', 1, 1, '2020-04-07 12:29:44', '2020-04-07 12:29:44', 0);
INSERT INTO `t_menu` VALUES (16, 13, '删除部门', '', '', 'dept:delete', '', 1, 1, '2020-04-07 12:29:45', '2020-04-07 12:29:45', 0);
INSERT INTO `t_menu` VALUES (17, 0, '标签管理', '/tag', '', 'tag:view', '', 0, 5, '2020-04-07 12:34:20', '2020-04-07 12:34:20', 0);
INSERT INTO `t_menu` VALUES (18, 17, '新增标签', '', '', 'tag:add', '', 0, 1, '2020-04-07 12:34:44', '2020-04-07 12:34:44', 0);
INSERT INTO `t_menu` VALUES (19, 17, '修改标签', '', '', 'tag:update', '', 0, 1, '2020-04-07 12:35:03', '2020-04-07 12:35:03', 0);
INSERT INTO `t_menu` VALUES (20, 17, '删除标签', '', '', 'tag:delete', '', 0, 1, '2020-04-07 12:35:21', '2020-04-07 12:35:21', 0);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '角色名称',
  `remark` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '角色描述',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modify_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `is_del` tinyint(4) NOT NULL COMMENT '是否删除 0 未删除 1 已删除',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, '管理员', '管理员', '2020-01-20 10:36:03', '2020-01-20 10:36:03', 0);
INSERT INTO `t_role` VALUES (2, '普通用户', '普通用户', '2020-01-20 10:36:04', '2020-01-20 10:36:04', 0);

-- ----------------------------
-- Table structure for t_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu`  (
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `menu_id` int(11) NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色菜单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_menu
-- ----------------------------
INSERT INTO `t_role_menu` VALUES (1, 1);
INSERT INTO `t_role_menu` VALUES (1, 2);
INSERT INTO `t_role_menu` VALUES (1, 3);
INSERT INTO `t_role_menu` VALUES (1, 4);
INSERT INTO `t_role_menu` VALUES (1, 5);
INSERT INTO `t_role_menu` VALUES (1, 6);
INSERT INTO `t_role_menu` VALUES (1, 7);
INSERT INTO `t_role_menu` VALUES (1, 8);
INSERT INTO `t_role_menu` VALUES (1, 9);
INSERT INTO `t_role_menu` VALUES (1, 10);
INSERT INTO `t_role_menu` VALUES (1, 11);
INSERT INTO `t_role_menu` VALUES (1, 12);
INSERT INTO `t_role_menu` VALUES (1, 13);
INSERT INTO `t_role_menu` VALUES (1, 14);
INSERT INTO `t_role_menu` VALUES (1, 15);
INSERT INTO `t_role_menu` VALUES (1, 16);
INSERT INTO `t_role_menu` VALUES (1, 17);
INSERT INTO `t_role_menu` VALUES (1, 18);
INSERT INTO `t_role_menu` VALUES (1, 19);
INSERT INTO `t_role_menu` VALUES (1, 20);
INSERT INTO `t_role_menu` VALUES (2, 17);
INSERT INTO `t_role_menu` VALUES (2, 18);
INSERT INTO `t_role_menu` VALUES (2, 19);
INSERT INTO `t_role_menu` VALUES (2, 20);

-- ----------------------------
-- Table structure for t_tag
-- ----------------------------
DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag`  (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签id',
  `tag_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '标签名字',
  `tag_desc` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '标签描述',
  `create_user_id` int(11) NOT NULL DEFAULT 0 COMMENT '创建人id',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modify_user_id` int(11) NOT NULL DEFAULT 0 COMMENT '修改人id',
  `modify_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `is_del` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除 0未删除 1 以删除',
  PRIMARY KEY (`tag_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '标签信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_tag
-- ----------------------------
INSERT INTO `t_tag` VALUES (38, '标签名字', '标签描述', 1, '2020-04-07 15:42:05', 1, '2020-04-07 15:42:05', 0);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '登录名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '用户密码',
  `mobile` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '手机号',
  `user_photo` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像图片',
  `sex` tinyint(4) NOT NULL DEFAULT 0 COMMENT '性别 0 男 1 女',
  `dept_id` int(11) NOT NULL DEFAULT 0 COMMENT '部门id',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modify_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '状态 0有效 1锁定',
  `is_del` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否删除 0 未删除 1 已删除',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'shaowen', '123456', '1888888888', NULL, 0, 0, '2020-04-07 15:08:29', '2020-04-07 15:08:29', 0, 0);
INSERT INTO `t_user` VALUES (2, 'test', '123456', '1888888888', NULL, 0, 0, '2020-04-07 15:46:36', '2020-04-07 15:46:36', 0, 0);

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role`  (
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES (1, 1);
INSERT INTO `t_user_role` VALUES (2, 2);

SET FOREIGN_KEY_CHECKS = 1;
