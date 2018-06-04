package com.yany.authorization.api.builder;

/**
 * 数据权限配置构造器工厂
 * Created by yanyong on 2018/5/13.
 */
public interface DataAccessConfigBuilderFactory {

    /**
     * @return 新建一个数据权限配置构造器工厂
     */
    DataAccessConfigBuilder create();
}
