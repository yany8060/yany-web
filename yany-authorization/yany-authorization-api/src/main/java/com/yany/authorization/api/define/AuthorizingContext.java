package com.yany.authorization.api.define;

/**
 * 权限控制上下文
 * Created by yanyong on 2018/5/13.
 */
public class AuthorizingContext {
    private AuthorizeDefinition definition;


    public AuthorizeDefinition getDefinition() {
        return definition;
    }

    public void setDefinition(AuthorizeDefinition definition) {
        this.definition = definition;
    }
}
