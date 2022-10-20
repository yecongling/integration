package com.soft.common.api.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * model基础类
 * 封装子model公用部分
 */
public class BaseModel implements Serializable {
    private static final long serialVersionUID = 2261134664715644382L;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 最新修改时间
     */
    private Date updateTime;

    /**
     * 创建人ID
     *
     */
    private String createBy;

    /**
     * 最新修改人ID
     */
    private String updateBy;
}
