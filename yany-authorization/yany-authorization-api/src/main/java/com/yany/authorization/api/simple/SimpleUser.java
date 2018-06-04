package com.yany.authorization.api.simple;

import com.yany.authorization.api.User;

import lombok.*;

/**
 * Created by yanyong on 2018/5/13.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SimpleUser implements User {

    private String id;

    private String username;

    private String name;

    private String type;


}
