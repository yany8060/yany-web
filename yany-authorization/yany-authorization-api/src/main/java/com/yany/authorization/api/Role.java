package com.yany.authorization.api;

import java.io.Serializable;

/**
 * 角色信息
 * Created by yanyong on 2018/5/8.
 */
public interface Role extends Serializable {

    /**
     * @return 角色ID
     */
    String getId();

    /**
     * @return 角色名
     */
    String getName();
}
