package com.zy.alibaba.utils;

import java.io.Serializable;

/**
 * 响应
 * @param <T>
 */
public class  ResponseBody<T>  implements Serializable {

    private String msg = "数据处理成功";

    private T Data;

    private boolean success;

    public String getMsg() {
        return msg;
    }

    public ResponseBody setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return Data;
    }

    public ResponseBody setData(T data) {
        Data = data;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public ResponseBody setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public static ResponseBody ok(Object data) {
        ResponseBody responseBody = new ResponseBody();
        responseBody.setData(data);
        responseBody.msg = "数据处理成功";
        responseBody.setSuccess(true);
        return  responseBody;
    }
}
