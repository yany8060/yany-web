package com.yany.authorization.api;

import com.yany.authorization.api.access.DataAccessConfig;

import java.util.Set;

/**
 * Created by yanyong on 2018/5/8.
 */
public interface Permission {
    /**
     * 查询
     */
    String ACTION_QUERY = "query";
    /**
     * 获取明细
     */
    String ACTION_GET = "get";
    /**
     * 新增
     */
    String ACTION_ADD = "add";
    /**
     * 更新
     */
    String ACTION_UPDATE = "update";

    /**
     * 删除
     */
    String ACTION_DELETE = "delete";
    /**
     * 导入
     */
    String ACTION_IMPORT = "import";
    /**
     * 导出
     */
    String ACTION_EXPORT = "export";

    /**
     * 禁用
     */
    String ACTION_DISABLE = "disable";

    /**
     * 启用
     */
    String ACTION_ENABLE = "enable";

    /**
     * @return 权限ID，权限的唯一标识
     */
    String getId();

    /**
     * 用户对此权限的可操作事件(按钮)
     * <p>
     * ⚠️:任何时候都不应该对返回的Set进行写操作
     *
     * @return 如果没有配置返回空{@link Collections#emptySet()},不会返回null.
     */
    Set<String> getActions();


    /**
     * 用户对此权限持有的数据权限信息, 用于数据级别的控制
     * <p>
     * ⚠️:任何时候都不应该对返回的Set进行写操作
     *
     * @return 如果没有配置返回空{@link Collections#emptySet()},不会返回null.
     * @see DataAccessConfig
     * @see org.hswebframework.web.authorization.access.DataAccessController
     */
    Set<DataAccessConfig> getDataAccesses();
}
