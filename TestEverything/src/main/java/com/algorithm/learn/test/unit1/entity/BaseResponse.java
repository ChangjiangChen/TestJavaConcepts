package com.algorithm.learn.test.unit1.entity;

/**
 * Created by wanglei on 2017/4/13.
 */
public class BaseResponse {
    /**
     * 结果代码，200成功
     */
    private int code;

    /**
     * 响应消息
     */
    private String msg;

    /**
     * 业务数据
     */
    private Object data;

    public BaseResponse() {
        this.code = 404;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
