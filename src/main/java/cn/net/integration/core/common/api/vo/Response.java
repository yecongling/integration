package cn.net.integration.core.common.api.vo;

import java.io.Serial;
import java.io.Serializable;

/**
 * 封装返回数据格式
 *
 * @param <T>
 */
public class Response<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 返回处理消息
     */
    private String message = "";

    /**
     * 返回代码
     */
    private Integer code = 200;

    /**
     * 返回数据对象 data
     */
    private T result;

    /**
     * 时间戳
     */
    private long timestamp = System.currentTimeMillis();

    public Response() {
    }

    /**
     * 构造器
     *
     * @param code    编码
     * @param message 消息
     */
    public Response(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public boolean isSuccess() {
        return this.code == 200;
    }

    /**
     * 返回成功
     *
     * @param <T>
     * @return
     */
    public static <T> Response<T> success() {
        Response<T> r = new Response<T>();
        r.setCode(200);
        return r;
    }

    /**
     * 返回成功
     *
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> Response<T> success(String msg) {
        Response<T> r = new Response<T>();
        r.setCode(200);
        r.setResult((T) msg);
        r.setMessage(msg);
        return r;
    }

    /**
     * 返回成功
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Response<T> success(T data) {
        Response<T> r = new Response<T>();
        r.setCode(200);
        r.setResult(data);
        return r;
    }

    /**
     * 返回成功
     *
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Response<T> success(String msg, T data) {
        Response<T> r = new Response<T>();
        r.setCode(200);
        r.setMessage(msg);
        r.setResult(data);
        return r;
    }

    public static <T> Response<T> error(String msg, T data) {
        Response<T> r = new Response<T>();
        r.setCode(500);
        r.setMessage(msg);
        r.setResult(data);
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
