package com.yany.authorization.jwt;

import com.alibaba.fastjson.JSON;
import com.yany.authorization.basic.web.AuthorizedToken;
import com.yany.authorization.basic.web.GeneratedToken;
import com.yany.authorization.basic.web.UserTokenGenerator;
import com.yany.core.id.IDGenerator;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.yany.authorization.jwt.JwtAuthorizedToken.TOKEN_TYPE;

/**
 * Created by yanyong on 2018/4/26.
 */
public class JwtTokenGenerator implements UserTokenGenerator {

    private JwtConfig jwtConfig;

    public JwtTokenGenerator(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    @Override
    public String getSupportTokenType() {
        return TOKEN_TYPE;
    }

    private String createToken() {
        return IDGenerator.MD5.generate();
    }

    @Override
    public GeneratedToken generate(AuthorizedToken authorizedToken) {
        String token = createToken();
        String userId = authorizedToken.getUserId();

        String subject = JSON.toJSONString(new JwtAuthorizedToken(token, userId));


        String jwtToken = createJWT(userId, subject, jwtConfig.getTtl());

//      String refreshToken = createJWT(jwtConfig.getId(), userId, jwtConfig.getRefreshTtl());
        int timeout = jwtConfig.getTtl();

        return new GeneratedToken() {
            @Override
            public Map<String, Object> getResponse() {
                Map<String, Object> map = new HashMap<>();
                map.put("token", jwtToken);
//                map.put("refreshToken", refreshToken);
                return map;
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
            public int getTimeout() {
                return timeout;
            }
        };
    }

    public String createJWT(String id, String subject, long ttlMillis) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        SecretKey key = jwtConfig.generalKey();
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setIssuedAt(now)//在什么时候签发的(UNIX时间)
                .setSubject(subject)//该JWT所面向的用户
                .signWith(signatureAlgorithm, key);

        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);//什么时候过期
        }
        return builder.compact();
    }
}
