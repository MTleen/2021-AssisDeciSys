/*
 Navicat Premium Data Transfer

 Source Server         : xiaofang
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : xiaofang

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 22/12/2022 15:02:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `adminID` int(2) NOT NULL AUTO_INCREMENT,
  `adminname` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`adminID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for detailtype
-- ----------------------------
DROP TABLE IF EXISTS `detailtype`;
CREATE TABLE `detailtype`  (
  `typeID` int(2) NOT NULL AUTO_INCREMENT,
  `typename` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `disastertype` int(2) UNSIGNED NULL DEFAULT NULL,
  `priority` int(2) NULL DEFAULT NULL COMMENT '安全知识类型',
  PRIMARY KEY (`typeID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of detailtype
-- ----------------------------
INSERT INTO `detailtype` VALUES (1, '高层建筑火灾扑救', 1, 1);
INSERT INTO `detailtype` VALUES (2, '多层建筑火灾扑救', NULL, 1);
INSERT INTO `detailtype` VALUES (3, '城市综合体火灾扑救', NULL, 1);
INSERT INTO `detailtype` VALUES (4, '地下建筑火灾扑救', NULL, 1);
INSERT INTO `detailtype` VALUES (5, '船舶火灾扑救', NULL, 1);
INSERT INTO `detailtype` VALUES (6, '带电场所及设备火灾扑救', NULL, 1);
INSERT INTO `detailtype` VALUES (7, '堆垛火灾扑救', NULL, 1);
INSERT INTO `detailtype` VALUES (8, '冷库火灾扑救', NULL, 3);
INSERT INTO `detailtype` VALUES (9, '厂库房火灾扑救', NULL, 1);
INSERT INTO `detailtype` VALUES (10, '粉尘场所火灾扑救', NULL, 3);
INSERT INTO `detailtype` VALUES (11, '化工储罐火灾扑救', NULL, 3);
INSERT INTO `detailtype` VALUES (12, '化工装置火灾扑救', NULL, 3);
INSERT INTO `detailtype` VALUES (13, '危险化学品仓储场所火灾扑救', NULL, 1);
INSERT INTO `detailtype` VALUES (14, '危险化学品道路运输事故处置', NULL, 1);
INSERT INTO `detailtype` VALUES (15, '锂电池汽车火灾扑救', NULL, 1);
INSERT INTO `detailtype` VALUES (16, '道路交通事故救援', NULL, 1);
INSERT INTO `detailtype` VALUES (17, '高空救援', NULL, 1);
INSERT INTO `detailtype` VALUES (18, '水域救援', NULL, 1);
INSERT INTO `detailtype` VALUES (19, '电梯救援', NULL, 1);
INSERT INTO `detailtype` VALUES (20, '污水井救援', NULL, 3);
INSERT INTO `detailtype` VALUES (21, '建筑坍塌救援', NULL, 3);
INSERT INTO `detailtype` VALUES (22, '居民燃气泄漏救援', NULL, 1);
INSERT INTO `detailtype` VALUES (23, '坑道救援', NULL, 3);
INSERT INTO `detailtype` VALUES (24, '泥石流灾害救援', NULL, 3);
INSERT INTO `detailtype` VALUES (25, '台风救援', NULL, 1);
INSERT INTO `detailtype` VALUES (26, '摘除蜂窝', NULL, 3);
INSERT INTO `detailtype` VALUES (27, '战斗员火灾类', NULL, 2);
INSERT INTO `detailtype` VALUES (28, '战斗员抢险类', NULL, 2);
INSERT INTO `detailtype` VALUES (29, '驾驶员行车、供水类', NULL, 2);

-- ----------------------------
-- Table structure for disastertype
-- ----------------------------
DROP TABLE IF EXISTS `disastertype`;
CREATE TABLE `disastertype`  (
  `typeID` int(2) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `typename` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `objID` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`typeID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of disastertype
-- ----------------------------
INSERT INTO `disastertype` VALUES (01, '火灾', NULL);
INSERT INTO `disastertype` VALUES (02, '抢险救援', NULL);
INSERT INTO `disastertype` VALUES (03, '社会救助', NULL);

-- ----------------------------
-- Table structure for disposeobj
-- ----------------------------
DROP TABLE IF EXISTS `disposeobj`;
CREATE TABLE `disposeobj`  (
  `objID` int(4) UNSIGNED NOT NULL AUTO_INCREMENT,
  `objname` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `distype` int(2) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`objID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of disposeobj
-- ----------------------------
INSERT INTO `disposeobj` VALUES (1, '一般居民', 1);
INSERT INTO `disposeobj` VALUES (2, '高层住宅', 1);
INSERT INTO `disposeobj` VALUES (3, '学校', 1);
INSERT INTO `disposeobj` VALUES (4, '一般单位', 1);
INSERT INTO `disposeobj` VALUES (6, '高层建筑', 1);
INSERT INTO `disposeobj` VALUES (7, '工程工地', 1);
INSERT INTO `disposeobj` VALUES (8, '人员密集场所', 1);
INSERT INTO `disposeobj` VALUES (9, '地下空间', 1);
INSERT INTO `disposeobj` VALUES (10, '机动车', 1);
INSERT INTO `disposeobj` VALUES (11, '船舶', 1);
INSERT INTO `disposeobj` VALUES (12, '地上轨道交通', 1);
INSERT INTO `disposeobj` VALUES (13, '地下轨道交通', 1);
INSERT INTO `disposeobj` VALUES (14, '室外电力设施', 1);
INSERT INTO `disposeobj` VALUES (15, '室外杂物', 1);
INSERT INTO `disposeobj` VALUES (16, '其他', 1);
INSERT INTO `disposeobj` VALUES (17, '不明异味', 2);
INSERT INTO `disposeobj` VALUES (18, '救助人员', 2);
INSERT INTO `disposeobj` VALUES (19, '燃气泄露', 2);
INSERT INTO `disposeobj` VALUES (20, '电梯故障', 2);
INSERT INTO `disposeobj` VALUES (21, '危化品泄漏', 2);
INSERT INTO `disposeobj` VALUES (22, '建筑物垮塌事故', 2);
INSERT INTO `disposeobj` VALUES (23, '扬言自杀', 2);
INSERT INTO `disposeobj` VALUES (24, '燃气自杀', 2);
INSERT INTO `disposeobj` VALUES (25, '跳河自杀', 2);
INSERT INTO `disposeobj` VALUES (26, '跳楼自杀', 2);
INSERT INTO `disposeobj` VALUES (27, '纵火自焚', 2);
INSERT INTO `disposeobj` VALUES (28, '高空排险', 2);
INSERT INTO `disposeobj` VALUES (29, '水域救援', 2);
INSERT INTO `disposeobj` VALUES (30, '人员被困', 2);
INSERT INTO `disposeobj` VALUES (31, '公路', 2);
INSERT INTO `disposeobj` VALUES (32, '其他', 2);
INSERT INTO `disposeobj` VALUES (33, '防汛', 2);

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback`  (
  `feedID` int(10) NOT NULL AUTO_INCREMENT,
  `tele` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `inform` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`feedID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for firefightingtruck
-- ----------------------------
DROP TABLE IF EXISTS `firefightingtruck`;
CREATE TABLE `firefightingtruck`  (
  `license` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `truckID` int(4) NOT NULL AUTO_INCREMENT,
  `trucktype` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `siteID` int(2) NULL DEFAULT NULL,
  `peoplenum` int(9) NULL DEFAULT NULL,
  PRIMARY KEY (`truckID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for forceinvolve
-- ----------------------------
DROP TABLE IF EXISTS `forceinvolve`;
CREATE TABLE `forceinvolve`  (
  `cautionID` int(100) NOT NULL,
  `siteID` int(100) UNSIGNED NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of forceinvolve
-- ----------------------------
INSERT INTO `forceinvolve` VALUES (1, 1);
INSERT INTO `forceinvolve` VALUES (2, 1);
INSERT INTO `forceinvolve` VALUES (4, 2);
INSERT INTO `forceinvolve` VALUES (4, 1);

-- ----------------------------
-- Table structure for gen_table
-- ----------------------------
DROP TABLE IF EXISTS `gen_table`;
CREATE TABLE `gen_table`  (
  `table_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '表名称',
  `table_comment` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '表描述',
  `sub_table_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '关联子表的表名',
  `sub_table_fk_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '子表关联的外键名',
  `class_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '实体类名称',
  `tpl_category` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'crud' COMMENT '使用的模板（crud单表操作 tree树表操作）',
  `package_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '生成包路径',
  `module_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '生成模块名',
  `business_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '生成业务名',
  `function_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '生成功能名',
  `function_author` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '生成功能作者',
  `gen_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '生成代码方式（0zip压缩包 1自定义路径）',
  `gen_path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '/' COMMENT '生成路径（不填默认项目路径）',
  `options` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '其它生成选项',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`table_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '代码生成业务表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for gen_table_column
-- ----------------------------
DROP TABLE IF EXISTS `gen_table_column`;
CREATE TABLE `gen_table_column`  (
  `column_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `table_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '归属表编号',
  `column_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '列名称',
  `column_comment` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '列描述',
  `column_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '列类型',
  `java_type` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'JAVA类型',
  `java_field` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'JAVA字段名',
  `is_pk` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '是否主键（1是）',
  `is_increment` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '是否自增（1是）',
  `is_required` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '是否必填（1是）',
  `is_insert` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '是否为插入字段（1是）',
  `is_edit` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '是否编辑字段（1是）',
  `is_list` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '是否列表字段（1是）',
  `is_query` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '是否查询字段（1是）',
  `query_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'EQ' COMMENT '查询方式（等于、不等于、大于、小于、范围）',
  `html_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）',
  `dict_type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '字典类型',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`column_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '代码生成业务表字段' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for history
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history`  (
  `index` int(100) NOT NULL AUTO_INCREMENT,
  `cautionID` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `informID` int(2) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT 'knowedge表中的informID',
  `positionID` int(2) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `sendtime` datetime(0) NULL DEFAULT NULL,
  `tele` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `librarytype` int(2) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '知识类型',
  `sendtimeStart` datetime(0) NULL DEFAULT NULL,
  `sendtimeEnd` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`index`) USING BTREE,
  INDEX `infomid`(`informID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of history
-- ----------------------------
INSERT INTO `history` VALUES (1, '27', 01, 01, '2022-12-22 11:05:41', '18516291129', 01, '2022-12-22 11:05:54', '2022-12-01 12:05:58');
INSERT INTO `history` VALUES (2, '24', 02, 02, '2022-12-23 11:15:08', '119', 02, '2022-12-22 11:15:20', '2022-12-22 13:15:22');
INSERT INTO `history` VALUES (3, '3', 01, NULL, '2022-12-22 15:00:18', '18516291129', 01, NULL, NULL);
INSERT INTO `history` VALUES (4, '3', 33, NULL, '2022-12-22 15:00:18', '18516291129', 01, NULL, NULL);
INSERT INTO `history` VALUES (5, '3', 18, NULL, '2022-12-22 15:00:18', '18516291129', 01, NULL, NULL);
INSERT INTO `history` VALUES (6, '3', 14, NULL, '2022-12-22 15:00:18', '18516291129', 01, NULL, NULL);
INSERT INTO `history` VALUES (7, '3', 02, NULL, '2022-12-22 15:00:18', '18516291129', 02, NULL, NULL);
INSERT INTO `history` VALUES (8, '3', 05, NULL, '2022-12-22 15:00:18', '18516291129', 02, NULL, NULL);
INSERT INTO `history` VALUES (9, '4', 25, NULL, '2022-12-22 15:01:13', '119', 01, NULL, NULL);
INSERT INTO `history` VALUES (10, '4', 26, NULL, '2022-12-22 15:01:13', '119', 01, NULL, NULL);
INSERT INTO `history` VALUES (11, '4', 32, NULL, '2022-12-22 15:01:13', '119', 01, NULL, NULL);
INSERT INTO `history` VALUES (12, '4', 38, NULL, '2022-12-22 15:01:13', '119', 01, NULL, NULL);
INSERT INTO `history` VALUES (13, '4', 249, NULL, '2022-12-22 15:01:13', '119', 02, NULL, NULL);
INSERT INTO `history` VALUES (14, '4', 186, NULL, '2022-12-22 15:01:13', '119', 02, NULL, NULL);
INSERT INTO `history` VALUES (15, '4', 25, NULL, '2022-12-22 15:01:13', '119', 01, NULL, NULL);
INSERT INTO `history` VALUES (16, '4', 27, NULL, '2022-12-22 15:01:13', '119', 01, NULL, NULL);
INSERT INTO `history` VALUES (17, '4', 29, NULL, '2022-12-22 15:01:13', '119', 01, NULL, NULL);
INSERT INTO `history` VALUES (18, '4', 30, NULL, '2022-12-22 15:01:13', '119', 01, NULL, NULL);
INSERT INTO `history` VALUES (19, '4', 257, NULL, '2022-12-22 15:01:13', '119', 02, NULL, NULL);
INSERT INTO `history` VALUES (20, '4', 248, NULL, '2022-12-22 15:01:13', '119', 02, NULL, NULL);
INSERT INTO `history` VALUES (21, '4', 25, NULL, '2022-12-22 15:01:13', '18516291129', 01, NULL, NULL);
INSERT INTO `history` VALUES (22, '4', 29, NULL, '2022-12-22 15:01:13', '18516291129', 01, NULL, NULL);
INSERT INTO `history` VALUES (23, '4', 31, NULL, '2022-12-22 15:01:13', '18516291129', 01, NULL, NULL);
INSERT INTO `history` VALUES (24, '4', 32, NULL, '2022-12-22 15:01:13', '18516291129', 01, NULL, NULL);
INSERT INTO `history` VALUES (25, '4', 162, NULL, '2022-12-22 15:01:13', '18516291129', 02, NULL, NULL);
INSERT INTO `history` VALUES (26, '4', 198, NULL, '2022-12-22 15:01:13', '18516291129', 02, NULL, NULL);

-- ----------------------------
-- Table structure for informtype
-- ----------------------------
DROP TABLE IF EXISTS `informtype`;
CREATE TABLE `informtype`  (
  `typeID` int(2) NOT NULL AUTO_INCREMENT,
  `typename` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`typeID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for knowledge
-- ----------------------------
DROP TABLE IF EXISTS `knowledge`;
CREATE TABLE `knowledge`  (
  `informID` int(2) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `inform` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `disastertype` int(2) NULL DEFAULT NULL,
  `disposeobj` int(2) NULL DEFAULT NULL,
  `detailtype` int(2) NULL DEFAULT NULL COMMENT '和detailtype的typeid联系',
  `label` int(2) NULL DEFAULT NULL,
  `informtypeID` int(2) NULL DEFAULT NULL,
  `weight` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`informID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 217 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of knowledge
-- ----------------------------
INSERT INTO `knowledge` VALUES (01, '严格落实一线指挥。指挥员要靠前指挥。', 1, 1, 1, 1, 1, 1);
INSERT INTO `knowledge` VALUES (02, '深入内部侦察掌握火场情况，研判安全风险。', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (03, '合理选择进攻途径，优先利用防烟楼梯间登高，严禁乘坐普通电梯。', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (04, '乘坐消防电梯登高时，要停靠在着火层下两层并提前戴好空气呼吸器面罩。', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (05, '使用电梯时严禁停靠着火层或穿越着火层。', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (06, '正确选择进攻起点，要熟悉建筑功能布局。', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (07, '选择着火层下一层或下两层作为进攻起点，集结人员和器材装备。', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (08, '从进攻起点层铺设水带，通过疏散楼梯进入着火层，做好出水准备或充水跟进。', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (09, '个人防护、侦察、水带等器材装备尽可能一次性携带到位。', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (10, '要保证充足的备用气瓶供给，避免多次往返消耗体能。', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (11, '防止发生人员迷失。加强通信联络，全程掌握内攻人员情况。', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (12, '进入充烟区域应携带热成像仪，铺设水带或敷设救生照明线、使用安全绳等器材装备。', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (13, '进入密闭房间前，要检测判断内部温度，做好出水掩护，采取限位措施，合理站位。', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (14, '防止发生轰燃或穿堂风夹带烟火伤人。', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (15, '严防高空坠落意外。', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (16, '不得随意破拆高位玻璃幕墙，', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (17, '必须破拆时，应划出警戒区域，并保持必要的安全距离；', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (18, '垂直铺设水带下方严禁站人。', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (19, '谨慎实施举高作业。工作平台严禁超载。', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (20, '举高消防车疏散救人灭火，应避开着火或火势蔓延部位。', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (21, '严禁使用拉梯搭桥救人，严禁悬空铺设水带。', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (22, '正确实施紧急避险。谨慎采用绳索自救方式紧急避险。', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (23, '绳索自救时应将绳索两端事前与支点及安全腰带固结牢固。', NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (24, '做好触电防范，防止电线绝缘层烧毁或老化触电。', NULL, NULL, 2, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (25, '有触电风险的，要谨慎探索前行，手背向外，不得背靠墙体裸露电线。', NULL, NULL, 2, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (26, '当心燃气泄漏。发生室内燃气泄漏的，要加强检测、通风排气、稀释抑爆，注意开门方式和正确站位；', NULL, NULL, 2, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (27, '液化气钢瓶泄漏的，还应采取关阀或应急堵漏、冷却转移等措施。', NULL, NULL, 2, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (28, '防止塌落踏空。', NULL, NULL, 2, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (29, '出现建筑构件变形、裂缝、异响和楼板变形等建筑倒塌征兆时，不得贸然内攻；', NULL, NULL, 2, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (30, '深入建筑内部时，要使用水枪扫射吊顶或不稳定物体。', NULL, NULL, 2, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (31, '设有木质楼板或木质楼梯的，要探测判别结构稳定性，防止踏空坠落。', NULL, NULL, 2, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (32, '防止轰燃发生。', NULL, NULL, 2, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (33, '进入封闭建筑内，要检测判别室内温度，采取出水降温增湿等防轰燃措施。', NULL, NULL, 2, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (34, '避免烟气伤害。内攻人员原则上不得采取从着火层上方缓降的方式进攻。', NULL, NULL, 2, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (35, '有人员被困阳台、窗户的，开门射水要防止高温烟气流向被困人员造成伤害坠落。', NULL, NULL, 2, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (36, '注意架梯安全。', NULL, NULL, 2, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (37, '架梯登高灭火应避开冒烟的阳台、窗口正面。', NULL, NULL, 2, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (38, '在梯上出水的，要防止水锤作用或拉扯水带将梯子掀翻伤人。', NULL, NULL, 2, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (39, '熟悉内部分隔，指挥员要详细查看建筑结构分布图。', NULL, NULL, 3, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (40, '熟悉建筑结构和功能布局，预判安全风险隐患，科学选择进攻路线。', NULL, NULL, 3, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (41, '加强安全防护。进入黑暗、充烟空间，进攻阵地必须储备足够的空气呼吸器备用气瓶。', NULL, NULL, 3, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (42, '进入黑暗、充烟空间，携带热成像仪，铺设水带或敷设救生照明线、使用安全绳等器材装备；', NULL, NULL, 3, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (43, '加强通信联络，通过电台和后场接收装置，全程掌握内攻人员情况。', NULL, NULL, 3, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (44, '合理设置阵地。内攻行动要依托防火分区、承重墙设置进攻或堵截阵地。', NULL, NULL, 3, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (45, '水枪未到位的情况下不得贸然开启或破拆防火卷帘，防止火势蔓延或充烟迷失。', NULL, NULL, 3, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (46, '做好紧急救助。设置安全员，严格做好安全检查；', NULL, NULL, 3, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (47, '外部设立紧急救助小组，做好紧急救助准备。', NULL, NULL, 3, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (48, '观察烟气流动。排烟散热时，要充分考虑烟气流向，', NULL, NULL, 3, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (49, '合理选择进风口、排烟口的位置，做到攻防结合，必要时进行射水保护，防止烟气突然充斥后迷失方向。', NULL, NULL, 3, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (50, '防止倒塌伤人；火势突破建筑外壳，有建（构）筑物、外部装饰物坍塌风险时，不得内攻。', NULL, NULL, 3, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (51, '尽量减少建筑周边人员，保持必要的安全距离。', NULL, NULL, 3, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (52, '必须编组开展作业。', NULL, NULL, 4, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (53, '内攻人员必须编组行动，落实出入口安全管控，记录进出人员、时间、气瓶压力等信息，提醒安全注意事项。', NULL, NULL, 4, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (54, '加强个人安全防护。进入内部人员应严格落实安全防护措施，佩戴空（氧）气呼吸器，携带热成像仪，穿着降温背心。', NULL, NULL, 4, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (55, '内攻时，需铺设水带或敷设救生照明线，使用安全绳等器材装备，必要时设置水枪同步跟进，梯次掩护。', NULL, NULL, 4, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (56, '做好紧急救助准备。内攻小组必须同进同出；外部设立紧急救助小组，做好紧急救助准备。', NULL, NULL, 4, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (57, '合理选择进攻路线。内攻灭火前应熟悉地下建筑内部结构、布局等情况。', NULL, NULL, 4, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (58, '内攻路线尽量选择上风、进风口或烟量少的出入口进攻，减少烟气对指战员的伤害。', NULL, NULL, 4, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (59, '扑救地下车库火灾，应加强对油箱和汽车轮胎的冷却保护，避免发生爆炸造成灾情扩大和人员伤害。', NULL, NULL, 4, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (60, '保持通信联络畅通。', NULL, NULL, 4, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (61, '对信号干扰大，影响内外通信的，应设置中继装置，保障通信联络不间断，全程掌握内攻人员情况。', NULL, NULL, 4, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (62, '谨慎实施内攻行动。对高温浓烟积聚、内部情况不明时，应采取灭火机器人开辟通道等方式，枪炮协同推进灭火。', NULL, NULL, 4, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (63, '确保封堵区域安全。使用高倍数泡沫窒息灭火前，必须确认灌注、封堵区域人员已全部撤离。', NULL, NULL, 4, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (64, '不得贸然登船。油轮、液化气轮发生火灾，不得轻易登船灭火；', NULL, NULL, 5, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (65, '确有必要实施时，必须精简一线人员，做好紧急救助措施，并保持一定的安全距离。', NULL, NULL, 5, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (66, '强化侦察研判。要充分发挥船舶技术或工作人员作用。', NULL, NULL, 5, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (67, '详细了解掌握船舶类型、功能布局、装载物品特性，预判安全风险隐患，并在其引导下实施内攻作业。', NULL, NULL, 5, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (68, '严格出入管控，设置安全员，实行编组行动，记录进出人员姓名、时间、空气呼吸器压力等信息。', NULL, NULL, 5, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (69, '进入内部人员应佩戴空气呼吸器、携带热成像仪，同步铺设水带或使用安全绳等器材装备，必要时出水枪同步跟进掩护。', NULL, NULL, 5, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (70, '设置进出引导。铺设水带或安全绳作为行动引导，必须沿行进路面铺设，不得悬空横跨，避免造成方向迷失。', NULL, NULL, 5, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (71, '严禁盲目射水，有人员实施内攻时，严禁从排烟口等部位向内射水，避免形成高温蒸汽伤害。', NULL, NULL, 5, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (72, '船体高温炙烤，严禁用直流水直击船体钢板，防止瞬间形成高温蒸汽反扑伤人。', NULL, NULL, 5, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (73, '抑制爆炸发生。火灾高温影响机舱时，要监测油蒸汽浓度，做好冷却稀释防爆措施；有爆炸风险应迅速撤离。', NULL, NULL, 5, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (74, '确保封舱安全。封舱灭火时，必须确认灌注、封堵区域人员已全部撤离。', NULL, NULL, 5, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (75, '侦察判断是否带电。详细了解判断带电情况，通知起火单位切断电源，并通过仪器检测进行确认，不可轻信大意。', NULL, NULL, 6, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (76, '做好个人安全防护。进入漏电危险区域必须穿戴绝缘服、绝缘手套、绝缘胶靴，避免与带电体接触。', NULL, NULL, 6, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (77, '谨慎实施带电灭火。必须带电灭火时，与带电体要保持足够的安全距离，不得靠近电线断落的区域尤其是积水区域；', NULL, NULL, 6, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (78, '误入带电区域应双脚并拢或单脚跳离，防止产生跨步电压。', NULL, NULL, 6, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (79, '合理选择灭火方式。尽量使用二氧化碳、干粉等灭火剂进行灭火；', NULL, NULL, 6, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (80, '火势较大需用水扑救时，可采用雾状射流、向火势上方或上风风向射水、直流点射等方式灭火；必要时采取水枪接地保护。', NULL, NULL, 6, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (81, '防止变压油箱爆炸。油浸式电力变压器发生火灾，要加强油箱的冷却保护，防止发生爆炸造成伤害。', NULL, NULL, 6, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (82, '正确实施触电急救。对触电人员要采取不间断心肺复苏等急救措施。', NULL, NULL, 6, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (83, '发现有人员触电时，应用干燥的木棒、竹竿等绝缘体将触电者与电源分离，或立即切断电源使触电者脱离电源；', NULL, NULL, 6, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (84, '严禁贸然攀登垛顶。不得盲目攀登燃烧堆垛设置阵地，防止垛心烧空坠入。', NULL, NULL, 7, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (85, '保持一定安全距离。设置水枪阵地时，应与堆垛保持足够的安全距离，防止堆垛倒塌伤人。', NULL, NULL, 7, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (86, '不得盲目深入内部。', NULL, NULL, 7, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (87, '火势燃烧猛烈时，不得贸然深入堆垛中间，防止飞火切断退路被火势围困。', NULL, NULL, 7, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (88, '确保进出通道畅通。', NULL, NULL, 7, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (89, '有倒塌风险的，深入内部前要预先合理规划行进和撤离路线，避免堆垛倒塌阻碍撤离路线；', NULL, NULL, 7, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (90, '当火场风向发生改变或火情出现突变、对消防员的安全构成重大威胁时，要立即组织撤离。', NULL, NULL, 7, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (91, '有序组织疏散转移。', NULL, NULL, 7, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (92, '利用大型机械设备转移疏散堆垛物品，要落实专人指挥，科学确定疏散进出路线，防止现场车辆和人员冲撞。', NULL, NULL, 7, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (93, '谨慎处置涉化堆垛，在技术人员指导和协助下实施处置。', NULL, NULL, 7, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (94, '扑救危险化学品或遇湿易燃物品时，不得盲目出水灭火，应根据其理化性质，合理选择灭火药剂，在技术人员指导和协助下实施处置。', NULL, NULL, 7, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (95, '防止建筑承重过载。', NULL, NULL, 7, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (96, '扑救棉花、纸张等具有吸水性的物品堆垛火灾，要加强排水，防止积水较多超过建筑承重而发生坍塌。', NULL, NULL, 7, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (97, '安全停靠车辆。参战车辆应与着火建筑保持一定的安全距离，严禁在狭窄通道、雨棚、女儿墙等延伸构件下方停靠。', NULL, NULL, 9, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (98, '侦察掌握情况。侦察了解厂房建筑结构形式、功能布局、生产工艺性质，以及毗邻情况，预判安全风险隐患。', NULL, NULL, 9, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (99, '确保阵地安全。火势不大、具备内攻条件时，应选择在承重墙、柱下方且无货物堆垛处设置水枪阵地。', NULL, NULL, 9, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (100, '当火势突破建筑外壳时，不得内攻，水枪阵地设置必须保持与建筑高度1.5倍以上的距离。', NULL, NULL, 9, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (101, '确保进出畅通。进入充烟区域应携带热成像仪，铺设水带或敷设救生照明线、安全绳等器材装备，', NULL, NULL, 9, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (102, '加强通信联络，全程掌握内攻人员情况。', NULL, NULL, 9, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (103, '严密组织内攻。内攻小组不得少于3人，在水枪掩护下实施作战行动，做到同出同进，防止迷失；', NULL, NULL, 9, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (104, '组织内攻时，必要时在每个区段或战斗面预备紧急救助小组。', NULL, NULL, 9, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (105, '防止倒塌伤人。扑救大跨度厂库房火灾，应选择机器人、移动炮等远程喷射器具冷却、堵截、灭火，尽量减少内攻人员；', NULL, NULL, 9, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (106, '对建筑构件冷却要均匀，避免直流水对梁、柱、墙等承重构件产生高压冲击导致坍塌。', NULL, NULL, 9, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (107, '谨慎涉化处置。厂房存有危险化学品或遇湿易燃物品时，不得盲目出水灭火。', NULL, NULL, 9, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (108, '谨慎涉化处置。应根据其理化性质，合理选择灭火药剂，在技术人员指导和协助下实施处置。', NULL, NULL, 9, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (109, '合理设置阵地。参战车辆停靠上风或侧上风方向，车头朝向撤离方向。', NULL, NULL, 13, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (110, '严禁停靠在地势低洼处和窨井盖、下水道附近，并与现场必须保持足够的安全距离，不得贸然进入厂区、库区。', NULL, NULL, 13, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (111, '谨慎强攻近战。现场情况不明，正在发生爆炸或可能发生爆炸的，不得强攻近战；', NULL, NULL, 13, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (112, '对现场情况比较清楚，不及时采取有效措施将产生灾难性后果，经研判现场具备作战条件的，可以组织进攻。', NULL, NULL, 13, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (113, '正确选用灭火剂。合理选择灭火药剂，有毒气体火灾应用雾状或开花水流稀释；', NULL, NULL, 13, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (114, '可燃液体火灾应用泡沫覆盖扑救；可燃气体火灾应用二氧化碳和干粉扑救；', NULL, NULL, 13, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (115, '遇水燃烧或活泼金属火灾应用干粉、沙土、水泥或特殊灭火剂覆盖灭火，严禁射水。', NULL, NULL, 13, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (116, '加强安全防护。必须按危险等级穿着相应的防护装具，进攻路线应从上风或侧上风方向进入，视情采用喷射器具变换射流进行掩护进攻；', NULL, NULL, 13, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (117, '水枪手尽可能利用墙、柱等掩体，保持足够的安全距离，视情选择大口径水（泡沫）枪（炮），内部情况危险时，应设置移动炮；', NULL, NULL, 13, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (118, '尽量减少现场作业人员，充分利用地形、地物作掩体，避开泄压方向；需要出水掩护或降毒时，供水线路应不少于2路，且应来自不同的供水车辆。', NULL, NULL, 13, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (119, '防止建筑倒塌。扑救火灾过程中，注意仓库框架的承受能力，防止坍塌；', NULL, NULL, 13, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (120, '注意仓储及周边建筑蔓延情况，应第一时间观察风向，堵截火势向毗邻库房蔓延。', NULL, NULL, 13, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (121, '实施现场洗消。处置完毕，要对参战指战员、灭火用具、个人防护装备、车辆进行洗消处理，防止二次污染。', NULL, NULL, 13, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (122, '严格落实各项警戒措施，按要求划定警戒区域，禁止无关车辆和人员进入，必要时由专人负责，设置明显的警戒标识。', NULL, NULL, 14, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (123, '进入警戒区以内人员应根据介质理化性质，严格按等级做好防静电、防热辐射、防冻伤、防麻醉、防窒息、防腐蚀、防中毒等安全防护。', NULL, NULL, 14, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (124, '确认运输物质。对于剧毒、神经性毒剂、特殊危化品以及无法确认的危化品运输车辆事故，不得盲目处置；', NULL, NULL, 14, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (125, '要扩大警戒范围，提高防护等级，必要时取样送检，确定物质种类和理化性质，调集专业人员处置。', NULL, NULL, 14, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (126, '危化品道路运输罐车发生火灾，关阀、堵漏等切断气源措施未完全到位前，不宜直接扑灭火焰，防止回火爆炸伤人；', NULL, NULL, 14, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (127, '处置CNG罐车（压缩天然气）泄漏事故时，处置人员应避开泄漏口、爆破板、阀门等部位，防止高压气体造成切割伤害；', NULL, NULL, 14, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (128, '严禁在槽车罐体封头、长管拖车尾部停留或部署人员，防止超压爆炸伤人。', NULL, NULL, 14, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (129, '常温压力或低温常压罐车事故在进行冷却稀释抑爆时，应利用喷雾水枪、水幕水枪或移动摇摆炮进行不间断稀释，', NULL, NULL, 14, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (130, '不得喷射直流水或向超压罐体安全阀射水，不得向低温常压罐车结霜面射水，防止造成罐体超压破裂或爆炸伤人。', NULL, NULL, 14, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (131, '严格实施倒罐。处置装载丁二烯、丁烯-1、异丁烯、顺丁烯-2、反丁烯-2等全压力液化烃运输车辆，不能轻易采取直接倒罐，需对备用罐进行充氮，防止形成过氧化聚合分解爆炸。', NULL, NULL, 14, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (132, '紧急避险或紧急撤离时，严禁向地势低洼处或爆炸冲击物体抛洒方向撤离。', NULL, NULL, 14, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (133, '紧急避险或紧急撤离时，撤出爆炸核心区应立即寻找掩体或朝向爆炸冲击方向卧倒。严禁站立观望或在爆炸冲击泄压面走动。', NULL, NULL, 14, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (134, '加强个人安全防护。穿着全套灭火防护服，佩戴空气呼吸器、绝缘手套，从上风或侧上风方向接近起火车辆，', NULL, NULL, 15, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (135, '原则上保持5米以上的安全距离，防止中毒、电击、高温喷溅等伤害。', NULL, NULL, 15, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (136, '确保车辆断电状态。', NULL, NULL, 15, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (137, '火势初起阶段，立即实施断电，放空高压电，将车辆钥匙装入信号屏蔽袋或放置到10米外区域。', NULL, NULL, 15, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (138, '谨慎实施车辆破拆。破拆作业时，应尽量在专业技术人员指导下进行（电话远程指导）。', NULL, NULL, 15, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (139, '避开电池及高压装置等部位，防止高压放电伤人。', NULL, NULL, 15, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (140, '防止燃料箱罐爆炸。加强对燃料油（气）箱（罐）部位冷却保护，保持必要的安全距离，防止爆炸伤人。', NULL, NULL, 15, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (141, '全程警惕防范风险。明火扑灭后，要持续冷却降温，不得随意脱卸防护装备。', NULL, NULL, 15, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (142, '全程做好测电、测温、测气等侦检工作，防止复燃复爆；', NULL, NULL, 15, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (143, '发现温度急剧上升、释放大量烟气时，应立即撤离至安全区域。', NULL, NULL, 15, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (144, '加强现场警戒。普通道路警戒距离不少于200米，高速公路不少于500米，并在200米处设置第二道警戒。', NULL, NULL, 16, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (145, '遇有雨、雪、雾等天气或夜间，应使用反光或有灯光标识的警戒标志，警戒距离应扩大1-1.5倍，可设置多重警戒标志。', NULL, NULL, 16, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (146, '正确停靠车辆。救援车辆斜停来车方向距离事故车辆不少于50米处，成45度斜跨路中，开启警灯和双闪灯。', NULL, NULL, 16, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (147, '在下坡路段救援时，车辆应停在来车方向可视位置的坡度上，并采取稳固的防溜车措施。', NULL, NULL, 16, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (148, '注意起吊安全。严禁在车辆倾覆面、大型设备起重臂下、车辆牵引绳旁站人，防止二次伤害。', NULL, NULL, 16, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (149, '起吊作业时，应确认起吊或起重设备的吨位在规定范围内，严格控制车下作业人员数量。', NULL, NULL, 16, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (150, '谨慎实施破拆。破拆车辆时应进行固定保护，避开安全气囊、高压油路等危险区域，保持必要的安全距离。', NULL, NULL, 16, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (151, '对破拆车辆形成的锋利棱角进行包扎保护。', NULL, NULL, 16, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (152, '破拆新能源车时，应尽量在专业技术人员指导下进行，避开电池及高压装置等部位。', NULL, NULL, 16, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (153, '防止爆炸流淌。事故车辆着火时，应用喷雾水冷却保护事故车辆油箱，用泡沫覆盖燃烧的油箱和地面流淌火。', NULL, NULL, 16, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (154, '灭火时，避开车辆轮胎部位，防止发生爆炸。', NULL, NULL, 16, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (155, '做好自身防护。应选择与本人身材匹配的专用头盔、全身式安全吊带，携带安全绳，配备防坠落辅助部件等器材装备。', NULL, NULL, 17, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (156, '采取地面保护。可根据作业环境，铺设救生气垫、设置安全网，进行辅助安全保护。', NULL, NULL, 17, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (157, '使用绳索开展高空救援时，应对绳索及附件进行安全检查，经过安全员核查合格后方可实施救助作业。', NULL, NULL, 17, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (158, '选择并制作不少于2个牢固的支点，利用人作支点时，绳索一端应固定在腰间。', NULL, NULL, 17, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (159, '高空救援要确保成功率，应制定多套方案，并同步开展救援行动。', NULL, NULL, 17, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (160, '避开危险威胁。保护绳索应避开墙角、烟火等尖锐、高温部位；', NULL, NULL, 17, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (161, '必须穿越时应采取防护措施或选用带有钢丝的保护绳；', NULL, NULL, 17, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (162, '不得超限作业，必要时设置两道保护；', NULL, NULL, 17, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (163, '高空营救轻生者、精神病患者、醉酒者、攻击性动物时，要保持一定距离，设法消除潜在风险。', NULL, NULL, 17, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (164, '绝不允许穿着灭火防护服执行水域救援任务。', NULL, NULL, 18, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (165, '绝不允许无证驾驶消防舟艇和潜水作业。', NULL, NULL, 18, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (166, '绝不允许水域情况不明盲目下水救援。', NULL, NULL, 18, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (167, '绝不允许穿着非水域专用救援服下水救援。', NULL, NULL, 18, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (168, '绝不允许不会游泳的指战员在一线参与水域救援任务。', NULL, NULL, 18, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (169, '选派经过专业培训、精干且熟悉水性的人员进行施救，合理编组，加强协同配合。', NULL, NULL, 18, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (170, '设置紧急救助小组和预备力量，做好紧急救援准备和人员轮换。', NULL, NULL, 18, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (171, '上游设置观察员，现场设置安全员，掌握水情动态和救援人员状况。', NULL, NULL, 18, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (172, '舟艇舷外机的螺旋桨应采取保护罩进行防护，防止杂物缠绕失去动力。', NULL, NULL, 18, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (173, '落实避险措施。救助溺水人员，应从被困人员后侧靠近。', NULL, NULL, 18, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (174, '潜水作业时，必须佩戴潜水防护装具。', NULL, NULL, 18, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (175, '夜间视线不清、水情不明或水域复杂、水流湍急时，不得贸然下水救援；', NULL, NULL, 18, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (176, '进入深水区域，要选择安全的路线，避开旋涡、暗流、高水位落差、滚水坝或坑井沟渠以及漏电等危险区域。', NULL, NULL, 18, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (177, '舟艇编队前行。驾驶舟艇应控制速度、艇距，保持相应队形，严禁超载，抓紧船体。', NULL, NULL, 18, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (178, '当一舟艇失去动力，应快速安全靠近拖拉至安全区域，防止漂向危险区发生侧翻。', NULL, NULL, 18, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (179, '严密冰面救援。穿着干式水域救援防护服，落实防冻保暖和冰面破裂等防范措施。', NULL, NULL, 18, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (180, '冰面救援，优先使用冰面救援气垫船、橡皮艇、冰上浮板等专业救生装备。', NULL, NULL, 18, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (181, '冰面救援行动展开前应检测冰面厚度，视情采取在冰面铺设木板、消防梯等措施，增大受力面积；', NULL, NULL, 18, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (182, '冰面救援时，使用绳索进行保护，施救人员应设快速脱离装置，', NULL, NULL, 18, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (183, '冰面救援时，若条件允许应对施救者设置两条绳索进行保护，且两条绳索尽可能平行设置，防止施救者沉入冰层下方或被冰层卡住时的紧急救助。', NULL, NULL, 18, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (184, '加强专业指导。第一时间通知电梯维修部门，在专业技术人员的指导下，开展抢险救援作业。', NULL, NULL, 19, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (185, '设立警戒，禁止无关人员进入电梯间前室。', NULL, NULL, 19, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (186, '因机械故障造成停梯，应在顶层电梯控制室采取固定措施，防止轿厢坠落。', NULL, NULL, 19, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (187, '打开电梯门，要保持重心稳定，防止滑落，必要时采取保护措施。', NULL, NULL, 19, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (188, '不得盲目破拆，应首先确认轿厢位置，由专业人员实施轿厢升降至固定楼层。', NULL, NULL, 19, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (189, '优先使用专用钥匙开电梯门，必须破拆时，在专业人员配合下进行。', NULL, NULL, 19, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (190, '预防突然启动，因停电造成停梯，应安排专人守护电闸，确保电闸关闭状态，防止突然来电电梯动作引发事故。', NULL, NULL, 19, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (191, '严禁在梯井外探身到轿厢内操作，防止轿厢突然升降导致人员被夹。', NULL, NULL, 19, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (192, '判断倒塌风险。了解建筑结构形式、坍塌程度，有无装饰外挂墙、不稳定断檐，以及悬挂物体的稳定性，是否存在二次倒塌危险。', NULL, NULL, 21, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (193, '设置安全员，多角度实时监测建筑结构变化。', NULL, NULL, 21, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (194, '保持安全距离。与倒塌建筑外墙保持足够的安全距离，通常为建筑高度的1.5倍以上。', NULL, NULL, 21, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (195, '设置警戒，专人看护提示，禁止无关人员靠近。', NULL, NULL, 21, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (196, '在安全距离外设置人员集结点，不得在狭窄过道、不稳定物体下方行进或停留，不得进入明显松动的建筑内部。', NULL, NULL, 21, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (197, '消除潜在风险。对于不稳定构件可使用水枪扫射或人工清除，必要时采取加固支撑措施。', NULL, NULL, 21, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (198, '深入内部时，不得用水炮（枪）冲击墙体，不得破坏建筑承重构件，不得拖拉水带扰动不稳定构件，防止建筑失去稳定性。', NULL, NULL, 21, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (199, '注意紧急避险。设置观察哨，发现建筑倒塌征兆，立即发出预警信号，全体人员迅速撤离危险区域。', NULL, NULL, 21, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (200, '严格等级防护，内着棉质内衣，佩戴空气呼吸器、消防头盔、阻燃头套、手套等，皮肤不得外露。', NULL, NULL, 22, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (201, '加强侦察检测，侦察检测泄漏危险性，有无爆炸可能。', NULL, NULL, 22, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (202, '必要时，在燃气部门技术人员指导下，关闭户外燃气阀门。', NULL, NULL, 22, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (203, '减少一线人员。挑选精干力量，实施编组作业，加强协同配合，严格控制作业人员，尤其泄漏居民门口人员不得过于集中，便于紧急避险。', NULL, NULL, 22, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (204, '采取抑爆措施。远端切断电源，或保持泄漏区域电源原有状态，禁绝一切火源，落实防静电措施；', NULL, NULL, 22, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (205, '采取破拆玻璃窗户通风排气、射水稀释抑爆等措施；', NULL, NULL, 22, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (206, '破拆进户门时，应使用无火花工具，并在喷雾射流掩护下进行。', NULL, NULL, 22, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (207, '防止爆炸伤人。疏散泄漏区域和扩散可能波及范围的无关人员；', NULL, NULL, 22, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (208, '低姿掩护前行，避开门、窗正面泄压口；开门时，要使用限位器，防止门反弹伤人。', NULL, NULL, 22, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (209, '加强与气象、交通等部门的研判会商，及时准确掌握台风强度或路径，提前预置救援力量。', NULL, NULL, 25, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (210, '避开台风袭击。台风登陆或经过时，不得贸然外出，躲避台风袭击，避免造成伤害。', NULL, NULL, 25, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (211, '加强协同配合。与交通、路政、电力等部门密切配合，了解交通路况信息，调集大型工程机械，及时清除道路障碍，必要时实施断电措施。', NULL, NULL, 25, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (212, '注意隐患风险。远离不稳定建（构）筑物和树木，避开空中、地面障碍物，预防电线断落触电和水域孔洞坠落。', NULL, NULL, 25, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (213, '做好安全防护。高空作业时要使用安全绳进行保护，进入建（构）筑物要确保无再次垮塌的危险。', NULL, NULL, 25, NULL, NULL, NULL);
INSERT INTO `knowledge` VALUES (214, '存在高空物体坠落风险要及时采取清除或加固措施。', NULL, NULL, 25, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for label4
-- ----------------------------
DROP TABLE IF EXISTS `label4`;
CREATE TABLE `label4`  (
  `labelID` int(2) NOT NULL AUTO_INCREMENT,
  `labelname` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`labelID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture`  (
  `picID` int(10) NOT NULL AUTO_INCREMENT,
  `position` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `picture` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`picID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for QRTZ_BLOB_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_BLOB_TRIGGERS`;
CREATE TABLE `QRTZ_BLOB_TRIGGERS`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'QRTZ_TRIGGERS表trigger_name的外键',
  `trigger_group` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'QRTZ_TRIGGERS表trigger_group的外键',
  `blob_data` blob NULL COMMENT '存放持久化Trigger对象',
  PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`) USING BTREE,
  CONSTRAINT `QRTZ_BLOB_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `QRTZ_TRIGGERS` (`sched_name`, `trigger_name`, `trigger_group`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'Blob类型的触发器表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for QRTZ_CALENDARS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_CALENDARS`;
CREATE TABLE `QRTZ_CALENDARS`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '调度名称',
  `calendar_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '日历名称',
  `calendar` blob NOT NULL COMMENT '存放持久化calendar对象',
  PRIMARY KEY (`sched_name`, `calendar_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '日历信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for QRTZ_CRON_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_CRON_TRIGGERS`;
CREATE TABLE `QRTZ_CRON_TRIGGERS`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'QRTZ_TRIGGERS表trigger_name的外键',
  `trigger_group` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'QRTZ_TRIGGERS表trigger_group的外键',
  `cron_expression` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'cron表达式',
  `time_zone_id` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '时区',
  PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`) USING BTREE,
  CONSTRAINT `QRTZ_CRON_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `QRTZ_TRIGGERS` (`sched_name`, `trigger_name`, `trigger_group`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'Cron类型的触发器表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of QRTZ_CRON_TRIGGERS
-- ----------------------------
INSERT INTO `QRTZ_CRON_TRIGGERS` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME1', 'DEFAULT', '0/10 * * * * ?', 'Asia/Shanghai');
INSERT INTO `QRTZ_CRON_TRIGGERS` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME2', 'DEFAULT', '0/15 * * * * ?', 'Asia/Shanghai');
INSERT INTO `QRTZ_CRON_TRIGGERS` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME3', 'DEFAULT', '0/20 * * * * ?', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for QRTZ_FIRED_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_FIRED_TRIGGERS`;
CREATE TABLE `QRTZ_FIRED_TRIGGERS`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '调度名称',
  `entry_id` varchar(95) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '调度器实例id',
  `trigger_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'QRTZ_TRIGGERS表trigger_name的外键',
  `trigger_group` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'QRTZ_TRIGGERS表trigger_group的外键',
  `instance_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '调度器实例名',
  `fired_time` bigint(13) NOT NULL COMMENT '触发的时间',
  `sched_time` bigint(13) NOT NULL COMMENT '定时器制定的时间',
  `priority` int(11) NOT NULL COMMENT '优先级',
  `state` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '状态',
  `job_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '任务名称',
  `job_group` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '任务组名',
  `is_nonconcurrent` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '是否并发',
  `requests_recovery` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '是否接受恢复执行',
  PRIMARY KEY (`sched_name`, `entry_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '已触发的触发器表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for QRTZ_JOB_DETAILS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_JOB_DETAILS`;
CREATE TABLE `QRTZ_JOB_DETAILS`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '调度名称',
  `job_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '任务名称',
  `job_group` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '任务组名',
  `description` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '相关介绍',
  `job_class_name` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '执行任务类名称',
  `is_durable` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '是否持久化',
  `is_nonconcurrent` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '是否并发',
  `is_update_data` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '是否更新数据',
  `requests_recovery` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '是否接受恢复执行',
  `job_data` blob NULL COMMENT '存放持久化job对象',
  PRIMARY KEY (`sched_name`, `job_name`, `job_group`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '任务详细信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of QRTZ_JOB_DETAILS
-- ----------------------------
INSERT INTO `QRTZ_JOB_DETAILS` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME1', 'DEFAULT', NULL, 'com.ruoyi.quartz.util.QuartzDisallowConcurrentExecution', '0', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000F5441534B5F50524F504552544945537372001E636F6D2E72756F79692E71756172747A2E646F6D61696E2E5379734A6F6200000000000000010200084C000A636F6E63757272656E747400124C6A6176612F6C616E672F537472696E673B4C000E63726F6E45787072657373696F6E71007E00094C000C696E766F6B6554617267657471007E00094C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000D6D697366697265506F6C69637971007E00094C000673746174757371007E000978720027636F6D2E72756F79692E636F6D6D6F6E2E636F72652E646F6D61696E2E42617365456E7469747900000000000000010200074C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C0006706172616D7371007E00034C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000184BCB1E91878707400007070707400013174000E302F3130202A202A202A202A203F74001172795461736B2E72794E6F506172616D7374000744454641554C547372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000000000000001740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E697A0E58F82EFBC8974000133740001317800);
INSERT INTO `QRTZ_JOB_DETAILS` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME2', 'DEFAULT', NULL, 'com.ruoyi.quartz.util.QuartzDisallowConcurrentExecution', '0', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000F5441534B5F50524F504552544945537372001E636F6D2E72756F79692E71756172747A2E646F6D61696E2E5379734A6F6200000000000000010200084C000A636F6E63757272656E747400124C6A6176612F6C616E672F537472696E673B4C000E63726F6E45787072657373696F6E71007E00094C000C696E766F6B6554617267657471007E00094C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000D6D697366697265506F6C69637971007E00094C000673746174757371007E000978720027636F6D2E72756F79692E636F6D6D6F6E2E636F72652E646F6D61696E2E42617365456E7469747900000000000000010200074C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C0006706172616D7371007E00034C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000184BCB1E91878707400007070707400013174000E302F3135202A202A202A202A203F74001572795461736B2E7279506172616D7328277279272974000744454641554C547372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000000000000002740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E69C89E58F82EFBC8974000133740001317800);
INSERT INTO `QRTZ_JOB_DETAILS` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME3', 'DEFAULT', NULL, 'com.ruoyi.quartz.util.QuartzDisallowConcurrentExecution', '0', '1', '0', '0', 0xACED0005737200156F72672E71756172747A2E4A6F62446174614D61709FB083E8BFA9B0CB020000787200266F72672E71756172747A2E7574696C732E537472696E674B65794469727479466C61674D61708208E8C3FBC55D280200015A0013616C6C6F77735472616E7369656E74446174617872001D6F72672E71756172747A2E7574696C732E4469727479466C61674D617013E62EAD28760ACE0200025A000564697274794C00036D617074000F4C6A6176612F7574696C2F4D61703B787001737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C7708000000100000000174000F5441534B5F50524F504552544945537372001E636F6D2E72756F79692E71756172747A2E646F6D61696E2E5379734A6F6200000000000000010200084C000A636F6E63757272656E747400124C6A6176612F6C616E672F537472696E673B4C000E63726F6E45787072657373696F6E71007E00094C000C696E766F6B6554617267657471007E00094C00086A6F6247726F757071007E00094C00056A6F6249647400104C6A6176612F6C616E672F4C6F6E673B4C00076A6F624E616D6571007E00094C000D6D697366697265506F6C69637971007E00094C000673746174757371007E000978720027636F6D2E72756F79692E636F6D6D6F6E2E636F72652E646F6D61696E2E42617365456E7469747900000000000000010200074C0008637265617465427971007E00094C000A63726561746554696D657400104C6A6176612F7574696C2F446174653B4C0006706172616D7371007E00034C000672656D61726B71007E00094C000B73656172636856616C756571007E00094C0008757064617465427971007E00094C000A75706461746554696D6571007E000C787074000561646D696E7372000E6A6176612E7574696C2E44617465686A81014B5974190300007870770800000184BCB1E91878707400007070707400013174000E302F3230202A202A202A202A203F74003872795461736B2E72794D756C7469706C65506172616D7328277279272C20747275652C20323030304C2C203331362E3530442C203130302974000744454641554C547372000E6A6176612E6C616E672E4C6F6E673B8BE490CC8F23DF0200014A000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B02000078700000000000000003740018E7B3BBE7BB9FE9BB98E8AEA4EFBC88E5A49AE58F82EFBC8974000133740001317800);

-- ----------------------------
-- Table structure for QRTZ_LOCKS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_LOCKS`;
CREATE TABLE `QRTZ_LOCKS`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '调度名称',
  `lock_name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '悲观锁名称',
  PRIMARY KEY (`sched_name`, `lock_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '存储的悲观锁信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of QRTZ_LOCKS
-- ----------------------------
INSERT INTO `QRTZ_LOCKS` VALUES ('RuoyiScheduler', 'STATE_ACCESS');
INSERT INTO `QRTZ_LOCKS` VALUES ('RuoyiScheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for QRTZ_PAUSED_TRIGGER_GRPS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_PAUSED_TRIGGER_GRPS`;
CREATE TABLE `QRTZ_PAUSED_TRIGGER_GRPS`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '调度名称',
  `trigger_group` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'QRTZ_TRIGGERS表trigger_group的外键',
  PRIMARY KEY (`sched_name`, `trigger_group`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '暂停的触发器表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for QRTZ_SCHEDULER_STATE
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_SCHEDULER_STATE`;
CREATE TABLE `QRTZ_SCHEDULER_STATE`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '调度名称',
  `instance_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '实例名称',
  `last_checkin_time` bigint(13) NOT NULL COMMENT '上次检查时间',
  `checkin_interval` bigint(13) NOT NULL COMMENT '检查间隔时间',
  PRIMARY KEY (`sched_name`, `instance_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '调度器状态表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of QRTZ_SCHEDULER_STATE
-- ----------------------------
INSERT INTO `QRTZ_SCHEDULER_STATE` VALUES ('RuoyiScheduler', 'DESKTOP-HPSUFGG1671692402399', 1671692524663, 15000);

-- ----------------------------
-- Table structure for QRTZ_SIMPLE_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_SIMPLE_TRIGGERS`;
CREATE TABLE `QRTZ_SIMPLE_TRIGGERS`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'QRTZ_TRIGGERS表trigger_name的外键',
  `trigger_group` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'QRTZ_TRIGGERS表trigger_group的外键',
  `repeat_count` bigint(7) NOT NULL COMMENT '重复的次数统计',
  `repeat_interval` bigint(12) NOT NULL COMMENT '重复的间隔时间',
  `times_triggered` bigint(10) NOT NULL COMMENT '已经触发的次数',
  PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`) USING BTREE,
  CONSTRAINT `QRTZ_SIMPLE_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `QRTZ_TRIGGERS` (`sched_name`, `trigger_name`, `trigger_group`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '简单触发器的信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for QRTZ_SIMPROP_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_SIMPROP_TRIGGERS`;
CREATE TABLE `QRTZ_SIMPROP_TRIGGERS`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'QRTZ_TRIGGERS表trigger_name的外键',
  `trigger_group` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'QRTZ_TRIGGERS表trigger_group的外键',
  `str_prop_1` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'String类型的trigger的第一个参数',
  `str_prop_2` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'String类型的trigger的第二个参数',
  `str_prop_3` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'String类型的trigger的第三个参数',
  `int_prop_1` int(11) NULL DEFAULT NULL COMMENT 'int类型的trigger的第一个参数',
  `int_prop_2` int(11) NULL DEFAULT NULL COMMENT 'int类型的trigger的第二个参数',
  `long_prop_1` bigint(20) NULL DEFAULT NULL COMMENT 'long类型的trigger的第一个参数',
  `long_prop_2` bigint(20) NULL DEFAULT NULL COMMENT 'long类型的trigger的第二个参数',
  `dec_prop_1` decimal(13, 4) NULL DEFAULT NULL COMMENT 'decimal类型的trigger的第一个参数',
  `dec_prop_2` decimal(13, 4) NULL DEFAULT NULL COMMENT 'decimal类型的trigger的第二个参数',
  `bool_prop_1` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'Boolean类型的trigger的第一个参数',
  `bool_prop_2` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'Boolean类型的trigger的第二个参数',
  PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`) USING BTREE,
  CONSTRAINT `QRTZ_SIMPROP_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `QRTZ_TRIGGERS` (`sched_name`, `trigger_name`, `trigger_group`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '同步机制的行锁表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for QRTZ_TRIGGERS
-- ----------------------------
DROP TABLE IF EXISTS `QRTZ_TRIGGERS`;
CREATE TABLE `QRTZ_TRIGGERS`  (
  `sched_name` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '调度名称',
  `trigger_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '触发器的名字',
  `trigger_group` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '触发器所属组的名字',
  `job_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'QRTZ_JOB_DETAILS表job_name的外键',
  `job_group` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'QRTZ_JOB_DETAILS表job_group的外键',
  `description` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '相关介绍',
  `next_fire_time` bigint(13) NULL DEFAULT NULL COMMENT '上一次触发时间（毫秒）',
  `prev_fire_time` bigint(13) NULL DEFAULT NULL COMMENT '下一次触发时间（默认为-1表示不触发）',
  `priority` int(11) NULL DEFAULT NULL COMMENT '优先级',
  `trigger_state` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '触发器状态',
  `trigger_type` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '触发器的类型',
  `start_time` bigint(13) NOT NULL COMMENT '开始时间',
  `end_time` bigint(13) NULL DEFAULT NULL COMMENT '结束时间',
  `calendar_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '日程表名称',
  `misfire_instr` smallint(2) NULL DEFAULT NULL COMMENT '补偿执行的策略',
  `job_data` blob NULL COMMENT '存放持久化job对象',
  PRIMARY KEY (`sched_name`, `trigger_name`, `trigger_group`) USING BTREE,
  INDEX `sched_name`(`sched_name`, `job_name`, `job_group`) USING BTREE,
  CONSTRAINT `QRTZ_TRIGGERS_ibfk_1` FOREIGN KEY (`sched_name`, `job_name`, `job_group`) REFERENCES `QRTZ_JOB_DETAILS` (`sched_name`, `job_name`, `job_group`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '触发器详细信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of QRTZ_TRIGGERS
-- ----------------------------
INSERT INTO `QRTZ_TRIGGERS` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME1', 'DEFAULT', 'TASK_CLASS_NAME1', 'DEFAULT', NULL, 1671692410000, -1, 5, 'PAUSED', 'CRON', 1671692402000, 0, NULL, 2, '');
INSERT INTO `QRTZ_TRIGGERS` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME2', 'DEFAULT', 'TASK_CLASS_NAME2', 'DEFAULT', NULL, 1671692415000, -1, 5, 'PAUSED', 'CRON', 1671692402000, 0, NULL, 2, '');
INSERT INTO `QRTZ_TRIGGERS` VALUES ('RuoyiScheduler', 'TASK_CLASS_NAME3', 'DEFAULT', 'TASK_CLASS_NAME3', 'DEFAULT', NULL, 1671692420000, -1, 5, 'PAUSED', 'CRON', 1671692402000, 0, NULL, 2, '');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `cautionID` int(100) NOT NULL AUTO_INCREMENT,
  `cautiontime` datetime(0) NULL DEFAULT NULL,
  `location` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `distypeID` int(2) NULL DEFAULT NULL,
  `dillobject` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `siteID` int(2) NULL DEFAULT NULL,
  `truckID` int(255) NULL DEFAULT NULL,
  `supplement` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `boom` tinyint(1) NULL DEFAULT NULL,
  `poison` tinyint(1) NULL DEFAULT NULL,
  `picture` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` tinyint(1) NULL DEFAULT NULL,
  `detailtype` int(2) NULL DEFAULT NULL,
  `label4` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `keywords` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cautionID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES (2, '2022-12-22 14:33:08', '宝山区大场镇', 1, '1', 1, 1, NULL, 1, 1, '1', 0, 1, NULL, '加油');
INSERT INTO `record` VALUES (3, '2022-12-07 00:00:00', '顾村镇', 1, NULL, 1, NULL, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `record` VALUES (4, '2022-12-08 00:00:00', '顾村镇', 2, '3', 2, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for rule
-- ----------------------------
DROP TABLE IF EXISTS `rule`;
CREATE TABLE `rule`  (
  `ruleID` int(2) NOT NULL AUTO_INCREMENT,
  `generalnum` int(2) NULL DEFAULT NULL,
  `securitynum` int(2) NULL DEFAULT NULL,
  `specialnum` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`ruleID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rule
-- ----------------------------
INSERT INTO `rule` VALUES (1, 3, 2, 0);
INSERT INTO `rule` VALUES (2, 0, 0, 5);

-- ----------------------------
-- Table structure for security
-- ----------------------------
DROP TABLE IF EXISTS `security`;
CREATE TABLE `security`  (
  `informID` int(2) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `inform` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `securitypeID` int(2) NULL DEFAULT NULL COMMENT '与detailtype的typeid对应',
  PRIMARY KEY (`informID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 369 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of security
-- ----------------------------
INSERT INTO `security` VALUES (01, '参加灭火战斗时，应根据火场危害程度，严格按照防护等级要求采取防护措施。', 27);
INSERT INTO `security` VALUES (02, '进入高温、热辐射强和有爆炸危险区域时，必须着隔热服、避火服或防爆服，佩戴防高温手套，视情着降温背心。', 27);
INSERT INTO `security` VALUES (03, '进入现场的摄像员、宣传员、通信员、单位技术人员等，必须按照相关要求进行等级防护，编组管理，严禁单独作业。', 27);
INSERT INTO `security` VALUES (04, '消防员在特殊环境作战时，应采取针对性防护措施。', 27);
INSERT INTO `security` VALUES (05, '进入高温、浓烟、有毒、缺氧区域、封闭空间时，必须佩戴空（氧）气呼吸器或移动供气源，严禁使用过滤式防护装具。', 27);
INSERT INTO `security` VALUES (06, '开放式有毒区域可使用强制送风呼吸器、消防过滤式综合防毒面具。', 27);
INSERT INTO `security` VALUES (07, '高温场所作业时，可出水冷却，或打湿消防员防护服增强防护效果。', 27);
INSERT INTO `security` VALUES (08, '高强度作业时，定时组织战斗人员轮换休息，轮换休息和更换空气呼吸器钢瓶必须在安全区域进行。', 27);
INSERT INTO `security` VALUES (09, '重大灾害事故处置时或事后，及时安排专业人员进行心理干预。', 27);
INSERT INTO `security` VALUES (10, '个人防护装备的穿戴必须要严格遵守操作规程和相关标准，确保防护效果。', 27);
INSERT INTO `security` VALUES (11, '脱卸防化服前要彻底洗消，脱卸过程中不得直接接触防化服外表面。', 27);
INSERT INTO `security` VALUES (12, '现场警戒必须根据灾害类别、特点、规模范围，科学确定警戒区域，划定警戒范围和区域分割，严禁无关人员和车辆进入。', 27);
INSERT INTO `security` VALUES (13, '在道路进行灭火救援时，打开警灯警报，封闭作业区域。', 27);
INSERT INTO `security` VALUES (14, '一般道路警戒距离不少于200米。', 27);
INSERT INTO `security` VALUES (15, '高速公路，在救援区域前、后方500米处设置发光或反光的警戒和事故警示标志，并在200米处设置第二道警戒。', 27);
INSERT INTO `security` VALUES (16, '高速公路救援，遇有雨、雪、雾等天气或夜间，警戒距离均应扩大一倍。', 27);
INSERT INTO `security` VALUES (17, '侦察小组不少于３人，由指挥员带领，严禁单独行动，视情有单位知情人引导，灾情侦察应贯穿于作战行动全过程。', 27);
INSERT INTO `security` VALUES (18, '进入浓烟、高温、有毒等危险区域侦察时，要选择侦察路线，确定撤离方式，明确联络信号，必须使用水枪进行掩护。', 27);
INSERT INTO `security` VALUES (19, '进入建筑物内部侦察时，应当对建筑结构强度进行评估，靠近承重结构行动，行进时必须前虚后实，探步前进。', 27);
INSERT INTO `security` VALUES (20, '进入密闭区域侦察时，应当测试门窗温度，判别轰然风险，在侧面缓慢开启门、窗，同时采取限位措施，并视情向门、窗内射水，防止发生轰然伤人。', 27);
INSERT INTO `security` VALUES (21, '侦察线路长、转弯多时，应设中间保护点，中间保护点不宜过多，每个保护点不应少于2人。', 27);
INSERT INTO `security` VALUES (22, '进入有发生爆炸、中毒危险区域侦察时，选择精干人员，并严格控制人数。', 27);
INSERT INTO `security` VALUES (23, '分水器、水枪阵地应当设置在便于观察、便于进攻、便于转移或者撤离，且相对安全的位置。', 27);
INSERT INTO `security` VALUES (24, '利用地形、地物，依托防火墙、防火门、窗和承重构件等设置水枪（炮）阵地。', 27);
INSERT INTO `security` VALUES (25, '利用拉梯在窗口、阳台设置阵地时，角度不得过陡，确保拉梯接触点的稳定性。', 27);
INSERT INTO `security` VALUES (26, '严禁在轻质屋顶、墙头、遮阳棚、雨棚、可燃油气罐上部、卧式储罐的两端等结构不牢、风险较大的位置设置水枪阵地。', 27);
INSERT INTO `security` VALUES (27, '压缩气体钢瓶或者油桶库房着火，必须在充分冷却，确认无爆炸危险后，方能深入内部设置水枪阵地。', 27);
INSERT INTO `security` VALUES (28, '楼层进攻时，分水器阵地通常设置在主入口处，燃烧层高于6层的一般设置在下一层或下两层楼梯间。', 27);
INSERT INTO `security` VALUES (29, '地面进攻时，分水器阵地通常设置在火势蔓延方向的下风、侧下风室外，保持足够的安全距离。', 27);
INSERT INTO `security` VALUES (30, '分水器后干线水带垂直铺设时，应对分水器进行固定。', 27);
INSERT INTO `security` VALUES (31, '高层垂直供水或大面积灾害事故现场，应在地面适当位置设置两道分水器，便于泄压和转移供水阵地。', 27);
INSERT INTO `security` VALUES (32, '作战进攻时，必须选择正确的喷射器材、药剂、进攻路线及射水（射流）方式。', 27);
INSERT INTO `security` VALUES (33, '灭火时应当采用正确射水姿势，开、关水枪（分水器）动作要缓慢，避免水锤作用，严禁对射误伤他人。', 27);
INSERT INTO `security` VALUES (34, '扑救木质楼板、吊顶的建筑物火灾时，确认没有塌落危险后，保持前虚后实探步前进的方式进入室内救人、灭火。', 27);
INSERT INTO `security` VALUES (35, '必须带电灭火时，应当按照带电灭火的要求，若使用直流水灭火时应当采用点射方式，保持水枪有效接地。', 27);
INSERT INTO `security` VALUES (36, '进入危险化学品泄漏区域侦察前，必须设置洗消区，并在安全区域预留同等级防护的后备小组，随时做好救援准备。', 27);
INSERT INTO `security` VALUES (37, '利用拉梯在窗口、阳台设置阵地时，要避开喷火冒烟的阳台、窗口正面，拉梯上端必须高出窗口、阳台2个以上梯蹬，梯上最多不得超过2人，并采取固定措施。', 27);
INSERT INTO `security` VALUES (38, '大跨度钢架结构厂房、库房着火，必须在确认无倒塌风险或实施结构冷却后，方能深入内部设置水枪阵地。', 27);
INSERT INTO `security` VALUES (39, '大跨度钢架结构厂房、库房着火，在外部设置阵地时，应采取措施或保持足够的安全距离，严防建筑外墙倒塌伤人。', 27);
INSERT INTO `security` VALUES (40, '货（油）轮的货（油）舱起火，情况不明、温度较高的情况下，应保持一定的安全距离，严禁直接登至货（油）舱甲板灭火。', 27);
INSERT INTO `security` VALUES (41, '转移阵地或调整作战力量时，必须考虑整个作战部署的协调统一，防止因局部力量调整，影响其他作战阵地安全。', 27);
INSERT INTO `security` VALUES (42, '每次转移阵地或调整作战力量时必须立即检查清点人员，并做好防护工作。', 27);
INSERT INTO `security` VALUES (43, '水枪后应留有10米左右的机动水带，水枪手位于两侧站立，身高矮的在前，以便战斗员及时发现异常、快速移动位置躲避风险。', 27);
INSERT INTO `security` VALUES (44, '水枪手后方不得站人或拥挤，便于快速撤离。', 27);
INSERT INTO `security` VALUES (45, '扑救可燃气体、挥发性易燃液体火灾时，不得盲目灭火，灭火后，要防止复燃、复爆。扑救重质油品火灾时，严防沸溢喷溅伤人。', 27);
INSERT INTO `security` VALUES (46, '扑救高温、高压容器设备火灾，或大跨度钢架结构厂房、库房火灾，以及长时间燃烧的建筑火灾时，必须减少前方作战人员。', 27);
INSERT INTO `security` VALUES (47, '优先使用带架水枪、移动炮、遥控水炮等远射程、大流量喷射器实施冷却、阻击、灭火，避免人员近距离作战。', 27);
INSERT INTO `security` VALUES (48, '严禁用水或泡沫扑救遇湿易燃、易爆物质火灾。', 27);
INSERT INTO `security` VALUES (49, '严禁使用直流水扑救可燃粉尘、强腐蚀性物质火灾，或冲击炼铁炉内钢水等超高温物质，防止引发爆炸或火势蔓延扩大。', 27);
INSERT INTO `security` VALUES (50, '采用窒息法灭火时，必须确认灌注、封堵空间人员已全部撤离。', 27);
INSERT INTO `security` VALUES (51, '在进入室内等场所灭火进攻时，应预先熟悉撤退路线，进入时在门、窗一侧低姿缓慢开启门窗，或采取限位措施。', 27);
INSERT INTO `security` VALUES (52, '边射水边开启门窗，防止门、窗开启瞬间发生轰燃、回燃、爆燃伤人，高层建筑还应防止穿堂风挟烟火伤人。', 27);
INSERT INTO `security` VALUES (53, '进入猛烈燃烧的室内，应注意射流方式和站立位置，防止热烟气反扑伤人，可在门口向顶部射水后退出关门。', 27);
INSERT INTO `security` VALUES (54, '在存有倒塌危险的区域进行灭火进攻时，不得用直流水枪、水炮冲击柱、梁、墙等承重构建。', 27);
INSERT INTO `security` VALUES (55, '室内大量射水时，应注意排水，防止过载倒塌。', 27);
INSERT INTO `security` VALUES (56, '掩护时一般使用喷雾射流，与保护目标保持3-5米的有效距离。', 27);
INSERT INTO `security` VALUES (57, '屋顶行进时，应沿梁、卯等处行走，坡面较大或结冰湿滑时，利用安全绳保护，做好防滑措施。', 27);
INSERT INTO `security` VALUES (58, '进入可燃有毒气体泄漏区域时，应从上风方向进入，必须使用喷雾水，或屏风水枪、水幕水带等出水掩护。', 27);
INSERT INTO `security` VALUES (59, '利用消防梯登高开辟外攻路线时，应落实专人保护，必要时应借助梯首设立安全绳保护支点。', 27);
INSERT INTO `security` VALUES (60, '内攻人员完成既定作战任务后必须立即撤出，不得随意改变作战行动。', 27);
INSERT INTO `security` VALUES (61, '救援人员编组不得少于3人，并指定一名负责人。', 27);
INSERT INTO `security` VALUES (62, '在进入浓烟、高温或者有毒区域搜救人员时，要在水枪冷却掩护或者驱散稀释措施的配合下行动。', 27);
INSERT INTO `security` VALUES (63, '救援人员要携带救生担架、一次性防毒面具或其他呼吸保护器具，用于救助和保护被困人员。', 27);
INSERT INTO `security` VALUES (64, '应全程注重排烟降毒，现场浓烟、有毒、易燃气体集聚，有迷失、窒息、中毒、爆炸危险时，应首先开展排烟降毒。', 27);
INSERT INTO `security` VALUES (65, '排烟降毒时，必须充分考虑烟雾、气体流向，合理选择进风口、排烟口和驱散方向。', 27);
INSERT INTO `security` VALUES (66, '排烟降毒，操作人员应充分做好个人防护，视情设置水枪进行掩护。', 27);
INSERT INTO `security` VALUES (67, '有毒烟气必须向下（侧）风方向排放，并提前疏散可能受到烟雾威胁的人员。', 27);
INSERT INTO `security` VALUES (68, '排烟路径或排烟口不得危及作战阵地，参战人员不得随意穿越或靠近。', 27);
INSERT INTO `security` VALUES (69, '要时刻管控或掌握泄漏物资流向、泄漏范围，防止有毒、易燃等物资扩散、流入下水道或其他危险区域。', 27);
INSERT INTO `security` VALUES (70, '在开展作战行动前，要明确紧急撤离的信号、撤离路线，并在安全区域选择集合地点，发现险情，应立即发布撤离信号，组织撤离行动。', 27);
INSERT INTO `security` VALUES (71, '指挥员和安全员必须密切观察现场情况，发现险情或接到险情报告及时发出撤离信号。', 27);
INSERT INTO `security` VALUES (72, '明确撤离要求，特别紧急情况下，应当放弃车辆和器材徒手快速撤离。', 27);
INSERT INTO `security` VALUES (73, '遇爆炸等危险征兆来不及撤离时应就近卧倒，头向外、脸向下，匍匐撤离或依托掩体避险。', 27);
INSERT INTO `security` VALUES (74, '在高层建筑等复杂场所作业时，分层分区设置人员接应点，确保人员快速有序撤离。', 27);
INSERT INTO `security` VALUES (75, '发出紧急撤离信号后，中队指挥员要立即在集合地点清点人员，并向指挥部报告，研究新的对策措施。', 27);
INSERT INTO `security` VALUES (76, '清理现场时，必须克服麻痹思想，有毒有害烟气、物质未彻底清除前，不得脱卸个人防护装备，防止发生意外伤害。', 27);
INSERT INTO `security` VALUES (77, '现场清理时减少内部人员，并注重时效性，加快进程，最大限度避免风险。', 27);
INSERT INTO `security` VALUES (78, '必须注意观察建筑物上方建筑构件和高空坠落物，观察砖墙、楼板和钢筋已经裸露的水泥柱的稳定性，防止发生垮塌伤害事故。', 27);
INSERT INTO `security` VALUES (79, '检查楼梯间、走道、外墙处烧损电线的带电情况，防止发生触电伤害事故，必要时切断进户线路。', 27);
INSERT INTO `security` VALUES (80, '检查煤气管道、液化气瓶的泄漏情况，防止发生爆燃伤人事故。', 27);
INSERT INTO `security` VALUES (81, '检查危险化学物品泄漏情况，防止发生复燃、爆炸、中毒、腐蚀伤害事故。', 27);
INSERT INTO `security` VALUES (82, '高温容器、罐体应持续冷却直至常温，未充分冷却前，不得搬运、移动。', 27);
INSERT INTO `security` VALUES (83, '避免在泡沫覆盖区域行走奔跑，防止复燃。灭火后仍存大量易燃液体时，应输转妥处。', 27);
INSERT INTO `security` VALUES (84, '收整器材时，严禁强行拖拽，禁止从高处抛掷。', 27);
INSERT INTO `security` VALUES (85, '撤离现场时，必须清点人员和器材。', 27);
INSERT INTO `security` VALUES (86, '处置危险化学品灾害事故，或有燃气泄漏的灾害现场，应严防爆炸伤人。', 27);
INSERT INTO `security` VALUES (87, '靠近可燃物泄漏且未起火的现场，应注意观察和侦检，不得盲目选择行车路线，防止驾车误入泄漏区域。', 27);
INSERT INTO `security` VALUES (88, '进入有爆炸危险的区域应穿着防静电内衣，根据需要穿着特级或一级化学防护服，尽量从上风方向实施作战行动。', 27);
INSERT INTO `security` VALUES (89, '进入有爆炸危险的场所，应尽可能保持低姿状态，依托堤坝、土坡、坑凹、承重墙、墙角、柱及大型物件等地形、地物作为掩护。', 27);
INSERT INTO `security` VALUES (90, '作战中，应利用测爆仪等仪器持续检测，可燃气体浓度接近爆炸下限且不能完全禁绝火源的，必须立即撤离。', 27);
INSERT INTO `security` VALUES (91, '对于易燃易爆气体火灾，在无法关闭阀门和堵漏的情况下，严禁盲目扑灭火焰，严防泄漏气体与空气形成爆炸混合物，引发爆炸。', 27);
INSERT INTO `security` VALUES (92, '充满可燃气体、易燃液体蒸气的空间，可采取强力送风，驱散可燃气体和蒸气。', 27);
INSERT INTO `security` VALUES (93, '可燃气体、易燃液体蒸气泄漏和粉尘飞扬的区域，可利用雾状水稀释降尘，抑制爆炸或降低爆炸危险。', 27);
INSERT INTO `security` VALUES (94, '易燃液体泄漏流淌，可向流淌液体表面大量喷射泡沫，并保持泡沫厚度，阻止液体蒸发，并筑坝阻流或开槽引流，控制流淌蔓延范围。', 27);
INSERT INTO `security` VALUES (95, '可燃气体、易燃液体泄漏及粉尘扩散可能波及的区域，必需消除一切火种，切断电源，消除静电。', 27);
INSERT INTO `security` VALUES (96, '严禁使用非防爆器材，行动时要注意防止撞击产生火花。', 27);
INSERT INTO `security` VALUES (97, '严禁在可燃气体、易燃液体蒸气泄漏区域内的门窗正面泄压口，下水井、电缆井、煤气井等部位的上方及周围站立，以防爆炸造成伤亡。', 27);
INSERT INTO `security` VALUES (98, '避免在覆盖泡沫的流淌液体中走动，禁止跑动，防止破坏覆盖层加速液体蒸发。', 27);
INSERT INTO `security` VALUES (99, '粉尘沉积的场所严禁使用直流射流或奔跑，防止引起粉尘飞扬增加爆炸危险。', 27);
INSERT INTO `security` VALUES (100, '受火势威胁的装置、压力容器等，必须进行冷却保护。', 27);
INSERT INTO `security` VALUES (101, '在扑救锂电池火灾时，应在厂方技术人员指导下进行。', 27);
INSERT INTO `security` VALUES (102, '密切观察存有爆炸危险的现场情况，减少一线作业人员，保持足够安全距离，发现危险征兆应迅速撤离。', 27);
INSERT INTO `security` VALUES (103, '进入有烟气、固体粉尘、异味、有毒气体泄露等有毒有害场所、区域作业时，应严防中毒。', 27);
INSERT INTO `security` VALUES (104, '根据烟气、毒害品性质确定防护等级，严格等级防护措施，未采取防护措施的人员严禁进入危险区域。', 27);
INSERT INTO `security` VALUES (105, '防护必须在进入有毒区域前完成，严禁在有毒区域脱卸或更换防护装备。', 27);
INSERT INTO `security` VALUES (106, '尽可能从上风方向进入有毒区域，出水掩护或降毒的供水线路应不少于2路，且应来自不同的供水车辆。', 27);
INSERT INTO `security` VALUES (107, '进入有毒区域的人员必须精干，进入前应进行安全登记，编组进入，严格控制人数。', 27);
INSERT INTO `security` VALUES (108, '严禁在有毒区域进食、饮水，以及坐、躺休息，或从事其他与抢险救援无关的事项。', 27);
INSERT INTO `security` VALUES (109, '着火的有毒物质被扑灭后，毒性可能更强，必须持续做好个人防护。', 27);
INSERT INTO `security` VALUES (110, '空气呼吸器报警或遇特殊情况，作战小组全体人员必须立即撤离，严禁擅自降低防护等级，强行作业。', 27);
INSERT INTO `security` VALUES (111, '从有毒区域撤出的人员、器材装备，要及时进行洗消。在洗消前，严禁与未采取防护措施的人员接触。', 27);
INSERT INTO `security` VALUES (112, '指挥员、安全员应对进入有毒区域的人员实时监测，发现体力不支、精神状态下降等情况，应及时安排人员轮换。', 27);
INSERT INTO `security` VALUES (113, '在入口处应部署应急小组待命，随时做好人员紧急救助准备。', 27);
INSERT INTO `security` VALUES (114, '处置电器火灾，或进入着火建筑、倒塌区域时，应严防触电。', 27);
INSERT INTO `security` VALUES (115, '作业前应关闭作业区域电源开关，必要时可切断灾害区域入户电线。', 27);
INSERT INTO `security` VALUES (116, '在具有触电危险的现场，要利用漏电探测仪实施检测，并划定警戒区域。', 27);
INSERT INTO `security` VALUES (117, '进入可能存在漏电危险区域的人员要穿戴绝缘服、绝缘手套、绝缘胶靴，避免与带电体接触。', 27);
INSERT INTO `security` VALUES (118, '禁止站在架空电线下方，防止电线断落引发触电，要防止高温条件下电线绝缘层烧毁老化引发触电。', 27);
INSERT INTO `security` VALUES (119, '不得靠近电线断落的区域尤其是积水区域，误入带电区域应双脚并拢、或单脚跳离，防止产生跨步电压。', 27);
INSERT INTO `security` VALUES (120, '尽量使用二氧化碳、干粉等灭火器（剂）扑救电气火灾。', 27);
INSERT INTO `security` VALUES (121, '火势较大需用水扑救时，可用雾状射流或向火势上方或上风风向射水。', 27);
INSERT INTO `security` VALUES (122, '使用直流水灭火时应采用点射，并采取接地措施。', 27);
INSERT INTO `security` VALUES (123, '进入建筑内部前，用直流水对屋檐、屋顶等部位进行扫射，清除屋檐瓦片、屋顶构件坠落危险。', 27);
INSERT INTO `security` VALUES (124, '扑救钢结构建筑火灾时，要持续冷却钢梁和钢柱等承重结构，防止钢材在高温下强度减弱，造成坍塌。', 27);
INSERT INTO `security` VALUES (125, '扑救楼层火灾，楼层内积水较多时，应组织排水，必要时在确保建筑结构安全的情况下开凿孔洞进行排水，防止楼板承载过重造成坍塌。', 27);
INSERT INTO `security` VALUES (126, '破拆着火建筑屋顶，或采取其他排烟措施，实施排烟散热，防止建筑结构因高温强度下降倒塌。', 27);
INSERT INTO `security` VALUES (127, '根据救援需要对危险建筑结构采取加固措施，消除倒塌风险。', 27);
INSERT INTO `security` VALUES (128, '必要时对有倒塌风险的构件进行拆除，对有塌方风险的地方进行清除开挖主动排除倒塌风险。', 27);
INSERT INTO `security` VALUES (129, '要设置现场安全员，必要时邀请专家对危险建筑物或作业区域进行现场安全评估，发现倒塌征兆或存有倒塌风险时不得强行内攻。', 27);
INSERT INTO `security` VALUES (130, '内攻过程中发现有倒塌征兆、埋压风险的，应及时撤离，尽量使用移动炮、带架水枪，减少人员进入。', 27);
INSERT INTO `security` VALUES (131, '危险建筑保持足够的安全距离，不要在陈旧、烧损的屋檐及窗口下方架梯。', 27);
INSERT INTO `security` VALUES (132, '不得沿建筑底层墙边行走，必须与外墙保持足够距离，防止被高空坠物埋压砸伤。', 27);
INSERT INTO `security` VALUES (133, '对可能发生倒塌的区域或倒塌坠落物影响区域，要设置警戒，并安排专人负责看护提示，禁止人员靠近。', 27);
INSERT INTO `security` VALUES (134, '扑救堆垛火灾时，不得轻易登到燃烧堆垛顶部，严禁登上桶装物品堆垛上方，货架变形或受火势直接炙烤时，应保持足够安全距离。', 27);
INSERT INTO `security` VALUES (135, '在存倒塌、坍塌危险区域作业时，要寻找依托牢固掩体，预防埋压伤害。', 27);
INSERT INTO `security` VALUES (136, '登高射水时，不得快速加压，固定的绳索和水带要留用一定备用长度。', 27);
INSERT INTO `security` VALUES (137, '进入室内灭火时要使用直流水枪冲击地面，测试强度或探看坑洼部位。', 27);
INSERT INTO `security` VALUES (138, '夜间能见度低或在浓烟中行动时，按照前虚后实，探步前进，避开电梯井或回型楼梯等危险区域，防止坠落伤害。\r\n', 27);
INSERT INTO `security` VALUES (139, '参加抢险救援战斗时，应根据灾害事故性质和危险特性，按照防护等级佩戴相应特种防护装备。', 28);
INSERT INTO `security` VALUES (140, '进入危险化学品泄漏事故现场或有传染疾病危险的区域时，作业人员根据危险区域着相应等级防化服。', 28);
INSERT INTO `security` VALUES (141, '易燃易爆区域还应当着防静电服，防静电内衣、袜子和手套。', 28);
INSERT INTO `security` VALUES (142, '处置压缩、液化气体泄漏事故时，必须采取防冻措施。', 28);
INSERT INTO `security` VALUES (143, '进行水域救援时，必须着消防员专用救生衣，水下救援需佩戴潜水装具，严禁着消防防护服下水救援。', 28);
INSERT INTO `security` VALUES (144, '开展冰面救援时还应着干式水域救援服，并采取相关保暖措施。', 28);
INSERT INTO `security` VALUES (145, '摘取马蜂窝时，必须着防蜂服，并佩戴护目镜。', 28);
INSERT INTO `security` VALUES (146, '参与地震、地质、气象等自然灾害救援时，应配备护肘护膝、军刀、防尘口罩、毛巾、雨衣、个人急救包等装备。', 28);
INSERT INTO `security` VALUES (147, '进入有核放射危险区域时，必须着核沾染防护服等专业防护装具，佩戴个人辐射剂量仪，并在专业人员指导下开展救援行动。', 28);
INSERT INTO `security` VALUES (148, '开放式有毒区域也可使用强制送风呼吸器、消防过滤式综合防毒面具。', 28);
INSERT INTO `security` VALUES (149, '进入带电区域作战时，必须穿戴绝缘服、绝缘靴、绝缘手套等防护装备，携带漏电探测仪、绝缘胶垫、接地线（棒）等器材。', 28);
INSERT INTO `security` VALUES (150, '高空作业时，应穿戴救生吊带，携带安全绳，配备防坠落辅助设备。', 28);
INSERT INTO `security` VALUES (151, '强噪音环境，应配备使用保护耳塞、耳罩。', 28);
INSERT INTO `security` VALUES (152, '开展金属、混凝土、玻璃等物质破拆时，应佩戴护目镜及具备防割功能的手套等防护装备。', 28);
INSERT INTO `security` VALUES (153, '处置现场可能接触到人员、动物尸体或体液时，消防员还必须佩戴口罩、眼罩和医用手套，做好卫生防疫措施。', 28);
INSERT INTO `security` VALUES (154, '针对特别危险情形，可采取主动防范手段降低安全风险。', 28);
INSERT INTO `security` VALUES (155, '深井、地下等相对密闭空间救援时，使用正压式排烟机、送风机、备用气瓶等进行通风吹扫，降毒增氧。', 28);
INSERT INTO `security` VALUES (156, '对不牢固建筑或构件，采取主动拆除或支撑加固措施。', 28);
INSERT INTO `security` VALUES (157, '高强度作业时，定时组织战斗人员轮换休息，轮换休息和更换空气呼吸器钢瓶必须在安全区域进行。', 28);
INSERT INTO `security` VALUES (158, '现场警戒必须根据灾害类别、特点、规模范围，科学确定警戒区域，划定警戒范围和区域分割，严禁无关人员进入。', 28);
INSERT INTO `security` VALUES (159, '负责警戒人员要注意自身安全，选择安全处站立，发现异常及时报告或发出紧急撤离信号，并做好紧急避险准备。', 28);
INSERT INTO `security` VALUES (160, '在存建筑倒塌风险的事故现场，警戒区域半径不小于建筑物高度的1.5倍。', 28);
INSERT INTO `security` VALUES (161, '危险化学品泄漏现场警戒范围要根据泄漏物质、泄漏量、风向、风速等因素计算确定，并应划定重危区、轻危区、安全区。', 28);
INSERT INTO `security` VALUES (162, '进入有发生爆炸、中毒危险区域侦察时，选择精干人员，并严格控制人数。', 28);
INSERT INTO `security` VALUES (163, '进入危险化学品泄漏区域侦察前，必须设置洗消区，并在安全区域预留同等级防护的后备小组，随时做好救援准备。', 28);
INSERT INTO `security` VALUES (164, '应全程注重排烟降毒，现场浓烟、有毒、易燃气体集聚，有迷失、窒息、中毒、爆炸危险时，应首先开展排烟降毒。', 28);
INSERT INTO `security` VALUES (165, '脱卸防化服前要彻底洗消，脱卸过程中不得直接接触防化服外表面。', 28);
INSERT INTO `security` VALUES (166, '排烟降毒时，必须充分考虑烟雾、气体流向，合理选择进风口、排烟口和驱散方向。', 28);
INSERT INTO `security` VALUES (167, '操作人员应充分做好个人防护，视情设置水枪进行掩护。', 28);
INSERT INTO `security` VALUES (168, '有毒烟气必须向下（侧）风方向排放，并提前疏散可能受到烟雾威胁的人员。', 28);
INSERT INTO `security` VALUES (169, '排烟路径或排烟口不得危及作战阵地，参战人员不得随意穿越或靠近。', 28);
INSERT INTO `security` VALUES (170, '要时刻管控或掌握泄漏物资流向、泄漏范围，防止有毒、易燃等物资扩散、流入下水道或其他危险区域，造成污染或引发爆炸等次生灾害。', 28);
INSERT INTO `security` VALUES (171, '疏散物资必须在单位负责人或者技术人员的配合下有序进行，并对疏散出的物品指定专人看护。', 28);
INSERT INTO `security` VALUES (172, '科学确定疏散进出线路和疏散物资先后顺序，避免现场车辆、人员交织形成不安全因素。', 28);
INSERT INTO `security` VALUES (173, '疏散出来的物品必须检查是否夹带火种，是否安全稳定，搬运方法是否得当。', 28);
INSERT INTO `security` VALUES (174, '疏散易燃、易爆、腐蚀性物品时，应分类放置，划出警戒线，设置相应警示标志，禁止无关人员靠近。', 28);
INSERT INTO `security` VALUES (175, '疏散压缩气体钢瓶，必须充分冷却，并在水枪掩护下进行。', 28);
INSERT INTO `security` VALUES (176, '现场起重破拆必须佩戴护目镜、手套等防护装置。正确选择位置，使用快捷、高效的器材，合理实施起重破拆。', 28);
INSERT INTO `security` VALUES (177, '使用锤、斧、挠钩等器材破拆时，必须检查连接是否牢固，破拆时必须保持身体重心稳定，防止摔伤。', 28);
INSERT INTO `security` VALUES (178, '使用切割器具破拆时，要平稳操作、直线切割，切割器具前方不得站人。', 28);
INSERT INTO `security` VALUES (179, '实施扩张时，应选好两侧受力点，扩张器开口方向与受力面要保持垂直。', 28);
INSERT INTO `security` VALUES (180, '对硬、脆等物质进行扩张时，要防止碎片弹射伤人。', 28);
INSERT INTO `security` VALUES (181, '起重时，找准受力位置，气垫受力面塞入物体下部必须在总面积75%以上。', 28);
INSERT INTO `security` VALUES (182, '严禁重叠使用不带重叠连接装置的起重气垫；起重车辆时，要做好车辆固定防滑措施。', 28);
INSERT INTO `security` VALUES (183, '牵引吊升作业时，不得超角度、超限重操作，防止起吊器材侧翻，吊臂及转移线路下方严禁站人。', 28);
INSERT INTO `security` VALUES (184, '吊索与被吊升物体必须连接牢固，必要时采取防滑措施，起吊过程中保持重心稳定。', 28);
INSERT INTO `security` VALUES (185, '起吊可燃物质或现场发生可燃物质泄漏时，必须持续对吊索进行出水防护，防止产生火花引发燃烧爆炸。', 28);
INSERT INTO `security` VALUES (186, '使用大型机械进行破拆时，要划出警戒区域，安排专人指挥引导，并设置安全员。', 28);
INSERT INTO `security` VALUES (187, '破拆门窗玻璃时，必须站在门窗侧面，从玻璃上方一角开始破拆。', 28);
INSERT INTO `security` VALUES (188, '从破拆处进出时，必须清除残留的玻璃碎片。', 28);
INSERT INTO `security` VALUES (189, '不准随意破拆高处玻璃幕墙，必须实施破拆时，应及时在地面划出警戒区域，并派专人进行警戒提示。', 28);
INSERT INTO `security` VALUES (190, '一般不得破拆建筑承重构件，必须破拆时，应采取支撑加固等相应的安全防护措施。', 28);
INSERT INTO `security` VALUES (191, '不得轻易破拆应力不均部位，破拆时，应科学评估，做好应力平衡措施，严防破拆过程中弹射、突然撕裂等伤人。', 28);
INSERT INTO `security` VALUES (192, '在有燃烧爆炸危险的场所进行起重破拆作业时，必须使用无火花工具，或采取有效防爆措施，并使用水枪进行掩护。', 28);
INSERT INTO `security` VALUES (193, '高处破拆时，不得将破拆物抛向地面。破拆完毕后，应对破拆口尖锐部位进行处理，收整归拢破拆碎片。', 28);
INSERT INTO `security` VALUES (194, '破拆车辆时应进行固定，防止溜车、倾覆，并应避开安全气囊，或采取防范措施，防止气囊弹出伤人。', 28);
INSERT INTO `security` VALUES (195, '关阀堵漏编组一般为2至3人，必须在工艺处置队，或厂方技术人员指导配合下进行，全程实施喷雾水掩护。', 28);
INSERT INTO `security` VALUES (196, '关阀堵漏应当选择精干人员，组织备用力量，必要时进行轮换作业。', 28);
INSERT INTO `security` VALUES (197, '必须使用型号合适的关阀堵漏器材工具，严禁使用非防爆器材。', 28);
INSERT INTO `security` VALUES (198, '进入易燃、易爆、有毒区域关阀堵漏时，应从上风或侧上风方向进入。', 28);
INSERT INTO `security` VALUES (199, '进入压缩气体泄漏区域关阀堵漏时，必须落实防冻保护措施。', 28);
INSERT INTO `security` VALUES (200, '应避开高压泄漏口正面，堵漏时人员应从侧面或后面靠近开展作业，不得超限强行堵漏。', 28);
INSERT INTO `security` VALUES (201, '高空关阀堵漏作业时，须采取安全固定保护措施。', 28);
INSERT INTO `security` VALUES (202, '输转倒罐必须由专业人员操作，易燃易爆物质必须使用防爆输转设备。', 28);
INSERT INTO `security` VALUES (203, '必须与输转倒罐现场保持一定的安全距离，并对作业人员进行保护。', 28);
INSERT INTO `security` VALUES (204, '实施易燃易爆物质输转倒罐时，管线、设备必须接地，严禁在地面拖拉输转倒罐器材。', 28);
INSERT INTO `security` VALUES (205, '实施输转倒罐，必须进行现场监护，非禁水区域应利用喷雾水或水幕实施保护。', 28);
INSERT INTO `security` VALUES (206, '有毒物质输转时必须密闭储存，严格洗消后转运，交由专业机构处理。', 28);
INSERT INTO `security` VALUES (207, '在有毒有害物质区域内作业的人员、装备器材，撤回安全区前必须进行现场洗消。', 28);
INSERT INTO `security` VALUES (208, '必须正确选择洗消剂，并按照规定比例使用。', 28);
INSERT INTO `security` VALUES (209, '要严格程序，确保洗消全面到位，时间达到规定要求，重度污染要延长洗消时间、增加洗消次数。', 28);
INSERT INTO `security` VALUES (210, '对眼睛等特殊部位进行洗消时，应洗消充分，必要时相互协助或由专业人员负责实施。', 28);
INSERT INTO `security` VALUES (211, '有毒有害物质沾染皮肤时，应立即去除衣物，用大量的水进行冲洗15分钟，并彻底洗消，情况严重或沾染强腐蚀性和剧毒物质必须及时就医。', 28);
INSERT INTO `security` VALUES (212, '在清理可燃液（气）体、有毒物品泄漏现场时，必须检查窨井、暗沟、低洼处等有无残留物。', 28);
INSERT INTO `security` VALUES (213, '使用洗消帐篷进行洗消时，必须调节好水温；使用水枪进行洗消时，应当防止水流冲击伤人。', 28);
INSERT INTO `security` VALUES (214, '冲洗及洗消后的污水要妥善处理，防止造成二次污染。', 28);
INSERT INTO `security` VALUES (215, '救援结束后，应适时组织染毒区域内人员进行身体检查，必要时主动服用解毒药品。', 28);
INSERT INTO `security` VALUES (216, '放空点燃必须经专家论证并在工程技术人员配合下实施。', 28);
INSERT INTO `security` VALUES (217, '放空点燃必须采取远距离点燃的方法。', 28);
INSERT INTO `security` VALUES (218, '放空点燃必须从上风或者侧上风方向接近，并保持足够的安全距离。', 28);
INSERT INTO `security` VALUES (219, '担负放空点燃人员要专业精干，必须事先确定好紧急撤离路线、方式，必要时设置掩体，组织水枪实施掩护。', 28);
INSERT INTO `security` VALUES (220, '救援人员编组不得少于3人，并指定一名负责人。', 28);
INSERT INTO `security` VALUES (221, '在高空利用绳索、软梯、缓降器救人或者自救时，固定点必须牢固，必须设置不少于2 处固定支点。', 28);
INSERT INTO `security` VALUES (222, '必须使用安全绳对救援人员和被救人员进行保护。', 28);
INSERT INTO `security` VALUES (223, '绳索在接触建筑物的转角处必须使用墙角保护器或其他形式的护垫、护具，并在绳索救助系统额定荷载范围内使用。', 28);
INSERT INTO `security` VALUES (224, '使用登高器材登高救人时，尽量稳定被困人员情绪，实施有序疏散。', 28);
INSERT INTO `security` VALUES (225, '抢救疏散医院病人时，应当在医护人员的指导下进行，疏散传染病患者时，必须做好安全防护。', 28);
INSERT INTO `security` VALUES (226, '深井救人时，优先使用救援三脚架，必须利用有毒（可燃）气体检测仪对井下环境进行检测，对井口、井壁实施加固。', 28);
INSERT INTO `security` VALUES (227, '倒塌、交通事故等现场救人时，应对伤者进行固定。', 28);
INSERT INTO `security` VALUES (228, '搬运过程中保持头高脚低，必要时在现场医护人员指导配合下实施，防止二次伤害。', 28);
INSERT INTO `security` VALUES (229, '水域及洪涝灾害中进行救助时，应当选派水性和身体素质好的人员进行施救，从被困人员后侧靠近', 28);
INSERT INTO `security` VALUES (230, '水下救援时，应安排取得潜水员相应资质的人员佩戴潜水防护装具下水救援。', 28);
INSERT INTO `security` VALUES (231, '抢救自杀者、精神病患者、醉酒者、攻击性动物时，必须请求公安、医疗、动物管理部门配合救助，加强个人防护、做好避险准备，防止受到伤害。', 28);
INSERT INTO `security` VALUES (232, '放空点燃前，应认真清理警戒区内的无关人员和车辆。', 28);
INSERT INTO `security` VALUES (233, '在开展作战行动前，要明确紧急撤离的信号、撤离路线，并在安全区域选择集合地点，发现险情，应立即发布撤离信号，组织撤离行动。', 28);
INSERT INTO `security` VALUES (234, '必须密切观察现场情况，发现险情或接到险情报告及时发出撤离信号。', 28);
INSERT INTO `security` VALUES (235, '明确撤离要求，特别紧急情况下，应当放弃车辆和器材徒手快速撤离。', 28);
INSERT INTO `security` VALUES (236, '在油罐区防护堤内等危险区域作业时，提前设置利于快速撤离的各种设施，确定防爆掩蔽体，', 28);
INSERT INTO `security` VALUES (237, '遇爆炸等危险征兆来不及撤离时应就近卧倒，头向外、脸向下，匍匐撤离或依托掩体避险。', 28);
INSERT INTO `security` VALUES (238, '在高层建筑等复杂场所作业时，分层分区设置人员接应点，确保人员快速有序撤离。', 28);
INSERT INTO `security` VALUES (239, '发出紧急撤离信号后，中队指挥员要立即在集合地点清点人员，并向指挥部报告，研究新的对策措施。', 28);
INSERT INTO `security` VALUES (240, '有毒有害烟气、物质未彻底清除前，不得脱卸个人防护装备。', 28);
INSERT INTO `security` VALUES (241, '必须注意观察建筑物上方建筑构件和高空坠落物，观察砖墙、楼板和钢筋已经裸露的水泥柱的稳定性。', 28);
INSERT INTO `security` VALUES (242, '检查楼梯间、走道、外墙处烧损电线的带电情况，防止发生触电伤害事故，必要时切断进户线路。', 28);
INSERT INTO `security` VALUES (243, '检查煤气管道、液化气瓶的泄漏情况，防止发生爆燃伤人事故。', 28);
INSERT INTO `security` VALUES (244, '检查危险化学物品泄漏情况，防止发生复燃、爆炸、中毒、腐蚀伤害事故。', 28);
INSERT INTO `security` VALUES (245, '处置危险化学品灾害事故，或有燃气泄漏的灾害现场，应严防爆炸伤人。', 28);
INSERT INTO `security` VALUES (246, '靠近可燃物泄漏且未起火的现场，应注意观察和侦检，不得盲目选择行车路线，防止驾车误入泄漏区域。', 28);
INSERT INTO `security` VALUES (247, '收整器材时，严禁强行拖拽，禁止从高处抛掷。', 28);
INSERT INTO `security` VALUES (248, '撤离现场时，必须清点人员和器材。', 28);
INSERT INTO `security` VALUES (249, '进入有爆炸危险的区域应穿着防静电内衣，根据需要穿着特级或一级化学防护服，尽量从上风方向实施作战行动。', 28);
INSERT INTO `security` VALUES (250, '进入有爆炸危险的场所，应尽可能保持低姿状态，依托堤坝、承重墙、墙角、柱及大型物件等地形、地物作为掩护。', 28);
INSERT INTO `security` VALUES (251, '作战中，应利用测爆仪等仪器持续检测，可燃气体浓度接近爆炸下限且不能完全禁绝火源的，必须立即撤离。', 28);
INSERT INTO `security` VALUES (252, '充满可燃气体、易燃液体蒸气的空间，可采取强力送风，驱散可燃气体和蒸气。', 28);
INSERT INTO `security` VALUES (253, '可燃气体、易燃液体蒸气泄漏和粉尘飞扬的区域，可利用雾状水稀释降尘，抑制爆炸或降低爆炸危险。', 28);
INSERT INTO `security` VALUES (254, '可燃气体、易燃液体泄漏及粉尘扩散可能波及的区域（尤其是下风和侧下风方向）必需消除一切火种。', 28);
INSERT INTO `security` VALUES (255, '严禁在可燃气体、易燃液体蒸气泄漏区域内的门窗正面泄压口，下水井、电缆井、煤气井等部位的上方及周围站立。', 28);
INSERT INTO `security` VALUES (256, '密切观察存有爆炸危险的现场情况，减少一线作业人员，保持足够安全距离，发现危险征兆应迅速撤离。', 28);
INSERT INTO `security` VALUES (257, '进入有烟气、固体粉尘、异味、有毒气体泄露等有毒有害场所、区域作业时，应严防中毒。', 28);
INSERT INTO `security` VALUES (258, '根据烟气、毒害品性质确定防护等级，严格等级防护措施，未采取防护措施的人员严禁进入危险区域。', 28);
INSERT INTO `security` VALUES (259, '防护必须在进入有毒区域前完成，严禁在有毒区域脱卸或更换防护装备。', 28);
INSERT INTO `security` VALUES (260, '进入有毒区域的人员必须精干，进入前应进行安全登记，编组进入，严格控制人数。', 28);
INSERT INTO `security` VALUES (261, '严禁在有毒区域进食、饮水，以及坐、躺休息，或从事其他与抢险救援无关的事项。', 28);
INSERT INTO `security` VALUES (262, '从有毒区域撤出的人员、器材装备，要及时进行洗消。在洗消前，严禁与未采取防护措施的人员接触。', 28);
INSERT INTO `security` VALUES (263, '指挥员、安全员应对进入有毒区域的人员实时监测，发现体力不支、精神状态下降等情况，应及时安排人员轮换。', 28);
INSERT INTO `security` VALUES (264, '在入口处应部署应急小组待命，随时做好人员紧急救助准备。', 28);
INSERT INTO `security` VALUES (265, '对所有参战人员必须持续观察，必要时服用解毒药品，或就医检查。', 28);
INSERT INTO `security` VALUES (266, '作业前应关闭作业区域电源开关，必要时可切断灾害区域入户电线。', 28);
INSERT INTO `security` VALUES (267, '在具有触电危险的现场，要利用漏电探测仪实施检测，并划定警戒区域。', 28);
INSERT INTO `security` VALUES (268, '进入可能存在漏电危险区域的人员要穿戴绝缘服、绝缘手套、绝缘胶靴，避免与带电体接触。', 28);
INSERT INTO `security` VALUES (269, '禁止站在架空电线下方，防止电线断落引发触电，要防止高温条件下电线绝缘层烧毁老化引发触电。', 28);
INSERT INTO `security` VALUES (270, '不得靠近电线断落的区域尤其是积水区域，误入带电区域应双脚并拢、或单脚跳离，防止产生跨步电压。', 28);
INSERT INTO `security` VALUES (271, '发现有人员触电时，不可直接用裸露的双手拉拽，应用干燥的木棒、竹竿等绝缘体将触电者与电源分离，或立即切断电源。', 28);
INSERT INTO `security` VALUES (272, '根据救援需要对危险建筑结构采取加固措施，消除倒塌风险。', 28);
INSERT INTO `security` VALUES (273, '必要时对有倒塌风险的构件进行拆除，对有塌方风险的地方进行清除开挖主动排除倒塌风险。', 28);
INSERT INTO `security` VALUES (274, '进入或靠近存倒塌危险区域作业时，严防指战员埋压受害。', 28);
INSERT INTO `security` VALUES (275, '危险建筑保持足够的安全距离，不要在陈旧、烧损的屋檐及窗口下方架梯。', 28);
INSERT INTO `security` VALUES (276, '不得沿建筑底层墙边行走，必须与外墙保持足够距离，防止被高空坠物埋压砸伤。', 28);
INSERT INTO `security` VALUES (277, '对可能发生倒塌的区域或倒塌坠落物影响区域，要设置警戒，并安排专人负责看护提示，禁止人员靠近。', 28);
INSERT INTO `security` VALUES (278, '不得进入已经明显松动的建筑内部，不准冒险钻入非固定支撑的废墟空隙间，必须进入时应评估，并采取加固措施。', 28);
INSERT INTO `security` VALUES (279, '进入井下、坑道作业时，要对井口、侧壁进行支撑，严禁大型机械在周边行进，不得停靠车辆或站立大量人员。', 28);
INSERT INTO `security` VALUES (280, '山地、土堆等区域作业时，应尽量保持安全距离，安排专人观察上方滑坡、塌方迹象。', 28);
INSERT INTO `security` VALUES (281, '在存倒塌、坍塌危险区域作业时，要寻找依托牢固掩体，预防埋压伤害。', 28);
INSERT INTO `security` VALUES (282, '在开展登高作业，高空救援，进入工地等危险区域，或在视线较差、湿滑等场所行进时，应严防坠落。', 28);
INSERT INTO `security` VALUES (283, '在进行登高作业时，必须采取安全牢固的保护措施。', 28);
INSERT INTO `security` VALUES (284, '在石棉瓦、玻璃钢瓦、彩钢板等轻质屋顶上行动时，应沿有铆钉的承重部位行动。', 28);
INSERT INTO `security` VALUES (285, '在施工现场、建筑工地行动要注意观察，谨慎行进，避开敞开式孔洞，防止踏空坠落。', 28);
INSERT INTO `security` VALUES (286, '在结冰、油污、湿滑、坑凹不平的地面或有障碍物的区域行动时，要小心谨慎防摔跌。', 28);
INSERT INTO `security` VALUES (287, '在确认轿厢楼层和被困人员位置的情况方可开启对应电梯层门，开启时保持重心稳定，必要时采取安全绳保护。', 28);
INSERT INTO `security` VALUES (288, '登上倾斜船体时，要紧紧抓住护栏或用绳索固定在栏杆等牢固部位。', 28);
INSERT INTO `security` VALUES (289, '救援人员高空救助时，可根据作业环境，铺设救生气垫、设置安全网，提升安全防范效果。', 28);
INSERT INTO `security` VALUES (290, '跨越有缝隙的架空道路隔离带时，做好绳索保护，视情架梯通过，跨越位置应选择在事故点上风位置。', 28);
INSERT INTO `security` VALUES (291, '开展水域救援、冰面救援和训练，实施洪涝灾害事故处置时，或进行城市内涝排水时，应严防溺水。', 28);
INSERT INTO `security` VALUES (292, '救援人员在开展水域救援时，要合理编组，严格程序、采取正确救人方法，明确安全纪律和行动要求。', 28);
INSERT INTO `security` VALUES (293, '在上游设置观察员，现场设置安全员，掌握水情动态，对救援人员的安全防护进行检查。', 28);
INSERT INTO `security` VALUES (294, '必须持证驾驶舟艇，驾驶员精力集中，控制速度，保持船身稳定，躲避障碍物。', 28);
INSERT INTO `security` VALUES (295, '严禁超载，乘员必须熟悉水性，不得盲目跟艇施救，行驶过程中必须抓紧船体，严防落水。', 28);
INSERT INTO `security` VALUES (296, '在开展救助行动时，要选择精干人员入水救助，同时部署预备力量轮换。', 28);
INSERT INTO `security` VALUES (297, '夜间等视线不清，水情不明或水情复杂、水流湍急时严禁贸然下水救援。', 28);
INSERT INTO `security` VALUES (298, '入水救援人员必须穿着消防员专业救生衣、采取安全绳固定保护，必须具备游泳技能。', 28);
INSERT INTO `security` VALUES (299, '非专业持证人员，不得开展潜水作业。', 28);
INSERT INTO `security` VALUES (300, '必须编队潜水，不得单独作业，潜水作业时按照1:1配置备用应急小组，并同步穿戴全套潜水装具。', 28);
INSERT INTO `security` VALUES (301, '下潜时经常观察压力表和浮力表，保持中性浮力，每下潜3m均需观察周边情况，气瓶压力低于5MPa时必须上浮出水，速度不得大于18m/min。', 28);
INSERT INTO `security` VALUES (302, '冬季下水救援或在冰面开展救援行动必须采取保暖和预防冰面破裂等防范措施。', 28);
INSERT INTO `security` VALUES (303, '在摘除马蜂窝等，或在马蜂、蜜蜂集中区域开展作业时，应防止蜇伤。', 28);
INSERT INTO `security` VALUES (304, '应穿着防蜂服，并在服装内部佩戴抢险救援头盔，袖口和裤管及头罩须扎紧，并随车携带急救解毒药品。', 28);
INSERT INTO `security` VALUES (305, '处置前要研判周边群众分布情况，提示周边住户关闭门窗、做好防蜂虫蛰伤防范措施。', 28);
INSERT INTO `security` VALUES (306, '划定警戒区域，设置警戒，疏散警戒区域内无关人员，禁止无关人员或无防护人员进入警戒区域。', 28);
INSERT INTO `security` VALUES (307, '处置要采取合适的措施，干净利落，有条件的应优先采取网罩、火攻等措施，防止蜂虫大面积逃脱、飞散伤人。', 28);
INSERT INTO `security` VALUES (308, '脱卸防蜂服前，应认真检查确认无附着蜂虫方可脱卸。', 28);
INSERT INTO `security` VALUES (309, '日常应组织指战员进行蜂毒过敏测试，蜂毒过敏体质人员不得参与摘除蜂窝任务。', 28);
INSERT INTO `security` VALUES (310, '摘下的马蜂窝、虫巢等应在合适安全的位置用火焚烧、水淹，或用蛇皮袋等牢固包装材料密闭包装转移掩埋。', 28);
INSERT INTO `security` VALUES (311, '密闭包装原则上不得开启，必须开启时应确认内部蜂虫全部灭杀，并做好个人防护和灭杀准备。', 28);
INSERT INTO `security` VALUES (312, '必须在本车指挥员确定人员全部登车、器材箱及车门关牢、车库门完全开启定位并发出指令后，按照出车顺序出库。', 29);
INSERT INTO `security` VALUES (313, '车辆在出警行驶途中，应开启警灯警报器，严格遵守交通法规，确保行车安全。', 29);
INSERT INTO `security` VALUES (314, '消防员不得将肢体伸出车窗外，设有安全带座位的乘员应系安全带。', 29);
INSERT INTO `security` VALUES (315, '车辆行驶途中，驾驶员和指挥员应加强行车观察，驾驶员不得疲劳驾驶，指挥员不得睡觉。', 29);
INSERT INTO `security` VALUES (316, '应控制车速，与前车保持足够的安全距离，严禁强行超车，防止摩托车、自行车、行人、车辆横穿和急速转弯变道。', 29);
INSERT INTO `security` VALUES (317, '雨、雪、雾、大风天气，冰雪、泥浆、湿滑等路面行驶时，减速慢行，增配防滑链，开启雾灯、“双闪”警示灯。', 29);
INSERT INTO `security` VALUES (318, '狭窄、陡坡、弯路、松软路面行驶，注意观察，控制车速。', 29);
INSERT INTO `security` VALUES (319, '狭窄、陡坡、弯路、松软路面行驶，正确使用刹车制动，防止操作失误，必要时组织乘车人员下车徒步通过。', 29);
INSERT INTO `security` VALUES (320, '经过桥梁、涵洞、隧道时，应当注意观察限高、限重及空中障碍物。', 29);
INSERT INTO `security` VALUES (321, '特殊情况需要通过交通禁用通道或正在施工的路段时，要详细了解情况，确保安全后方可通行。', 29);
INSERT INTO `security` VALUES (322, '经过铁路道口时必须服从信号灯或道口工作人员指挥，严禁抢行或强行通过。', 29);
INSERT INTO `security` VALUES (323, '倒车时必须安排人员在车辆两侧后方进行指挥警戒。', 29);
INSERT INTO `security` VALUES (324, '车辆到达现场后，应当根据现场情况选择适当的停车位置，并统一在道路一侧靠边停放。', 29);
INSERT INTO `security` VALUES (325, '车辆到达现场后，车辆之间保持约20米的安全距离。大型灾害事故处置时，应由指挥部指定专人指挥车辆集结、停放。', 29);
INSERT INTO `security` VALUES (326, '严禁在松软或者路基薄弱的地带、高压线下和危险建（构）筑物旁停靠。', 29);
INSERT INTO `security` VALUES (327, '必须与起火建（构）筑物或危险区域保持足够的安全距离。', 29);
INSERT INTO `security` VALUES (328, '举高、照明消防车必须停靠在空中无障碍物、地面平坦坚实的地段。', 29);
INSERT INTO `security` VALUES (329, '增援时，未向现场指挥员请示，未明确火场任务，不可盲目驶入现场停靠。', 29);
INSERT INTO `security` VALUES (330, '扑救高危场所火灾时，车辆应当停在便于展开、便于转移的安全位置，车头应朝撤离方向。', 29);
INSERT INTO `security` VALUES (331, '在进入易燃易爆气体或者可燃液体泄漏的场所前，车辆必须安装防火罩，并停靠在上风或侧上风位置。', 29);
INSERT INTO `security` VALUES (332, '在进入易燃易爆气体或者可燃液体泄漏的场所前，严禁停靠在地沟、窨井、管道上方及其附近。', 29);
INSERT INTO `security` VALUES (333, '处置公路隧道灾害事故，一般情况下车辆应停放在隧道两端洞外右侧。', 29);
INSERT INTO `security` VALUES (334, '当车辆必须停在坡路上时，应采取可靠的防溜车措施。', 29);
INSERT INTO `security` VALUES (335, '开门下车时，应观察车辆、行人来往情况，避免开门下车与来往车辆、行人发生碰撞，从靠近人行道一侧开门下车。', 29);
INSERT INTO `security` VALUES (336, '开展交通道路火灾扑救或应急救援时，救援车辆应跨路斜停（车尾靠近来车方向）在事故车辆后方。', 29);
INSERT INTO `security` VALUES (337, '开展交通道路火灾扑救或应急救援时，，停靠位置应距离事故点不少于50米。', 29);
INSERT INTO `security` VALUES (338, '现场供水必须根据供水原则，采用正确的供水方法。', 29);
INSERT INTO `security` VALUES (339, '驾驶员应与供水指挥员、分水器控制人员、水枪手保持联系，根据供水指令实施供水作业。', 29);
INSERT INTO `security` VALUES (340, '供水时，应缓慢加压，保持水压平稳，不得突然加压、超压供水，遇特殊情况立即停水。', 29);
INSERT INTO `security` VALUES (341, '一般情况下应在水带线路铺设完成，分水器、水枪控制人员就位以后方可实施供水。', 29);
INSERT INTO `security` VALUES (342, '紧急情况下提前供水时，水头应与铺设线路的人员保持2根水带以上的安全距离。', 29);
INSERT INTO `security` VALUES (343, '水泵出口、分水器、水枪等不得急开急关，防止水锤作用伤人。', 29);
INSERT INTO `security` VALUES (344, '水带铺设应平直、沿路边设置，跨越道路时垂直铺设，并应设置水带护桥，', 29);
INSERT INTO `security` VALUES (345, '参战人员不得站立于打圈水带之间，水带不得缠绕身体。', 29);
INSERT INTO `security` VALUES (346, '垂直铺设水带时，必须在底层设置两道分水器，并使用水带挂钩、绳索、水带接口加固件等进行固定。', 29);
INSERT INTO `security` VALUES (347, '水带固定点应选在两条水带接口下端，下方不得站人。', 29);
INSERT INTO `security` VALUES (348, '停泵前应开启底层分水器泄压后，再缓慢停泵。', 29);
INSERT INTO `security` VALUES (349, '耦合供水时，前车先启动加压，停水时后车先减压停泵，不得急停。', 29);
INSERT INTO `security` VALUES (350, '消防车在进行高压供水时，水泵出口、分水器、水带接口附近不得站人。', 29);
INSERT INTO `security` VALUES (351, '供水流量不足时，应优先保障内攻线路、高危区域、掩护射流用水需求。', 29);
INSERT INTO `security` VALUES (352, '危险化学品处置现场车辆应停靠上风侧水源，保持足够安全距离。', 29);
INSERT INTO `security` VALUES (353, '危险化学品处置现场，设置不少于2路不同来源的供水线路。', 29);
INSERT INTO `security` VALUES (354, '水带铺设应当避开玻璃幕墙下方、尖锐物质，如无法避开时，应当对水带进行遮盖或包裹。', 29);
INSERT INTO `security` VALUES (355, '水带漏水时应及时进行包扎或调换。', 29);
INSERT INTO `security` VALUES (356, '远程供水车组铺设或收卷供水线路时，应设置专人引导指挥，确保安全。', 29);

-- ----------------------------
-- Table structure for site
-- ----------------------------
DROP TABLE IF EXISTS `site`;
CREATE TABLE `site`  (
  `siteID` int(2) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `sitename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `siteposition` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tele` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`siteID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of site
-- ----------------------------
INSERT INTO `site` VALUES (01, '大场', '大场镇', '119');
INSERT INTO `site` VALUES (02, '顾村', '顾村镇', '119');

-- ----------------------------
-- Table structure for special
-- ----------------------------
DROP TABLE IF EXISTS `special`;
CREATE TABLE `special`  (
  `informID` int(2) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `inform` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `detailtype` int(2) NOT NULL COMMENT '与detailtype表中typeid相关\r\n',
  PRIMARY KEY (`informID`) USING BTREE,
  INDEX `detailtype`(`detailtype`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 86 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of special
-- ----------------------------
INSERT INTO `special` VALUES (01, '侦察掌握冷库情况。指挥员要靠前指挥，组织侦察了解制冷剂类型、冷库建筑结构，预判安全风险隐患。', 8);
INSERT INTO `special` VALUES (02, '及时切断危险隐患。第一时间切断电源，停止制冷系统运行，防止冻伤和触电。\r\n及时切断危险隐患。第一时间切断电源，停止制冷系统运行，防止冻伤和触电。\r\n及时切断危险隐患。第一时间切断电源，停止制冷系统运行，防止冻伤和触电。', 8);
INSERT INTO `special` VALUES (03, '防止爆炸中毒发生。遇制冷剂泄漏时，利用检测仪监测浓度，采用喷雾水进行稀释降毒，防止爆炸和中毒。', 8);
INSERT INTO `special` VALUES (04, '进入冷库内部人员应佩戴空气呼吸器，携带热成像仪和有毒气体检测仪，必要时水枪同步跟进掩护；', 8);
INSERT INTO `special` VALUES (05, '进入氨气压缩机房关闭阀门或灭火时，要做好防冻保暖措施，佩戴空气呼吸器，穿着防化服，防止液氨喷出导致中毒或冻伤。', 8);
INSERT INTO `special` VALUES (06, '防止建（构）筑倒塌。加强对建筑构件冷却，防止倒塌；随时观察内部货架、货物等稳固情况，防止倒塌埋压。', 8);
INSERT INTO `special` VALUES (07, '确保进出通道安全，实施冷库火灾扑救，当空间较大、充斥高温浓烟，应敷设救生照明线、安全绳作为进出路线引导。', 8);
INSERT INTO `special` VALUES (08, '遇有紧急情况，进攻小组应坚持同进同出原则要求，防止发生迷失造成伤亡。', 8);
INSERT INTO `special` VALUES (09, '防止粉尘飞扬。进入可能有悬浮粉尘的区域，应采取防静电措施，避免金属器材碰撞产生火花；', 10);
INSERT INTO `special` VALUES (10, '及时向扬尘区域喷洒雾状水，降低空间内悬浮粉尘浓度。', 10);
INSERT INTO `special` VALUES (11, '合理设置阵地。进攻路线和阵地的设置应避开泄压口，防范粉尘爆炸冲击等潜在风险造成人员伤害。', 10);
INSERT INTO `special` VALUES (12, '正确实施灭火。', 10);
INSERT INTO `special` VALUES (13, '沉淀粉尘表面起火后，应用雾状水喷洒，不能用直流水、有冲击力的干粉、二氧化碳等冲击粉尘。防止粉尘飞扬、引发爆炸。', 10);
INSERT INTO `special` VALUES (14, '在扑救面粉生产、轮毂抛光等粉尘车间设备火灾时，要提前对除尘室的设备、管道用雾状水降尘增湿，防止火星被吸入除尘管道、引发除尘室爆炸。', 10);
INSERT INTO `special` VALUES (15, '防范金属粉尘。', 10);
INSERT INTO `special` VALUES (16, '对遇水反应的金属粉尘（铝、镁粉等），可用干沙、石灰、水泥粉等进行覆盖灭火，禁止使用水、泡沫灭火；', 10);
INSERT INTO `special` VALUES (17, '覆盖灭火时，应在覆盖层上设置孔洞，便于可燃气体溢散，避免发生爆燃。', 10);
INSERT INTO `special` VALUES (18, '加强现场侦察辨识。', 11);
INSERT INTO `special` VALUES (19, '通过现场辨识、中控室DCS系统、查阅设计施工图纸等方式，核查确认储罐类型、储存介质、储运工艺、运行工况、事故部位、燃烧形式、灾情等级等处置要素，综合研判超压超温等安全风险，采取针对性预防措施。', 11);
INSERT INTO `special` VALUES (20, '严格个人安全防护。根据现场情况佩戴个人防护装备，落实防火、防爆、防毒、防冻、防灼伤等措施。', 11);
INSERT INTO `special` VALUES (21, '登罐灭外浮顶原油储罐火灾时，要做好针对硫化氢的呼吸防护，特别是火灾扑灭后硫化氢浓度增加，要加强气体浓度监测和呼吸防护。', 11);
INSERT INTO `special` VALUES (22, '合理设置进攻阵地。', 11);
INSERT INTO `special` VALUES (23, '参战车辆停靠上风或侧上风方向，车头朝向撤离方向。', 11);
INSERT INTO `special` VALUES (24, '严禁停靠在地势低洼处和窨井盖、下水道附近，并与现场必须保持足够的安全距离，不得贸然进入储罐区。', 11);
INSERT INTO `special` VALUES (25, '防止复燃复爆发生。处置液化烃全压力、半冷冻、全冷冻储罐时，液化烃火灾扑灭后，要防止复燃复爆；', 11);
INSERT INTO `special` VALUES (26, '泄漏事故要及时关闭雨排、沟渠等设施，防止液化烃沿地下隐蔽设施外泄，遇明火回燃至储罐区。', 11);
INSERT INTO `special` VALUES (27, '明确紧急撤离信号。应设置现场观察哨，及时发出险情预警。', 11);
INSERT INTO `special` VALUES (28, '指挥员要视灾情发展程度和危害后果，及时作出紧急撤离、暂缓处置等决定，一线作战人员视情采取紧急避险措施。', 11);
INSERT INTO `special` VALUES (29, '合理设置阵地。车辆停靠、阵地设置应坚持上风向或侧风向原则。', 12);
INSERT INTO `special` VALUES (40, '避开流淌火、爆炸冲击波、毒害、腐蚀、放射源等风险区域以及窨井盖、事故装置的工艺管线和压力容器，防止处置过程中意外伤害。', 12);
INSERT INTO `special` VALUES (41, '落实防毒措施。落实“防火、防爆、防毒、防灼伤、防冻伤、防同位素辐射”的要求。视情保护有害气体焚烧炉处于明火状态；', 12);
INSERT INTO `special` VALUES (42, '工艺未到位或现场情况不明的，严禁盲目深入内部作业。', 12);
INSERT INTO `special` VALUES (43, '明确禁入范围。严禁作战人员进入多层装置框架内部实施灭火冷却作业；', 12);
INSERT INTO `special` VALUES (44, '扑救地面流淌火时，严禁进入燃烧区域或泡沫覆盖区域。', 12);
INSERT INTO `special` VALUES (45, '准确辨识风险。对设有放射源料位计的装置区域，要保持安全距离，警惕铅盒熔化后水流沾染的间接辐射；', 12);
INSERT INTO `special` VALUES (46, '对活性物质危险源（三乙基铝、倍半烷基铝等催化剂），严禁射水扑救；', 12);
INSERT INTO `special` VALUES (47, '对遇水反应生成剧毒品或装置内多种物料混合反应形成的毒害区，要落实及时安全防护，减少一线作业人员。', 12);
INSERT INTO `special` VALUES (48, '警惕特殊设备。对高温换热器、高温油泵（原油蒸馏装置渣油泵）冷却灭火，作战行动应避开高压换热器封头的扇面区域；', 12);
INSERT INTO `special` VALUES (49, '对高温高压、临氢反应器（釜）等设备，严禁用直流水冷却灭火；对低温深冷容器和输送管道，严禁射水灭火冷却。', 12);
INSERT INTO `special` VALUES (57, '加强侦察侦检。侦察井口、井壁有无坍塌风险，使用有毒气体检测仪，全程检测井内有毒有害气体浓度。', 20);
INSERT INTO `special` VALUES (58, '做好安全防护。设置警戒或围栏，控制井口人员数量。', 20);
INSERT INTO `special` VALUES (59, '救援人员必须佩戴空气呼吸器或移动供气源，严防面罩刮落、供气管线划破。', 20);
INSERT INTO `special` VALUES (60, '实施绳索保护。架设救援三脚架、搭建两节拉梯，对下井人员进行绳索保护，建立上下行动和营救生命通道。', 20);
INSERT INTO `special` VALUES (61, '适时降毒增氧。必要时，利用送风机、气瓶等吹扫置换井下有毒有害气体，降毒增氧。', 20);
INSERT INTO `special` VALUES (62, '设置预备力量。设置紧急救助小组和预备力量，做好紧急救助准备和人员轮换，不得盲目超时限、超强度作业。', 20);
INSERT INTO `special` VALUES (63, '保障通信联络。保持现场相对安静，明确绳索联络信号和方式，确保救援信息及时准确传达。', 20);
INSERT INTO `special` VALUES (64, '加强险情判断。全面侦察坑道内部、周边土质等情况，是否存在二次坍塌风险。', 23);
INSERT INTO `special` VALUES (65, '控制周边人员。设置警戒或围栏，严禁无关人员进入，控制坑道附近人员，防止因承载过大发生坍塌。', 23);
INSERT INTO `special` VALUES (66, '禁止机械扰动。附近工作的重型设备应停止作业，挖出的土方要远离坑壁，防止造成二次塌方。', 23);
INSERT INTO `special` VALUES (67, '采取支撑措施。采取支撑稳固措施，情况紧急且暂无坍塌危险时，一边救援一边实施支撑加固，防止坑道坍陷。', 23);
INSERT INTO `special` VALUES (68, '避免渗水影响。及时排出坑道积水，防止积水造成坑道土体稳定性下降，以及渗水对被救困人员的影响。', 23);
INSERT INTO `special` VALUES (69, '做好应急准备。制定紧急安全措施，设置预备力量，采取临时稳固措施，做好突发情况和紧急救助的准备。', 23);
INSERT INTO `special` VALUES (70, '需要步行远程开进时，应配备护肘护膝、手套、军刀、防尘口罩、毛巾、雨衣、个人急救包等个人防护装备，携带安全绳等辅助行进器材。', 24);
INSERT INTO `special` VALUES (71, '行进时靠近远离山体的道路一侧行进，并留意碎石滑落等山体变化情况，危险区域要分组快速通过，不得停留。', 24);
INSERT INTO `special` VALUES (72, '保障阵地安全。应评估宿营地环境，尽量选择平整较高的区域作为营地，救援时要尽量远离滑坡体。', 24);
INSERT INTO `special` VALUES (73, '加强现场观察。划定警戒区，设置观察哨，禁止无关人员进入现场，并实行局部交通管制；', 24);
INSERT INTO `special` VALUES (74, '要有地质专家和技术人员全程指导观察救援现场环境，发现危险征兆立即发出撤离信号。', 24);
INSERT INTO `special` VALUES (75, '实施编组作业。编组开展搜救作业，尽量减少危险区域救援人员，严禁在危险区域聚集。', 24);
INSERT INTO `special` VALUES (76, '采取避险措施。遇山体崩滑，应向滑坡方向的两侧撤离；', 24);
INSERT INTO `special` VALUES (77, '当无法继续撤离时，应就近避险，严禁顺着滚石方向往山下跑。', 24);
INSERT INTO `special` VALUES (78, '救援人员应着防蜂服，手、脚等全封闭防护；备好降暑药品和急救解毒药品；', 26);
INSERT INTO `special` VALUES (79, '不得安排蜂毒过敏体质人员参与摘除蜂窝任务；高空作业要利用绳索进行安全保护。', 26);
INSERT INTO `special` VALUES (80, '加强现场管控。划定警戒区，禁止无关人员进入作业区；提示附近住户关闭门窗，采取防蜂虫蜇伤的防范措施。', 26);
INSERT INTO `special` VALUES (81, '采取有效方法。根据蜂巢形态、所处位置，合理选择作业时间和处置措施，防止蜂虫大面积逃脱、飞散伤人。', 26);
INSERT INTO `special` VALUES (82, '妥善处置蜂窝。摘下的蜂窝在安全区域进行处理，不得随意开启密封包装，禁止带回营区。', 26);
INSERT INTO `special` VALUES (83, '做好应急处置。防蜂服面罩破损并遭到马蜂攻击时，应低头含胸，双手捂住破损部位，静待马蜂离去；', 26);
INSERT INTO `special` VALUES (84, '被蜂蜇伤后，若皮内留有毒刺，可用针或镊子挑出毒刺，不得挤压, 以免剩余的毒素进入体内；', 26);
INSERT INTO `special` VALUES (85, '因蜇伤出现过敏性休克或心跳呼吸停止，应立即进行心肺复苏，并及时就医。', 26);
INSERT INTO `special` VALUES (86, '严格脱卸检查。脱卸防蜂服前，应认真检查确认有无附着蜂虫，防止蜂蜇伤害。', 26);

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `config_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '参数主键',
  `config_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '参数键值',
  `config_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'N' COMMENT '系统内置（Y是 N否）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`config_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '参数配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_config
-- ----------------------------
INSERT INTO `sys_config` VALUES (1, '主框架页-默认皮肤样式名称', 'sys.index.skinName', 'skin-blue', 'Y', 'admin', '2022-11-28 13:24:47', '', NULL, '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow');
INSERT INTO `sys_config` VALUES (2, '用户管理-账号初始密码', 'sys.user.initPassword', '123456', 'Y', 'admin', '2022-11-28 13:24:47', '', NULL, '初始化密码 123456');
INSERT INTO `sys_config` VALUES (3, '主框架页-侧边栏主题', 'sys.index.sideTheme', 'theme-dark', 'Y', 'admin', '2022-11-28 13:24:47', '', NULL, '深色主题theme-dark，浅色主题theme-light');
INSERT INTO `sys_config` VALUES (4, '账号自助-验证码开关', 'sys.account.captchaOnOff', 'true', 'Y', 'admin', '2022-11-28 13:24:47', '', NULL, '是否开启验证码功能（true开启，false关闭）');
INSERT INTO `sys_config` VALUES (5, '账号自助-是否开启用户注册功能', 'sys.account.registerUser', 'false', 'Y', 'admin', '2022-11-28 13:24:47', '', NULL, '是否开启注册用户功能（true开启，false关闭）');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `dept_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `parent_id` bigint(20) NULL DEFAULT 0 COMMENT '父部门id',
  `ancestors` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '部门名称',
  `order_num` int(4) NULL DEFAULT 0 COMMENT '显示顺序',
  `leader` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 200 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (100, 0, '0', '若依科技', 0, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-11-28 13:24:46', '', NULL);
INSERT INTO `sys_dept` VALUES (101, 100, '0,100', '深圳总公司', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-11-28 13:24:46', '', NULL);
INSERT INTO `sys_dept` VALUES (102, 100, '0,100', '长沙分公司', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-11-28 13:24:46', '', NULL);
INSERT INTO `sys_dept` VALUES (103, 101, '0,100,101', '研发部门', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-11-28 13:24:46', '', NULL);
INSERT INTO `sys_dept` VALUES (104, 101, '0,100,101', '市场部门', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-11-28 13:24:46', '', NULL);
INSERT INTO `sys_dept` VALUES (105, 101, '0,100,101', '测试部门', 3, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-11-28 13:24:46', '', NULL);
INSERT INTO `sys_dept` VALUES (106, 101, '0,100,101', '财务部门', 4, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-11-28 13:24:46', '', NULL);
INSERT INTO `sys_dept` VALUES (107, 101, '0,100,101', '运维部门', 5, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-11-28 13:24:46', '', NULL);
INSERT INTO `sys_dept` VALUES (108, 102, '0,100,102', '市场部门', 1, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-11-28 13:24:46', '', NULL);
INSERT INTO `sys_dept` VALUES (109, 102, '0,100,102', '财务部门', 2, '若依', '15888888888', 'ry@qq.com', '0', '0', 'admin', '2022-11-28 13:24:46', '', NULL);

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data`  (
  `dict_code` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典编码',
  `dict_sort` int(4) NULL DEFAULT 0 COMMENT '字典排序',
  `dict_label` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '字典类型',
  `css_class` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '样式属性（其他样式扩展）',
  `list_class` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表格回显样式',
  `is_default` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 102 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '字典数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------
INSERT INTO `sys_dict_data` VALUES (1, 1, '男', '0', 'sys_user_sex', '', '', 'Y', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '性别男');
INSERT INTO `sys_dict_data` VALUES (2, 2, '女', '1', 'sys_user_sex', '', '', 'N', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '性别女');
INSERT INTO `sys_dict_data` VALUES (3, 3, '未知', '2', 'sys_user_sex', '', '', 'N', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '性别未知');
INSERT INTO `sys_dict_data` VALUES (4, 1, '显示', '0', 'sys_show_hide', '', 'primary', 'Y', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '显示菜单');
INSERT INTO `sys_dict_data` VALUES (5, 2, '隐藏', '1', 'sys_show_hide', '', 'danger', 'N', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '隐藏菜单');
INSERT INTO `sys_dict_data` VALUES (6, 1, '正常', '0', 'sys_normal_disable', '', 'primary', 'Y', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (7, 2, '停用', '1', 'sys_normal_disable', '', 'danger', 'N', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '停用状态');
INSERT INTO `sys_dict_data` VALUES (8, 1, '正常', '0', 'sys_job_status', '', 'primary', 'Y', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (9, 2, '暂停', '1', 'sys_job_status', '', 'danger', 'N', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '停用状态');
INSERT INTO `sys_dict_data` VALUES (10, 1, '默认', 'DEFAULT', 'sys_job_group', '', '', 'Y', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '默认分组');
INSERT INTO `sys_dict_data` VALUES (11, 2, '系统', 'SYSTEM', 'sys_job_group', '', '', 'N', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '系统分组');
INSERT INTO `sys_dict_data` VALUES (12, 1, '是', 'Y', 'sys_yes_no', '', 'primary', 'Y', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '系统默认是');
INSERT INTO `sys_dict_data` VALUES (13, 2, '否', 'N', 'sys_yes_no', '', 'danger', 'N', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '系统默认否');
INSERT INTO `sys_dict_data` VALUES (14, 1, '通知', '1', 'sys_notice_type', '', 'warning', 'Y', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '通知');
INSERT INTO `sys_dict_data` VALUES (15, 2, '公告', '2', 'sys_notice_type', '', 'success', 'N', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '公告');
INSERT INTO `sys_dict_data` VALUES (16, 1, '正常', '0', 'sys_notice_status', '', 'primary', 'Y', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (17, 2, '关闭', '1', 'sys_notice_status', '', 'danger', 'N', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '关闭状态');
INSERT INTO `sys_dict_data` VALUES (18, 1, '新增', '1', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '新增操作');
INSERT INTO `sys_dict_data` VALUES (19, 2, '修改', '2', 'sys_oper_type', '', 'info', 'N', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '修改操作');
INSERT INTO `sys_dict_data` VALUES (20, 3, '删除', '3', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '删除操作');
INSERT INTO `sys_dict_data` VALUES (21, 4, '授权', '4', 'sys_oper_type', '', 'primary', 'N', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '授权操作');
INSERT INTO `sys_dict_data` VALUES (22, 5, '导出', '5', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '导出操作');
INSERT INTO `sys_dict_data` VALUES (23, 6, '导入', '6', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '导入操作');
INSERT INTO `sys_dict_data` VALUES (24, 7, '强退', '7', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '强退操作');
INSERT INTO `sys_dict_data` VALUES (25, 8, '生成代码', '8', 'sys_oper_type', '', 'warning', 'N', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '生成操作');
INSERT INTO `sys_dict_data` VALUES (26, 9, '清空数据', '9', 'sys_oper_type', '', 'danger', 'N', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '清空操作');
INSERT INTO `sys_dict_data` VALUES (27, 1, '成功', '0', 'sys_common_status', '', 'primary', 'N', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '正常状态');
INSERT INTO `sys_dict_data` VALUES (28, 2, '失败', '1', 'sys_common_status', '', 'danger', 'N', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '停用状态');
INSERT INTO `sys_dict_data` VALUES (100, 0, '在岗', '0', 'sys_user_status', NULL, NULL, 'Y', '0', 'admin', NULL, '', NULL, '在岗状态');
INSERT INTO `sys_dict_data` VALUES (101, 1, '休假', '1', 'sys_user_status', NULL, NULL, 'N', '0', 'admin', NULL, '', NULL, '休假状态');
INSERT INTO `sys_dict_data` VALUES (102, 0, '已完成', '0', 'sys_caution_status', NULL, NULL, 'Y', '0', 'admin', NULL, '', NULL, '案件已完成');
INSERT INTO `sys_dict_data` VALUES (103, 1, '进行中', '1', 'sys_caution_status', NULL, NULL, 'N', '0', 'admin', NULL, '', NULL, '案件进行中');

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type`  (
  `dict_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '字典主键',
  `dict_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '字典类型',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`) USING BTREE,
  UNIQUE INDEX `dict_type`(`dict_type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '字典类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES (1, '用户性别', 'sys_user_sex', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '用户性别列表');
INSERT INTO `sys_dict_type` VALUES (2, '菜单状态', 'sys_show_hide', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '菜单状态列表');
INSERT INTO `sys_dict_type` VALUES (3, '系统开关', 'sys_normal_disable', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '系统开关列表');
INSERT INTO `sys_dict_type` VALUES (4, '任务状态', 'sys_job_status', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '任务状态列表');
INSERT INTO `sys_dict_type` VALUES (5, '任务分组', 'sys_job_group', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '任务分组列表');
INSERT INTO `sys_dict_type` VALUES (6, '系统是否', 'sys_yes_no', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '系统是否列表');
INSERT INTO `sys_dict_type` VALUES (7, '通知类型', 'sys_notice_type', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '通知类型列表');
INSERT INTO `sys_dict_type` VALUES (8, '通知状态', 'sys_notice_status', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '通知状态列表');
INSERT INTO `sys_dict_type` VALUES (9, '操作类型', 'sys_oper_type', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '操作类型列表');
INSERT INTO `sys_dict_type` VALUES (10, '系统状态', 'sys_common_status', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '登录状态列表');

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job`  (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'DEFAULT' COMMENT '任务组名',
  `invoke_target` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '调用目标字符串',
  `cron_expression` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
  `concurrent` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`job_id`, `job_name`, `job_group`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '定时任务调度表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_job
-- ----------------------------
INSERT INTO `sys_job` VALUES (1, '系统默认（无参）', 'DEFAULT', 'ryTask.ryNoParams', '0/10 * * * * ?', '3', '1', '1', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_job` VALUES (2, '系统默认（有参）', 'DEFAULT', 'ryTask.ryParams(\'ry\')', '0/15 * * * * ?', '3', '1', '1', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_job` VALUES (3, '系统默认（多参）', 'DEFAULT', 'ryTask.ryMultipleParams(\'ry\', true, 2000L, 316.50D, 100)', '0/20 * * * * ?', '3', '1', '1', 'admin', '2022-11-28 13:24:47', '', NULL, '');

-- ----------------------------
-- Table structure for sys_job_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_job_log`;
CREATE TABLE `sys_job_log`  (
  `job_log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '任务组名',
  `invoke_target` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '调用目标字符串',
  `job_message` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '日志信息',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '异常信息',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '定时任务调度日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_logininfor
-- ----------------------------
DROP TABLE IF EXISTS `sys_logininfor`;
CREATE TABLE `sys_logininfor`  (
  `info_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '访问ID',
  `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '用户账号',
  `ipaddr` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '操作系统',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '提示消息',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`info_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 117 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统访问记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_logininfor
-- ----------------------------
INSERT INTO `sys_logininfor` VALUES (100, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-11-28 13:34:16');
INSERT INTO `sys_logininfor` VALUES (101, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-11-28 15:23:40');
INSERT INTO `sys_logininfor` VALUES (102, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-11-29 14:04:39');
INSERT INTO `sys_logininfor` VALUES (103, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 13:51:56');
INSERT INTO `sys_logininfor` VALUES (104, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-03 15:56:19');
INSERT INTO `sys_logininfor` VALUES (105, 'common', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '1', '登录用户：common 不存在', '2022-12-03 15:56:29');
INSERT INTO `sys_logininfor` VALUES (106, 'common', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '1', '登录用户：common 不存在', '2022-12-03 15:56:30');
INSERT INTO `sys_logininfor` VALUES (107, 'common', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '1', '登录用户：common 不存在', '2022-12-03 15:56:31');
INSERT INTO `sys_logininfor` VALUES (108, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 15:56:46');
INSERT INTO `sys_logininfor` VALUES (109, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-03 15:59:12');
INSERT INTO `sys_logininfor` VALUES (110, 'ry', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 15:59:18');
INSERT INTO `sys_logininfor` VALUES (111, 'ry', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '退出成功', '2022-12-03 15:59:31');
INSERT INTO `sys_logininfor` VALUES (112, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-03 16:00:34');
INSERT INTO `sys_logininfor` VALUES (113, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-05 19:09:26');
INSERT INTO `sys_logininfor` VALUES (114, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 11:33:47');
INSERT INTO `sys_logininfor` VALUES (115, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-06 12:44:15');
INSERT INTO `sys_logininfor` VALUES (116, 'admin', '127.0.0.1', '内网IP', 'Chrome 10', 'Windows 10', '0', '登录成功', '2022-12-22 10:10:06');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) NULL DEFAULT 0 COMMENT '父菜单ID',
  `order_num` int(4) NULL DEFAULT 0 COMMENT '显示顺序',
  `path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '组件路径',
  `query` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '路由参数',
  `is_frame` int(1) NULL DEFAULT 1 COMMENT '是否为外链（0是 1否）',
  `is_cache` int(1) NULL DEFAULT 0 COMMENT '是否缓存（0缓存 1不缓存）',
  `menu_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `perms` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2014 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '菜单权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, '系统管理', 0, 4, 'system', NULL, '', 1, 0, 'M', '0', '0', '', 'system', 'admin', '2022-11-28 13:24:47', 'admin', '2022-12-03 16:37:59', '系统管理目录');
INSERT INTO `sys_menu` VALUES (2, '系统监控', 0, 4, 'monitor', NULL, '', 1, 0, 'M', '0', '0', '', 'monitor', 'admin', '2022-11-28 13:24:47', 'admin', '2022-12-03 16:37:44', '系统监控目录');
INSERT INTO `sys_menu` VALUES (3, '系统工具', 0, 4, 'tool', NULL, '', 1, 0, 'M', '0', '0', '', 'tool', 'admin', '2022-11-28 13:24:47', 'admin', '2022-12-03 16:38:06', '系统工具目录');
INSERT INTO `sys_menu` VALUES (4, '若依官网', 0, 4, 'http://ruoyi.vip', NULL, '', 0, 0, 'M', '0', '0', '', 'guide', 'admin', '2022-11-28 13:24:47', '', NULL, '若依官网地址');
INSERT INTO `sys_menu` VALUES (100, '用户管理', 1, 1, 'user', 'system/user/index', '', 1, 0, 'C', '0', '0', 'system:user:list', 'user', 'admin', '2022-11-28 13:24:47', '', NULL, '用户管理菜单');
INSERT INTO `sys_menu` VALUES (101, '角色管理', 1, 2, 'role', 'system/role/index', '', 1, 0, 'C', '0', '0', 'system:role:list', 'peoples', 'admin', '2022-11-28 13:24:47', '', NULL, '角色管理菜单');
INSERT INTO `sys_menu` VALUES (102, '菜单管理', 1, 3, 'menu', 'system/menu/index', '', 1, 0, 'C', '0', '0', 'system:menu:list', 'tree-table', 'admin', '2022-11-28 13:24:47', '', NULL, '菜单管理菜单');
INSERT INTO `sys_menu` VALUES (103, '部门管理', 1, 4, 'dept', 'system/dept/index', '', 1, 0, 'C', '0', '0', 'system:dept:list', 'tree', 'admin', '2022-11-28 13:24:47', '', NULL, '部门管理菜单');
INSERT INTO `sys_menu` VALUES (104, '岗位管理', 1, 5, 'post', 'system/post/index', '', 1, 0, 'C', '0', '0', 'system:post:list', 'post', 'admin', '2022-11-28 13:24:47', '', NULL, '岗位管理菜单');
INSERT INTO `sys_menu` VALUES (105, '字典管理', 1, 6, 'dict', 'system/dict/index', '', 1, 0, 'C', '0', '0', 'system:dict:list', 'dict', 'admin', '2022-11-28 13:24:47', '', NULL, '字典管理菜单');
INSERT INTO `sys_menu` VALUES (106, '参数设置', 1, 7, 'config', 'system/config/index', '', 1, 0, 'C', '0', '0', 'system:config:list', 'edit', 'admin', '2022-11-28 13:24:47', '', NULL, '参数设置菜单');
INSERT INTO `sys_menu` VALUES (107, '通知公告', 1, 8, 'notice', 'system/notice/index', '', 1, 0, 'C', '0', '0', 'system:notice:list', 'message', 'admin', '2022-11-28 13:24:47', '', NULL, '通知公告菜单');
INSERT INTO `sys_menu` VALUES (108, '日志管理', 1, 9, 'log', '', '', 1, 0, 'M', '0', '0', '', 'log', 'admin', '2022-11-28 13:24:47', '', NULL, '日志管理菜单');
INSERT INTO `sys_menu` VALUES (109, '在线用户', 2, 1, 'online', 'monitor/online/index', '', 1, 0, 'C', '0', '0', 'monitor:online:list', 'online', 'admin', '2022-11-28 13:24:47', '', NULL, '在线用户菜单');
INSERT INTO `sys_menu` VALUES (110, '定时任务', 2, 2, 'job', 'monitor/job/index', '', 1, 0, 'C', '0', '0', 'monitor:job:list', 'job', 'admin', '2022-11-28 13:24:47', '', NULL, '定时任务菜单');
INSERT INTO `sys_menu` VALUES (111, '数据监控', 2, 3, 'druid', 'monitor/druid/index', '', 1, 0, 'C', '0', '0', 'monitor:druid:list', 'druid', 'admin', '2022-11-28 13:24:47', '', NULL, '数据监控菜单');
INSERT INTO `sys_menu` VALUES (112, '服务监控', 2, 4, 'server', 'monitor/server/index', '', 1, 0, 'C', '0', '0', 'monitor:server:list', 'server', 'admin', '2022-11-28 13:24:47', '', NULL, '服务监控菜单');
INSERT INTO `sys_menu` VALUES (113, '缓存监控', 2, 5, 'cache', 'monitor/cache/index', '', 1, 0, 'C', '0', '0', 'monitor:cache:list', 'redis', 'admin', '2022-11-28 13:24:47', '', NULL, '缓存监控菜单');
INSERT INTO `sys_menu` VALUES (114, '表单构建', 3, 1, 'build', 'tool/build/index', '', 1, 0, 'C', '0', '0', 'tool:build:list', 'build', 'admin', '2022-11-28 13:24:47', '', NULL, '表单构建菜单');
INSERT INTO `sys_menu` VALUES (115, '代码生成', 3, 2, 'gen', 'tool/gen/index', '', 1, 0, 'C', '0', '0', 'tool:gen:list', 'code', 'admin', '2022-11-28 13:24:47', '', NULL, '代码生成菜单');
INSERT INTO `sys_menu` VALUES (116, '系统接口', 3, 3, 'swagger', 'tool/swagger/index', '', 1, 0, 'C', '0', '0', 'tool:swagger:list', 'swagger', 'admin', '2022-11-28 13:24:47', '', NULL, '系统接口菜单');
INSERT INTO `sys_menu` VALUES (500, '操作日志', 108, 1, 'operlog', 'monitor/operlog/index', '', 1, 0, 'C', '0', '0', 'monitor:operlog:list', 'form', 'admin', '2022-11-28 13:24:47', '', NULL, '操作日志菜单');
INSERT INTO `sys_menu` VALUES (501, '登录日志', 108, 2, 'logininfor', 'monitor/logininfor/index', '', 1, 0, 'C', '0', '0', 'monitor:logininfor:list', 'logininfor', 'admin', '2022-11-28 13:24:47', '', NULL, '登录日志菜单');
INSERT INTO `sys_menu` VALUES (1001, '用户查询', 100, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:user:query', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1002, '用户新增', 100, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:user:add', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1003, '用户修改', 100, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:user:edit', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1004, '用户删除', 100, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:user:remove', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1005, '用户导出', 100, 5, '', '', '', 1, 0, 'F', '0', '0', 'system:user:export', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1006, '用户导入', 100, 6, '', '', '', 1, 0, 'F', '0', '0', 'system:user:import', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1007, '重置密码', 100, 7, '', '', '', 1, 0, 'F', '0', '0', 'system:user:resetPwd', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1008, '角色查询', 101, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:role:query', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1009, '角色新增', 101, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:role:add', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1010, '角色修改', 101, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:role:edit', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1011, '角色删除', 101, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:role:remove', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1012, '角色导出', 101, 5, '', '', '', 1, 0, 'F', '0', '0', 'system:role:export', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1013, '菜单查询', 102, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:query', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1014, '菜单新增', 102, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:add', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1015, '菜单修改', 102, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:edit', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1016, '菜单删除', 102, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:menu:remove', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1017, '部门查询', 103, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:query', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1018, '部门新增', 103, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:add', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1019, '部门修改', 103, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:edit', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1020, '部门删除', 103, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:dept:remove', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1021, '岗位查询', 104, 1, '', '', '', 1, 0, 'F', '0', '0', 'system:post:query', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1022, '岗位新增', 104, 2, '', '', '', 1, 0, 'F', '0', '0', 'system:post:add', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1023, '岗位修改', 104, 3, '', '', '', 1, 0, 'F', '0', '0', 'system:post:edit', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1024, '岗位删除', 104, 4, '', '', '', 1, 0, 'F', '0', '0', 'system:post:remove', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1025, '岗位导出', 104, 5, '', '', '', 1, 0, 'F', '0', '0', 'system:post:export', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1026, '字典查询', 105, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:query', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1027, '字典新增', 105, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:add', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1028, '字典修改', 105, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:edit', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1029, '字典删除', 105, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:remove', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1030, '字典导出', 105, 5, '#', '', '', 1, 0, 'F', '0', '0', 'system:dict:export', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1031, '参数查询', 106, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:query', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1032, '参数新增', 106, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:add', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1033, '参数修改', 106, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:edit', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1034, '参数删除', 106, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:remove', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1035, '参数导出', 106, 5, '#', '', '', 1, 0, 'F', '0', '0', 'system:config:export', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1036, '公告查询', 107, 1, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:query', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1037, '公告新增', 107, 2, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:add', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1038, '公告修改', 107, 3, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:edit', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1039, '公告删除', 107, 4, '#', '', '', 1, 0, 'F', '0', '0', 'system:notice:remove', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1040, '操作查询', 500, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:query', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1041, '操作删除', 500, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:remove', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1042, '日志导出', 500, 4, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:operlog:export', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1043, '登录查询', 501, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:query', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1044, '登录删除', 501, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:remove', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1045, '日志导出', 501, 3, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:logininfor:export', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1046, '在线查询', 109, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:query', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1047, '批量强退', 109, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:batchLogout', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1048, '单条强退', 109, 3, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:online:forceLogout', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1049, '任务查询', 110, 1, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:query', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1050, '任务新增', 110, 2, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:add', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1051, '任务修改', 110, 3, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:edit', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1052, '任务删除', 110, 4, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:remove', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1053, '状态修改', 110, 5, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:changeStatus', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1054, '任务导出', 110, 7, '#', '', '', 1, 0, 'F', '0', '0', 'monitor:job:export', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1055, '生成查询', 115, 1, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:query', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1056, '生成修改', 115, 2, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:edit', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1057, '生成删除', 115, 3, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:remove', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1058, '导入代码', 115, 2, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:import', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1059, '预览代码', 115, 4, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:preview', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (1060, '生成代码', 115, 5, '#', '', '', 1, 0, 'F', '0', '0', 'tool:gen:code', '#', 'admin', '2022-11-28 13:24:47', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2000, '案件管理', 0, 1, 'case', 'case/index', NULL, 1, 0, 'C', '0', '0', '', 'form', 'admin', '2022-12-03 16:25:33', 'admin', '2022-12-03 16:29:58', '');
INSERT INTO `sys_menu` VALUES (2001, '知识管理', 0, 2, 'knowledge', NULL, NULL, 1, 0, 'M', '0', '0', NULL, 'dict', 'admin', '2022-12-03 16:37:17', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2002, '专项知识库', 2001, 1, 'knowledge/special', 'knowledge/special/index', NULL, 1, 0, 'C', '0', '0', '', '#', 'admin', '2022-12-03 16:43:14', 'admin', '2022-12-03 16:43:57', '');
INSERT INTO `sys_menu` VALUES (2003, '安全知识库', 2001, 2, 'knowledge/security', 'knowledge/security/index', NULL, 1, 0, 'C', '0', '0', NULL, '#', 'admin', '2022-12-03 16:45:03', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2004, '通用知识库', 2001, 3, 'knowledge/knowledge', 'knowledge/knowledge/index', NULL, 1, 0, 'C', '0', '0', NULL, '#', 'admin', '2022-12-03 16:46:01', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2005, '灾情类型', 2001, 4, 'knowledge/disastertype', 'knowledge/disastertype/index', NULL, 1, 0, 'C', '0', '0', NULL, '#', 'admin', '2022-12-03 16:46:57', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2006, '处置对象', 2001, 5, 'knowledge/disposeobj', 'knowledge/disposeobj/index', NULL, 1, 0, 'C', '0', '0', NULL, '#', 'admin', '2022-12-03 16:47:58', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2007, '详细类型表', 2001, 6, 'knowledge/detailtype', 'knowledge/detailtype/index', NULL, 1, 0, 'C', '0', '0', NULL, '#', 'admin', '2022-12-03 16:48:46', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2008, '规则表', 2001, 7, 'knowledge/rule', 'knowledge/rule/index', NULL, 1, 0, 'C', '0', '0', NULL, '#', 'admin', '2022-12-03 16:49:20', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2009, '历史表', 2001, 8, 'knowledge/history', 'knowledge/history/index', NULL, 1, 0, 'C', '0', '0', '', '#', 'admin', '2022-12-03 16:49:45', 'admin', '2022-12-03 16:51:12', '');
INSERT INTO `sys_menu` VALUES (2010, '人员管理', 0, 3, 'information', NULL, NULL, 1, 0, 'M', '0', '0', NULL, 'peoples', 'admin', '2022-12-03 16:52:07', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2011, '用户信息', 2010, 1, 'information/userinfo', 'information/userinfo/index', NULL, 1, 0, 'C', '0', '0', NULL, '#', 'admin', '2022-12-03 16:52:50', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2012, '队站信息', 2010, 2, 'information/site', 'information/site/index', NULL, 1, 0, 'C', '0', '0', NULL, '#', 'admin', '2022-12-03 16:56:18', '', NULL, '');
INSERT INTO `sys_menu` VALUES (2013, '岗位信息', 2010, 3, 'information/userposition', 'information/userposition/index', NULL, 1, 0, 'C', '0', '0', NULL, '#', 'admin', '2022-12-03 16:57:21', '', NULL, '');

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice`  (
  `notice_id` int(4) NOT NULL AUTO_INCREMENT COMMENT '公告ID',
  `notice_title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '公告标题',
  `notice_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '公告类型（1通知 2公告）',
  `notice_content` longblob NULL COMMENT '公告内容',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '公告状态（0正常 1关闭）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`notice_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '通知公告表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_notice
-- ----------------------------
INSERT INTO `sys_notice` VALUES (1, '温馨提醒：2018-07-01 若依新版本发布啦', '2', 0xE696B0E78988E69CACE58685E5AEB9, '0', 'admin', '2022-11-28 13:24:47', '', NULL, '管理员');
INSERT INTO `sys_notice` VALUES (2, '维护通知：2018-07-01 若依系统凌晨维护', '1', 0xE7BBB4E68AA4E58685E5AEB9, '0', 'admin', '2022-11-28 13:24:47', '', NULL, '管理员');

-- ----------------------------
-- Table structure for sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log`;
CREATE TABLE `sys_oper_log`  (
  `oper_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '模块标题',
  `business_type` int(2) NULL DEFAULT 0 COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '请求方式',
  `operator_type` int(1) NULL DEFAULT 0 COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '请求参数',
  `json_result` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '返回参数',
  `status` int(1) NULL DEFAULT 0 COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`oper_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 128 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '操作日志记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_oper_log
-- ----------------------------
INSERT INTO `sys_oper_log` VALUES (100, '菜单管理', 1, 'com.ruoyi.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"form\",\"orderNum\":\"1\",\"menuName\":\"案件管理\",\"params\":{},\"parentId\":0,\"isCache\":\"0\",\"path\":\"/case\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"M\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 16:25:33');
INSERT INTO `sys_oper_log` VALUES (101, '菜单管理', 2, 'com.ruoyi.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"form\",\"orderNum\":\"1\",\"menuName\":\"案件管理\",\"params\":{},\"parentId\":0,\"isCache\":\"0\",\"path\":\"/case\",\"children\":[],\"createTime\":1670055933000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":2000,\"menuType\":\"C\",\"perms\":\"\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 16:26:26');
INSERT INTO `sys_oper_log` VALUES (102, '菜单管理', 2, 'com.ruoyi.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"form\",\"orderNum\":\"1\",\"menuName\":\"案件管理\",\"params\":{},\"parentId\":0,\"isCache\":\"0\",\"path\":\"/case\",\"component\":\"/case\",\"children\":[],\"createTime\":1670055933000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":2000,\"menuType\":\"C\",\"perms\":\"\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 16:26:41');
INSERT INTO `sys_oper_log` VALUES (103, '菜单管理', 2, 'com.ruoyi.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"form\",\"orderNum\":\"1\",\"menuName\":\"案件管理\",\"params\":{},\"parentId\":0,\"isCache\":\"0\",\"path\":\"case\",\"component\":\"\",\"children\":[],\"createTime\":1670055933000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":2000,\"menuType\":\"C\",\"perms\":\"\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 16:27:06');
INSERT INTO `sys_oper_log` VALUES (104, '菜单管理', 2, 'com.ruoyi.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"form\",\"orderNum\":\"1\",\"menuName\":\"案件管理\",\"params\":{},\"parentId\":0,\"isCache\":\"0\",\"path\":\"case\",\"component\":\"\",\"children\":[],\"createTime\":1670055933000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":2000,\"menuType\":\"M\",\"perms\":\"\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 16:27:42');
INSERT INTO `sys_oper_log` VALUES (105, '菜单管理', 2, 'com.ruoyi.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"form\",\"orderNum\":\"1\",\"menuName\":\"案件管理\",\"params\":{},\"parentId\":0,\"isCache\":\"0\",\"path\":\"case\",\"component\":\"case/index\",\"children\":[],\"createTime\":1670055933000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":2000,\"menuType\":\"C\",\"perms\":\"\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 16:29:58');
INSERT INTO `sys_oper_log` VALUES (106, '菜单管理', 2, 'com.ruoyi.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"query\":\"\",\"icon\":\"system\",\"orderNum\":\"2\",\"menuName\":\"系统管理\",\"params\":{},\"parentId\":0,\"isCache\":\"0\",\"path\":\"system\",\"children\":[],\"createTime\":1669613087000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1,\"menuType\":\"M\",\"perms\":\"\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 16:32:10');
INSERT INTO `sys_oper_log` VALUES (107, '菜单管理', 1, 'com.ruoyi.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"dict\",\"orderNum\":\"2\",\"menuName\":\"知识管理\",\"params\":{},\"parentId\":0,\"isCache\":\"0\",\"path\":\"knowledge\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"M\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 16:37:17');
INSERT INTO `sys_oper_log` VALUES (108, '菜单管理', 2, 'com.ruoyi.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"query\":\"\",\"icon\":\"system\",\"orderNum\":\"3\",\"menuName\":\"系统管理\",\"params\":{},\"parentId\":0,\"isCache\":\"0\",\"path\":\"system\",\"children\":[],\"createTime\":1669613087000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1,\"menuType\":\"M\",\"perms\":\"\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 16:37:31');
INSERT INTO `sys_oper_log` VALUES (109, '菜单管理', 2, 'com.ruoyi.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"query\":\"\",\"icon\":\"monitor\",\"orderNum\":\"4\",\"menuName\":\"系统监控\",\"params\":{},\"parentId\":0,\"isCache\":\"0\",\"path\":\"monitor\",\"children\":[],\"createTime\":1669613087000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":2,\"menuType\":\"M\",\"perms\":\"\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 16:37:44');
INSERT INTO `sys_oper_log` VALUES (110, '菜单管理', 3, 'com.ruoyi.web.controller.system.SysMenuController.remove()', 'DELETE', 1, 'admin', NULL, '/system/menu/4', '127.0.0.1', '内网IP', '{menuId=4}', '{\"msg\":\"菜单已分配,不允许删除\",\"code\":500}', 0, NULL, '2022-12-03 16:37:54');
INSERT INTO `sys_oper_log` VALUES (111, '菜单管理', 2, 'com.ruoyi.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"query\":\"\",\"icon\":\"system\",\"orderNum\":\"4\",\"menuName\":\"系统管理\",\"params\":{},\"parentId\":0,\"isCache\":\"0\",\"path\":\"system\",\"children\":[],\"createTime\":1669613087000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":1,\"menuType\":\"M\",\"perms\":\"\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 16:37:59');
INSERT INTO `sys_oper_log` VALUES (112, '菜单管理', 2, 'com.ruoyi.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"query\":\"\",\"icon\":\"tool\",\"orderNum\":\"4\",\"menuName\":\"系统工具\",\"params\":{},\"parentId\":0,\"isCache\":\"0\",\"path\":\"tool\",\"children\":[],\"createTime\":1669613087000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":3,\"menuType\":\"M\",\"perms\":\"\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 16:38:06');
INSERT INTO `sys_oper_log` VALUES (113, '菜单管理', 1, 'com.ruoyi.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"orderNum\":\"1\",\"menuName\":\"专项知识库\",\"params\":{},\"parentId\":2001,\"isCache\":\"0\",\"path\":\"knowledge/special\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"M\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 16:43:14');
INSERT INTO `sys_oper_log` VALUES (114, '菜单管理', 2, 'com.ruoyi.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"#\",\"orderNum\":\"1\",\"menuName\":\"专项知识库\",\"params\":{},\"parentId\":2001,\"isCache\":\"0\",\"path\":\"knowledge/special\",\"component\":\"knowledge/special/index\",\"children\":[],\"createTime\":1670056994000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":2002,\"menuType\":\"C\",\"perms\":\"\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 16:43:57');
INSERT INTO `sys_oper_log` VALUES (115, '菜单管理', 1, 'com.ruoyi.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"orderNum\":\"2\",\"menuName\":\"安全知识库\",\"params\":{},\"parentId\":2001,\"isCache\":\"0\",\"path\":\"knowledge/security\",\"component\":\"knowledge/security/index\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"C\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 16:45:03');
INSERT INTO `sys_oper_log` VALUES (116, '菜单管理', 1, 'com.ruoyi.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"orderNum\":\"3\",\"menuName\":\"通用知识库\",\"params\":{},\"parentId\":2001,\"isCache\":\"0\",\"path\":\"knowledge/knowledge\",\"component\":\"knowledge/knowledge/index\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"C\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 16:46:01');
INSERT INTO `sys_oper_log` VALUES (117, '菜单管理', 1, 'com.ruoyi.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"orderNum\":\"4\",\"menuName\":\"灾情类型\",\"params\":{},\"parentId\":2001,\"isCache\":\"0\",\"path\":\"knowledge/disastertype\",\"component\":\"knowledge/disastertype/index\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"C\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 16:46:57');
INSERT INTO `sys_oper_log` VALUES (118, '菜单管理', 1, 'com.ruoyi.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"orderNum\":\"5\",\"menuName\":\"处置对象\",\"params\":{},\"parentId\":2001,\"isCache\":\"0\",\"path\":\"knowledge/disposeobj\",\"component\":\"knowledge/disposeobj/index\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"C\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 16:47:58');
INSERT INTO `sys_oper_log` VALUES (119, '菜单管理', 1, 'com.ruoyi.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"orderNum\":\"6\",\"menuName\":\"详细类型表\",\"params\":{},\"parentId\":2001,\"isCache\":\"0\",\"path\":\"knowledge/detailtype\",\"component\":\"knowledge/detailtype/index\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"C\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 16:48:46');
INSERT INTO `sys_oper_log` VALUES (120, '菜单管理', 1, 'com.ruoyi.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"orderNum\":\"7\",\"menuName\":\"规则表\",\"params\":{},\"parentId\":2001,\"isCache\":\"0\",\"path\":\"knowledge/rule\",\"component\":\"knowledge/rule/index\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"C\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 16:49:20');
INSERT INTO `sys_oper_log` VALUES (121, '菜单管理', 1, 'com.ruoyi.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"orderNum\":\"8\",\"menuName\":\"历史表\",\"params\":{},\"parentId\":2001,\"isCache\":\"0\",\"path\":\"knowledge/record\",\"component\":\"knowledge/record/index\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"C\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 16:49:45');
INSERT INTO `sys_oper_log` VALUES (122, '菜单管理', 2, 'com.ruoyi.web.controller.system.SysMenuController.edit()', 'PUT', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"#\",\"orderNum\":\"8\",\"menuName\":\"历史表\",\"params\":{},\"parentId\":2001,\"isCache\":\"0\",\"path\":\"knowledge/history\",\"component\":\"knowledge/history/index\",\"children\":[],\"createTime\":1670057385000,\"updateBy\":\"admin\",\"isFrame\":\"1\",\"menuId\":2009,\"menuType\":\"C\",\"perms\":\"\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 16:51:12');
INSERT INTO `sys_oper_log` VALUES (123, '菜单管理', 1, 'com.ruoyi.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"icon\":\"peoples\",\"orderNum\":\"3\",\"menuName\":\"人员管理\",\"params\":{},\"parentId\":0,\"isCache\":\"0\",\"path\":\"information\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"M\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 16:52:07');
INSERT INTO `sys_oper_log` VALUES (124, '菜单管理', 1, 'com.ruoyi.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"orderNum\":\"1\",\"menuName\":\"用户信息\",\"params\":{},\"parentId\":2010,\"isCache\":\"0\",\"path\":\"information/userinfo\",\"component\":\"information/userinfo/index\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"C\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 16:52:50');
INSERT INTO `sys_oper_log` VALUES (125, '菜单管理', 1, 'com.ruoyi.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"orderNum\":\"2\",\"menuName\":\"队站信息\",\"params\":{},\"parentId\":2010,\"isCache\":\"0\",\"path\":\"information/site\",\"component\":\"information/site/index\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"C\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 16:56:18');
INSERT INTO `sys_oper_log` VALUES (126, '菜单管理', 1, 'com.ruoyi.web.controller.system.SysMenuController.add()', 'POST', 1, 'admin', NULL, '/system/menu', '127.0.0.1', '内网IP', '{\"visible\":\"0\",\"orderNum\":\"3\",\"menuName\":\"岗位信息\",\"params\":{},\"parentId\":2010,\"isCache\":\"0\",\"path\":\"information/userposition\",\"component\":\"information/userposition/index\",\"createBy\":\"admin\",\"children\":[],\"isFrame\":\"1\",\"menuType\":\"C\",\"status\":\"0\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-03 16:57:21');
INSERT INTO `sys_oper_log` VALUES (127, '通用知识库', 2, 'com.ruoyi.web.controller.knowledge.KnowledgeController.edit()', 'PUT', 1, 'admin', NULL, '/knowledge/knowledge', '127.0.0.1', '内网IP', '{\"detailtype\":9,\"librarytype\":1,\"inform\":\"发生火灾\",\"weight\":1,\"informid\":1,\"params\":{},\"informtypeid\":1}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-06 13:00:46');
INSERT INTO `sys_oper_log` VALUES (128, '出警记录表', 2, 'com.ruoyi.web.controller.knowledge.RecordController.edit()', 'PUT', 1, 'admin', NULL, '/knowledge/record', '127.0.0.1', '内网IP', '{\"truckid\":1,\"detailtype\":1,\"siteid2List\":[\"1\"],\"keywords\":\"text\",\"dillobject\":1,\"cautiontime\":1670131835000,\"cautionid\":\"001\",\"params\":{},\"picture\":\"\",\"distypeid\":1,\"siteid\":1,\"location\":\"宝山\",\"status\":0}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-06 14:58:35');
INSERT INTO `sys_oper_log` VALUES (129, '用户信息', 1, 'com.ruoyi.web.controller.information.UserInfoController.add()', 'POST', 1, 'admin', NULL, '/information/userinfo', '127.0.0.1', '内网IP', '{\"gender\":1,\"openid\":\"213132\",\"params\":{},\"userid\":\"3213213\",\"positionid\":1,\"siteid\":1,\"tele\":\"123584844\",\"age\":26,\"status\":1,\"username\":\"小明\"}', 'null', 1, '\r\n### Error updating database.  Cause: java.sql.SQLException: Field \'id\' doesn\'t have a default value\r\n### The error may exist in file [F:\\2022\\910实验室\\消防项目\\2021-AssisDeciSys\\RuoYi-Vue-master\\ruoyi-system\\target\\classes\\mapper\\information\\UserInfoMapper.xml]\r\n### The error may involve com.ruoyi.information.mapper.UserInfoMapper.insertUserInfo-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into UserInfo          ( tele,             username,             gender,             age,             positionID,                          siteID,                                                    status,             openid,             userid )           values ( ?,             ?,             ?,             ?,             ?,                          ?,                                                    ?,             ?,             ? )\r\n### Cause: java.sql.SQLException: Field \'id\' doesn\'t have a default value\n; Field \'id\' doesn\'t have a default value; nested exception is java.sql.SQLException: Field \'id\' doesn\'t have a default value', '2022-12-22 11:27:47');
INSERT INTO `sys_oper_log` VALUES (130, '用户信息', 1, 'com.ruoyi.web.controller.information.UserInfoController.add()', 'POST', 1, 'admin', NULL, '/information/userinfo', '127.0.0.1', '内网IP', '{\"gender\":1,\"openid\":\"213132\",\"params\":{},\"userid\":\"3213213\",\"positionid\":1,\"siteid\":1,\"tele\":\"123584844\",\"age\":26,\"status\":1,\"username\":\"小明\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-22 11:29:36');
INSERT INTO `sys_oper_log` VALUES (131, '用户信息', 2, 'com.ruoyi.web.controller.information.UserInfoController.edit()', 'PUT', 1, 'admin', NULL, '/information/userinfo', '127.0.0.1', '内网IP', '{\"gender\":1,\"openid\":\"213132\",\"params\":{},\"userid\":\"3213213\",\"positionid\":1,\"siteid\":1,\"id\":2,\"tele\":\"123584844\",\"age\":26,\"status\":1,\"username\":\"小明\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-22 11:29:52');
INSERT INTO `sys_oper_log` VALUES (132, '用户信息', 2, 'com.ruoyi.web.controller.information.UserInfoController.edit()', 'PUT', 1, 'admin', NULL, '/information/userinfo', '127.0.0.1', '内网IP', '{\"truckid\":1,\"gender\":1,\"openid\":\"openid\",\"params\":{},\"userid\":\"useid\",\"password\":\"123\",\"positionid\":1,\"adminid\":1,\"siteid\":1,\"id\":1,\"tele\":\"18516291129\",\"account\":\"chenjiaqi\",\"age\":1670428800000,\"status\":0,\"username\":\"陈佳琪\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-22 11:40:36');
INSERT INTO `sys_oper_log` VALUES (133, '用户信息', 2, 'com.ruoyi.web.controller.information.UserInfoController.edit()', 'PUT', 1, 'admin', NULL, '/information/userinfo', '127.0.0.1', '内网IP', '{\"truckid\":1,\"gender\":1,\"openid\":\"openid\",\"params\":{},\"userid\":\"useid\",\"password\":\"123\",\"positionid\":1,\"adminid\":1,\"siteid\":1,\"id\":1,\"tele\":\"18516291129\",\"account\":\"chenjiaqi\",\"age\":674146800000,\"status\":0,\"username\":\"陈佳琪\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-22 11:40:50');
INSERT INTO `sys_oper_log` VALUES (134, '用户信息', 2, 'com.ruoyi.web.controller.information.UserInfoController.edit()', 'PUT', 1, 'admin', NULL, '/information/userinfo', '127.0.0.1', '内网IP', '{\"gender\":1,\"openid\":\"213132\",\"params\":{},\"userid\":\"3213213\",\"positionid\":1,\"siteid\":1,\"id\":2,\"tele\":\"123584844\",\"age\":408038400000,\"status\":1,\"username\":\"小明\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-22 11:41:01');
INSERT INTO `sys_oper_log` VALUES (135, '队站信息', 1, 'com.ruoyi.web.controller.information.SiteController.add()', 'POST', 1, 'admin', NULL, '/information/site', '127.0.0.1', '内网IP', '{\"siteposition\":\"上海学源路\",\"sitename\":\"test\",\"params\":{},\"tele\":\"12313545\"}', 'null', 1, '\r\n### Error updating database.  Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'01\' for key \'PRIMARY\'\r\n### The error may exist in file [F:\\2022\\910实验室\\消防项目\\2021-AssisDeciSys\\RuoYi-Vue-master\\ruoyi-system\\target\\classes\\mapper\\information\\SiteMapper.xml]\r\n### The error may involve com.ruoyi.information.mapper.SiteMapper.insertSite-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into Site          ( sitename,             siteposition,             tele )           values ( ?,             ?,             ? )\r\n### Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'01\' for key \'PRIMARY\'\n; Duplicate entry \'01\' for key \'PRIMARY\'; nested exception is java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'01\' for key \'PRIMARY\'', '2022-12-22 11:41:46');
INSERT INTO `sys_oper_log` VALUES (136, '队站信息', 1, 'com.ruoyi.web.controller.information.SiteController.add()', 'POST', 1, 'admin', NULL, '/information/site', '127.0.0.1', '内网IP', '{\"siteposition\":\"大场镇\",\"sitename\":\"大场\",\"params\":{},\"tele\":\"119\"}', 'null', 1, '\r\n### Error updating database.  Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'02\' for key \'PRIMARY\'\r\n### The error may exist in file [F:\\2022\\910实验室\\消防项目\\2021-AssisDeciSys\\RuoYi-Vue-master\\ruoyi-system\\target\\classes\\mapper\\information\\SiteMapper.xml]\r\n### The error may involve com.ruoyi.information.mapper.SiteMapper.insertSite-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into Site          ( sitename,             siteposition,             tele )           values ( ?,             ?,             ? )\r\n### Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'02\' for key \'PRIMARY\'\n; Duplicate entry \'02\' for key \'PRIMARY\'; nested exception is java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'02\' for key \'PRIMARY\'', '2022-12-22 12:46:42');
INSERT INTO `sys_oper_log` VALUES (137, '队站信息', 1, 'com.ruoyi.web.controller.information.SiteController.add()', 'POST', 1, 'admin', NULL, '/information/site', '127.0.0.1', '内网IP', '{\"siteposition\":\"大场镇\",\"sitename\":\"大场\",\"siteid\":3,\"params\":{},\"tele\":\"119\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-22 12:46:57');
INSERT INTO `sys_oper_log` VALUES (138, '队站信息', 1, 'com.ruoyi.web.controller.information.SiteController.add()', 'POST', 1, 'admin', NULL, '/information/site', '127.0.0.1', '内网IP', '{\"siteposition\":\"顾村镇\",\"sitename\":\"顾村站\",\"siteid\":4,\"params\":{},\"tele\":\"123456\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-22 12:47:47');
INSERT INTO `sys_oper_log` VALUES (139, '岗位信息表管理', 2, 'com.ruoyi.web.controller.information.UserPositionController.edit()', 'PUT', 1, 'admin', NULL, '/information/userposition', '127.0.0.1', '内网IP', '{\"positionid\":1,\"positionname\":\"指挥员\",\"params\":{}}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-22 12:50:05');
INSERT INTO `sys_oper_log` VALUES (140, '岗位信息表管理', 2, 'com.ruoyi.web.controller.information.UserPositionController.edit()', 'PUT', 1, 'admin', NULL, '/information/userposition', '127.0.0.1', '内网IP', '{\"positionid\":1,\"positionname\":\"指挥员\",\"params\":{}}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-22 12:50:22');
INSERT INTO `sys_oper_log` VALUES (141, '队站信息', 2, 'com.ruoyi.web.controller.information.SiteController.edit()', 'PUT', 1, 'admin', NULL, '/information/site', '127.0.0.1', '内网IP', '{\"siteposition\":\"顾村镇\",\"sitename\":\"顾村站\",\"siteid\":4,\"params\":{},\"tele\":\"12345\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-22 12:50:44');
INSERT INTO `sys_oper_log` VALUES (142, '队站信息', 1, 'com.ruoyi.web.controller.information.SiteController.add()', 'POST', 1, 'admin', NULL, '/information/site', '127.0.0.1', '内网IP', '{\"siteposition\":\"大场镇\",\"sitename\":\"大场\",\"siteid\":5,\"params\":{},\"tele\":\"119\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-22 12:57:24');
INSERT INTO `sys_oper_log` VALUES (143, '队站信息', 1, 'com.ruoyi.web.controller.information.SiteController.add()', 'POST', 1, 'admin', NULL, '/information/site', '127.0.0.1', '内网IP', '{\"siteposition\":\"大场镇\",\"sitename\":\"大场\",\"siteid\":1,\"params\":{},\"tele\":\"119\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-22 12:59:00');
INSERT INTO `sys_oper_log` VALUES (144, '队站信息', 1, 'com.ruoyi.web.controller.information.SiteController.add()', 'POST', 1, 'admin', NULL, '/information/site', '127.0.0.1', '内网IP', '{\"siteposition\":\"顾村镇\",\"sitename\":\"顾村\",\"siteid\":2,\"params\":{},\"tele\":\"119\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-22 12:59:30');
INSERT INTO `sys_oper_log` VALUES (145, '用户信息', 2, 'com.ruoyi.web.controller.information.UserInfoController.edit()', 'PUT', 1, 'admin', NULL, '/information/userinfo', '127.0.0.1', '内网IP', '{\"gender\":1,\"openid\":\"213132\",\"params\":{},\"userid\":\"3213213\",\"positionid\":1,\"siteid\":2,\"id\":2,\"tele\":\"123584844\",\"age\":408038400000,\"status\":0,\"username\":\"小明\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-22 13:08:18');
INSERT INTO `sys_oper_log` VALUES (146, '用户信息', 2, 'com.ruoyi.web.controller.information.UserInfoController.edit()', 'PUT', 1, 'admin', NULL, '/information/userinfo', '127.0.0.1', '内网IP', '{\"gender\":1,\"openid\":\"213132\",\"params\":{},\"userid\":\"3213213\",\"positionid\":1,\"siteid\":2,\"id\":2,\"tele\":\"119\",\"age\":408038400000,\"status\":0,\"username\":\"小明\"}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-22 13:09:18');
INSERT INTO `sys_oper_log` VALUES (147, '出警记录表', 2, 'com.ruoyi.web.controller.knowledge.RecordController.edit()', 'PUT', 1, 'admin', NULL, '/knowledge/record', '127.0.0.1', '内网IP', '{\"truckid\":1,\"detailtype\":1,\"siteid2List\":[\"1\"],\"keywords\":\"text\",\"dillobject\":1,\"cautiontime\":1670131835000,\"cautionid\":\"001\",\"params\":{},\"picture\":\"\",\"distypeid\":1,\"siteid\":1,\"location\":\"宝山\",\"status\":0}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-22 13:10:41');
INSERT INTO `sys_oper_log` VALUES (148, '出警记录表', 2, 'com.ruoyi.web.controller.knowledge.RecordController.edit()', 'PUT', 1, 'admin', NULL, '/knowledge/record', '127.0.0.1', '内网IP', '{\"truckid\":1,\"detailtype\":1,\"siteid2List\":[\"2\"],\"keywords\":\"text\",\"dillobject\":1,\"cautiontime\":1670131835000,\"cautionid\":\"001\",\"params\":{},\"picture\":\"\",\"distypeid\":1,\"siteid\":1,\"location\":\"宝山\",\"status\":0}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-22 13:10:48');
INSERT INTO `sys_oper_log` VALUES (149, '出警记录表', 2, 'com.ruoyi.web.controller.knowledge.RecordController.edit()', 'PUT', 1, 'admin', NULL, '/knowledge/record', '127.0.0.1', '内网IP', '{\"truckid\":1,\"detailtype\":1,\"siteid2List\":[\"01\",\"1\",\"2\"],\"keywords\":\"加油\",\"dillobject\":1,\"cautiontime\":1670131835000,\"cautionid\":\"1\",\"params\":{},\"picture\":\"\",\"distypeid\":1,\"label4\":1,\"siteid\":1,\"location\":\"宝山\",\"siteid2\":\"01,1,2\",\"status\":0}', 'null', 1, '\r\n### Error updating database.  Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'1\' for key \'PRIMARY\'\r\n### The error may exist in file [F:\\2022\\910实验室\\消防项目\\2021-AssisDeciSys\\RuoYi-Vue-master\\ruoyi-system\\target\\classes\\mapper\\knowledge\\ForceInvolveMapper.xml]\r\n### The error may involve com.ruoyi.knowledge.mapper.ForceInvolveMapper.insertForceInvolve-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into ForceInvolve          ( cautionID,             siteID )           values ( ?,             ? )\r\n### Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'1\' for key \'PRIMARY\'\n; Duplicate entry \'1\' for key \'PRIMARY\'; nested exception is java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'1\' for key \'PRIMARY\'', '2022-12-22 13:23:51');
INSERT INTO `sys_oper_log` VALUES (150, '出警记录表', 2, 'com.ruoyi.web.controller.knowledge.RecordController.edit()', 'PUT', 1, 'admin', NULL, '/knowledge/record', '127.0.0.1', '内网IP', '{\"truckid\":1,\"detailtype\":1,\"siteid2List\":[\"1\",\"2\"],\"keywords\":\"加油\",\"dillobject\":1,\"cautiontime\":1670131835000,\"cautionid\":\"1\",\"params\":{},\"picture\":\"\",\"distypeid\":1,\"label4\":1,\"siteid\":1,\"location\":\"宝山\",\"siteid2\":\"1,2\",\"status\":0}', 'null', 1, '\r\n### Error updating database.  Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'1\' for key \'PRIMARY\'\r\n### The error may exist in file [F:\\2022\\910实验室\\消防项目\\2021-AssisDeciSys\\RuoYi-Vue-master\\ruoyi-system\\target\\classes\\mapper\\knowledge\\ForceInvolveMapper.xml]\r\n### The error may involve com.ruoyi.knowledge.mapper.ForceInvolveMapper.insertForceInvolve-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into ForceInvolve          ( cautionID,             siteID )           values ( ?,             ? )\r\n### Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'1\' for key \'PRIMARY\'\n; Duplicate entry \'1\' for key \'PRIMARY\'; nested exception is java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'1\' for key \'PRIMARY\'', '2022-12-22 13:23:56');
INSERT INTO `sys_oper_log` VALUES (151, '出警记录表', 2, 'com.ruoyi.web.controller.knowledge.RecordController.edit()', 'PUT', 1, 'admin', NULL, '/knowledge/record', '127.0.0.1', '内网IP', '{\"truckid\":1,\"detailtype\":1,\"siteid2List\":[\"01\"],\"keywords\":\"加油\",\"dillobject\":1,\"cautiontime\":1670131835000,\"cautionid\":\"1\",\"params\":{},\"picture\":\"\",\"distypeid\":1,\"label4\":1,\"siteid\":1,\"location\":\"宝山\",\"siteid2\":\"01\",\"status\":0}', 'null', 1, '\r\n### Error updating database.  Cause: java.sql.SQLSyntaxErrorException: Unknown column \'siteID2\' in \'field list\'\r\n### The error may exist in file [F:\\2022\\910实验室\\消防项目\\2021-AssisDeciSys\\RuoYi-Vue-master\\ruoyi-system\\target\\classes\\mapper\\knowledge\\RecordMapper.xml]\r\n### The error may involve com.ruoyi.knowledge.mapper.RecordMapper.updateRecord-Inline\r\n### The error occurred while setting parameters\r\n### SQL: update Record          SET cautiontime = ?,             location = ?,             distypeID = ?,             dillobject = ?,             siteID = ?,             truckID = ?,             detailtype = ?,             picture = ?,             label4 = ?,             status = ?,             keywords = ?,             siteID2 = ?          where cautionID = ?\r\n### Cause: java.sql.SQLSyntaxErrorException: Unknown column \'siteID2\' in \'field list\'\n; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: Unknown column \'siteID2\' in \'field list\'', '2022-12-22 13:25:13');
INSERT INTO `sys_oper_log` VALUES (152, '出警记录表', 2, 'com.ruoyi.web.controller.knowledge.RecordController.edit()', 'PUT', 1, 'admin', NULL, '/knowledge/record', '127.0.0.1', '内网IP', '{\"truckid\":1,\"detailtype\":1,\"siteid2List\":[\"1\"],\"keywords\":\"加油\",\"dillobject\":1,\"cautiontime\":1670131835000,\"cautionid\":\"1\",\"params\":{},\"picture\":\"\",\"distypeid\":1,\"label4\":1,\"siteid\":1,\"location\":\"宝山\",\"siteid2\":\"1\",\"status\":0}', 'null', 1, '\r\n### Error updating database.  Cause: java.sql.SQLSyntaxErrorException: Unknown column \'siteID2\' in \'field list\'\r\n### The error may exist in file [F:\\2022\\910实验室\\消防项目\\2021-AssisDeciSys\\RuoYi-Vue-master\\ruoyi-system\\target\\classes\\mapper\\knowledge\\RecordMapper.xml]\r\n### The error may involve com.ruoyi.knowledge.mapper.RecordMapper.updateRecord-Inline\r\n### The error occurred while setting parameters\r\n### SQL: update Record          SET cautiontime = ?,             location = ?,             distypeID = ?,             dillobject = ?,             siteID = ?,             truckID = ?,             detailtype = ?,             picture = ?,             label4 = ?,             status = ?,             keywords = ?,             siteID2 = ?          where cautionID = ?\r\n### Cause: java.sql.SQLSyntaxErrorException: Unknown column \'siteID2\' in \'field list\'\n; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: Unknown column \'siteID2\' in \'field list\'', '2022-12-22 14:02:48');
INSERT INTO `sys_oper_log` VALUES (153, '出警记录表', 2, 'com.ruoyi.web.controller.knowledge.RecordController.edit()', 'PUT', 1, 'admin', NULL, '/knowledge/record', '127.0.0.1', '内网IP', '{\"truckid\":1,\"detailtype\":1,\"siteid2List\":[\"01\"],\"keywords\":\"加油\",\"dillobject\":1,\"cautiontime\":1670131835000,\"cautionid\":\"1\",\"params\":{},\"picture\":\"\",\"distypeid\":1,\"label4\":1,\"siteid\":1,\"location\":\"宝山\",\"siteid2\":\"01\",\"status\":1}', 'null', 1, '\r\n### Error updating database.  Cause: java.sql.SQLSyntaxErrorException: Unknown column \'siteID2\' in \'field list\'\r\n### The error may exist in file [F:\\2022\\910实验室\\消防项目\\2021-AssisDeciSys\\RuoYi-Vue-master\\ruoyi-system\\target\\classes\\mapper\\knowledge\\RecordMapper.xml]\r\n### The error may involve com.ruoyi.knowledge.mapper.RecordMapper.updateRecord-Inline\r\n### The error occurred while setting parameters\r\n### SQL: update Record          SET cautiontime = ?,             location = ?,             distypeID = ?,             dillobject = ?,             siteID = ?,             truckID = ?,             detailtype = ?,             picture = ?,             label4 = ?,             status = ?,             keywords = ?,             siteID2 = ?          where cautionID = ?\r\n### Cause: java.sql.SQLSyntaxErrorException: Unknown column \'siteID2\' in \'field list\'\n; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: Unknown column \'siteID2\' in \'field list\'', '2022-12-22 14:17:46');
INSERT INTO `sys_oper_log` VALUES (154, '出警记录表', 2, 'com.ruoyi.web.controller.knowledge.RecordController.edit()', 'PUT', 1, 'admin', NULL, '/knowledge/record', '127.0.0.1', '内网IP', '{\"truckid\":1,\"detailtype\":1,\"siteid2List\":[\"01\"],\"keywords\":\"加油\",\"dillobject\":1,\"cautiontime\":1670131835000,\"cautionid\":\"1\",\"params\":{},\"picture\":\"\",\"distypeid\":1,\"label4\":1,\"siteid\":1,\"location\":\"宝山\",\"siteid2\":\"01\",\"status\":1}', 'null', 1, '\r\n### Error updating database.  Cause: java.sql.SQLSyntaxErrorException: Unknown column \'siteID2\' in \'field list\'\r\n### The error may exist in file [F:\\2022\\910实验室\\消防项目\\2021-AssisDeciSys\\RuoYi-Vue-master\\ruoyi-system\\target\\classes\\mapper\\knowledge\\RecordMapper.xml]\r\n### The error may involve com.ruoyi.knowledge.mapper.RecordMapper.updateRecord-Inline\r\n### The error occurred while setting parameters\r\n### SQL: update Record          SET cautiontime = ?,             location = ?,             distypeID = ?,             dillobject = ?,             siteID = ?,             truckID = ?,             detailtype = ?,             picture = ?,             label4 = ?,             status = ?,             keywords = ?,             siteID2 = ?          where cautionID = ?\r\n### Cause: java.sql.SQLSyntaxErrorException: Unknown column \'siteID2\' in \'field list\'\n; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: Unknown column \'siteID2\' in \'field list\'', '2022-12-22 14:17:55');
INSERT INTO `sys_oper_log` VALUES (155, '出警记录表', 2, 'com.ruoyi.web.controller.knowledge.RecordController.edit()', 'PUT', 1, 'admin', NULL, '/knowledge/record', '127.0.0.1', '内网IP', '{\"truckid\":1,\"detailtype\":1,\"siteid2List\":[\"01\"],\"keywords\":\"加油\",\"dillobject\":1,\"cautiontime\":1670131835000,\"cautionid\":\"1\",\"params\":{},\"picture\":\"\",\"distypeid\":1,\"label4\":1,\"siteid\":1,\"location\":\"宝山\",\"siteid2\":\"01\",\"status\":1}', 'null', 1, '\r\n### Error updating database.  Cause: java.sql.SQLSyntaxErrorException: Unknown column \'siteID2\' in \'field list\'\r\n### The error may exist in file [F:\\2022\\910实验室\\消防项目\\2021-AssisDeciSys\\RuoYi-Vue-master\\ruoyi-system\\target\\classes\\mapper\\knowledge\\RecordMapper.xml]\r\n### The error may involve com.ruoyi.knowledge.mapper.RecordMapper.updateRecord-Inline\r\n### The error occurred while setting parameters\r\n### SQL: update Record          SET cautiontime = ?,             location = ?,             distypeID = ?,             dillobject = ?,             siteID = ?,             truckID = ?,             detailtype = ?,             picture = ?,             label4 = ?,             status = ?,             keywords = ?,             siteID2 = ?          where cautionID = ?\r\n### Cause: java.sql.SQLSyntaxErrorException: Unknown column \'siteID2\' in \'field list\'\n; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: Unknown column \'siteID2\' in \'field list\'', '2022-12-22 14:20:14');
INSERT INTO `sys_oper_log` VALUES (156, '出警记录表', 2, 'com.ruoyi.web.controller.knowledge.RecordController.edit()', 'PUT', 1, 'admin', NULL, '/knowledge/record', '127.0.0.1', '内网IP', '{\"truckid\":1,\"detailtype\":1,\"siteid2List\":[\"01\"],\"keywords\":\"加油\",\"dillobject\":1,\"cautiontime\":1670131835000,\"cautionid\":\"1\",\"params\":{},\"picture\":\"\",\"distypeid\":1,\"label4\":1,\"siteid\":1,\"location\":\"宝山\",\"siteid2\":\"01\",\"status\":1}', 'null', 1, '\r\n### Error updating database.  Cause: java.sql.SQLSyntaxErrorException: Unknown column \'siteID2\' in \'field list\'\r\n### The error may exist in file [F:\\2022\\910实验室\\消防项目\\2021-AssisDeciSys\\RuoYi-Vue-master\\ruoyi-system\\target\\classes\\mapper\\knowledge\\RecordMapper.xml]\r\n### The error may involve com.ruoyi.knowledge.mapper.RecordMapper.updateRecord-Inline\r\n### The error occurred while setting parameters\r\n### SQL: update Record          SET cautiontime = ?,             location = ?,             distypeID = ?,             dillobject = ?,             siteID = ?,             truckID = ?,             detailtype = ?,             picture = ?,             label4 = ?,             status = ?,             keywords = ?,             siteID2 = ?          where cautionID = ?\r\n### Cause: java.sql.SQLSyntaxErrorException: Unknown column \'siteID2\' in \'field list\'\n; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: Unknown column \'siteID2\' in \'field list\'', '2022-12-22 14:20:15');
INSERT INTO `sys_oper_log` VALUES (157, '出警记录表', 2, 'com.ruoyi.web.controller.knowledge.RecordController.edit()', 'PUT', 1, 'admin', NULL, '/knowledge/record', '127.0.0.1', '内网IP', '{\"truckid\":1,\"detailtype\":1,\"siteid2List\":[\"1\",\"2\"],\"keywords\":\"加油\",\"dillobject\":1,\"cautiontime\":1670131835000,\"cautionid\":\"1\",\"params\":{},\"picture\":\"\",\"distypeid\":1,\"label4\":1,\"siteid\":1,\"location\":\"宝山\",\"siteid2\":\"1,2\",\"status\":0}', 'null', 1, '\r\n### Error updating database.  Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'1\' for key \'PRIMARY\'\r\n### The error may exist in file [F:\\2022\\910实验室\\消防项目\\2021-AssisDeciSys\\RuoYi-Vue-master\\ruoyi-system\\target\\classes\\mapper\\knowledge\\ForceInvolveMapper.xml]\r\n### The error may involve com.ruoyi.knowledge.mapper.ForceInvolveMapper.insertForceInvolve-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into ForceInvolve          ( cautionID,             siteID )           values ( ?,             ? )\r\n### Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'1\' for key \'PRIMARY\'\n; Duplicate entry \'1\' for key \'PRIMARY\'; nested exception is java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'1\' for key \'PRIMARY\'', '2022-12-22 14:32:06');
INSERT INTO `sys_oper_log` VALUES (158, '出警记录表', 2, 'com.ruoyi.web.controller.knowledge.RecordController.edit()', 'PUT', 1, 'admin', NULL, '/knowledge/record', '127.0.0.1', '内网IP', '{\"truckid\":1,\"detailtype\":1,\"siteid2List\":[\"1\",\"2\"],\"keywords\":\"加油\",\"dillobject\":1,\"cautiontime\":1670131835000,\"cautionid\":\"1\",\"params\":{},\"picture\":\"\",\"distypeid\":1,\"label4\":1,\"siteid\":1,\"location\":\"宝山\",\"siteid2\":\"1,2\",\"status\":0}', 'null', 1, '\r\n### Error updating database.  Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'1\' for key \'PRIMARY\'\r\n### The error may exist in file [F:\\2022\\910实验室\\消防项目\\2021-AssisDeciSys\\RuoYi-Vue-master\\ruoyi-system\\target\\classes\\mapper\\knowledge\\ForceInvolveMapper.xml]\r\n### The error may involve com.ruoyi.knowledge.mapper.ForceInvolveMapper.insertForceInvolve-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into ForceInvolve          ( cautionID,             siteID )           values ( ?,             ? )\r\n### Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'1\' for key \'PRIMARY\'\n; Duplicate entry \'1\' for key \'PRIMARY\'; nested exception is java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'1\' for key \'PRIMARY\'', '2022-12-22 14:32:19');
INSERT INTO `sys_oper_log` VALUES (159, '出警记录表', 2, 'com.ruoyi.web.controller.knowledge.RecordController.edit()', 'PUT', 1, 'admin', NULL, '/knowledge/record', '127.0.0.1', '内网IP', '{\"truckid\":1,\"detailtype\":1,\"siteid2List\":[\"2\"],\"dillobject\":1,\"cautiontime\":1671690788000,\"cautionid\":\"2\",\"params\":{},\"picture\":\"1\",\"distypeid\":1,\"siteid\":1,\"location\":\"宝山区大场镇\",\"siteid2\":\"2\",\"status\":1}', 'null', 1, '\r\n### Error updating database.  Cause: java.sql.SQLSyntaxErrorException: Unknown column \'siteID2\' in \'field list\'\r\n### The error may exist in file [F:\\2022\\910实验室\\消防项目\\2021-AssisDeciSys\\RuoYi-Vue-master\\ruoyi-system\\target\\classes\\mapper\\knowledge\\RecordMapper.xml]\r\n### The error may involve com.ruoyi.knowledge.mapper.RecordMapper.updateRecord-Inline\r\n### The error occurred while setting parameters\r\n### SQL: update Record          SET cautiontime = ?,             location = ?,             distypeID = ?,             dillobject = ?,             siteID = ?,             truckID = ?,             detailtype = ?,             picture = ?,                          status = ?,                          siteID2 = ?          where cautionID = ?\r\n### Cause: java.sql.SQLSyntaxErrorException: Unknown column \'siteID2\' in \'field list\'\n; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: Unknown column \'siteID2\' in \'field list\'', '2022-12-22 14:33:54');
INSERT INTO `sys_oper_log` VALUES (160, '出警记录表', 2, 'com.ruoyi.web.controller.knowledge.RecordController.edit()', 'PUT', 1, 'admin', NULL, '/knowledge/record', '127.0.0.1', '内网IP', '{\"truckid\":1,\"detailtype\":1,\"siteid2List\":[],\"dillobject\":1,\"cautiontime\":1671690788000,\"cautionid\":\"2\",\"params\":{},\"picture\":\"1\",\"distypeid\":1,\"siteid\":1,\"location\":\"宝山区大场镇\",\"siteid2\":\"\",\"status\":1}', 'null', 1, '\r\n### Error updating database.  Cause: java.sql.SQLSyntaxErrorException: Unknown column \'siteID2\' in \'field list\'\r\n### The error may exist in file [F:\\2022\\910实验室\\消防项目\\2021-AssisDeciSys\\RuoYi-Vue-master\\ruoyi-system\\target\\classes\\mapper\\knowledge\\RecordMapper.xml]\r\n### The error may involve com.ruoyi.knowledge.mapper.RecordMapper.updateRecord-Inline\r\n### The error occurred while setting parameters\r\n### SQL: update Record          SET cautiontime = ?,             location = ?,             distypeID = ?,             dillobject = ?,             siteID = ?,             truckID = ?,             detailtype = ?,             picture = ?,                          status = ?,                          siteID2 = ?          where cautionID = ?\r\n### Cause: java.sql.SQLSyntaxErrorException: Unknown column \'siteID2\' in \'field list\'\n; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: Unknown column \'siteID2\' in \'field list\'', '2022-12-22 14:34:04');
INSERT INTO `sys_oper_log` VALUES (161, '出警记录表', 2, 'com.ruoyi.web.controller.knowledge.RecordController.edit()', 'PUT', 1, 'admin', NULL, '/knowledge/record', '127.0.0.1', '内网IP', '{\"truckid\":1,\"detailtype\":1,\"siteid2List\":[\"1\"],\"dillobject\":1,\"cautiontime\":1671690788000,\"cautionid\":\"2\",\"params\":{},\"picture\":\"1\",\"distypeid\":1,\"siteid\":1,\"location\":\"宝山区大场镇\",\"siteid2\":\"\",\"status\":1}', 'null', 1, 'nested exception is org.apache.ibatis.type.TypeException: Could not set parameters for mapping: ParameterMapping{property=\'cautionid\', mode=IN, javaType=class java.lang.String, jdbcType=null, numericScale=null, resultMapId=\'null\', jdbcTypeName=\'null\', expression=\'null\'}. Cause: org.apache.ibatis.type.TypeException: Error setting non null for parameter #11 with JdbcType null . Try setting a different JdbcType for this parameter or a different configuration property. Cause: java.sql.SQLException: Parameter index out of range (11 > number of parameters, which is 10).', '2022-12-22 14:39:53');
INSERT INTO `sys_oper_log` VALUES (162, '出警记录表', 2, 'com.ruoyi.web.controller.knowledge.RecordController.edit()', 'PUT', 1, 'admin', NULL, '/knowledge/record', '127.0.0.1', '内网IP', '{\"truckid\":1,\"detailtype\":1,\"siteid2List\":[],\"dillobject\":1,\"cautiontime\":1671690788000,\"cautionid\":\"2\",\"params\":{},\"picture\":\"1\",\"distypeid\":1,\"siteid\":1,\"location\":\"宝山区大场镇\",\"siteid2\":\"\",\"status\":1}', 'null', 1, 'nested exception is org.apache.ibatis.type.TypeException: Could not set parameters for mapping: ParameterMapping{property=\'cautionid\', mode=IN, javaType=class java.lang.String, jdbcType=null, numericScale=null, resultMapId=\'null\', jdbcTypeName=\'null\', expression=\'null\'}. Cause: org.apache.ibatis.type.TypeException: Error setting non null for parameter #11 with JdbcType null . Try setting a different JdbcType for this parameter or a different configuration property. Cause: java.sql.SQLException: Parameter index out of range (11 > number of parameters, which is 10).', '2022-12-22 14:40:30');
INSERT INTO `sys_oper_log` VALUES (163, '出警记录表', 2, 'com.ruoyi.web.controller.knowledge.RecordController.edit()', 'PUT', 1, 'admin', NULL, '/knowledge/record', '127.0.0.1', '内网IP', '{\"truckid\":1,\"detailtype\":1,\"siteid2List\":[\"1\"],\"dillobject\":1,\"cautiontime\":1671690788000,\"cautionid\":\"2\",\"params\":{},\"picture\":\"1\",\"distypeid\":1,\"siteid\":1,\"location\":\"1\",\"status\":1}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-22 14:42:17');
INSERT INTO `sys_oper_log` VALUES (164, '出警记录表', 2, 'com.ruoyi.web.controller.knowledge.RecordController.edit()', 'PUT', 1, 'admin', NULL, '/knowledge/record', '127.0.0.1', '内网IP', '{\"truckid\":1,\"detailtype\":1,\"siteid2List\":[\"1\",\"2\"],\"dillobject\":1,\"cautiontime\":1671690788000,\"cautionid\":\"2\",\"params\":{},\"picture\":\"1\",\"distypeid\":1,\"siteid\":1,\"location\":\"1\",\"siteid2\":\"1,2\",\"status\":1}', 'null', 1, '\r\n### Error updating database.  Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'2\' for key \'PRIMARY\'\r\n### The error may exist in file [F:\\2022\\910实验室\\消防项目\\2021-AssisDeciSys\\RuoYi-Vue-master\\ruoyi-system\\target\\classes\\mapper\\knowledge\\ForceInvolveMapper.xml]\r\n### The error may involve com.ruoyi.knowledge.mapper.ForceInvolveMapper.insertForceInvolve-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into ForceInvolve          ( cautionID,             siteID )           values ( ?,             ? )\r\n### Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'2\' for key \'PRIMARY\'\n; Duplicate entry \'2\' for key \'PRIMARY\'; nested exception is java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'2\' for key \'PRIMARY\'', '2022-12-22 14:42:29');
INSERT INTO `sys_oper_log` VALUES (165, '出警记录表', 2, 'com.ruoyi.web.controller.knowledge.RecordController.edit()', 'PUT', 1, 'admin', NULL, '/knowledge/record', '127.0.0.1', '内网IP', '{\"truckid\":1,\"detailtype\":1,\"siteid2List\":[\"2\"],\"dillobject\":1,\"cautiontime\":1671690788000,\"cautionid\":\"2\",\"params\":{},\"picture\":\"1\",\"distypeid\":1,\"siteid\":1,\"location\":\"1\",\"siteid2\":\"2\",\"status\":1}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-22 14:42:34');
INSERT INTO `sys_oper_log` VALUES (166, '出警记录表', 2, 'com.ruoyi.web.controller.knowledge.RecordController.edit()', 'PUT', 1, 'admin', NULL, '/knowledge/record', '127.0.0.1', '内网IP', '{\"truckid\":1,\"detailtype\":1,\"siteid2List\":[\"1\"],\"dillobject\":1,\"cautiontime\":1671690788000,\"cautionid\":\"2\",\"params\":{},\"picture\":\"1\",\"distypeid\":1,\"siteid\":1,\"location\":\"1\",\"siteid2\":\"1\",\"status\":1}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-22 14:43:28');
INSERT INTO `sys_oper_log` VALUES (167, '出警记录表', 2, 'com.ruoyi.web.controller.knowledge.RecordController.edit()', 'PUT', 1, 'admin', NULL, '/knowledge/record', '127.0.0.1', '内网IP', '{\"truckid\":1,\"detailtype\":1,\"siteid2List\":[\"1\",\"2\"],\"dillobject\":1,\"cautiontime\":1671690788000,\"cautionid\":\"2\",\"params\":{},\"picture\":\"1\",\"distypeid\":1,\"siteid\":1,\"location\":\"1\",\"siteid2\":\"1,2\",\"status\":1}', 'null', 1, '\r\n### Error updating database.  Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'2\' for key \'PRIMARY\'\r\n### The error may exist in file [F:\\2022\\910实验室\\消防项目\\2021-AssisDeciSys\\RuoYi-Vue-master\\ruoyi-system\\target\\classes\\mapper\\knowledge\\ForceInvolveMapper.xml]\r\n### The error may involve com.ruoyi.knowledge.mapper.ForceInvolveMapper.insertForceInvolve-Inline\r\n### The error occurred while setting parameters\r\n### SQL: insert into ForceInvolve          ( cautionID,             siteID )           values ( ?,             ? )\r\n### Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'2\' for key \'PRIMARY\'\n; Duplicate entry \'2\' for key \'PRIMARY\'; nested exception is java.sql.SQLIntegrityConstraintViolationException: Duplicate entry \'2\' for key \'PRIMARY\'', '2022-12-22 14:44:01');
INSERT INTO `sys_oper_log` VALUES (168, '出警记录表', 2, 'com.ruoyi.web.controller.knowledge.RecordController.edit()', 'PUT', 1, 'admin', NULL, '/knowledge/record', '127.0.0.1', '内网IP', '{\"truckid\":1,\"detailtype\":1,\"siteid2List\":[\"1\",\"2\"],\"dillobject\":1,\"cautiontime\":1671690788000,\"cautionid\":\"2\",\"params\":{},\"picture\":\"1\",\"distypeid\":1,\"siteid\":1,\"location\":\"1\",\"siteid2\":\"1,2\",\"status\":1}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-22 14:44:55');
INSERT INTO `sys_oper_log` VALUES (169, '出警记录表', 2, 'com.ruoyi.web.controller.knowledge.RecordController.edit()', 'PUT', 1, 'admin', NULL, '/knowledge/record', '127.0.0.1', '内网IP', '{\"truckid\":1,\"detailtype\":1,\"siteid2List\":[\"1\",\"2\"],\"keywords\":\"加油\",\"dillobject\":1,\"cautiontime\":1671690788000,\"cautionid\":\"2\",\"params\":{},\"picture\":\"1\",\"distypeid\":1,\"siteid\":1,\"location\":\"宝山区大场镇\",\"siteid2\":\"1,2\",\"status\":0}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-22 14:45:54');
INSERT INTO `sys_oper_log` VALUES (170, '出警记录表', 2, 'com.ruoyi.web.controller.knowledge.RecordController.edit()', 'PUT', 1, 'admin', NULL, '/knowledge/record', '127.0.0.1', '内网IP', '{\"truckid\":1,\"detailtype\":1,\"siteid2List\":[\"1\"],\"keywords\":\"加油\",\"dillobject\":1,\"cautiontime\":1671690788000,\"cautionid\":\"2\",\"params\":{},\"picture\":\"1\",\"distypeid\":1,\"siteid\":1,\"location\":\"宝山区大场镇\",\"siteid2\":\"1\",\"status\":0}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-22 14:46:57');
INSERT INTO `sys_oper_log` VALUES (171, '出警记录表', 2, 'com.ruoyi.web.controller.knowledge.RecordController.edit()', 'PUT', 1, 'admin', NULL, '/knowledge/record', '127.0.0.1', '内网IP', '{\"cautiontime\":1670342400000,\"cautionid\":\"3\",\"params\":{},\"distypeid\":1,\"siteid\":1,\"location\":\"顾村镇\",\"status\":0}', '{\"msg\":\"操作成功\",\"code\":200}', 0, NULL, '2022-12-22 15:00:35');

-- ----------------------------
-- Table structure for sys_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_post`;
CREATE TABLE `sys_post`  (
  `post_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '岗位ID',
  `post_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '岗位编码',
  `post_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '岗位名称',
  `post_sort` int(4) NOT NULL COMMENT '显示顺序',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`post_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '岗位信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_post
-- ----------------------------
INSERT INTO `sys_post` VALUES (1, 'ceo', '董事长', 1, '0', 'admin', '2022-11-28 13:24:46', '', NULL, '');
INSERT INTO `sys_post` VALUES (2, 'se', '项目经理', 2, '0', 'admin', '2022-11-28 13:24:46', '', NULL, '');
INSERT INTO `sys_post` VALUES (3, 'hr', '人力资源', 3, '0', 'admin', '2022-11-28 13:24:46', '', NULL, '');
INSERT INTO `sys_post` VALUES (4, 'user', '普通员工', 4, '0', 'admin', '2022-11-28 13:24:46', '', NULL, '');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `menu_check_strictly` tinyint(1) NULL DEFAULT 1 COMMENT '菜单树选择项是否关联显示',
  `dept_check_strictly` tinyint(1) NULL DEFAULT 1 COMMENT '部门树选择项是否关联显示',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '超级管理员', 'admin', 1, '1', 1, 1, '0', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '超级管理员');
INSERT INTO `sys_role` VALUES (2, '普通角色', 'common', 2, '2', 1, 1, '0', '0', 'admin', '2022-11-28 13:24:47', '', NULL, '普通角色');

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept`  (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`, `dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色和部门关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------
INSERT INTO `sys_role_dept` VALUES (2, 100);
INSERT INTO `sys_role_dept` VALUES (2, 101);
INSERT INTO `sys_role_dept` VALUES (2, 105);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色和菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (2, 1);
INSERT INTO `sys_role_menu` VALUES (2, 2);
INSERT INTO `sys_role_menu` VALUES (2, 3);
INSERT INTO `sys_role_menu` VALUES (2, 4);
INSERT INTO `sys_role_menu` VALUES (2, 100);
INSERT INTO `sys_role_menu` VALUES (2, 101);
INSERT INTO `sys_role_menu` VALUES (2, 102);
INSERT INTO `sys_role_menu` VALUES (2, 103);
INSERT INTO `sys_role_menu` VALUES (2, 104);
INSERT INTO `sys_role_menu` VALUES (2, 105);
INSERT INTO `sys_role_menu` VALUES (2, 106);
INSERT INTO `sys_role_menu` VALUES (2, 107);
INSERT INTO `sys_role_menu` VALUES (2, 108);
INSERT INTO `sys_role_menu` VALUES (2, 109);
INSERT INTO `sys_role_menu` VALUES (2, 110);
INSERT INTO `sys_role_menu` VALUES (2, 111);
INSERT INTO `sys_role_menu` VALUES (2, 112);
INSERT INTO `sys_role_menu` VALUES (2, 113);
INSERT INTO `sys_role_menu` VALUES (2, 114);
INSERT INTO `sys_role_menu` VALUES (2, 115);
INSERT INTO `sys_role_menu` VALUES (2, 116);
INSERT INTO `sys_role_menu` VALUES (2, 500);
INSERT INTO `sys_role_menu` VALUES (2, 501);
INSERT INTO `sys_role_menu` VALUES (2, 1000);
INSERT INTO `sys_role_menu` VALUES (2, 1001);
INSERT INTO `sys_role_menu` VALUES (2, 1002);
INSERT INTO `sys_role_menu` VALUES (2, 1003);
INSERT INTO `sys_role_menu` VALUES (2, 1004);
INSERT INTO `sys_role_menu` VALUES (2, 1005);
INSERT INTO `sys_role_menu` VALUES (2, 1006);
INSERT INTO `sys_role_menu` VALUES (2, 1007);
INSERT INTO `sys_role_menu` VALUES (2, 1008);
INSERT INTO `sys_role_menu` VALUES (2, 1009);
INSERT INTO `sys_role_menu` VALUES (2, 1010);
INSERT INTO `sys_role_menu` VALUES (2, 1011);
INSERT INTO `sys_role_menu` VALUES (2, 1012);
INSERT INTO `sys_role_menu` VALUES (2, 1013);
INSERT INTO `sys_role_menu` VALUES (2, 1014);
INSERT INTO `sys_role_menu` VALUES (2, 1015);
INSERT INTO `sys_role_menu` VALUES (2, 1016);
INSERT INTO `sys_role_menu` VALUES (2, 1017);
INSERT INTO `sys_role_menu` VALUES (2, 1018);
INSERT INTO `sys_role_menu` VALUES (2, 1019);
INSERT INTO `sys_role_menu` VALUES (2, 1020);
INSERT INTO `sys_role_menu` VALUES (2, 1021);
INSERT INTO `sys_role_menu` VALUES (2, 1022);
INSERT INTO `sys_role_menu` VALUES (2, 1023);
INSERT INTO `sys_role_menu` VALUES (2, 1024);
INSERT INTO `sys_role_menu` VALUES (2, 1025);
INSERT INTO `sys_role_menu` VALUES (2, 1026);
INSERT INTO `sys_role_menu` VALUES (2, 1027);
INSERT INTO `sys_role_menu` VALUES (2, 1028);
INSERT INTO `sys_role_menu` VALUES (2, 1029);
INSERT INTO `sys_role_menu` VALUES (2, 1030);
INSERT INTO `sys_role_menu` VALUES (2, 1031);
INSERT INTO `sys_role_menu` VALUES (2, 1032);
INSERT INTO `sys_role_menu` VALUES (2, 1033);
INSERT INTO `sys_role_menu` VALUES (2, 1034);
INSERT INTO `sys_role_menu` VALUES (2, 1035);
INSERT INTO `sys_role_menu` VALUES (2, 1036);
INSERT INTO `sys_role_menu` VALUES (2, 1037);
INSERT INTO `sys_role_menu` VALUES (2, 1038);
INSERT INTO `sys_role_menu` VALUES (2, 1039);
INSERT INTO `sys_role_menu` VALUES (2, 1040);
INSERT INTO `sys_role_menu` VALUES (2, 1041);
INSERT INTO `sys_role_menu` VALUES (2, 1042);
INSERT INTO `sys_role_menu` VALUES (2, 1043);
INSERT INTO `sys_role_menu` VALUES (2, 1044);
INSERT INTO `sys_role_menu` VALUES (2, 1045);
INSERT INTO `sys_role_menu` VALUES (2, 1046);
INSERT INTO `sys_role_menu` VALUES (2, 1047);
INSERT INTO `sys_role_menu` VALUES (2, 1048);
INSERT INTO `sys_role_menu` VALUES (2, 1049);
INSERT INTO `sys_role_menu` VALUES (2, 1050);
INSERT INTO `sys_role_menu` VALUES (2, 1051);
INSERT INTO `sys_role_menu` VALUES (2, 1052);
INSERT INTO `sys_role_menu` VALUES (2, 1053);
INSERT INTO `sys_role_menu` VALUES (2, 1054);
INSERT INTO `sys_role_menu` VALUES (2, 1055);
INSERT INTO `sys_role_menu` VALUES (2, 1056);
INSERT INTO `sys_role_menu` VALUES (2, 1057);
INSERT INTO `sys_role_menu` VALUES (2, 1058);
INSERT INTO `sys_role_menu` VALUES (2, 1059);
INSERT INTO `sys_role_menu` VALUES (2, 1060);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `dept_id` bigint(20) NULL DEFAULT NULL COMMENT '部门ID',
  `user_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户账号',
  `nick_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户昵称',
  `user_type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '00' COMMENT '用户类型（00系统用户）',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '手机号码',
  `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '头像地址',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '密码',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 103, 'admin', '若依', '00', 'ry@163.com', '15888888888', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', '2022-12-22 10:10:06', 'admin', '2022-11-28 13:24:46', '', '2022-12-22 10:10:06', '管理员');
INSERT INTO `sys_user` VALUES (2, 105, 'ry', '若依', '00', 'ry@qq.com', '15666666666', '1', '', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', '0', '0', '127.0.0.1', '2022-12-03 15:59:18', 'admin', '2022-11-28 13:24:46', '', '2022-12-03 15:59:18', '测试员');

-- ----------------------------
-- Table structure for sys_user_post
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_post`;
CREATE TABLE `sys_user_post`  (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `post_id` bigint(20) NOT NULL COMMENT '岗位ID',
  PRIMARY KEY (`user_id`, `post_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户与岗位关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_post
-- ----------------------------
INSERT INTO `sys_user_post` VALUES (1, 1);
INSERT INTO `sys_user_post` VALUES (2, 2);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户和角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1);
INSERT INTO `sys_user_role` VALUES (2, 2);

-- ----------------------------
-- Table structure for trucktype
-- ----------------------------
DROP TABLE IF EXISTS `trucktype`;
CREATE TABLE `trucktype`  (
  `typeID` int(2) NOT NULL AUTO_INCREMENT,
  `typename` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`typeID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of trucktype
-- ----------------------------
INSERT INTO `trucktype` VALUES (1, '1号车');

-- ----------------------------
-- Table structure for typerelation
-- ----------------------------
DROP TABLE IF EXISTS `typerelation`;
CREATE TABLE `typerelation`  (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `disposeobj` int(2) NULL DEFAULT NULL,
  `detailtype` int(2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of typerelation
-- ----------------------------
INSERT INTO `typerelation` VALUES (1, 1, 1);
INSERT INTO `typerelation` VALUES (2, 1, 2);
INSERT INTO `typerelation` VALUES (3, 2, 1);
INSERT INTO `typerelation` VALUES (4, 3, 2);
INSERT INTO `typerelation` VALUES (5, 4, 1);
INSERT INTO `typerelation` VALUES (6, 4, 2);
INSERT INTO `typerelation` VALUES (7, 4, 9);
INSERT INTO `typerelation` VALUES (8, 6, 1);
INSERT INTO `typerelation` VALUES (9, 7, 1);
INSERT INTO `typerelation` VALUES (10, 7, 2);
INSERT INTO `typerelation` VALUES (11, 8, 3);
INSERT INTO `typerelation` VALUES (12, 9, 4);
INSERT INTO `typerelation` VALUES (13, 10, 15);
INSERT INTO `typerelation` VALUES (14, 11, 5);
INSERT INTO `typerelation` VALUES (15, 14, 6);
INSERT INTO `typerelation` VALUES (16, 15, 7);
INSERT INTO `typerelation` VALUES (17, 17, 22);
INSERT INTO `typerelation` VALUES (18, 19, 22);
INSERT INTO `typerelation` VALUES (19, 20, 19);
INSERT INTO `typerelation` VALUES (20, 21, 13);
INSERT INTO `typerelation` VALUES (21, 21, 14);
INSERT INTO `typerelation` VALUES (22, 22, 21);
INSERT INTO `typerelation` VALUES (24, 23, 22);
INSERT INTO `typerelation` VALUES (25, 24, 22);
INSERT INTO `typerelation` VALUES (26, 25, 18);
INSERT INTO `typerelation` VALUES (27, 26, 17);
INSERT INTO `typerelation` VALUES (28, 27, 1);
INSERT INTO `typerelation` VALUES (29, 27, 2);
INSERT INTO `typerelation` VALUES (30, 28, 17);
INSERT INTO `typerelation` VALUES (31, 29, 18);
INSERT INTO `typerelation` VALUES (32, 31, 16);
INSERT INTO `typerelation` VALUES (33, 33, 25);
INSERT INTO `typerelation` VALUES (34, 33, 18);

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `tele` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `username` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gender` tinyint(1) NULL DEFAULT NULL,
  `age` datetime(0) NULL DEFAULT NULL,
  `positionID` int(2) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `truckID` int(4) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `siteID` int(2) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `account` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `adminID` int(2) UNSIGNED ZEROFILL NULL DEFAULT NULL,
  `status` tinyint(1) NULL DEFAULT NULL,
  `openid` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户微信 openid',
  `userid` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户企业微信 id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (1, '18516291129', '陈佳琪', 1, '1991-05-13 23:00:00', 01, 0001, 01, 'chenjiaqi', '123', 01, 0, 'openid', 'useid');
INSERT INTO `userinfo` VALUES (2, '119', '小明', 1, '1982-12-07 00:00:00', 01, NULL, 02, NULL, NULL, NULL, 0, '213132', '3213213');

-- ----------------------------
-- Table structure for userposition
-- ----------------------------
DROP TABLE IF EXISTS `userposition`;
CREATE TABLE `userposition`  (
  `positionID` int(2) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT,
  `positionname` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`positionID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userposition
-- ----------------------------
INSERT INTO `userposition` VALUES (01, '指挥员');
INSERT INTO `userposition` VALUES (02, '战斗员');
INSERT INTO `userposition` VALUES (03, '通信员');

SET FOREIGN_KEY_CHECKS = 1;
