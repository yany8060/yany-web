package com.yany.authorization.api;

import java.io.Serializable;

/**
 * 用户信息
 * Created by yanyong on 2018/5/8.
 */
public interface User extends Serializable {
    /**
     * @return 用户ID
     */
    String getId();

    /**
     * @return 用户名
     */
    String getUsername();

    /**
     * @return 姓名
     */
    String getName();

    String getType();
}
