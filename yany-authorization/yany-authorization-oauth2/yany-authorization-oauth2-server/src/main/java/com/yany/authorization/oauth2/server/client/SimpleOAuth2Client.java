package com.yany.authorization.oauth2.server.client;

import lombok.*;

import java.util.Set;

/**
 * Created by yanyong on 2018/5/6.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class SimpleOAuth2Client implements OAuth2Client {
    private String id;

    private String secret;

    private String name;

    private String redirectUri;

    private String ownerId;

    private Long createTime;

    private Byte status;

    private Set<String> supportGrantTypes;

    private Set<String> DefaultGrantScope;

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getSecret() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getRedirectUtil() {
        return null;
    }

    @Override
    public String getOwnId() {
        return null;
    }

    @Override
    public Long getCreateTime() {
        return null;
    }

    @Override
    public Byte getStatus() {
        return null;
    }

    @Override
    public Set<String> getSupportGrantTypes() {
        return null;
    }

    @Override
    public Set<String> getDefaultGrantScope() {
        return null;
    }
}
