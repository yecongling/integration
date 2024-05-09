package cn.net.engine.bean.connection;

import cn.net.base.bean.BaseModel;

import java.io.Serial;

/**
 * @ClassName Datasource
 * @Description 数据源
 * @Author ycl
 * @Date 2024/5/9 上午9:36
 * @Version 1.0
 */
public class Datasource extends BaseModel {
    @Serial
    private static final long serialVersionUID = 4638946782786699715L;
    /* 连接ID 连接以 */
    private String id;
    /* 数据源名 */
    private String name;
    /* 数据源类型 */
    private String datasourceType;
    /* 数据源连接的URL */
    private String url;
    /* 测试连接语句 */
    private String testQuery;
    /* 连接的用户名 */
    private String username;
    /* 连接的密码 */
    private String password;
    /* 使用变量密码（该值为true时，password使用变量替代，变量的维护在变量维护模块维护-使用groovy） */
    private Boolean variablePassword;
    /* 连接超时时间 */
    private Integer connectionTimeout;
    /* 闲置超时时间 */
    private Integer idleTimeout;
    /* 连接存活时间 */
    private Integer maxLifetime;
    /* 最小闲置连接数量 */
    private Integer minIdle;
    /* 最大连接池数量 */
    private Integer maxPoolSize;

    /* 备注 */
    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String datasourceId) {
        this.id = datasourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatasourceType() {
        return datasourceType;
    }

    public void setDatasourceType(String datasourceType) {
        this.datasourceType = datasourceType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTestQuery() {
        return testQuery;
    }

    public void setTestQuery(String testQuery) {
        this.testQuery = testQuery;
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

    public Boolean getVariablePassword() {
        return variablePassword;
    }

    public void setVariablePassword(Boolean variablePassword) {
        this.variablePassword = variablePassword;
    }

    public Integer getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(Integer connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public Integer getIdleTimeout() {
        return idleTimeout;
    }

    public void setIdleTimeout(Integer idleTimeout) {
        this.idleTimeout = idleTimeout;
    }

    public Integer getMaxLifetime() {
        return maxLifetime;
    }

    public void setMaxLifetime(Integer maxLifetime) {
        this.maxLifetime = maxLifetime;
    }

    public Integer getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(Integer minIdle) {
        this.minIdle = minIdle;
    }

    public Integer getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(Integer maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
