package cn.net.system.service.impl;

import cn.net.base.core.domain.Response;
import cn.net.system.bean.SysUser;
import cn.net.system.service.ILoginService;
import org.springframework.stereotype.Service;

/**
 * @ClassName LoginServiceImpl
 * @Description 登录逻辑的实现类
 * @Author ycl
 * @Date 2024/4/26 下午5:33
 * @Version 1.0
 */
@Service
public class LoginServiceImpl implements ILoginService {


    /**
     * 系统登录逻辑
     *
     * @param user 用户信息
     * @return 返回登录结果
     */
    @Override
    public Response<SysUser> login(SysUser user) {
        return null;
    }
}
