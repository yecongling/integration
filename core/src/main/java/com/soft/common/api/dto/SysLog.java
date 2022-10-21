package com.soft.common.api.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @TODO 系统日志对象封装
 * @Author ycl
 * @Date 2022/10/21 12:46
 * @Version 1.0
 */
public class SysLog implements Serializable {

    private static final long serialVersionUID = 693954259809170201L;
    /**
     * 日志ID
     */
    private String id;

    /**
     * 创建人（产生这条日志的操作员是哪个）
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 日志类型 考虑后续定义常量
     * 0-操作日志
     * 1-登陆日志
     * 2-定时任务
     * ……
     */
    private Integer logType;

    /**
     * 操作类型 考虑后续定义常量
     * 1-新增
     * 2-修改
     * 3-删除
     * ……
     */
    private Integer operatorType;
}
