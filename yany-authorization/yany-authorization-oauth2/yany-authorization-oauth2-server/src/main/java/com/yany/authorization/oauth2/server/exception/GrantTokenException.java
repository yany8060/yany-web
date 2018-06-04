package com.yany.authorization.oauth2.server.exception;

import com.yany.authorization.oauth2.core.ErrorType;

/**
 * Created by yanyong on 2018/5/1.
 */
public class GrantTokenException extends RuntimeException {
    private ErrorType errorType;

    public GrantTokenException(ErrorType errorType) {
        this(errorType, errorType.message());
    }

    public GrantTokenException(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

    public ErrorType getErrorType() {
        return errorType;
    }
}
