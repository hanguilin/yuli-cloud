/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50713
 Source Host           : localhost:3306
 Source Schema         : yuli_code_generator

 Target Server Type    : MySQL
 Target Server Version : 50713
 File Encoding         : 65001

 Date: 29/01/2021 16:42:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for datasource_conf
-- ----------------------------
DROP TABLE IF EXISTS `datasource_conf`;
CREATE TABLE `datasource_conf`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '数据源名称',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '数据源url',
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '数据源用户名',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '数据源密码',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `create_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `update_by` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '数据源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of datasource_conf
-- ----------------------------
INSERT INTO `datasource_conf` VALUES ('05ebdcfcb913293d546860ed80ed1407', 'quartz', 'jdbc:mysql://network-yuli-quartz:3306/yuli_quartz?useUnicode=true&characterEncoding=utf-8&useSSL=false&nullCatalogMeansCurrent=true&serverTimezone=Asia/Shanghai', 'root', '1dnX4/2TzNknGlbXXlb8LQ==', '2021-01-28 13:52:29', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, '', '', '0');
INSERT INTO `datasource_conf` VALUES ('ab29cc14efd6dfe1b58b1675f607de15', 'ss', 'jdbc:mysql://network-yuli-quartz:3306/yuli_quartz?useUnicode=true&characterEncoding=utf-8&useSSL=false&nullCatalogMeansCurrent=true&serverTimezone=Asia/Shanghai', 'root', 'BzoEteY4IyJma+ve5eqVxw==', '2021-01-29 16:31:34', 'd0c82e56a5224b1cb8d9cbd00386a015', '2021-01-29 16:33:03', '', '', '1');
INSERT INTO `datasource_conf` VALUES ('ed591b24e31540ea1b8e29512b41c8c6', 'system', 'jdbc:mysql://network-yuli-auth:3306/yuli_system?useUnicode=true&characterEncoding=utf-8&useSSL=false&nullCatalogMeansCurrent=true&serverTimezone=Asia/Shanghai', 'root', '/vbrIv3wu54KbFNt4t6woA==', '2021-01-23 19:18:42', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, '', '', '0');

-- ----------------------------
-- Table structure for field_definition
-- ----------------------------
DROP TABLE IF EXISTS `field_definition`;
CREATE TABLE `field_definition`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `column_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '列名',
  `column_type` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '列类型',
  `column_length` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '列长度',
  `column_nullable` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '列是否可为空',
  `column_is_primary` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '列是否主键',
  `column_default_value` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '列默认值',
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注释',
  `property_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'java属性名',
  `property_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'java属性类型',
  `generator_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联生成id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `del_flag` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of field_definition
-- ----------------------------

-- ----------------------------
-- Table structure for generator_definition
-- ----------------------------
DROP TABLE IF EXISTS `generator_definition`;
CREATE TABLE `generator_definition`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `table_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表名',
  `package_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '包名',
  `module_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '模块名',
  `sub_module_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '子模块名',
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '功能描述',
  `author` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作者',
  `project_version` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目版本',
  `gate_way_prefix` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网关访问前缀',
  `table_prefix` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表名前缀',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `del_flag` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of generator_definition
-- ----------------------------
INSERT INTO `generator_definition` VALUES ('016972574dc769fb70ae794f2f08e764', 'field_definition', 'cn.javayuli.cloud', 'field', 'test', '字段信息', 'hanguilin', '1.0', 'fie', '', '2021-01-24 13:10:05', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `generator_definition` VALUES ('09a4029dd7ece8f78034c86dfc3360c9', 'field_definition', 'cn.javayuli.cloud', 'field', 'test', '字段信息', 'hanguilin', '1.0', 'fie', '', '2021-01-24 12:48:16', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `generator_definition` VALUES ('0d2a4c92d7fcb6f44a351bab83995109', 'field_definition', 'cn.javayuli.cloud', 'field', 'test', '字段信息', 'hanguilin', '1.0', 'fie', '', '2021-01-24 13:18:36', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `generator_definition` VALUES ('15ab9ac3d595544fb916852da5f18b4e', 'field_definition', 'cn.javayuli.cloud', 'field', 'test', '字段信息', 'hanguilin', '1.0', 'fie', '', '2021-01-24 13:09:24', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `generator_definition` VALUES ('164974ce1339928c793ebbe0191b7876', 'field_definition', 'cn.javayuli.cloud', 'field', 'test', '字段信息', 'hanguilin', '1.0', 'fie', '', '2021-01-24 13:19:38', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `generator_definition` VALUES ('1d0a915cf4ae802b67de1e6fbf02a509', 'generator_definition', 'cn.javayuli.cloud', 'g', '', '', '', '1.0', '', '', '2021-01-24 13:20:14', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `generator_definition` VALUES ('29ca9784c48be61a08d3402fc0aeedf4', 'sys_quartz_job', 'cn.javayuli.cloud', 'quartz', '', '定时任务', 'hanguilin', '1.0', 'quartz', '', '2021-01-28 13:53:13', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `generator_definition` VALUES ('30353457665fd83083daa53974626d53', 'sys_quartz_job', 'cn.javayuli.cloud', 'quartz', '', '定时任务', 'hanguilin', '1.0', 'quartz', '', '2021-01-29 13:29:51', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `generator_definition` VALUES ('3cb7558b369bba561d02c5f02e24e3b8', 'field_definition', 'cn.javayuli.cloud', 'field', 'test', '字段信息', 'hanguilin', '1.0', 'fie', '', '2021-01-24 13:17:14', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `generator_definition` VALUES ('496a377f83a236a540c4d4c9a73c0804', 'field_definition', 'cn.javayuli.cloud', 'field', 'test', '字段信息', 'hanguilin', '1.0', 'fie', '', '2021-01-24 13:19:18', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `generator_definition` VALUES ('5c07c430cffc04fdd70c11d507940e75', 'field_definition', 'cn.javayuli.cloud', 'field', 'test', '字段信息', 'hanguilin', '1.0', 'fie', '', '2021-01-24 13:13:28', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `generator_definition` VALUES ('6772846927da685a3cd1e6d4b35b79dd', 'generator_definition', 'cn.javayuli.cloud', 'g', '', '', '', '1.0', '', '', '2021-01-24 13:22:54', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `generator_definition` VALUES ('78c13ce218e5c67c97f84cc8d86ead0a', 'field_definition', 'cn.javayuli.cloud', 'field', 'test', '字段信息', 'hanguilin', '1.0', 'fie', '', '2021-01-24 12:48:14', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `generator_definition` VALUES ('8fa072f68569bc5917cf0cb8f8921bac', 'field_definition', 'cn.javayuli.cloud', 'field', 'test', '字段信息', 'hanguilin', '1.0', 'fie', '', '2021-01-24 13:04:25', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `generator_definition` VALUES ('ab443b5b3b538e58586d0cfedf73442f', 'field_definition', 'cn.javayuli.cloud', 'field', 'test', '字段信息', 'hanguilin', '1.0', 'fie', '', '2021-01-24 13:25:47', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `generator_definition` VALUES ('b785d67037348c49cca1fdb45ac57f59', 'generator_definition', 'cn.javayuli.cloud', 'g', '', '', '', '1.0', '', '', '2021-01-24 13:21:15', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `generator_definition` VALUES ('b8641eb48f72d2e4d4022f6a9f7a9822', 'field_definition', 'cn.javayuli.cloud', 'field', 'test', '字段信息', 'hanguilin', '1.0', 'fie', '', '2021-01-24 12:48:10', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `generator_definition` VALUES ('bdba1e34b763ded4b03bdf2405ee4eb5', 'field_definition', 'cn.javayuli.cloud', 'field', 'test', '字段信息', 'hanguilin', '1.0', 'fie', '', '2021-01-24 13:24:09', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `generator_definition` VALUES ('be60a82836d005a8da79c0bb4587f46f', 'sys_quartz_job', 'cn.javayuli.cloud', 'quartz', '', '定时任务', 'hanguilin', '1.0', 'quartz', '', '2021-01-29 13:31:13', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `generator_definition` VALUES ('cc949f4eeb32b2587952fb0ffee89ac4', 'field_definition', 'cn.javayuli.cloud', 'field', 'test', '字段信息', 'hanguilin', '1.0', 'fie', '', '2021-01-24 12:36:30', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `generator_definition` VALUES ('d29252167070c9cff079dbf85bb427ab', 'field_definition', 'cn.javayuli.cloud', 'field', 'test', '字段信息', 'hanguilin', '1.0', 'fie', '', '2021-01-24 13:29:24', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `generator_definition` VALUES ('d9e7b4f20c4cc01d66cdd8266e54953f', 'field_definition', 'cn.javayuli.cloud', 'field', 'test', '字段信息', 'hanguilin', '1.0', 'fie', '', '2021-01-24 13:06:14', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `generator_definition` VALUES ('eb582c15c6ff7b1dd0387381385d4630', 'field_definition', 'cn.javayuli.cloud', 'field', 'test', '字段信息', 'hanguilin', '1.0', 'fie', '', '2021-01-24 13:04:39', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');
INSERT INTO `generator_definition` VALUES ('fd07172b88da47dc8f65284ddfa5f3f8', 'field_definition', 'cn.javayuli.cloud', 'field', 'test', '字段信息', 'hanguilin', '1.0', 'fie', '', '2021-01-24 13:05:42', 'd0c82e56a5224b1cb8d9cbd00386a015', NULL, NULL, NULL, '0');

SET FOREIGN_KEY_CHECKS = 1;
