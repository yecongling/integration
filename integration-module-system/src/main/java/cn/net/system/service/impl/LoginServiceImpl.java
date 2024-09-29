package cn.net.system.service.impl;

import cn.net.base.bean.SysOpr;
import cn.net.base.constant.CommonConstant;
import cn.net.base.core.Response;
import cn.net.base.utils.PasswordUtils;
import cn.net.base.utils.SpringContextUtils;
import cn.net.base.utils.UUIDUtils;
import cn.net.framework.event.BaseEvent;
import cn.net.framework.event.Producer;
import cn.net.framework.redis.RedisUtil;
import cn.net.system.bean.SysUser;
import cn.net.system.mapper.UserMapper;
import cn.net.system.service.ILoginService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
    private final Producer<Object> producer;
    // redis相关的类
    private final RedisUtil redisUtil;

    @Autowired
    public LoginServiceImpl(UserMapper userMapper, Producer<Object> producer, RedisUtil redisUtil) {
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
    public Response<Object> login(SysUser user) throws Exception {
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
        if (Objects.equals(sysUser.getStatus(), CommonConstant.USER_FREEZE)) {
            return Response.error("该账号已冻结，冻结时间：" + sysUser.getUpdateTime().toString());
        }
        // 登录成功后获取向前端返回token
        String token = UUIDUtils.getUniqueId();
        SysOpr sysOpr = new SysOpr();
        sysOpr.setUserId(sysUser.getUserId());
        sysOpr.setUserName(sysUser.getUsername());
        // 记录操作员的登录地址方便做审计
        HttpServletRequest request = SpringContextUtils.getHttpServletRequest();
        String localAddr = request.getLocalAddr();
        sysOpr.setIpAddress(localAddr);
        // token有效期30分钟
        redisUtil.set(token, sysOpr, 1800);
        // 发送消息用于记录登录日志
        BaseEvent<Object> event = new BaseEvent<>(sysUser, "login");
        producer.publishEvent(event);
        Map<String, Object> data = new HashMap<>();
        data.put("token", token);
        // 这里需要查询用户自己配置的书页面以及用户的角色信息，然后后面才会根据角色来显示系统的菜单
        data.put("homePath", "/home");
        data.put("roleId", "admin");
        return Response.success(data);
    }

    /**
     * 退出登录
     *
     * @param token 用户token
     * @return 返回退出登录结果
     */
    @Override
    public Response<Object> logout(String token) {
        // 从redis删除用户的token
        Object o = redisUtil.get(token);
        redisUtil.delete(token);

        // 记录退出登录日志
        BaseEvent<Object> logout = new BaseEvent<>(o, "logout");
        producer.publishEvent(logout);
        return Response.success();
    }
}
