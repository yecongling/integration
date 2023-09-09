package cn.net.integration.core.common.system.base.entity;

import java.io.Serializable;

/**
 * @TODO Entity基类
 * @Author ycl
 * @Date 2022/10/9 16:59
 * @Version 1.0
 */
public class IntegrationEntity implements Serializable {
    private static final long serialVersionUID = 3954077004876773333L;

    /**
     * id
     */
    private String id;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 修改时间
     */
    private String updateTime;
}
