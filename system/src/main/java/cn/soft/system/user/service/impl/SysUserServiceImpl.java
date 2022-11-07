package cn.soft.system.user.service.impl;

import cn.soft.common.api.vo.Result;
import cn.soft.system.user.mapper.SysUserMapper;
import cn.soft.system.user.service.SysUserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SysUserServiceImpl
 * @Description 系统用户service实现类
 * @Author ycl
 * @Date 2022/11/4 13:02
 * @Version 1.0
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    private SysUserMapper userMapper;
    @Autowired
    public void setUserMapper(SysUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 用户注册
     *
     * @param jsonObject 注册信息
     * @return 注册结果
     */
    @Override
    public Result<JSONObject> register(JSONObject jsonObject) {

        return null;
    }
}
