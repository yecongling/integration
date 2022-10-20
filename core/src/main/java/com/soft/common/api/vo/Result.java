package com.soft.common.api.vo;

import java.io.Serializable;

/**
 * 封装返回数据格式
 *
 * @param <T>
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 2559075582944212726L;

    /**
     * 成功标志
     */
    private boolean success = true;

    /**
     * 返回处理消息
     */
    private String message = "";

    /**
     * 返回代码
     */
    private Integer code = 0;

    /**
     * 返回数据对象
     */
    private T result;

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();
}
