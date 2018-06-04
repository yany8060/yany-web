package com.yany.authorization.jwt;


import org.apache.commons.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by yanyong on 2018/4/23.
 */
public class JwtConfig {

    private String id = "yany-web-jwt";

    private String secret = Base64.encodeBase64String("yany.jwt.secret".getBytes());

    private int ttl = 60 * 60 * 1000;

    public int refreshTtl = 12 * 60 * 60 * 1000;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public int getRefreshTtl() {
        return refreshTtl;
    }

    public void setRefreshTtl(int refreshTtl) {
        this.refreshTtl = refreshTtl;
    }

    public SecretKey generalKey() {
        byte[] encodedKey = Base64.decodeBase64(secret);
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
