-- MySQL dump 10.13  Distrib 8.0.30, for macos12 (x86_64)
--
-- Host: 127.0.0.1    Database: integration
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `t_ep_properties`
--

DROP TABLE IF EXISTS `t_ep_properties`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_ep_properties`
(
    `create_by`      varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '创建人',
    `create_time`    datetime                                                              DEFAULT NULL COMMENT '创建日期',
    `update_by`      varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '更新人',
    `update_time`    datetime                                                              DEFAULT NULL COMMENT '更新日期',
    `ep_type_name`   varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '终端类型名',
    `name`           varchar(64) COLLATE utf8mb4_general_ci                       NOT NULL COMMENT '属性名',
    `type`           varchar(16) COLLATE utf8mb4_general_ci                       NOT NULL COMMENT '类型',
    `title`          varchar(64) COLLATE utf8mb4_general_ci                                DEFAULT NULL COMMENT '标题',
    `required`       tinyint(1)                                                   NOT NULL DEFAULT '0' COMMENT '属性名',
    `allowed_values` text COLLATE utf8mb4_general_ci COMMENT '允许的属性值',
    `default_value`  varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '默认值',
    `endpoint_modes` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '属性名',
    `masked`         tinyint(1)                                                   NOT NULL DEFAULT '0' COMMENT '标记',
    `modeRequired`   tinyint(1)                                                   NOT NULL DEFAULT '0' COMMENT '模式必填',
    `applies_to`     varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用于哪一端 生产-PRODUCER（IN/IN_OUT） 消费-CONSUMER（OUT/OUT_IN）',
    PRIMARY KEY (`ep_type_name`, `name`, `applies_to`) USING BTREE,
    KEY `idx_variable_ep_type_name` (`ep_type_name`) USING BTREE,
    KEY `idx_variable_applies_to` (`applies_to`) USING BTREE,
    KEY `idx_variable_name` (`name`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = DYNAMIC COMMENT ='终端属性配置表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_ep_properties`
--

LOCK TABLES `t_ep_properties` WRITE;
/*!40000 ALTER TABLE `t_ep_properties`
    DISABLE KEYS */;
INSERT INTO `t_ep_properties` (`create_by`, `create_time`, `update_by`, `update_time`, `ep_type_name`, `name`, `type`,
                               `title`, `required`, `allowed_values`, `default_value`, `endpoint_modes`, `masked`,
                               `modeRequired`, `applies_to`)
