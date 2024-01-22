package cn.net.integration.modules.system.entity;

import cn.net.integration.core.common.api.vo.BaseModel;
import cn.net.integration.core.common.util.SnowFlakeUtil;

import java.io.Serial;

/**
 * @ClassName SysUserRole
 * @Description 用户角色关联信息对象
 * @Author ycl
 * @Date 2022/11/8 13:01
 * @Version 1.0
 */
public class SysRole extends BaseModel {
    @Serial
    private static final long serialVersionUID = 905627383669213208L;

    /* 表ID 主键 */
    private String id;
    /* 用户ID */
    private String userId;
    /* 角色ID */
    private String roleId;

    public SysRole() {
        this.id = String.valueOf(new SnowFlakeUtil(16, 16).nextId());
    }

    public SysRole(String userId, String roleId) {
        this.id = String.valueOf(new SnowFlakeUtil(16, 16).nextId());
        this.userId = userId;
        this.roleId = roleId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
