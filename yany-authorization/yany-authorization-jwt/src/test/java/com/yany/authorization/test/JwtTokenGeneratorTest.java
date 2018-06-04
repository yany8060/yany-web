package com.yany.authorization.test;

import com.yany.authorization.basic.web.AuthorizedToken;
import com.yany.authorization.basic.web.GeneratedToken;
import com.yany.authorization.jwt.JwtConfig;
import com.yany.authorization.jwt.JwtTokenGenerator;
import org.junit.Test;

/**
 * Created by yanyong on 2018/4/27.
 */
public class JwtTokenGeneratorTest {
    JwtConfig jwtConfig = new JwtConfig();
    JwtTokenGenerator jwtTokenGenerator = new JwtTokenGenerator(jwtConfig);

    @Test
    public void generate() {
        GeneratedToken generatedToken = jwtTokenGenerator.generate(new AuthorizedToken() {
            @Override
            public String getUserId() {
                return "1234";
            }

            @Override
            public String getToken() {
                return null;
            }

            @Override
            public String getType() {
                return "jwt";
            }
        });

        System.out.println(generatedToken.getToken());
        System.out.println(generatedToken.getResponse().get("token"));

        jwtTokenGenerator.getSupportTokenType();

    }


}
