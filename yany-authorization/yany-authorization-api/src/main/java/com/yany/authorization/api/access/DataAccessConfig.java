package com.yany.authorization.api.access;

import java.io.Serializable;

/**
 * 数据级的权限控制,此接口为控制方式配置
 *
 * Created by yanyong on 2018/5/13.
 */
public interface DataAccessConfig extends Serializable {

    String getAction();

    String getType();


    /**
     * 内置的控制方式
     */
    interface DefaultType {
        /**
         * 自己创建的数据
         *
         * @see OwnCreatedDataAccessConfig#getType()
         */
        String OWN_CREATED = "OWN_CREATED";
        /**
         * 字段值范围
         *
         * @see FieldScopeDataAccessConfig#getType()
         */
        String FIELD_SCOPE = "FIELD_SCOPE";

        /**
         * 字段过滤,黑名单
         *
         * @see FieldFilterDataAccessConfig#getType()
         */
        String DENY_FIELDS = "DENY_FIELDS";

        /**
         * 自定义脚本方式
         *
         * @see ScriptDataAccessConfig#getType()
         */
        String SCRIPT = "SCRIPT";

        /**
         * 自定义控制器
         *
         * @see CustomDataAccessConfig#getType()
         */
        String CUSTOM = "CUSTOM";
    }

}
