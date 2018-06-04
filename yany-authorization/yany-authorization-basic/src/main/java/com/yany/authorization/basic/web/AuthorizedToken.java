package com.yany.authorization.basic.web;

/**
 * 已完成认证的令牌,如果返回此令牌,将直接使用{@link this#getUserId()}来绑定用户信息
 * <p>
 * Created by yanyong on 2018/4/26.
 */
public interface AuthorizedToken extends ParsedToken {

    String getUserId();

    /**
     * default关键字可以让接口中的方法可以有默认的函数体
     *
     * @return 令牌有效期，单位毫秒，-1为长期有效
     */
    default long getMaxInactiveInterval() {
        return -1;
    }

}
