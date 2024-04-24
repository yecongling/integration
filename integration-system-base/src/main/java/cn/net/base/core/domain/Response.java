package cn.net.base.core.domain;

import java.io.Serial;
import java.io.Serializable;

/**
 * 封装返回数据的响应格式
 */
public class Response<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    // 返回代码
    private int code;
    // 返回消息
    private String msg;
    // 返回数据
    private T data;

    /**
     * 无参构造函数
     */
    public Response() {
    }

    /**
     * 构造函数
     *
     * @param code 代码
     * @param msg  消息
     * @param data 数据
     */
    public Response(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 返回成功
     *
     * @param data 数据
     * @param <T>  类型
     * @return 响应
     */
    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<>();
        response.setData(data);
        response.setCode(200);
        return response;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
