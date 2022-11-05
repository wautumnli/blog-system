/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80024
 Source Host           : 127.0.0.1:3306
 Source Schema         : ddd

 Target Server Type    : MySQL
 Target Server Version : 80024
 File Encoding         : 65001

 Date: 05/11/2022 15:40:11
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for au_user
-- ----------------------------
DROP TABLE IF EXISTS `au_user`;
CREATE TABLE `au_user`
(
    `id`          bigint       NOT NULL AUTO_INCREMENT COMMENT '主键',
    `username`    varchar(200) NOT NULL COMMENT '用户名',
    `password`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
    `deleted`     int          NOT NULL                                   DEFAULT '0' COMMENT '逻辑删',
    `ver`         int          NOT NULL                                   DEFAULT '0' COMMENT '版本号',
    `create_user` varchar(255) NOT NULL COMMENT '创建用户',
    `create_time` datetime     NOT NULL COMMENT '创建时间',
    `update_user` varchar(255) NOT NULL COMMENT '更新用户',
    `update_time` datetime     NOT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for bl_article
-- ----------------------------
DROP TABLE IF EXISTS `bl_article`;
CREATE TABLE `bl_article`
(
    `id`           bigint      NOT NULL AUTO_INCREMENT,
    `user_id`      bigint      DEFAULT NULL COMMENT '用户id',
    `content_id`   bigint      DEFAULT NULL COMMENT '文章内容id',
    `article_name` varchar(63) DEFAULT NULL COMMENT '文章名',
    `deleted`      int         DEFAULT '0' COMMENT '删除标识',
    `ver`          int         DEFAULT '0' COMMENT '版本号',
    `create_time`  datetime    NOT NULL COMMENT '创建时间',
    `update_time`  datetime    NOT NULL COMMENT '更新时间',
    `create_user`  varchar(50) NOT NULL COMMENT '创建用户',
    `update_user`  varchar(50) NOT NULL COMMENT '更新用户',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Table structure for bl_article_content
-- ----------------------------
DROP TABLE IF EXISTS `bl_article_content`;
CREATE TABLE `bl_article_content`
(
    `id`          bigint      NOT NULL AUTO_INCREMENT,
    `content`     blob COMMENT '内容',
    `deleted`     int DEFAULT '0' COMMENT '删除标识',
    `ver`         int DEFAULT '0' COMMENT '版本号',
    `create_time` datetime    NOT NULL COMMENT '创建时间',
    `update_time` datetime    NOT NULL COMMENT '更新时间',
    `create_user` varchar(50) NOT NULL COMMENT '创建用户',
    `update_user` varchar(50) NOT NULL COMMENT '更新用户',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

SET
FOREIGN_KEY_CHECKS = 1;
