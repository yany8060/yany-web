package com.yany.authorization.test;

import com.yany.authorization.jwt.JwtConfig;
import com.yany.authorization.jwt.JwtTokenParser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import org.junit.Test;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;

/**
 * Created by yanyong on 2018/4/27.
 */
public class JwtTokenParserTest {
    JwtConfig jwtConfig = new JwtConfig();
    JwtTokenParser jwtTokenParser  = new JwtTokenParser(jwtConfig);

    @Test
    public void parse(){
        String headToken = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMjM0IiwiaWF0IjoxNTI0Nzk4NTkxLCJzdWIiOiJ7XCJtYXhJbmFjdGl2ZUludGVydmFsXCI6LTEsXCJ0b2tlblwiOlwiOGRjOTdlMTZmYjRhZTY3ZDcyNjk3ODEzZjE3YjU5NzFcIixcInR5cGVcIjpcImp3dFwiLFwidXNlcklkXCI6XCIxMjM0XCJ9IiwiZXhwIjoxNTI0ODAyMTkxfQ.lFflfOfJqgcOm9ct2vupWUgJY6R7RGGsq_SurK1Jk3Q";

        Claims claims = jwtTokenParser.parseJWT(headToken);
        System.out.println(claims.getExpiration());
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());




    }


}
