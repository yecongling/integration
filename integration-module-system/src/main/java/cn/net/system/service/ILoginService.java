package cn.net.system.service;

import cn.net.base.core.domain.Response;
import cn.net.system.bean.SysUser;

/**
 * @ClassName ILoginService
 * @Description 系统登录service
 * @Author ycl
 * @Date 2024/04/26 11:01
 * @Version 1.0
 */
public interface ILoginService {

    /**
     * 系统登录逻辑
     * @param user 用户信息
     * @return 返回登录结果
     */
    Response<SysUser> login(SysUser user);
}
