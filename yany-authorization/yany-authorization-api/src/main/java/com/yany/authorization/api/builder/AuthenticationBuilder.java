package com.yany.authorization.api.builder;

import com.yany.authorization.api.Authentication;
import com.yany.authorization.api.Permission;
import com.yany.authorization.api.Role;
import com.yany.authorization.api.User;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by yanyong on 2018/5/13.
 */
public interface AuthenticationBuilder extends Serializable {
    AuthenticationBuilder user(User user);

    AuthenticationBuilder user(String user);

    AuthenticationBuilder user(Map<String, String> user);


    AuthenticationBuilder role(List<Role> role);

    AuthenticationBuilder role(String role);


    AuthenticationBuilder permission(List<Permission> permission);

    AuthenticationBuilder permission(String permission);

    AuthenticationBuilder attributes(String attributes);

    AuthenticationBuilder attributes(Map<String, Serializable> permission);

    AuthenticationBuilder json(String json);

    Authentication build();
}
