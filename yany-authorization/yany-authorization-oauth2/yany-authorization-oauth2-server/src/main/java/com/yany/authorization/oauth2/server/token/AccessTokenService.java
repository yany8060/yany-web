package com.yany.authorization.oauth2.server.token;

import com.yany.authorization.oauth2.server.OAuth2AccessToken;

/**
 * Created by yanyong on 2018/5/6.
 */
public interface AccessTokenService {

    OAuth2AccessToken createToken();

    OAuth2AccessToken tryGetOldToken(OAuth2AccessToken token);

    OAuth2AccessToken getTokenByRefreshToken(String refreshToken);

    OAuth2AccessToken getTokenByAccessToken(String accessToken);

    OAuth2AccessToken saveOrUpdateToken(OAuth2AccessToken token);

}
