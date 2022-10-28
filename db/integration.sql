/* 新建变量表 */
drop table if exists `sys_variable`;
create table `sys_variable` (
    `id` varchar(36) character set utf8mb4 collate utf8mb4_general_ci not null comment '变量ID' primary key,
    `create_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
    `create_time` datetime NULL DEFAULT NULL COMMENT '创建日期',
    `update_by` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新人',
    `update_time` datetime NULL DEFAULT NULL COMMENT '更新日期',
    `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '变量名字',
    `encrypt` bit NULL DEFAULT NULL COMMENT '是否加密',
    `encryption` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '加密方式',
    `value` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '变量值'
) engine = InnoDB character set = utf8mb4 collate = utf8mb4_general_ci row_format = DYNAMIC;