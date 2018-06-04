package com.yany.commons.controller.message;

import java.io.Serializable;

/**
 * Created by yanyong on 2018/5/6.
 */
public class ResponseMessage<T> implements Serializable {
    protected String message;

    protected T result;

    protected int status;

    private Long timestamp;


    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public T getResult() {
        return result;
    }

    public ResponseMessage<T> status(int status) {
        this.status = status;
        return this;
    }

    private ResponseMessage<T> putTimeStamp() {
        this.timestamp = System.currentTimeMillis();
        return this;
    }

    public ResponseMessage<T> result(T result) {
        this.result = result;
        return this;
    }


    public static <T> ResponseMessage<T> error(int status, String message) {
        ResponseMessage<T> msg = new ResponseMessage<>();
        msg.message = message;
        msg.status = status;
        return msg.putTimeStamp();
    }

    public static <T> ResponseMessage<T> error(String message) {
        return error(500, message);
    }

    public static <T> ResponseMessage<T> ok(T result) {
        return new ResponseMessage<T>().result(result).putTimeStamp().status(200);
    }

    public static <T> ResponseMessage<T> ok() {
        return ok(null);
    }


}
