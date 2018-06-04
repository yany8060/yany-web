package com.yany.authorization.api.simple;

import com.yany.authorization.api.Permission;
import com.yany.authorization.api.access.DataAccessConfig;
import lombok.*;

import java.util.Collections;
import java.util.Set;

/**
 * Created by yanyong on 2018/5/13.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimplePermission implements Permission {
    private String id;

    private Set<String> actions;

    private Set<DataAccessConfig> dataAccesses;


    @Override
    public Set<String> getActions() {
        return actions;
    }

    @Override
    public Set<DataAccessConfig> getDataAccesses() {
        if (dataAccesses == null) {
            dataAccesses = Collections.emptySet();
        }
        return dataAccesses;
    }
}
