package cn.net.integration.modules.system.entity;

import cn.net.integration.core.common.api.vo.BaseModel;
import cn.net.integration.core.common.util.SnowFlakeUtil;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serial;

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


    public SysRole() {
        this.id = String.valueOf(new SnowFlakeUtil(16, 16).nextId());
    }
}
