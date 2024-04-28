package cn.net.system.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;

/**
 * @ClassName SysUser
 * @Description 系统用户模块
 * @Author ycl
 * @Date 2024/4/26 下午5:30
 * @Version 1.0
 */
@JsonIgnoreProperties(value = {"password"}, allowSetters = true)
public class SysUser implements Serializable {
    @Serial
    private static final long serialVersionUID = -1283938764867538048L;

    /* 用户登录账号 */
    @NotEmpty(message = "用户名不能为空！")
    private String username;

    /* 用户登录密码 */
    @NotEmpty(message = "密码不能为空！")
    @Size(min = 8, message = "密码长度不能小于8！")
    private String password;

    /**
     * md5密码盐
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String salt;

    // 登录选择的角色
    private String roleId;

    // 登录的验证码
    private String code;

    // 登录用户携带的token
    private String token;

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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
