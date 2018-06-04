package com.yany.authorization.api.exception;

import com.yany.authorization.api.token.TokenState;

/**
 * Created by yanyong on 2018/5/13.
 */
public class UnAuthorizedException extends RuntimeException {
    private TokenState state;

    public UnAuthorizedException() {
        this(TokenState.expired);
    }

    public UnAuthorizedException(TokenState state) {
        this(state.getText(), state);
    }

    public UnAuthorizedException(String message, TokenState state) {
        super(message);
        this.state = state;
    }

    public UnAuthorizedException(String message, TokenState state, Throwable cause) {
        super(message, cause);
        this.state = state;
    }

    public TokenState getState() {
        return state;
    }

}
