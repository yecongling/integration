/*  新建用户信息表 */
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user`
(
    `id`             varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '主键id',
    `username`       varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录账号',
    `real_name`      varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
    `password`       varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
    `salt`           varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT 'md5密码盐',
    `avatar`         varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
    `birthday`       datetime                                                NULL DEFAULT NULL COMMENT '生日',
    `sex`            tinyint(1)                                              NULL DEFAULT NULL COMMENT '性别(0-默认未知,1-男,2-女)',
    `email`          varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '电子邮件',
    `phone`          varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '电话',
    `org_code`       varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '登录会话的机构编码',
    `status`         tinyint(1)                                              NULL DEFAULT NULL COMMENT '性别(1-正常,2-冻结)',
    `del_flag`       tinyint(1)                                              NULL DEFAULT NULL COMMENT '删除状态(0-正常,1-已删除)',
    `third_id`       varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '第三方登录的唯一标识',
    `third_type`     varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '第三方类型',
    `activity_sync`  tinyint(1)                                              NULL DEFAULT NULL COMMENT '同步工作流引擎(1-同步,0-不同步)',
    `work_no`        varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工号，唯一键',
    `post`           varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职务，关联职务表',
    `telephone`      varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '座机号',
    `create_by`      varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人',
    `create_time`    datetime                                                NULL DEFAULT NULL COMMENT '创建时间',
    `update_by`      varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '更新人',
    `update_time`    datetime                                                NULL DEFAULT NULL COMMENT '更新时间',
    `user_identity`  tinyint(1)                                              NULL DEFAULT NULL COMMENT '身份（1普通成员 2上级）',
    `depart_ids`     longtext CHARACTER SET utf8 COLLATE utf8_general_ci     NULL COMMENT '负责部门',
    `rel_tenant_ids` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '多租户标识',
    `client_id`      varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '设备ID',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `uniq_sys_user_work_no` (`work_no`) USING BTREE,
    UNIQUE INDEX `uniq_sys_user_username` (`username`) USING BTREE,
    UNIQUE INDEX `uniq_sys_user_phone` (`phone`) USING BTREE,
    UNIQUE INDEX `uniq_sys_user_email` (`email`) USING BTREE,
    INDEX `idx_su_username` (`username`) USING BTREE,
    INDEX `idx_su_status` (`status`) USING BTREE,
    INDEX `idx_su_del_flag` (`del_flag`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '用户表'
  ROW_FORMAT = Dynamic;

/* 新建系统角色表 */
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role`
(
    `id`          varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '主键id',
    `role_name`   varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
    `role_code`   varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色编码',
    `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
    `create_by`   varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '创建人',
    `create_time` datetime                                                NULL DEFAULT NULL COMMENT '创建时间',
    `update_by`   varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '更新人',
    `update_time` datetime                                                NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `uniq_sys_role_role_code` (`role_code`) USING BTREE,
    INDEX `idx_sr_role_code` (`role_code`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '角色表'
  ROW_FORMAT = Dynamic;

/* 新建用户角色关联表 */
DROP TABLE IF EXISTS `t_sys_user_role`;
CREATE TABLE `t_sys_user_role`
(
    `id`      varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
    `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
    `role_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色id',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `idx_sur_user_id` (`user_id`) USING BTREE,
    INDEX `idx_sur_role_id` (`role_id`) USING BTREE,
    INDEX `idx_sur_user_role_id` (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '用户角色表'
  ROW_FORMAT = Dynamic;

/*  ============== 以下是引擎部分需要的=================*/

/* 新建项目表 */


/* 新建变量表 */
drop table if exists `t_variable`;
create table `t_variable`
(
    `id`          varchar(36) character set utf8mb4 collate utf8mb4_general_ci  not null comment '变量ID',
    `create_by`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '创建人',
    `create_time` datetime                                                      NULL DEFAULT NULL COMMENT '创建日期',
    `update_by`   varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '更新人',
    `update_time` datetime                                                      NULL DEFAULT NULL COMMENT '更新日期',
    `name`        varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '变量名字',
    `encrypt`     bit                                                           NULL DEFAULT NULL COMMENT '是否加密',
    `encryption`  varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL COMMENT '加密方式',
    `value`       varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '变量值',
    primary key (`id`) using BTREE,
    index `idx_variable_id` (`id`) using btree
) engine = InnoDB
  character set = utf8mb4
  collate = utf8mb4_general_ci comment = '变量表'
  row_format = DYNAMIC;