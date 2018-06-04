package com.yany.authorization.api.token;

import com.yany.core.dict.EnumDict;

/**
 * Created by yanyong on 2018/5/13.
 */
public enum TokenState implements EnumDict<String> {
    /**
     * 正常，有效
     */
    effective("effective", "正常"),

    /**
     * 已被禁止访问
     */
    deny("deny", "已被禁止访问"),

    /**
     * 已过期
     */
    expired("expired", "用户未登录"),

    /**
     * 已被踢下线
     */
    offline("offline", "用户已在其他地方登录"),

    /**
     * 锁定
     */
    lock("lock", "登录状态已被锁定");

    TokenState(String value, String text) {
        this.value = value;
        this.text = text;
    }

    private String value;

    private String text;

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getText() {
        return text;
    }
}
