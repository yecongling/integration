package cn.net.integration.system.modules.engine.entity.resource;

import cn.net.integration.core.common.api.vo.BaseModel;

import java.io.Serial;

/**
 * @ClassName VariableModel
 * @Description 系统变量
 * @Author 叶丛林
 * @Date 2022/10/28 22:34
 * @Version 1.0
 **/
public class VariableModel extends BaseModel {

    @Serial
    private static final long serialVersionUID = 8967226505071996202L;
    /* 变量id 以variable_开头 */
    private String variableId;
    /* 变量名 */
    private String variableName;
    /* 变量值 */
    private String variableValue;
    /* 是否加密 */
    private Boolean encrypt;
    /* 加密方式 */
    private String encryption;

    public String getVariableId() {
        return variableId;
    }

    public void setVariableId(String variableId) {
        this.variableId = variableId;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public String getVariableValue() {
        return variableValue;
    }

    public void setVariableValue(String variableValue) {
        this.variableValue = variableValue;
    }

    public Boolean getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(Boolean encrypt) {
        this.encrypt = encrypt;
    }

    public String getEncryption() {
        return encryption;
    }

    public void setEncryption(String encryption) {
        this.encryption = encryption;
    }
}