VALUES ('00001', '2022-11-29 11:30:48', '00001', '2022-11-29 11:30:53', 'soap', 'certificate', 'STRING', '证书', 0, NULL,
        NULL, NULL, 0, 0, 'PRODUCER'),
       ('00001', '2022-11-29 12:44:52', '00001', '2022-11-29 12:44:56', 'soap', 'compressContent', 'BOOLEAN', '压缩响应', 0,
        NULL, 'true', NULL, 0, 0, 'CONSUMER'),
       ('00001', '2022-11-29 11:18:34', '00001', '2022-11-29 11:18:41', 'soap', 'connectionTimeout', 'INTEGER', '连接超时',
        0, NULL, '30000', NULL, 0, 0, 'PRODUCER'),
       ('00001', '2022-11-29 11:18:34', '00001', '2022-11-29 11:18:41', 'soap', 'disableChunking', 'BOOLEAN', '禁用分块传输',
        0, NULL, 'false', NULL, 0, 0, 'PRODUCER'),
       ('00001', '2022-11-29 11:30:48', '00001', '2022-11-29 11:30:53', 'soap', 'disableHostnameCheck', 'BOOLEAN',
        '禁用主机检测', 0, NULL, 'false', NULL, 0, 0, 'PRODUCER'),
       ('00001', '2022-11-29 12:42:16', '00001', '2022-11-29 12:42:21', 'soap', 'idleTimeout', 'INTEGER', '闲置超时', 0,
        NULL, '60', NULL, 0, 0, 'CONSUMER'),
       ('00001', '2022-11-29 12:46:40', '00001', '2022-11-29 12:46:44', 'soap', 'isLoggingEnabled', 'BOOELAN', '调试日志',
        0, NULL, 'false', NULL, 0, 0, 'CONSUMER'),
       ('00001', '2022-11-29 11:30:48', '00001', '2022-11-29 11:30:53', 'soap', 'isLoggingEnabled', 'BOOLEAN', '调试日志',
        0, NULL, 'false', NULL, 0, 0, 'PRODUCER'),
       ('00001', '2022-11-29 12:34:57', '00001', '2022-11-29 12:34:50', 'soap', 'keyStore', 'STRING', '密钥仓库', 0, NULL,
        NULL, NULL, 0, 0, 'CONSUMER'),
       ('00001', '2022-11-29 12:43:35', '00001', '2022-11-29 12:43:39', 'soap', 'maximumQueueSize', 'INTEGER',
        '最大线程池队列数', 0, NULL, '100', NULL, 0, 0, 'CONSUMER'),
       ('00001', '2022-11-29 12:40:51', '00001', '2022-11-29 12:40:56', 'soap', 'maximumThreadSize', 'INTEGER', '最大线程数',
        0, NULL, '200', NULL, 0, 0, 'CONSUMER'),
       ('00001', '2022-11-29 12:39:33', '00001', '2022-11-29 12:39:40', 'soap', 'minimumThreadSize', 'INTEGER', '最小线程数',
        0, NULL, '8', NULL, 0, 0, 'CONSUMER'),
       ('00001', '2022-11-29 11:30:48', '00001', '2022-11-29 11:30:53', 'soap', 'namespaceURI', 'STRING', '命名空间', 0,
        NULL, NULL, NULL, 0, 0, 'CONSUMER'),
       ('00001', '2022-11-29 11:30:48', '00001', '2022-11-29 11:30:53', 'soap', 'namespaceURI', 'STRING', '命名空间', 0,
        NULL, NULL, NULL, 0, 0, 'PRODUCER'),
       ('00001', '2022-11-29 11:18:34', '00001', '2022-11-29 11:18:41', 'soap', 'operationName', 'STRING', '调用方法名', 1,
        NULL, NULL, NULL, 0, 0, 'PRODUCER'),
       ('00001', '2022-11-29 12:37:54', '00001', '2022-11-29 12:37:58', 'soap', 'ownThreadPool', 'BOOLEAN', '服务端线程池', 0,
        NULL, 'false', NULL, 0, 0, 'CONSUMER'),
       ('00001', '2022-11-29 11:28:48', '00001', '2022-11-29 11:28:52', 'soap', 'portName', 'STRING', '端口名称', 1, NULL,
        NULL, NULL, 0, 0, 'CONSUMER'),
       ('00001', '2022-11-29 11:18:34', '00001', '2022-11-29 11:18:41', 'soap', 'portName', 'STRING', '端口名称', 1, NULL,
        NULL, NULL, 0, 0, 'PRODUCER'),
       ('00001', '2022-11-29 11:18:34', '00001', '2022-11-29 11:18:41', 'soap', 'receiveTimeout', 'INTEGER', '接收超时', 0,
        NULL, '30000', NULL, 0, 0, 'PRODUCER'),
       ('00001', '2022-11-29 11:18:34', '00001', '2022-11-29 11:18:41', 'soap', 'requestCompressMode', 'STRING', '压缩请求',
        0, 'NO_REQUEST_COMPRESSION=不压缩请求|COMPRESS_ON_SERVER_COMPRESSION=根据服务端压缩请求|ALWAYS_COMPRESS_REQUEST=压缩请求',
        'COMPRESS_ON_SERV', NULL, 0, 0, 'PRODUCER'),
       ('00001', '2022-11-29 11:30:48', '00001', '2022-11-29 11:30:53', 'soap', 'requestHeaders', 'STRING', '消息头', 0,
        NULL, NULL, NULL, 0, 0, 'PRODUCER'),
       ('00001', '2022-11-29 11:21:43', '00001', '2022-11-29 11:21:51', 'soap', 'resourceAddress', 'STRING', '资源服务地址',
        0, NULL, NULL, NULL, 0, 0, 'CONSUMER'),
       ('00001', '2022-11-29 11:35:05', '00001', '2022-11-29 11:35:10', 'soap', 'responseTimeout', 'INTEGER', '响应超时', 0,
        NULL, '60', 'IN_OUT', 0, 0, 'CONSUMER'),
       ('00001', '2022-11-29 11:36:33', '00001', '2022-11-29 11:36:38', 'soap', 'responseTimeoutStrategy', 'STRING',
        '超时策略', 0, '发送超时错误到错误队列=SEND_TO_DLQ|丢弃超时错误=DISCAED', 'SEND_TO_DLQ', 'IN_OUT', 0, 0, 'CONSUMER'),
       ('00001', '2022-11-29 11:25:09', '00001', '2022-11-29 11:25:15', 'soap', 'serviceAddress', 'STRING', '服务地址', 0,
        NULL, NULL, NULL, 0, 0, 'CONSUMER'),
       ('00001', '2022-11-29 12:33:45', '00001', '2022-11-29 12:33:52', 'soap', 'serviceAddress', 'STRING', '服务地址', 1,
        NULL, NULL, NULL, 0, 0, 'PRODUCER'),
       ('00001', '2022-11-29 12:33:45', '00001', '2022-11-29 12:33:52', 'soap', 'serviceName', 'STRING', '服务名称', 1,
        NULL, NULL, NULL, 0, 0, 'CONSUMER'),
       ('00001', '2022-11-29 12:33:45', '00001', '2022-11-29 12:33:52', 'soap', 'serviceName', 'STRING', '服务名称', 1,
        NULL, NULL, NULL, 0, 0, 'PRODUCER'),
       ('00001', '2022-11-29 11:18:34', '00001', '2022-11-29 11:18:41', 'soap', 'soapRequestTemplate', 'STRING',
        'SOAP请求模板', 0, NULL, NULL, NULL, 0, 0, 'PRODUCER'),
       ('00001', '2022-11-29 12:48:03', '00001', '2022-11-29 12:48:08', 'soap', 'timeoutDetail', 'STRING', '响应超时错误详细',
        0, NULL, '', 'IN_OUT', 0, 0, 'CONSUMER'),
       ('00001', '2022-11-29 12:50:22', '00001', '2022-11-29 12:50:26', 'soap', 'timeoutFaultString', 'STRING',
        '响应超时错误信息', 0, NULL, NULL, 'IN_OUT', 0, 0, 'CONSUMER'),
       ('00001', '2022-11-29 12:48:03', '00001', '2022-11-29 12:48:08', 'soap', 'timeoutStatusCode', 'INTEGER',
        '响应超时状态码', 0, NULL, '504', 'IN_OUT', 0, 0, 'CONSUMER'),
       ('00001', '2022-11-29 12:36:56', '00001', '2022-11-29 12:37:01', 'soap', 'trustStore', 'STRING', '信任仓库', 0, NULL,
        NULL, NULL, 0, 0, 'CONSUMER'),
       ('00001', '2022-11-29 11:30:48', '00001', '2022-11-29 11:30:53', 'soap', 'useRequestHeaders', 'BOOLEAN', '使用消息头',
        0, NULL, 'false', NULL, 0, 0, 'PRODUCER'),
       ('00001', '2022-11-29 11:18:34', '00001', '2022-11-29 11:18:41', 'soap', 'wsdlId', 'STRING', 'WSDL文件名称', 1, NULL,
        NULL, NULL, 0, 0, 'CONSUMER'),
       ('00001', '2022-11-29 11:18:34', '00001', '2022-11-29 11:18:41', 'soap', 'wsdlId', 'STRING', 'WSDL文件名称', 1, NULL,
        NULL, NULL, 0, 0, 'PRODUCER');
/*!40000 ALTER TABLE `t_ep_properties`
    ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2022-11-29 13:46:57
