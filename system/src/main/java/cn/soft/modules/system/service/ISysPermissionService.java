package cn.soft.modules.system.service;

import cn.soft.common.api.vo.Result;
import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName ISysPermissionService
 * @Description 菜单权限业务层
 * @Author ycl
 * @Date 2022/12/22 12:04
 * @Version 1.0
 */
public interface ISysPermissionService {

    /**
     * 获取登录用户所拥有的权限
     *
     * @param userId 用户ID
     * @return 权限数据
     */
    Result<JSONObject> queryByUser(String userId);
}
