package com.yany.authorization.basic.web;

/**
 * 令牌解析结果
 * Created by yanyong on 2018/4/26.
 */
public interface ParsedToken {

    /**
     * @return 令牌
     */
    String getToken();

    /**
     * @return 令牌类型
     */
    String getType();
}
