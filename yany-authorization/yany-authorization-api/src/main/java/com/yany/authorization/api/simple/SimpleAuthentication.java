package com.yany.authorization.api.simple;

import com.yany.authorization.api.Authentication;
import com.yany.authorization.api.Permission;
import com.yany.authorization.api.Role;
import com.yany.authorization.api.User;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yanyong on 2018/5/13.
 */
public class SimpleAuthentication implements Authentication {
    private User user;

    private List<Role> roles;

    private List<Permission> permissions;

    @Override
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public List<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public List<Permission> getPermissions() {
        return this.permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
