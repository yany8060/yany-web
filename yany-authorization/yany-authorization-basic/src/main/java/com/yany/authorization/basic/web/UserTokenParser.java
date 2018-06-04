package com.yany.authorization.basic.web;

import javax.servlet.http.HttpServletRequest;

/**
 * 令牌解析器，用于在接受到请求到时候，从请求中获取令牌
 * Created by yanyong on 2018/4/26.
 */
public interface UserTokenParser {

    ParsedToken parsToken(HttpServletRequest request);

    ParsedToken parsToken(String headerToken);
}
