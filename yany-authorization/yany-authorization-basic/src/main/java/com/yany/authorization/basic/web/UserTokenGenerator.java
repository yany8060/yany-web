package com.yany.authorization.basic.web;

/**
 * 用户令牌生产器，用于在用户进行授权后生成令牌
 * <p>
 * Created by yanyong on 2018/4/26.
 */
public interface UserTokenGenerator {
    String TOKEN_TYPE_SESSION_ID = "sessionId";

    String TOKEN_TYPE_SIMPLE = "simple-token";

    String getSupportTokenType();

    /**
     * @param authorizedToken
     * @return
     */
    GeneratedToken generate(AuthorizedToken authorizedToken);

}
