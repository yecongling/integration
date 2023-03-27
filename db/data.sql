INSERT INTO integration.t_engine_ep_properties (create_by, create_time, update_by, update_time, endpoint_type_name, name, `type`,
                                         title, required, allowed_values, default_value, endpoint_modes, masked,
                                         modeRequired, applies_to)
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
        '最大线程池队列数', 0, NULL, '100', NULL, 0, 0, 'CONSUMER');
INSERT INTO integration.t_engine_ep_properties (create_by, create_time, update_by, update_time, endpoint_type_name, name, `type`,
                                         title, required, allowed_values, default_value, endpoint_modes, masked,
                                         modeRequired, applies_to)
VALUES ('00001', '2022-11-29 12:40:51', '00001', '2022-11-29 12:40:56', 'soap', 'maximumThreadSize', 'INTEGER', '最大线程数',
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
        'COMPRESS_ON_SERV', NULL, 0, 0, 'PRODUCER');
INSERT INTO integration.t_engine_ep_properties (create_by, create_time, update_by, update_time, endpoint_type_name, name, `type`,
                                         title, required, allowed_values, default_value, endpoint_modes, masked,
                                         modeRequired, applies_to)
VALUES ('00001', '2022-11-29 11:30:48', '00001', '2022-11-29 11:30:53', 'soap', 'requestHeaders', 'STRING', '消息头', 0,
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
        0, NULL, '', 'IN_OUT', 0, 0, 'CONSUMER');
INSERT INTO integration.t_engine_ep_properties (create_by, create_time, update_by, update_time, endpoint_type_name, name, `type`,
                                         title, required, allowed_values, default_value, endpoint_modes, masked,
                                         modeRequired, applies_to)
