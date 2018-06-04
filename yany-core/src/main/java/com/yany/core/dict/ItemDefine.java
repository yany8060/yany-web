package com.yany.core.dict;

import java.util.List;

/**
 * Created by yanyong on 2018/5/13.
 */
public interface ItemDefine {

    String getText();

    String getValue();

    String getComments();

    List<ItemDefine> getChildren();

}
