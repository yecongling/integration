package cn.soft.system.user.entity;

import cn.soft.common.api.vo.BaseModel;

/**
 * @ClassName SysUser
 * @Description 系统用户实体类
 * @Author 叶丛林
 * @Date 2022/10/30 22:04
 * @Version 1.0
 **/
public class SysUser extends BaseModel {

    private static final long serialVersionUID = -3557717365698975454L;

    private Integer id;

    private String username;

    private String password;

    private String salt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
