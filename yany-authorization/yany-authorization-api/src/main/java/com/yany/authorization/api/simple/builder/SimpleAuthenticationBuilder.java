package com.yany.authorization.api.simple.builder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yany.authorization.api.Authentication;
import com.yany.authorization.api.Permission;
import com.yany.authorization.api.Role;
import com.yany.authorization.api.User;
import com.yany.authorization.api.builder.AuthenticationBuilder;
import com.yany.authorization.api.builder.DataAccessConfigBuilderFactory;
import com.yany.authorization.api.simple.SimpleAuthentication;
import com.yany.authorization.api.simple.SimplePermission;
import com.yany.authorization.api.simple.SimpleRole;
import com.yany.authorization.api.simple.SimpleUser;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by yanyong on 2018/5/13.
 */
public class SimpleAuthenticationBuilder implements AuthenticationBuilder {
    private SimpleAuthentication authentication = new SimpleAuthentication();

    private DataAccessConfigBuilderFactory dataBuilderFactory;

    @Override
    public AuthenticationBuilder user(User user) {
        Objects.requireNonNull(user);
        authentication.setUser(user);
        return this;
    }

    @Override
    public AuthenticationBuilder user(String user) {
        return user(JSON.parseObject(user, SimpleUser.class));
    }

    @Override
    public AuthenticationBuilder user(Map<String, String> user) {
        Objects.requireNonNull(user.get("id"));
        user(SimpleUser.builder()
                .id(user.get("id"))
                .username(user.get("username"))
                .name(user.get("name"))
                .type(user.get("type"))
                .build());
        return null;
    }

    @Override
    public AuthenticationBuilder role(List<Role> role) {
        authentication.setRoles(role);
        return this;
    }

    @Override
    public AuthenticationBuilder role(String role) {
        return role((List) JSON.parseArray(role, SimpleRole.class));
    }

    @Override
    public AuthenticationBuilder permission(List<Permission> permission) {
        authentication.setPermissions(permission);
        return this;
    }

    @Override
    public AuthenticationBuilder permission(String permissionJson) {
        JSONArray jsonArray = JSON.parseArray(permissionJson);
        List<Permission> permissions = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            SimplePermission permission = new SimplePermission();
            permission.setId(jsonObject.getString("id"));

            JSONArray actions = jsonObject.getJSONArray("actions");
            if (actions != null) {
                permission.setActions(new HashSet<>(actions.toJavaList(String.class)));
            }
            JSONArray dataAccess = jsonObject.getJSONArray("dataAccesses");
            if (null != dataAccess) {
                permission.setDataAccesses(dataAccess.stream().map(JSONObject.class::cast)
                        .map(dataJson -> dataBuilderFactory.create().fromJson(dataJson.toJSONString()).build())
                        .filter(Objects::nonNull)
                        .collect(Collectors.toSet()));
            }
            permissions.add(permission);
        }

        authentication.setPermissions(permissions);
        return this;
    }

    @Override
    public AuthenticationBuilder attributes(String attributes) {
        return this;
    }

    @Override
    public AuthenticationBuilder attributes(Map<String, Serializable> permission) {
        return null;
    }

    @Override
    public AuthenticationBuilder json(String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        user(jsonObject.getObject("user", SimpleUser.class));
        role(jsonObject.getJSONArray("roles").toJSONString());
        permission(jsonObject.getJSONArray("permissions").toJSONString());
        return this;
    }

    @Override
    public Authentication build() {
        return authentication;
    }
}
