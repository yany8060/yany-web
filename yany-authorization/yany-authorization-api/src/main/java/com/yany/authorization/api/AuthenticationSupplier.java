package com.yany.authorization.api;

import java.util.function.Supplier;

/**
 * Created by yanyong on 2018/5/9.
 */
public interface AuthenticationSupplier extends Supplier<Authentication> {
    Authentication get(String userId);
}
