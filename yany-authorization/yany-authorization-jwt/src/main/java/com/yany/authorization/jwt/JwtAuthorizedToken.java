package com.yany.authorization.jwt;

import com.yany.authorization.basic.web.AuthorizedToken;

/**
 * Created by yanyong on 2018/4/26.
 */
public class JwtAuthorizedToken implements AuthorizedToken {

    public static final String TOKEN_TYPE = "jwt";

    private String token;

    private String userId;

    public JwtAuthorizedToken(String token, String userId) {
        this.token = token;
        this.userId = userId;
    }

    @Override
    public String getToken() {
        return token;
    }

    @Override
    public String getType() {
        return TOKEN_TYPE;
    }

    @Override
    public String getUserId() {
        return userId;
    }
}
