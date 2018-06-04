package com.yany.authorization.api.builder;

import com.yany.authorization.api.access.DataAccessConfig;

/**
 * Created by yanyong on 2018/5/13.
 */
public interface DataAccessConfigBuilder {

    DataAccessConfigBuilder fromJson(String json);

    DataAccessConfig build();

}
