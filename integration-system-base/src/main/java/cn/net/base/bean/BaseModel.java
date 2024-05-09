package cn.net.base.bean;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName BaseModel
 * @Description 基础bean类
 * @Author ycl
 * @Date 2024/5/9 上午9:31
 * @Version 1.0
 */
public class BaseModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

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
