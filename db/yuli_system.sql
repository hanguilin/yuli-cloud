/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50713
 Source Host           : localhost:3306
 Source Schema         : yuli_system

 Target Server Type    : MySQL
 Target Server Version : 50713
 File Encoding         : 65001

 Date: 29/01/2021 16:43:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `del_flag` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES ('380e3eeeb05b456c9d479f0b2b9806f7', 'sys_flag', '2020-12-28 13:57:25', '1', '2021-01-28 18:08:23', 'd0c82e56a5224b1cb8d9cbd00386a015', '系统标志位', '0');
INSERT INTO `sys_dict_type` VALUES ('594cd281bb9a998de7d86dd7aa203eed', 'test', '2021-01-16 11:20:30', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, '测试缓存', '1');
INSERT INTO `sys_dict_type` VALUES ('ff17fe21c83b3b9d158180c552f026b6', 'test2', '2021-01-16 11:37:34', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, '1', '1');

-- ----------------------------
-- Table structure for sys_dict_value
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_value`;
CREATE TABLE `sys_dict_value`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `label` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签',
  `value` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '键值',
  `sort` int(5) NULL DEFAULT NULL COMMENT '排序',
  `type_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `del_flag` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_value
-- ----------------------------
INSERT INTO `sys_dict_value` VALUES ('380e3eeeb05b456c9d479f0b2b9806f7', '是', '0', 1, '380e3eeeb05b456c9d479f0b2b9806f7', '2020-12-28 13:57:25', '1', '2021-01-14 16:14:29', 'd0c82e56a5224b1cb8d9cbd00386a015', '', '0');
INSERT INTO `sys_dict_value` VALUES ('b42efb982515d4abf1d92cdbcb787a99', '是是', '3', 4, '380e3eeeb05b456c9d479f0b2b9806f7', '2021-01-14 16:15:01', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_dict_value` VALUES ('bff742ed3ae59dec361af5852ac1c095', '否', '1', 2, '380e3eeeb05b456c9d479f0b2b9806f7', NULL, NULL, '2021-01-14 16:14:39', 'd0c82e56a5224b1cb8d9cbd00386a015', '', '0');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `title` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路由',
  `url` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '外链路径',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `visible` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否显示',
  `type` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0、目录；1、菜单；2、按钮',
  `target` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '链接类型，0、系统页面；1、外链',
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `sort` int(5) NULL DEFAULT NULL COMMENT '排序',
  `parent_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `del_flag` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1a16c681385607d02331dbcb41c31385', '开发工具', '', '', 'fa fa-rocket', '0', '0', '0', '', 30, '', '2021-01-21 12:54:31', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, '', '0');
INSERT INTO `sys_menu` VALUES ('234571b5b2bab5e6786882fc78d985aa', 'sentinel', '/sentinel', 'http://localhost:7000', 'el-icon-s-opportunity', '0', '1', '1', '', 30, 'd9dcc7ae8e36fc5c19b82b60b30e443f', '2021-01-18 14:56:55', 'd0c82e56a5224b1cb8d9cbd00386a015', '2021-01-18 14:57:23', 'd0c82e56a5224b1cb8d9cbd00386a015', '', '0');
INSERT INTO `sys_menu` VALUES ('239ac5abd4190fcb649733b1e5ef6a99', '外链', '', NULL, 'fa fa-flag', '0', '0', '0', '', 30, '', '2021-01-13 18:19:41', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, '', '0');
INSERT INTO `sys_menu` VALUES ('243fe8f2cdd437ba107339b1dd5accde', 'swagger文档', '/swagger', 'http://network-yuli-getway:8000/swagger-ui.html', 'fa fa-file-o', '0', '1', '1', '', 40, '1a16c681385607d02331dbcb41c31385', '2021-01-28 10:41:42', 'd0c82e56a5224b1cb8d9cbd00386a015', '2021-01-28 10:46:21', 'd0c82e56a5224b1cb8d9cbd00386a015', '', '0');
INSERT INTO `sys_menu` VALUES ('305220e89e4adb184845c95ea6c305f6', '列表', '', '', '', '0', '2', '0', 'generator:genDatasourceConf:page', 30, 'b5968794471875f100b2448943f88f49', '2021-01-23 17:22:34', 'd0c82e56a5224b1cb8d9cbd00386a015', '2021-01-24 11:23:28', 'd0c82e56a5224b1cb8d9cbd00386a015', '', '0');
INSERT INTO `sys_menu` VALUES ('345525f783fed9394687075eab6ae0e8', 'nacos', '/nacos', 'http://localhost:8848/nacos', 'el-icon-s-opportunity', '0', '1', '1', '', 30, 'd9dcc7ae8e36fc5c19b82b60b30e443f', '2021-01-18 15:02:53', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, '', '0');
INSERT INTO `sys_menu` VALUES ('3821884b57db14bb40609151c2d225ae', '修改', '', '', '', '0', '2', '0', 'quartz:sysQuartzJob:update', 40, '6ad658de7c72f4c893875521bfacb074', '2021-01-28 14:21:00', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, '', '0');
INSERT INTO `sys_menu` VALUES ('3e4f7e0639fb47dda548998c285e3702', '菜单管理', '/sys/menu/MenuIndex', NULL, 'fa fa-list', '0', '1', '0', 'sys:menu:view', 10, '3e4f7e0639fb47dda548998c285e3736', '2020-12-28 14:04:08', '1', '2021-01-14 13:51:26', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, '0');
INSERT INTO `sys_menu` VALUES ('3e4f7e0639fb47dda548998c285e3736', '权限管理', '', '', 'fa fa-cog', '0', '0', '0', 'sys:menu:view', 1, NULL, '2020-12-28 14:04:08', '1', '2021-01-14 13:51:26', 'd0c82e56a5224b1cb8d9cbd00386a015', '', '0');
INSERT INTO `sys_menu` VALUES ('3e4f7e0639fb47dda548998c285e3756', '页面1', '/demo/page1/index', NULL, 'fa fa-black-tie', '0', '1', '0', 'sys:menu:view', 2, NULL, '2020-12-28 14:04:08', '1', NULL, '1', '', '1');
INSERT INTO `sys_menu` VALUES ('3e4f7e0639fb47dda548998c285e3757', '页面2', '/demo/page2/index', NULL, 'el-icon-search', '0', '1', '0', 'sys:menu:view', 3, NULL, '2020-12-28 14:04:08', '1', NULL, '1', '', '1');
INSERT INTO `sys_menu` VALUES ('44f22b3bb8be65684c43687d47b0eb5f', '新建', '', '', '', '0', '2', '0', 'generator:genDatasourceConf:save', 30, 'b5968794471875f100b2448943f88f49', '2021-01-23 17:21:13', 'd0c82e56a5224b1cb8d9cbd00386a015', '2021-01-24 11:23:28', 'd0c82e56a5224b1cb8d9cbd00386a015', '', '0');
INSERT INTO `sys_menu` VALUES ('5ec0cf0f7b10de101e2fedcd49d58cd1', '个人博客', '/blog', 'https://blog.javayuli.cn', 'el-icon-s-comment', '0', '1', '1', '', 30, '239ac5abd4190fcb649733b1e5ef6a99', '2021-01-13 18:22:48', 'd0c82e56a5224b1cb8d9cbd00386a015', '2021-01-14 09:52:26', 'd0c82e56a5224b1cb8d9cbd00386a015', '', '0');
INSERT INTO `sys_menu` VALUES ('6a0c792088e4576b65e15cb22899095b', 'nacos', '/nacos', '/nacos', 'el-icon-box', '0', '1', '1', '', 30, '239ac5abd4190fcb649733b1e5ef6a99', '2021-01-14 09:10:48', 'd0c82e56a5224b1cb8d9cbd00386a015', '2021-01-14 13:48:08', 'd0c82e56a5224b1cb8d9cbd00386a015', '', '1');
INSERT INTO `sys_menu` VALUES ('6ad658de7c72f4c893875521bfacb074', '定时任务', '/sys/quartz/SysQuartzJobIndex', '', 'fa fa-clock-o', '0', '1', '0', '', 30, 'd24995bf82bf48e91a6fe6b7cc812f2d', '2021-01-28 14:18:20', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, '', '0');
INSERT INTO `sys_menu` VALUES ('6ffaa221078cf76effe300d60c07876c', '页面3', '/demo/page3/index', NULL, 'el-icon-success', '0', '1', '0', 'sys:menu:view', 30, NULL, NULL, NULL, NULL, NULL, '', '1');
INSERT INTO `sys_menu` VALUES ('7322f83175a3f7cac7c6c86db79fee39', '用户管理', '/sys/user/UserIndex', '', 'fa fa-user', '0', '1', '0', 'sys:user:list', 20, '3e4f7e0639fb47dda548998c285e3736', NULL, NULL, '2021-01-29 16:11:29', 'd0c82e56a5224b1cb8d9cbd00386a015', '', '0');
INSERT INTO `sys_menu` VALUES ('7ac0cec0f9b723150d3ab76e08403ec0', '新建', '', '', '', '0', '2', '0', 'quartz:sysQuartzJob:save', 20, '6ad658de7c72f4c893875521bfacb074', '2021-01-28 14:20:04', 'd0c82e56a5224b1cb8d9cbd00386a015', '2021-01-28 14:20:36', 'd0c82e56a5224b1cb8d9cbd00386a015', '', '0');
INSERT INTO `sys_menu` VALUES ('8444b41000ecf8a5628909e584f93996', '列表', '', '', '', '0', '2', '0', 'sys:role:list', 30, '91e047affda077f3fad71d8a9de1c110', '2021-01-14 17:55:44', 'd0c82e56a5224b1cb8d9cbd00386a015', '2021-01-29 16:11:39', 'd0c82e56a5224b1cb8d9cbd00386a015', '', '0');
INSERT INTO `sys_menu` VALUES ('849d881d928f8929758f138a9eacab1a', '修改', '', '', '', '0', '2', '0', 'generator:genDatasourceConf:update', 30, 'b5968794471875f100b2448943f88f49', '2021-01-23 17:21:53', 'd0c82e56a5224b1cb8d9cbd00386a015', '2021-01-24 11:23:28', 'd0c82e56a5224b1cb8d9cbd00386a015', '', '0');
INSERT INTO `sys_menu` VALUES ('8d53d7a70067655dbb344f432fc02e65', '百度', '/baidu', 'https://www.baidu.com', 'fa fa-paw', '0', '1', '1', '', 30, '239ac5abd4190fcb649733b1e5ef6a99', '2021-01-14 13:40:33', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, '', '0');
INSERT INTO `sys_menu` VALUES ('91e047affda077f3fad71d8a9de1c110', '角色管理', '/sys/role/RoleIndex', '', 'fa fa-users', '0', '1', '0', 'user:role:list', 30, '3e4f7e0639fb47dda548998c285e3736', NULL, NULL, '2021-01-29 16:11:39', 'd0c82e56a5224b1cb8d9cbd00386a015', '', '0');
INSERT INTO `sys_menu` VALUES ('94570c1dfa813dd6e2386163c4662e0a', '列表', '', '', '', '0', '2', '0', 'generator:table:page', 30, 'd0afa19fcfd59aea078c407a144057b8', '2021-01-24 11:19:06', 'd0c82e56a5224b1cb8d9cbd00386a015', '2021-01-24 11:28:53', 'd0c82e56a5224b1cb8d9cbd00386a015', '', '0');
INSERT INTO `sys_menu` VALUES ('9784a170e894bbbfb8a9d294a993334d', '字典管理', '/sys/dict/type/DictTypeIndex', '', 'fa fa-header', '0', '1', '0', 'sys:dict:list', 30, 'd24995bf82bf48e91a6fe6b7cc812f2d', '2021-01-14 13:54:55', 'd0c82e56a5224b1cb8d9cbd00386a015', '2021-01-29 16:14:49', 'd0c82e56a5224b1cb8d9cbd00386a015', '', '0');
INSERT INTO `sys_menu` VALUES ('a23df5be32feebf66b3a52320140ef8d', '机构管理', '/sys/office/OfficeIndex', '', 'fa fa-university', '0', '1', '0', 'sys:office:list', 40, '3e4f7e0639fb47dda548998c285e3736', NULL, NULL, '2021-01-29 16:11:53', 'd0c82e56a5224b1cb8d9cbd00386a015', '', '0');
INSERT INTO `sys_menu` VALUES ('a41464a4c6b2797aedf4322e4a1b1fe4', '外部链接', 'https://www.baidu.com', NULL, 'el-icon-sunrise-1', '0', '1', '0', '', 30, '', '2021-01-13 16:51:06', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, '', '1');
INSERT INTO `sys_menu` VALUES ('a7fd3db29f48170138a96e900ecc26e8', '删除', '', '', '', '0', '2', '0', 'generator:genDatasourceConf:delete', 30, 'b5968794471875f100b2448943f88f49', '2021-01-23 17:21:32', 'd0c82e56a5224b1cb8d9cbd00386a015', '2021-01-24 11:23:28', 'd0c82e56a5224b1cb8d9cbd00386a015', '', '0');
INSERT INTO `sys_menu` VALUES ('b03042ed303953c634abc4a627c19bb8', '列表', '', '', '', '0', '2', '0', 'quartz:sysQuartzJob:page', 10, '6ad658de7c72f4c893875521bfacb074', '2021-01-28 14:19:16', 'd0c82e56a5224b1cb8d9cbd00386a015', '2021-01-28 14:20:32', 'd0c82e56a5224b1cb8d9cbd00386a015', '', '0');
INSERT INTO `sys_menu` VALUES ('b52ef1cf7ee65b5e63b04fd60b75d96f', '查询', '', '', '', '0', '2', '0', 'generator:genDatasourceConf:info', 30, 'b5968794471875f100b2448943f88f49', '2021-01-23 17:22:20', 'd0c82e56a5224b1cb8d9cbd00386a015', '2021-01-24 11:23:28', 'd0c82e56a5224b1cb8d9cbd00386a015', '', '0');
INSERT INTO `sys_menu` VALUES ('b5968794471875f100b2448943f88f49', '数据源管理', '/sys/generator/datasource/GenDatasourceConfIndex', '', 'fa fa-save', '0', '1', '0', '', 30, '1a16c681385607d02331dbcb41c31385', '2021-01-21 13:01:03', 'd0c82e56a5224b1cb8d9cbd00386a015', '2021-01-24 11:23:28', 'd0c82e56a5224b1cb8d9cbd00386a015', '', '0');
INSERT INTO `sys_menu` VALUES ('cacab4b3a3986bfd4268452065284ab3', 'test', '', NULL, '', '0', '1', '0', '', 30, 'cacab4b3a3986bfd4268452065284ab4', NULL, NULL, NULL, NULL, '', '1');
INSERT INTO `sys_menu` VALUES ('cacab4b3a3986bfd4268452065284ab4', 'test2', '', NULL, '', '0', '1', '0', '', 30, '', NULL, NULL, NULL, NULL, '', '1');
INSERT INTO `sys_menu` VALUES ('d0afa19fcfd59aea078c407a144057b8', '表单配置', '/sys/generator/table/TableIndex', '', 'fa fa-list-alt', '0', '1', '0', '', 30, '1a16c681385607d02331dbcb41c31385', '2021-01-21 13:03:00', 'd0c82e56a5224b1cb8d9cbd00386a015', '2021-01-24 11:28:53', 'd0c82e56a5224b1cb8d9cbd00386a015', '', '0');
INSERT INTO `sys_menu` VALUES ('d24995bf82bf48e91a6fe6b7cc812f2d', '系统配置', '', '', 'fa fa-gears', '0', '0', '0', '', 2, '', '2021-01-14 13:52:16', 'd0c82e56a5224b1cb8d9cbd00386a015', '2021-01-14 13:52:50', 'd0c82e56a5224b1cb8d9cbd00386a015', '', '0');
INSERT INTO `sys_menu` VALUES ('d5aa5b2aed5f12ab9485fc2e35e9206c', '删除', '', '', '', '0', '2', '0', 'quartz:sysQuartzJob:delete', 30, '6ad658de7c72f4c893875521bfacb074', '2021-01-28 14:20:18', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, '', '0');
INSERT INTO `sys_menu` VALUES ('d9dcc7ae8e36fc5c19b82b60b30e443f', '运行监控', '', '', 'el-icon-s-platform', '0', '0', '0', '', 30, NULL, '2021-01-18 14:55:43', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, '', '0');
INSERT INTO `sys_menu` VALUES ('dfe12b03a1ca02a393b6818a39dc117e', 'knife4j文档', '/knife4j', 'http://network-yuli-getway:8000/doc.html', 'fa fa-file-o', '0', '1', '1', '', 50, '1a16c681385607d02331dbcb41c31385', '2021-01-28 10:46:12', 'd0c82e56a5224b1cb8d9cbd00386a015', '2021-01-28 10:46:37', 'd0c82e56a5224b1cb8d9cbd00386a015', '', '0');
INSERT INTO `sys_menu` VALUES ('e8d4f1a23b5e12c7a2be82c1b4968dd8', '详情', '', '', '', '0', '2', '0', 'quartz:sysQuartzJob:info', 50, '6ad658de7c72f4c893875521bfacb074', '2021-01-28 14:21:15', 'd0c82e56a5224b1cb8d9cbd00386a015', '2021-01-28 14:21:23', 'd0c82e56a5224b1cb8d9cbd00386a015', '', '0');
INSERT INTO `sys_menu` VALUES ('f03c96a900ccae531765edc7688f0dfc', '新建', '', '', '', '0', '2', '0', 'sys:role:add', 30, '91e047affda077f3fad71d8a9de1c110', '2021-01-14 17:17:34', 'd0c82e56a5224b1cb8d9cbd00386a015', '2021-01-29 16:11:39', 'd0c82e56a5224b1cb8d9cbd00386a015', '', '0');

-- ----------------------------
-- Table structure for sys_office
-- ----------------------------
DROP TABLE IF EXISTS `sys_office`;
CREATE TABLE `sys_office`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构名称',
  `enabled` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否启用',
  `type` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0、公司；1、部门；2、团队；3、其他',
  `sort` int(5) NULL DEFAULT NULL COMMENT '排序',
  `parent_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `del_flag` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_office
-- ----------------------------
INSERT INTO `sys_office` VALUES ('5df4b176d0d6d5e92c28a68574cbf7d1', '*******公司', '0', '0', 30, '', NULL, NULL, '2021-01-13 15:11:25', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, '0');
INSERT INTO `sys_office` VALUES ('e9c5ee49db4ca2a200602825b5ba3f03', '地表最强开发团队', '0', '1', 30, '5df4b176d0d6d5e92c28a68574cbf7d1', NULL, NULL, '2021-01-13 15:11:58', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, '0');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `en_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色英文名称',
  `system` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否系统数据',
  `enabled` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否启用',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `del_flag` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('380e3eeeb05b456c9d479f0b2b9806f7', '超级管理员', 'admin', '0', '0', '2020-12-28 13:57:25', '1', '2020-12-28 13:57:28', '1', '', '0');
INSERT INTO `sys_role` VALUES ('7e7afdfdb1d0f6fc62d4ecb92136df21', '测试', 'test', '0', '0', '2021-01-14 18:03:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, '', '1');
INSERT INTO `sys_role` VALUES ('85513071accd9951fc92cc7453e43abe', '测试', 'test', '0', '0', '2021-01-15 10:23:05', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, '', '1');
INSERT INTO `sys_role` VALUES ('8ef866808c8524793f4cf828a5005587', '测试', 'test', '0', '0', '2021-01-15 10:23:57', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, '', '1');
INSERT INTO `sys_role` VALUES ('bff742ed3ae59dec361af5852ac1c095', '普通管理员', 'common_admin', '0', '0', NULL, NULL, NULL, NULL, '', '0');
INSERT INTO `sys_role` VALUES ('cf213e3048c91144357350066fd05b59', '测试', 'test', '0', '0', '2021-01-15 11:26:16', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, '', '1');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色id',
  `menu_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `del_flag` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('0131911d464a8c75c24b45b77559dee9', '380e3eeeb05b456c9d479f0b2b9806f7', '5ec0cf0f7b10de101e2fedcd49d58cd1', '2021-01-14 14:40:13', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('01cc612d2d4a40f836fc8e158d72e724', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3736', '2021-01-13 16:51:26', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('02eff249fda78efbb854ba27c262f25b', '380e3eeeb05b456c9d479f0b2b9806f7', '849d881d928f8929758f138a9eacab1a', '2021-01-24 11:21:19', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('04648e1054e9fa8ec2eca85303e427d6', '380e3eeeb05b456c9d479f0b2b9806f7', '8d53d7a70067655dbb344f432fc02e65', '2021-01-28 14:18:30', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('056d0b5377272eab8ea8059451b3c210', '380e3eeeb05b456c9d479f0b2b9806f7', 'd24995bf82bf48e91a6fe6b7cc812f2d', '2021-01-14 17:57:11', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('05cfbe787039b417978e49f45a29192d', '380e3eeeb05b456c9d479f0b2b9806f7', '8444b41000ecf8a5628909e584f93996', '2021-01-28 10:46:45', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('05f6b3b6c675130ce03ce1f840839f78', '380e3eeeb05b456c9d479f0b2b9806f7', '9784a170e894bbbfb8a9d294a993334d', '2021-01-28 10:46:45', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('061220add62c7edeea99fb1c0c27d50b', '380e3eeeb05b456c9d479f0b2b9806f7', '8444b41000ecf8a5628909e584f93996', '2021-01-18 15:03:02', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('06437cfb3a18ff48f52f71432b5f6289', '380e3eeeb05b456c9d479f0b2b9806f7', '7322f83175a3f7cac7c6c86db79fee39', '2021-01-14 17:57:11', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('06e2ce4affc6dd3eb6b622ddba4229e8', '380e3eeeb05b456c9d479f0b2b9806f7', '243fe8f2cdd437ba107339b1dd5accde', '2021-01-28 14:18:30', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('0810fa37442b2cb3589e3ca370adfc26', '380e3eeeb05b456c9d479f0b2b9806f7', '44f22b3bb8be65684c43687d47b0eb5f', '2021-01-23 17:33:15', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('0822c34c381cb5dd070ee0f89d7ccf0b', '380e3eeeb05b456c9d479f0b2b9806f7', '7322f83175a3f7cac7c6c86db79fee39', '2021-01-14 09:11:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('08e3fa590b4be21890fec040cd07697a', '380e3eeeb05b456c9d479f0b2b9806f7', '9784a170e894bbbfb8a9d294a993334d', '2021-01-21 13:03:34', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('09706866a93f5fd1ca731eb299533cbe', '380e3eeeb05b456c9d479f0b2b9806f7', 'a23df5be32feebf66b3a52320140ef8d', '2021-01-14 17:18:05', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('0a8c5d586419ee2771fd151099f16fc8', '380e3eeeb05b456c9d479f0b2b9806f7', '305220e89e4adb184845c95ea6c305f6', '2021-01-23 17:30:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('0ba8b600aee7ecb8e129d11807e89195', '380e3eeeb05b456c9d479f0b2b9806f7', 'a23df5be32feebf66b3a52320140ef8d', '2021-01-28 10:46:45', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('0cf7a3adfb955149a92055cb6c7276da', '380e3eeeb05b456c9d479f0b2b9806f7', '239ac5abd4190fcb649733b1e5ef6a99', '2021-01-28 14:18:30', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('0f2715d5855bf28a4832477427200978', '380e3eeeb05b456c9d479f0b2b9806f7', '5ec0cf0f7b10de101e2fedcd49d58cd1', '2021-01-23 17:33:15', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('0fba5aa296bda22cb817e24dc2c350f2', '380e3eeeb05b456c9d479f0b2b9806f7', '9784a170e894bbbfb8a9d294a993334d', '2021-01-23 17:22:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('100e8fc19ff3097df95fc3506edc283b', '380e3eeeb05b456c9d479f0b2b9806f7', 'b52ef1cf7ee65b5e63b04fd60b75d96f', '2021-01-23 17:33:15', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('11f056afb39db779e5e7e20e3679b6e7', '380e3eeeb05b456c9d479f0b2b9806f7', 'd9dcc7ae8e36fc5c19b82b60b30e443f', '2021-01-23 17:33:15', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('12174da00688c81484efd29adbde8ae0', '380e3eeeb05b456c9d479f0b2b9806f7', 'a23df5be32feebf66b3a52320140ef8d', '2021-01-18 15:03:02', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('12a87bc166a3c033ac99be06bfd88f69', '380e3eeeb05b456c9d479f0b2b9806f7', '91e047affda077f3fad71d8a9de1c110', '2021-01-15 10:22:28', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('12af76f002d7e97c5eb834b9e9318c22', '380e3eeeb05b456c9d479f0b2b9806f7', '8444b41000ecf8a5628909e584f93996', '2021-01-15 11:26:34', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('12dfde1359cd86b63e7e40cf05507462', '380e3eeeb05b456c9d479f0b2b9806f7', '91e047affda077f3fad71d8a9de1c110', '2021-01-18 14:57:02', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('138b5c37455433ce1aa9b16215f39965', '380e3eeeb05b456c9d479f0b2b9806f7', '9784a170e894bbbfb8a9d294a993334d', '2021-01-14 14:40:13', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('1500de30115b2e953a3aac976633727b', '380e3eeeb05b456c9d479f0b2b9806f7', '345525f783fed9394687075eab6ae0e8', '2021-01-23 17:30:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('152cbcfe7fe9ef2ab6e6bd71712d1504', '380e3eeeb05b456c9d479f0b2b9806f7', 'a23df5be32feebf66b3a52320140ef8d', '2021-01-14 18:02:25', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('1565b5c10514c861f2a2ea1f8e38fadc', '380e3eeeb05b456c9d479f0b2b9806f7', '9784a170e894bbbfb8a9d294a993334d', '2021-01-15 10:22:28', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('15958df4edfdccc89459ca383c7bbec6', '380e3eeeb05b456c9d479f0b2b9806f7', '91e047affda077f3fad71d8a9de1c110', '2021-01-14 13:40:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('16196c151483eeee63bf3c6a6875974f', '380e3eeeb05b456c9d479f0b2b9806f7', '91e047affda077f3fad71d8a9de1c110', '2021-01-24 11:21:19', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('16e03d3637091c667236670992a9d8e3', '380e3eeeb05b456c9d479f0b2b9806f7', '91e047affda077f3fad71d8a9de1c110', '2021-01-28 10:41:59', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('1738210b9189ee16744acceeb5e66413', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3702', '2021-01-13 16:51:26', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('18292a303ec22c735125582bc171310e', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3702', '2021-01-14 13:52:33', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('18accd9fea84f1774056d1110fef51d6', '380e3eeeb05b456c9d479f0b2b9806f7', '849d881d928f8929758f138a9eacab1a', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('18ca33935c30a8961e2ff75060417dda', '380e3eeeb05b456c9d479f0b2b9806f7', '234571b5b2bab5e6786882fc78d985aa', '2021-01-23 17:33:15', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('1a67e11231209cd95ea21a29fabe1310', '380e3eeeb05b456c9d479f0b2b9806f7', 'd0afa19fcfd59aea078c407a144057b8', '2021-01-28 10:41:59', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('1a8209026de5fa990b2ce342fe644b1f', '380e3eeeb05b456c9d479f0b2b9806f7', '91e047affda077f3fad71d8a9de1c110', '2021-01-28 14:18:30', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('1b2c8db71eace464446d6630cd1e7acf', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3736', '2021-01-13 18:29:47', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('1bc480a8ec0d9aafb19b59fc0a1436f8', '380e3eeeb05b456c9d479f0b2b9806f7', '7322f83175a3f7cac7c6c86db79fee39', '2021-01-14 17:18:05', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('1c8234b0a1c3455938ac6490fc06d2d7', '380e3eeeb05b456c9d479f0b2b9806f7', 'd24995bf82bf48e91a6fe6b7cc812f2d', '2021-01-14 17:18:05', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('1da28f1c49269d43fe58317242e091c1', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3702', '2021-01-15 11:26:34', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('1edd8f2f17b74db72d4bb863b6f38ca4', '380e3eeeb05b456c9d479f0b2b9806f7', 'd5aa5b2aed5f12ab9485fc2e35e9206c', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('1f1d656804a51775a69b30994ab63dd3', '380e3eeeb05b456c9d479f0b2b9806f7', 'a23df5be32feebf66b3a52320140ef8d', '2021-01-14 13:52:33', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('1f20e2968b4e5f28f31b3aefad0aee05', '380e3eeeb05b456c9d479f0b2b9806f7', 'a23df5be32feebf66b3a52320140ef8d', '2021-01-14 09:11:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('208e05cdf43966c79ee87eb19b10e17e', '380e3eeeb05b456c9d479f0b2b9806f7', '94570c1dfa813dd6e2386163c4662e0a', '2021-01-24 11:21:19', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('20c3a50b45e06b7fc15bb54861415bdd', '380e3eeeb05b456c9d479f0b2b9806f7', 'a7fd3db29f48170138a96e900ecc26e8', '2021-01-24 11:21:19', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('211c9ea6f958de571fe78a81c43e613f', '380e3eeeb05b456c9d479f0b2b9806f7', 'a23df5be32feebf66b3a52320140ef8d', '2021-01-24 11:21:19', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('218594cd5a19c0745ac3a49e23cb64d2', '380e3eeeb05b456c9d479f0b2b9806f7', '243fe8f2cdd437ba107339b1dd5accde', '2021-01-28 10:46:45', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('220377538dedb0fb93eb78171f21aa32', '380e3eeeb05b456c9d479f0b2b9806f7', '6a0c792088e4576b65e15cb22899095b', '2021-01-14 13:40:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('221e52f19d2ce8dfb70f826f37f0d4b9', '380e3eeeb05b456c9d479f0b2b9806f7', '7322f83175a3f7cac7c6c86db79fee39', '2021-01-23 17:30:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('2359b4f9f5eba28a65c339b5177e065f', '380e3eeeb05b456c9d479f0b2b9806f7', '849d881d928f8929758f138a9eacab1a', '2021-01-23 17:30:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('23d0946cad0df171a45d0f6abcbf3e15', '380e3eeeb05b456c9d479f0b2b9806f7', '5ec0cf0f7b10de101e2fedcd49d58cd1', '2021-01-14 17:57:11', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('24afa504ce5341fcdb97b31a16a9b735', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3702', '2021-01-15 10:22:28', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('26f407ea81f7786f8d4e506c4748eec5', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3702', '2021-01-14 17:57:11', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('271a7ca4335af1fb63281274f526f443', '380e3eeeb05b456c9d479f0b2b9806f7', '7322f83175a3f7cac7c6c86db79fee39', '2021-01-28 10:41:59', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('2746a25b55a74259cbeb973393a926e7', '380e3eeeb05b456c9d479f0b2b9806f7', '8444b41000ecf8a5628909e584f93996', '2021-01-21 13:03:34', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('28127048216e29f254c5525b4b7d6803', '380e3eeeb05b456c9d479f0b2b9806f7', '44f22b3bb8be65684c43687d47b0eb5f', '2021-01-28 10:46:45', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('29177357c91d7d0799b32b716401d9ce', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3736', '2021-01-28 14:18:30', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('29397fa3b4633cb08407853f380807ff', '380e3eeeb05b456c9d479f0b2b9806f7', '239ac5abd4190fcb649733b1e5ef6a99', '2021-01-15 11:26:34', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('2a178b731a6cc7b1c71ce92ae013b7fb', '380e3eeeb05b456c9d479f0b2b9806f7', 'b5968794471875f100b2448943f88f49', '2021-01-21 13:03:34', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('2a77a5e70605a04b3d9bff366d3144ca', '380e3eeeb05b456c9d479f0b2b9806f7', '345525f783fed9394687075eab6ae0e8', '2021-01-28 14:18:30', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('2b49b7df06e64ab7d3b05a0c75f064ec', '380e3eeeb05b456c9d479f0b2b9806f7', 'b5968794471875f100b2448943f88f49', '2021-01-23 17:33:15', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('2b68ad557503fc55241fe2963d822f23', '380e3eeeb05b456c9d479f0b2b9806f7', '8d53d7a70067655dbb344f432fc02e65', '2021-01-23 17:22:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('2bb703214a215e429ad15c3dd2d59ba6', '380e3eeeb05b456c9d479f0b2b9806f7', '234571b5b2bab5e6786882fc78d985aa', '2021-01-28 14:18:30', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('2ccf674c4bf732c02ec7ad01115a5b2e', '380e3eeeb05b456c9d479f0b2b9806f7', '8d53d7a70067655dbb344f432fc02e65', '2021-01-18 14:57:02', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('2cd06b7e0e337e77f0df009af7366bad', '380e3eeeb05b456c9d479f0b2b9806f7', '9784a170e894bbbfb8a9d294a993334d', '2021-01-23 17:30:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('2e13e1affec7e1c27f196b1172f2a445', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3702', '2021-01-14 17:54:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('2e831101ea3a9fe2cce39640be9d9477', '380e3eeeb05b456c9d479f0b2b9806f7', 'a41464a4c6b2797aedf4322e4a1b1fe4', '2021-01-13 16:51:26', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('2e8890af4b87733a8520784dca66f201', '380e3eeeb05b456c9d479f0b2b9806f7', 'd24995bf82bf48e91a6fe6b7cc812f2d', '2021-01-15 10:22:10', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('2e9e296551121784c3b36d09bed12312', '380e3eeeb05b456c9d479f0b2b9806f7', 'a23df5be32feebf66b3a52320140ef8d', '2021-01-15 10:22:28', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('30cc2091ab335585b587d7e6526cbd73', '380e3eeeb05b456c9d479f0b2b9806f7', '5ec0cf0f7b10de101e2fedcd49d58cd1', '2021-01-23 17:30:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('30e78ffd82441f43e06dea2667e06dfc', '380e3eeeb05b456c9d479f0b2b9806f7', 'b5968794471875f100b2448943f88f49', '2021-01-23 17:30:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('31ca2eb64eaaa0a4a5156d5dcc6d8d45', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3702', '2021-01-18 15:03:02', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('324dc5950c70f06e6312aea69af8b610', '380e3eeeb05b456c9d479f0b2b9806f7', '7322f83175a3f7cac7c6c86db79fee39', '2021-01-15 10:22:28', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('331e141b9f1d147fe5c11af115cfdbc8', '380e3eeeb05b456c9d479f0b2b9806f7', '8d53d7a70067655dbb344f432fc02e65', '2021-01-24 11:21:19', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('33b0a138da05e58a2bb7af27a236af52', '380e3eeeb05b456c9d479f0b2b9806f7', '234571b5b2bab5e6786882fc78d985aa', '2021-01-23 17:22:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('344c9915c142d2b07ed70c44fe13cf82', '380e3eeeb05b456c9d479f0b2b9806f7', '8d53d7a70067655dbb344f432fc02e65', '2021-01-14 17:54:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('367eea37cd3d55d929c63a71b5b370ea', '380e3eeeb05b456c9d479f0b2b9806f7', '9784a170e894bbbfb8a9d294a993334d', '2021-01-18 14:55:50', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('3698ae9814a5f9a36f9792b648c50957', '380e3eeeb05b456c9d479f0b2b9806f7', 'd9dcc7ae8e36fc5c19b82b60b30e443f', '2021-01-18 15:03:02', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('38ef0c0ac6783e23237500fe64854624', '380e3eeeb05b456c9d479f0b2b9806f7', '8d53d7a70067655dbb344f432fc02e65', '2021-01-23 17:30:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('3ad76e929794e7bf6c4725c870e13e81', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3702', '2021-01-13 18:29:47', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('3c47186130a0d2adffb0e2c3617b1525', '380e3eeeb05b456c9d479f0b2b9806f7', 'a23df5be32feebf66b3a52320140ef8d', '2021-01-23 17:30:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('3cb0e5cb96c438f544c2494675fa9ac1', '380e3eeeb05b456c9d479f0b2b9806f7', '7322f83175a3f7cac7c6c86db79fee39', '2021-01-21 13:03:34', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('3d056ba4876f5f3f29178cff7ba460e5', '380e3eeeb05b456c9d479f0b2b9806f7', '7322f83175a3f7cac7c6c86db79fee39', '2021-01-14 17:54:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('3da90b795bc6919a0e4f9f6cdca6c93e', '380e3eeeb05b456c9d479f0b2b9806f7', 'd24995bf82bf48e91a6fe6b7cc812f2d', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('3e4f7e0639fb47dda548998c285e3702', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3702', NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('3e4f7e0639fb47dda548998c285e3736', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3736', NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('3f62dcd4e8d03234039d428ca2b499ab', '380e3eeeb05b456c9d479f0b2b9806f7', '239ac5abd4190fcb649733b1e5ef6a99', '2021-01-14 17:57:11', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('3ff60996d578984c387656f9421c31f6', '380e3eeeb05b456c9d479f0b2b9806f7', '8444b41000ecf8a5628909e584f93996', '2021-01-23 17:33:15', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('402513e9bfca078a76b9470a0b269ab2', '380e3eeeb05b456c9d479f0b2b9806f7', '8444b41000ecf8a5628909e584f93996', '2021-01-14 18:03:27', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('425ac515d9a6c04623cced53dbf8c1d6', '380e3eeeb05b456c9d479f0b2b9806f7', '91e047affda077f3fad71d8a9de1c110', '2021-01-14 09:11:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('430cb859333c4dbfbf51b5d94bcd8655', '380e3eeeb05b456c9d479f0b2b9806f7', '5ec0cf0f7b10de101e2fedcd49d58cd1', '2021-01-14 17:54:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('4312747972ae6604f36574e82d606c2c', '380e3eeeb05b456c9d479f0b2b9806f7', '44f22b3bb8be65684c43687d47b0eb5f', '2021-01-23 17:22:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('439cdc16eee298b857c7bc79303a93b9', '380e3eeeb05b456c9d479f0b2b9806f7', '1a16c681385607d02331dbcb41c31385', '2021-01-23 17:33:15', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('441b366a3a64e90003dff0224a3837a0', '380e3eeeb05b456c9d479f0b2b9806f7', '239ac5abd4190fcb649733b1e5ef6a99', '2021-01-28 10:46:45', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('444be20eeab82cad63f54a47910da9f1', '380e3eeeb05b456c9d479f0b2b9806f7', '5ec0cf0f7b10de101e2fedcd49d58cd1', '2021-01-14 18:03:27', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('44fded3ab984f0e7656aa4a4811fb4bb', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3702', '2021-01-14 09:11:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('453fa3d36d519016c37d3518722f80ed', '380e3eeeb05b456c9d479f0b2b9806f7', '7322f83175a3f7cac7c6c86db79fee39', '2021-01-14 17:57:49', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('476b1c4b234fd5b8a828c508d8eeaade', '380e3eeeb05b456c9d479f0b2b9806f7', '849d881d928f8929758f138a9eacab1a', '2021-01-28 10:41:59', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('477142c6296ffa5f5043927cd4984dcb', '380e3eeeb05b456c9d479f0b2b9806f7', '305220e89e4adb184845c95ea6c305f6', '2021-01-24 11:21:19', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('47d904f79c71f0cd91525a249ced339b', '380e3eeeb05b456c9d479f0b2b9806f7', '1a16c681385607d02331dbcb41c31385', '2021-01-24 11:21:19', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('47db4969b2ce16c2a81e9e2c4bfd1964', '380e3eeeb05b456c9d479f0b2b9806f7', 'a7fd3db29f48170138a96e900ecc26e8', '2021-01-28 10:41:59', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('480a1c0fe6b4faad8877ae8f65a627c2', '380e3eeeb05b456c9d479f0b2b9806f7', 'b52ef1cf7ee65b5e63b04fd60b75d96f', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('4a065f3c55b6b4f5b46b2967f10f9fb5', '380e3eeeb05b456c9d479f0b2b9806f7', '305220e89e4adb184845c95ea6c305f6', '2021-01-28 10:41:59', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('4a19c43d4c12f25884a77d2c9fe3e86b', '380e3eeeb05b456c9d479f0b2b9806f7', 'd0afa19fcfd59aea078c407a144057b8', '2021-01-23 17:30:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('4a36e8200fed27a112b234ac6e5c8ce6', '380e3eeeb05b456c9d479f0b2b9806f7', '91e047affda077f3fad71d8a9de1c110', '2021-01-23 17:30:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('4a6e63cd138458b3482812e1610d0155', '380e3eeeb05b456c9d479f0b2b9806f7', '243fe8f2cdd437ba107339b1dd5accde', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('4a704e7fab3e34e8f3f39c80b239b772', '380e3eeeb05b456c9d479f0b2b9806f7', '345525f783fed9394687075eab6ae0e8', '2021-01-28 10:46:45', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('4aa2183cba069d69ce1e7e23cb5620ff', '380e3eeeb05b456c9d479f0b2b9806f7', 'a23df5be32feebf66b3a52320140ef8d', '2021-01-14 17:57:49', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('4b5427c920f60e5ecd7b019629d9cc0f', '380e3eeeb05b456c9d479f0b2b9806f7', '345525f783fed9394687075eab6ae0e8', '2021-01-28 10:41:59', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('4b55095d4e7b423b416a2f715610087c', '380e3eeeb05b456c9d479f0b2b9806f7', '5ec0cf0f7b10de101e2fedcd49d58cd1', '2021-01-18 14:55:50', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('4bc263ea16081b0ee39dafa9a789ccd5', '380e3eeeb05b456c9d479f0b2b9806f7', 'd24995bf82bf48e91a6fe6b7cc812f2d', '2021-01-18 14:57:02', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('4bd430b8c7eda4364a8b233b2e97f300', '380e3eeeb05b456c9d479f0b2b9806f7', 'a23df5be32feebf66b3a52320140ef8d', '2021-01-14 14:40:13', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('4bf9580fab793f7c2dcad95c68173707', '380e3eeeb05b456c9d479f0b2b9806f7', '239ac5abd4190fcb649733b1e5ef6a99', '2021-01-23 17:30:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('4c4819f13d4e6348dcef997508a843ef', '380e3eeeb05b456c9d479f0b2b9806f7', '1a16c681385607d02331dbcb41c31385', '2021-01-23 17:22:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('4d6d8d95a86b573df4ba8a00d228e324', '380e3eeeb05b456c9d479f0b2b9806f7', '8d53d7a70067655dbb344f432fc02e65', '2021-01-15 11:26:34', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('4ed5c9e2b6730d9bdd7a812adb58d9da', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3736', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('4f52de5b4881bc37176d6177eb46f863', '380e3eeeb05b456c9d479f0b2b9806f7', '7322f83175a3f7cac7c6c86db79fee39', '2021-01-28 14:18:30', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('500d8ee7b928a46ce0ad583565432253', '380e3eeeb05b456c9d479f0b2b9806f7', '9784a170e894bbbfb8a9d294a993334d', '2021-01-14 18:02:25', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('501a6c8c50a641861cfa0aef54599a6e', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3736', '2021-01-15 10:22:28', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('51076e4a73ca0a8164a1d13c1fcc56b1', '380e3eeeb05b456c9d479f0b2b9806f7', 'd24995bf82bf48e91a6fe6b7cc812f2d', '2021-01-15 10:22:28', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('51a9cde68582bbe6681e277bc95fa0d2', '380e3eeeb05b456c9d479f0b2b9806f7', '91e047affda077f3fad71d8a9de1c110', '2021-01-23 17:22:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('5345baa5329f3a4f257f4c984cc070ca', '380e3eeeb05b456c9d479f0b2b9806f7', '8444b41000ecf8a5628909e584f93996', '2021-01-28 10:41:59', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('55401e521a08a15fdbb9d9635420b819', '380e3eeeb05b456c9d479f0b2b9806f7', '8444b41000ecf8a5628909e584f93996', '2021-01-23 17:30:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('5774331ec986090e7cf32c256f683311', '380e3eeeb05b456c9d479f0b2b9806f7', 'd24995bf82bf48e91a6fe6b7cc812f2d', '2021-01-14 18:03:27', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('57b652d432dd9b7402542bb5f98598db', '380e3eeeb05b456c9d479f0b2b9806f7', '9784a170e894bbbfb8a9d294a993334d', '2021-01-23 17:33:15', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('57f694565de491e9ec7d4e52e2efeadf', '380e3eeeb05b456c9d479f0b2b9806f7', '7322f83175a3f7cac7c6c86db79fee39', '2021-01-14 13:40:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('5824bdf1dbc14ef8790a2fd36028bd2c', '380e3eeeb05b456c9d479f0b2b9806f7', '44f22b3bb8be65684c43687d47b0eb5f', '2021-01-28 14:18:30', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('582767d54b8bca623ab948a65ff78a73', '380e3eeeb05b456c9d479f0b2b9806f7', '91e047affda077f3fad71d8a9de1c110', '2021-01-18 14:55:50', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('58a27835134797c48ce487ca11fc92bb', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3736', '2021-01-14 13:40:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('58b2c9e3b25971d712895bbd489d22cd', '380e3eeeb05b456c9d479f0b2b9806f7', 'd24995bf82bf48e91a6fe6b7cc812f2d', '2021-01-14 17:57:49', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('58d174687f52b02d05c3101acff5d751', '380e3eeeb05b456c9d479f0b2b9806f7', 'd9dcc7ae8e36fc5c19b82b60b30e443f', '2021-01-24 11:21:19', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('59185d3dddab7f535a7a02da1abdbbc8', '380e3eeeb05b456c9d479f0b2b9806f7', '1a16c681385607d02331dbcb41c31385', '2021-01-28 10:46:45', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('595395dd9a735f69c59e05982cfce95c', '380e3eeeb05b456c9d479f0b2b9806f7', '8d53d7a70067655dbb344f432fc02e65', '2021-01-23 17:33:15', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('5a976bcb2565488f88859bc6173e760b', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3736', '2021-01-15 11:26:34', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('5bfcbf616d3ae851a9dd36649133c78d', '380e3eeeb05b456c9d479f0b2b9806f7', 'd24995bf82bf48e91a6fe6b7cc812f2d', '2021-01-14 18:02:25', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('5d34010ff226698e627f9971cf828219', '380e3eeeb05b456c9d479f0b2b9806f7', 'a23df5be32feebf66b3a52320140ef8d', '2021-01-23 17:33:15', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('5d7fc80d124bbd6da54707c0041ba1da', '380e3eeeb05b456c9d479f0b2b9806f7', '234571b5b2bab5e6786882fc78d985aa', '2021-01-28 10:46:45', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('5dda3596885a8d2d3a98d56a79051411', '380e3eeeb05b456c9d479f0b2b9806f7', '7322f83175a3f7cac7c6c86db79fee39', '2021-01-23 17:33:15', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('5e7ccefa3640faa76cb59020cc548485', '380e3eeeb05b456c9d479f0b2b9806f7', '234571b5b2bab5e6786882fc78d985aa', '2021-01-21 13:03:34', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('5fc191957839e04bbccd18a0fa1bf34a', '380e3eeeb05b456c9d479f0b2b9806f7', 'd0afa19fcfd59aea078c407a144057b8', '2021-01-28 14:18:30', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('611fe6b574c730265ac7d9c2238f6c25', '380e3eeeb05b456c9d479f0b2b9806f7', '8d53d7a70067655dbb344f432fc02e65', '2021-01-21 13:03:34', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('6155541c2bc1b7167003c7468784791b', '380e3eeeb05b456c9d479f0b2b9806f7', '239ac5abd4190fcb649733b1e5ef6a99', '2021-01-14 17:18:05', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('6169716e16f573a1f042022c951e3b4d', '380e3eeeb05b456c9d479f0b2b9806f7', '8d53d7a70067655dbb344f432fc02e65', '2021-01-18 15:03:02', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('61a6cb527d3c07312fcd5d83d4bd54cd', '380e3eeeb05b456c9d479f0b2b9806f7', '91e047affda077f3fad71d8a9de1c110', '2021-01-21 13:03:34', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('61e3a718a137b76efb6a84d66064364f', '380e3eeeb05b456c9d479f0b2b9806f7', '234571b5b2bab5e6786882fc78d985aa', '2021-01-24 11:21:19', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('61fa2cf3e8dde72166d482f3d7659198', '380e3eeeb05b456c9d479f0b2b9806f7', 'b5968794471875f100b2448943f88f49', '2021-01-24 11:21:19', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('623843e26506d5a8b56f31cf091b0dfd', '380e3eeeb05b456c9d479f0b2b9806f7', '239ac5abd4190fcb649733b1e5ef6a99', '2021-01-15 10:22:10', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('65365e01df7c044c8a755b2e01f09c89', '380e3eeeb05b456c9d479f0b2b9806f7', '5ec0cf0f7b10de101e2fedcd49d58cd1', '2021-01-14 17:57:49', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('66ac71ab67a71690662e1bd7c24940b4', '380e3eeeb05b456c9d479f0b2b9806f7', 'a7fd3db29f48170138a96e900ecc26e8', '2021-01-23 17:30:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('67303622f32b54e7058d03730230b0bd', '380e3eeeb05b456c9d479f0b2b9806f7', '91e047affda077f3fad71d8a9de1c110', '2021-01-18 15:03:02', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('67371ba02a308d3bbbfbd1d87ad57cc7', '380e3eeeb05b456c9d479f0b2b9806f7', '5ec0cf0f7b10de101e2fedcd49d58cd1', '2021-01-28 14:18:30', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('6788777e4e2e373d6ce211b674c92021', '380e3eeeb05b456c9d479f0b2b9806f7', 'd24995bf82bf48e91a6fe6b7cc812f2d', '2021-01-28 10:41:59', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('68d890674a7830d7b8333a9deae25081', '380e3eeeb05b456c9d479f0b2b9806f7', 'd0afa19fcfd59aea078c407a144057b8', '2021-01-23 17:22:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('69108773ae374fc8a71015afdbc60690', '380e3eeeb05b456c9d479f0b2b9806f7', '239ac5abd4190fcb649733b1e5ef6a99', '2021-01-23 17:22:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('69e8cb5dc9636c8e9a8188ac0f822977', '380e3eeeb05b456c9d479f0b2b9806f7', '8444b41000ecf8a5628909e584f93996', '2021-01-14 18:02:25', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('6aa89b96afe4775ac460403a8ee6d2b3', '380e3eeeb05b456c9d479f0b2b9806f7', '345525f783fed9394687075eab6ae0e8', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('6c2622ef7332958ca6bf36f60345740b', '380e3eeeb05b456c9d479f0b2b9806f7', '1a16c681385607d02331dbcb41c31385', '2021-01-21 13:03:34', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('6c3d5cd12f1710a1e65e821de3dff988', '380e3eeeb05b456c9d479f0b2b9806f7', '239ac5abd4190fcb649733b1e5ef6a99', '2021-01-14 13:52:33', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('6c91ed0e565f3225e38d15db9ff2e2e9', '380e3eeeb05b456c9d479f0b2b9806f7', 'd9dcc7ae8e36fc5c19b82b60b30e443f', '2021-01-18 14:57:02', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('6d940b25ab3ba0ac87069146e2e00aef', '380e3eeeb05b456c9d479f0b2b9806f7', '94570c1dfa813dd6e2386163c4662e0a', '2021-01-28 10:41:59', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('6ee1784831d72e12a83577ef9c234a38', '380e3eeeb05b456c9d479f0b2b9806f7', '91e047affda077f3fad71d8a9de1c110', '2021-01-14 18:02:25', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('6f8a02dce2c8e6f9b32b3f09f73ee6ea', '380e3eeeb05b456c9d479f0b2b9806f7', '8444b41000ecf8a5628909e584f93996', '2021-01-18 14:57:02', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('706facfe97c529e7d8433a2c9f00ab9c', '380e3eeeb05b456c9d479f0b2b9806f7', '8d53d7a70067655dbb344f432fc02e65', '2021-01-14 18:03:27', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('7322f83175a3f7cac7c6c86db79fee39', '380e3eeeb05b456c9d479f0b2b9806f7', '7322f83175a3f7cac7c6c86db79fee39', NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('740fe58e57e511e68780f4b42c451e54', '380e3eeeb05b456c9d479f0b2b9806f7', '9784a170e894bbbfb8a9d294a993334d', '2021-01-28 14:18:30', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('74929922406a7eb27738cef7f693b539', '380e3eeeb05b456c9d479f0b2b9806f7', 'a23df5be32feebf66b3a52320140ef8d', '2021-01-14 17:54:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('7511f5fc7ca0d47dc8b9ab9f93d37114', '380e3eeeb05b456c9d479f0b2b9806f7', '305220e89e4adb184845c95ea6c305f6', '2021-01-23 17:33:15', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('759cdc42e142225720345c5a100b0e63', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3702', '2021-01-28 10:41:59', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('77c06df54e0c3510f252b6740c610a5c', '380e3eeeb05b456c9d479f0b2b9806f7', 'b52ef1cf7ee65b5e63b04fd60b75d96f', '2021-01-23 17:30:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('781459b1ef4cc25d627187328a1b2956', '380e3eeeb05b456c9d479f0b2b9806f7', '239ac5abd4190fcb649733b1e5ef6a99', '2021-01-24 11:21:19', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('788d6937057af34a193aceb47facaf41', '380e3eeeb05b456c9d479f0b2b9806f7', '305220e89e4adb184845c95ea6c305f6', '2021-01-28 10:46:45', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('79242437ca22594f1c50ea1ce7281ebe', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3736', '2021-01-28 10:41:59', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('799c191bc5c215d59d2cfdf0ad13afb6', '380e3eeeb05b456c9d479f0b2b9806f7', '239ac5abd4190fcb649733b1e5ef6a99', '2021-01-18 14:57:02', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('7ac5737df6f95175ebc7f963faccb8e9', '380e3eeeb05b456c9d479f0b2b9806f7', '7ac0cec0f9b723150d3ab76e08403ec0', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('7ae8028966224057bb827ed0fb5995b5', '380e3eeeb05b456c9d479f0b2b9806f7', 'b52ef1cf7ee65b5e63b04fd60b75d96f', '2021-01-28 10:46:45', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('7b0e3340d57045c347d1e0d2934ee3db', '380e3eeeb05b456c9d479f0b2b9806f7', 'd0afa19fcfd59aea078c407a144057b8', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('7b11bb20e7e4837f9521ac34fe70083c', '380e3eeeb05b456c9d479f0b2b9806f7', 'a23df5be32feebf66b3a52320140ef8d', '2021-01-28 10:41:59', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('7b7c82148d33a8df73fc28ed31b59f10', '380e3eeeb05b456c9d479f0b2b9806f7', '239ac5abd4190fcb649733b1e5ef6a99', '2021-01-28 10:41:59', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('7bf00c0ebe1d0f610b6158a7f7682ae7', '380e3eeeb05b456c9d479f0b2b9806f7', '44f22b3bb8be65684c43687d47b0eb5f', '2021-01-28 10:41:59', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('7c5762aeb42588d8d468b28033cbca14', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3736', '2021-01-14 18:02:25', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('7dd9d4d36940af30bc52f7b3102e452a', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3736', '2021-01-21 13:03:34', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('7e1c0cbfb9d270a43d6df4c764adbd09', '380e3eeeb05b456c9d479f0b2b9806f7', '1a16c681385607d02331dbcb41c31385', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('7eab9c6e255b1c16c62b92b60a110709', '380e3eeeb05b456c9d479f0b2b9806f7', '7322f83175a3f7cac7c6c86db79fee39', '2021-01-13 16:51:26', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('7fe6d17acc2fb1a3bafb030f3528a2c7', '380e3eeeb05b456c9d479f0b2b9806f7', '91e047affda077f3fad71d8a9de1c110', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('80780679381d535beed2726cc7fb303f', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3702', '2021-01-24 11:21:19', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('80c356c27b8fb7f97dd1017e5f833ed2', '380e3eeeb05b456c9d479f0b2b9806f7', 'b5968794471875f100b2448943f88f49', '2021-01-23 17:22:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('80e3f5ac60fe669bc5a43f0307389a3e', '380e3eeeb05b456c9d479f0b2b9806f7', '8d53d7a70067655dbb344f432fc02e65', '2021-01-14 13:52:33', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('8317d5634ec3d28428593d7abe1c8850', '380e3eeeb05b456c9d479f0b2b9806f7', '91e047affda077f3fad71d8a9de1c110', '2021-01-23 17:33:15', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('8367979ac058b02c34725c01dba5d13e', '380e3eeeb05b456c9d479f0b2b9806f7', '7322f83175a3f7cac7c6c86db79fee39', '2021-01-15 11:26:34', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('84a09042bd0dad98065727c11972c475', '380e3eeeb05b456c9d479f0b2b9806f7', '8d53d7a70067655dbb344f432fc02e65', '2021-01-15 10:22:10', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('8501817094af26d3da0cb816895fccf9', '380e3eeeb05b456c9d479f0b2b9806f7', '345525f783fed9394687075eab6ae0e8', '2021-01-23 17:22:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('851b24e410e7020eea38b9c550b95b54', '380e3eeeb05b456c9d479f0b2b9806f7', '8d53d7a70067655dbb344f432fc02e65', '2021-01-14 13:40:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('86453df01877170e526bcbb5f1b1bb7e', '380e3eeeb05b456c9d479f0b2b9806f7', '9784a170e894bbbfb8a9d294a993334d', '2021-01-18 15:03:02', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('86762de8afaa8fda21d9932108210a90', '380e3eeeb05b456c9d479f0b2b9806f7', '8d53d7a70067655dbb344f432fc02e65', '2021-01-14 14:40:13', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('86aca82439ad1cef07eae76b3fba723f', '380e3eeeb05b456c9d479f0b2b9806f7', 'a23df5be32feebf66b3a52320140ef8d', '2021-01-13 16:51:26', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('86aef7ab779abef5fee8129de4910ef3', '380e3eeeb05b456c9d479f0b2b9806f7', '8d53d7a70067655dbb344f432fc02e65', '2021-01-28 10:41:59', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('86d96122f9e217805be08c79e29f2a9b', '380e3eeeb05b456c9d479f0b2b9806f7', '5ec0cf0f7b10de101e2fedcd49d58cd1', '2021-01-14 18:02:25', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('876284a3de7d43abbeb2a6515cc95711', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3702', '2021-01-14 13:40:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('885b976d044dd88de285601be50b22fb', '380e3eeeb05b456c9d479f0b2b9806f7', '234571b5b2bab5e6786882fc78d985aa', '2021-01-28 10:41:59', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('8885367dc6402c97abe717424fd48d29', '380e3eeeb05b456c9d479f0b2b9806f7', '9784a170e894bbbfb8a9d294a993334d', '2021-01-14 17:57:11', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('8890449aa8022c8fb09b8e775a2eb2af', '380e3eeeb05b456c9d479f0b2b9806f7', '3821884b57db14bb40609151c2d225ae', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('89cdf15d86e20984fed491fb4c81b541', '380e3eeeb05b456c9d479f0b2b9806f7', 'a23df5be32feebf66b3a52320140ef8d', '2021-01-18 14:55:50', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('89e9831e8ae6c361c0a2f4ca794cddab', '380e3eeeb05b456c9d479f0b2b9806f7', 'd0afa19fcfd59aea078c407a144057b8', '2021-01-24 11:21:19', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('8a85355d13b00648798d62e2de12b0b8', '380e3eeeb05b456c9d479f0b2b9806f7', 'd24995bf82bf48e91a6fe6b7cc812f2d', '2021-01-23 17:30:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('8bf10cde4a357f20df8dee90114b5305', '380e3eeeb05b456c9d479f0b2b9806f7', 'd24995bf82bf48e91a6fe6b7cc812f2d', '2021-01-18 14:55:50', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('8d96361facc3e81c6682df6981e7675f', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3736', '2021-01-18 14:55:50', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('8da3c7f71e685574a350ff6a9647e59e', '380e3eeeb05b456c9d479f0b2b9806f7', '345525f783fed9394687075eab6ae0e8', '2021-01-21 13:03:34', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('8db840dfcf9d40b43987b99b99317e4c', '380e3eeeb05b456c9d479f0b2b9806f7', '91e047affda077f3fad71d8a9de1c110', '2021-01-15 10:22:10', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('8dda85bedf10e4906bb3712a06cac1c5', '380e3eeeb05b456c9d479f0b2b9806f7', 'f03c96a900ccae531765edc7688f0dfc', '2021-01-14 17:57:49', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('8e028d23ec613a0f5379c0dfeff6292d', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3736', '2021-01-14 17:18:05', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('8e305a563a148a0c71b19d8233cba3cc', '380e3eeeb05b456c9d479f0b2b9806f7', 'd24995bf82bf48e91a6fe6b7cc812f2d', '2021-01-14 14:40:13', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('8e3af036f7db665e7dcc9e75934c19e4', '380e3eeeb05b456c9d479f0b2b9806f7', '8444b41000ecf8a5628909e584f93996', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('8f41e912cc4505f0d0838e0d622f58a7', '380e3eeeb05b456c9d479f0b2b9806f7', '1a16c681385607d02331dbcb41c31385', '2021-01-28 10:41:59', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('90a47926c8339c392b298976e4132c22', '380e3eeeb05b456c9d479f0b2b9806f7', '7322f83175a3f7cac7c6c86db79fee39', '2021-01-24 11:21:19', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('90f8e1f590a52510d07b6c0beabebbd7', '380e3eeeb05b456c9d479f0b2b9806f7', '5ec0cf0f7b10de101e2fedcd49d58cd1', '2021-01-15 10:22:10', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('910d3848a87f905f53064e03037fca69', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3702', '2021-01-21 13:03:34', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('91e047affda077f3fad71d8a9de1c110', '380e3eeeb05b456c9d479f0b2b9806f7', '91e047affda077f3fad71d8a9de1c110', NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('925ccf2242b425cdb92b09e4f30a3725', '380e3eeeb05b456c9d479f0b2b9806f7', 'dfe12b03a1ca02a393b6818a39dc117e', '2021-01-28 10:46:45', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('94953ba7188ab5582c1926a5ca925283', '380e3eeeb05b456c9d479f0b2b9806f7', 'a23df5be32feebf66b3a52320140ef8d', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('950fb5c5a4f490e7132ef44af79c77f6', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3736', '2021-01-18 15:03:02', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('9517adc1c1c22b2f776650acb4601037', '380e3eeeb05b456c9d479f0b2b9806f7', '8444b41000ecf8a5628909e584f93996', '2021-01-28 14:18:30', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('957d24d7144be511bd4bd0c90fedbf0c', '380e3eeeb05b456c9d479f0b2b9806f7', '849d881d928f8929758f138a9eacab1a', '2021-01-23 17:22:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('9586f10b55bd937df6b59bbaa8693ac2', '380e3eeeb05b456c9d479f0b2b9806f7', '8d53d7a70067655dbb344f432fc02e65', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('958f725ad979a5e7c3eac29c2b75f7ea', '380e3eeeb05b456c9d479f0b2b9806f7', '5ec0cf0f7b10de101e2fedcd49d58cd1', '2021-01-13 18:29:47', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('961b3d272b4da1f2627d55ea5618a35f', '380e3eeeb05b456c9d479f0b2b9806f7', '8d53d7a70067655dbb344f432fc02e65', '2021-01-28 10:46:45', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('985a20daebc262b66fb80380ddeda4e2', '380e3eeeb05b456c9d479f0b2b9806f7', '94570c1dfa813dd6e2386163c4662e0a', '2021-01-28 10:46:45', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('98b23733b3345ba896593a1e0018aa8f', '380e3eeeb05b456c9d479f0b2b9806f7', '7322f83175a3f7cac7c6c86db79fee39', '2021-01-23 17:22:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('98dd188d3c216e68e12299522a930095', '380e3eeeb05b456c9d479f0b2b9806f7', '8d53d7a70067655dbb344f432fc02e65', '2021-01-14 18:02:25', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('996721e76a1b8097cba066e942083305', '380e3eeeb05b456c9d479f0b2b9806f7', '9784a170e894bbbfb8a9d294a993334d', '2021-01-14 17:54:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('9967dd75b06bf0e21a91614be90a1f6a', '380e3eeeb05b456c9d479f0b2b9806f7', 'd9dcc7ae8e36fc5c19b82b60b30e443f', '2021-01-18 14:55:50', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('9a5059d04b8f2a6e4969db14315cd8ef', '380e3eeeb05b456c9d479f0b2b9806f7', '91e047affda077f3fad71d8a9de1c110', '2021-01-15 11:26:34', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('9a6969038b02d03fdbcb760d0a08e183', '380e3eeeb05b456c9d479f0b2b9806f7', 'a23df5be32feebf66b3a52320140ef8d', '2021-01-21 13:03:34', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('9b1ebde942ee0e99ed9810c5fb48c13b', '380e3eeeb05b456c9d479f0b2b9806f7', '91e047affda077f3fad71d8a9de1c110', '2021-01-14 17:18:05', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('9b6e50817c30c0f33b181809cc99a73f', '380e3eeeb05b456c9d479f0b2b9806f7', '849d881d928f8929758f138a9eacab1a', '2021-01-28 10:46:45', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('9c1eef2fed3c0fdb01626b80c8709324', '380e3eeeb05b456c9d479f0b2b9806f7', '1a16c681385607d02331dbcb41c31385', '2021-01-28 14:18:30', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('9c47a8a54c4f11b14872bc6c250bd4af', '380e3eeeb05b456c9d479f0b2b9806f7', '8d53d7a70067655dbb344f432fc02e65', '2021-01-18 14:55:50', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('9ca9c2337b42a9307b457acdb2f6670f', '380e3eeeb05b456c9d479f0b2b9806f7', '5ec0cf0f7b10de101e2fedcd49d58cd1', '2021-01-15 10:22:28', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('9d8207d2daff1f3f304b0d5b34b308e9', '380e3eeeb05b456c9d479f0b2b9806f7', '9784a170e894bbbfb8a9d294a993334d', '2021-01-18 14:57:02', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('9d9b33310ae80cc3ad6d508680ac7e44', '380e3eeeb05b456c9d479f0b2b9806f7', 'b5968794471875f100b2448943f88f49', '2021-01-28 14:18:30', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('9ded7d0de6c823aef33cb407e4310005', '380e3eeeb05b456c9d479f0b2b9806f7', '91e047affda077f3fad71d8a9de1c110', '2021-01-13 18:29:47', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('9e300d97b9dcb7f3c8b6b3954c735aa4', '380e3eeeb05b456c9d479f0b2b9806f7', '1a16c681385607d02331dbcb41c31385', '2021-01-23 17:30:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('9e421a23a916a2b9b47c27a025e9d558', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3736', '2021-01-14 09:11:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('9ed1b27a5edb9a6caff87295bc4bbae4', '380e3eeeb05b456c9d479f0b2b9806f7', '239ac5abd4190fcb649733b1e5ef6a99', '2021-01-14 18:03:27', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('9f881e80365db1308d82315a620c5274', '380e3eeeb05b456c9d479f0b2b9806f7', '345525f783fed9394687075eab6ae0e8', '2021-01-18 15:03:02', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('9fd87df3543fae7377b1902702186f34', '380e3eeeb05b456c9d479f0b2b9806f7', 'd9dcc7ae8e36fc5c19b82b60b30e443f', '2021-01-23 17:22:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('a0cec743f80b08a88d656ef1ec4723f1', '380e3eeeb05b456c9d479f0b2b9806f7', '5ec0cf0f7b10de101e2fedcd49d58cd1', '2021-01-14 09:11:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('a1c5a2f609edf99e9881899247c9f5f1', '380e3eeeb05b456c9d479f0b2b9806f7', '7322f83175a3f7cac7c6c86db79fee39', '2021-01-15 10:22:10', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('a1ffa429902ac229c83a07569478e6d6', '380e3eeeb05b456c9d479f0b2b9806f7', 'f03c96a900ccae531765edc7688f0dfc', '2021-01-15 10:22:28', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('a2110d90af9a1f3a1fac95cd73e3b68a', '380e3eeeb05b456c9d479f0b2b9806f7', '5ec0cf0f7b10de101e2fedcd49d58cd1', '2021-01-18 15:03:02', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('a23df5be32feebf66b3a52320140ef8d', '380e3eeeb05b456c9d479f0b2b9806f7', 'a23df5be32feebf66b3a52320140ef8d', NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('a373be22d5ce11fe8d18c32170e4edae', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3702', '2021-01-14 17:18:05', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('a40f37045739a538b7bf07029ba430ef', '380e3eeeb05b456c9d479f0b2b9806f7', 'd24995bf82bf48e91a6fe6b7cc812f2d', '2021-01-18 15:03:02', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('a4315a6a76629b068d13ea5041332a3b', '380e3eeeb05b456c9d479f0b2b9806f7', '8d53d7a70067655dbb344f432fc02e65', '2021-01-14 17:57:49', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('a45ce2206c72e6c1f7f5e0da8786e5a1', '380e3eeeb05b456c9d479f0b2b9806f7', 'a23df5be32feebf66b3a52320140ef8d', '2021-01-13 18:29:47', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('a4a8c704ac7296b268a3a18555ddce34', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3702', '2021-01-14 18:02:25', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('a5ab14141838753472993b0ea7f3e62a', '380e3eeeb05b456c9d479f0b2b9806f7', 'b5968794471875f100b2448943f88f49', '2021-01-28 10:46:45', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('a5bfa464c4ac86723bc683aabe9e7a28', '380e3eeeb05b456c9d479f0b2b9806f7', 'a23df5be32feebf66b3a52320140ef8d', '2021-01-15 11:26:34', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('a628f1e6da1cb3bad3caed4524e15bac', '380e3eeeb05b456c9d479f0b2b9806f7', '239ac5abd4190fcb649733b1e5ef6a99', '2021-01-15 10:22:28', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('a81549ec96dada9a6426fc82ad675a7f', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3702', '2021-01-14 14:40:13', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('a899bbd00bcbb896eecc92eb06d6f902', '380e3eeeb05b456c9d479f0b2b9806f7', '6ad658de7c72f4c893875521bfacb074', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('a9795761261fa690b198ac863d576022', '380e3eeeb05b456c9d479f0b2b9806f7', 'a23df5be32feebf66b3a52320140ef8d', '2021-01-23 17:22:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('a9873616124dabfa393cf5eb5ac5b9ff', '380e3eeeb05b456c9d479f0b2b9806f7', '305220e89e4adb184845c95ea6c305f6', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('a9fdc565cc13aacd31cbaa8b3d61e0a1', '380e3eeeb05b456c9d479f0b2b9806f7', 'd9dcc7ae8e36fc5c19b82b60b30e443f', '2021-01-28 10:41:59', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('aa060365c14fda618baa7c2b389c0a9c', '380e3eeeb05b456c9d479f0b2b9806f7', '5ec0cf0f7b10de101e2fedcd49d58cd1', '2021-01-24 11:21:19', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('aa7efe4845e6950879623a22ef1f5c37', '380e3eeeb05b456c9d479f0b2b9806f7', '8444b41000ecf8a5628909e584f93996', '2021-01-24 11:21:19', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('aa8df8d117ea858f010abf244cdc79ac', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3736', '2021-01-14 18:03:27', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('ac797634fa4086c12efda36fcbca91e2', '380e3eeeb05b456c9d479f0b2b9806f7', '7322f83175a3f7cac7c6c86db79fee39', '2021-01-18 14:55:50', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('ad20412fe27e30770bc9df9532d73ae4', '380e3eeeb05b456c9d479f0b2b9806f7', 'b52ef1cf7ee65b5e63b04fd60b75d96f', '2021-01-28 14:18:30', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('ae44fc5a7e9484fd5dca87db185c14a7', '380e3eeeb05b456c9d479f0b2b9806f7', '91e047affda077f3fad71d8a9de1c110', '2021-01-14 17:57:11', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('ae64ab8874d84038668a03598770b26b', '380e3eeeb05b456c9d479f0b2b9806f7', '234571b5b2bab5e6786882fc78d985aa', '2021-01-18 15:03:02', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('ae6721c91529fbfe15611841b6b5152f', '380e3eeeb05b456c9d479f0b2b9806f7', '5ec0cf0f7b10de101e2fedcd49d58cd1', '2021-01-14 13:40:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('ae78db9a83f3422d8443bd7839209bd6', '380e3eeeb05b456c9d479f0b2b9806f7', 'd0afa19fcfd59aea078c407a144057b8', '2021-01-21 13:03:34', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('aec5463db3910b715dc20b79384efd66', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3702', '2021-01-23 17:22:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('aed635a21c0335534f5db77b0d9561c5', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3736', '2021-01-14 14:40:13', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('af4ccab6868c46120eabbd03a1698e8f', '380e3eeeb05b456c9d479f0b2b9806f7', '239ac5abd4190fcb649733b1e5ef6a99', '2021-01-14 17:57:49', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('afc99290924a42828f88056ba5c5362d', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3736', '2021-01-23 17:33:15', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('b002eb19685db1354643e772e1b8f34a', '380e3eeeb05b456c9d479f0b2b9806f7', 'a23df5be32feebf66b3a52320140ef8d', '2021-01-15 10:22:10', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('b0560a5da283ec833af8391563bd1105', '380e3eeeb05b456c9d479f0b2b9806f7', '5ec0cf0f7b10de101e2fedcd49d58cd1', '2021-01-14 13:52:33', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('b08944a08c12a421c6c5b700806fd0c6', '380e3eeeb05b456c9d479f0b2b9806f7', '7322f83175a3f7cac7c6c86db79fee39', '2021-01-14 14:40:13', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('b0b87b646542c0922b12d3eae439c384', '380e3eeeb05b456c9d479f0b2b9806f7', '9784a170e894bbbfb8a9d294a993334d', '2021-01-14 18:03:27', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('b1308120d1241a12715d0c54e32a13fa', '380e3eeeb05b456c9d479f0b2b9806f7', 'd24995bf82bf48e91a6fe6b7cc812f2d', '2021-01-24 11:21:19', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('b2ae2c4e1a4bb661447617c055958c86', '380e3eeeb05b456c9d479f0b2b9806f7', 'a7fd3db29f48170138a96e900ecc26e8', '2021-01-23 17:33:15', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('b3814b3a649262c1510f8997020a7d05', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3736', '2021-01-14 17:57:11', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('b4509a975d07915c31835379a2286aeb', '380e3eeeb05b456c9d479f0b2b9806f7', '234571b5b2bab5e6786882fc78d985aa', '2021-01-23 17:30:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('b6d295c97a4d1b9f82c74c2c49d1b0df', '380e3eeeb05b456c9d479f0b2b9806f7', 'd9dcc7ae8e36fc5c19b82b60b30e443f', '2021-01-28 10:46:45', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('b6f93e18d920925299e9cf1c475f69c9', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3736', '2021-01-23 17:22:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('b98c2d1805150329400463127a6e33e8', '380e3eeeb05b456c9d479f0b2b9806f7', '6ad658de7c72f4c893875521bfacb074', '2021-01-28 14:18:30', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('b9a7c68749986b596326e871b0ea8190', '380e3eeeb05b456c9d479f0b2b9806f7', '44f22b3bb8be65684c43687d47b0eb5f', '2021-01-23 17:30:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('b9b45bbcdfcaa9688be61beec2af609e', '380e3eeeb05b456c9d479f0b2b9806f7', '5ec0cf0f7b10de101e2fedcd49d58cd1', '2021-01-15 11:26:34', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('ba73ed8a770be9da1406e580d2e8d0eb', '380e3eeeb05b456c9d479f0b2b9806f7', 'a7fd3db29f48170138a96e900ecc26e8', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('bada0e0cbc4960617c860ab74449f913', '380e3eeeb05b456c9d479f0b2b9806f7', '8444b41000ecf8a5628909e584f93996', '2021-01-14 17:57:49', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('bb524eacef00add34a8b85dea040399d', '380e3eeeb05b456c9d479f0b2b9806f7', '243fe8f2cdd437ba107339b1dd5accde', '2021-01-28 10:41:59', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('bb70b0442b984ccda0523f10e1035a9e', '380e3eeeb05b456c9d479f0b2b9806f7', '5ec0cf0f7b10de101e2fedcd49d58cd1', '2021-01-21 13:03:34', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('bc2b40780a392df73ed5649f89bbc91c', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3702', '2021-01-23 17:33:15', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('bce36a8a5cf2348551082bc1de3bdb80', '380e3eeeb05b456c9d479f0b2b9806f7', 'd0afa19fcfd59aea078c407a144057b8', '2021-01-23 17:33:15', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('bd619431bab8a55648cfbd449f50efe5', '380e3eeeb05b456c9d479f0b2b9806f7', '91e047affda077f3fad71d8a9de1c110', '2021-01-14 14:40:13', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('bd62853e1b09e418cdcc965965a30f04', '380e3eeeb05b456c9d479f0b2b9806f7', '345525f783fed9394687075eab6ae0e8', '2021-01-24 11:21:19', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('bf0dc35b75e286fa9093d5b9564aa032', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3736', '2021-01-14 17:57:49', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('bf3d05400c51e3ccf7efb4c2882e3cb8', '380e3eeeb05b456c9d479f0b2b9806f7', '239ac5abd4190fcb649733b1e5ef6a99', '2021-01-13 18:29:47', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('c017bb5a2c699cb33d79beb1e0cdb3c2', '380e3eeeb05b456c9d479f0b2b9806f7', '5ec0cf0f7b10de101e2fedcd49d58cd1', '2021-01-28 10:46:45', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('c10b52b2a96532e14eca8acf14bb47df', '380e3eeeb05b456c9d479f0b2b9806f7', '239ac5abd4190fcb649733b1e5ef6a99', '2021-01-18 14:55:50', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('c17e6b25820bf6b2374d70db0388ae5d', '380e3eeeb05b456c9d479f0b2b9806f7', '239ac5abd4190fcb649733b1e5ef6a99', '2021-01-21 13:03:34', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('c1a1e63b1ebc316def34cbba12c6efa1', '380e3eeeb05b456c9d479f0b2b9806f7', 'b52ef1cf7ee65b5e63b04fd60b75d96f', '2021-01-28 10:41:59', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('c386be0e5d62778ca6932f9df616b4d0', '380e3eeeb05b456c9d479f0b2b9806f7', '44f22b3bb8be65684c43687d47b0eb5f', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('c3a158dbdffd258d5a24bee191a43db0', '380e3eeeb05b456c9d479f0b2b9806f7', '234571b5b2bab5e6786882fc78d985aa', '2021-01-18 14:57:02', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('c4bff4212306c46c3b3dde33fa81bb03', '380e3eeeb05b456c9d479f0b2b9806f7', 'a7fd3db29f48170138a96e900ecc26e8', '2021-01-28 14:18:30', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('c569b9af97d255d3980735d93b3ba174', '380e3eeeb05b456c9d479f0b2b9806f7', '7322f83175a3f7cac7c6c86db79fee39', '2021-01-14 18:02:25', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('c66798290f61fa3f55a293d5943bd172', '380e3eeeb05b456c9d479f0b2b9806f7', '91e047affda077f3fad71d8a9de1c110', '2021-01-14 17:57:49', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('c69a5ae32881e117a76e6f98a8ad2591', '380e3eeeb05b456c9d479f0b2b9806f7', '7322f83175a3f7cac7c6c86db79fee39', '2021-01-18 15:03:02', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('c7c140ea3c45c23551c59cc114488f47', '380e3eeeb05b456c9d479f0b2b9806f7', '91e047affda077f3fad71d8a9de1c110', '2021-01-28 10:46:45', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('c891c5afd07a15bcc00c863abc8993ba', '380e3eeeb05b456c9d479f0b2b9806f7', '94570c1dfa813dd6e2386163c4662e0a', '2021-01-28 14:18:30', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('c898ffbfc665a29ba9c721148d2f99f7', '380e3eeeb05b456c9d479f0b2b9806f7', '239ac5abd4190fcb649733b1e5ef6a99', '2021-01-14 13:40:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('c8b52d189b865019d00df8211c26d75e', '380e3eeeb05b456c9d479f0b2b9806f7', '239ac5abd4190fcb649733b1e5ef6a99', '2021-01-18 15:03:02', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('cdc867a409958ca297224edd862629a3', '380e3eeeb05b456c9d479f0b2b9806f7', '5ec0cf0f7b10de101e2fedcd49d58cd1', '2021-01-28 10:41:59', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('cdd699410fdc00504b6f94bb2c17f4b6', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3736', '2021-01-18 14:57:02', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('ce55abf1a074a2d54996922b46e39f09', '380e3eeeb05b456c9d479f0b2b9806f7', 'd24995bf82bf48e91a6fe6b7cc812f2d', '2021-01-23 17:33:15', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('cf3f1a876f2d5ca685d60fba7da73439', '380e3eeeb05b456c9d479f0b2b9806f7', 'd24995bf82bf48e91a6fe6b7cc812f2d', '2021-01-14 17:54:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('cf75e38579bf87f2af9518fa1dda5649', '380e3eeeb05b456c9d479f0b2b9806f7', '305220e89e4adb184845c95ea6c305f6', '2021-01-28 14:18:30', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('d0da58d8cda7e11de4f23deaf7724678', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3736', '2021-01-28 10:46:45', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('d213e72f383cd2caa148651ad8a94ab7', '380e3eeeb05b456c9d479f0b2b9806f7', '91e047affda077f3fad71d8a9de1c110', '2021-01-14 13:52:33', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('d2e9a557bb61234bbf8611db8ba47738', '380e3eeeb05b456c9d479f0b2b9806f7', '9784a170e894bbbfb8a9d294a993334d', '2021-01-15 10:22:10', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('d40a6cfdce4154532bbabc13cf63aa9c', '380e3eeeb05b456c9d479f0b2b9806f7', 'b52ef1cf7ee65b5e63b04fd60b75d96f', '2021-01-24 11:21:19', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('d4584087414b7ef4883deca545b0d6b3', '380e3eeeb05b456c9d479f0b2b9806f7', 'b03042ed303953c634abc4a627c19bb8', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('d547eef47b83009fdf5f0515184aab74', '380e3eeeb05b456c9d479f0b2b9806f7', '8d53d7a70067655dbb344f432fc02e65', '2021-01-14 17:57:11', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('d6113583faf93096354f12f1fe89c2ea', '380e3eeeb05b456c9d479f0b2b9806f7', '239ac5abd4190fcb649733b1e5ef6a99', '2021-01-14 18:02:25', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('d63bcdadda3357cc6b9b16c8d38d647a', '380e3eeeb05b456c9d479f0b2b9806f7', 'e8d4f1a23b5e12c7a2be82c1b4968dd8', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('d760dd8411a11430581529e420a384c7', '380e3eeeb05b456c9d479f0b2b9806f7', 'a23df5be32feebf66b3a52320140ef8d', '2021-01-28 14:18:30', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('d7f6194f4d4093154717a20a40e9447f', '380e3eeeb05b456c9d479f0b2b9806f7', '8444b41000ecf8a5628909e584f93996', '2021-01-18 14:55:50', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('d84c50761aeada4f908e9e932f03345e', '380e3eeeb05b456c9d479f0b2b9806f7', 'a7fd3db29f48170138a96e900ecc26e8', '2021-01-28 10:46:45', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('d8c3212bccfa00f995c218ec3b1d9d93', '380e3eeeb05b456c9d479f0b2b9806f7', '9784a170e894bbbfb8a9d294a993334d', '2021-01-28 10:41:59', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('d8e131b9926173dd66147c09bfd2ac1f', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3702', '2021-01-28 14:18:30', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('d91262759711906543ce820cdc559a20', '380e3eeeb05b456c9d479f0b2b9806f7', '8d53d7a70067655dbb344f432fc02e65', '2021-01-15 10:22:28', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('d9a6c564ddf1e213b20bc1aef40e1e7b', '380e3eeeb05b456c9d479f0b2b9806f7', '7322f83175a3f7cac7c6c86db79fee39', '2021-01-13 18:29:47', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('db06b40781bab83411df07839d5b8db1', '380e3eeeb05b456c9d479f0b2b9806f7', '5ec0cf0f7b10de101e2fedcd49d58cd1', '2021-01-23 17:22:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('db3838216d4cc79fa62fb1c9ed68ae40', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3702', '2021-01-28 10:46:45', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('dbfe9c6c4670ef75e684455edee3712c', '380e3eeeb05b456c9d479f0b2b9806f7', '234571b5b2bab5e6786882fc78d985aa', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('dccb466889bba173aee1d594a036a163', '380e3eeeb05b456c9d479f0b2b9806f7', 'a23df5be32feebf66b3a52320140ef8d', '2021-01-18 14:57:02', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('dd0bf78ea855e214762c744aa50cb8b2', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3736', '2021-01-14 17:54:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('dd8f119fb16dc83760d67ac0dfb160a7', '380e3eeeb05b456c9d479f0b2b9806f7', '8d53d7a70067655dbb344f432fc02e65', '2021-01-14 17:18:05', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('ddf5ad54cd0af12ea2647fa516d93cff', '380e3eeeb05b456c9d479f0b2b9806f7', 'd24995bf82bf48e91a6fe6b7cc812f2d', '2021-01-21 13:03:34', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('de43641c8c3ccb092104946562fb7a65', '380e3eeeb05b456c9d479f0b2b9806f7', '239ac5abd4190fcb649733b1e5ef6a99', '2021-01-23 17:33:15', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('de567b6903dd7fe2edf011087127a720', '380e3eeeb05b456c9d479f0b2b9806f7', '9784a170e894bbbfb8a9d294a993334d', '2021-01-15 11:26:34', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('df51f0f58f6b3e157d056b6cb660f55a', '380e3eeeb05b456c9d479f0b2b9806f7', '8444b41000ecf8a5628909e584f93996', '2021-01-15 10:22:10', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('df734cf71c04c104c6274ca64dc56a39', '380e3eeeb05b456c9d479f0b2b9806f7', '239ac5abd4190fcb649733b1e5ef6a99', '2021-01-14 09:11:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('e0120994db6cfd67aed6830d18bfeb90', '380e3eeeb05b456c9d479f0b2b9806f7', '849d881d928f8929758f138a9eacab1a', '2021-01-28 14:18:30', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('e0ee91de083234811dd54baa22b4fa10', '380e3eeeb05b456c9d479f0b2b9806f7', 'd9dcc7ae8e36fc5c19b82b60b30e443f', '2021-01-28 14:18:30', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('e12a8f9a863944d9fa7b34e4df4df82a', '380e3eeeb05b456c9d479f0b2b9806f7', 'b5968794471875f100b2448943f88f49', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('e131644926fa5abce381bd828dbe08d5', '380e3eeeb05b456c9d479f0b2b9806f7', 'a7fd3db29f48170138a96e900ecc26e8', '2021-01-23 17:22:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('e2b562e0d03d9dff21e84cf1d11b4733', '380e3eeeb05b456c9d479f0b2b9806f7', '8444b41000ecf8a5628909e584f93996', '2021-01-14 17:57:11', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('e2d760dfee7da73aadc08c343e47c5cb', '380e3eeeb05b456c9d479f0b2b9806f7', 'd24995bf82bf48e91a6fe6b7cc812f2d', '2021-01-28 10:46:45', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('e2e3f4cbdd8adb7b99196ed73578670d', '380e3eeeb05b456c9d479f0b2b9806f7', '8444b41000ecf8a5628909e584f93996', '2021-01-23 17:22:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('e32efd41850e2ce0ac3ab1732e9511ed', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3736', '2021-01-15 10:22:10', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('e38b315d68a102b4c2262d4c0be3f54e', '380e3eeeb05b456c9d479f0b2b9806f7', '5ec0cf0f7b10de101e2fedcd49d58cd1', '2021-01-14 17:18:05', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('e3f18305f29faf164f7f243cfd37e32c', '380e3eeeb05b456c9d479f0b2b9806f7', '9784a170e894bbbfb8a9d294a993334d', '2021-01-14 17:18:05', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('e3f1ecc809bdb2bd50acfac9b6e03a88', '380e3eeeb05b456c9d479f0b2b9806f7', '5ec0cf0f7b10de101e2fedcd49d58cd1', '2021-01-18 14:57:02', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('e4676823ac87811a62bbbb0ed35ac514', '380e3eeeb05b456c9d479f0b2b9806f7', 'a23df5be32feebf66b3a52320140ef8d', '2021-01-14 17:57:11', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('e4aff3ee25c59880c20dfd2b994ac463', '380e3eeeb05b456c9d479f0b2b9806f7', '345525f783fed9394687075eab6ae0e8', '2021-01-23 17:33:15', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('e53d43c032c063f6fcd9136a642a5aee', '380e3eeeb05b456c9d479f0b2b9806f7', '849d881d928f8929758f138a9eacab1a', '2021-01-23 17:33:15', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('e572ca554f3fc391cd03721894f28207', '380e3eeeb05b456c9d479f0b2b9806f7', '94570c1dfa813dd6e2386163c4662e0a', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('e63a3b6d0658b17b3fb453186a97a954', '380e3eeeb05b456c9d479f0b2b9806f7', '239ac5abd4190fcb649733b1e5ef6a99', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('e6d57112c557f75cbf3e849e39c12710', '380e3eeeb05b456c9d479f0b2b9806f7', 'f03c96a900ccae531765edc7688f0dfc', '2021-01-14 18:03:27', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('e70efd2f4925b5db401744ad7c4c8323', '380e3eeeb05b456c9d479f0b2b9806f7', '9784a170e894bbbfb8a9d294a993334d', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('e72e12b5ab13b5c9c964f6e62063251e', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3702', '2021-01-14 17:57:49', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('e7414f844870e8c3be9cfe7f25cd433d', '380e3eeeb05b456c9d479f0b2b9806f7', 'dfe12b03a1ca02a393b6818a39dc117e', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('e779e9e068a27208a663b23af09d5cc9', '380e3eeeb05b456c9d479f0b2b9806f7', '9784a170e894bbbfb8a9d294a993334d', '2021-01-14 17:57:49', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('e7ea84cbeabeaff0be2827fc0da699b3', '380e3eeeb05b456c9d479f0b2b9806f7', '7322f83175a3f7cac7c6c86db79fee39', '2021-01-14 13:52:33', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('e7f773932195281b0c0db117a00856c7', '380e3eeeb05b456c9d479f0b2b9806f7', '91e047affda077f3fad71d8a9de1c110', '2021-01-14 18:03:27', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('e879c3bbcfd4d35b8e3f90bb22727b00', '380e3eeeb05b456c9d479f0b2b9806f7', '6a0c792088e4576b65e15cb22899095b', '2021-01-14 09:11:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('e91084654717ce09ef00dd08f982b9e4', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3702', '2021-01-23 17:30:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('e9b8bc86e20a440401423224dd9e294a', '380e3eeeb05b456c9d479f0b2b9806f7', 'd9dcc7ae8e36fc5c19b82b60b30e443f', '2021-01-23 17:30:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('e9be31066d6c5802e1d82bc65bfe3662', '380e3eeeb05b456c9d479f0b2b9806f7', '91e047affda077f3fad71d8a9de1c110', '2021-01-13 16:51:26', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('ea7b3d5bc4f7072e926457a10fef1bd9', '380e3eeeb05b456c9d479f0b2b9806f7', '7322f83175a3f7cac7c6c86db79fee39', '2021-01-18 14:57:02', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('eb62927cfa9f4d12045dd9210e83a12c', '380e3eeeb05b456c9d479f0b2b9806f7', '9784a170e894bbbfb8a9d294a993334d', '2021-01-24 11:21:19', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('ec462d4d815b7999cb1c19b30ba063fd', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3736', '2021-01-14 13:52:33', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('ec867b540534161e1ce1c66e3a6e3527', '380e3eeeb05b456c9d479f0b2b9806f7', 'd9dcc7ae8e36fc5c19b82b60b30e443f', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('ed7a63257020fd774ae25ac54fd0feee', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3736', '2021-01-23 17:30:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('ee85831f5cb1948bd568689d5cbc409e', '380e3eeeb05b456c9d479f0b2b9806f7', 'd0afa19fcfd59aea078c407a144057b8', '2021-01-28 10:46:45', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('f0271a22663f040e70719779ab92c417', '380e3eeeb05b456c9d479f0b2b9806f7', 'b5968794471875f100b2448943f88f49', '2021-01-28 10:41:59', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('f0ea2537007e1b19708926222daf06ae', '380e3eeeb05b456c9d479f0b2b9806f7', 'a23df5be32feebf66b3a52320140ef8d', '2021-01-14 18:03:27', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('f1b3e7eb32d3a048ef596187e86cfc00', '380e3eeeb05b456c9d479f0b2b9806f7', 'd24995bf82bf48e91a6fe6b7cc812f2d', '2021-01-15 11:26:34', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('f248bddc596ccbf038989f6113f2f356', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3702', '2021-01-18 14:55:50', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('f289b2b8023fbdf96d27b5b5d0864ae2', '380e3eeeb05b456c9d479f0b2b9806f7', '5ec0cf0f7b10de101e2fedcd49d58cd1', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('f3f4138ddfdadf03dbbe2caf12ef5351', '380e3eeeb05b456c9d479f0b2b9806f7', 'a23df5be32feebf66b3a52320140ef8d', '2021-01-14 13:40:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('f46a1cce839ee5ee4c1da26ffb7161f9', '380e3eeeb05b456c9d479f0b2b9806f7', '44f22b3bb8be65684c43687d47b0eb5f', '2021-01-24 11:21:19', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('f6000e772ebf79bd35baef881602ba17', '380e3eeeb05b456c9d479f0b2b9806f7', 'b52ef1cf7ee65b5e63b04fd60b75d96f', '2021-01-23 17:22:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('f754542de96ba046172e9fec15cd37f3', '380e3eeeb05b456c9d479f0b2b9806f7', 'd24995bf82bf48e91a6fe6b7cc812f2d', '2021-01-28 14:18:30', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('f770b8e71761468bc9874566cbede04d', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3702', '2021-01-18 14:57:02', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('f7d159f32495ccd8cbb2bb637f649fb0', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3702', '2021-01-15 10:22:10', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('f8e3d3f5210e004f9324563e30613442', '380e3eeeb05b456c9d479f0b2b9806f7', '7322f83175a3f7cac7c6c86db79fee39', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('f970c206bf5d5f58d4fef3d204532b75', '380e3eeeb05b456c9d479f0b2b9806f7', 'dfe12b03a1ca02a393b6818a39dc117e', '2021-01-28 14:18:30', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('fa3d70cfe3d911ec8579bbb9f73ff6f3', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3702', '2021-01-14 18:03:27', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('fae9bed1628ff67022d3ef496f0005f8', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3736', '2021-01-24 11:21:19', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('fafb3b67e7c94768f9cd671069ea269a', '380e3eeeb05b456c9d479f0b2b9806f7', 'f03c96a900ccae531765edc7688f0dfc', '2021-01-14 17:18:05', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('fb0caa7db9d211bcf924505c5edaa516', '380e3eeeb05b456c9d479f0b2b9806f7', '305220e89e4adb184845c95ea6c305f6', '2021-01-23 17:22:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('fb5b0c81413532869e5413e997263cf1', '380e3eeeb05b456c9d479f0b2b9806f7', 'd24995bf82bf48e91a6fe6b7cc812f2d', '2021-01-14 13:52:33', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('fb751fdbf64b65f76bf63128f93ad86e', '380e3eeeb05b456c9d479f0b2b9806f7', '8444b41000ecf8a5628909e584f93996', '2021-01-15 10:22:28', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('fc5ee1e2c9b25be750c088310d7c07e1', '380e3eeeb05b456c9d479f0b2b9806f7', '3e4f7e0639fb47dda548998c285e3702', '2021-01-28 14:21:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_role_menu` VALUES ('fc8f9a962f81f865ba5f4346eb3727ed', '380e3eeeb05b456c9d479f0b2b9806f7', '7322f83175a3f7cac7c6c86db79fee39', '2021-01-28 10:46:45', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('fd463ebc936f3eae454600e046328072', '380e3eeeb05b456c9d479f0b2b9806f7', 'd24995bf82bf48e91a6fe6b7cc812f2d', '2021-01-23 17:22:48', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('fdd29fe3dbddf1562d15f7bb44a1d8c1', '380e3eeeb05b456c9d479f0b2b9806f7', '7322f83175a3f7cac7c6c86db79fee39', '2021-01-14 18:03:27', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('fe0753d5d0e68cf73e911bcb126bd40c', '380e3eeeb05b456c9d479f0b2b9806f7', '239ac5abd4190fcb649733b1e5ef6a99', '2021-01-14 17:54:40', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('fe9bfe232d6d482d5b816cabba23eb91', '380e3eeeb05b456c9d479f0b2b9806f7', 'd9dcc7ae8e36fc5c19b82b60b30e443f', '2021-01-21 13:03:34', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_role_menu` VALUES ('fec82a25f6d93c0a03dfec3bc1463a1d', '380e3eeeb05b456c9d479f0b2b9806f7', '239ac5abd4190fcb649733b1e5ef6a99', '2021-01-14 14:40:13', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nickname` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名(昵称)',
  `username` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `office_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构id',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `telephone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `enabled` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '是否启用',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `del_flag` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_account`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('43d2badc4486b82f550a7e8a93d77b18', '李欢', 'lh2', '$2a$10$L46O3XQ1./TdiJm85aB0O.S9N5iPDImLRG/pYLTMwgg7.Gb76yDTO', '', NULL, '1451633962@qq.com', '', '1', NULL, NULL, NULL, NULL, '', '1');
INSERT INTO `sys_user` VALUES ('6942b3e7bca899aae0d61fbbb153b34b', 'hang', 'user1', '$2a$10$vsI6mLyGf/2RgcEMLWs9YOAEF/OjU0MJoIVC8z2vD78BXcefvJ1LW', '', 'e9c5ee49db4ca2a200602825b5ba3f03', '', '', '0', '2021-01-13 15:09:21', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, '', '1');
INSERT INTO `sys_user` VALUES ('84a2b481e6ce468797d07ca0bca29f01', 'admin', 'admin', '', '', 'e9c5ee49db4ca2a200602825b5ba3f03', '', '', '0', '2020-12-28 14:05:16', '', '2021-01-13 15:52:32', 'd0c82e56a5224b1cb8d9cbd00386a015', '', '0');
INSERT INTO `sys_user` VALUES ('d0c82e56a5224b1cb8d9cbd00386a015', '韩桂林', 'han', '$2a$10$7/L4uX4CLc9B6V2ZHULwXurGpK1q6Rst5wuhW0YJa.xX/q593Zbqe', NULL, NULL, NULL, '15870580719', '0', '2020-12-28 10:30:54', '1', '2020-12-28 10:31:00', '1', NULL, '0');
INSERT INTO `sys_user` VALUES ('e93339696da7e8d0774d68d97c101ca4', '李欢', 'lh', '', '', '5df4b176d0d6d5e92c28a68574cbf7d1', '', '', '0', NULL, NULL, '2021-01-13 15:49:42', 'd0c82e56a5224b1cb8d9cbd00386a015', '', '0');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `del_flag` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('25283c0a19d004a2fa6fef928bebfca0', 'd0c82e56a5224b1cb8d9cbd00386a015', '380e3eeeb05b456c9d479f0b2b9806f7', '2021-01-13 14:49:41', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_user_role` VALUES ('7bec99fecaf38b287a889f7a845ce810', '6942b3e7bca899aae0d61fbbb153b34b', '380e3eeeb05b456c9d479f0b2b9806f7', '2021-01-13 15:09:21', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '1');
INSERT INTO `sys_user_role` VALUES ('8264600bce9e50bb553c98fc38d30cf1', '1663c7c21a8808dcbee7f387c4aa1a5e', '380e3eeeb05b456c9d479f0b2b9806f7', '2021-01-13 15:08:05', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_user_role` VALUES ('8d70173d40e52018750870668696a8bb', 'e93339696da7e8d0774d68d97c101ca4', '380e3eeeb05b456c9d479f0b2b9806f7', '2021-01-13 14:49:41', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `sys_user_role` VALUES ('d0c82e56a5224b1cb8d9cbd00386a015', 'd0c82e56a5224b1cb8d9cbd00386a015', '380e3eeeb05b456c9d479f0b2b9806f7', NULL, NULL, NULL, NULL, NULL, '1');
INSERT INTO `sys_user_role` VALUES ('f3ad0599657546d5a730c1f7aea30722', '9febc8527ca46b8819438b9af5b4ea20', '380e3eeeb05b456c9d479f0b2b9806f7', '2021-01-13 15:02:47', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
