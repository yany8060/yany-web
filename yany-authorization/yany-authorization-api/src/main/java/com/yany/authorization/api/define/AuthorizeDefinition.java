package com.yany.authorization.api.define;

/**
 * 权限控制定义,定义权限控制的方式
 * Created by yanyong on 2018/5/13.
 */
public interface AuthorizeDefinition {


    /**
     * 优先级,如果获取到多个权限控制定义是,则先判断优先级高的
     *
     * @return 优先级
     */
    int getPriority();

}
