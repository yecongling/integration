package cn.net.integration.modules.system.service;


import cn.net.integration.core.common.api.vo.Result;
import cn.net.integration.modules.system.entity.SysLoginModel;
import cn.net.integration.modules.system.entity.SysUser;
import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName SysLoginService
 * @Description 系统登录service
 * @Author ycl
 * @Date 2022/10/28 11:01
 * @Version 1.0
 */
public interface ISysLoginService {

    /**
     * 登录逻辑
     *
     * @param loginModel 登录对象
     * @return 登录结果
     */
    Result<JSONObject> login(SysLoginModel loginModel) throws Exception;

    /**
     * 校验用户是否有效
     *
     * @param sysUser 用户信息
     * @return 校验结果
     */
    Result<JSONObject> checkUserIsEffective(SysUser sysUser) throws Exception;
}
