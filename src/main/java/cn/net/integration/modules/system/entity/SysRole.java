package cn.net.integration.modules.system.entity;

import cn.net.integration.core.common.api.vo.BaseModel;
import cn.net.integration.core.common.util.SnowFlakeUtil;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serial;
import java.util.Date;

/**
 * @ClassName SysUserRole
 * @Description 角色
 * @Author ycl
 * @Date 2022/11/8 13:01
 * @Version 1.0
 */
public class SysRole extends BaseModel {
    @Serial
    private static final long serialVersionUID = 905627383669213208L;

    /* 角色ID 主键 */
    @TableId
    private String id;
    // 角色名
    private String roleName;

    private String roleCode;

    private String description;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;


    public SysRole() {
        this.id = String.valueOf(new SnowFlakeUtil(16, 16).nextId());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getCreateBy() {
        return createBy;
    }

    @Override
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String getUpdateBy() {
        return updateBy;
    }

    @Override
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
