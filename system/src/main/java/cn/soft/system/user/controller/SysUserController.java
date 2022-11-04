package cn.soft.system.user.controller;

import cn.soft.common.api.vo.Result;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SysUserController
 * @Description 用户相关controller  如注册、用户管理等
 * @Author ycl
 * @Date 2022/11/4 12:56
 * @Version 1.0
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    /**
     * 用户注册
     *
     * @param data 注册数据
     * @return 返回注册结果
     */
    public Result<JSONObject> userRegister(@RequestBody JSONObject data) {
        return null;
    }
}
