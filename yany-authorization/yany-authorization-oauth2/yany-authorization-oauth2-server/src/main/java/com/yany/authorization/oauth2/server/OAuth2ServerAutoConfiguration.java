package com.yany.authorization.oauth2.server;

import com.yany.authorization.oauth2.server.client.SimpleOAuth2Client;
import com.yany.authorization.oauth2.server.exception.GrantTokenException;
import com.yany.commons.controller.message.ResponseMessage;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by yanyong on 2018/5/1.
 */
@Configurable
public class OAuth2ServerAutoConfiguration {

    @Bean
    public OAuth2ServerErrorControllerAdvice oAuth2ServerErrorControllerAdvice() {
        return new OAuth2ServerErrorControllerAdvice();
    }

    @RestControllerAdvice
    public class OAuth2ServerErrorControllerAdvice {

        @ExceptionHandler(GrantTokenException.class)
        @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
        public ResponseMessage<String> error(GrantTokenException e) {
            return ResponseMessage.<String>error(e.getErrorType().code(), e.getMessage())
                    .result(e.getErrorType().message());
        }
    }
}
