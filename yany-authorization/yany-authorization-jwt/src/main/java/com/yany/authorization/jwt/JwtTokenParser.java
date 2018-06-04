package com.yany.authorization.jwt;

import com.alibaba.fastjson.JSON;
import com.yany.authorization.basic.web.ParsedToken;
import com.yany.authorization.basic.web.UserTokenParser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by yanyong on 2018/4/26.
 */
public class JwtTokenParser implements UserTokenParser {
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenParser.class);

    private JwtConfig jwtConfig;

    public JwtTokenParser(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }


    @Override
    public ParsedToken parsToken(String headerToken) {
        if (headerToken != null) {
            try {
                Claims claims = parseJWT(headerToken);
                if (claims.getExpiration().getTime() <= System.currentTimeMillis()) {
                    return null;
                }
                return JSON.parseObject(claims.getSubject(), JwtAuthorizedToken.class);
            } catch (ExpiredJwtException e) {
                return null;
            }
        }
        return null;
    }

    @Override
    public ParsedToken parsToken(HttpServletRequest request) {
        String headerToken = request.getHeader("jwt-token");
        if (StringUtils.isEmpty(headerToken)) {
            headerToken = request.getHeader("Authorization");
            if (StringUtils.isEmpty(headerToken)) {
                String[] auth = headerToken.split("[ ]");
                if (auth[0].equalsIgnoreCase("jwt") || auth[0].equalsIgnoreCase("Bearer")) {
                    headerToken = auth[1];
                } else {
                    return null;
                }
            }
        }

        return parsToken(headerToken);
    }

    public Claims parseJWT(String jwt) {
        SecretKey key = jwtConfig.generalKey();
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwt)
                .getBody();
    }
}
