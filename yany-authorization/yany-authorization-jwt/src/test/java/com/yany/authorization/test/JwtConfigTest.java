package com.yany.authorization.test;

import com.yany.authorization.jwt.JwtConfig;
import org.junit.Test;

import javax.crypto.SecretKey;

/**
 * Created by yanyong on 2018/4/27.
 */
public class JwtConfigTest {

    JwtConfig jwtConfig = new JwtConfig();

    @Test
    public void generalKey(){

        SecretKey secretKey = jwtConfig.generalKey();
        System.out.println(secretKey.getAlgorithm());

        secretKey.getFormat();



    }

}
