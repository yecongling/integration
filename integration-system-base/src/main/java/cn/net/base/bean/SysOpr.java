package cn.net.base.bean;

import java.io.Serial;
import java.io.Serializable;

/**
 * @ClassName SysOpr
 * @Description 系统操作员
 * @Author ycl
 * @Date 2024/5/11 上午9:32
 * @Version 1.0
 */
public class SysOpr implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String userId = "00001";
    private String userName = "admin";

    private String ipAddress = "";

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
