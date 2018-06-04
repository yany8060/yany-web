package com.yany.authorization.oauth2.core;

/**
 * Created by yanyong on 2018/5/1.
 */
public enum ErrorType {

    ILLEGAL_CODE(1001), //错误的授权码
    ILLEGAL_ACCESS_TOKEN(1002), //错误的access_token
    ILLEGAL_CLIENT_ID(1003),//客户端信息错误
    ILLEGAL_CLIENT_SECRET(1004),//客户端密钥错误
    ILLEGAL_GRANT_TYPE(1005), //错误的授权方式
    ILLEGAL_RESPONSE_TYPE(1006),//response_type 错误
    ILLEGAL_AUTHORIZATION(1007),//Authorization 错误
    ILLEGAL_REFRESH_TOKEN(1008),//refresh_token 错误
    ILLEGAL_REDIRECT_URI(1009), //redirect_url 错误
    ILLEGAL_SCOPE(1010), //scope 错误
    ILLEGAL_USERNAME(1011), //username 错误
    ILLEGAL_PASSWORD(1012), //password 错误

    SCOPE_OUT_OF_RANGE(2010), //scope超出范围

    UNAUTHORIZED_CLIENT(4010), //无权限
    EXPIRED_TOKEN(4011), //TOKEN过期
    INVALID_TOKEN(4012), //TOKEN已失效
    UNSUPPORTED_GRANT_TYPE(4013), //不支持的认证类型
    UNSUPPORTED_RESPONSE_TYPE(4014), //不支持的响应类型

    EXPIRED_CODE(4015), //AUTHORIZATION_CODE过期
    EXPIRED_REFRESH_TOKEN(4020), //REFRESH_TOKEN过期

    CLIENT_DISABLED(4016),//客户端已被禁用

    CLIENT_NOT_EXIST(4040),//客户端不存在

    USER_NOT_EXIST(4041),//客户端不存在

    ACCESS_DENIED(503), //访问被拒绝

    OTHER(5001), //其他错误

    PARSE_RESPONSE_ERROR(5002),//解析返回结果错误

    SERVICE_ERROR(5003); //服务器返回错误信息


    private final String message;
    private final int code;


    ErrorType(int code) {
        this.code = code;
        message = this.name().toLowerCase();
    }

    ErrorType(int code, String message) {
        this.message = message;
        this.code = code;
    }

    public String message() {
        if (message == null) {
            return this.name();
        }
        return message;
    }

    public int code() {
        return code;
    }
}
