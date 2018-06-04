package com.yany.authorization.oauth2.server.client;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by yanyong on 2018/5/6.
 */
public interface OAuth2Client extends Serializable {

    String getId();

    String getSecret();

    String getName();

    String getRedirectUtil();

    String getOwnId();

    Long getCreateTime();

    Byte getStatus();

    /**
     * @return 客户端支持的认证类型
     */
    Set<String> getSupportGrantTypes();

    Set<String> getDefaultGrantScope();


}
