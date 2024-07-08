package cn.net.system.bean;

import cn.net.framework.annotation.Column;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统角色
 */
public class Role implements Serializable {
    // 角色id
    @Column("role_id")
    private String roleId;
    // 角色名称
    @Column("role_name")
    private String roleName;
    // 描述
    private String description;
    // 状态
    private int status;
    // 创建、更新人、时间信息
    @Column("create_time")
    private Date createTime;
    @Column("update_time")
    private Date updateTime;
    @Column("create_by")
    private String createBy;
    @Column("update_by")
    private String updateBy;

    // 该角色对应的权限菜单
    private List<Menu> menus;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

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

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