VALUES ('00001', '2022-11-29 12:50:22', '00001', '2022-11-29 12:50:26', 'soap', 'timeoutFaultString', 'STRING',
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

/* 系统菜单表 */
INSERT INTO `t_sys_permission` (`id`,`parent_id`,`name`,`url`,`component`,`component_name`,`redirect`,`menu_type`,`perms`,`perms_type`,`sort_no`,`always_show`,`icon`,`is_route`,`is_leaf`,`keep_alive`,`hidden`,`hide_tab`,`description`,`create_by`,`create_time`,`update_by`,`update_time`,`del_flag`,`rule_flag`,`status`,`internal_or_external`) VALUES ('1170592628746872934','d7d6e2e4e2934fer98c2f3','病历设计器','/emr/editor','emr/Editor',null,null,1,null,'0',6.10,0,'EditOutlined',1,1,0,0,0,null,'admin','2023-03-27 12:00:00','admin','2023-03-27 12:00:00',0,0,null,null);
INSERT INTO `t_sys_permission` (`id`,`parent_id`,`name`,`url`,`component`,`component_name`,`redirect`,`menu_type`,`perms`,`perms_type`,`sort_no`,`always_show`,`icon`,`is_route`,`is_leaf`,`keep_alive`,`hidden`,`hide_tab`,`description`,`create_by`,`create_time`,`update_by`,`update_time`,`del_flag`,`rule_flag`,`status`,`internal_or_external`) VALUES ('11705926287468729781233','d7d6e2e4e2934f2c9385a623fd98c6f6','数据源管理','/resource/database','resource/Database',null,null,1,null,'0',5.20,0,'DatabaseOutlined',1,1,0,0,0,null,'admin','2019-04-17 15:13:56','admin','2019-04-17 15:13:56',0,0,null,null);
INSERT INTO `t_sys_permission` (`id`,`parent_id`,`name`,`url`,`component`,`component_name`,`redirect`,`menu_type`,`perms`,`perms_type`,`sort_no`,`always_show`,`icon`,`is_route`,`is_leaf`,`keep_alive`,`hidden`,`hide_tab`,`description`,`create_by`,`create_time`,`update_by`,`update_time`,`del_flag`,`rule_flag`,`status`,`internal_or_external`) VALUES ('1170592628746878978','d7d6e2e4e2934f2c9385a623fd98c6f3','菜单管理','/system/menu','system/Menu',null,null,1,null,'1',1.30,0,'SettingOutlined',1,1,0,0,0,null,'admin','2019-09-08 15:00:05','admin','2022-10-14 18:01:57',0,0,'1',0);
INSERT INTO `t_sys_permission` (`id`,`parent_id`,`name`,`url`,`component`,`component_name`,`redirect`,`menu_type`,`perms`,`perms_type`,`sort_no`,`always_show`,`icon`,`is_route`,`is_leaf`,`keep_alive`,`hidden`,`hide_tab`,`description`,`create_by`,`create_time`,`update_by`,`update_time`,`del_flag`,`rule_flag`,`status`,`internal_or_external`) VALUES ('190c2b43bec6a5f7a4194a85db67d96a','d7d6e2e4e2934f2c9385a623fd98c6f3','角色管理','/system/role','system/Role',null,null,1,null,null,1.20,0,'SettingOutlined',1,1,0,0,0,null,'admin','2019-04-17 15:13:56','admin','2019-12-25 09:36:31',0,0,null,0);
INSERT INTO `t_sys_permission` (`id`,`parent_id`,`name`,`url`,`component`,`component_name`,`redirect`,`menu_type`,`perms`,`perms_type`,`sort_no`,`always_show`,`icon`,`is_route`,`is_leaf`,`keep_alive`,`hidden`,`hide_tab`,`description`,`create_by`,`create_time`,`update_by`,`update_time`,`del_flag`,`rule_flag`,`status`,`internal_or_external`) VALUES ('3f915b2769fc80648e92d04e84ca059d','d7d6e2e4e2934f2c9385a623fd98c6f3','用户管理','/system/user','system/User',null,null,1,null,null,1.10,0,'UserOutlined',1,1,0,0,0,null,null,'2018-12-25 20:34:38','admin','2022-10-14 18:09:03',0,0,null,0);
INSERT INTO `t_sys_permission` (`id`,`parent_id`,`name`,`url`,`component`,`component_name`,`redirect`,`menu_type`,`perms`,`perms_type`,`sort_no`,`always_show`,`icon`,`is_route`,`is_leaf`,`keep_alive`,`hidden`,`hide_tab`,`description`,`create_by`,`create_time`,`update_by`,`update_time`,`del_flag`,`rule_flag`,`status`,`internal_or_external`) VALUES ('d7d6e2e4e2934f2c9385a623fd98c6f2','','首页','/home','Home',null,null,0,null,'0',0.80,0,'HomeOutlined',1,0,0,0,0,'首页','admin','2019-04-17 15:13:56','admin','2019-04-17 15:13:56',0,0,'1',null);
INSERT INTO `t_sys_permission` (`id`,`parent_id`,`name`,`url`,`component`,`component_name`,`redirect`,`menu_type`,`perms`,`perms_type`,`sort_no`,`always_show`,`icon`,`is_route`,`is_leaf`,`keep_alive`,`hidden`,`hide_tab`,`description`,`create_by`,`create_time`,`update_by`,`update_time`,`del_flag`,`rule_flag`,`status`,`internal_or_external`) VALUES ('d7d6e2e4e2934f2c9385a623fd98c6f3','','系统管理','/system','',null,null,0,null,null,4.00,0,'SettingOutlined',1,0,null,0,null,null,null,'2018-12-25 20:34:38','admin','2019-03-31 22:19:52',0,0,null,null);
INSERT INTO `t_sys_permission` (`id`,`parent_id`,`name`,`url`,`component`,`component_name`,`redirect`,`menu_type`,`perms`,`perms_type`,`sort_no`,`always_show`,`icon`,`is_route`,`is_leaf`,`keep_alive`,`hidden`,`hide_tab`,`description`,`create_by`,`create_time`,`update_by`,`update_time`,`del_flag`,`rule_flag`,`status`,`internal_or_external`) VALUES ('d7d6e2e4e2934f2c9385a623fd98c6f6','','资源管理','/resource','',null,null,0,null,'0',5.00,0,'DribbbleOutlined',1,0,0,0,0,null,'admin','2019-04-17 15:13:56','admin','2019-04-17 15:13:56',0,0,null,null);
INSERT INTO `t_sys_permission` (`id`,`parent_id`,`name`,`url`,`component`,`component_name`,`redirect`,`menu_type`,`perms`,`perms_type`,`sort_no`,`always_show`,`icon`,`is_route`,`is_leaf`,`keep_alive`,`hidden`,`hide_tab`,`description`,`create_by`,`create_time`,`update_by`,`update_time`,`del_flag`,`rule_flag`,`status`,`internal_or_external`) VALUES ('d7d6e2e4e2934fer98c2f3',null,'病历管理','/emr',null,null,null,0,null,'0',6.00,0,'FileDoneOutlined',1,0,0,0,0,null,'admin','2023-03-27 12:00:00','admin','2023-03-27 12:00:00',0,0,null,null);

