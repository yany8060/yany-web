package com.yany.authorization.jwt;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * Created by yanyong on 2018/4/23.
 */
@Configurable
public class JwtAutoConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "yany.authorize.jwt")
    public JwtConfig jwtConfig() {
        return new JwtConfig();
    }

    @Bean
    public JwtTokenGenerator jwtTokenGenerator(JwtConfig config) {
        return new JwtTokenGenerator(config);
    }

    @Bean
    public JwtTokenParser jwtTokenParser(JwtConfig config) {
        return new JwtTokenParser(config);
    }
}
