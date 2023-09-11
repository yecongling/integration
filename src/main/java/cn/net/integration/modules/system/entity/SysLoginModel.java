package cn.net.integration.modules.system.entity;

import java.io.Serializable;

/**
 * @ClassName SysLoginModel
 * @Description 系统登录实体类封装
 * @Author ycl
 * @Date 2022/10/28 11:11
 * @Version 1.0
 */
public class SysLoginModel implements Serializable {
    private static final long serialVersionUID = -1283938764867538048L;
    /* 用户登录账号 */
    private String username;
    /* 用户登录密码 */
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
