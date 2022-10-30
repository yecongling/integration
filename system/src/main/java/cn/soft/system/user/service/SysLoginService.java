package cn.soft.system.user.service;

import cn.soft.system.user.entity.SysLoginModel;
import com.alibaba.fastjson.JSONObject;
import cn.soft.common.api.vo.Result;

/**
 * @ClassName SysLoginService
 * @Description 系统登录service
 * @Author ycl
 * @Date 2022/10/28 11:01
 * @Version 1.0
 */
public interface SysLoginService {

    /**
     * 登录逻辑
     *
     * @param loginModel 登录对象
     * @return 登录结果
     */
    Result<JSONObject> login(SysLoginModel loginModel);
}
