package cn.net.base.core;

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
    private String message = "";
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
        this.message = msg;
        this.data = data;
    }

    public boolean isSuccess() {
        return this.code == 200;
    }

    /**
     * 返回成功
     *
     * @param <T> 类型
     * @return 结果
     */
    public static <T> Response<T> success() {
        Response<T> r = new Response<T>();
        r.setCode(200);
        return r;
    }

    /**
     * 返回成功
     *
     * @param msg 消息
     * @param <T> 类型
     * @return 结果
     */
    public static <T> Response<T> success(String msg) {
        Response<T> r = new Response<T>();
        r.setCode(200);
        r.setData((T) msg);
        r.setMessage(msg);
        return r;
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

    /**
     * 返回成功
     *
     * @param msg  信息
     * @param data 数据
     * @param <T>  类型
     * @return 结果
     */
    public static <T> Response<T> success(String msg, T data) {
        Response<T> r = new Response<T>();
        r.setCode(200);
        r.setMessage(msg);
        r.setData(data);
        return r;
    }

    public static <T> Response<T> error(String msg, T data) {
        Response<T> r = new Response<T>();
        r.setCode(500);
        r.setMessage(msg);
        r.setData(data);
        return r;
    }

    public static <T> Response<T> error(String msg) {
        return error(500, msg);
    }

    public static <T> Response<T> error(int code, String msg) {
        Response<T> r = new Response<T>();
        r.setCode(code);
        r.setMessage(msg);
        return r;
    }

    public Response<T> error500(String message) {
        this.message = message;
        this.code = 500;
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String msg) {
        this.message = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
