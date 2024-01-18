package cn.net.integration.core.common.api.vo;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * model基础类
 * 封装子model公用部分
 */
public class BaseModel implements Serializable {
    @Serial
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
}
