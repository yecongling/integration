package cn.net.system.service.impl;

import cn.net.base.constant.CommonConstant;
import cn.net.base.core.domain.Response;
import cn.net.base.utils.PasswordUtils;
import cn.net.framework.event.Producer;
import cn.net.framework.redis.RedisUtil;
import cn.net.system.bean.SysUser;
import cn.net.system.mapper.UserMapper;
import cn.net.system.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final UserMapper userMapper;

    // 消息生产者
    private final Producer producer;
    // redis相关的类
    private final RedisUtil redisUtil;

    @Autowired
    public LoginServiceImpl(UserMapper userMapper, Producer producer, RedisUtil redisUtil) {
        this.userMapper = userMapper;
        this.producer = producer;
        this.redisUtil = redisUtil;
    }

    /**
     * 系统登录逻辑
     *
     * @param user 用户信息
     * @return 返回登录结果
     */
    @Override
    public Response<SysUser> login(SysUser user) throws Exception {
        // 先从数据库中根据用户名查询用户是否存在
        SysUser sysUser = userMapper.getUserByUsername(user.getUsername());
        if (sysUser == null) {
            return Response.error("用户名不存在！");
        }
        // 验证密码
        String username = user.getUsername();
        // 校验用户名密码是否正确
        String encrypt = PasswordUtils.encrypt(username, user.getPassword(), sysUser.getSalt());
        String sysPassword = sysUser.getPassword();
        if (!sysPassword.equals(encrypt)) {
            return Response.error("用户名或密码错误！");
        }
        // 验证角色
        // 验证账号状态
        // 登录成功后获取向前端返回token
        String token = "";
        // token有效期30分钟
        redisUtil.set(CommonConstant.USER_TOKEN_PREFIX + username, token, 1800);
        // 发送消息用于记录
        producer.publishEvent("");
        return Response.success(token);
    }
}
