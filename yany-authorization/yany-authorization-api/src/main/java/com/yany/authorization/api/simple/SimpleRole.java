package com.yany.authorization.api.simple;

import com.yany.authorization.api.Role;
import lombok.*;

/**
 * Created by yanyong on 2018/5/13.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimpleRole implements Role {

    private String id;

    private String name;
}
