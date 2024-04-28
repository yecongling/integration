package cn.net.system.service.impl;

import cn.net.system.mapper.UserMapper;
import cn.net.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description 用户service实现类
 * @Author ycl
 * @Date 2024/4/28 下午1:52
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements IUserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

}
