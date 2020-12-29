package cn.javayuli.core.entity;

import cn.hutool.http.HttpStatus;

/**
 * 公共返回类
 *
 * @author hanguilin
 */
public class Rest<T> {

    private Integer code;

    private String msg;

    private T data;

    public Rest(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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

    public static <T> Rest success(String msg, T data) {
        return new Rest(HttpStatus.HTTP_OK, msg, data);
    }

    public static <T> Rest success(T data) {
        return new Rest(HttpStatus.HTTP_OK, "成功", data);
    }

    public static <T> Rest success() {
        return new Rest(HttpStatus.HTTP_OK, "成功", null);
    }

    public static <T> Rest fail(String msg, Integer code) {
        return new Rest(code, msg, null);
    }

    public static <T> Rest fail(String msg) {
        return new Rest(HttpStatus.HTTP_INTERNAL_ERROR, msg, null);
    }
}
